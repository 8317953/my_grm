//package com.haut.grm.model;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonView;
//import com.haut.grm.json.view.Views;
//import com.haut.grm.model.base.AbstractEntity;
//
//
//
//@Entity
//@Table(name="gb_history_stock_amount")
//public class Gbhistorystockamount   extends AbstractEntity<Long>  {
//
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -8353801300237427294L;
//
//	@Column(name="amount")
//	@JsonView({Views.IdView.class})
//	private Double amount;
//	
//	@Column(name="input_time")
//	@JsonView({Views.IdView.class})
//	private Date input_time;
//	
//	@Column(name="stock_id")
//	@JsonView({Views.IdView.class})
//	private int stockid;
//	
//	@Column(name="inorout")
//	@JsonView({Views.IdView.class})
//	private int inorout;
//	
//	@Column(name="businesskey")
//	@JsonView({Views.IdView.class})
//	private String businesskey;
//	
//
//	public String getBusinesskey() {
//		return businesskey;
//	}
//
//	public void setBusinesskey(String businesskey) {
//		this.businesskey = businesskey;
//	}
//
//	public Double getAmount() {
//		return amount;
//	}
//
//	public void setAmount(Double amount) {
//		this.amount = amount;
//	}
//
//	public Date getInput_time() {
//		return input_time;
//	}
//
//	public void setInput_time(Date input_time) {
//		this.input_time = input_time;
//	}
//
//	public int getStockid() {
//		return stockid;
//	}
//
//	public void setStockid(int stockid) {
//		this.stockid = stockid;
//	}
//
//	public int getInorout() {
//		return inorout;
//	}
//
//	public void setInorout(int inorout) {
//		this.inorout = inorout;
//	}
//	
//	
//	
//}
