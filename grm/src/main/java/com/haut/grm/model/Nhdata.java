package com.haut.grm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;
import com.haut.grm.model.type.Nhtype;


@Entity
@Table(name="nh_data")
public class Nhdata  extends AbstractEntity<Long>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4899394586041063810L;

	@Column(name="code_id")
	@JsonView({Views.IdView.class})
	private Integer codeid;
	
	@Column(name="code")
	@JsonView({Views.IdView.class})
	private String code;
	
	@ManyToOne
	@JoinColumn(name="nh_type_id")
	@JsonView({Views.NhdataView.class})
	private Nhtype nhtypeid;
	
	@Column(name="pow")
	@JsonView({Views.IdView.class})
	private Double pow;

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

	public Nhtype getNhtypeid() {
		return nhtypeid;
	}

	public void setNhtypeid(Nhtype nhtypeid) {
		this.nhtypeid = nhtypeid;
	}

	public Double getPow() {
		return pow;
	}

	public void setPow(Double pow) {
		this.pow = pow;
	}

	
	
	
}