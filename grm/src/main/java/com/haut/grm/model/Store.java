/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.StoreRefCompartmentView;
/*     */ import com.haut.grm.json.view.Views.StoreRefConfigView;
/*     */ import com.haut.grm.json.view.Views.StoreRefDepotView;
/*     */ import com.haut.grm.json.view.Views.StoreRefDeviceCameraView;
/*     */ import com.haut.grm.json.view.Views.StoreRefDoorView;
/*     */ import com.haut.grm.json.view.Views.StoreRefStatusView;
/*     */ import com.haut.grm.json.view.Views.StoreView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.OrderBy;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="grm_store")
/*     */ public class Store
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = -6914226047083900158L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="depot_id")
/*     */   @JsonView({Views.StoreRefDepotView.class})
/*     */   private Depot depot;
/*     */   @Column(name="code_id")
/*     */   @JsonView({Views.StoreView.class})
/*     */   private Integer codeId;
/*     */   @Column(name="name")
/*     */   @JsonView({Views.StoreView.class})
/*     */   private String name;
/*     */   @Column(name="length")
/*     */   @JsonView({Views.StoreView.class})
/*     */   private Double length;
/*     */   @Column(name="breadth")
/*     */   @JsonView({Views.StoreView.class})
/*     */   private Double breadth;
/*     */   @Column(name="height")
/*     */   @JsonView({Views.StoreView.class})
/*     */   private Double height;
/*     */   @Column(name="grain_height")
/*     */   @JsonView({Views.StoreView.class})
/*     */   private Double grainHeight;
/*     */   @Column(name="actual_volume")
/*     */   @JsonView({Views.StoreView.class})
/*     */   private Long actualVolume;
/*     */   @Column(name="design_volume")
/*     */   @JsonView({Views.StoreView.class})
/*     */   private Long designVolume;
/*     */   @Column(name="longitude")
/*     */   @JsonView({Views.StoreView.class})
/*     */   private Double longitude;
/*     */   @Column(name="latitude")
/*     */   @JsonView({Views.StoreView.class})
/*     */   private Double latitude;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="camera_id")
/*     */   @JsonView({Views.StoreRefDeviceCameraView.class})
/*     */   private DeviceCamera camera;
/*     */   @OneToOne(cascade={javax.persistence.CascadeType.ALL}, optional=false)//主意这个false 代表不可为NULL  true 可选可为空NULL
/*     */   @JoinColumn(name="config_id")
/*     */   @JsonView({Views.StoreRefConfigView.class})
/*     */   private StoreConfig config;
/*     */   @OneToOne(cascade={javax.persistence.CascadeType.ALL}, optional=false)
/*     */   @JsonView({Views.StoreRefStatusView.class})
/*     */   @JoinColumn(name="status_id")
/*     */   private StoreStatus status;
/*     */   @OneToMany(fetch=FetchType.LAZY, mappedBy="store", cascade={javax.persistence.CascadeType.ALL})
/*     */   @JsonView({Views.StoreRefCompartmentView.class})
/*     */   @OrderBy("codeId ASC")
/*     */   private Set<Compartment> compartments;
/*     */   @OneToMany(fetch=FetchType.LAZY, mappedBy="store", cascade={javax.persistence.CascadeType.ALL})
/*     */   @JsonView({Views.StoreRefDoorView.class})
/*     */   @OrderBy("codeId ASC")
/*     */   private Set<Door> doors;

			@OneToMany(fetch=FetchType.EAGER, mappedBy="store")
			@JsonView({Views.StoreRefSdTfSbView.class})
			@OrderBy("id ASC")
			private Set<SdTfSb> sdTfSbs;

			
			
			
			public Set<SdTfSb> getSdTfSbs() {
				return sdTfSbs;
			}
			public void setSdTfSbs(Set<SdTfSb> sdTfSbs) {
				this.sdTfSbs = sdTfSbs;
			}
/*     */   
/*     */   public String getName()
/*     */   {
/*  97 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 101 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Integer getCodeId() {
/* 105 */     return this.codeId;
/*     */   }
/*     */   
/*     */   public void setCodeId(Integer codeId) {
/* 109 */     this.codeId = codeId;
/*     */   }
/*     */   
/*     */   public Double getLength() {
/* 113 */     return this.length;
/*     */   }
/*     */   
/*     */   public void setLength(Double length) {
/* 117 */     this.length = length;
/*     */   }
/*     */   
/*     */   public Double getBreadth() {
/* 121 */     return this.breadth;
/*     */   }
/*     */   
/*     */   public void setBreadth(Double breadth) {
/* 125 */     this.breadth = breadth;
/*     */   }
/*     */   
/*     */   public Double getHeight() {
/* 129 */     return this.height;
/*     */   }
/*     */   
/*     */   public void setHeight(Double height) {
/* 133 */     this.height = height;
/*     */   }
/*     */   
/*     */   public Double getGrainHeight() {
/* 137 */     return this.grainHeight;
/*     */   }
/*     */   
/*     */   public void setGrainHeight(Double grainHeight) {
/* 141 */     this.grainHeight = grainHeight;
/*     */   }
/*     */   
/*     */   public Long getActualVolume() {
/* 145 */     return this.actualVolume;
/*     */   }
/*     */   
/*     */   public void setActualVolume(Long actualVolume) {
/* 149 */     this.actualVolume = actualVolume;
/*     */   }
/*     */   
/*     */   public Long getDesignVolume() {
/* 153 */     return this.designVolume;
/*     */   }
/*     */   
/*     */   public void setDesignVolume(Long designVolume) {
/* 157 */     this.designVolume = designVolume;
/*     */   }
/*     */   
/*     */   public Double getLongitude() {
/* 161 */     return this.longitude;
/*     */   }
/*     */   
/*     */   public void setLongitude(Double longitude) {
/* 165 */     this.longitude = longitude;
/*     */   }
/*     */   
/*     */   public Double getLatitude() {
/* 169 */     return this.latitude;
/*     */   }
/*     */   
/*     */   public void setLatitude(Double latitude) {
/* 173 */     this.latitude = latitude;
/*     */   }
/*     */   
/*     */   public DeviceCamera getCamera() {
/* 177 */     return this.camera;
/*     */   }
/*     */   
/*     */   public void setCamera(DeviceCamera camera) {
/* 181 */     this.camera = camera;
/*     */   }
/*     */   
/*     */   public StoreConfig getConfig() {
/* 185 */     return this.config;
/*     */   }
/*     */   
/*     */   public void setConfig(StoreConfig config) {
/* 189 */     this.config = config;
/*     */   }
/*     */   
/*     */   public StoreStatus getStatus() {
/* 193 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(StoreStatus status) {
/* 197 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Set<Door> getDoors() {
/* 201 */     return this.doors;
/*     */   }
/*     */   
/*     */   public void setDoors(Set<Door> doors) {
/* 205 */     this.doors = doors;
/*     */   }
/*     */   
/*     */   public Depot getDepot() {
/* 209 */     return this.depot;
/*     */   }
/*     */   
/*     */   public void setDepot(Depot depot) {
/* 213 */     this.depot = depot;
/*     */   }
/*     */   
/*     */   public Set<Compartment> getCompartments() {
/* 217 */     return this.compartments;
/*     */   }
/*     */   
/*     */   public void setCompartments(Set<Compartment> compartments) {
/* 221 */     this.compartments = compartments;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\Store.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */