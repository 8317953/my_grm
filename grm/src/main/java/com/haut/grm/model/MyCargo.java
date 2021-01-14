package com.haut.grm.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.json.view.Views.CargoRefCompartmentView;
import com.haut.grm.json.view.Views.CargoStatusView;
import com.haut.grm.json.view.Views.CargoView;
import com.haut.grm.json.view.Views.PackageCategoryView;
import com.haut.grm.json.view.Views.PackageTypeView;
import com.haut.grm.model.base.AbstractEntity;
import com.haut.grm.model.meta.User;
import com.haut.grm.model.type.CargoStatus;
import com.haut.grm.model.type.PackageCategory;
import com.haut.grm.model.type.PackageType;
import com.querydsl.core.annotations.QueryInit;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name="grm_cargo")
public class MyCargo extends AbstractEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -105412496668808234L;


	@Column(name="code_id")
	@JsonView({Views.UserView.class})
	private Integer codeid;
	
	
	@Column(name="package_type_id")
	@JsonView({Views.UserView.class})
	private Integer packagetypeid;
	
	@Column(name="active_date")
	@JsonView({Views.UserView.class})
	private Date activedate;
	
	
	@Column(name="name")
	@JsonView({Views.UserView.class})
	private String cargoname;
	
	
	@Column(name="volume")
	@JsonView({Views.UserView.class})
	private Integer volume;
	
	
	@Column(name="package_category_id")
	@JsonView({Views.UserView.class})
	private Integer packagecategoryid;


	


	public Integer getCodeid() {
		return codeid;
	}


	public void setCodeid(Integer codeid) {
		this.codeid = codeid;
	}


	public Integer getPackagetypeid() {
		return packagetypeid;
	}


	public void setPackagetypeid(Integer packagetypeid) {
		this.packagetypeid = packagetypeid;
	}


	public Date getActivedate() {
		return activedate;
	}


	public void setActivedate(Date activedate) {
		this.activedate = activedate;
	}


	public String getCargoname() {
		return cargoname;
	}


	public void setCargoname(String cargoname) {
		this.cargoname = cargoname;
	}


	public Integer getVolume() {
		return volume;
	}


	public void setVolume(Integer volume) {
		this.volume = volume;
	}


	public Integer getPackagecategoryid() {
		return packagecategoryid;
	}


	public void setPackagecategoryid(Integer packagecategoryid) {
		this.packagecategoryid = packagecategoryid;
	}


	
	
	
}

