//package com.haut.grm.bean;
//
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//public class CustomSecurityFilter extends AbstractAuthenticationProcessingFilter {
//
//    private AuthenticationManager authenticationManager;
//
//
//    public CustomSecurityFilter(AuthenticationManager authenticationManager) {
//
//        super(new AntPathRequestMatcher("/login", "POST"));
//        this.authenticationManager = authenticationManager;
//
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
//        
//    }
//}