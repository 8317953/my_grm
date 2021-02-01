package com.haut.grm.model;

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
import com.haut.grm.model.type.QtCdType;


@Entity
@Table(name="qt_cd_model")
public class QtCdModel  extends AbstractEntity<Long>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5711750980159656607L;

	@Column(name = "code_id")
	@JsonView({Views.IdView.class})
	private Integer codeid;
	
	@Column(name = "code")
	@JsonView({Views.IdView.class})
	private String code;
	
	
	
	@ManyToOne
	@JoinColumn(name = "cd_type_id")
	@JsonView({Views.IdView.class})
	private QtCdType qtcdtype;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	@JsonView({Views.QtCdModelView.class})
	private Store store;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cdmodelid")
	@JsonView(Views.QtCdModelFm.class)
	private Set<Qtfmmodel> qtfmmodels;
	
	
	
	

	public Set<Qtfmmodel> getQtfmmodels() {
		return qtfmmodels;
	}

	public void setQtfmmodels(Set<Qtfmmodel> qtfmmodels) {
		this.qtfmmodels = qtfmmodels;
	}

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

	public QtCdType getQtcdtype() {
		return qtcdtype;
	}

	public void setQtcdtype(QtCdType qtcdtype) {
		this.qtcdtype = qtcdtype;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	
	
	
	
}
