/*     */ package com.haut.grm.shengju.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import com.fasterxml.jackson.annotation.JsonFormat.Shape;
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/*     */ import com.haut.grm.shengju.util.SjNumberSerializer;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import org.springframework.data.rest.core.annotation.Description;
/*     */ 
/*     */ 
/*     */ public class SjGrainRotate
/*     */ {
/*     */   @Description("申请编号")
/*     */   private String SQBH;
/*     */   @Description("申请日期")
/*     */   private Date SQRQ;
/*     */   @Description("申请单位编码")
/*     */   private String SQDWBM;
/*     */   @Description("申请轮换年份")
/*     */   private String SQLHNF;
/*     */   @Description("业务类型")
/*     */   private String YWLX;
/*     */   @Description("品种编码")
/*     */   private String PZBM;
/*     */   @Description("品质状态")
/*     */   private String PZZT;
/*     */   @Description("生产年份")
/*     */   private String SCNF;
/*     */   @Description("储存年限")
/*     */   private Integer CCNX;
/*     */   @Description("计划轮换量")
/*     */   private BigDecimal JHLHL;
/*     */   @Description("录入时间")
/*     */   private Date LRSJ;
/*     */   @Description("是否删除")
/*  38 */   private Integer SFSC = Integer.valueOf(0);
/*     */   
/*     */   @JsonProperty("sqbh")
/*     */   public String getSQBH() {
/*  42 */     return this.SQBH;
/*     */   }
/*     */   
/*  45 */   public void setSQBH(String sQBH) { this.SQBH = sQBH; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("sqrq")
/*     */   public Date getSQRQ() {
/*  50 */     return this.SQRQ;
/*     */   }
/*     */   
/*  53 */   public void setSQRQ(Date sQRQ) { this.SQRQ = sQRQ; }
/*     */   
/*     */   @JsonProperty("sqdwbm")
/*     */   public String getSQDWBM() {
/*  57 */     return this.SQDWBM;
/*     */   }
/*     */   
/*  60 */   public void setSQDWBM(String sQDWBM) { this.SQDWBM = sQDWBM; }
/*     */   
/*     */   @JsonProperty("sqlhnf")
/*     */   public String getSQLHNF() {
/*  64 */     return this.SQLHNF;
/*     */   }
/*     */   
/*  67 */   public void setSQLHNF(String sQLHNF) { this.SQLHNF = sQLHNF; }
/*     */   
/*     */   @JsonProperty("ywlx")
/*     */   public String getYWLX() {
/*  71 */     return this.YWLX;
/*     */   }
/*     */   
/*  74 */   public void setYWLX(String yWLX) { this.YWLX = yWLX; }
/*     */   
/*     */   @JsonProperty("pzbm")
/*     */   public String getPZBM() {
/*  78 */     return this.PZBM;
/*     */   }
/*     */   
/*  81 */   public void setPZBM(String pZBM) { this.PZBM = pZBM; }
/*     */   
/*     */   @JsonProperty("pzzt")
/*     */   public String getPZZT() {
/*  85 */     return this.PZZT;
/*     */   }
/*     */   
/*  88 */   public void setPZZT(String pZZT) { this.PZZT = pZZT; }
/*     */   
/*     */   @JsonProperty("scnf")
/*     */   public String getSCNF() {
/*  92 */     return this.SCNF;
/*     */   }
/*     */   
/*  95 */   public void setSCNF(String sCNF) { this.SCNF = sCNF; }
/*     */   
/*     */   @JsonProperty("ccnx")
/*     */   public Integer getCCNX() {
/*  99 */     return this.CCNX;
/*     */   }
/*     */   
/* 102 */   public void setCCNX(Integer cCNX) { this.CCNX = cCNX; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("jhlhl")
/*     */   public BigDecimal getJHLHL() {
/* 107 */     return this.JHLHL;
/*     */   }
/*     */   
/* 110 */   public void setJHLHL(BigDecimal jHLHL) { this.JHLHL = jHLHL; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("lrsj")
/*     */   public Date getLRSJ() {
/* 115 */     return this.LRSJ;
/*     */   }
/*     */   
/* 118 */   public void setLRSJ(Date lRSJ) { this.LRSJ = lRSJ; }
/*     */   
/*     */   @JsonProperty("sfsc")
/*     */   public Integer getSFSC() {
/* 122 */     return this.SFSC;
/*     */   }
/*     */   
/* 125 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjGrainRotate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */