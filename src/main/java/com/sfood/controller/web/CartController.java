package com.sfood.controller.web;

import com.sfood.dto.CartDTO;
import com.sfood.dto.CartItemDTO;
import com.sfood.dto.CustomerDTO;
import com.sfood.dto.FoodDTO;
import com.sfood.service.impl.CartService;
import com.sfood.service.impl.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

import static com.sfood.cookie.CookieStorage.getCartFromCookie;
import static com.sfood.cookie.CookieStorage.writeCartToCookie;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CartService cartService;
    @ModelAttribute("user")
    public CustomerDTO getUserFromSession(HttpSession session) {
        return (CustomerDTO) session.getAttribute("user");
    }

    @GetMapping
    public String viewCart(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) {
        CustomerDTO user = getUserFromSession(session);
        CartDTO cart = new CartDTO();
        Long totalItem = 0L;
        if(user != null) {
             cart = cartService.findCartByCustomerId(user.getId());
             if(cart == null) {
                 cart = new CartDTO();
                 cart = cartService.save(cart);
             }

             CartDTO cookieCart = getCartFromCookie(request);
             if(cookieCart != null && !cookieCart.getLstCartItem().isEmpty()) {
                 for(CartItemDTO item : cookieCart.getLstCartItem()) {
                     cartService.saveFoodInCart(item.getFood(), item.getQuantity(), cart.getId());
                 }
//                 clearCartCookie(response);
             }
            totalItem = cart.getTotalItem();
        }
        else {
            cart = getCartFromCookie(request);
            if(cart == null) {
                cart = new CartDTO();
            }
            totalItem = cart.getTotalItem();
        }

        model.addAttribute("totalItem", totalItem);
        model.addAttribute("cart", cart.getLstCartItem());
        model.addAttribute("cartId", cart.getId());
        return "web/cart";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToCart( @RequestParam("foodId") Long foodId,
                                        @RequestParam("quantity") Long quantity,
                                        HttpServletRequest request,
                                        HttpServletResponse response,
                                        HttpSession session) {
        CustomerDTO user = getUserFromSession(session);
        FoodDTO food = foodService.findFoodById(foodId);
        if(food == null) {
            return ResponseEntity.badRequest().body("{\"status\":\"error\", \"message\":\"Food not found\"}");
        }

        CartDTO cart;
        if(user != null) {
            cart = cartService.findCartByCustomerId(user.getId());
            if(cart == null) {
                cart = new CartDTO();
                cart = cartService.save(cart);
            }

            CartDTO cookieCart = getCartFromCookie(request);
            if(cookieCart != null && !cookieCart.getLstCartItem().isEmpty()) {
                for(CartItemDTO item : cookieCart.getLstCartItem()) {
                    cartService.saveFoodInCart(item.getFood(), item.getQuantity(), cart.getId());
                }
//                clearCartCookie(response);
            }
            CartItemDTO cartItem = cartService.saveFoodInCart(food, quantity, cart.getId());
            cart.addItem(cartItem);
        }
        else {
            cart = getCartFromCookie(request);
            if(cart == null) {
                cart = new CartDTO();
            }
            CartItemDTO cartItem = new CartItemDTO(null, food, quantity);
            cart.addItem(cartItem);
            writeCartToCookie(cart, response);
        }

        return ResponseEntity.ok("{\"status\":\"success\"}");
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeFromCart(@RequestParam("foodId") Long foodId,
                                            HttpServletRequest request,
                                            HttpServletResponse response,
                                            HttpSession session) {
        CustomerDTO user = getUserFromSession(session);
        CartDTO cart;
        if(user != null) {
            cart = cartService.findCartByCustomerId(user.getId());
            if(cart != null) {
                cartService.removeFoodFromCart(foodId, cart.getId());
            }
        }
        else {
            cart = getCartFromCookie(request);
            if(cart != null) {
                cart.getLstCartItem().removeIf(item -> item.getFood().getId().equals(foodId));
                writeCartToCookie(cart, response);
            }
        }
        return ResponseEntity.ok("{\"status\":\"success\"}");
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getCartCount(HttpServletRequest request,
                                                          HttpServletResponse response,
                                                          HttpSession session) {
        CustomerDTO user = getUserFromSession(session);
        CartDTO cart;
        Long count = 0L;

        if(user != null) {
            cart = cartService.findCartByCustomerId(user.getId());
            count = (cart != null) ? cart.getLstCartItem().size() : 0L;
        }
        else {
            cart = getCartFromCookie(request);
            count = (cart != null) ? cart.getLstCartItem().size() : 0L;
        }

        return ResponseEntity.ok(Collections.singletonMap("count", count));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCart(@RequestParam("foodId") Long foodId,
                                        @RequestParam("quantity") Long quantity,
                                        HttpServletRequest request,
                                        HttpServletResponse response,
                                        HttpSession session) {
        CustomerDTO user = getUserFromSession(session);
        CartDTO cart;

        if (user != null) {
            cart = cartService.findCartByCustomerId(user.getId());
            if (cart != null) {
                cartService.updateFoodInCart(foodId, quantity, cart.getId());
            }
        } else {
            cart = getCartFromCookie(request);
            if (cart != null) {
                for (CartItemDTO item : cart.getLstCartItem()) {
                    if (item.getFood().getId().equals(foodId)) {
                        item.setQuantity(quantity);
                        break;
                    }
                }
                writeCartToCookie(cart, response);
            }
        }
        return ResponseEntity.ok("{\"status\":\"success\"}");
    }

}
