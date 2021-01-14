///*     */ package com.haut.grm.util;
///*     */ 
///*     */ import com.haut.grm.model.ies.Analysis;
///*     */ import com.haut.grm.model.ies.GrainTraffic;
///*     */ import com.haut.grm.model.ies.RegisterRecord;
///*     */ import com.haut.grm.model.ies.VehicleTraffic;
///*     */ import java.awt.Color;
///*     */ import java.awt.Font;
///*     */ import java.io.PrintStream;
///*     */ import java.text.DecimalFormat;
///*     */ import java.text.NumberFormat;
///*     */ import onbon.bx05.Bx5GEnv;
///*     */ import onbon.bx05.Bx5GScreenClient;
///*     */ import onbon.bx05.Bx5GScreenProfile;
///*     */ import onbon.bx05.area.TextCaptionBxArea;
///*     */ import onbon.bx05.area.page.TextBxPage;
///*     */ import onbon.bx05.cmd.dyn7.DynamicBxAreaRule;
///*     */ import onbon.bx05.utils.DisplayStyleFactory;
///*     */ import onbon.bx05.utils.TextBinary.Alignment;
///*     */ 
///*     */ 
///*     */ public class LEDUtil
///*     */ {
///*     */   private static Bx5GScreenClient screen;
///*     */   private static DynamicBxAreaRule dRule;
///*     */   private static TextCaptionBxArea tArea;
///*     */   private static String ip;
///*  28 */   private static int STAY_TIME = 3000;
///*     */   
///*  30 */   private static boolean inited = false;
///*     */   
///*     */   public static void sendLED(GrainTraffic gt) throws Exception {
///*  33 */     if (!inited) {
///*  34 */       initLED(ip);
///*     */     }
///*     */     
///*  37 */     if (!screen.connect(ip, 5005)) {
///*  38 */       System.out.println("LED链接失败");
///*  39 */       return;
///*     */     }
///*  41 */     screen.turnOn();
///*     */     
///*  43 */     TextBxPage page = new TextBxPage(new Font("宋体", 0, 14));
///*  44 */     page.setLineBreak(false);
///*  45 */     page.setForeground(Color.red);
///*  46 */     page.setHorizontalAlignment(TextBinary.Alignment.CENTER);
///*  47 */     page.setDisplayStyle(DisplayStyleFactory.getStyle(27));
///*  48 */     page.setStayTime(STAY_TIME);
///*  49 */     NumberFormat f = new DecimalFormat("#0.0#");
///*  50 */     page.newLine("  ");
///*  51 */     page.newLine("车辆 " + gt.getRegisterRecord().getVehicleTraffic().getPlate() + " 化验信息");
///*  52 */     page.newLine("  ");
///*  53 */     if (gt.getAnalysis().getA1l() != null)
///*  54 */       page.newLine("除水前水分: " + f.format(gt.getAnalysis().getA1l()) + "%");
///*  55 */     if (gt.getAnalysis().getA3l() != null)
///*  56 */       page.newLine("除杂前杂质: " + f.format(gt.getAnalysis().getA3l()) + "%");
///*  57 */     if (gt.getAnalysis().getA7() != null)
///*  58 */       page.newLine("黄粒米: " + f.format(gt.getAnalysis().getA7()) + "%");
///*  59 */     if (gt.getAnalysis().getA5() != null)
///*  60 */       page.newLine("出糙率: " + f.format(gt.getAnalysis().getA5()) + "%");
///*  61 */     if (gt.getAnalysis().getA6() != null)
///*  62 */       page.newLine("整精米率: " + f.format(gt.getAnalysis().getA6()) + "%");
///*  63 */     if (gt.getAnalysis().getA10() != null)
///*  64 */       page.newLine("不完善粒: " + f.format(gt.getAnalysis().getA10()) + "%");
///*  65 */     page.newLine("  ");
///*  66 */     String result = "化验结果: " + (gt.getAnalysis().getPass().booleanValue() ? "合格" : "不合格");
///*  67 */     if ((gt.getAnalysis().getAnalysisComment() != null) && (!gt.getAnalysis().getAnalysisComment().equals(""))) {
///*  68 */       result = result + " (" + gt.getAnalysis().getAnalysisComment() + ")";
///*     */     }
///*  70 */     page.newLine(result);
///*  71 */     page.newLine("承运人: " + gt.getRegisterRecord().getPersonnelName().trim());
///*  72 */     tArea.addPage(page);
///*  73 */     screen.writeDynamic(dRule, tArea);
///*  74 */     screen.disconnect();
///*     */   }
///*     */   
///*     */   public static void initLED(String ip) throws Exception
///*     */   {
///*  79 */     ip = ip;
///*  80 */     Bx5GEnv.initial("log.properties", 15000);
///*  81 */     screen = new Bx5GScreenClient("MyScreen");
///*     */     
///*  83 */     if (!screen.connect(ip, 5005)) {
///*  84 */       System.out.println("LED控制器 初始化链接失败");
///*  85 */       inited = false;
///*  86 */       throw new Exception("LED控制器 初始化链接失败");
///*     */     }
///*     */     
///*  89 */     dRule = new DynamicBxAreaRule(0, (byte)0, (byte)1, 0);
///*  90 */     tArea = new TextCaptionBxArea(0, 0, screen.getProfile().getWidth(), screen.getProfile().getHeight(), screen.getProfile());
///*  91 */     tArea.setFrameShow(true);
///*  92 */     tArea.setFrameStyle(7);
///*  93 */     tArea.loadFrameImage(4);
///*     */     
///*  95 */     TextBxPage page = new TextBxPage("广东顺德智能化粮库综合管理系统");
///*  96 */     page.setStayTime(200);
///*  97 */     page.setVerticalAlignment(TextBinary.Alignment.CENTER);
///*  98 */     page.setHorizontalAlignment(TextBinary.Alignment.CENTER);
///*  99 */     tArea.addPage(page);
///*     */     
///* 101 */     screen.syncTime();
///* 102 */     screen.deleteAllDynamic();
///* 103 */     screen.manualBrightness((byte)12);
///* 104 */     screen.writeDynamic(dRule, tArea);
///* 105 */     screen.disconnect();
///* 106 */     inited = true;
///*     */   }
///*     */   
///*     */   public static void refreshDynamic() throws Exception
///*     */   {
///* 111 */     if (!screen.connect(ip, 5005)) {
///* 112 */       System.out.println("LED 链接失败");
///* 113 */       inited = false;
///* 114 */       throw new Exception("LED控制器 刷新链接失败");
///*     */     }
///*     */     
///* 117 */     tArea.clearPages();
///* 118 */     TextBxPage page = new TextBxPage("广东顺德智能化粮库综合管理系统");
///* 119 */     page.setVerticalAlignment(TextBinary.Alignment.CENTER);
///* 120 */     page.setHorizontalAlignment(TextBinary.Alignment.CENTER);
///* 121 */     tArea.addPage(page);
///*     */     
///* 123 */     screen.writeDynamic(dRule, tArea);
///*     */     
///* 125 */     screen.disconnect();
///*     */   }
///*     */   
///*     */   public static void turnOn() throws Exception {
///* 129 */     if (!screen.connect(ip, 5005)) {
///* 130 */       System.out.println("LED控制器 初始化链接失败");
///* 131 */       inited = false;
///* 132 */       throw new Exception("LED控制器 初始化链接失败");
///*     */     }
///* 134 */     screen.turnOn();
///*     */   }
///*     */   
///*     */   public static void turnOff() throws Exception {
///* 138 */     if (!screen.connect(ip, 5005)) {
///* 139 */       System.out.println("LED控制器 初始化链接失败");
///* 140 */       inited = false;
///* 141 */       throw new Exception("LED控制器 初始化链接失败");
///*     */     }
///* 143 */     screen.turnOff();
///*     */   }
///*     */ }
//
//
///* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\LEDUtil.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       0.7.1
// */