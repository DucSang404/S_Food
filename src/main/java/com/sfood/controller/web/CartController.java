package com.sfood.controller.web;

import com.sfood.dto.CartDTO;
import com.sfood.dto.CartItemDTO;
import com.sfood.dto.CustomerDTO;
import com.sfood.dto.FoodDTO;
import com.sfood.service.impl.FoodService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    private FoodService foodService;

    @ModelAttribute("user")
    public CustomerDTO getUserFromSession(HttpSession session) {
        return (CustomerDTO) session.getAttribute("user");
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        CartDTO cart = (CartDTO) session.getAttribute("cart");
        if(cart == null) {
            cart = new CartDTO();
            session.setAttribute("cart", cart);
        }
        model.addAttribute("cart", cart.getItems());
        return "web/cart";
    }

    @PostMapping("/cart/add")
    public ResponseEntity<?> addToCart(@RequestParam("foodId") Long foodId,
                                    @RequestParam("quantity") Long quantity,
                                    HttpSession session) {
        FoodDTO foodDTO = foodService.findFoodById(foodId);
        if(foodDTO == null) {
            return ResponseEntity.badRequest().body("{\"status\":\"error\", \"message\":\"Food not found\"}");
        }

        CartDTO cartDTO = (CartDTO) session.getAttribute("cart");
        if(cartDTO == null) {
            cartDTO = new CartDTO();
        }

        cartDTO.addItem(new CartItemDTO(null, foodDTO, quantity));
        session.setAttribute("cart", cartDTO);
        return ResponseEntity.ok("{\"status\":\"success\"}");

    }

    @PostMapping("/cart/remove")
    public ResponseEntity<?> removeFromCart(@RequestParam("foodId") Long foodId, HttpSession session) {
        CartDTO cartDTO = (CartDTO) session.getAttribute("cart");
        if(cartDTO != null) {
            cartDTO.getItems().removeIf(item -> item.getFood().getId().equals(foodId));
        }
        return ResponseEntity.ok("{\"status\":\"success\"}");
    }

    @GetMapping("/cart/count")
    public ResponseEntity<Map<String, Long>> getCartCount(HttpSession session) {
        CartDTO cartDTO = (CartDTO) session.getAttribute("cart");
        Long count = (cartDTO != null) ? cartDTO.getTotalItem() : 0;
        return ResponseEntity.ok(Collections.singletonMap("count", count));
    }

}
