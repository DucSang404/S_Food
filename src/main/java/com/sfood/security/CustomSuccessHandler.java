package com.sfood.security;

import com.sfood.util.JwtUtils;
import com.sfood.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private JwtUtils jwtUtils;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication); // redirect after successful login
        if (response.isCommitted()) {
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//            throws IOException {
//        // Lấy thông tin người dùng đã xác thực
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        String username = userDetails.getUsername();
//        List<String> roles = SecurityUtils.getAuthorities();
//
//        // Tạo JWT token
//        String token = jwtUtils.generateToken(username, roles);
//        System.out.println("Token: " + token);
//        // Trả token về client
//        Map<String, String> tokenResponse = new HashMap<>();
//        tokenResponse.put("token", token);
//        tokenResponse.put("username", username);
//        tokenResponse.put("role", roles.toString());
//
//        response.setContentType("application/json");
//        response.getWriter().write(tokenResponse.toString());
//        response.getWriter().flush();
//
//        String targetUrl = determineTargetUrl(authentication); // redirect after successful login
//        if (response.isCommitted()) {
//            return;
//        }
//        redirectStrategy.sendRedirect(request, response, targetUrl);
//    }
    private String determineTargetUrl(Authentication authentication) {
        String url = "";
        List<String> roles = SecurityUtils.getAuthorities();
        if(roles.contains("OWNER")) {
            url = "/admin";
        }
        else if(roles.contains("CUSTOMER")) {
            url = "/home";
        }
        return url;
    }

}
