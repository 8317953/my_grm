package com.haut.grm.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;
import com.haut.grm.model.business.Contract;
import com.haut.grm.model.meta.User;
import com.haut.grm.model.standard.code.GrainVariety;

import com.haut.grm.model.type.GrainType;

import com.haut.grm.model.type.PlanType;
import com.haut.grm.model.type.PlaneDwType;
import com.haut.grm.model.type.PlaneProcessType;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="gb_plane")
public class Plane extends AbstractEntity<Long>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5519653350776427077L;



	@ManyToOne
	@JoinColumn(name="plane_type")
	@JsonView({Views.IdView.class})
	private PlanType plane_type;
	
	
	
	@Column(name="plane_name")
	@JsonView({Views.IdView.class})
	private String plane_name;
	
	@Column(name="plane_business")
	@JsonView({Views.IdView.class})
	private String plane_business;
	
	@Column(name="plane_wenhao")
	@JsonView({Views.IdView.class})
	private String plane_wenhao;
	
	@ManyToOne
	@JoinColumn(name="plane_bzdw")
	@JsonView({Views.IdView.class})
	private PlaneDwType plane_bzdw;
	
	@ManyToOne
	@JoinColumn(name="plane_gldw")
	@JsonView({Views.IdView.class})
	private PlaneDwType plane_gldw;
	
	@ManyToOne
	@JoinColumn(name="plane_zxdw")
	@JsonView({Views.IdView.class})
	private PlaneDwType plane_zxdw;
	
	@ManyToOne
	@JoinColumn(name="grain_type")
	@JsonView({Views.IdView.class})
	private GrainType grain_type;
	
	@ManyToOne
	@JoinColumn(name="grain_variety")
	@JsonView({Views.IdView.class})
	private GrainVariety grain_variety;
	
	@Column(name="plane_amount")
	@JsonView({Views.IdView.class})
	private Double plane_amount;
	
	@Column(name="plane_start_date")
	@JsonView({Views.IdView.class})
	private Date plane_start_date;
	
	
	@Column(name="plane_end_date")
	@JsonView({Views.IdView.class})
	private Date plane_end_date;
	
	@Column(name="file_path")
	@JsonView({Views.IdView.class})
	private String file_path;
	
	
	@Column(name="input_time")
	@JsonView({Views.IdView.class})
	private Date input_time;
	
	@ManyToOne
	@JoinColumn(name="input_user")
	@JsonView({Views.IdView.class})
	private User input_user;

	
	@ManyToOne
	@JoinColumn(name="process")
	@JsonView({Views.IdView.class})
	private PlaneProcessType process;
	
	@ManyToOne
	@JoinColumn(name="contract_id")
	@JsonView({Views.IdView.class})
	private Contract contract;
	
	
	
	
	

	public PlaneProcessType getProcess() {
		return process;
	}

	public void setProcess(PlaneProcessType process) {
		this.process = process;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public PlanType getPlane_type() {
		return plane_type;
	}

	public void setPlane_type(PlanType plane_type) {
		this.plane_type = plane_type;
	}

	public String getPlane_name() {
		return plane_name;
	}

	public void setPlane_name(String plane_name) {
		this.plane_name = plane_name;
	}

	public String getPlane_business() {
		return plane_business;
	}

	public void setPlane_business(String plane_business) {
		this.plane_business = plane_business;
	}

	public String getPlane_wenhao() {
		return plane_wenhao;
	}

	public void setPlane_wenhao(String plane_wenhao) {
		this.plane_wenhao = plane_wenhao;
	}

	public PlaneDwType getPlane_bzdw() {
		return plane_bzdw;
	}

	public void setPlane_bzdw(PlaneDwType plane_bzdw) {
		this.plane_bzdw = plane_bzdw;
	}

	public PlaneDwType getPlane_gldw() {
		return plane_gldw;
	}

	public void setPlane_gldw(PlaneDwType plane_gldw) {
		this.plane_gldw = plane_gldw;
	}

	public PlaneDwType getPlane_zxdw() {
		return plane_zxdw;
	}

	public void setPlane_zxdw(PlaneDwType plane_zxdw) {
		this.plane_zxdw = plane_zxdw;
	}

	public GrainType getGrain_type() {
		return grain_type;
	}

	public void setGrain_type(GrainType grain_type) {
		this.grain_type = grain_type;
	}

	public GrainVariety getGrain_variety() {
		return grain_variety;
	}

	public void setGrain_variety(GrainVariety grain_variety) {
		this.grain_variety = grain_variety;
	}

	public Double getPlane_amount() {
		return plane_amount;
	}

	public void setPlane_amount(Double plane_amount) {
		this.plane_amount = plane_amount;
	}

	public Date getPlane_start_date() {
		return plane_start_date;
	}

	public void setPlane_start_date(Date plane_start_date) {
		this.plane_start_date = plane_start_date;
	}

	public Date getPlane_end_date() {
		return plane_end_date;
	}

	public void setPlane_end_date(Date plane_end_date) {
		this.plane_end_date = plane_end_date;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public Date getInput_time() {
		return input_time;
	}

	public void setInput_time(Date input_time) {
		this.input_time = input_time;
	}

	public User getInput_user() {
		return input_user;
	}

	public void setInput_user(User input_user) {
		this.input_user = input_user;
	}
	
	
	
	
}

