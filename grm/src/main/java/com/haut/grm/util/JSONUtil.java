/*    */ package com.haut.grm.util;
/*    */ 
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ 
/*    */ public class JSONUtil
/*    */ {
/*    */   public static String objectToJson(Object obj) throws com.fasterxml.jackson.core.JsonProcessingException
/*    */   {
/*  9 */     ObjectMapper mapper = new ObjectMapper();
/* 10 */     return mapper.writeValueAsString(obj);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\JSONUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */