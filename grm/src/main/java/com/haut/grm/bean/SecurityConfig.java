//package com.haut.grm.bean;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
// 
//@Configuration
//class SecurityConfig extends WebSecurityConfigurerAdapter {
// 
////    private static final String[] AUTH_WHITELIST = {
//// 
////            // -- swagger ui
////            "/swagger-resources/**",
////            "/swagger-ui.html",
////            "/v2/api-docs",
////            "/webjars/**"
////    };
//    
//    
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//		
//		http
//        .authorizeRequests()
//            .antMatchers("/resources/**", "/signup", "/about").permitAll()
//            .antMatchers("/admin/**").hasRole("ADMIN")
//            .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//            .anyRequest().authenticated()
//            .and()
//        .formLogin()
//            .usernameParameter("username")
//            .passwordParameter("password")
//            .failureForwardUrl("/login?error")
//            .loginPage("/login")
//            .permitAll()
//            .and()
//        .logout()
//            .logoutUrl("/logout")
//            .logoutSuccessUrl("/index")
//            .permitAll()
//            .and()
//        .httpBasic()
//            .disable();
//		
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//           
//    }
//
//    
//    
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers(AUTH_WHITELIST).permitAll()
////                .antMatchers("/**/*").denyAll();
////    }
//}