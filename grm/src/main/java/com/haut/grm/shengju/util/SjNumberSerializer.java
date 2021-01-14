/*    */ package com.haut.grm.shengju.util;
/*    */ 
/*    */ import com.fasterxml.jackson.core.JsonGenerator;
/*    */ import com.fasterxml.jackson.databind.JsonSerializer;
/*    */ import com.fasterxml.jackson.databind.SerializerProvider;
/*    */ import java.io.IOException;
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ public class SjNumberSerializer
/*    */   extends JsonSerializer<BigDecimal>
/*    */ {
/*    */   public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException
/*    */   {
/* 14 */     gen.writeNumber(value.setScale(2, 4).toString());
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengj\\util\SjNumberSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */