package com.sfood.controller.web;

import com.sfood.dto.AccountDTO;
import com.sfood.dto.CustomerDTO;
import com.sfood.entity.account.AccountEntity;
import com.sfood.entity.actor.CustomerEntity;
import com.sfood.mapper.impl.AccountMapper;
import com.sfood.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private MessageSource messageSource;
    @GetMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("account", new AccountDTO());
        model.addAttribute("customer", new CustomerDTO());
        return "web/register";
    }

    @PostMapping
    public String registerAccount(@ModelAttribute("account") AccountDTO accountDTO,
                                  @ModelAttribute("customer") CustomerDTO customerDTO,
                                  Model model, Locale locale) {
        boolean usernameExists = accountService.isUsernameTaken(accountDTO.getUsername());
        boolean emailExists = accountService.isEmailTaken(customerDTO.getEmail());
        boolean phoneExists = accountService.isPhoneTaken(customerDTO.getPhone());

        if (usernameExists) {
            String message = messageSource.getMessage("username_exists", null, locale);
            model.addAttribute("error", message);
            return "web/register";
        }

        if (emailExists) {
            String message = messageSource.getMessage("email_exists", null, locale);
            model.addAttribute("error", message);
            return "web/register";
        }

        if (phoneExists) {
            String message = messageSource.getMessage("phone_exists", null, locale);
            model.addAttribute("error", message);
            return "web/register";
        }

        accountService.registerAccount(accountDTO, customerDTO);

        String message = messageSource.getMessage("registration_success", null, locale);
        model.addAttribute("success", message);
        return "web/register";
    }
}
