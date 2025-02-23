package com.sfood.controller.web;

import com.nimbusds.jose.JOSEException;
import com.sfood.config.SocialConfig;
import com.sfood.dto.CustomerDTO;
import com.sfood.dto.SocialAccountDTO;
import com.sfood.enums.EnumAccountStatus;
import com.sfood.service.impl.CustomUserDetailsService;
import com.sfood.service.impl.SocialAccountService;
import com.sfood.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private SocialAccountService socialAccountService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    @GetMapping("/login/facebook-login")
    public RedirectView redirectToFb() {
        String authUrl = SocialConfig.get("facebook.auth.url") +
                "?client_id=" + SocialConfig.get("facebook.app.id") +
                "&redirect_uri=" + SocialConfig.get("facebook.redirect.uri") +
                "&scope=email,public_profile";
        return new RedirectView(authUrl);
    }

    //Facebook
    @GetMapping("/login/facebook-callback")
    public String handleFacebookCallback(@RequestParam("code") String code,
                                         Model model, HttpServletRequest request,
                                         HttpSession session) throws IOException, JOSEException {

        String tokenUrl = SocialConfig.get("facebook.token.url") +
                "?client_id=" + SocialConfig.get("facebook.app.id") +
                "&redirect_uri=" + SocialConfig.get("facebook.redirect.uri") +
                "&client_secret=" + SocialConfig.get("facebook.app.secret") +
                "&code=" + code;
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> tokenResponse = restTemplate.getForObject(tokenUrl, Map.class);
        String accessToken = (String) tokenResponse.get("access_token");
        String userInfoUrl = SocialConfig.get("facebook.user.url") +
                "?fields=id,name,email&access_token=" + accessToken;

        Map<String, Object> userResponse = restTemplate.getForObject(userInfoUrl, Map.class);
        System.out.println("User Info: " + userResponse);

        String fbId = (String) userResponse.get("id");
        String name = (String) userResponse.get("name");
//        String email = (String) userResponse.get("email");
        SocialAccountDTO socialAccountDTO = new SocialAccountDTO(null, fbId, null, EnumAccountStatus.ACTIVE);
        CustomerDTO customerDTO = new CustomerDTO(null, name, null, null, null, null);
        socialAccountService.registerSocialAccount(socialAccountDTO, customerDTO);

        customerDTO = socialAccountService.findCustomerByFbId(fbId);

        Authentication authentication = jwtUtils.createAuthentication(customerDTO);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = customUserDetailsService.generateTokenSocial(fbId);
        request.getSession().setAttribute("token", token);

        session.setAttribute("user", customerDTO);
        model.addAttribute("user", customerDTO);
        return "web/home";
    }

    @GetMapping("/login/google-login")
    public RedirectView redirectToGoogle() {
        String authUrl = SocialConfig.get("google.auth.url") +
                "?client_id=" + SocialConfig.get("google.client.id") +
                "&redirect_uri=" + SocialConfig.get("google.redirect.uri") +
                "&response_type=code" + "&scope=openid%20profile%20email";
        return new RedirectView(authUrl);
    }

    //Google
    @GetMapping("/login/google-callback")
    public String handleGoogleCallback(@RequestParam("code") String code,
                                       Model model, HttpServletRequest request,
                                       HttpSession session) throws IOException, JOSEException {
        String tokenUrl = SocialConfig.get("google.token.url") +
                "?client_id=" + SocialConfig.get("google.client.id") +
                "&client_secret=" + SocialConfig.get("google.client.secret") +
                "&redirect_uri=" + SocialConfig.get("google.redirect.uri") +
                "&grant_type=authorization_code" +
                "&code=" + code;

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> tokenResponse = restTemplate.postForObject(tokenUrl, null, Map.class);
        String accessToken = (String) tokenResponse.get("access_token");
        String userInfoUrl = SocialConfig.get("google.user.info.url") +
                "?access_token=" + accessToken;

        Map<String, Object> userResponse = restTemplate.getForObject(userInfoUrl, Map.class);
        System.out.println(userResponse);
        String ggId = (String) userResponse.get("sub");
        String name = (String) userResponse.get("name");
        String email = (String) userResponse.get("email");

        SocialAccountDTO socialAccountDTO = new SocialAccountDTO(null, null, ggId, EnumAccountStatus.ACTIVE);
        CustomerDTO customerDTO = new CustomerDTO(null, name, email, null, null, null);
        socialAccountService.registerSocialAccount(socialAccountDTO, customerDTO);

        customerDTO = socialAccountService.findCustomerByGgId(ggId);

        Authentication authentication = jwtUtils.createAuthentication(customerDTO);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = customUserDetailsService.generateTokenSocial(ggId);
        request.getSession().setAttribute("token", token);

        model.addAttribute("user", customerDTO);
        session.setAttribute("user", customerDTO);

        return "web/home";
    }
}
