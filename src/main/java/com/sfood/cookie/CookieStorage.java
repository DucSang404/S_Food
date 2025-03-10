package com.sfood.cookie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfood.dto.CartDTO;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class CookieStorage {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static CartDTO getCartFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("cart".equals(cookie.getName())) {
                    try {
                        String decodedValue = java.net.URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
                        return objectMapper.readValue(decodedValue, CartDTO.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("No cookies found in request.");
        }
        return new CartDTO();
    }


    public static void writeCartToCookie(CartDTO cartDTO, HttpServletResponse response) {
        try {
            String cartJson = objectMapper.writeValueAsString(cartDTO);
            String encodedValue = URLEncoder.encode(cartJson, StandardCharsets.UTF_8);

            Cookie cookie = new Cookie("cart", encodedValue);
            cookie.setPath("/");
            cookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookie);

            System.out.println("Cookie set: " + cookie.getName() + " = " + cookie.getValue());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearCartCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("cart", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}
