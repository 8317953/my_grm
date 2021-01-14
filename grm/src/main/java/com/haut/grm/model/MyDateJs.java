package com.haut.grm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;
import com.haut.grm.model.business.StockId;

@Entity
@Table(name="sd_my_js_f_s_amount_current_date")
@AttributeOverride(name="id", column=@Column(name="date_stock"))
public class MyDateJs extends AbstractEntity<String> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4887994494564018817L;


	@ManyToOne
	@JoinColumn(name="stock_id")
	@JsonView({Views.IdView.class})
	private StockId stock;
	
	
	@Column(name="format_out_time")
	@JsonView({Views.IdView.class})
	private Date formatouttime;
	
	@Column(name="total_in_amount")
	@JsonView({Views.IdView.class})
	private Integer inamount;
	
	@Column(name="total_out_amount")
	@JsonView({Views.IdView.class})
	private Integer outamount;
	
	@Column(name="js_amount")
	@JsonView({Views.IdView.class})
	private Integer jsamount;

	public StockId getStock() {
		return stock;
	}

	public void setStock(StockId stock) {
		this.stock = stock;
	}

	public Date getFormatouttime() {
		return formatouttime;
	}

	public void setFormatouttime(Date formatouttime) {
		this.formatouttime = formatouttime;
	}


	public Integer getInamount() {
		return inamount;
	}

	public void setInamount(Integer inamount) {
		this.inamount = inamount;
	}

	public Integer getOutamount() {
		return outamount;
	}

	public void setOutamount(Integer outamount) {
		this.outamount = outamount;
	}

	public Integer getJsamount() {
		return jsamount;
	}

	public void setJsamount(Integer jsamount) {
		this.jsamount = jsamount;
	}
	
	
	
}
