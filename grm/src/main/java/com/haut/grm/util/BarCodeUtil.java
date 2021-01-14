/*    */ package com.haut.grm.util;
/*    */ 
/*    */ import com.haut.grm.repository.ies.AnalysisRepository;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Date;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.spec.IvParameterSpec;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ import org.apache.commons.codec.binary.Base64;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BarCodeUtil
/*    */ {
/*    */   private static final String KEY = "I'm coming toyla";
/*    */   private static final String CHARSET = "UTF-8";
/* 17 */   private static String IV = "whateverdudefuck";
/*    */   
/*    */   public static String encrypt(String plainText) throws Exception
/*    */   {
/* 21 */     Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
/* 22 */     SecretKeySpec key = new SecretKeySpec("I'm coming toyla".getBytes("UTF-8"), "AES");
/* 23 */     cipher.init(1, key, new IvParameterSpec(IV.getBytes("UTF-8")));
/* 24 */     return Base64.encodeBase64String(cipher.doFinal(plainText.getBytes("UTF-8")));
/*    */   }
/*    */   
/*    */   public static String decrypt(String cipherText) throws Exception
/*    */   {
/*    */     try {
/* 30 */       Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
/* 31 */       SecretKeySpec key = new SecretKeySpec("I'm coming toyla".getBytes("UTF-8"), "AES");
/* 32 */       cipher.init(2, key, new IvParameterSpec(IV.getBytes("UTF-8")));
/* 33 */       return new String(cipher.doFinal(Base64.decodeBase64(cipherText)), "UTF-8");
/*    */     }
/*    */     catch (Exception e) {
/* 36 */       System.out.println("二维码 解码错误"); }
/* 37 */     return null;
/*    */   }
/*    */   
/*    */   public static String getValidBarCodeRaw(AnalysisRepository aRepo)
/*    */   {
			//生成一个format code
/* 42 */     int number = 1;
/* 43 */     Date nowDate = new Date();
/* 44 */     String next = String.format("%tY%tm%td%03d", new Object[] { nowDate, nowDate, nowDate, Integer.valueOf(number) });
/* 45 */     while (aRepo.findByBarcode(next) != null) {
/* 46 */       number++;//查询有没有被占用 占用加1 再生成  在查询一直到没有被占用
/* 47 */       next = String.format("%tY%tm%td%03d", new Object[] { nowDate, nowDate, nowDate, Integer.valueOf(number) });
/*    */     }
/* 49 */     return next;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\BarCodeUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */