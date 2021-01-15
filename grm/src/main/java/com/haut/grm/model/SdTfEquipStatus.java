package com.haut.grm.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;
import com.haut.grm.model.meta.User;
import com.haut.grm.model.type.EquipStatusType;
import com.haut.grm.model.type.PlaneProcessType;
import com.haut.grm.model.type.SdSfType;
import com.haut.grm.model.type.SdTfMdType;
import com.haut.grm.model.type.SdTfType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "设备状态记录")
@Entity
@Table(name="equip_status_table")
public class SdTfEquipStatus  extends AbstractEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3829718118201201933L;


	@ManyToOne
	@JoinColumn(name = "sb_id")
	@JsonView({Views.TfEquipStatusToEquipView.class})
	private SdTfSb tfequip;
	
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	@JsonView({Views.BaseTypeView.class})
	private EquipStatusType equipstatus;
	
	
	@ManyToOne
	@JoinColumn(name = "tf_palne_id")
	@JsonView({Views.TfEquipStatusToTfPlaneView.class})
	private SdTfPlane sdTfPlane;
	
	
	@ManyToOne
	@JoinColumn(name = "tf_data_id")
	@JsonView({Views.TfEquipStatusToTfDataView.class})
	private SdTfDate sdTfDate;
	
	
	@ManyToOne
	@JoinColumn(name = "inputer")
	@JsonView({Views.IdView.class})
	private User inputer;
	
	
	public SdTfPlane getSdTfPlane() {
		return sdTfPlane;
	}


	public void setSdTfPlane(SdTfPlane sdTfPlane) {
		this.sdTfPlane = sdTfPlane;
	}


	public SdTfDate getSdTfDate() {
		return sdTfDate;
	}


	public void setSdTfDate(SdTfDate sdTfDate) {
		this.sdTfDate = sdTfDate;
	}


	@Column(name="inputtime")
	@JsonView({Views.IdView.class})
	private Date inputtime;


	public SdTfSb getTfequip() {
		return tfequip;
	}


	public void setTfequip(SdTfSb tfequip) {
		this.tfequip = tfequip;
	}


	public EquipStatusType getEquipstatus() {
		return equipstatus;
	}


	public void setEquipstatus(EquipStatusType equipstatus) {
		this.equipstatus = equipstatus;
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
	
	
}
