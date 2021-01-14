/*     */ package com.haut.grm.shengju.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import org.springframework.data.rest.core.annotation.Description;
/*     */ 
/*     */ 
/*     */ public class SjDeviceCamera
/*     */ {
/*     */   @Description("系统编号")
/*     */   private String XTBM;
/*     */   @Description("企业代码")
/*     */   private String QYDM;
/*     */   @Description("设备编号")
/*     */   private String SBBH;
/*     */   @Description("设备名称")
/*     */   private String SBMC;
/*     */   @Description("设备类型编码")
/*  18 */   private String SBLXNM = "002";
/*     */   @Description("设备类型名称")
/*     */   private String SBLXMC;
/*     */   @Description("监控类别")
/*     */   private String JKLB;
/*     */   @Description("库区编码")
/*     */   private String KQBM;
/*     */   @Description("仓房号")
/*     */   private String CFH;
/*     */   @Description("设备厂家")
/*     */   private String SBCJ;
/*     */   @Description("视频平台IP")
/*     */   private String IP;
/*     */   @Description("视频平台端口")
/*     */   private String DK;
/*     */   @Description("用户名")
/*     */   private String YHM;
/*     */   @Description("密码")
/*     */   private String MM;
/*     */   @Description("是否删除")
/*  38 */   private Integer SFSC = Integer.valueOf(0);
/*     */   
/*     */   @JsonProperty("xtbm")
/*     */   public String getXTBM() {
/*  42 */     return this.XTBM;
/*     */   }
/*     */   
/*  45 */   public void setXTBM(String xTBM) { this.XTBM = xTBM; }
/*     */   
/*     */   @JsonProperty("qydm")
/*     */   public String getQYDM() {
/*  49 */     return this.QYDM;
/*     */   }
/*     */   
/*  52 */   public void setQYDM(String qYDM) { this.QYDM = qYDM; }
/*     */   
/*     */   @JsonProperty("sbbh")
/*     */   public String getSBBH() {
/*  56 */     return this.SBBH;
/*     */   }
/*     */   
/*  59 */   public void setSBBH(String sBBH) { this.SBBH = sBBH; }
/*     */   
/*     */   @JsonProperty("sbmc")
/*     */   public String getSBMC() {
/*  63 */     return this.SBMC;
/*     */   }
/*     */   
/*  66 */   public void setSBMC(String sBMC) { this.SBMC = sBMC; }
/*     */   
/*     */   @JsonProperty("sblxnm")
/*     */   public String getSBLXNM() {
/*  70 */     return this.SBLXNM;
/*     */   }
/*     */   
/*  73 */   public void setSBLXNM(String sBLXNM) { this.SBLXNM = sBLXNM; }
/*     */   
/*     */   @JsonProperty("sblxmc")
/*     */   public String getSBLXMC() {
/*  77 */     return this.SBLXMC;
/*     */   }
/*     */   
/*  80 */   public void setSBLXMC(String sBLXMC) { this.SBLXMC = sBLXMC; }
/*     */   
/*     */   @JsonProperty("jklb")
/*     */   public String getJKLB() {
/*  84 */     return this.JKLB;
/*     */   }
/*     */   
/*  87 */   public void setJKLB(String jKLB) { this.JKLB = jKLB; }
/*     */   
/*     */   @JsonProperty("kqbm")
/*     */   public String getKQBM() {
/*  91 */     return this.KQBM;
/*     */   }
/*     */   
/*  94 */   public void setKQBM(String kQBM) { this.KQBM = kQBM; }
/*     */   
/*     */   @JsonProperty("cfh")
/*     */   public String getCFH() {
/*  98 */     return this.CFH;
/*     */   }
/*     */   
/* 101 */   public void setCFH(String cFH) { this.CFH = cFH; }
/*     */   
/*     */   @JsonProperty("sbcj")
/*     */   public String getSBCJ() {
/* 105 */     return this.SBCJ;
/*     */   }
/*     */   
/* 108 */   public void setSBCJ(String sBCJ) { this.SBCJ = sBCJ; }
/*     */   
/*     */   @JsonProperty("ip")
/*     */   public String getIP() {
/* 112 */     return this.IP;
/*     */   }
/*     */   
/* 115 */   public void setIP(String iP) { this.IP = iP; }
/*     */   
/*     */   @JsonProperty("dk")
/*     */   public String getDK() {
/* 119 */     return this.DK;
/*     */   }
/*     */   
/* 122 */   public void setDK(String dK) { this.DK = dK; }
/*     */   
/*     */   @JsonProperty("yhm")
/*     */   public String getYHM() {
/* 126 */     return this.YHM;
/*     */   }
/*     */   
/* 129 */   public void setYHM(String yHM) { this.YHM = yHM; }
/*     */   
/*     */   @JsonProperty("mm")
/*     */   public String getMM() {
/* 133 */     return this.MM;
/*     */   }
/*     */   
/* 136 */   public void setMM(String mM) { this.MM = mM; }
/*     */   
/*     */   @JsonProperty("sfsc")
/*     */   public Integer getSFSC() {
/* 140 */     return this.SFSC;
/*     */   }
/*     */   
/* 143 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjDeviceCamera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */