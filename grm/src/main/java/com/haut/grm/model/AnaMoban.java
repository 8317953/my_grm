package com.haut.grm.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;

import com.haut.grm.model.standard.code.GrainVariety;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ana_moban")
public class AnaMoban extends AbstractEntity<Long>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2166109609149389330L;

	@ManyToOne
	@JoinColumn(name="variety_id")
	@JsonView({Views.IdView.class})
	private GrainVariety gv;
	
	@Column(name="outintype")
	@JsonView({Views.IdView.class})
	private Integer type;
	
	

	@JoinColumn(name="a1")
	@JsonView({Views.IdView.class})
	private String a1;
	

	
	@JoinColumn(name="a2")
	@JsonView({Views.IdView.class})
	private String a2;
	
	
	
	@JoinColumn(name="a3")
	@JsonView({Views.IdView.class})
	private String a3;
	
	
	
	@JoinColumn(name="a4")
	@JsonView({Views.IdView.class})
	private String a4;
	
	
	
	@JoinColumn(name="a5")
	@JsonView({Views.IdView.class})
	private String a5;
	
	
	
	@JoinColumn(name="a6")
	@JsonView({Views.IdView.class})
	private String a6;
	
	
	
	@JoinColumn(name="a7")
	@JsonView({Views.IdView.class})
	private String a7;
	
	
	
	@JoinColumn(name="a8")
	@JsonView({Views.IdView.class})
	private String a8;
	
	
	
	@JoinColumn(name="a9")
	@JsonView({Views.IdView.class})
	private String a9;
	
	
	
	@JoinColumn(name="a10")
	@JsonView({Views.IdView.class})
	private String a10;
	
	
	
	@JoinColumn(name="a11")
	@JsonView({Views.IdView.class})
	private String a11;
	
	
	@JoinColumn(name="a12")
	@JsonView({Views.IdView.class})
	private String a12;
	
	
	
	@JoinColumn(name="a13")
	@JsonView({Views.IdView.class})
	private String a13;
	
	
	
	@JoinColumn(name="a14")
	@JsonView({Views.IdView.class})
	private String a14;
	
	
	
	@JoinColumn(name="a15")
	@JsonView({Views.IdView.class})
	private String a15;
	
	
	
	
	@JoinColumn(name="a16")
	@JsonView({Views.IdView.class})
	private String a16;
	
	
	
	@JoinColumn(name="a17")
	@JsonView({Views.IdView.class})
	private String a17;
	
	
	
	@JoinColumn(name="a18")
	@JsonView({Views.IdView.class})
	private String a18;
	
	
	
	@JoinColumn(name="a19")
	@JsonView({Views.IdView.class})
	private String a19;
	
	
	
	@JoinColumn(name="a20")
	@JsonView({Views.IdView.class})
	private String a20;
	
	
	
	@JoinColumn(name="a21")
	@JsonView({Views.IdView.class})
	private String a21;
	
	
	
	@JoinColumn(name="a22")
	@JsonView({Views.IdView.class})
	private String a22;
	
	
	
	
	@JoinColumn(name="a23")
	@JsonView({Views.IdView.class})
	private String a23;
	
	
	
	@JoinColumn(name="a24")
	@JsonView({Views.IdView.class})
	private String a24;
	
	
	
	@JoinColumn(name="a25")
	@JsonView({Views.IdView.class})
	private String a25;
	
	
	
	
	@JoinColumn(name="a26")
	@JsonView({Views.IdView.class})
	private String a26;
	
	
	
	
	@JoinColumn(name="a27")
	@JsonView({Views.IdView.class})
	private String a27;
	
	
	
	@JoinColumn(name="a28")
	@JsonView({Views.IdView.class})
	private String a28;
	
	
	
	
	@JoinColumn(name="a29")
	@JsonView({Views.IdView.class})
	private String a29;
	
	
	
	
	@JoinColumn(name="a30")
	@JsonView({Views.IdView.class})
	private String a30;
	
	
	
	
	@JoinColumn(name="a31")
	@JsonView({Views.IdView.class})
	private String a31;
	
	
	
	@JoinColumn(name="a32")
	@JsonView({Views.IdView.class})
	private String a32;
	
	
	
	@JoinColumn(name="a33")
	@JsonView({Views.IdView.class})
	private String a33;
	
	
	
	@JoinColumn(name="a34")
	@JsonView({Views.IdView.class})
	private String a34;
	
	
	
	@JoinColumn(name="a35")
	@JsonView({Views.IdView.class})
	private String a35;
	
	
	
	@JoinColumn(name="a36")
	@JsonView({Views.IdView.class})
	private String a36;
	
	
	
	
	@JoinColumn(name="a37")
	@JsonView({Views.IdView.class})
	private String a37;
	
	
	
	
	@JoinColumn(name="a38")
	@JsonView({Views.IdView.class})
	private String a38;
	
	
	
	
	
	@JoinColumn(name="a39")
	@JsonView({Views.IdView.class})
	private String a39;
	
	
	
	
	@JoinColumn(name="a40")
	@JsonView({Views.IdView.class})
	private String a40;



	public GrainVariety getGv() {
		return gv;
	}



	public void setGv(GrainVariety gv) {
		this.gv = gv;
	}



	



	public Integer getType() {
		return type;
	}



	public void setType(Integer type) {
		this.type = type;
	}



	public String getA1() {
		return a1;
	}



	public void setA1(String a1) {
		this.a1 = a1;
	}



	public String getA2() {
		return a2;
	}



	public void setA2(String a2) {
		this.a2 = a2;
	}



	public String getA3() {
		return a3;
	}



	public void setA3(String a3) {
		this.a3 = a3;
	}



	public String getA4() {
		return a4;
	}



	public void setA4(String a4) {
		this.a4 = a4;
	}



	public String getA5() {
		return a5;
	}



	public void setA5(String a5) {
		this.a5 = a5;
	}



	public String getA6() {
		return a6;
	}



	public void setA6(String a6) {
		this.a6 = a6;
	}



	public String getA7() {
		return a7;
	}



	public void setA7(String a7) {
		this.a7 = a7;
	}



	public String getA8() {
		return a8;
	}



	public void setA8(String a8) {
		this.a8 = a8;
	}



	public String getA9() {
		return a9;
	}



	public void setA9(String a9) {
		this.a9 = a9;
	}



	public String getA10() {
		return a10;
	}



	public void setA10(String a10) {
		this.a10 = a10;
	}



	public String getA11() {
		return a11;
	}



	public void setA11(String a11) {
		this.a11 = a11;
	}



	public String getA12() {
		return a12;
	}



	public void setA12(String a12) {
		this.a12 = a12;
	}



	public String getA13() {
		return a13;
	}



	public void setA13(String a13) {
		this.a13 = a13;
	}



	public String getA14() {
		return a14;
	}



	public void setA14(String a14) {
		this.a14 = a14;
	}



	public String getA15() {
		return a15;
	}



	public void setA15(String a15) {
		this.a15 = a15;
	}



	public String getA16() {
		return a16;
	}



	public void setA16(String a16) {
		this.a16 = a16;
	}



	public String getA17() {
		return a17;
	}



	public void setA17(String a17) {
		this.a17 = a17;
	}



	public String getA18() {
		return a18;
	}



	public void setA18(String a18) {
		this.a18 = a18;
	}



	public String getA19() {
		return a19;
	}



	public void setA19(String a19) {
		this.a19 = a19;
	}



	public String getA20() {
		return a20;
	}



	public void setA20(String a20) {
		this.a20 = a20;
	}



	public String getA21() {
		return a21;
	}



	public void setA21(String a21) {
		this.a21 = a21;
	}



	public String getA22() {
		return a22;
	}



	public void setA22(String a22) {
		this.a22 = a22;
	}



	public String getA23() {
		return a23;
	}



	public void setA23(String a23) {
		this.a23 = a23;
	}



	public String getA24() {
		return a24;
	}



	public void setA24(String a24) {
		this.a24 = a24;
	}



	public String getA25() {
		return a25;
	}



	public void setA25(String a25) {
		this.a25 = a25;
	}



	public String getA26() {
		return a26;
	}



	public void setA26(String a26) {
		this.a26 = a26;
	}



	public String getA27() {
		return a27;
	}



	public void setA27(String a27) {
		this.a27 = a27;
	}



	public String getA28() {
		return a28;
	}



	public void setA28(String a28) {
		this.a28 = a28;
	}



	public String getA29() {
		return a29;
	}



	public void setA29(String a29) {
		this.a29 = a29;
	}



	public String getA30() {
		return a30;
	}



	public void setA30(String a30) {
		this.a30 = a30;
	}



	public String getA31() {
		return a31;
	}



	public void setA31(String a31) {
		this.a31 = a31;
	}



	public String getA32() {
		return a32;
	}



	public void setA32(String a32) {
		this.a32 = a32;
	}



	public String getA33() {
		return a33;
	}



	public void setA33(String a33) {
		this.a33 = a33;
	}



	public String getA34() {
		return a34;
	}



	public void setA34(String a34) {
		this.a34 = a34;
	}



	public String getA35() {
		return a35;
	}



	public void setA35(String a35) {
		this.a35 = a35;
	}



	public String getA36() {
		return a36;
	}



	public void setA36(String a36) {
		this.a36 = a36;
	}



	public String getA37() {
		return a37;
	}



	public void setA37(String a37) {
		this.a37 = a37;
	}



	public String getA38() {
		return a38;
	}



	public void setA38(String a38) {
		this.a38 = a38;
	}



	public String getA39() {
		return a39;
	}



	public void setA39(String a39) {
		this.a39 = a39;
	}



	public String getA40() {
		return a40;
	}



	public void setA40(String a40) {
		this.a40 = a40;
	}

	
}

