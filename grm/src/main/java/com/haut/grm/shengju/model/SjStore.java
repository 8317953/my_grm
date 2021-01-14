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
/*     */ public class SjStore
/*     */ {
/*     */   @Description("企业代码")
/*     */   private String QYDM;
/*     */   @Description("库区编码")
/*     */   private String KQBM;
/*     */   @Description("仓房号")
/*     */   private String CFH;
/*     */   @Description("仓房名称")
/*     */   private String CFMC;
/*     */   @Description("仓型")
/*     */   private String CX;
/*     */   @Description("仓型名称")
/*     */   private String CXMC;
/*     */   @Description("设计仓容")
/*     */   private BigDecimal SJCR;
/*     */   @Description("实际仓容")
/*     */   private BigDecimal SJCRONG;
/*     */   @Description("建成年份")
/*     */   private Date JCRQ;
/*     */   @Description("能否隔热保温")
/*  34 */   private Integer NFGRBW = Integer.valueOf(1);
/*     */   @Description("能否散装储存")
/*  36 */   private Integer NFSZCC = Integer.valueOf(1);
/*     */   @Description("有无防鼠防雀防虫装置及设施")
/*  38 */   private Integer YWFSQCSS = Integer.valueOf(1);
/*     */   @Description("有无防火防爆防盗措施")
/*  40 */   private Integer YWFHFBFDSS = Integer.valueOf(1);
/*     */   @Description("有无粮情检测设施")
/*  42 */   private Integer YWLQJCSS = Integer.valueOf(1);
/*     */   @Description("有无机械通风设施")
/*  44 */   private Integer YWJXTFSS = Integer.valueOf(1);
/*     */   @Description("能否环流熏蒸杀虫")
/*  46 */   private Integer NFHLXZSC = Integer.valueOf(1);
/*     */   @Description("能否富氮低氧气调储粮")
/*  48 */   private Integer NFFDDYQTCL = Integer.valueOf(1);
/*     */   @Description("能否仓外测虫")
/*  50 */   private Integer NFCWCC = Integer.valueOf(0);
/*     */   @Description("储粮方式")
/*  52 */   private Integer CLFS = Integer.valueOf(1);
/*     */   @Description("储粮类型")
/*  54 */   private Integer CLLX = Integer.valueOf(1);
/*     */   @Description("储粮技术")
/*  56 */   private Integer CLJS = Integer.valueOf(1);
/*     */   @Description("温度控制类型")
/*  58 */   private Integer WDKZLX = Integer.valueOf(1);
/*     */   @Description("仓房平面图")
/*     */   private String CFPMT;
/*     */   @Description("仓房是否完好")
/*     */   private Integer CFSFWH;
/*     */   @Description("仓房状态")
/*     */   private Integer CFZT;
/*     */   @Description("使用情况")
/*     */   private Integer SYQK;
/*     */   @Description("仓房_经度")
/*     */   private BigDecimal JD;
/*     */   @Description("仓房_纬度")
/*     */   private BigDecimal WD;
/*     */   @Description("仓库结构地面")
/*     */   private Integer CKJGDM;
/*     */   @Description("仓库结构墙体")
/*     */   private Integer CKJGQT;
/*     */   @Description("仓库结构房顶")
/*     */   private Integer CKJGFD;
/*     */   @Description("仓库结构房架")
/*     */   private Integer CKJGFJ;
/*     */   @Description("仓房长度")
/*     */   private BigDecimal CFCD;
/*     */   @Description("仓房宽度")
/*     */   private BigDecimal CFKD;
/*     */   @Description("檐口高度")
/*     */   private BigDecimal YKGD;
/*     */   @Description("仓外筒仓外直径")
/*     */   private BigDecimal CWTCWJ;
/*     */   @Description("仓内筒仓内直径")
/*     */   private BigDecimal CNTCNJ;
/*     */   @Description("装粮线高度")
/*     */   private BigDecimal ZLXGD;
/*     */   @Description("仓外顶高")
/*     */   private BigDecimal CWDG;
/*     */   @Description("仓内体积")
/*     */   private BigDecimal CNTJ;
/*     */   @Description("粮堆体积")
/*     */   private BigDecimal LDTJ;
/*     */   @Description("仓门数量")
/*     */   private Integer CMSL;
/*     */   @Description("仓门位置")
/* 100 */   private String CMWZ = "0";
/*     */   @Description("仓门高度")
/* 102 */   private BigDecimal CMGD = new BigDecimal(0);
/*     */   @Description("仓门宽度")
/* 104 */   private BigDecimal CMKD = new BigDecimal(0);
/*     */   @Description("启用日期")
/*     */   private Date QYRQ;
/*     */   @Description("保管员编号")
/*     */   private String BGYBH;
/*     */   @Description("保管员名称")
/*     */   private String BGYMC;
/*     */   @Description("备注")
/*     */   private String BZ;
/*     */   @Description("是否代储仓房")
/*     */   private String SFDCCF;
/*     */   @Description("是否删除")
/* 116 */   private Integer SFSC = Integer.valueOf(0);
/*     */   
/*     */   @JsonProperty("qydm")
/*     */   public String getQYDM() {
/* 120 */     return this.QYDM;
/*     */   }
/*     */   
/* 123 */   public void setQYDM(String qYDM) { this.QYDM = qYDM; }
/*     */   
/*     */   @JsonProperty("kqbm")
/*     */   public String getKQBM() {
/* 127 */     return this.KQBM;
/*     */   }
/*     */   
/* 130 */   public void setKQBM(String kQBM) { this.KQBM = kQBM; }
/*     */   
/*     */   @JsonProperty("cfh")
/*     */   public String getCFH() {
/* 134 */     return this.CFH;
/*     */   }
/*     */   
/* 137 */   public void setCFH(String cFH) { this.CFH = cFH; }
/*     */   
/*     */   @JsonProperty("cfmc")
/*     */   public String getCFMC() {
/* 141 */     return this.CFMC;
/*     */   }
/*     */   
/* 144 */   public void setCFMC(String cFMC) { this.CFMC = cFMC; }
/*     */   
/*     */   @JsonProperty("cx")
/*     */   public String getCX() {
/* 148 */     return this.CX;
/*     */   }
/*     */   
/* 151 */   public void setCX(String cX) { this.CX = cX; }
/*     */   
/*     */   @JsonProperty("cxmc")
/*     */   public String getCXMC() {
/* 155 */     return this.CXMC;
/*     */   }
/*     */   
/* 158 */   public void setCXMC(String cXMC) { this.CXMC = cXMC; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("sjcr")
/*     */   public BigDecimal getSJCR() {
/* 163 */     return this.SJCR;
/*     */   }
/*     */   
/* 166 */   public void setSJCR(BigDecimal sJCR) { this.SJCR = sJCR; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("sjcrong")
/*     */   public BigDecimal getSJCRONG() {
/* 171 */     return this.SJCRONG;
/*     */   }
/*     */   
/* 174 */   public void setSJCRONG(BigDecimal sJCRONG) { this.SJCRONG = sJCRONG; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("jcrq")
/*     */   public Date getJCRQ() {
/* 179 */     return this.JCRQ;
/*     */   }
/*     */   
/* 182 */   public void setJCRQ(Date jCRQ) { this.JCRQ = jCRQ; }
/*     */   
/*     */   @JsonProperty("nfgrbw")
/*     */   public Integer getNFGRBW() {
/* 186 */     return this.NFGRBW;
/*     */   }
/*     */   
/* 189 */   public void setNFGRBW(Integer nFGRBW) { this.NFGRBW = nFGRBW; }
/*     */   
/*     */   @JsonProperty("nfszcc")
/*     */   public Integer getNFSZCC() {
/* 193 */     return this.NFSZCC;
/*     */   }
/*     */   
/* 196 */   public void setNFSZCC(Integer nFSZCC) { this.NFSZCC = nFSZCC; }
/*     */   
/*     */   @JsonProperty("ywfsqcss")
/*     */   public Integer getYWFSQCSS() {
/* 200 */     return this.YWFSQCSS;
/*     */   }
/*     */   
/* 203 */   public void setYWFSQCSS(Integer yWFSQCSS) { this.YWFSQCSS = yWFSQCSS; }
/*     */   
/*     */   @JsonProperty("ywfhfbfdss")
/*     */   public Integer getYWFHFBFDSS() {
/* 207 */     return this.YWFHFBFDSS;
/*     */   }
/*     */   
/* 210 */   public void setYWFHFBFDSS(Integer yWFHFBFDSS) { this.YWFHFBFDSS = yWFHFBFDSS; }
/*     */   
/*     */   @JsonProperty("ywlqjcss")
/*     */   public Integer getYWLQJCSS() {
/* 214 */     return this.YWLQJCSS;
/*     */   }
/*     */   
/* 217 */   public void setYWLQJCSS(Integer yWLQJCSS) { this.YWLQJCSS = yWLQJCSS; }
/*     */   
/*     */   @JsonProperty("ywjxtfss")
/*     */   public Integer getYWJXTFSS() {
/* 221 */     return this.YWJXTFSS;
/*     */   }
/*     */   
/* 224 */   public void setYWJXTFSS(Integer yWJXTFSS) { this.YWJXTFSS = yWJXTFSS; }
/*     */   
/*     */   @JsonProperty("nfhlxzsc")
/*     */   public Integer getNFHLXZSC() {
/* 228 */     return this.NFHLXZSC;
/*     */   }
/*     */   
/* 231 */   public void setNFHLXZSC(Integer nFHLXZSC) { this.NFHLXZSC = nFHLXZSC; }
/*     */   
/*     */   @JsonProperty("nffddyqtcl")
/*     */   public Integer getNFFDDYQTCL() {
/* 235 */     return this.NFFDDYQTCL;
/*     */   }
/*     */   
/* 238 */   public void setNFFDDYQTCL(Integer nFFDDYQTCL) { this.NFFDDYQTCL = nFFDDYQTCL; }
/*     */   
/*     */   @JsonProperty("nfcwcc")
/*     */   public Integer getNFCWCC() {
/* 242 */     return this.NFCWCC;
/*     */   }
/*     */   
/* 245 */   public void setNFCWCC(Integer nFCWCC) { this.NFCWCC = nFCWCC; }
/*     */   
/*     */   @JsonProperty("clfs")
/*     */   public Integer getCLFS() {
/* 249 */     return this.CLFS;
/*     */   }
/*     */   
/* 252 */   public void setCLFS(Integer cLFS) { this.CLFS = cLFS; }
/*     */   
/*     */   @JsonProperty("cllx")
/*     */   public Integer getCLLX() {
/* 256 */     return this.CLLX;
/*     */   }
/*     */   
/* 259 */   public void setCLLX(Integer cLLX) { this.CLLX = cLLX; }
/*     */   
/*     */   @JsonProperty("cljs")
/*     */   public Integer getCLJS() {
/* 263 */     return this.CLJS;
/*     */   }
/*     */   
/* 266 */   public void setCLJS(Integer cLJS) { this.CLJS = cLJS; }
/*     */   
/*     */   @JsonProperty("wdkzlx")
/*     */   public Integer getWDKZLX() {
/* 270 */     return this.WDKZLX;
/*     */   }
/*     */   
/* 273 */   public void setWDKZLX(Integer wDKZLX) { this.WDKZLX = wDKZLX; }
/*     */   
/*     */   @JsonProperty("cfpmt")
/*     */   public String getCFPMT() {
/* 277 */     return this.CFPMT;
/*     */   }
/*     */   
/* 280 */   public void setCFPMT(String cFPMT) { this.CFPMT = cFPMT; }
/*     */   
/*     */   @JsonProperty("cfsfwh")
/*     */   public Integer getCFSFWH() {
/* 284 */     return this.CFSFWH;
/*     */   }
/*     */   
/* 287 */   public void setCFSFWH(Integer cFSFWH) { this.CFSFWH = cFSFWH; }
/*     */   
/*     */   @JsonProperty("cfzt")
/*     */   public Integer getCFZT() {
/* 291 */     return this.CFZT;
/*     */   }
/*     */   
/* 294 */   public void setCFZT(Integer cFZT) { this.CFZT = cFZT; }
/*     */   
/*     */   @JsonProperty("syqk")
/*     */   public Integer getSYQK() {
/* 298 */     return this.SYQK;
/*     */   }
/*     */   
/* 301 */   public void setSYQK(Integer sYQK) { this.SYQK = sYQK; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("jd")
/*     */   public BigDecimal getJD() {
/* 306 */     return this.JD;
/*     */   }
/*     */   
/* 309 */   public void setJD(BigDecimal jD) { this.JD = jD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("wd")
/*     */   public BigDecimal getWD() {
/* 314 */     return this.WD;
/*     */   }
/*     */   
/* 317 */   public void setWD(BigDecimal wD) { this.WD = wD; }
/*     */   
/*     */   @JsonProperty("ckjgdm")
/*     */   public Integer getCKJGDM() {
/* 321 */     return this.CKJGDM;
/*     */   }
/*     */   
/* 324 */   public void setCKJGDM(Integer cKJGDM) { this.CKJGDM = cKJGDM; }
/*     */   
/*     */   @JsonProperty("ckjgqt")
/*     */   public Integer getCKJGQT() {
/* 328 */     return this.CKJGQT;
/*     */   }
/*     */   
/* 331 */   public void setCKJGQT(Integer cKJGQT) { this.CKJGQT = cKJGQT; }
/*     */   
/*     */   @JsonProperty("ckjgfd")
/*     */   public Integer getCKJGFD() {
/* 335 */     return this.CKJGFD;
/*     */   }
/*     */   
/* 338 */   public void setCKJGFD(Integer cKJGFD) { this.CKJGFD = cKJGFD; }
/*     */   
/*     */   @JsonProperty("ckjgfj")
/*     */   public Integer getCKJGFJ() {
/* 342 */     return this.CKJGFJ;
/*     */   }
/*     */   
/* 345 */   public void setCKJGFJ(Integer cKJGFJ) { this.CKJGFJ = cKJGFJ; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("cfcd")
/*     */   public BigDecimal getCFCD() {
/* 350 */     return this.CFCD;
/*     */   }
/*     */   
/* 353 */   public void setCFCD(BigDecimal cFCD) { this.CFCD = cFCD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("cfkd")
/*     */   public BigDecimal getCFKD() {
/* 358 */     return this.CFKD;
/*     */   }
/*     */   
/* 361 */   public void setCFKD(BigDecimal cFKD) { this.CFKD = cFKD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("ykgd")
/*     */   public BigDecimal getYKGD() {
/* 366 */     return this.YKGD;
/*     */   }
/*     */   
/* 369 */   public void setYKGD(BigDecimal yKGD) { this.YKGD = yKGD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("cwtcwj")
/*     */   public BigDecimal getCWTCWJ() {
/* 374 */     return this.CWTCWJ;
/*     */   }
/*     */   
/* 377 */   public void setCWTCWJ(BigDecimal cWTCWJ) { this.CWTCWJ = cWTCWJ; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("cntcnj")
/*     */   public BigDecimal getCNTCNJ() {
/* 382 */     return this.CNTCNJ;
/*     */   }
/*     */   
/* 385 */   public void setCNTCNJ(BigDecimal cNTCNJ) { this.CNTCNJ = cNTCNJ; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("zlxgd")
/*     */   public BigDecimal getZLXGD() {
/* 390 */     return this.ZLXGD;
/*     */   }
/*     */   
/* 393 */   public void setZLXGD(BigDecimal zLXGD) { this.ZLXGD = zLXGD; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("cwdg")
/*     */   public BigDecimal getCWDG() {
/* 398 */     return this.CWDG;
/*     */   }
/*     */   
/* 401 */   public void setCWDG(BigDecimal cWDG) { this.CWDG = cWDG; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("cntj")
/*     */   public BigDecimal getCNTJ() {
/* 406 */     return this.CNTJ;
/*     */   }
/*     */   
/* 409 */   public void setCNTJ(BigDecimal cNTJ) { this.CNTJ = cNTJ; }
/*     */   
/*     */   @JsonSerialize(using=SjNumberSerializer.class)
/*     */   @JsonProperty("ldtj")
/*     */   public BigDecimal getLDTJ() {
/* 414 */     return this.LDTJ;
/*     */   }
/*     */   
/* 417 */   public void setLDTJ(BigDecimal lDTJ) { this.LDTJ = lDTJ; }
/*     */   
/*     */   @JsonProperty("cmsl")
/*     */   public Integer getCMSL() {
/* 421 */     return this.CMSL;
/*     */   }
/*     */   
/* 424 */   public void setCMSL(Integer cMSL) { this.CMSL = cMSL; }
/*     */   
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   @JsonProperty("qyrq")
/*     */   public Date getQYRQ() {
/* 429 */     return this.QYRQ;
/*     */   }
/*     */   
/* 432 */   public void setQYRQ(Date qYRQ) { this.QYRQ = qYRQ; }
/*     */   
/*     */   @JsonProperty("bgybh")
/*     */   public String getBGYBH() {
/* 436 */     return this.BGYBH;
/*     */   }
/*     */   
/* 439 */   public void setBGYBH(String bGYBH) { this.BGYBH = bGYBH; }
/*     */   
/*     */   @JsonProperty("bgymc")
/*     */   public String getBGYMC() {
/* 443 */     return this.BGYMC;
/*     */   }
/*     */   
/* 446 */   public void setBGYMC(String bGYMC) { this.BGYMC = bGYMC; }
/*     */   
/*     */   @JsonProperty("bz")
/*     */   public String getBZ() {
/* 450 */     return this.BZ;
/*     */   }
/*     */   
/* 453 */   public void setBZ(String bZ) { this.BZ = bZ; }
/*     */   
/*     */   @JsonProperty("sfdccf")
/*     */   public String getSFDCCF() {
/* 457 */     return this.SFDCCF;
/*     */   }
/*     */   
/* 460 */   public void setSFDCCF(String sFDCCF) { this.SFDCCF = sFDCCF; }
/*     */   
/*     */   @JsonProperty("sfsc")
/*     */   public Integer getSFSC() {
/* 464 */     return this.SFSC;
/*     */   }
/*     */   
/* 467 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*     */   
/*     */   @JsonProperty("cmwz")
/*     */   public String getCMWZ() {
/* 471 */     return this.CMWZ;
/*     */   }
/*     */   
/* 474 */   public void setCMWZ(String cMWZ) { this.CMWZ = cMWZ; }
/*     */   
/*     */   @JsonProperty("cmgd")
/*     */   public BigDecimal getCMGD() {
/* 478 */     return this.CMGD;
/*     */   }
/*     */   
/* 481 */   public void setCMGD(BigDecimal cMGD) { this.CMGD = cMGD; }
/*     */   
/*     */   @JsonProperty("cmkd")
/*     */   public BigDecimal getCMKD() {
/* 485 */     return this.CMKD;
/*     */   }
/*     */   
/* 488 */   public void setCMKD(BigDecimal cMKD) { this.CMKD = cMKD; }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */