package com.haut.grm.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;

@Entity
@Table(name="mydebug")
public class Mydebug extends AbstractEntity<Long> {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5541172584325790249L;


	@OneToOne(cascade={javax.persistence.CascadeType.ALL}, optional=false)
	@JoinColumn(name="store_id")
	@JsonView({Views.IdView.class})
	private Store store;
	
	
	@OneToOne
	@JoinColumn(name="depot_id")
	@JsonView({Views.IdView.class})
	private Depot depot;
	
	
	@OneToOne
	@JoinColumn(name="compent_id")
	@JsonView({Views.IdView.class})
	private Compartment compartment;
	
	
	@JoinColumn(name="content")
	@JsonView({Views.IdView.class})
	private String content;
	
	@JoinColumn(name="url")
	@JsonView({Views.IdView.class})
	private String url;
	
	
	
	
	
	@OneToOne(cascade={javax.persistence.CascadeType.ALL}, optional=false)
	@JoinColumn(name="store2_id")
	@JsonView({Views.IdView.class})
	private Store storem;

	
	
	public Store getStorem() {
		return storem;
	}

	public void setStorem(Store storem) {
		this.storem = storem;
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

	public Compartment getCompartment() {
		return compartment;
	}

	public void setCompartment(Compartment compartment) {
		this.compartment = compartment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	
}
