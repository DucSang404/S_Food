package com.sfood.controller.web;

import com.nimbusds.jose.JOSEException;
import com.sfood.dto.CartDTO;
import com.sfood.dto.CustomerDTO;
import com.sfood.service.impl.AccountService;
import com.sfood.service.impl.CartService;
import com.sfood.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

import static com.sfood.cookie.CookieStorage.clearCartCookie;
import static com.sfood.cookie.CookieStorage.getCartFromCookie;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private CartService cartService;
    @GetMapping("/home")
    public String homePage(Model model, HttpServletRequest request,
                           HttpServletResponse response,
                           HttpSession session) throws JOSEException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            String username = authentication.getName();
            if(!Objects.equals(username, "anonymousUser")) {
                CustomerDTO customerDTO = accountService.findCustomerByUserName(username);
                String token = customUserDetailsService.generateToken(username);
                model.addAttribute("user", customerDTO);

                CartDTO cartFromCookie = getCartFromCookie(request);
                CartDTO cartFromDB = cartService.findCartByCustomerId(customerDTO.getId());

                if(cartFromDB == null || cartFromDB.getLstCartItem().isEmpty()) {
                    cartService.saveCartForCustomer(customerDTO.getId(), cartFromCookie);
                }
                request.getSession().setAttribute("token", token);
                session.setAttribute("user", customerDTO);

                clearCartCookie(response);
            }
        }
        return "web/home";
    }
}
