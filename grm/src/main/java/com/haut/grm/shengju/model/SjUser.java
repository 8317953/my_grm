/*     */ package com.haut.grm.shengju.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import com.fasterxml.jackson.annotation.JsonFormat.Shape;
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.util.Date;
/*     */ import org.springframework.data.rest.core.annotation.Description;
/*     */ 
/*     */ 
/*     */ public class SjUser
/*     */ {
/*     */   @Description("人员编号")
/*     */   private String RYBH;
/*     */   @Description("企业代码")
/*     */   private String QYDM;
/*     */   @Description("库区编码")
/*     */   private String KQBM;
/*     */   @Description("姓名")
/*     */   private String XM;
/*     */   @Description("性别")
/*     */   private String XB;
/*     */   @Description("身份证")
/*     */   private String SFZ;
/*     */   @Description("籍贯")
/*     */   private String GJ;
/*     */   @Description("出生日期")
/*     */   private Date CSRQ;
/*     */   @Description("政治面貌")
/*     */   private Integer ZZMM;
/*     */   @Description("人员类型")
/*     */   private String RYLX;
/*     */   @Description("职务")
/*     */   private Integer ZW;
/*     */   @Description("毕业院校")
/*     */   private String BYYX;
/*     */   @Description("学历")
/*     */   private Integer XL;
/*     */   @Description("专业")
/*     */   private Integer ZY;
/*     */   @Description("健康状况")
/*     */   private Integer JKZK;
/*     */   @Description("入职时间")
/*     */   private Date RZSJ;
/*     */   @Description("移动电话")
/*     */   private String YDDH;
/*     */   @Description("固话")
/*     */   private String GH;
/*     */   @Description("邮箱")
/*     */   private String YX;
/*     */   @Description("职称级别")
/*     */   private Integer ZCJB;
/*     */   @Description("工作状态")
/*     */   private Integer GZZT;
/*     */   @Description("是否外请")
/*     */   private Integer SFWQ;
/*     */   @Description("是否删除")
/*  57 */   private Integer SFSC = Integer.valueOf(0);
/*     */   
/*     */   @JsonProperty("rybh")
/*     */   public String getRYBH() {
/*  61 */     return this.RYBH;
/*     */   }
/*     */   
/*  64 */   public void setRYBH(String rYBH) { this.RYBH = rYBH; }
/*     */   
/*     */   @JsonProperty("qydm")
/*     */   public String getQYDM() {
/*  68 */     return this.QYDM;
/*     */   }
/*     */   
/*  71 */   public void setQYDM(String qYDM) { this.QYDM = qYDM; }
/*     */   
/*     */   @JsonProperty("kqbm")
/*     */   public String getKQBM() {
/*  75 */     return this.KQBM;
/*     */   }
/*     */   
/*  78 */   public void setKQBM(String kQBM) { this.KQBM = kQBM; }
/*     */   
/*     */   @JsonProperty("xm")
/*     */   public String getXM() {
/*  82 */     return this.XM;
/*     */   }
/*     */   
/*  85 */   public void setXM(String xM) { this.XM = xM; }
/*     */   
/*     */   @JsonProperty("xb")
/*     */   public String getXB() {
/*  89 */     return this.XB;
/*     */   }
/*     */   
/*  92 */   public void setXB(String xB) { this.XB = xB; }
/*     */   
/*     */   @JsonProperty("sfz")
/*     */   public String getSFZ() {
/*  96 */     return this.SFZ;
/*     */   }
/*     */   
/*  99 */   public void setSFZ(String sFZ) { this.SFZ = sFZ; }
/*     */   
/*     */   @JsonProperty("gj")
/*     */   public String getGJ() {
/* 103 */     return this.GJ;
/*     */   }
/*     */   
/* 106 */   public void setGJ(String gJ) { this.GJ = gJ; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("csrq")
/*     */   public Date getCSRQ() {
/* 111 */     return this.CSRQ;
/*     */   }
/*     */   
/* 114 */   public void setCSRQ(Date cSRQ) { this.CSRQ = cSRQ; }
/*     */   
/*     */   @JsonProperty("zzmm")
/*     */   public Integer getZZMM() {
/* 118 */     return this.ZZMM;
/*     */   }
/*     */   
/* 121 */   public void setZZMM(Integer zZMM) { this.ZZMM = zZMM; }
/*     */   
/*     */   @JsonProperty("rylx")
/*     */   public String getRYLX() {
/* 125 */     return this.RYLX;
/*     */   }
/*     */   
/* 128 */   public void setRYLX(String rYLX) { this.RYLX = rYLX; }
/*     */   
/*     */   @JsonProperty("zw")
/*     */   public Integer getZW() {
/* 132 */     return this.ZW;
/*     */   }
/*     */   
/* 135 */   public void setZW(Integer zW) { this.ZW = zW; }
/*     */   
/*     */   @JsonProperty("byyx")
/*     */   public String getBYYX() {
/* 139 */     return this.BYYX;
/*     */   }
/*     */   
/* 142 */   public void setBYYX(String bYYX) { this.BYYX = bYYX; }
/*     */   
/*     */   @JsonProperty("xl")
/*     */   public Integer getXL() {
/* 146 */     return this.XL;
/*     */   }
/*     */   
/* 149 */   public void setXL(Integer xL) { this.XL = xL; }
/*     */   
/*     */   @JsonProperty("zy")
/*     */   public Integer getZY() {
/* 153 */     return this.ZY;
/*     */   }
/*     */   
/* 156 */   public void setZY(Integer zY) { this.ZY = zY; }
/*     */   
/*     */   @JsonProperty("jkzk")
/*     */   public Integer getJKZK() {
/* 160 */     return this.JKZK;
/*     */   }
/*     */   
/* 163 */   public void setJKZK(Integer jKZK) { this.JKZK = jKZK; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("rzsj")
/*     */   public Date getRZSJ() {
/* 168 */     return this.RZSJ;
/*     */   }
/*     */   
/* 171 */   public void setRZSJ(Date rZSJ) { this.RZSJ = rZSJ; }
/*     */   
/*     */   @JsonProperty("yddh")
/*     */   public String getYDDH() {
/* 175 */     return this.YDDH;
/*     */   }
/*     */   
/* 178 */   public void setYDDH(String yDDH) { this.YDDH = yDDH; }
/*     */   
/*     */   @JsonProperty("gh")
/*     */   public String getGH() {
/* 182 */     return this.GH;
/*     */   }
/*     */   
/* 185 */   public void setGH(String gH) { this.GH = gH; }
/*     */   
/*     */   @JsonProperty("yx")
/*     */   public String getYX() {
/* 189 */     return this.YX;
/*     */   }
/*     */   
/* 192 */   public void setYX(String yX) { this.YX = yX; }
/*     */   
/*     */   @JsonProperty("zcjb")
/*     */   public Integer getZCJB() {
/* 196 */     return this.ZCJB;
/*     */   }
/*     */   
/* 199 */   public void setZCJB(Integer zCJB) { this.ZCJB = zCJB; }
/*     */   
/*     */   @JsonProperty("gzzt")
/*     */   public Integer getGZZT() {
/* 203 */     return this.GZZT;
/*     */   }
/*     */   
/* 206 */   public void setGZZT(Integer gZZT) { this.GZZT = gZZT; }
/*     */   
/*     */   @JsonProperty("sfwq")
/*     */   public Integer getSFWQ() {
/* 210 */     return this.SFWQ;
/*     */   }
/*     */   
/* 213 */   public void setSFWQ(Integer sFWQ) { this.SFWQ = sFWQ; }
/*     */   
/*     */   @JsonProperty("sfsc")
/*     */   public Integer getSFSC() {
/* 217 */     return this.SFSC;
/*     */   }
/*     */   
/* 220 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */