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
/*     */ public class SjDepot
/*     */ {
/*     */   @Description("企业代码")
/*     */   private String QYDM;
/*     */   @Description("库区编码")
/*     */   private String KQBM;
/*     */   @Description("库区名称")
/*     */   private String KQMC;
/*     */   @Description("库区负责人姓名")
/*     */   private String KQFZRXM;
/*     */   @Description("库区电话")
/*     */   private String KQDH;
/*     */   @Description("库区属地")
/*     */   private String KQSD;
/*     */   @Description("库区详细地址")
/*     */   private String KQDZ;
/*     */   @Description("仓储设施产权")
/*  30 */   private Integer CCSSCQ = Integer.valueOf(1);
/*     */   @Description("设计总仓容")
/*     */   private BigDecimal SJZCR;
/*     */   @Description("设计总罐容")
/*     */   private BigDecimal SJZGR;
/*     */   @Description("有效总仓容")
/*     */   private BigDecimal YXZCR;
/*     */   @Description("有效总罐容")
/*     */   private BigDecimal YXZGR;
/*     */   @Description("有无铁路专用线")
/*  40 */   private Integer YWTLZYX = Integer.valueOf(2);
/*     */   @Description("有无水运码头")
/*  42 */   private Integer YWSYMT = Integer.valueOf(2);
/*     */   @Description("紧邻公路类别")
/*  44 */   private Integer JLGLLB = Integer.valueOf(4);
/*     */   @Description("紧邻公路距离")
/*  46 */   private BigDecimal JLGLJL = new BigDecimal(1500);
/*     */   @Description("有无污染源")
/*  48 */   private Integer YWWRY = Integer.valueOf(2);
/*     */   @Description("有无防洪设施")
/*  50 */   private Integer YWFHSS = Integer.valueOf(1);
/*     */   @Description("有无消防水源")
/*  52 */   private Integer YWXFSY = Integer.valueOf(1);
/*     */   @Description("有无消防设施")
/*  54 */   private Integer YWXFSS = Integer.valueOf(1);
/*     */   @Description("有无汽车衡")
/*  56 */   private Integer YWQCH = Integer.valueOf(1);
/*     */   @Description("有无检化验室")
/*  58 */   private Integer YWJHYS = Integer.valueOf(1);
/*     */   @Description("库区平面图")
/*     */   private String KQPMT;
/*     */   @Description("库点_经度")
/*     */   private BigDecimal JD;
/*     */   @Description("库点_纬度")
/*     */   private BigDecimal WD;
/*     */   @Description("建成时间")
/*     */   private Date JCSJ;
/*     */   @Description("库区传真")
/*     */   private String KQCZ;
/*     */   @Description("库区邮编")
/*     */   private String KQYB;
/*     */   @Description("其它图片")
/*     */   private String QTTP;
/*     */   @Description("库点介绍")
/*     */   private String KDJS;
/*     */   @Description("是否直属库")
/*  76 */   private String SFZSF = "N";
/*     */   @Description("直属库级别")
/*     */   private String ZSKJB;
/*     */   @Description("直属库所属部门")
/*     */   private String ZSKSSBM;
/*     */   @Description("是否删除")
/*  82 */   private Integer SFSC = Integer.valueOf(0);
/*     */   
/*     */   @JsonProperty("qydm")
/*     */   public String getQYDM() {
/*  86 */     return this.QYDM;
/*     */   }
/*     */   
/*  89 */   public void setQYDM(String qYDM) { this.QYDM = qYDM; }
/*     */   
/*     */   @JsonProperty("kqbm")
/*     */   public String getKQBM() {
/*  93 */     return this.KQBM;
/*     */   }
/*     */   
/*  96 */   public void setKQBM(String kQBM) { this.KQBM = kQBM; }
/*     */   
/*     */   @JsonProperty("kqmc")
/*     */   public String getKQMC() {
/* 100 */     return this.KQMC;
/*     */   }
/*     */   
/* 103 */   public void setKQMC(String kQMC) { this.KQMC = kQMC; }
/*     */   
/*     */   @JsonProperty("kqfzrxm")
/*     */   public String getKQFZRXM() {
/* 107 */     return this.KQFZRXM;
/*     */   }
/*     */   
/* 110 */   public void setKQFZRXM(String kQFZRXM) { this.KQFZRXM = kQFZRXM; }
/*     */   
/*     */   @JsonProperty("kqdh")
/*     */   public String getKQDH() {
/* 114 */     return this.KQDH;
/*     */   }
/*     */   
/* 117 */   public void setKQDH(String kQDH) { this.KQDH = kQDH; }
/*     */   
/*     */   @JsonProperty("kqsd")
/*     */   public String getKQSD() {
/* 121 */     return this.KQSD;
/*     */   }
/*     */   
/* 124 */   public void setKQSD(String kQSD) { this.KQSD = kQSD; }
/*     */   
/*     */   @JsonProperty("kqdz")
/*     */   public String getKQDZ() {
/* 128 */     return this.KQDZ;
/*     */   }
/*     */   
/* 131 */   public void setKQDZ(String kQDZ) { this.KQDZ = kQDZ; }
/*     */   
/*     */   @JsonProperty("ccsscq")
/*     */   public Integer getCCSSCQ() {
/* 135 */     return this.CCSSCQ;
/*     */   }
/*     */   
/* 138 */   public void setCCSSCQ(Integer cCSSCQ) { this.CCSSCQ = cCSSCQ; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("sjzcr")
/*     */   public BigDecimal getSJZCR() {
/* 143 */     return this.SJZCR;
/*     */   }
/*     */   
/* 146 */   public void setSJZCR(BigDecimal sJZCR) { this.SJZCR = sJZCR; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("sjzgr")
/*     */   public BigDecimal getSJZGR() {
/* 151 */     return this.SJZGR;
/*     */   }
/*     */   
/* 154 */   public void setSJZGR(BigDecimal sJZGR) { this.SJZGR = sJZGR; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("yxzcr")
/*     */   public BigDecimal getYXZCR() {
/* 159 */     return this.YXZCR;
/*     */   }
/*     */   
/* 162 */   public void setYXZCR(BigDecimal yXZCR) { this.YXZCR = yXZCR; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("yxzgr")
/*     */   public BigDecimal getYXZGR() {
/* 167 */     return this.YXZGR;
/*     */   }
/*     */   
/* 170 */   public void setYXZGR(BigDecimal yXZGR) { this.YXZGR = yXZGR; }
/*     */   
/*     */   @JsonProperty("ywtlzyx")
/*     */   public Integer getYWTLZYX() {
/* 174 */     return this.YWTLZYX;
/*     */   }
/*     */   
/* 177 */   public void setYWTLZYX(Integer yWTLZYX) { this.YWTLZYX = yWTLZYX; }
/*     */   
/*     */   @JsonProperty("ywsymt")
/*     */   public Integer getYWSYMT() {
/* 181 */     return this.YWSYMT;
/*     */   }
/*     */   
/* 184 */   public void setYWSYMT(Integer yWSYMT) { this.YWSYMT = yWSYMT; }
/*     */   
/*     */   @JsonProperty("jlgllb")
/*     */   public Integer getJLGLLB() {
/* 188 */     return this.JLGLLB;
/*     */   }
/*     */   
/* 191 */   public void setJLGLLB(Integer jLGLLB) { this.JLGLLB = jLGLLB; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("jlgljl")
/*     */   public BigDecimal getJLGLJL() {
/* 196 */     return this.JLGLJL;
/*     */   }
/*     */   
/* 199 */   public void setJLGLJL(BigDecimal jLGLJL) { this.JLGLJL = jLGLJL; }
/*     */   
/*     */   @JsonProperty("ywwry")
/*     */   public Integer getYWWRY() {
/* 203 */     return this.YWWRY;
/*     */   }
/*     */   
/* 206 */   public void setYWWRY(Integer yWWRY) { this.YWWRY = yWWRY; }
/*     */   
/*     */   @JsonProperty("ywfhss")
/*     */   public Integer getYWFHSS() {
/* 210 */     return this.YWFHSS;
/*     */   }
/*     */   
/* 213 */   public void setYWFHSS(Integer yWFHSS) { this.YWFHSS = yWFHSS; }
/*     */   
/*     */   @JsonProperty("ywxfsy")
/*     */   public Integer getYWXFSY() {
/* 217 */     return this.YWXFSY;
/*     */   }
/*     */   
/* 220 */   public void setYWXFSY(Integer yWXFSY) { this.YWXFSY = yWXFSY; }
/*     */   
/*     */   @JsonProperty("ywxfss")
/*     */   public Integer getYWXFSS() {
/* 224 */     return this.YWXFSS;
/*     */   }
/*     */   
/* 227 */   public void setYWXFSS(Integer yWXFSS) { this.YWXFSS = yWXFSS; }
/*     */   
/*     */   @JsonProperty("ywqch")
/*     */   public Integer getYWQCH() {
/* 231 */     return this.YWQCH;
/*     */   }
/*     */   
/* 234 */   public void setYWQCH(Integer yWQCH) { this.YWQCH = yWQCH; }
/*     */   
/*     */   @JsonProperty("ywjhys")
/*     */   public Integer getYWJHYS() {
/* 238 */     return this.YWJHYS;
/*     */   }
/*     */   
/* 241 */   public void setYWJHYS(Integer yWJHYS) { this.YWJHYS = yWJHYS; }
/*     */   
/*     */   @JsonProperty("kqpmt")
/*     */   public String getKQPMT() {
/* 245 */     return this.KQPMT;
/*     */   }
/*     */   
/* 248 */   public void setKQPMT(String kQPMT) { this.KQPMT = kQPMT; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("jd")
/*     */   public BigDecimal getJD() {
/* 253 */     return this.JD;
/*     */   }
/*     */   
/* 256 */   public void setJD(BigDecimal jD) { this.JD = jD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("wd")
/*     */   public BigDecimal getWD() {
/* 261 */     return this.WD;
/*     */   }
/*     */   
/* 264 */   public void setWD(BigDecimal wD) { this.WD = wD; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("jcsj")
/*     */   public Date getJCSJ() {
/* 269 */     return this.JCSJ;
/*     */   }
/*     */   
/* 272 */   public void setJCSJ(Date jCSJ) { this.JCSJ = jCSJ; }
/*     */   
/*     */   @JsonProperty("kqcz")
/*     */   public String getKQCZ() {
/* 276 */     return this.KQCZ;
/*     */   }
/*     */   
/* 279 */   public void setKQCZ(String kQCZ) { this.KQCZ = kQCZ; }
/*     */   
/*     */   @JsonProperty("kqyb")
/*     */   public String getKQYB() {
/* 283 */     return this.KQYB;
/*     */   }
/*     */   
/* 286 */   public void setKQYB(String kQYB) { this.KQYB = kQYB; }
/*     */   
/*     */   @JsonProperty("qttp")
/*     */   public String getQTTP() {
/* 290 */     return this.QTTP;
/*     */   }
/*     */   
/* 293 */   public void setQTTP(String qTTP) { this.QTTP = qTTP; }
/*     */   
/*     */   @JsonProperty("kdjs")
/*     */   public String getKDJS() {
/* 297 */     return this.KDJS;
/*     */   }
/*     */   
/* 300 */   public void setKDJS(String kDJS) { this.KDJS = kDJS; }
/*     */   
/*     */   @JsonProperty("sfzsf")
/*     */   public String getSFZSF() {
/* 304 */     return this.SFZSF;
/*     */   }
/*     */   
/* 307 */   public void setSFZSF(String sFZSF) { this.SFZSF = sFZSF; }
/*     */   
/*     */   @JsonProperty("zskjb")
/*     */   public String getZSKJB() {
/* 311 */     return this.ZSKJB;
/*     */   }
/*     */   
/* 314 */   public void setZSKJB(String zSKJB) { this.ZSKJB = zSKJB; }
/*     */   
/*     */   @JsonProperty("zskssbm")
/*     */   public String getZSKSSBM() {
/* 318 */     return this.ZSKSSBM;
/*     */   }
/*     */   
/* 321 */   public void setZSKSSBM(String zSKSSBM) { this.ZSKSSBM = zSKSSBM; }
/*     */   
/*     */   @JsonProperty("sfsc")
/*     */   public Integer getSFSC() {
/* 325 */     return this.SFSC;
/*     */   }
/*     */   
/* 328 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjDepot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */