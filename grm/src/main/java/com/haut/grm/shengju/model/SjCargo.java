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
/*     */ public class SjCargo
/*     */ {
/*     */   @Description("企业代码")
/*     */   private String QYDM;
/*     */   @Description("库区编码")
/*     */   private String KQBM;
/*     */   @Description("仓房号")
/*     */   private String CFH;
/*     */   @Description("廒间编号")
/*     */   private String AJBH;
/*     */   @Description("货位编号")
/*     */   private String HWBH;
/*     */   @Description("货位名称")
/*     */   private String HWMC;
/*     */   @Description("储粮方式")
/*     */   private Integer CLFS;
/*     */   @Description("货位容量")
/*     */   private BigDecimal HWRL;
/*     */   @Description("货位状态")
/*     */   private Integer HWZT;
/*     */   @Description("货位启用日期")
/*     */   private Date HWQYRQ;
/*     */   @Description("货位备注")
/*     */   private String HWBZ;
/*     */   @Description("是否删除")
/*  38 */   private Integer SFSC = Integer.valueOf(0);
/*     */   
/*     */   @JsonProperty("qydm")
/*     */   public String getQYDM() {
/*  42 */     return this.QYDM;
/*     */   }
/*     */   
/*  45 */   public void setQYDM(String qYDM) { this.QYDM = qYDM; }
/*     */   
/*     */   @JsonProperty("kqbm")
/*     */   public String getKQBM() {
/*  49 */     return this.KQBM;
/*     */   }
/*     */   
/*  52 */   public void setKQBM(String kQBM) { this.KQBM = kQBM; }
/*     */   
/*     */   @JsonProperty("cfh")
/*     */   public String getCFH() {
/*  56 */     return this.CFH;
/*     */   }
/*     */   
/*  59 */   public void setCFH(String cFH) { this.CFH = cFH; }
/*     */   
/*     */   @JsonProperty("ajbh")
/*     */   public String getAJBH() {
/*  63 */     return this.AJBH;
/*     */   }
/*     */   
/*  66 */   public void setAJBH(String aJBH) { this.AJBH = aJBH; }
/*     */   
/*     */   @JsonProperty("hwbh")
/*     */   public String getHWBH() {
/*  70 */     return this.HWBH;
/*     */   }
/*     */   
/*  73 */   public void setHWBH(String hWBH) { this.HWBH = hWBH; }
/*     */   
/*     */   @JsonProperty("hwmc")
/*     */   public String getHWMC() {
/*  77 */     return this.HWMC;
/*     */   }
/*     */   
/*  80 */   public void setHWMC(String hWMC) { this.HWMC = hWMC; }
/*     */   
/*     */   @JsonProperty("clfs")
/*     */   public Integer getCLFS() {
/*  84 */     return this.CLFS;
/*     */   }
/*     */   
/*  87 */   public void setCLFS(Integer cLFS) { this.CLFS = cLFS; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("hwrl")
/*     */   public BigDecimal getHWRL() {
/*  92 */     return this.HWRL;
/*     */   }
/*     */   
/*  95 */   public void setHWRL(BigDecimal hWRL) { this.HWRL = hWRL; }
/*     */   
/*     */   @JsonProperty("hwzt")
/*     */   public Integer getHWZT() {
/*  99 */     return this.HWZT;
/*     */   }
/*     */   
/* 102 */   public void setHWZT(Integer hWZT) { this.HWZT = hWZT; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("hwqyrq")
/*     */   public Date getHWQYRQ() {
/* 107 */     return this.HWQYRQ;
/*     */   }
/*     */   
/* 110 */   public void setHWQYRQ(Date hWQYRQ) { this.HWQYRQ = hWQYRQ; }
/*     */   
/*     */   @JsonProperty("hwbz")
/*     */   public String getHWBZ() {
/* 114 */     return this.HWBZ;
/*     */   }
/*     */   
/* 117 */   public void setHWBZ(String hWBZ) { this.HWBZ = hWBZ; }
/*     */   
/*     */   @JsonProperty("sfsc")
/*     */   public Integer getSFSC() {
/* 121 */     return this.SFSC;
/*     */   }
/*     */   
/* 124 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjCargo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */