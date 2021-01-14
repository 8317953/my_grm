/*     */ package com.haut.grm.model.business;
import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.AnaMoban;
/*     */ 
/*     */ import com.haut.grm.model.base.AbstractBusiness;
/*     */ import com.haut.grm.model.type.AnalysisLevel;
/*     */ import com.haut.grm.model.type.AnalysisType;
/*     */ import com.querydsl.core.annotations.QueryInit;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
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
/*     */ @Table(name="gb_stock_analysis")
/*     */ public class StockAnalysis
/*     */   extends AbstractBusiness
/*     */ {
/*     */   private static final long serialVersionUID = -7221810053328186193L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="stock_id")
/*     */   @Description("货位")
/*     */   @QueryInit({"cargo.compartment.store.depot.*"})
			@JsonView({Views.IdView.class})
/*     */   private StockId stock;

@JsonView({Views.IdView.class})
/*     */   @ManyToOne
/*     */   @JoinColumn(name="analysis_type_id")
/*     */   @Description("化验类型")
/*     */   private AnalysisType type;


@JsonView({Views.IdView.class})
/*     */   @ManyToOne
/*     */   @JoinColumn(name="analysis_level_id")
/*     */   @Description("质量等级")
/*     */   private AnalysisLevel level;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a1")
/*     */   @Description("水分(%)")
/*     */   private Double a1;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a2")
/*     */   @Description("容重(g/L)")
/*     */   private Double a2;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a3")
/*     */   @Description("杂质(%)")
/*     */   private Double a3;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a4")
/*     */   @Description("互混率(%)")
/*     */   private Double a4;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a5")
/*     */   @Description("出糙率(%)")
/*     */   private Double a5;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a6")
/*     */   @Description("整精米率(%)")
/*     */   private Double a6;


@JsonView({Views.IdView.class})
/*     */   @Column(name="a7")
/*     */   @Description("黄粒米(%)")
/*     */   private Double a7;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a8")
/*     */   @Description("碎米率(%)")
/*     */   private Double a8;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a9")
/*     */   @Description("脂肪酸值(KOH/千基)/(mg/100g)")
/*     */   private Double a9;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a10")
/*     */   @Description("不完善粒(%)")
/*     */   private Double a10;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a11")
/*     */   @Description("面筋吸水量(%)")
/*     */   private Double a11;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a12")
/*     */   @Description("谷外糙米含量(%)")
/*     */   private Double a12;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a13")
/*     */   @Description("品尝评分值/分")
/*     */   private Integer a13;


@JsonView({Views.IdView.class})
/*     */   @Column(name="a14")
/*     */   @Description("镉(mg/kg)")
/*     */   private Double a14;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a15")
/*     */   private Double a15;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a16")
/*     */   @Description("脱氧雪腐镰刀菌烯醇(μg/kg)")
/*     */   private Double a16;

@JsonView({Views.IdView.class})
/*     */   @Column(name="a17")
/*     */   @Description("玉米赤霉烯酮(μg/kg)")
/*     */   private Double a17;

@JsonView({Views.IdView.class})
/*     */   @Column(name="s1")
/*     */   @Description("色泽、气味")
/*     */   private String s1;

@JsonView({Views.IdView.class})
/*     */   @Column(name="s2")
/*     */   @Description("加工精度")
/*     */   private String s2;

@JsonView({Views.IdView.class})
/*     */   @Column(name="s3")
/*     */   private String s3;

@JsonView({Views.IdView.class})
/*     */   @Column(name="s4")
/*     */   private String s4;

@JsonView({Views.IdView.class})
/*     */   @Column(name="s5")
/*     */   private String s5;
/*     */   
@JsonView({Views.IdView.class})
@Column(name="a18")
private Double a18;


@JsonView({Views.IdView.class})
@Column(name="a19")
private Double a19;

@JsonView({Views.IdView.class})
@Column(name="a20")
private Double a20;

@JsonView({Views.IdView.class})
@Column(name="a21")
private Double a21;

@JsonView({Views.IdView.class})
@Column(name="a22")
private Double a22;

@JsonView({Views.IdView.class})
@Column(name="a23")
private Double a23;

@JsonView({Views.IdView.class})
@Column(name="a24")
private Double a24;

@JsonView({Views.IdView.class})
@Column(name="a25")
private Double a25;

@JsonView({Views.IdView.class})
@Column(name="a26")
private Double a26;

@JsonView({Views.IdView.class})
@Column(name="a27")
private Double a27;

@JsonView({Views.IdView.class})
@Column(name="a28")
private Double a28;

@JsonView({Views.IdView.class})
@Column(name="a29")
private Double a29;

@JsonView({Views.IdView.class})
@Column(name="a30")
private Double a30;

@JsonView({Views.IdView.class})
@Column(name="a31")
private Double a31;

@JsonView({Views.IdView.class})
@Column(name="a32")
private Double a32;


@JsonView({Views.IdView.class})
@Column(name="a33")
private Double a33;

@JsonView({Views.IdView.class})
@Column(name="a34")
private Double a34;

@JsonView({Views.IdView.class})
@Column(name="a35")
private Double a35;

@JsonView({Views.IdView.class})
@Column(name="a36")
private Double a36;

@JsonView({Views.IdView.class})
@Column(name="a37")
private Double a37;

@JsonView({Views.IdView.class})
@Column(name="a38")
private Double a38;

@JsonView({Views.IdView.class})
@Column(name="a39")
private Double a39;

