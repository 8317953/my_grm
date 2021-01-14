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
@Table(name="sd_qingjia")
public class MyQingjia extends AbstractEntity<Long>{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5160892270084609183L;


	@ManyToOne
	@JsonView({Views.UserView.class})
	@JoinColumn(name="start_user")
	private User startuser;
	
	
	@Column(name="tianshu")
	@JsonView({Views.UserView.class})
	private Integer tianshu;
	
	
	@Column(name="start_time")
	@JsonView({Views.UserView.class})
	private Date starttime;
	
	
	@Column(name="bumen")
	@JsonView({Views.UserView.class})
	private String bumen;
	
	@Column(name="yuanyin")
	@JsonView({Views.UserView.class})
	private String yuanyin;
	
	
	@Column(name="cijibeizhu")
	@JsonView({Views.UserView.class})
	private String cijibeizhu;
	
	
	@Column(name="zongjinglibeizhu")
	@JsonView({Views.UserView.class})
	private String zongjinglibeizhu;


	public User getStartuser() {
		return startuser;
	}


	public void setStartuser(User startuser) {
		this.startuser = startuser;
	}


	public Integer getTianshu() {
		return tianshu;
	}


	public void setTianshu(Integer tianshu) {
		this.tianshu = tianshu;
	}


	public Date getStarttime() {
		return starttime;
	}


	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}


	public String getBumen() {
		return bumen;
	}


	public void setBumen(String bumen) {
		this.bumen = bumen;
	}


	public String getYuanyin() {
		return yuanyin;
	}


	public void setYuanyin(String yuanyin) {
		this.yuanyin = yuanyin;
	}


	public String getCijibeizhu() {
		return cijibeizhu;
	}


	public void setCijibeizhu(String cijibeizhu) {
		this.cijibeizhu = cijibeizhu;
	}


	public String getZongjinglibeizhu() {
		return zongjinglibeizhu;
	}


	public void setZongjinglibeizhu(String zongjinglibeizhu) {
		this.zongjinglibeizhu = zongjinglibeizhu;
	}
	
	
}

