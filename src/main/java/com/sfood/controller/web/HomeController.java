package com.sfood.controller.web;

import com.nimbusds.jose.JOSEException;
import com.sfood.dto.AccountDTO;
import com.sfood.dto.CustomerDTO;
import com.sfood.entity.account.AccountEntity;
import com.sfood.mapper.impl.CustomerMapper;
import com.sfood.repository.AccountRepository;
import com.sfood.repository.CustomerRepository;
import com.sfood.service.impl.AccountService;
import com.sfood.service.impl.CustomUserDetailsService;
import com.sfood.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @GetMapping("/home")
    public String homePage(Model model, HttpServletRequest request,
                           HttpSession session) throws JOSEException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            String username = authentication.getName();
            if(!Objects.equals(username, "anonymousUser")) {
                CustomerDTO customerDTO = accountService.findCustomerByUserName(username);
                String token = customUserDetailsService.generateToken(username);
                model.addAttribute("user", customerDTO);
                request.getSession().setAttribute("token", token);
                session.setAttribute("user", customerDTO);
            }
        }
        return "web/home";
    }
}
