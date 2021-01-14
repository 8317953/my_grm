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
/*     */ public class SjCompany
/*     */ {
/*     */   @Description("企业代码")
/*  16 */   private String QYDM = "";
/*     */   @Description("企业名称")
/*  18 */   private String QYMC = "";
/*     */   @Description("企业类型")
/*     */   private Integer QYLX;
/*     */   @Description("企业类别")
/*     */   private Integer QYLB;
/*     */   @Description("企业经济性质")
/*     */   private Integer QYXZ;
/*     */   @Description("隶属关系")
/*     */   private Integer LSGX;
/*     */   @Description("是否应急企业")
/*  28 */   private Integer SFYJQY = Integer.valueOf(0);
/*     */   @Description("是否放心粮油")
/*  30 */   private Integer SFFXLY = Integer.valueOf(1);
/*     */   @Description("隶属上级单位")
/*  32 */   private String LSSJDW = "";
/*     */   @Description("收购资格")
/*  34 */   private Integer SGZG = Integer.valueOf(300);
/*     */   @Description("收购许可证")
/*  36 */   private String SGXKZ = "";
/*     */   @Description("上级粮食局")
/*  38 */   private String SJLSBH = "";
/*     */   @Description("登记机关编号")
/*  40 */   private String DJJGBH = "";
/*     */   @Description("注册时间")
/*     */   private Date ZCSJ;
/*     */   @Description("注册币种")
/*  44 */   private Integer ZCBZ = Integer.valueOf(156);
/*     */   @Description("注册资本")
/*  46 */   private BigDecimal ZCZB = new BigDecimal(10000);
/*     */   @Description("注册地址区域编码")
/*  48 */   private String ZCQYBM = "";
/*     */   @Description("注册详细地址")
/*  50 */   private String ZCXXDZ = "";
/*     */   @Description("经营地址区域编码")
/*  52 */   private String JYDZBM = "";
/*     */   @Description("法人姓名")
/*  54 */   private String FRXM = "156";
/*     */   @Description("法人国别")
/*  56 */   private String FRGB = "";
/*     */   @Description("法人证件类型")
/*  58 */   private Integer FRZJLX = Integer.valueOf(10);
/*     */   @Description("法人证件号")
/*  60 */   private String FRSFZ = "";
/*     */   @Description("法人手机号")
/*  62 */   private String FRSJH = "";
/*     */   @Description("经度")
/*     */   private BigDecimal JD;
/*     */   @Description("纬度")
/*     */   private BigDecimal WD;
/*     */   @Description("资产总额")
/*     */   private BigDecimal ZCZE;
/*     */   @Description("年加工量")
/*  70 */   private BigDecimal NJGL = new BigDecimal(10000);
/*     */   @Description("主要加工品种")
/*     */   private String ZYJGPZ;
/*     */   @Description("年经营量")
/*  74 */   private BigDecimal NJYL = new BigDecimal(10000);
/*     */   @Description("主要经营品种")
/*     */   private String ZYJYPZ;
/*     */   @Description("年收购量")
/*  78 */   private BigDecimal NSGL = new BigDecimal(10000);
/*     */   @Description("主要收购品种")
/*     */   private String ZYSGPZ;
/*     */   @Description("自有资金")
/*  82 */   private BigDecimal ZYZJ = new BigDecimal(1000);
/*     */   @Description("法人传真号码")
/*     */   private String FRCZHM;
/*     */   @Description("备案日期")
/*     */   private Date BARQ;
/*     */   @Description("企业联系人手机")
/*     */   private String QYLXRSJ;
/*     */   @Description("是否删除")
/*  90 */   private Integer SFSC = Integer.valueOf(0);
/*     */   
/*     */   @JsonProperty("qydm")
/*     */   public String getQYDM() {
/*  94 */     return this.QYDM;
/*     */   }
/*     */   
/*  97 */   public void setQYDM(String qYDM) { this.QYDM = qYDM; }
/*     */   
/*     */   @JsonProperty("qymc")
/*     */   public String getQYMC() {
/* 101 */     return this.QYMC;
/*     */   }
/*     */   
/* 104 */   public void setQYMC(String qYMC) { this.QYMC = qYMC; }
/*     */   
/*     */   @JsonProperty("qylx")
/*     */   public Integer getQYLX() {
/* 108 */     return this.QYLX;
/*     */   }
/*     */   
/* 111 */   public void setQYLX(Integer qYLX) { this.QYLX = qYLX; }
/*     */   
/*     */   @JsonProperty("qylb")
/*     */   public Integer getQYLB() {
/* 115 */     return this.QYLB;
/*     */   }
/*     */   
/* 118 */   public void setQYLB(Integer qYLB) { this.QYLB = qYLB; }
/*     */   
/*     */   @JsonProperty("qyxz")
/*     */   public Integer getQYXZ() {
/* 122 */     return this.QYXZ;
/*     */   }
/*     */   
/* 125 */   public void setQYXZ(Integer qYXZ) { this.QYXZ = qYXZ; }
/*     */   
/*     */   @JsonProperty("lsgx")
/*     */   public Integer getLSGX() {
/* 129 */     return this.LSGX;
/*     */   }
/*     */   
/* 132 */   public void setLSGX(Integer lSGX) { this.LSGX = lSGX; }
/*     */   
/*     */   @JsonProperty("sfyjqy")
/*     */   public Integer getSFYJQY() {
/* 136 */     return this.SFYJQY;
/*     */   }
/*     */   
/* 139 */   public void setSFYJQY(Integer sFYJQY) { this.SFYJQY = sFYJQY; }
/*     */   
/*     */   @JsonProperty("sffxly")
/*     */   public Integer getSFFXLY() {
/* 143 */     return this.SFFXLY;
/*     */   }
/*     */   
/* 146 */   public void setSFFXLY(Integer sFFXLY) { this.SFFXLY = sFFXLY; }
/*     */   
/*     */   @JsonProperty("sgzg")
/*     */   public Integer getSGZG() {
/* 150 */     return this.SGZG;
/*     */   }
/*     */   
/* 153 */   public void setSGZG(Integer sGZG) { this.SGZG = sGZG; }
/*     */   
/*     */   @JsonProperty("sgxkz")
/*     */   public String getSGXKZ() {
/* 157 */     return this.SGXKZ;
/*     */   }
/*     */   
/* 160 */   public void setSGXKZ(String sGXKZ) { this.SGXKZ = sGXKZ; }
/*     */   
/*     */   @JsonProperty("sjlsbh")
/*     */   public String getSJLSBH() {
/* 164 */     return this.SJLSBH;
/*     */   }
/*     */   
/* 167 */   public void setSJLSBH(String sJLSBH) { this.SJLSBH = sJLSBH; }
/*     */   
/*     */   @JsonProperty("djjgbh")
/*     */   public String getDJJGBH() {
/* 171 */     return this.DJJGBH;
/*     */   }
/*     */   
/* 174 */   public void setDJJGBH(String dJJGBH) { this.DJJGBH = dJJGBH; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("zcsj")
/*     */   public Date getZCSJ() {
/* 179 */     return this.ZCSJ;
/*     */   }
/*     */   
/* 182 */   public void setZCSJ(Date zCSJ) { this.ZCSJ = zCSJ; }
/*     */   
/*     */   @JsonProperty("zcbz")
/*     */   public Integer getZCBZ() {
/* 186 */     return this.ZCBZ;
/*     */   }
/*     */   
/* 189 */   public void setZCBZ(Integer zCBZ) { this.ZCBZ = zCBZ; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("zczb")
/*     */   public BigDecimal getZCZB() {
/* 194 */     return this.ZCZB;
/*     */   }
/*     */   
/* 197 */   public void setZCZB(BigDecimal zCZB) { this.ZCZB = zCZB; }
/*     */   
/*     */   @JsonProperty("zcqybm")
/*     */   public String getZCQYBM() {
/* 201 */     return this.ZCQYBM;
/*     */   }
/*     */   
/* 204 */   public void setZCQYBM(String zCQYBM) { this.ZCQYBM = zCQYBM; }
/*     */   
/*     */   @JsonProperty("zcxxdz")
/*     */   public String getZCXXDZ() {
/* 208 */     return this.ZCXXDZ;
/*     */   }
/*     */   
/* 211 */   public void setZCXXDZ(String zCXXDZ) { this.ZCXXDZ = zCXXDZ; }
/*     */   
/*     */   @JsonProperty("jydzbm")
/*     */   public String getJYDZBM() {
/* 215 */     return this.JYDZBM;
/*     */   }
/*     */   
/* 218 */   public void setJYDZBM(String jYDZBM) { this.JYDZBM = jYDZBM; }
/*     */   
/*     */   @JsonProperty("frxm")
/*     */   public String getFRXM() {
/* 222 */     return this.FRXM;
/*     */   }
/*     */   
/* 225 */   public void setFRXM(String fRXM) { this.FRXM = fRXM; }
/*     */   
/*     */   @JsonProperty("frgb")
/*     */   public String getFRGB() {
/* 229 */     return this.FRGB;
/*     */   }
/*     */   
/* 232 */   public void setFRGB(String fRGB) { this.FRGB = fRGB; }
/*     */   
/*     */   @JsonProperty("frzjlx")
/*     */   public Integer getFRZJLX() {
/* 236 */     return this.FRZJLX;
/*     */   }
/*     */   
/* 239 */   public void setFRZJLX(Integer fRZJLX) { this.FRZJLX = fRZJLX; }
/*     */   
/*     */   @JsonProperty("frsfz")
/*     */   public String getFRSFZ() {
/* 243 */     return this.FRSFZ;
/*     */   }
/*     */   
/* 246 */   public void setFRSFZ(String fRSFZ) { this.FRSFZ = fRSFZ; }
/*     */   
/*     */   @JsonProperty("frsjh")
/*     */   public String getFRSJH() {
/* 250 */     return this.FRSJH;
/*     */   }
/*     */   
/* 253 */   public void setFRSJH(String fRSJH) { this.FRSJH = fRSJH; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("jd")
/*     */   public BigDecimal getJD() {
/* 258 */     return this.JD;
/*     */   }
/*     */   
/* 261 */   public void setJD(BigDecimal jD) { this.JD = jD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("wd")
/*     */   public BigDecimal getWD() {
/* 266 */     return this.WD;
/*     */   }
/*     */   
/* 269 */   public void setWD(BigDecimal wD) { this.WD = wD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("zcze")
/*     */   public BigDecimal getZCZE() {
/* 274 */     return this.ZCZE;
/*     */   }
/*     */   
/* 277 */   public void setZCZE(BigDecimal zCZE) { this.ZCZE = zCZE; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("njgl")
/*     */   public BigDecimal getNJGL() {
/* 282 */     return this.NJGL;
/*     */   }
/*     */   
/* 285 */   public void setNJGL(BigDecimal nJGL) { this.NJGL = nJGL; }
/*     */   
/*     */   @JsonProperty("zyjgpz")
/*     */   public String getZYJGPZ() {
/* 289 */     return this.ZYJGPZ;
/*     */   }
/*     */   
/* 292 */   public void setZYJGPZ(String zYJGPZ) { this.ZYJGPZ = zYJGPZ; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("njyl")
/*     */   public BigDecimal getNJYL() {
/* 297 */     return this.NJYL;
/*     */   }
/*     */   
/* 300 */   public void setNJYL(BigDecimal nJYL) { this.NJYL = nJYL; }
/*     */   
/*     */   @JsonProperty("zyjypz")
/*     */   public String getZYJYPZ() {
/* 304 */     return this.ZYJYPZ;
/*     */   }
/*     */   
/* 307 */   public void setZYJYPZ(String zYJYPZ) { this.ZYJYPZ = zYJYPZ; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("nsgl")
/*     */   public BigDecimal getNSGL() {
/* 312 */     return this.NSGL;
/*     */   }
/*     */   
/* 315 */   public void setNSGL(BigDecimal nSGL) { this.NSGL = nSGL; }
/*     */   
/*     */   @JsonProperty("zysgpz")
/*     */   public String getZYSGPZ() {
/* 319 */     return this.ZYSGPZ;
/*     */   }
/*     */   
/* 322 */   public void setZYSGPZ(String zYSGPZ) { this.ZYSGPZ = zYSGPZ; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("zyzj")
/*     */   public BigDecimal getZYZJ() {
/* 327 */     return this.ZYZJ;
/*     */   }
/*     */   
/* 330 */   public void setZYZJ(BigDecimal zYZJ) { this.ZYZJ = zYZJ; }
/*     */   
/*     */   @JsonProperty("sfsc")
/*     */   public Integer getSFSC() {
/* 334 */     return this.SFSC;
/*     */   }
/*     */   
/* 337 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*     */   
/*     */   @JsonProperty("lssjdw")
/*     */   public String getLSSJDW() {
/* 341 */     return this.LSSJDW;
/*     */   }
/*     */   
/* 344 */   public void setLSSJDW(String lSSJDW) { this.LSSJDW = lSSJDW; }
/*     */   
/*     */   @JsonProperty("frczhm")
/*     */   public String getFRCZHM() {
/* 348 */     return this.FRCZHM;
/*     */   }
/*     */   
/* 351 */   public void setFRCZHM(String fRCZHM) { this.FRCZHM = fRCZHM; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("barq")
/*     */   public Date getBARQ() {
/* 356 */     return this.BARQ;
/*     */   }
/*     */   
/* 359 */   public void setBARQ(Date bARQ) { this.BARQ = bARQ; }
/*     */   
/*     */   @JsonProperty("qylxrsj")
/*     */   public String getQYLXRSJ() {
/* 363 */     return this.QYLXRSJ;
/*     */   }
/*     */   
/* 366 */   public void setQYLXRSJ(String qYLXRSJ) { this.QYLXRSJ = qYLXRSJ; }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjCompany.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */