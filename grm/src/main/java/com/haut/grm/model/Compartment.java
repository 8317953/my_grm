/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.CompartmentRefCargoView;
/*     */ import com.haut.grm.json.view.Views.CompartmentRefStoreView;
/*     */ import com.haut.grm.json.view.Views.CompartmentView;
/*     */ import com.haut.grm.json.view.Views.SpaceConditionView;
/*     */ import com.haut.grm.json.view.Views.SpaceStatusView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.type.SpaceCondition;
/*     */ import com.haut.grm.model.type.SpaceStatus;
/*     */ import java.util.Date;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.OrderBy;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="grm_compartment")
/*     */ public class Compartment
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 8673200632918630082L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="store_id")
/*     */   @JsonView({Views.CompartmentRefStoreView.class})
/*     */   private Store store;
/*     */   @Column(name="code_id")
/*     */   @JsonView({Views.CompartmentView.class})
/*     */   private Integer codeId;
/*     */   @Column(name="name")
/*     */   @JsonView({Views.CompartmentView.class})
/*     */   private String name;
/*     */   @Column(name="length")
/*     */   @JsonView({Views.CompartmentView.class})
/*     */   private Double length;
/*     */   @Column(name="breadth")
/*     */   @JsonView({Views.CompartmentView.class})
/*     */   private Double breadth;
/*     */   @Column(name="height")
/*     */   @JsonView({Views.CompartmentView.class})
/*     */   private Double height;
/*     */   @Column(name="grain_height")
/*     */   @JsonView({Views.CompartmentView.class})
/*     */   private Double grainHeight;
/*     */   @Column(name="actual_volume")
/*     */   @JsonView({Views.CompartmentView.class})
/*     */   private String actualVolume;
/*     */   @Column(name="design_volume")
/*     */   @JsonView({Views.CompartmentView.class})
/*     */   private String designVolume;
/*     */   @Column(name="longitude")
/*     */   @JsonView({Views.CompartmentView.class})
/*     */   private Double longitude;
/*     */   @Column(name="latitude")
/*     */   @JsonView({Views.CompartmentView.class})
/*     */   private Double latitude;
/*     */   @ManyToOne
/*     */   @JsonView({Views.SpaceStatusView.class})
/*     */   @JoinColumn(name="status_id")
/*     */   private SpaceStatus status;
/*     */   @ManyToOne
/*     */   @JsonView({Views.SpaceConditionView.class})
/*     */   @JoinColumn(name="condition_id")
/*     */   private SpaceCondition condition;
/*     */   @Column(name="active_date")
/*     */   @JsonView({Views.CompartmentView.class})
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date activeDate;
/*     */   @OneToMany(fetch=FetchType.LAZY, mappedBy="compartment", cascade={javax.persistence.CascadeType.ALL})
/*     */   @JsonView({Views.CompartmentRefCargoView.class})
/*     */   @OrderBy("codeId ASC")
/*     */   private Set<Cargo> cargos;
/*     */   
/*     */   public Store getStore()
/*     */   {
/*  99 */     return this.store;
/*     */   }
/*     */   
/*     */   public void setStore(Store store) {
/* 103 */     this.store = store;
/*     */   }
/*     */   
/*     */   public Integer getCodeId() {
/* 107 */     return this.codeId;
/*     */   }
/*     */   
/*     */   public void setCodeId(Integer codeId) {
/* 111 */     this.codeId = codeId;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 115 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 119 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Double getLength() {
/* 123 */     return this.length;
/*     */   }
/*     */   
/*     */   public void setLength(Double length) {
/* 127 */     this.length = length;
/*     */   }
/*     */   
/*     */   public Double getBreadth() {
/* 131 */     return this.breadth;
/*     */   }
/*     */   
/*     */   public void setBreadth(Double breadth) {
/* 135 */     this.breadth = breadth;
/*     */   }
/*     */   
/*     */   public Double getHeight() {
/* 139 */     return this.height;
/*     */   }
/*     */   
/*     */   public void setHeight(Double height) {
/* 143 */     this.height = height;
/*     */   }
/*     */   
/*     */   public Double getGrainHeight() {
/* 147 */     return this.grainHeight;
/*     */   }
/*     */   
/*     */   public void setGrainHeight(Double grainHeight) {
/* 151 */     this.grainHeight = grainHeight;
/*     */   }
/*     */   
/*     */   public String getActualVolume() {
/* 155 */     return this.actualVolume;
/*     */   }
/*     */   
/*     */   public void setActualVolume(String actualVolume) {
/* 159 */     this.actualVolume = actualVolume;
/*     */   }
/*     */   
/*     */   public String getDesignVolume() {
/* 163 */     return this.designVolume;
/*     */   }
/*     */   
/*     */   public void setDesignVolume(String designVolume) {
/* 167 */     this.designVolume = designVolume;
/*     */   }
/*     */   
/*     */   public Double getLongitude() {
/* 171 */     return this.longitude;
/*     */   }
/*     */   
/*     */   public void setLongitude(Double longitude) {
/* 175 */     this.longitude = longitude;
/*     */   }
/*     */   
/*     */   public Double getLatitude() {
/* 179 */     return this.latitude;
/*     */   }
/*     */   
/*     */   public void setLatitude(Double latitude) {
/* 183 */     this.latitude = latitude;
/*     */   }
/*     */   
/*     */   public SpaceStatus getStatus() {
/* 187 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(SpaceStatus status) {
/* 191 */     this.status = status;
/*     */   }
/*     */   
/*     */   public SpaceCondition getCondition() {
/* 195 */     return this.condition;
/*     */   }
/*     */   
/*     */   public void setCondition(SpaceCondition condition) {
/* 199 */     this.condition = condition;
/*     */   }
/*     */   
/*     */   public Date getActiveDate() {
/* 203 */     return this.activeDate;
/*     */   }
/*     */   
/*     */   public void setActiveDate(Date activeDate) {
/* 207 */     this.activeDate = activeDate;
/*     */   }
/*     */   
/*     */   public Set<Cargo> getCargos() {
/* 211 */     return this.cargos;
/*     */   }
/*     */   
/*     */   public void setCargos(Set<Cargo> cargos) {
/* 215 */     this.cargos = cargos;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\Compartment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */