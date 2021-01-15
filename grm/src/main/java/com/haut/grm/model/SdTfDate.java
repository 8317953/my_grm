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

@Entity
@Table(name="sd_tfjl")
public class SdTfDate  extends AbstractEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8936229661390005182L;


	@Column(name = "code")
	@JsonView(Views.SdTfDateView.class)
	private String code;
	
	
	@ManyToOne
    @JoinColumn(name = "store_id")
	@JsonView(Views.SdTfDateToStoreView.class)
	private Store store;
	
	@Column(name = "pre_innertem")
	@JsonView(Views.SdTfDateView.class)
	private Double preinnertem;
	
	@Column(name = "pre_innerwater")
	@JsonView(Views.SdTfDateView.class)
	private Double preinnerwater;
	
	@Column(name = "preoutertem")
	@JsonView(Views.SdTfDateView.class)
	private Double preoutertem;
	
	@Column(name = "preouterwater")
	@JsonView(Views.SdTfDateView.class)
	private Double preouterwater;
	
	@Column(name = "pregraintem")
	@JsonView(Views.SdTfDateView.class)
	private Double pregraintem;
	
	@Column(name = "pregrainwater")
	@JsonView(Views.SdTfDateView.class)
	private Double pregrainwater;
	
	@Column(name = "afterinnertem")
	@JsonView(Views.SdTfDateView.class)
	private Double afterinnertem;
	
	@Column(name = "afterinnerwater")
	@JsonView(Views.SdTfDateView.class)
	private Double afterinnerwater;
	
	@Column(name = "afteroutertem")
	@JsonView(Views.SdTfDateView.class)
	private Double afteroutertem;
	
	@Column(name = "afterouterwater")
	@JsonView(Views.SdTfDateView.class)
	private Double afterouterwater;
	
	@Column(name = "aftergraintem")
	@JsonView(Views.SdTfDateView.class)
	private Double aftergraintem;
	
	@Column(name = "aftergrainwater")
	@JsonView(Views.SdTfDateView.class)
	private Double aftergrainwater;
	
	@ManyToOne
	@JsonView(Views.SdTfDateToTfPlaneView.class)
    @JoinColumn(name = "tf_plane_id")
	private SdTfPlane sdTfPlane;
	
	
	@Column(name = "input_time")
	@JsonView(Views.SdTfDateView.class)
	private Date inputtime;
	
	@ManyToOne
    @JoinColumn(name = "inputer")
	@JsonView(Views.SdTfDateView.class)
	private User inputer;
	
	@Column(name = "start_time")
	@JsonView(Views.SdTfDateView.class)
	private Date starttime;
	
	@Column(name = "end_time")
	@JsonView(Views.SdTfDateView.class)
	private Date endtime;
	
	@ManyToOne
    @JoinColumn(name = "tf_type")
	@JsonView(Views.SdTfDateView.class)
	private SdTfType tftype;
	
	@ManyToOne
    @JoinColumn(name = "sf_type")
	@JsonView(Views.SdTfDateView.class)
	private SdSfType sftype;
	
	@ManyToOne
    @JoinColumn(name = "tf_md")
	@JsonView(Views.SdTfDateView.class)
	private SdTfMdType tfmd;
	
	@ManyToOne
    @JoinColumn(name = "manager_id")
	@JsonView(Views.SdTfDateView.class)
	private User manager;
	
	@ManyToOne
    @JoinColumn(name = "acter_id")
	@JsonView(Views.SdTfDateView.class)
	private User acter;
	
	
	@ManyToOne
	@JoinColumn(name = "process_id")
	@JsonView(Views.SdTfPlaneView.class)
	private PlaneProcessType processType;

	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sdTfDate")
	@JsonView(Views.SdTfDataToTfEquipView.class)
	private Set<SdTfEquipStatus> sdTfEquipStatuses;
	
	
	
	
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

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Double getPreinnertem() {
		return preinnertem;
	}

	public void setPreinnertem(Double preinnertem) {
		this.preinnertem = preinnertem;
	}

	public Double getPreinnerwater() {
		return preinnerwater;
	}

	public void setPreinnerwater(Double preinnerwater) {
		this.preinnerwater = preinnerwater;
	}

	public Double getPreoutertem() {
		return preoutertem;
	}

	public void setPreoutertem(Double preoutertem) {
		this.preoutertem = preoutertem;
	}

	public Double getPreouterwater() {
		return preouterwater;
	}

	public void setPreouterwater(Double preouterwater) {
		this.preouterwater = preouterwater;
	}

	public Double getPregraintem() {
		return pregraintem;
	}

	public void setPregraintem(Double pregraintem) {
		this.pregraintem = pregraintem;
	}

	public Double getPregrainwater() {
		return pregrainwater;
	}

	public void setPregrainwater(Double pregrainwater) {
		this.pregrainwater = pregrainwater;
	}

	public Double getAfterinnertem() {
		return afterinnertem;
	}

	public void setAfterinnertem(Double afterinnertem) {
		this.afterinnertem = afterinnertem;
	}

	public Double getAfterinnerwater() {
		return afterinnerwater;
	}

	public void setAfterinnerwater(Double afterinnerwater) {
		this.afterinnerwater = afterinnerwater;
	}

	public Double getAfteroutertem() {
		return afteroutertem;
	}

	public void setAfteroutertem(Double afteroutertem) {
		this.afteroutertem = afteroutertem;
	}

	public Double getAfterouterwater() {
		return afterouterwater;
	}

	public void setAfterouterwater(Double afterouterwater) {
		this.afterouterwater = afterouterwater;
	}

	public Double getAftergraintem() {
		return aftergraintem;
	}

	public void setAftergraintem(Double aftergraintem) {
		this.aftergraintem = aftergraintem;
	}

	public Double getAftergrainwater() {
		return aftergrainwater;
	}

	public void setAftergrainwater(Double aftergrainwater) {
		this.aftergrainwater = aftergrainwater;
	}

	public SdTfPlane getSdTfPlane() {
		return sdTfPlane;
	}

	public void setSdTfPlane(SdTfPlane sdTfPlane) {
		this.sdTfPlane = sdTfPlane;
	}

	public Date getInputtime() {
		return inputtime;
	}

	public void setInputtime(Date inputtime) {
		this.inputtime = inputtime;
	}

	public User getInputer() {
		return inputer;
	}

	public void setInputer(User inputer) {
		this.inputer = inputer;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
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

	public SdTfMdType getTfmd() {
		return tfmd;
	}

	public void setTfmd(SdTfMdType tfmd) {
		this.tfmd = tfmd;
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
	
	
	
}
