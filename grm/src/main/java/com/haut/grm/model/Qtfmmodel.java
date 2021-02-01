package com.haut.grm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;


@Entity
@Table(name="qt_fm_model")
public class Qtfmmodel  extends AbstractEntity<Long>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 512347383023168985L;

	@ManyToOne
	@JoinColumn(name="cd_model_id")
	@JsonView({Views.QtfmmodelRefModelView.class})
	private QtCdModel cdmodelid;
	
	@ManyToOne
	@JoinColumn(name="cd_fm_id")
	@JsonView({Views.QtfmmodelView.class})
	private QtFm cdfmid;
	
	@Column(name="status")
	@JsonView({Views.IdView.class})
	private Integer status;

	public QtCdModel getCdmodelid() {
		return cdmodelid;
	}

	public void setCdmodelid(QtCdModel cdmodelid) {
		this.cdmodelid = cdmodelid;
	}

	public QtFm getCdfmid() {
		return cdfmid;
	}

	public void setCdfmid(QtFm cdfmid) {
		this.cdfmid = cdfmid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	
	
}