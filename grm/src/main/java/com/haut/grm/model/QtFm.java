package com.haut.grm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;


@Entity
@Table(name="qt_cd_fm")
public class QtFm  extends AbstractEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4030080771256599302L;

	@Column(name="code_id")
	@JsonView({Views.IdView.class})
	private Integer codeid;
	
	@Column(name="code")
	@JsonView({Views.IdView.class})
	private String code;
	
	@Column(name="name")
	@JsonView({Views.IdView.class})
	private String name;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	@JsonView({Views.QtFmView.class})
	private Store store;
	
	@Column(name="ip")
	@JsonView({Views.IdView.class})
	private String ip;
	
	@Column(name="port")
	@JsonView({Views.IdView.class})
	private Integer port;
	
	@Column(name="com")
	@JsonView({Views.IdView.class})
	private String com;

	public Integer getCodeid() {
		return codeid;
	}

	public void setCodeid(Integer codeid) {
		this.codeid = codeid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
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

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	
	
	
}
