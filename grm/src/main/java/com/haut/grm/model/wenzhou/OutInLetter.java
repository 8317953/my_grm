package com.haut.grm.model.wenzhou;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.Store;
import com.haut.grm.model.base.AbstractEntity;
import com.haut.grm.model.business.Client;
import com.haut.grm.model.business.Contract;
import com.haut.grm.model.meta.User;
import com.haut.grm.model.standard.code.GrainVariety;
import com.haut.grm.model.type.OutInType;
import com.haut.grm.model.type.PlanType;
import com.haut.grm.model.type.PlaneDwType;

@Entity
@Table(name="in_out_letter")
public class OutInLetter extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1005669925697244237L;



	@ManyToOne
	@JoinColumn(name="type")
	@JsonView({Views.IdView.class})
	private OutInType lettertype;
	
	
	@Column(name="name")
	@JsonView({Views.IdView.class})
	private String name;
	
	@Column(name="code_id")
	@JsonView({Views.IdView.class})
	private String code_id;
	
	@Column(name="code")
	@JsonView({Views.IdView.class})
	private String code;
	
	@ManyToOne
	@JoinColumn(name="kddw")
	@JsonView({Views.IdView.class})
	private PlaneDwType kddw;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	@JsonView({Views.IdView.class})
	private Client client;
	
	@Column(name="kdrq")
	@JsonView({Views.IdView.class})
	private Date kdrq;
	
	@ManyToOne
	@JoinColumn(name="gv")
	@JsonView({Views.IdView.class})
	private GrainVariety gv;
	
	
	@Column(name="thsl")
	@JsonView({Views.IdView.class})
	private Double thsl;
	
	
	@Column(name="stsl")
	@JsonView({Views.IdView.class})
	private Double stsl;
	
	@Column(name="sysl")
	@JsonView({Views.IdView.class})
	private Double sysl;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	@JsonView({Views.IdView.class})
	private Store store;
	
	@ManyToOne
	@JoinColumn(name="contract_id")
	@JsonView({Views.IdView.class})
	private Contract contrat;
	
	@ManyToOne
	@JoinColumn(name="create_by")
	@JsonView({Views.IdView.class})
	private User createby;
	
	@Column(name="create_time")
	@JsonView({Views.IdView.class})
	private Date create_time;
	
	@Column(name="dkzj")
	@JsonView({Views.IdView.class})
	private Double dkzj;
	
	
	@Column(name="per_price")
	@JsonView({Views.IdView.class})
	private Double perprice;
	
	
	@Column(name="status")
	@JsonView({Views.IdView.class})
	private int status;
	
	
	@Column(name="last_date")
	@JsonView({Views.IdView.class})
	private Date last_date;
	
	
	


	


	public Date getLast_date() {
		return last_date;
	}


	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}


	public OutInType getLettertype() {
		return lettertype;
	}


	public void setLettertype(OutInType lettertype) {
		this.lettertype = lettertype;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode_id() {
		return code_id;
	}


	public void setCode_id(String code_id) {
		this.code_id = code_id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	


	public PlaneDwType getKddw() {
		return kddw;
	}


	public void setKddw(PlaneDwType kddw) {
		this.kddw = kddw;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Date getKdrq() {
		return kdrq;
	}


	public void setKdrq(Date kdrq) {
		this.kdrq = kdrq;
	}


	public GrainVariety getGv() {
		return gv;
	}


	public void setGv(GrainVariety gv) {
		this.gv = gv;
	}


	public Double getThsl() {
		return thsl;
	}


	public void setThsl(Double thsl) {
		this.thsl = thsl;
	}


	public Double getStsl() {
		return stsl;
	}


	public void setStsl(Double stsl) {
		this.stsl = stsl;
	}


	public Double getSysl() {
		return sysl;
	}


	public void setSysl(Double sysl) {
		this.sysl = sysl;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public Contract getContrat() {
		return contrat;
	}


	public void setContrat(Contract contrat) {
		this.contrat = contrat;
	}


	public User getCreateby() {
		return createby;
	}


	public void setCreateby(User createby) {
		this.createby = createby;
	}


	public Date getCreate_time() {
		return create_time;
	}


	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}


	public Double getDkzj() {
		return dkzj;
	}


	public void setDkzj(Double dkzj) {
		this.dkzj = dkzj;
	}


	public Double getPerprice() {
		return perprice;
	}


	public void setPerprice(Double perprice) {
		this.perprice = perprice;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
}
