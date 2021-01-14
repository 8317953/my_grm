/*     */ package com.haut.grm.model.ies;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.AnalysisView;
import com.haut.grm.model.AnaMoban;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.meta.User;
/*     */ import com.haut.grm.model.type.AnalysisLevel;
/*     */ import com.haut.grm.model.type.Country;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import org.springframework.data.rest.core.annotation.Description;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="ies_analysis")
/*     */ public class Analysis
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = -7416799308588629871L;
/*     */   @Column(name="barcode")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private String barcode;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="sampler_id")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private User sampler;
/*     */   @Column(name="sample_time")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date sampleTime;
/*     */   @Column(name="sample_comment")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private String sampleComment;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="analyst_id")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private User analyst;
/*     */   @Column(name="analysis_time")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date analysisTime;
/*     */   @Column(name="analysis_comment")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private String analysisComment;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="analysis_level_id")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private AnalysisLevel analysisLevel;
/*     */   @Column(name="pass")
/*     */   @JsonView({Views.AnalysisView.class})
/*  70 */   private Boolean pass = Boolean.valueOf(true);
/*     */   
/*     */   @Column(name="done")
/*     */   @JsonView({Views.AnalysisView.class})
/*  74 */   private Boolean done = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name="a1")
/*     */   @Description("通风后水分(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a1;
/*     */   
/*     */   @Column(name="a2")
/*     */   @Description("容重(g/L)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a2;
/*     */   
/*     */   @Column(name="a3")
/*     */   @Description("除杂后杂质(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a3;
/*     */   
/*     */   @Column(name="a1l")
/*     */   @Description("初始水分(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a1l;
/*     */   
/*     */   @Column(name="a3l")
/*     */   @Description("初始杂质(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a3l;
/*     */   
/*     */   @Column(name="a4")
/*     */   @Description("互混率(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a4;
/*     */   
/*     */   @Column(name="a5")
/*     */   @Description("出糙率(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a5;
/*     */   
/*     */   @Column(name="a6")
/*     */   @Description("整精米率(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a6;
/*     */   
/*     */   @Column(name="a7")
/*     */   @Description("黄粒米(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a7;
/*     */   
/*     */   @Column(name="a8")
/*     */   @Description("碎米率(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a8;
/*     */   
/*     */   @Column(name="a9")
/*     */   @Description("脂肪酸值(KOH/千基)/(mg/100g)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a9;
/*     */   
/*     */   @Column(name="a10")
/*     */   @Description("不完善粒(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a10;
/*     */   
/*     */   @Column(name="a11")
/*     */   @Description("面筋吸水量(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a11;
/*     */   
/*     */   @Column(name="a12")
/*     */   @Description("谷外糙米含量(%)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a12;
/*     */   
/*     */   @Column(name="a13")
/*     */   @Description("品尝评分值/分")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Integer a13;
/*     */   
/*     */   @Column(name="a14")
/*     */   @Description("镉(mg/kg)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a14;
/*     */   
/*     */   @Column(name="a15")
/*     */   @Description("酸度、碱液(ml/10g)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a15;
/*     */   
/*     */   @Column(name="a16")
/*     */   @Description("脱氧雪腐镰刀菌烯醇(μg/kg)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a16;
/*     */   
/*     */   @Column(name="a17")
/*     */   @Description("玉米赤霉烯酮(μg/kg)")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Double a17;
/*     */   
/*     */   @Column(name="s1")
/*     */   @Description("色泽、气味")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private String s1;
/*     */   
/*     */   @Column(name="s2")
/*     */   @Description("加工精度")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private String s2;
/*     */   
/*     */   @Column(name="s3")
/*     */   @Description("酸度指示剂法")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private String s3;
/*     */   
/*     */   @Column(name="location")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private String location;
/*     */   
/*     */   @Column(name="year")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private String year;
/*     */   @Column(name="country_id")
/*     */   @JsonView({Views.AnalysisView.class})
/*     */   private Country country;








@Column(name="a18")
@JsonView({Views.AnalysisView.class})
private Double a18;



@Column(name="a19")
@JsonView({Views.AnalysisView.class})
private Double a19;

@Column(name="a20")
@JsonView({Views.AnalysisView.class})
private Double a20;


@Column(name="a21")
@JsonView({Views.AnalysisView.class})
private Double a21;

@Column(name="a22")
@JsonView({Views.AnalysisView.class})
private Double a22;


@Column(name="a23")
@JsonView({Views.AnalysisView.class})
private Double a23;


@Column(name="a24")
@JsonView({Views.AnalysisView.class})
private Double a24;


@Column(name="a25")
@JsonView({Views.AnalysisView.class})
private Double a25;


@Column(name="a26")
@JsonView({Views.AnalysisView.class})
private Double a26;


@Column(name="a27")
@JsonView({Views.AnalysisView.class})
private Double a27;


@Column(name="a28")
@JsonView({Views.AnalysisView.class})
private Double a28;


@Column(name="a29")
@JsonView({Views.AnalysisView.class})
private Double a29;


@Column(name="a30")
@JsonView({Views.AnalysisView.class})
private Double a30;


@Column(name="a31")
@JsonView({Views.AnalysisView.class})
private Double a31;


@Column(name="a32")
@JsonView({Views.AnalysisView.class})
private Double a32;


@Column(name="a33")
@JsonView({Views.AnalysisView.class})
private Double a33;


@Column(name="a34")
@JsonView({Views.AnalysisView.class})
private Double a34;


@Column(name="a35")
@JsonView({Views.AnalysisView.class})
private Double a35;


@Column(name="a36")
@JsonView({Views.AnalysisView.class})
private Double a36;


@Column(name="a37")
@JsonView({Views.AnalysisView.class})
private Double a37;


@Column(name="a38")
@JsonView({Views.AnalysisView.class})
private Double a38;


@Column(name="a39")
@JsonView({Views.AnalysisView.class})
private Double a39;

public Double getA18() {
	return a18;
}
public void setA18(Double a18) {
	this.a18 = a18;
}
public Double getA19() {
	return a19;
}
public void setA19(Double a19) {
	this.a19 = a19;
}
public Double getA20() {
	return a20;
}
public void setA20(Double a20) {
	this.a20 = a20;
}
public Double getA21() {
	return a21;
}
public void setA21(Double a21) {
	this.a21 = a21;
}
public Double getA22() {
	return a22;
}
public void setA22(Double a22) {
	this.a22 = a22;
}
public Double getA23() {
	return a23;
}
public void setA23(Double a23) {
	this.a23 = a23;
}
public Double getA24() {
	return a24;
}
public void setA24(Double a24) {
	this.a24 = a24;
}
public Double getA25() {
	return a25;
}
public void setA25(Double a25) {
	this.a25 = a25;
}
public Double getA26() {
	return a26;
}
public void setA26(Double a26) {
	this.a26 = a26;
}
public Double getA27() {
	return a27;
}
public void setA27(Double a27) {
	this.a27 = a27;
}
public Double getA28() {
	return a28;
}
public void setA28(Double a28) {
	this.a28 = a28;
}
public Double getA29() {
	return a29;
}
public void setA29(Double a29) {
	this.a29 = a29;
}
public Double getA30() {
	return a30;
}
public void setA30(Double a30) {
	this.a30 = a30;
}
public Double getA31() {
	return a31;
}
public void setA31(Double a31) {
	this.a31 = a31;
}
public Double getA32() {
	return a32;
}
public void setA32(Double a32) {
	this.a32 = a32;
}
public Double getA33() {
	return a33;
}
public void setA33(Double a33) {
	this.a33 = a33;
}
public Double getA34() {
	return a34;
}
public void setA34(Double a34) {
	this.a34 = a34;
}
public Double getA35() {
	return a35;
}
public void setA35(Double a35) {
	this.a35 = a35;
}
public Double getA36() {
	return a36;
}
public void setA36(Double a36) {
	this.a36 = a36;
}
public Double getA37() {
	return a37;
}
public void setA37(Double a37) {
	this.a37 = a37;
}
public Double getA38() {
	return a38;
}
public void setA38(Double a38) {
	this.a38 = a38;
}
public Double getA39() {
	return a39;
}
public void setA39(Double a39) {
	this.a39 = a39;
}
public Double getA40() {
	return a40;
}
public void setA40(Double a40) {
	this.a40 = a40;
}
public AnaMoban getAnamoban() {
	return anamoban;
}
public void setAnamoban(AnaMoban anamoban) {
	this.anamoban = anamoban;
}
public void setA16(Double a16) {
	this.a16 = a16;
}
public void setA17(Double a17) {
	this.a17 = a17;
}
@Column(name="a40")
@JsonView({Views.AnalysisView.class})
private Double a40;

@ManyToOne
@JoinColumn(name="moban_id")
@JsonView({Views.AnalysisView.class})
private AnaMoban anamoban;









/*     */   
/*     */   public Country getCountry()
/*     */   {
/* 199 */     return this.country;
/*     */   }
/*     */   
/*     */   public void setCountry(Country country) {
/* 203 */     this.country = country;
/*     */   }
/*     */   
/*     */   public String getLocation() {
/* 207 */     return this.location;
/*     */   }
/*     */   
/*     */   public void setLocation(String location) {
/* 211 */     this.location = location;
/*     */   }
/*     */   
/*     */   public String getYear() {
/* 215 */     return this.year;
/*     */   }
/*     */   
/*     */   public void setYear(String year) {
/* 219 */     this.year = year;
/*     */   }
/*     */   
/*     */   public Double getA1() {
/* 223 */     return this.a1;
/*     */   }
/*     */   
/*     */   public void setA1(Double a1) {
/* 227 */     this.a1 = a1;
/*     */   }
/*     */   
/*     */   public Double getA2() {
/* 231 */     return this.a2;
/*     */   }
/*     */   
/*     */   public void setA2(Double a2) {
/* 235 */     this.a2 = a2;
/*     */   }
/*     */   
/*     */   public Double getA3() {
/* 239 */     return this.a3;
/*     */   }
/*     */   
/*     */   public void setA3(Double a3) {
/* 243 */     this.a3 = a3;
/*     */   }
/*     */   
/*     */   public String getBarcode() {
/* 247 */     return this.barcode;
/*     */   }
/*     */   
/*     */   public void setBarcode(String barcode) {
/* 251 */     this.barcode = barcode;
/*     */   }
/*     */   
/*     */   public User getSampler() {
/* 255 */     return this.sampler;
/*     */   }
/*     */   
/*     */   public void setSampler(User sampler) {
/* 259 */     this.sampler = sampler;
/*     */   }
/*     */   
/*     */   public Date getSampleTime() {
/* 263 */     return this.sampleTime;
/*     */   }
/*     */   
/*     */   public void setSampleTime(Date sampleTime) {
/* 267 */     this.sampleTime = sampleTime;
/*     */   }
/*     */   
/*     */   public User getAnalyst() {
/* 271 */     return this.analyst;
/*     */   }
/*     */   
/*     */   public void setAnalyst(User analyst) {
/* 275 */     this.analyst = analyst;
/*     */   }
/*     */   
/*     */   public Date getAnalysisTime() {
/* 279 */     return this.analysisTime;
/*     */   }
/*     */   
/*     */   public void setAnalysisTime(Date analysisTime) {
/* 283 */     this.analysisTime = analysisTime;
/*     */   }
/*     */   
/*     */   public AnalysisLevel getAnalysisLevel() {
/* 287 */     return this.analysisLevel;
/*     */   }
/*     */   
/*     */   public void setAnalysisLevel(AnalysisLevel analysisLevel) {
/* 291 */     this.analysisLevel = analysisLevel;
/*     */   }
/*     */   
/*     */   public Boolean getPass() {
/* 295 */     return this.pass;
/*     */   }
/*     */   
/*     */   public void setPass(Boolean pass) {
/* 299 */     this.pass = pass;
/*     */   }
/*     */   
/*     */   public Boolean getDone() {
/* 303 */     return this.done;
/*     */   }
/*     */   
/*     */   public void setDone(Boolean done) {
/* 307 */     this.done = done;
/*     */   }
/*     */   
/*     */   public String getSampleComment() {
/* 311 */     return this.sampleComment;
/*     */   }
/*     */   
/*     */   public void setSampleComment(String sampleComment) {
/* 315 */     this.sampleComment = sampleComment;
/*     */   }
/*     */   
/*     */   public String getAnalysisComment() {
/* 319 */     return this.analysisComment;
/*     */   }
/*     */   
/*     */   public void setAnalysisComment(String analysisComment) {
/* 323 */     this.analysisComment = analysisComment;
/*     */   }
/*     */   
/*     */   public Double getA4() {
/* 327 */     return this.a4;
/*     */   }
/*     */   
/*     */   public void setA4(Double a4) {
/* 331 */     this.a4 = a4;
/*     */   }
/*     */   
/*     */   public Double getA5() {
/* 335 */     return this.a5;
/*     */   }
/*     */   
/*     */   public void setA5(Double a5) {
/* 339 */     this.a5 = a5;
/*     */   }
/*     */   
/*     */   public Double getA6() {
/* 343 */     return this.a6;
/*     */   }
/*     */   
/*     */   public void setA6(Double a6) {
/* 347 */     this.a6 = a6;
/*     */   }
/*     */   
/*     */   public Double getA7() {
/* 351 */     return this.a7;
/*     */   }
/*     */   
/*     */   public void setA7(Double a7) {
/* 355 */     this.a7 = a7;
/*     */   }
/*     */   
/*     */   public Double getA8() {
/* 359 */     return this.a8;
/*     */   }
/*     */   
/*     */   public void setA8(Double a8) {
/* 363 */     this.a8 = a8;
/*     */   }
/*     */   
/*     */   public Double getA9() {
/* 367 */     return this.a9;
/*     */   }
/*     */   
/*     */   public void setA9(Double a9) {
/* 371 */     this.a9 = a9;
/*     */   }
/*     */   
/*     */   public Double getA10() {
/* 375 */     return this.a10;
/*     */   }
/*     */   
/*     */   public void setA10(Double a10) {
/* 379 */     this.a10 = a10;
/*     */   }
/*     */   
/*     */   public Double getA11() {
/* 383 */     return this.a11;
/*     */   }
/*     */   
/*     */   public void setA11(Double a11) {
/* 387 */     this.a11 = a11;
/*     */   }
/*     */   
/*     */   public Double getA12() {
/* 391 */     return this.a12;
/*     */   }
/*     */   
/*     */   public void setA12(Double a12) {
/* 395 */     this.a12 = a12;
/*     */   }
/*     */   
/*     */   public Integer getA13() {
/* 399 */     return this.a13;
/*     */   }
/*     */   
/*     */   public void setA13(Integer a13) {
/* 403 */     this.a13 = a13;
/*     */   }
/*     */   
/*     */   public Double getA14() {
/* 407 */     return this.a14;
/*     */   }
/*     */   
/*     */   public void setA14(Double a14) {
/* 411 */     this.a14 = a14;
/*     */   }
/*     */   
/*     */   public Double getA15() {
/* 415 */     return this.a15;
/*     */   }
/*     */   
/*     */   public void setA15(Double a15) {
/* 419 */     this.a15 = a15;
/*     */   }
/*     */   
/*     */   public String getS1() {
/* 423 */     return this.s1;
/*     */   }
/*     */   
/*     */   public void setS1(String s1) {
/* 427 */     this.s1 = s1;
/*     */   }
/*     */   
/*     */   public String getS2() {
/* 431 */     return this.s2;
/*     */   }
/*     */   
/*     */   public void setS2(String s2) {
/* 435 */     this.s2 = s2;
/*     */   }
/*     */   
/*     */   public String getS3() {
/* 439 */     return this.s3;
/*     */   }
/*     */   
/*     */   public void setS3(String s3) {
/* 443 */     this.s3 = s3;
/*     */   }
/*     */   
/*     */   public Double getA1l() {
/* 447 */     return this.a1l;
/*     */   }
/*     */   
/*     */   public void setA1l(Double a1l) {
/* 451 */     this.a1l = a1l;
/*     */   }
/*     */   
/*     */   public Double getA3l() {
/* 455 */     return this.a3l;
/*     */   }
/*     */   
/*     */   public void setA3l(Double a3l) {
/* 459 */     this.a3l = a3l;
/*     */   }
/*     */
public Double getA16() {
	return a16;
}
public Double getA17() {
	return a17;
}   




/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\Analysis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */