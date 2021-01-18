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
import com.haut.grm.model.meta.User;


@Entity
@Table(name="qt_cd_jl")
public class Qtcdjl  extends AbstractEntity<Long>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1099497691447033570L;

	@Column(name="code_id")
	@JsonView({Views.IdView.class})
	private Integer codeid;
	
	@Column(name="code")
	@JsonView({Views.IdView.class})
	private String code;
	
	@ManyToOne
	@JoinColumn(name="cd_model_id")
	@JsonView({Views.IdView.class})
	private QtCdModel cdmodelid;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	@JsonView({Views.IdView.class})
	private Store storeid;
	
	@Column(name="yushenongdu")
	@JsonView({Views.IdView.class})
	private Double yushenongdu;
	
	@Column(name="endnongdu")
	@JsonView({Views.IdView.class})
	private Double endnongdu;
	
	@Column(name="yusheamount")
	@JsonView({Views.IdView.class})
	private Double yusheamount;
	
	@Column(name="endamount")
	@JsonView({Views.IdView.class})
	private Double endamount;
	
	@Column(name="startdate")
	@JsonView({Views.IdView.class})
	private Date startdate;
	
	@Column(name="enddate")
	@JsonView({Views.IdView.class})
	private Date enddate;
	
	@ManyToOne
	@JoinColumn(name="manager_id")
	@JsonView({Views.IdView.class})
	private User managerid;
	
	@ManyToOne
	@JoinColumn(name="inputer_id")
	@JsonView({Views.IdView.class})
	private User inputerid;
	
	@ManyToOne
	@JoinColumn(name="acter_id")
	@JsonView({Views.IdView.class})
	private User acterid;
	
	@Column(name="inputtime")
	@JsonView({Views.IdView.class})
	private Date inputtime;

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

	public QtCdModel getCdmodelid() {
		return cdmodelid;
	}

	public void setCdmodelid(QtCdModel cdmodelid) {
		this.cdmodelid = cdmodelid;
	}

	public Store getStoreid() {
		return storeid;
	}

	public void setStoreid(Store storeid) {
		this.storeid = storeid;
	}

	public Double getYushenongdu() {
		return yushenongdu;
	}

	public void setYushenongdu(Double yushenongdu) {
		this.yushenongdu = yushenongdu;
	}

	public Double getEndnongdu() {
		return endnongdu;
	}

	public void setEndnongdu(Double endnongdu) {
		this.endnongdu = endnongdu;
	}

	public Double getYusheamount() {
		return yusheamount;
	}

	public void setYusheamount(Double yusheamount) {
		this.yusheamount = yusheamount;
	}

	public Double getEndamount() {
		return endamount;
	}

	public void setEndamount(Double endamount) {
		this.endamount = endamount;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public User getManagerid() {
		return managerid;
	}

	public void setManagerid(User managerid) {
		this.managerid = managerid;
	}

	public User getInputerid() {
		return inputerid;
	}

	public void setInputerid(User inputerid) {
		this.inputerid = inputerid;
	}

	public User getActerid() {
		return acterid;
	}

	public void setActerid(User acterid) {
		this.acterid = acterid;
	}

	public Date getInputtime() {
		return inputtime;
	}

	public void setInputtime(Date inputtime) {
		this.inputtime = inputtime;
	}
	
	

}