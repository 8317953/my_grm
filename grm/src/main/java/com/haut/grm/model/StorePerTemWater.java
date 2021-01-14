package com.haut.grm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.base.AbstractEntity;

@Entity
@Table(name="sd_tf_plane_entry")
public class StorePerTemWater  extends AbstractEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7368846462496451723L;


	@ManyToOne
    @JoinColumn(name = "store_id")
	@JsonView(Views.StoreTemWaterEntryToStoreView.class)
	private Store store;
	
	
	@Column(name = "inner_tem")
	@JsonView(Views.StoreTemWaterEntryView.class)
	private Double innertem;
	
	@Column(name = "inner_water")
	@JsonView(Views.StoreTemWaterEntryView.class)
	private Double innerwater;
	
	@Column(name = "outer_tem")
	@JsonView(Views.StoreTemWaterEntryView.class)
	private Double outtem;
	
	@Column(name = "outer_water")
	@JsonView(Views.StoreTemWaterEntryView.class)
	private Double outwater;
	
	@Column(name = "grain_tem")
	@JsonView(Views.StoreTemWaterEntryView.class)
	private Double graintem;
	
	@Column(name = "grain_water")
	@JsonView(Views.StoreTemWaterEntryView.class)
	private Double grainwater;
	
	
	@ManyToOne
    @JoinColumn(name = "tf_plane_id")
	@JsonView(Views.StoreTemWaterEntryToTfPlaneView.class)
	private SdTfPlane sdTfPlane;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Double getInnertem() {
		return innertem;
	}

	public void setInnertem(Double innertem) {
		this.innertem = innertem;
	}

	public Double getInnerwater() {
		return innerwater;
	}

	public void setInnerwater(Double innerwater) {
		this.innerwater = innerwater;
	}

	public Double getOuttem() {
		return outtem;
	}

	public void setOuttem(Double outtem) {
		this.outtem = outtem;
	}

	public Double getOutwater() {
		return outwater;
	}

	public void setOutwater(Double outwater) {
		this.outwater = outwater;
	}

	

	

	public SdTfPlane getSdTfPlane() {
		return sdTfPlane;
	}

	public void setSdTfPlane(SdTfPlane sdTfPlane) {
		this.sdTfPlane = sdTfPlane;
	}

	public Double getGraintem() {
		return graintem;
	}

	public void setGraintem(Double graintem) {
		this.graintem = graintem;
	}

	public Double getGrainwater() {
		return grainwater;
	}

	public void setGrainwater(Double grainwater) {
		this.grainwater = grainwater;
	}
	
	
	
}
