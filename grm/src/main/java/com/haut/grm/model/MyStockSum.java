package com.haut.grm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;

@Entity
@Table(name="my_current_stock3")
public class MyStockSum   extends AbstractEntity<Long> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4317073631743670498L;
	@Column(name="hasamount")
	@JsonView({Views.IdView.class})
	private Double hasamount;
	
	@Column(name="amount")
	@JsonView({Views.IdView.class})
	private Double amount;
	
	
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@OneToOne
    @JoinColumn(name = "cargo_id")
	@JsonView({Views.IdView.class})
	private Cargo cargo;
	
	
	@ManyToOne
    @JoinColumn(name = "store_id")
	@JsonView({Views.IdView.class})
	private Store store;
	
	@ManyToOne
    @JoinColumn(name = "depot_id")
	@JsonView({Views.IdView.class})
	private Depot depot;
	
	
	@Column(name="out_amount")
	@JsonView({Views.IdView.class})
	private Double outamount;
	
	@Column(name="in_amount")
	@JsonView({Views.IdView.class})
	private Double inamount;
	
	
	@Column(name="input_time")
	@JsonView({Views.IdView.class})
	private Date inputtime;
	
	
	

	public Date getInputtime() {
		return inputtime;
	}

	public void setInputtime(Date inputtime) {
		this.inputtime = inputtime;
	}

	public Double getOutamount() {
		return outamount;
	}

	public void setOutamount(Double outamount) {
		this.outamount = outamount;
	}

	public Double getInamount() {
		return inamount;
	}

	public void setInamount(Double inamount) {
		this.inamount = inamount;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Depot getDepot() {
		return depot;
	}

	public void setDepot(Depot depot) {
		this.depot = depot;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Double getHasamount() {
		return hasamount;
	}

	public void setHasamount(Double hasamount) {
		this.hasamount = hasamount;
	}
	
	
}
