package com.haut.grm.model.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.haut.grm.model.CargoRepView;
import com.haut.grm.model.base.AbstractBusiness;
import com.haut.grm.model.standard.code.GrainVariety;
import com.haut.grm.model.type.GrainType;

@Entity
@Table(name="my_stock_sum_history")
public class MyStockSumHistory extends AbstractBusiness{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -861378844727395750L;

	@ManyToOne
	@JoinColumn(name="grain_variety_id")
	private GrainVariety gv;
	
	@ManyToOne
	@JoinColumn(name="grain_type_id")
	private GrainType gt;
	
	@Column(name="year")
	private String year;
	
	
	@Column(name="amount")
	private Long amount;
	
	@Column(name="in_amount")
	private Long inamount;
	
	@Column(name="out_amount")
	private Long outamount;
	
	@Column(name="location")
	private String location;
	
	@ManyToOne
	@JoinColumn(name="cargo_id")
	private CargoRepView cargo;

	public GrainVariety getGv() {
		return gv;
	}

	public void setGv(GrainVariety gv) {
		this.gv = gv;
	}

	public GrainType getGt() {
		return gt;
	}

	public void setGt(GrainType gt) {
		this.gt = gt;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getInamount() {
		return inamount;
	}

	public void setInamount(Long inamount) {
		this.inamount = inamount;
	}

	public Long getOutamount() {
		return outamount;
	}

	public void setOutamount(Long outamount) {
		this.outamount = outamount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public CargoRepView getCargo() {
		return cargo;
	}

	public void setCargo(CargoRepView cargo) {
		this.cargo = cargo;
	}
	
	
	
	
	
}
