///*    */ package com.haut.grm.bean;
///*    */ 
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
///*    */ import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import java.util.Base64;
//import org.apache.commons.collections.MapUtils;
///*    */ import javax.servlet.ServletException;
///*    */ import javax.servlet.http.HttpServletRequest;
///*    */ import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.codec.binary.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
///*    */ import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
//import org.springframework.security.oauth2.provider.ClientDetails;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.OAuth2Request;
//import org.springframework.security.oauth2.provider.TokenRequest;
//import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
///*    */ import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
///*    */ import org.springframework.stereotype.Component;
//
//import com.haut.grm.model.meta.MyUserDetails;
//import com.haut.grm.model.meta.Role;
//import com.haut.grm.model.meta.User;
///*    */ 
///*    */ 
///*    */ 
///*    */ @Component("customAuthenticationSuccessHandler")
///*    */ public class AuthenticationSuccessHandler
///*    */   extends SimpleUrlAuthenticationSuccessHandler
///*    */ {
//	
////	@Autowired
////    private AuthorizationServerTokenServices authorizationServerTokenServices;
//	
////	@Autowired
////    private ClientDetailsService clientDetailsService;
//	
//	@Autowired
//    private ObjectMapper objectMapper;  //将对象转换为Json的工具类，SpringMVC在启动的时候会自动为我们注册ObjectMapper
//
//	
///*    */   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
///*    */     throws IOException, ServletException
///*    */   {
//
///* 20 */     response.setStatus(200);
//
////MyUserDetails u=(MyUserDetails)authentication.getPrincipal();
//////System.out.println(u);
////String token=JwtTokenUtils.myjwt.generateToken(u.getUser());
////
////response.getWriter().write(objectMapper.writeValueAsString(token));
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
///*    */   }
//
//
//
//
//private String[] extractAndDecodeHeader(String header, HttpServletRequest request) throws IOException {
//    byte[] base64Token = header.substring(6).getBytes("UTF-8");
//
//    byte[] decoded;
//    try {
//        decoded = Base64.getDecoder().decode(base64Token);
//    } catch (IllegalArgumentException var7) {
//        throw new BadCredentialsException("Failed to decode basic authentication token");
//    }
//
//    String token = new String(decoded, "UTF-8");
//    int delim = token.indexOf(":");
//    if (delim == -1) {
//        throw new BadCredentialsException("Invalid basic authentication token");
//    } else {
//        return new String[]{token.substring(0, delim), token.substring(delim + 1)};
//    }
//}
//
//	
//
//
//
//
///*    */ }
//
//
//
//
//
//
//
//
//
///* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\bean\AuthenticationSuccessHandler.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       0.7.1
// */