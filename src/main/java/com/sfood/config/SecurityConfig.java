//package com.sfood.config;
//
//import com.sfood.service.CustomOAuth2UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/", "/login").permitAll() // Trang không yêu cầu đăng nhập
//                        .anyRequest().authenticated() // Các trang còn lại yêu cầu xác thực
//                )
//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/login") // URL trang đăng nhập
//                        .defaultSuccessUrl("/") // URL sau khi đăng nhập thành công
//                        .userInfoEndpoint(userInfo -> userInfo
//                                .userService(new CustomOAuth2UserService()))
//                );
//        return http.build();
//    }
//
//
//
//}