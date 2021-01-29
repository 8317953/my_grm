package com.haut.grm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;
import com.haut.grm.model.type.QtCdType;


@Entity
@Table(name="qt_cd_model")
public class QtCdModel  extends AbstractEntity<Long>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5711750980159656607L;

	@Column(name = "code_id")
	@JsonView({Views.IdView.class})
	private Integer codeid;
	
	@Column(name = "code")
	@JsonView({Views.IdView.class})
	private String code;
	
	
	
	@ManyToOne
	@JoinColumn(name = "cd_type_id")
	@JsonView({Views.IdView.class})
	private QtCdType qtcdtype;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	@JsonView({Views.QtCdModelView.class})
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "fm1")
	@JsonView({Views.QtCdModelView.class})
	private QtFm fm1;
	
	@ManyToOne
	@JoinColumn(name = "fm2")
	@JsonView({Views.QtCdModelView.class})
	private QtFm fm2;
	
	@ManyToOne
	@JoinColumn(name = "fm3")
	@JsonView({Views.QtCdModelView.class})
	private QtFm fm3;
	
	@ManyToOne
	@JoinColumn(name = "fm4")
	@JsonView({Views.QtCdModelView.class})
	private QtFm fm4;
	
	@ManyToOne
	@JoinColumn(name = "fm5")
	@JsonView({Views.QtCdModelView.class})
	private QtFm fm5;
	
	@ManyToOne
	@JoinColumn(name = "fm6")
	@JsonView({Views.QtCdModelView.class})
	private QtFm fm6;
	
	@ManyToOne
	@JoinColumn(name = "fm7")
	@JsonView({Views.QtCdModelView.class})
	private QtFm fm7;
	
	@ManyToOne
	@JoinColumn(name = "fm8")
	@JsonView({Views.QtCdModelView.class})
	private QtFm fm8;
	
	@ManyToOne
	@JoinColumn(name = "fm9")
	@JsonView({Views.QtCdModelView.class})
	private QtFm fm9;
	
	@ManyToOne
	@JoinColumn(name = "fm10")
	@JsonView({Views.QtCdModelView.class})
	private QtFm fm10;

	public Integer getCodeid() {
		return codeid;
	}

	public void setCodeid(Integer codeid) {
		this.codeid = codeid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public QtCdType getQtcdtype() {
		return qtcdtype;
	}

	public void setQtcdtype(QtCdType qtcdtype) {
		this.qtcdtype = qtcdtype;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public QtFm getFm1() {
		return fm1;
	}

	public void setFm1(QtFm fm1) {
		this.fm1 = fm1;
	}

	public QtFm getFm2() {
		return fm2;
	}

	public void setFm2(QtFm fm2) {
		this.fm2 = fm2;
	}

	public QtFm getFm3() {
		return fm3;
	}

	public void setFm3(QtFm fm3) {
		this.fm3 = fm3;
	}

	public QtFm getFm4() {
		return fm4;
	}

	public void setFm4(QtFm fm4) {
		this.fm4 = fm4;
	}

	public QtFm getFm5() {
		return fm5;
	}

	public void setFm5(QtFm fm5) {
		this.fm5 = fm5;
	}

	public QtFm getFm6() {
		return fm6;
	}

	public void setFm6(QtFm fm6) {
		this.fm6 = fm6;
	}

	public QtFm getFm7() {
		return fm7;
	}

	public void setFm7(QtFm fm7) {
		this.fm7 = fm7;
	}

	public QtFm getFm8() {
		return fm8;
	}

	public void setFm8(QtFm fm8) {
		this.fm8 = fm8;
	}

	public QtFm getFm9() {
		return fm9;
	}

	public void setFm9(QtFm fm9) {
		this.fm9 = fm9;
	}

	public QtFm getFm10() {
		return fm10;
	}

	public void setFm10(QtFm fm10) {
		this.fm10 = fm10;
	}
	
	
	
}
