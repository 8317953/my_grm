/*     */ package com.haut.grm.shengju.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/*     */ import com.haut.grm.shengju.util.SjNumberSerializer;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.springframework.data.rest.core.annotation.Description;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SjTemperature
/*     */ {
/*     */   @Description("系统编号")
/*     */   String XTBM;
/*     */   @Description("填报单位代码")
/*     */   String TBDWDM;
/*     */   @Description("检测时间")
/*     */   Date JCSJ;
/*     */   @Description("企业代码")
/*     */   String QYDM;
/*     */   @Description("库区编码")
/*     */   String KQBM;
/*     */   @Description("仓房号")
/*     */   String CFH;
/*     */   @Description("仓外气温")
/*     */   BigDecimal CWQW;
/*     */   @Description("仓内气温")
/*     */   BigDecimal CNQW;
/*     */   @Description("仓外湿度")
/*     */   BigDecimal CWSD;
/*     */   @Description("仓内湿度")
/*     */   BigDecimal CNSD;
/*     */   @Description("粮堆最高温度")
/*     */   BigDecimal LDZGWD;
/*     */   @Description("粮堆最低温度")
/*     */   BigDecimal LDZDWD;
/*     */   @Description("粮堆平均温度")
/*     */   BigDecimal LDPJWD;
/*     */   @Description("测温点")
/*     */   List<SjTemperaturePoint> points;
/*     */   @Description("是否删除")
/*  44 */   Integer SFSC = Integer.valueOf(0);
/*     */   
/*     */   @JsonProperty("xtbm")
/*     */   public String getXTBM() {
/*  48 */     return this.XTBM;
/*     */   }
/*     */   
/*  51 */   public void setXTBM(String xTBM) { this.XTBM = xTBM; }
/*     */   
/*     */   @JsonProperty("tbdwdm")
/*     */   public String getTBDWDM() {
/*  55 */     return this.TBDWDM;
/*     */   }
/*     */   
/*  58 */   public void setTBDWDM(String tBDWDM) { this.TBDWDM = tBDWDM; }
/*     */   
/*     */   @JsonProperty("jcsj")
/*     */   public Date getJCSJ() {
/*  62 */     return this.JCSJ;
/*     */   }
/*     */   
/*  65 */   public void setJCSJ(Date jCSJ) { this.JCSJ = jCSJ; }
/*     */   
/*     */   @JsonProperty("qydm")
/*     */   public String getQYDM() {
/*  69 */     return this.QYDM;
/*     */   }
/*     */   
/*  72 */   public void setQYDM(String qYDM) { this.QYDM = qYDM; }
/*     */   
/*     */   @JsonProperty("kqbm")
/*     */   public String getKQBM() {
/*  76 */     return this.KQBM;
/*     */   }
/*     */   
/*  79 */   public void setKQBM(String kQBM) { this.KQBM = kQBM; }
/*     */   
/*     */   @JsonProperty("cfh")
/*     */   public String getCFH() {
/*  83 */     return this.CFH;
/*     */   }
/*     */   
/*  86 */   public void setCFH(String cFH) { this.CFH = cFH; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("cwqw")
/*     */   public BigDecimal getCWQW() {
/*  91 */     return this.CWQW;
/*     */   }
/*     */   
/*  94 */   public void setCWQW(BigDecimal cWQW) { this.CWQW = cWQW; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("cnqw")
/*     */   public BigDecimal getCNQW() {
/*  99 */     return this.CNQW;
/*     */   }
/*     */   
/* 102 */   public void setCNQW(BigDecimal cNQW) { this.CNQW = cNQW; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("cwsd")
/*     */   public BigDecimal getCWSD() {
/* 107 */     return this.CWSD;
/*     */   }
/*     */   
/* 110 */   public void setCWSD(BigDecimal cWSD) { this.CWSD = cWSD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("cnsd")
/*     */   public BigDecimal getCNSD() {
/* 115 */     return this.CNSD;
/*     */   }
/*     */   
/* 118 */   public void setCNSD(BigDecimal cNSD) { this.CNSD = cNSD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("ldzgwd")
/*     */   public BigDecimal getLDZGWD() {
/* 123 */     return this.LDZGWD;
/*     */   }
/*     */   
/* 126 */   public void setLDZGWD(BigDecimal lDZGWD) { this.LDZGWD = lDZGWD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("ldzdwd")
/*     */   public BigDecimal getLDZDWD() {
/* 131 */     return this.LDZDWD;
/*     */   }
/*     */   
/* 134 */   public void setLDZDWD(BigDecimal lDZDWD) { this.LDZDWD = lDZDWD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("ldpjwd")
/*     */   public BigDecimal getLDPJWD() {
/* 139 */     return this.LDPJWD;
/*     */   }
/*     */   
/* 142 */   public void setLDPJWD(BigDecimal lDPJWD) { this.LDPJWD = lDPJWD; }
/*     */   
/*     */   @JsonProperty("sfsc")
/*     */   public Integer getSFSC() {
/* 146 */     return this.SFSC;
/*     */   }
/*     */   
/* 149 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*     */   
/*     */   @JsonProperty("lqjcccjkcwd")
/*     */   public List<SjTemperaturePoint> getPoints() {
/* 153 */     return this.points;
/*     */   }
/*     */   
/* 156 */   public void setPoints(List<SjTemperaturePoint> points) { this.points = points; }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjTemperature.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */