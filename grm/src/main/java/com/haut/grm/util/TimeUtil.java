/*    */ package com.haut.grm.util;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class TimeUtil
/*    */ {
/*    */   public static boolean nowBetween(String initialTime, String finalTime)
/*    */   {
/*    */     try
/*    */     {
/* 12 */       boolean valid = false;
/*    */       
/* 14 */       Date startTime = new java.text.SimpleDateFormat("HH:mm").parse(initialTime);
/* 15 */       Calendar startCalendar = Calendar.getInstance();
/* 16 */       startCalendar.setTime(startTime);
/*    */       
/*    */ 
/* 19 */       Date currentTime = new java.text.SimpleDateFormat("HH:mm").parse(new java.text.SimpleDateFormat("HH:mm").format(new Date()));
/* 20 */       Calendar currentCalendar = Calendar.getInstance();
/* 21 */       currentCalendar.setTime(currentTime);
/*    */       
/*    */ 
/* 24 */       Date endTime = new java.text.SimpleDateFormat("HH:mm").parse(finalTime);
/* 25 */       Calendar endCalendar = Calendar.getInstance();
/* 26 */       endCalendar.setTime(endTime);
/*    */       
/* 28 */       if (currentTime.compareTo(endTime) < 0) {
/* 29 */         currentCalendar.add(5, 1);
/* 30 */         currentTime = currentCalendar.getTime();
/*    */       }
/*    */       
/*    */ 
/* 34 */       if (startTime.compareTo(endTime) < 0) {
/* 35 */         startCalendar.add(5, 1);
/* 36 */         startTime = startCalendar.getTime();
/*    */       }
/*    */       
/* 39 */       if (currentTime.before(startTime)) {
/* 40 */         valid = false;
/*    */       } else {
/* 42 */         if (currentTime.after(endTime)) {
/* 43 */           endCalendar.add(5, 1);
/* 44 */           endTime = endCalendar.getTime();
/*    */         }
/*    */         
/* 47 */         if (currentTime.before(endTime))
/* 48 */           valid = true;
/*    */       }
/* 50 */       return false;
/*    */     }
/*    */     catch (java.text.ParseException e) {}
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 57 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\TimeUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */