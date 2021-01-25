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
import com.haut.grm.model.type.PlaneProcessType;
import com.haut.grm.model.type.SdSfType;
import com.haut.grm.model.type.SdTfMdType;
import com.haut.grm.model.type.SdTfType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "通风计划")
@Entity
@Table(name="sd_tf_plane")
public class SdTfPlane  extends AbstractEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6632204273717460094L;

	
	@ManyToOne
	@JoinColumn(name = "depot_id")
	@JsonView(Views.SdTfPlaneView.class)
	private Depot depot;
	
	@ApiModelProperty(value = "编号")
	@Column(name = "code")
	@JsonView(Views.SdTfPlaneView.class)
	private String code;
	
	@ApiModelProperty(value = "通风目的")
	@ManyToOne
    @JoinColumn(name = "tf_md")
	@JsonView(Views.SdTfPlaneView.class)
	private SdTfMdType tfmd;
	
	@ApiModelProperty(value = "通风类型")
	@ManyToOne
    @JoinColumn(name = "tf_type")
	@JsonView(Views.SdTfPlaneView.class)
	private SdTfType tftype;
	
	@ApiModelProperty(value = "送风方式")
	@ManyToOne
    @JoinColumn(name = "sf_type")
	@JsonView(Views.SdTfPlaneView.class)
	private SdSfType sftype;
	
	@ApiModelProperty(value = "负责人")
	@ManyToOne
    @JoinColumn(name = "manager_id")
	@JsonView(Views.SdTfPlaneView.class)
	private User manager;
	
	@ApiModelProperty(value = "操作人")
	@ManyToOne
    @JoinColumn(name = "acter_id")
	@JsonView(Views.SdTfPlaneView.class)
	private User acter;
	
	@ApiModelProperty(value = "录入人")
	@ManyToOne
    @JoinColumn(name = "inputer_id")
	@JsonView(Views.SdTfPlaneView.class)
	private User inputer;
	
	@ApiModelProperty(value = "录入时间")
	@Column(name = "input_time")
	@JsonView(Views.SdTfPlaneView.class)
	private Date inputtime;
	
	@ApiModelProperty(value = "开始时间")
	@Column(name = "start_date")
	@JsonView(Views.SdTfPlaneView.class)
	private Date startdate;
	
	@ApiModelProperty(value = "截止时间")
	@Column(name = "end_date")
	@JsonView(Views.SdTfPlaneView.class)
	private Date enddate;
	
	@ApiModelProperty(value = "通风计划")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sdTfPlane")
	@JsonView(Views.SdTfPlaneToEntryView.class)
	private Set<StorePerTemWater> storePerTemWater;
	
	@ApiModelProperty(value = "进度类型")
	@ManyToOne
	@JoinColumn(name = "process_id")
	@JsonView(Views.SdTfPlaneView.class)
	private PlaneProcessType processType;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sdTfPlane")
	@JsonView(Views.SdTfPlaneToTfEquipView.class)
	private Set<SdTfEquipStatus> sdTfEquipStatuses;
	
	
	@JsonView(Views.IdView.class)
	@Column(name = "name")
	private String name;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<SdTfEquipStatus> getSdTfEquipStatuses() {
		return sdTfEquipStatuses;
	}

	public void setSdTfEquipStatuses(Set<SdTfEquipStatus> sdTfEquipStatuses) {
		this.sdTfEquipStatuses = sdTfEquipStatuses;
	}

	public PlaneProcessType getProcessType() {
		return processType;
	}

	public void setProcessType(PlaneProcessType processType) {
		this.processType = processType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SdTfMdType getTfmd() {
		return tfmd;
	}

	public void setTfmd(SdTfMdType tfmd) {
		this.tfmd = tfmd;
	}

	public SdTfType getTftype() {
		return tftype;
	}

	public void setTftype(SdTfType tftype) {
		this.tftype = tftype;
	}

	public SdSfType getSftype() {
		return sftype;
	}

	public void setSftype(SdSfType sftype) {
		this.sftype = sftype;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public User getActer() {
		return acter;
	}

	public void setActer(User acter) {
		this.acter = acter;
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


	


	public Set<StorePerTemWater> getStorePerTemWater() {
		return storePerTemWater;
	}

	public void setStorePerTemWater(Set<StorePerTemWater> storePerTemWater) {
		this.storePerTemWater = storePerTemWater;
	}

	public Depot getDepot() {
		return depot;
	}

	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	
	
	
}