@JsonView({Views.IdView.class})
@Column(name="a40")
private Double a40;

@ManyToOne
@JsonView({Views.IdView.class})
@JoinColumn(name="moban_id")
private AnaMoban anamoban;





/*     */   public StockId getStock()
/*     */   {
/* 126 */     return this.stock;
/*     */   }
/*     */   
/*     */   public void setStock(StockId stock) {
/* 130 */     this.stock = stock;
/*     */   }
/*     */   
/*     */   public AnalysisType getType() {
/* 134 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(AnalysisType type) {
/* 138 */     this.type = type;
/*     */   }
/*     */   
/*     */   public AnalysisLevel getLevel() {
/* 142 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(AnalysisLevel level) {
/* 146 */     this.level = level;
/*     */   }
/*     */   
/*     */   public Double getA1() {
/* 150 */     return this.a1;
/*     */   }
/*     */   
/*     */   public void setA1(Double a1) {
/* 154 */     this.a1 = a1;
/*     */   }
/*     */   
/*     */   public Double getA2() {
/* 158 */     return this.a2;
/*     */   }
/*     */   
/*     */   public void setA2(Double a2) {
/* 162 */     this.a2 = a2;
/*     */   }
/*     */   
/*     */   public Double getA3() {
/* 166 */     return this.a3;
/*     */   }
/*     */   
/*     */   public void setA3(Double a3) {
/* 170 */     this.a3 = a3;
/*     */   }
/*     */   
/*     */   public Double getA4() {
/* 174 */     return this.a4;
/*     */   }
/*     */   
/*     */   public void setA4(Double a4) {
/* 178 */     this.a4 = a4;
/*     */   }
/*     */   
/*     */   public Double getA5() {
/* 182 */     return this.a5;
/*     */   }
/*     */   
/*     */   public void setA5(Double a5) {
/* 186 */     this.a5 = a5;
/*     */   }
/*     */   
/*     */   public Double getA6() {
/* 190 */     return this.a6;
/*     */   }
/*     */   
/*     */   public void setA6(Double a6) {
/* 194 */     this.a6 = a6;
/*     */   }
/*     */   
/*     */   public Double getA7() {
/* 198 */     return this.a7;
/*     */   }
/*     */   
/*     */   public void setA7(Double a7) {
/* 202 */     this.a7 = a7;
/*     */   }
/*     */   
/*     */   public Double getA8() {
/* 206 */     return this.a8;
/*     */   }
/*     */   
/*     */   public void setA8(Double a8) {
/* 210 */     this.a8 = a8;
/*     */   }
/*     */   
/*     */   public Double getA9() {
/* 214 */     return this.a9;
/*     */   }
/*     */   
/*     */   public void setA9(Double a9) {
/* 218 */     this.a9 = a9;
/*     */   }
/*     */   
/*     */   public Double getA10() {
/* 222 */     return this.a10;
/*     */   }
/*     */   
/*     */   public void setA10(Double a10) {
/* 226 */     this.a10 = a10;
/*     */   }
/*     */   
/*     */   public String getS1() {
/* 230 */     return this.s1;
/*     */   }
/*     */   
/*     */   public void setS1(String s1) {
/* 234 */     this.s1 = s1;
/*     */   }
/*     */   
/*     */   public String getS2() {
/* 238 */     return this.s2;
/*     */   }
/*     */   
/*     */   public void setS2(String s2) {
/* 242 */     this.s2 = s2;
/*     */   }
/*     */   
/*     */   public String getS3() {
/* 246 */     return this.s3;
/*     */   }
/*     */   
/*     */   public void setS3(String s3) {
/* 250 */     this.s3 = s3;
/*     */   }
/*     */   
/*     */   public String getS4() {
/* 254 */     return this.s4;
/*     */   }
/*     */   
/*     */   public void setS4(String s4) {
/* 258 */     this.s4 = s4;
/*     */   }
/*     */   
/*     */   public String getS5() {
/* 262 */     return this.s5;
/*     */   }
/*     */   
/*     */   public void setS5(String s5) {
/* 266 */     this.s5 = s5;
/*     */   }
/*     */   
/*     */   public Double getA11() {
/* 270 */     return this.a11;
/*     */   }
/*     */   
/*     */   public void setA11(Double a11) {
/* 274 */     this.a11 = a11;
/*     */   }
/*     */   
/*     */   public Double getA12() {
/* 278 */     return this.a12;
/*     */   }
/*     */   
/*     */   public void setA12(Double a12) {
/* 282 */     this.a12 = a12;
/*     */   }
/*     */   
/*     */   public Integer getA13() {
/* 286 */     return this.a13;
/*     */   }
/*     */   
/*     */   public void setA13(Integer a13) {
/* 290 */     this.a13 = a13;
/*     */   }
/*     */   
/*     */   public Double getA14() {
/* 294 */     return this.a14;
/*     */   }
/*     */   
/*     */   public void setA14(Double a14) {
/* 298 */     this.a14 = a14;
/*     */   }
/*     */   
/*     */   public Double getA15() {
/* 302 */     return this.a15;
/*     */   }
/*     */   
/*     */   public void setA15(Double a15) {
/* 306 */     this.a15 = a15;
/*     */   }
/*     */
public Double getA16() {
	return a16;
}
public void setA16(Double a16) {
	this.a16 = a16;
}
public Double getA17() {
	return a17;
}
public void setA17(Double a17) {
	this.a17 = a17;
}
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








/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockAnalysis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */