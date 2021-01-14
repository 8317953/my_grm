package com.haut.grm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;
import com.haut.grm.model.business.Contract;
import com.haut.grm.model.business.StockChange;
import com.haut.grm.model.business.StockId;
import com.haut.grm.model.ies.Analysis;
import com.haut.grm.model.ies.RegisterRecord;

@Entity
@Table(name="sd_my_js_f_s_amount")
@AttributeOverride(name="id", column=@Column(name="myid"))
public class MyFenIesSheet extends AbstractEntity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6193335122199423065L;


	@Column(name="code")
	@JsonView({Views.IdView.class})
	private String code;
	
	
	@Column(name="is_ingress")
	@JsonView({Views.IdView.class})
	private Integer isingress;
	
	@Column(name="stage_id")
	@JsonView({Views.IdView.class})
	private Integer stageid;

	@ManyToOne
	@JoinColumn(name="contract_id")
	@JsonView({Views.IdView.class})
	private Contract contract;
	
	@ManyToOne
	@JoinColumn(name="register_record_id")
	@JsonView({Views.IdView.class})
	private RegisterRecord registerRecord;
	
	
	@ManyToOne
	@JoinColumn(name="analysis_id")
	@JsonView({Views.IdView.class})
	private Analysis analysis;
	
	@Column(name="time")
	@JsonView({Views.IdView.class})
	private Date time;
	
	@Column(name="allow_stage")
	@JsonView({Views.IdView.class})
	private Integer allowstage;
	
	@Column(name="out_time")
	@JsonView({Views.IdView.class})
	private Date outtime;
	
	@ManyToOne
	@JoinColumn(name="stock_id")
	@JsonView({Views.IdView.class})
	private StockId stock;
	
	@OneToOne
	@JoinColumn(name="stock_change_id")
	@JsonView({Views.IdView.class})
	private StockChange stockchange;
	
	@Column(name="f_weight")
	@JsonView({Views.IdView.class})
	private Double fweight;
	
	@Column(name="s_weight")
	@JsonView({Views.IdView.class})
	private Double sweight;
	
	@Column(name="deduct_weight")
	@JsonView({Views.IdView.class})
	private Double deductweight;
	
	
	@Column(name="pack")
	@JsonView({Views.IdView.class})
	private Integer pack;
	
	@Column(name="pack_per_weight")
	@JsonView({Views.IdView.class})
	private Double packperweight;
	
	@Column(name="isecond")
	@JsonView({Views.IdView.class})
	private Integer isecond;
	
	@Column(name="deduct_percentage")
	@JsonView({Views.IdView.class})
	private Double deductpercentage;
	
	@Column(name="pack_total_amount")
	@JsonView({Views.IdView.class})
	private Double packtotalamount;
	
	@Column(name="in_amount")
	@JsonView({Views.IdView.class})
	private Double inamount;
	
	@Column(name="out_amount")
	@JsonView({Views.IdView.class})
	private Double outamount;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getIsingress() {
		return isingress;
	}

	public void setIsingress(Integer isingress) {
		this.isingress = isingress;
	}

	public Integer getStageid() {
		return stageid;
	}

	public void setStageid(Integer stageid) {
		this.stageid = stageid;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public RegisterRecord getRegisterRecord() {
		return registerRecord;
	}

	public void setRegisterRecord(RegisterRecord registerRecord) {
		this.registerRecord = registerRecord;
	}

	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getAllowstage() {
		return allowstage;
	}

	public void setAllowstage(Integer allowstage) {
		this.allowstage = allowstage;
	}

	public Date getOuttime() {
		return outtime;
	}

	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}

	public StockId getStock() {
		return stock;
	}

	public void setStock(StockId stock) {
		this.stock = stock;
	}

	public StockChange getStockchange() {
		return stockchange;
	}

	public void setStockchange(StockChange stockchange) {
		this.stockchange = stockchange;
	}

	public Double getFweight() {
		return fweight;
	}

	public void setFweight(Double fweight) {
		this.fweight = fweight;
	}

	public Double getSweight() {
		return sweight;
	}

	public void setSweight(Double sweight) {
		this.sweight = sweight;
	}

	public Double getDeductweight() {
		return deductweight;
	}

	public void setDeductweight(Double deductweight) {
		this.deductweight = deductweight;
	}

	public Integer getPack() {
		return pack;
	}

	public void setPack(Integer pack) {
		this.pack = pack;
	}

	public Double getPackperweight() {
		return packperweight;
	}

	public void setPackperweight(Double packperweight) {
		this.packperweight = packperweight;
	}

	public Integer getIsecond() {
		return isecond;
	}

	public void setIsecond(Integer isecond) {
		this.isecond = isecond;
	}

	public Double getDeductpercentage() {
		return deductpercentage;
	}

	public void setDeductpercentage(Double deductpercentage) {
		this.deductpercentage = deductpercentage;
	}

	public Double getPacktotalamount() {
		return packtotalamount;
	}

	public void setPacktotalamount(Double packtotalamount) {
		this.packtotalamount = packtotalamount;
	}

	public Double getInamount() {
		return inamount;
	}

	public void setInamount(Double inamount) {
		this.inamount = inamount;
	}

	public Double getOutamount() {
		return outamount;
	}

	public void setOutamount(Double outamount) {
		this.outamount = outamount;
	}
	
	
	
}
