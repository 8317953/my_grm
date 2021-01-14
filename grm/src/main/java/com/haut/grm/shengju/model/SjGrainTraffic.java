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
/*     */ public class SjGrainTraffic
/*     */ {
/*     */   @Description("单据编号")
/*     */   private String DJBH;
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
/*     */   @Description("业务类型")
/*     */   private Integer YWLX;
/*     */   @Description("业务登记日期")
/*     */   private Date YWDJRQ;
/*     */   @Description("合同编号")
/*     */   private String HTBH;
/*     */   @Description("客户名称")
/*     */   private String KHMC;
/*     */   @Description("承运人姓名")
/*     */   private String CYRXM;
/*     */   @Description("承运人身份证号")
/*     */   private String CYRSFZH;
/*     */   @Description("承运人联系电话")
/*     */   private String CYRLXDH;
/*     */   @Description("承运人详细地址")
/*     */   private String CYRXXDZ;
/*     */   @Description("运输工具")
/*     */   private String YSGJ;
/*     */   @Description("车船号")
/*     */   private String CCH;
/*     */   @Description("车辆登记时间")
/*     */   private Date CLDJSJ;
/*     */   @Description("登记门岗人员姓名")
/*     */   private String DJMGRYXM;
/*     */   @Description("扦样时间")
/*     */   private Date QYSJ;
/*     */   @Description("检验员")
/*     */   private String JYY;
/*     */   @Description("品种编码")
/*     */   private String PZBM;
/*     */   @Description("品种名称")
/*     */   private String PZMC;
/*     */   @Description("等级编码")
/*     */   private String DJBM;
/*     */   @Description("等级名称")
/*     */   private String DJMC;
/*     */   @Description("粮权性质编码")
/*     */   private String LQXZBM;
/*     */   @Description("粮权性质名称")
/*     */   private String LQXZMC;
/*     */   @Description("收获年度")
/*     */   private String SHND;
/*     */   @Description("国家编码")
/*     */   private String LSGB;
/*     */   @Description("粮食产地")
/*     */   private String LSCD;
/*     */   @Description("化验结果")
/*     */   private Integer HYJG;
/*     */   @Description("质检扣量")
/*     */   private Integer ZJKL;
/*     */   @Description("毛重")
/*     */   private Long MZ;
/*     */   @Description("毛重监磅员")
/*     */   private String MZJBY;
/*     */   @Description("毛重计量时间")
/*     */   private Date MZJLSJ;
/*     */   @Description("保管员扣量")
/*     */   private Long BGYKL;
/*     */   @Description("保管员姓名")
/*     */   private String BGYXM;
/*     */   @Description("确认时间")
/*     */   private Date QRSJ;
/*     */   @Description("皮重")
/*     */   private Long PZ;
/*     */   @Description("皮重监磅员")
/*     */   private String PZJBY;
/*     */   @Description("皮重计量时间")
/*     */   private Date PZJLSJ;
/*     */   @Description("现场扣量")
/*     */   private Long XCZJ;
/*     */   @Description("净重")
/*     */   private Long JZ;
/*     */   @Description("结算重量")
/*     */   private Long JSZL;
/*     */   @Description("结算单价")
/*     */   private BigDecimal JSDJ;
/*     */   @Description("结算金额（元）")
/*     */   private BigDecimal JSJE;
/*     */   @Description("结算时间")
/*     */   private Date JSSJ;
/*     */   @Description("结算人姓名")
/*     */   private String JSRXM;
/*     */   @Description("出门时间")
/*     */   private Date CMSJ;
/*     */   @Description("出门确认门岗人员姓名")
/*     */   private String CMQRMGRYXM;
/*     */   @Description("入门登记照片")
/*     */   private String RMDJZP;
/*     */   @Description("出门确认门岗人员姓名")
/*     */   private String GBZP;
/*     */   @Description("是否删除")
/* 118 */   private Integer SFSC = Integer.valueOf(0);
/*     */   
/*     */   @JsonProperty("djbh")
/*     */   public String getDJBH() {
/* 122 */     return this.DJBH;
/*     */   }
/*     */   
/* 125 */   public void setDJBH(String dJBH) { this.DJBH = dJBH; }
/*     */   
/*     */   @JsonProperty("qydm")
/*     */   public String getQYDM() {
/* 129 */     return this.QYDM;
/*     */   }
/*     */   
/* 132 */   public void setQYDM(String qYDM) { this.QYDM = qYDM; }
/*     */   
/*     */   @JsonProperty("kqbm")
/*     */   public String getKQBM() {
/* 136 */     return this.KQBM;
/*     */   }
/*     */   
/* 139 */   public void setKQBM(String kQBM) { this.KQBM = kQBM; }
/*     */   
/*     */   @JsonProperty("cfh")
/*     */   public String getCFH() {
/* 143 */     return this.CFH;
/*     */   }
/*     */   
/* 146 */   public void setCFH(String cFH) { this.CFH = cFH; }
/*     */   
/*     */   @JsonProperty("ajbh")
/*     */   public String getAJBH() {
/* 150 */     return this.AJBH;
/*     */   }
/*     */   
/* 153 */   public void setAJBH(String aJBH) { this.AJBH = aJBH; }
/*     */   
/*     */   @JsonProperty("hwbh")
/*     */   public String getHWBH() {
/* 157 */     return this.HWBH;
/*     */   }
/*     */   
/* 160 */   public void setHWBH(String hWBH) { this.HWBH = hWBH; }
/*     */   
/*     */   @JsonProperty("ywlx")
/*     */   public Integer getYWLX() {
/* 164 */     return this.YWLX;
/*     */   }
/*     */   
/* 167 */   public void setYWLX(Integer yWLX) { this.YWLX = yWLX; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("ywdjrq")
/*     */   public Date getYWDJRQ() {
/* 172 */     return this.YWDJRQ;
/*     */   }
/*     */   
/* 175 */   public void setYWDJRQ(Date yWDJRQ) { this.YWDJRQ = yWDJRQ; }
/*     */   
/*     */   @JsonProperty("htbh")
/*     */   public String getHTBH() {
/* 179 */     return this.HTBH;
/*     */   }
/*     */   
/* 182 */   public void setHTBH(String hTBH) { this.HTBH = hTBH; }
/*     */   
/*     */   @JsonProperty("khmc")
/*     */   public String getKHMC() {
/* 186 */     return this.KHMC;
/*     */   }
/*     */   
/* 189 */   public void setKHMC(String kHMC) { this.KHMC = kHMC; }
/*     */   
/*     */   @JsonProperty("cyrxm")
/*     */   public String getCYRXM() {
/* 193 */     return this.CYRXM;
/*     */   }
/*     */   
/* 196 */   public void setCYRXM(String cYRXM) { this.CYRXM = cYRXM; }
/*     */   
/*     */   @JsonProperty("cyrsfzh")
/*     */   public String getCYRSFZH() {
/* 200 */     return this.CYRSFZH;
/*     */   }
/*     */   
/* 203 */   public void setCYRSFZH(String cYRSFZH) { this.CYRSFZH = cYRSFZH; }
/*     */   
/*     */   @JsonProperty("cyrlxdh")
/*     */   public String getCYRLXDH() {
/* 207 */     return this.CYRLXDH;
/*     */   }
/*     */   
/* 210 */   public void setCYRLXDH(String cYRLXDH) { this.CYRLXDH = cYRLXDH; }
/*     */   
/*     */   @JsonProperty("cyrxxdz")
/*     */   public String getCYRXXDZ() {
/* 214 */     return this.CYRXXDZ;
/*     */   }
/*     */   
/* 217 */   public void setCYRXXDZ(String cYRXXDZ) { this.CYRXXDZ = cYRXXDZ; }
/*     */   
/*     */   @JsonProperty("ysgj")
/*     */   public String getYSGJ() {
/* 221 */     return this.YSGJ;
/*     */   }
/*     */   
/* 224 */   public void setYSGJ(String ySGJ) { this.YSGJ = ySGJ; }
/*     */   
/*     */   @JsonProperty("cch")
/*     */   public String getCCH() {
/* 228 */     return this.CCH;
/*     */   }
/*     */   
/* 231 */   public void setCCH(String cCH) { this.CCH = cCH; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("cldjsj")
/*     */   public Date getCLDJSJ() {
/* 236 */     return this.CLDJSJ;
/*     */   }
/*     */   
/* 239 */   public void setCLDJSJ(Date cLDJSJ) { this.CLDJSJ = cLDJSJ; }
/*     */   
/*     */   @JsonProperty("djmgryxm")
/*     */   public String getDJMGRYXM() {
/* 243 */     return this.DJMGRYXM;
/*     */   }
/*     */   
/* 246 */   public void setDJMGRYXM(String dJMGRYXM) { this.DJMGRYXM = dJMGRYXM; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("qysj")
/*     */   public Date getQYSJ() {
/* 251 */     return this.QYSJ;
/*     */   }
/*     */   
/* 254 */   public void setQYSJ(Date qYSJ) { this.QYSJ = qYSJ; }
/*     */   
/*     */   @JsonProperty("jyy")
/*     */   public String getJYY() {
/* 258 */     return this.JYY;
/*     */   }
/*     */   
/* 261 */   public void setJYY(String jYY) { this.JYY = jYY; }
/*     */   
/*     */   @JsonProperty("pzbm")
/*     */   public String getPZBM() {
/* 265 */     return this.PZBM;
/*     */   }
/*     */   
/* 268 */   public void setPZBM(String pZBM) { this.PZBM = pZBM; }
/*     */   
/*     */   @JsonProperty("pzmc")
/*     */   public String getPZMC() {
/* 272 */     return this.PZMC;
/*     */   }
/*     */   
/* 275 */   public void setPZMC(String pZMC) { this.PZMC = pZMC; }
/*     */   
/*     */   @JsonProperty("djbm")
/*     */   public String getDJBM() {
/* 279 */     return this.DJBM;
/*     */   }
/*     */   
/* 282 */   public void setDJBM(String dJBM) { this.DJBM = dJBM; }
/*     */   
/*     */   @JsonProperty("djmc")
/*     */   public String getDJMC() {
/* 286 */     return this.DJMC;
/*     */   }
/*     */   
/* 289 */   public void setDJMC(String dJMC) { this.DJMC = dJMC; }
/*     */   
/*     */   @JsonProperty("lqxzbm")
/*     */   public String getLQXZBM() {
/* 293 */     return this.LQXZBM;
/*     */   }
/*     */   
/* 296 */   public void setLQXZBM(String lQXZBM) { this.LQXZBM = lQXZBM; }
/*     */   
/*     */   @JsonProperty("lqxzmc")
/*     */   public String getLQXZMC() {
/* 300 */     return this.LQXZMC;
/*     */   }
/*     */   
/* 303 */   public void setLQXZMC(String lQXZMC) { this.LQXZMC = lQXZMC; }
/*     */   
/*     */   @JsonProperty("shnd")
/*     */   public String getSHND() {
/* 307 */     return this.SHND;
/*     */   }
/*     */   
/* 310 */   public void setSHND(String sHND) { this.SHND = sHND; }
/*     */   
/*     */   @JsonProperty("lsgb")
/*     */   public String getLSGB() {
/* 314 */     return this.LSGB;
/*     */   }
/*     */   
/* 317 */   public void setLSGB(String lSGB) { this.LSGB = lSGB; }
/*     */   
/*     */   @JsonProperty("lscd")
/*     */   public String getLSCD() {
/* 321 */     return this.LSCD;
/*     */   }
/*     */   
/* 324 */   public void setLSCD(String lSCD) { this.LSCD = lSCD; }
/*     */   
/*     */   @JsonProperty("hyjg")
/*     */   public Integer getHYJG() {
/* 328 */     return this.HYJG;
/*     */   }
/*     */   
/* 331 */   public void setHYJG(Integer hYJG) { this.HYJG = hYJG; }
/*     */   
/*     */   @JsonProperty("zjkl")
/*     */   public Integer getZJKL() {
/* 335 */     return this.ZJKL;
/*     */   }
/*     */   
/* 338 */   public void setZJKL(Integer zJKL) { this.ZJKL = zJKL; }
/*     */   
/*     */   @JsonProperty("mz")
/*     */   public Long getMZ() {
/* 342 */     return this.MZ;
/*     */   }
/*     */   
/* 345 */   public void setMZ(Long mZ) { this.MZ = mZ; }
/*     */   
/*     */   @JsonProperty("mzjby")
/*     */   public String getMZJBY() {
/* 349 */     return this.MZJBY;
/*     */   }
/*     */   
/* 352 */   public void setMZJBY(String mZJBY) { this.MZJBY = mZJBY; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("mzjlsj")
/*     */   public Date getMZJLSJ() {
/* 357 */     return this.MZJLSJ;
/*     */   }
/*     */   
/* 360 */   public void setMZJLSJ(Date mZJLSJ) { this.MZJLSJ = mZJLSJ; }
/*     */   
/*     */   @JsonProperty("bgykl")
/*     */   public Long getBGYKL() {
/* 364 */     return this.BGYKL;
/*     */   }
/*     */   
/* 367 */   public void setBGYKL(Long bGYKL) { this.BGYKL = bGYKL; }
/*     */   
/*     */   @JsonProperty("bgyxm")
/*     */   public String getBGYXM() {
/* 371 */     return this.BGYXM;
/*     */   }
/*     */   
/* 374 */   public void setBGYXM(String bGYXM) { this.BGYXM = bGYXM; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("qrsj")
/*     */   public Date getQRSJ() {
/* 379 */     return this.QRSJ;
/*     */   }
/*     */   
/* 382 */   public void setQRSJ(Date qRSJ) { this.QRSJ = qRSJ; }
/*     */   
/*     */   @JsonProperty("pz")
/*     */   public Long getPZ() {
/* 386 */     return this.PZ;
/*     */   }
/*     */   
/* 389 */   public void setPZ(Long pZ) { this.PZ = pZ; }
/*     */   
/*     */   @JsonProperty("pzjby")
/*     */   public String getPZJBY() {
/* 393 */     return this.PZJBY;
/*     */   }
/*     */   
/* 396 */   public void setPZJBY(String pZJBY) { this.PZJBY = pZJBY; }
/*     */   
/*     */   @JsonProperty("pzjlsj")
/*     */   public Date getPZJLSJ() {
/* 400 */     return this.PZJLSJ;
/*     */   }
/*     */   
/* 403 */   public void setPZJLSJ(Date pZJLSJ) { this.PZJLSJ = pZJLSJ; }
/*     */   
/*     */   @JsonProperty("xczj")
/*     */   public Long getXCZJ() {
/* 407 */     return this.XCZJ;
/*     */   }
/*     */   
/* 410 */   public void setXCZJ(Long xCZJ) { this.XCZJ = xCZJ; }
/*     */   
/*     */   @JsonProperty("jz")
/*     */   public Long getJZ() {
/* 414 */     return this.JZ;
/*     */   }
/*     */   
/* 417 */   public void setJZ(Long jZ) { this.JZ = jZ; }
/*     */   
/*     */   @JsonProperty("jszl")
/*     */   public Long getJSZL() {
/* 421 */     return this.JSZL;
/*     */   }
/*     */   
/* 424 */   public void setJSZL(Long jSZL) { this.JSZL = jSZL; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("jsdj")
/*     */   public BigDecimal getJSDJ() {
/* 429 */     return this.JSDJ;
/*     */   }
/*     */   
/* 432 */   public void setJSDJ(BigDecimal jSDJ) { this.JSDJ = jSDJ; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("jsje")
/*     */   public BigDecimal getJSJE() {
/* 437 */     return this.JSJE;
/*     */   }
/*     */   
/* 440 */   public void setJSJE(BigDecimal jSJE) { this.JSJE = jSJE; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("jssj")
/*     */   public Date getJSSJ() {
/* 445 */     return this.JSSJ;
/*     */   }
/*     */   
/* 448 */   public void setJSSJ(Date jSSJ) { this.JSSJ = jSSJ; }
/*     */   
/*     */   @JsonProperty("jsrxm")
/*     */   public String getJSRXM() {
/* 452 */     return this.JSRXM;
/*     */   }
/*     */   
/* 455 */   public void setJSRXM(String jSRXM) { this.JSRXM = jSRXM; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("cmsj")
/*     */   public Date getCMSJ() {
/* 460 */     return this.CMSJ;
/*     */   }
/*     */   
/* 463 */   public void setCMSJ(Date cMSJ) { this.CMSJ = cMSJ; }
/*     */   
/*     */   @JsonProperty("cmqrmgryxm")
/*     */   public String getCMQRMGRYXM() {
/* 467 */     return this.CMQRMGRYXM;
/*     */   }
/*     */   
/* 470 */   public void setCMQRMGRYXM(String cMQRMGRYXM) { this.CMQRMGRYXM = cMQRMGRYXM; }
/*     */   
/*     */   @JsonProperty("sfsc")
/*     */   public Integer getSFSC() {
/* 474 */     return this.SFSC;
/*     */   }
/*     */   
/* 477 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*     */   
/*     */   @JsonProperty("rmdjzp")
/*     */   public String getRMDJZP() {
/* 481 */     return this.RMDJZP;
/*     */   }
/*     */   
/* 484 */   public void setRMDJZP(String rMDJZP) { this.RMDJZP = rMDJZP; }
/*     */   
/*     */   @JsonProperty("gbzp")
/*     */   public String getGBZP() {
/* 488 */     return this.GBZP;
/*     */   }
/*     */   
/* 491 */   public void setGBZP(String gBZP) { this.GBZP = gBZP; }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjGrainTraffic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */