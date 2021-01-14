/*    */ package com.haut.grm.util;
/*    */ 
/*    */ import com.haut.grm.model.ies.GrainTraffic;
/*    */ import com.haut.grm.model.ies.VehicleTraffic;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class TemplateUtil
/*    */ {
/* 10 */   private static String TIME = "\\{time\\}";
/*    */   
/* 12 */   private static String CODE = "\\{code\\}";
/*    */   
/* 14 */   private static String PLATE = "\\{plate\\}";
/*    */   
/*    */   public static String generateAnalysisSms(String template, GrainTraffic gt) {
/* 17 */     String result = formatTime(template, new Date());
/* 18 */     result = format(result, CODE, gt.getCode());
/* 19 */     result = format(result, PLATE, gt.getRegisterRecord().getVehicleTraffic().getPlate());
/* 20 */     return result;
/*    */   }
/*    */   
/*    */   public static String formatTime(String raw, Date time) {
/* 24 */     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年M月d日 HH时mm分");
/* 25 */     String result = raw.replaceAll(TIME, dateFormat.format(new Date()));
/* 26 */     return result;
/*    */   }
/*    */   
/*    */   public static String format(String raw, String template, String candidate) {
/* 30 */     return raw.replaceAll(template, candidate);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\TemplateUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */