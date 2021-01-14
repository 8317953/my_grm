package com.haut.grm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;

@Entity
@Table(name="my_entry_tem")
public class UntilEntryTem  extends AbstractEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7223217585959450362L;

	@Column(name="data")
	@JsonView({Views.IdView.class})
	private String data;
	
	@Column(name="ymd")
	@JsonView({Views.IdView.class})
	private String ymd;
	
	@ManyToOne
    @JoinColumn(name = "store_id")
	@JsonView({Views.IdView.class})
	private Store store;
	
	@Column(name="time")
	@JsonView({Views.IdView.class})
	private Date time;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
