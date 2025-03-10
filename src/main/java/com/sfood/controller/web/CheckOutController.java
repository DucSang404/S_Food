package com.sfood.controller.web;

import com.sfood.dto.BillDiscountDTO;
import com.sfood.dto.CartItemDTO;
import com.sfood.dto.CustomerDTO;
import com.sfood.dto.OrderInfoDTO;
import com.sfood.dto.other_dto.CheckOutItem;
import com.sfood.service.impl.BillDiscountService;
import com.sfood.service.impl.CartItemService;
import com.sfood.service.impl.CartService;
import com.sfood.service.impl.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/checkout")
public class CheckOutController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private BillDiscountService billDiscountService;

    @ModelAttribute("user")
    public CustomerDTO getUserFromSession(HttpSession session) {
        return (CustomerDTO) session.getAttribute("user");
    }

    @GetMapping
    public String viewCheckout(Model model, HttpSession session) {
        List<CartItemDTO> cartItemLst = (List<CartItemDTO>) session.getAttribute("cartItem");

        CustomerDTO user = getUserFromSession(session);
        List<OrderInfoDTO> orderInfoLst = orderInfoService.findOrderInfoByCustomerId(user.getId());

        List<BillDiscountDTO> billDiscountLst = billDiscountService.findAllValidBillDiscount();

        model.addAttribute("cartItem", cartItemLst);
        model.addAttribute("orderInfo", orderInfoLst);
        model.addAttribute("billDiscount", billDiscountLst);

        return "web/checkout";
    }

    @PostMapping(consumes = "application/json")
    public String getcheckOut(@RequestBody List<CheckOutItem> items,
                               Model model,
                              HttpSession session) {

        List<CartItemDTO> cartItemLst = new ArrayList<>();
        for(CheckOutItem item : items) {
            CartItemDTO cartItem = cartItemService.findByCartItem(item.getFoodId(), item.getCartId());
            cartItemLst.add(cartItem);
        }
        session.setAttribute("cartItem", cartItemLst);
        return "web/checkout";
    }
}
