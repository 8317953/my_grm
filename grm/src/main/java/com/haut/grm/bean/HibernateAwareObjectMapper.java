/*    */ package com.haut.grm.bean;
/*    */ 
/*    */ import com.fasterxml.jackson.databind.DeserializationFeature;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HibernateAwareObjectMapper
/*    */   extends ObjectMapper
/*    */ {
/*    */   private static final long serialVersionUID = -3579451200262055259L;
/*    */   
/*    */   public HibernateAwareObjectMapper()
/*    */   {
/* 16 */     configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
/* 17 */     registerModule(new Hibernate5Module());
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\bean\HibernateAwareObjectMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */