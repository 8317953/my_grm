package com.haut.grm.model;



import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.haut.grm.model.type.CargoStatus;
import com.haut.grm.model.type.PackageCategory;
import com.haut.grm.model.type.PackageType;



@Projection(name="detail", types={MyStockSum.class})
public abstract interface MyStockSumDetail{
	
	public abstract Long getId();
	
	public abstract  Double getOutamount();

	
	public abstract  Double getInamount();


	public abstract Store getStore();


	public abstract Depot getDepot();

	
	public abstract Cargo getCargo();

	public abstract Double getHasamount();


	public abstract Date getInputtime();
	
	public abstract Double getAmount();
	
	
}
