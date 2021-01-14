/*    */ package com.haut.grm.controller;
/*    */ 
/*    */ import java.util.Locale;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ public class HomeController
/*    */ {
/*    */   @RequestMapping(value={"/"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String home(Locale locale, Model model)
/*    */   {
/* 23 */     return "redirect:page/index.html";
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/ies_403"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String deny(HttpServletRequest request) {
/* 28 */     return "redirect:/page/index.html#/ies_403";
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\HomeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */