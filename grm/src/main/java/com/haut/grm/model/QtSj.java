package com.haut.grm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;
import com.haut.grm.model.meta.User;


@Entity
@Table(name="qt_qt_data")
public class QtSj  extends AbstractEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3493020479134797011L;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	@JsonView({Views.QtSjView.class})
	private Store store;

	@Column(name="code")
	@JsonView({Views.IdView.class})
	private String code;
	
	@Column(name="code_id")
	@JsonView({Views.IdView.class})
	private Integer codeId;
	
	@Column(name="o2")
	@JsonView({Views.IdView.class})
	private String o2;
	
	@Column(name="co2")
	@JsonView({Views.IdView.class})
	private String co2;
	
	@Column(name="ph3")
	@JsonView({Views.IdView.class})
	private String ph3;
	
	@Column(name="so2f2")
	@JsonView({Views.IdView.class})
	private String so2f2;
	
	@Column(name="no1")
	@JsonView({Views.IdView.class})
	private String no1;
	
	@Column(name="co1")
	@JsonView({Views.IdView.class})
	private String co1;
	
	@Column(name="gettime")
	@JsonView({Views.IdView.class})
	private Date gettime;
	
	@ManyToOne
	@JoinColumn(name = "inputer")
	@JsonView({Views.IdView.class})
	private User inputer;
	
	@Column(name="inputtime")
	@JsonView({Views.IdView.class})
	private Date inputtime;
	
	@Column(name="n2")
	@JsonView({Views.IdView.class})
	private String n2;
	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCodeId() {
		return codeId;
	}

	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}

	public String getO2() {
		return o2;
	}

	public void setO2(String o2) {
		this.o2 = o2;
	}

	public String getCo2() {
		return co2;
	}

	public void setCo2(String co2) {
		this.co2 = co2;
	}

	public String getPh3() {
		return ph3;
	}

	public void setPh3(String ph3) {
		this.ph3 = ph3;
	}

	public String getSo2f2() {
		return so2f2;
	}

	public void setSo2f2(String so2f2) {
		this.so2f2 = so2f2;
	}

	public String getNo1() {
		return no1;
	}

	public void setNo1(String no1) {
		this.no1 = no1;
	}

	public String getCo1() {
		return co1;
	}

	public void setCo1(String co1) {
		this.co1 = co1;
	}

	public Date getGettime() {
		return gettime;
	}

	public void setGettime(Date gettime) {
		this.gettime = gettime;
	}

	public User getInputer() {
		return inputer;
	}

	public void setInputer(User inputer) {
		this.inputer = inputer;
	}

	public Date getInputtime() {
		return inputtime;
	}

	public void setInputtime(Date inputtime) {
		this.inputtime = inputtime;
	}

	public String getN2() {
		return n2;
	}

	public void setN2(String n2) {
		this.n2 = n2;
	}
	
	
	
	
}
