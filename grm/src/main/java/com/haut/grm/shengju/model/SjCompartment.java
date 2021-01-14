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
/*     */ public class SjCompartment
/*     */ {
/*     */   @Description("企业代码")
/*     */   private String QYDM;
/*     */   @Description("库区编码")
/*     */   private String KQBM;
/*     */   @Description("仓房号")
/*     */   private String CFH;
/*     */   @Description("廒间编号")
/*     */   private String AJBH;
/*     */   @Description("廒间名称")
/*     */   private String AJMC;
/*     */   @Description("廒间长度")
/*     */   private BigDecimal AJCD;
/*     */   @Description("廒间宽度")
/*     */   private BigDecimal AJKD;
/*     */   @Description("廒间高度")
/*     */   private BigDecimal AJGD;
/*     */   @Description("廒间设计仓容")
/*     */   private BigDecimal AJSJCR;
/*     */   @Description("廒间实际仓容")
/*     */   private BigDecimal AJSJRL;
/*     */   @Description("廒间联系电话")
/*     */   private String AJLXDH;
/*     */   @Description("廒间启用日期")
/*     */   private Date AJQYRQ;
/*     */   @Description("廒间状态")
/*     */   private Integer AJZT;
/*     */   @Description("廒间备注")
/*     */   private String AJBZ;
/*     */   @Description("是否删除")
/*  44 */   private Integer SFSC = Integer.valueOf(0);
/*     */   
/*     */   @JsonProperty("qydm")
/*     */   public String getQYDM() {
/*  48 */     return this.QYDM;
/*     */   }
/*     */   
/*  51 */   public void setQYDM(String qYDM) { this.QYDM = qYDM; }
/*     */   
/*     */   @JsonProperty("kqbm")
/*     */   public String getKQBM() {
/*  55 */     return this.KQBM;
/*     */   }
/*     */   
/*  58 */   public void setKQBM(String kQBM) { this.KQBM = kQBM; }
/*     */   
/*     */   @JsonProperty("cfh")
/*     */   public String getCFH() {
/*  62 */     return this.CFH;
/*     */   }
/*     */   
/*  65 */   public void setCFH(String cFH) { this.CFH = cFH; }
/*     */   
/*     */   @JsonProperty("ajbh")
/*     */   public String getAJBH() {
/*  69 */     return this.AJBH;
/*     */   }
/*     */   
/*  72 */   public void setAJBH(String aJBH) { this.AJBH = aJBH; }
/*     */   
/*     */   @JsonProperty("ajmc")
/*     */   public String getAJMC() {
/*  76 */     return this.AJMC;
/*     */   }
/*     */   
/*  79 */   public void setAJMC(String aJMC) { this.AJMC = aJMC; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("ajcd")
/*     */   public BigDecimal getAJCD() {
/*  84 */     return this.AJCD;
/*     */   }
/*     */   
/*  87 */   public void setAJCD(BigDecimal aJCD) { this.AJCD = aJCD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("ajkd")
/*     */   public BigDecimal getAJKD() {
/*  92 */     return this.AJKD;
/*     */   }
/*     */   
/*  95 */   public void setAJKD(BigDecimal aJKD) { this.AJKD = aJKD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("ajgd")
/*     */   public BigDecimal getAJGD() {
/* 100 */     return this.AJGD;
/*     */   }
/*     */   
/* 103 */   public void setAJGD(BigDecimal aJGD) { this.AJGD = aJGD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("ajsjcr")
/*     */   public BigDecimal getAJSJCR() {
/* 108 */     return this.AJSJCR;
/*     */   }
/*     */   
/* 111 */   public void setAJSJCR(BigDecimal aJSJCR) { this.AJSJCR = aJSJCR; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("ajsjrl")
/*     */   public BigDecimal getAJSJRL() {
/* 116 */     return this.AJSJRL;
/*     */   }
/*     */   
/* 119 */   public void setAJSJRL(BigDecimal aJSJRL) { this.AJSJRL = aJSJRL; }
/*     */   
/*     */   @JsonProperty("ajlxdh")
/*     */   public String getAJLXDH() {
/* 123 */     return this.AJLXDH;
/*     */   }
/*     */   
/* 126 */   public void setAJLXDH(String aJLXDH) { this.AJLXDH = aJLXDH; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("ajqyrq")
/*     */   public Date getAJQYRQ() {
/* 131 */     return this.AJQYRQ;
/*     */   }
/*     */   
/* 134 */   public void setAJQYRQ(Date aJQYRQ) { this.AJQYRQ = aJQYRQ; }
/*     */   
/*     */   @JsonProperty("ajzt")
/*     */   public Integer getAJZT() {
/* 138 */     return this.AJZT;
/*     */   }
/*     */   
/* 141 */   public void setAJZT(Integer aJZT) { this.AJZT = aJZT; }
/*     */   
/*     */   @JsonProperty("ajbz")
/*     */   public String getAJBZ() {
/* 145 */     return this.AJBZ;
/*     */   }
/*     */   
/* 148 */   public void setAJBZ(String aJBZ) { this.AJBZ = aJBZ; }
/*     */   
/*     */   @JsonProperty("sfsc")
/*     */   public Integer getSFSC() {
/* 152 */     return this.SFSC;
/*     */   }
/*     */   
/* 155 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjCompartment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */