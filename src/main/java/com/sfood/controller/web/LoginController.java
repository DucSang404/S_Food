package com.sfood.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

//    @GetMapping("/")
//    public String home(Model model, OAuth2AuthenticationToken authenticationToken) {
//        if(authenticationToken != null) {
//            model.addAttribute("user", authenticationToken.getPrincipal().getAttributes());
//        }
//        return "web/home";
//    }


}
