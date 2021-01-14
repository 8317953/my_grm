package com.haut.grm.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={Mydebug.class})
public abstract interface MydebugDetail {

	public abstract  Store getStore();
	
	public abstract Depot getDepot();

	public abstract Compartment getCompartment();

	public abstract String getContent();

	public abstract String getUrl();

}
