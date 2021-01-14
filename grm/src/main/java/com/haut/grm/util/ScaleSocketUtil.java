/*     */ package com.haut.grm.util;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketTimeoutException;
/*     */ 
/*     */ public class ScaleSocketUtil
/*     */ {
/*  13 */   private static int weight = -1;
/*     */   private static ServerSocket welcomeSocket;
/*     */   private static Socket connectionSocket;
/*     */   private static BufferedReader inFromClient;
/*     */   private static Integer port;
/*     */   
/*     */   public static void init(String sport) throws java.net.UnknownHostException, IOException, InterruptedException {
/*  20 */     port = Integer.valueOf(sport);
/*  21 */     if ((welcomeSocket != null) && (!welcomeSocket.isClosed()))
/*  22 */       welcomeSocket.close();
			System.out.println(port.intValue());
/*  23 */     welcomeSocket = new ServerSocket(port.intValue());
/*  24 */     welcomeSocket.setSoTimeout(10000);
/*  25 */     reinit();
/*     */   }
/*     */   
/*     */   public static void reinit() throws InterruptedException, IOException {
/*     */     try {
/*  30 */       if ((connectionSocket != null) && (!connectionSocket.isClosed()))
/*  31 */         connectionSocket.close();
/*  32 */       connectionSocket = welcomeSocket.accept();
/*  33 */       connectionSocket.setSoTimeout(2000);
/*  34 */       System.out.println("地磅链接成功");
/*     */     } catch (IOException e2) {
/*  36 */       System.out.println("地磅链接失败，将在3秒后重试链接");
/*  37 */       e2.printStackTrace();
/*     */       try {
/*  39 */         Thread.sleep(3000L);
/*  40 */         if ((connectionSocket != null) && (!connectionSocket.isClosed()))
/*  41 */           connectionSocket.close();
/*  42 */         if ((welcomeSocket != null) && (!welcomeSocket.isClosed()))
/*  43 */           welcomeSocket.close();
/*  44 */         welcomeSocket = new ServerSocket(port.intValue());
/*  45 */         welcomeSocket.setSoTimeout(20000);
/*  46 */         reinit2();
/*     */       } catch (InterruptedException e) {
/*  48 */         System.out.println("地磅链接失败，地磅链接重试被终止");
/*  49 */         throw e;
/*     */       } catch (IOException e) {
/*  51 */         System.out.println("地磅端口链接异常，地磅链接重试被终止");
/*  52 */         throw e;
/*     */       }
/*  54 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reinit2() throws InterruptedException, IOException {
///*     */     try {
///*  60 */       connectionSocket = welcomeSocket.accept();
///*  61 */       connectionSocket.setSoTimeout(2000);
///*  62 */       System.out.println("地磅链接成功");
///*     */     } catch (IOException e2) {
///*  64 */       System.out.println("地磅链接失败，将不再重启");
///*  65 */       throw e2;
///*     */     }
/*     */   }
/*     */   
/*     */   public static synchronized int getWeight()
/*     */   {
/*     */     try {
/*  72 */       inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
/*  73 */       String weightRead = null;
/*     */       try {
/*  75 */         weightRead = inFromClient.readLine();
/*     */       }
/*     */       catch (SocketTimeoutException e) {
/*  78 */         inFromClient.close();
/*  79 */         System.out.println("地磅数量获取超时");
/*  80 */         weight = -1;
/*  81 */         return weight;
/*     */       }
/*  83 */       byte[] response = weightRead.getBytes();
/*  84 */       byte[] number = { response[3], response[4], response[5], response[6], response[7], response[8], response[9] };
/*  85 */       weight = Integer.valueOf(new String(number).trim()).intValue();
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/*  89 */       System.out.println("地磅获取数量失败，原因未知，尝试实时重启");
/*     */       try {
/*  91 */         if (inFromClient != null)
/*  92 */           inFromClient.close();
/*  93 */         if ((connectionSocket != null) && (!connectionSocket.isClosed()))
/*  94 */           connectionSocket.close();
/*  95 */         reinit();
/*     */       } catch (InterruptedException|IOException e1) {
/*  97 */         System.out.println("地磅获取数量失败");
/*     */       }
/*  99 */       weight = -1;
/*     */     }
/* 101 */     return weight;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\ScaleSocketUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */