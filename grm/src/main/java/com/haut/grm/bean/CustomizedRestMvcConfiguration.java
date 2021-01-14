/*    */ package com.haut.grm.bean;
/*    */ 
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.context.ApplicationContext;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.data.repository.support.Repositories;
/*    */ import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
/*    */ import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
/*    */ 
/*    */ @Configuration
/*    */ public class CustomizedRestMvcConfiguration extends RepositoryRestMvcConfiguration
/*    */ {
/*    */   @Autowired
/*    */   ApplicationContext context;
/*    */   
/*    */   public Repositories repositories()
/*    */   {
/* 19 */     return new ExportAwareRepositories(this.context);
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public HateoasPageableHandlerMethodArgumentResolver pageableResolver()
/*    */   {
/* 25 */     HateoasPageableHandlerMethodArgumentResolver resolver = super.pageableResolver();
/* 26 */     resolver.setMaxPageSize(99999);
/* 27 */     return resolver;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\bean\CustomizedRestMvcConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */