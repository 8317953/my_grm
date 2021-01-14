package com.haut.grm.model;



import org.springframework.data.rest.core.config.Projection;



@Projection(name="detail", types={CargoRepView.class})
public abstract interface CargoRepViewDetail
{
	public abstract Long getId();
	
	public abstract Integer getCodeId();
	
	public abstract String getName();
	
	public abstract String getReadableName();
	
	public abstract String getCode();
	
	public abstract String getStatusName();
	
	public abstract String getStoreName();
	
	public abstract String getDepotAbbrev();
	
	public abstract String getShortName();
	
	public abstract Long getStatusId();
}


