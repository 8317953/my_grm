package com.haut.grm.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;
import com.haut.grm.model.meta.User;
import com.haut.grm.model.type.EquipmenType;
import com.haut.grm.model.type.PlanType;
import com.haut.grm.model.type.PlaneProcessType;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="sd_tf_equip")
public class SdTfSb   extends AbstractEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5604844211632284744L;

	@Column(name="code")
	@JsonView({Views.IdView.class})
	private String code;
	
	@Column(name="code_id")
	@JsonView({Views.IdView.class})
	private Integer codeid;
	
	
	@Column(name="ip")
	@JsonView({Views.IdView.class})
	private String ip;
	
	@Column(name="port")
	@JsonView({Views.IdView.class})
	private Integer port;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	@JsonView({Views.TfToStoreView.class})
	private Store store;
	
	@ManyToOne
	@JoinColumn(name="type")
	@JsonView({Views.IdView.class})
	private EquipmenType equipmenttype;
	
	
	@Column(name="name")
	@JsonView({Views.IdView.class})
	private String name;
	
	@ManyToOne
	@JoinColumn(name="manager")
	@JsonView({Views.IdView.class})
	private User manager;
	
	@ManyToOne
	@JoinColumn(name="inputer")
	@JsonView({Views.IdView.class})
	private User inputer;
	
	
	@Column(name="input_time")
	@JsonView({Views.IdView.class})
	private Date inputtime;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tfequip")
	@JsonView(Views.TfEquipToStatusView.class)
	private Set<SdTfEquipStatus> sdTfEquipStatuses;
	
	
	@Column(name="can_move;")
	@JsonView({Views.IdView.class})
	private Integer canMove;

	

	public Integer getCanMove() {
		return canMove;
	}


	public void setCanMove(Integer canMove) {
		this.canMove = canMove;
	}


	public Set<SdTfEquipStatus> getSdTfEquipStatuses() {
		return sdTfEquipStatuses;
	}


	public void setSdTfEquipStatuses(Set<SdTfEquipStatus> sdTfEquipStatuses) {
		this.sdTfEquipStatuses = sdTfEquipStatuses;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Integer getCodeid() {
		return codeid;
	}


	public void setCodeid(Integer codeid) {
		this.codeid = codeid;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public Integer getPort() {
		return port;
	}


	public void setPort(Integer port) {
		this.port = port;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public EquipmenType getEquipmenttype() {
		return equipmenttype;
	}


	public void setEquipmenttype(EquipmenType equipmenttype) {
		this.equipmenttype = equipmenttype;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public User getManager() {
		return manager;
	}


	public void setManager(User manager) {
		this.manager = manager;
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
