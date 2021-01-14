/*    */ package com.haut.grm.util;
/*    */ 
/*    */ import com.haut.grm.repository.base.BusinessDataRepository;
/*    */ import com.haut.grm.repository.business.StockChangeRepository;
/*    */ import com.haut.grm.repository.ies.ContractRepository;
/*    */ import com.haut.grm.repository.ies.GrainTrafficRepository;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ public class OfficialIdUtil
/*    */ {
/* 12 */   private static String YEAR = "%Y";
/*    */   
/* 14 */   private static String MONTH = "%M";
/*    */   
/* 16 */   private static String DAY = "%D";
/*    */   
/*    */   public static String generateContractOId(ContractRepository cRepo, String contractFormatter) {
/* 19 */     int number = 1;
/* 20 */     String oid = format(contractFormatter, number);
/* 21 */     while (cRepo.findByBusinessKey(oid) != null) {
/* 22 */       number++;
/* 23 */       oid = format(contractFormatter, number);
/*    */     }
/* 25 */     return oid;
/*    */   }
/*    */   
/*    */   public static String generateGrainTrafficOId(GrainTrafficRepository gtRepo, String grainTrafficFormatter) {
/* 29 */     int number = 1;
/* 30 */     String oid = format(grainTrafficFormatter, number);
/* 31 */     while (gtRepo.findByCode(oid) != null) {
/* 32 */       number++;
/* 33 */       oid = format(grainTrafficFormatter, number);
/*    */     }
/* 35 */     return oid;
/*    */   }
/*    */   
/*    */   public static String generateBusinessKey(BusinessDataRepository bdRepo, String formatter) {
/* 39 */     int number = 1;
/* 40 */     String bk = format(formatter, number);
/* 41 */     while (bdRepo.findByBusinessKey(bk) != null) {
/* 42 */       number++;
/* 43 */       bk = format(formatter, number);
/*    */     }
/* 45 */     return bk;
/*    */   }
/*    */   
/*    */   public static String generateStockChangeOId(BusinessDataRepository bdRepo, GrainTrafficRepository gtRepo, StockChangeRepository scRepo, String formatter) {
/* 49 */     int number = 1;
/* 50 */     String bk = format(formatter, number);
/* 51 */     while ((bdRepo.findByBusinessKey(bk) != null) || (scRepo.findByBusinessKey(bk) != null) || (gtRepo.findByCode(bk) != null)) {
/* 52 */       number++;
/* 53 */       bk = format(formatter, number);
/*    */     }
/* 55 */     return bk;
/*    */   }
/*    */   
/*    */   public static String generateStockChangeOId(BusinessDataRepository bdRepo, GrainTrafficRepository gtRepo, StockChangeRepository scRepo, String formatter, Date time) {
/* 59 */     int number = 1;
/* 60 */     String bk = format(formatter, number, time);
/* 61 */     while ((bdRepo.findByBusinessKey(bk) != null) || (scRepo.findByBusinessKey(bk) != null) || (gtRepo.findByCode(bk) != null)) {
/* 62 */       number++;
/* 63 */       bk = format(formatter, number, time);
/*    */     }
/* 65 */     return bk;
/*    */   }
/*    */   
/*    */   public static String format(String raw, int number) {
/* 69 */     Date nowDate = new Date();
/* 70 */     String result = raw.replaceAll(YEAR, String.format("%tY", new Object[] { nowDate }));
/* 71 */     result = result.replaceAll(MONTH, String.format("%tm", new Object[] { nowDate }));
/* 72 */     result = result.replaceAll(DAY, String.format("%td", new Object[] { nowDate }));
/* 73 */     result = String.format(result, new Object[] { Integer.valueOf(number) });
/* 74 */     return result;
/*    */   }
/*    */   
/*    */   public static String format(String raw, int number, Date nowDate) {
/* 78 */     String result = raw.replaceAll(YEAR, String.format("%tY", new Object[] { nowDate }));
/* 79 */     result = result.replaceAll(MONTH, String.format("%tm", new Object[] { nowDate }));
/* 80 */     result = result.replaceAll(DAY, String.format("%td", new Object[] { nowDate }));
/* 81 */     result = String.format(result, new Object[] { Integer.valueOf(number) });
/* 82 */     return result;
/*    */   }
/*    */   
/*    */   public static String generateBusinessKey(BusinessDataRepository bdRepo, String formatter, Date time) {
/* 86 */     int number = 1;
/* 87 */     String bk = format(formatter, number, time);
/* 88 */     while (bdRepo.findByBusinessKey(bk) != null) {
/* 89 */       number++;
/* 90 */       bk = format(formatter, number, time);
/*    */     }
/* 92 */     return bk;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\OfficialIdUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */