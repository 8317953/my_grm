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
/*     */ public class SjStockSum
/*     */ {
/*     */   @Description("企业代码")
/*     */   private String QYBM;
/*     */   @Description("库区编码")
/*     */   private String KQBM;
/*     */   @Description("仓房号")
/*     */   private String CFH;
/*     */   @Description("廒间编号")
/*     */   private String AJBH;
/*     */   @Description("货位编号")
/*     */   private String HWBH;
/*     */   @Description("货位状态")
/*     */   private String HWZT;
/*     */   @Description("收获年份")
/*     */   private String SHNF;
/*     */   @Description("粮权性质编码")
/*     */   private Integer LSXZBM;
/*     */   @Description("粮权归属单位编码")
/*     */   private String LQGSDWBM;
/*     */   @Description("粮权归属单位名称")
/*     */   private String LQGSDWMC;
/*     */   @Description("粮食品种")
/*     */   private String LSPZ;
/*     */   @Description("粮食品种编码")
/*     */   private String LSPZBM;
/*     */   @Description("粮食等级代码")
/*     */   private String LSDJBM;
/*     */   @Description("粮食国别")
/*     */   private String LSGB;
/*     */   @Description("粮食产地")
/*     */   private String LSCD;
/*     */   @Description("入库时间")
/*     */   private Date RKSJ;
/*     */   @Description("封仓时间")
/*     */   private Date FCSJ;
/*     */   @Description("清仓时间")
/*     */   private Date QCSJ;
/*     */   @Description("库存数量")
/*     */   private BigDecimal KCSL;
/*     */   @Description("保管员名称")
/*     */   private String BGYMC;
/*     */   @Description("是否删除")
/*  56 */   private Integer SFSC = Integer.valueOf(0);
/*     */   
/*     */   @JsonProperty("qybm")
/*     */   public String getQYBM() {
/*  60 */     return this.QYBM;
/*     */   }
/*     */   
/*  63 */   public void setQYBM(String qYBM) { this.QYBM = qYBM; }
/*     */   
/*     */   @JsonProperty("kqbm")
/*     */   public String getKQBM() {
/*  67 */     return this.KQBM;
/*     */   }
/*     */   
/*  70 */   public void setKQBM(String kQBM) { this.KQBM = kQBM; }
/*     */   
/*     */   @JsonProperty("cfh")
/*     */   public String getCFH() {
/*  74 */     return this.CFH;
/*     */   }
/*     */   
/*  77 */   public void setCFH(String cFH) { this.CFH = cFH; }
/*     */   
/*     */   @JsonProperty("ajbh")
/*     */   public String getAJBH() {
/*  81 */     return this.AJBH;
/*     */   }
/*     */   
/*  84 */   public void setAJBH(String aJBH) { this.AJBH = aJBH; }
/*     */   
/*     */   @JsonProperty("hwbh")
/*     */   public String getHWBH() {
/*  88 */     return this.HWBH;
/*     */   }
/*     */   
/*  91 */   public void setHWBH(String hWBH) { this.HWBH = hWBH; }
/*     */   
/*     */   @JsonProperty("hwzt")
/*     */   public String getHWZT() {
/*  95 */     return this.HWZT;
/*     */   }
/*     */   
/*  98 */   public void setHWZT(String hWZT) { this.HWZT = hWZT; }
/*     */   
/*     */   @JsonProperty("shnf")
/*     */   public String getSHNF() {
/* 102 */     return this.SHNF;
/*     */   }
/*     */   
/* 105 */   public void setSHNF(String sHNF) { this.SHNF = sHNF; }
/*     */   
/*     */   @JsonProperty("lsxzbm")
/*     */   public Integer getLSXZBM() {
/* 109 */     return this.LSXZBM;
/*     */   }
/*     */   
/* 112 */   public void setLSXZBM(Integer lSXZBM) { this.LSXZBM = lSXZBM; }
/*     */   
/*     */   @JsonProperty("lqgsdwbm")
/*     */   public String getLQGSDWBM() {
/* 116 */     return this.LQGSDWBM;
/*     */   }
/*     */   
/* 119 */   public void setLQGSDWBM(String lQGSDWBM) { this.LQGSDWBM = lQGSDWBM; }
/*     */   
/*     */   @JsonProperty("lqgsdwmc")
/*     */   public String getLQGSDWMC() {
/* 123 */     return this.LQGSDWMC;
/*     */   }
/*     */   
/* 126 */   public void setLQGSDWMC(String lQGSDWMC) { this.LQGSDWMC = lQGSDWMC; }
/*     */   
/*     */   @JsonProperty("lspz")
/*     */   public String getLSPZ() {
/* 130 */     return this.LSPZ;
/*     */   }
/*     */   
/* 133 */   public void setLSPZ(String lSPZ) { this.LSPZ = lSPZ; }
/*     */   
/*     */   @JsonProperty("lspzbm")
/*     */   public String getLSPZBM() {
/* 137 */     return this.LSPZBM;
/*     */   }
/*     */   
/* 140 */   public void setLSPZBM(String lSPZBM) { this.LSPZBM = lSPZBM; }
/*     */   
/*     */   @JsonProperty("lsdjbm")
/*     */   public String getLSDJBM() {
/* 144 */     return this.LSDJBM;
/*     */   }
/*     */   
/* 147 */   public void setLSDJBM(String lSDJBM) { this.LSDJBM = lSDJBM; }
/*     */   
/*     */   @JsonProperty("lsgb")
/*     */   public String getLSGB() {
/* 151 */     return this.LSGB;
/*     */   }
/*     */   
/* 154 */   public void setLSGB(String lSGB) { this.LSGB = lSGB; }
/*     */   
/*     */   @JsonProperty("lscd")
/*     */   public String getLSCD() {
/* 158 */     return this.LSCD;
/*     */   }
/*     */   
/* 161 */   public void setLSCD(String lSCD) { this.LSCD = lSCD; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("rksj")
/*     */   public Date getRKSJ() {
/* 166 */     return this.RKSJ;
/*     */   }
/*     */   
/* 169 */   public void setRKSJ(Date rKSJ) { this.RKSJ = rKSJ; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("fcsj")
/*     */   public Date getFCSJ() {
/* 174 */     return this.FCSJ;
/*     */   }
/*     */   
/* 177 */   public void setFCSJ(Date fCSJ) { this.FCSJ = fCSJ; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("qcsj")
/*     */   public Date getQCSJ() {
/* 182 */     return this.QCSJ;
/*     */   }
/*     */   
/* 185 */   public void setQCSJ(Date qCSJ) { this.QCSJ = qCSJ; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("kcsl")
/*     */   public BigDecimal getKCSL() {
/* 190 */     return this.KCSL;
/*     */   }
/*     */   
/* 193 */   public void setKCSL(BigDecimal kCSL) { this.KCSL = kCSL; }
/*     */   
/*     */   @JsonProperty("bgymc")
/*     */   public String getBGYMC() {
/* 197 */     return this.BGYMC;
/*     */   }
/*     */   
/* 200 */   public void setBGYMC(String bGYMC) { this.BGYMC = bGYMC; }
/*     */   
/*     */   @JsonProperty("sfsc")
/*     */   public Integer getSFSC() {
/* 204 */     return this.SFSC;
/*     */   }
/*     */   
/* 207 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjStockSum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */