/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonBackReference;
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.StoreConfigRefStoreView;
/*     */ import com.haut.grm.json.view.Views.StoreConfigView;
/*     */ import com.haut.grm.json.view.Views.StoreManagerView;
/*     */ import com.haut.grm.json.view.Views.StoreTypeView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.meta.StoreModel;
/*     */ import com.haut.grm.model.meta.User;
/*     */ import com.haut.grm.model.standard.code.StoreType;
/*     */ import com.haut.grm.model.system.CoreVersion;
/*     */ import com.haut.grm.model.type.PackageCategory;
/*     */ import com.haut.grm.model.type.StorageType;
/*     */ import com.haut.grm.model.type.StructureType;
/*     */ import com.haut.grm.model.type.TemperatureControlType;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="grm_store_config")
/*     */ public class StoreConfig
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 6899211891124117166L;
/*     */   @JsonBackReference
/*     */   @JsonView({Views.StoreConfigRefStoreView.class})
/*     */   @OneToOne(mappedBy="config")
/*     */   private Store store;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="manager_id")
/*     */   @JsonView({Views.StoreManagerView.class})
/*     */   private User manager;
/*     */   @Column(name="is_demo")
/*     */   @JsonView({Views.StoreConfigView.class})
/*  44 */   private Boolean isDemo = Boolean.valueOf(false);
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="version_id")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private CoreVersion version;
/*     */   
/*     */   @Column(name="source_position_x")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private String sourcePositionX;
/*     */   
/*     */   @Column(name="source_position_y")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private String sourcePositionY;
/*     */   
/*     */   @Column(name="target_position_x")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private String targetPositionX;
/*     */   
/*     */   @Column(name="target_position_y")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private String targetPositionY;
/*     */   
/*     */   @Column(name="temp_layer")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Long tempLayer;
/*     */   
/*     */   @Column(name="temp_breadth")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Long tempBreadth;
/*     */   
/*     */   @Column(name="temp_width")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Long tempWidth;
/*     */   
/*     */   @Column(name="cable_data")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private String cableData;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="model_id")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private StoreModel model;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="type_id")
/*     */   @JsonView({Views.StoreTypeView.class})
/*     */   private StoreType type;
/*     */   
/*     */   @Column(name="is_insulated")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Boolean isInsulated;
/*     */   
/*     */   @Column(name="is_packagelessable")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Boolean isPackagelessable;
/*     */   
/*     */   @Column(name="is_insecticidal")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Boolean isInsecticidal;
/*     */   
/*     */   @Column(name="is_retardant")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Boolean isRetardant;
/*     */   
/*     */   @Column(name="is_temperaturable")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Boolean isTemperaturable;
/*     */   
/*     */   @Column(name="is_ventilatable")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Boolean isVentilatable;
/*     */   
/*     */   @Column(name="is_fumigatable")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Boolean isFumigatable;
/*     */   
/*     */   @Column(name="is_chargeable")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Boolean isChargeable;
/*     */   
/*     */   @Column(name="is_insectsensitive")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Boolean isInsectsensitive;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="package_category_id")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private PackageCategory packageCategory;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="storage_type_id")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private StorageType storageType;
/*     */   
/*     */   @Column(name="is_processed")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private Boolean isProcessed;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="temperature_control_type_id")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private TemperatureControlType temperatureControlType;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="ground_structure_id")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private StructureType groundStructure;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="wall_structure_id")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private StructureType wallStructure;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="roof_structure_id")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private StructureType roofStructure;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="frame_structure_id")
/*     */   @JsonView({Views.StoreConfigView.class})
/*     */   private StructureType frameStructure;
/*     */   
/*     */   @Column(name="is_remote")
/*     */   @JsonView({Views.StoreConfigView.class})
/* 170 */   private Boolean isRemote = Boolean.valueOf(false);
/*     */   
/*     */   public Store getStore() {
/* 173 */     return this.store;
/*     */   }
/*     */   
/*     */   public void setStore(Store store) {
/* 177 */     this.store = store;
/*     */   }
/*     */   
/*     */   public User getManager() {
/* 181 */     return this.manager;
/*     */   }
/*     */   
/*     */   public void setManager(User manager) {
/* 185 */     this.manager = manager;
/*     */   }
/*     */   
/*     */   public Boolean getIsDemo() {
/* 189 */     return this.isDemo;
/*     */   }
/*     */   
/*     */   public void setIsDemo(Boolean isDemo) {
/* 193 */     this.isDemo = isDemo;
/*     */   }
/*     */   
/*     */   public CoreVersion getVersion() {
/* 197 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setVersion(CoreVersion version) {
/* 201 */     this.version = version;
/*     */   }
/*     */   
/*     */   public String getSourcePositionX() {
/* 205 */     return this.sourcePositionX;
/*     */   }
/*     */   
/*     */   public void setSourcePositionX(String sourcePositionX) {
/* 209 */     this.sourcePositionX = sourcePositionX;
/*     */   }
/*     */   
/*     */   public String getSourcePositionY() {
/* 213 */     return this.sourcePositionY;
/*     */   }
/*     */   
/*     */   public void setSourcePositionY(String sourcePositionY) {
/* 217 */     this.sourcePositionY = sourcePositionY;
/*     */   }
/*     */   
/*     */   public String getTargetPositionX() {
/* 221 */     return this.targetPositionX;
/*     */   }
/*     */   
/*     */   public void setTargetPositionX(String targetPositionX) {
/* 225 */     this.targetPositionX = targetPositionX;
/*     */   }
/*     */   
/*     */   public String getTargetPositionY() {
/* 229 */     return this.targetPositionY;
/*     */   }
/*     */   
/*     */   public void setTargetPositionY(String targetPositionY) {
/* 233 */     this.targetPositionY = targetPositionY;
/*     */   }
/*     */   
/*     */   public Long getTempLayer() {
/* 237 */     return this.tempLayer;
/*     */   }
/*     */   
/*     */   public void setTempLayer(Long tempLayer) {
/* 241 */     this.tempLayer = tempLayer;
/*     */   }
/*     */   
/*     */   public Long getTempBreadth() {
/* 245 */     return this.tempBreadth;
/*     */   }
/*     */   
/*     */   public void setTempBreadth(Long tempBreadth) {
/* 249 */     this.tempBreadth = tempBreadth;
/*     */   }
/*     */   
/*     */   public Long getTempWidth() {
/* 253 */     return this.tempWidth;
/*     */   }
/*     */   
/*     */   public void setTempWidth(Long tempWidth) {
/* 257 */     this.tempWidth = tempWidth;
/*     */   }
/*     */   
/*     */   public String getCableData() {
/* 261 */     return this.cableData;
/*     */   }
/*     */   
/*     */   public void setCableData(String cableData) {
/* 265 */     this.cableData = cableData;
/*     */   }
/*     */   
/*     */   public StoreModel getModel() {
/* 269 */     return this.model;
/*     */   }
/*     */   
/*     */   public void setModel(StoreModel model) {
/* 273 */     this.model = model;
/*     */   }
/*     */   
/*     */   public StoreType getType() {
/* 277 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(StoreType type) {
/* 281 */     this.type = type;
/*     */   }
/*     */   
/*     */   public Boolean getIsInsulated() {
/* 285 */     return this.isInsulated;
/*     */   }
/*     */   
/*     */   public void setIsInsulated(Boolean isInsulated) {
/* 289 */     this.isInsulated = isInsulated;
/*     */   }
/*     */   
/*     */   public Boolean getIsPackagelessable() {
/* 293 */     return this.isPackagelessable;
/*     */   }
/*     */   
/*     */   public void setIsPackagelessable(Boolean isPackagelessable) {
/* 297 */     this.isPackagelessable = isPackagelessable;
/*     */   }
/*     */   
/*     */   public Boolean getIsInsecticidal() {
/* 301 */     return this.isInsecticidal;
/*     */   }
/*     */   
/*     */   public void setIsInsecticidal(Boolean isInsecticidal) {
/* 305 */     this.isInsecticidal = isInsecticidal;
/*     */   }
/*     */   
/*     */   public Boolean getIsRetardant() {
/* 309 */     return this.isRetardant;
/*     */   }
/*     */   
/*     */   public void setIsRetardant(Boolean isRetardant) {
/* 313 */     this.isRetardant = isRetardant;
/*     */   }
/*     */   
/*     */   public Boolean getIsTemperaturable() {
/* 317 */     return this.isTemperaturable;
/*     */   }
/*     */   
/*     */   public void setIsTemperaturable(Boolean isTemperaturable) {
/* 321 */     this.isTemperaturable = isTemperaturable;
/*     */   }
/*     */   
/*     */   public Boolean getIsVentilatable() {
/* 325 */     return this.isVentilatable;
/*     */   }
/*     */   
/*     */   public void setIsVentilatable(Boolean isVentilatable) {
/* 329 */     this.isVentilatable = isVentilatable;
/*     */   }
/*     */   
/*     */   public Boolean getIsFumigatable() {
/* 333 */     return this.isFumigatable;
/*     */   }
/*     */   
/*     */   public void setIsFumigatable(Boolean isFumigatable) {
/* 337 */     this.isFumigatable = isFumigatable;
/*     */   }
/*     */   
/*     */   public Boolean getIsChargeable() {
/* 341 */     return this.isChargeable;
/*     */   }
/*     */   
/*     */   public void setIsChargeable(Boolean isChargeable) {
/* 345 */     this.isChargeable = isChargeable;
/*     */   }
/*     */   
/*     */   public Boolean getIsInsectsensitive() {
/* 349 */     return this.isInsectsensitive;
/*     */   }
/*     */   
/*     */   public void setIsInsectsensitive(Boolean isInsectsensitive) {
/* 353 */     this.isInsectsensitive = isInsectsensitive;
/*     */   }
/*     */   
/*     */   public StorageType getStorageType() {
/* 357 */     return this.storageType;
/*     */   }
/*     */   
/*     */   public void setStorageType(StorageType storageType) {
/* 361 */     this.storageType = storageType;
/*     */   }
/*     */   
/*     */   public TemperatureControlType getTemperatureControlType() {
/* 365 */     return this.temperatureControlType;
/*     */   }
/*     */   
/*     */   public void setTemperatureControlType(TemperatureControlType temperatureControlType) {
/* 369 */     this.temperatureControlType = temperatureControlType;
/*     */   }
/*     */   
/*     */   public StructureType getGroundStructure() {
/* 373 */     return this.groundStructure;
/*     */   }
/*     */   
/*     */   public void setGroundStructure(StructureType groundStructure) {
/* 377 */     this.groundStructure = groundStructure;
/*     */   }
/*     */   
/*     */   public StructureType getWallStructure() {
/* 381 */     return this.wallStructure;
/*     */   }
/*     */   
/*     */   public void setWallStructure(StructureType wallStructure) {
/* 385 */     this.wallStructure = wallStructure;
/*     */   }
/*     */   
/*     */   public StructureType getRoofStructure() {
/* 389 */     return this.roofStructure;
/*     */   }
/*     */   
/*     */   public void setRoofStructure(StructureType roofStructure) {
/* 393 */     this.roofStructure = roofStructure;
/*     */   }
/*     */   
/*     */   public StructureType getFrameStructure() {
/* 397 */     return this.frameStructure;
/*     */   }
/*     */   
/*     */   public void setFrameStructure(StructureType frameStructure) {
/* 401 */     this.frameStructure = frameStructure;
/*     */   }
/*     */   
/*     */   public Boolean getIsRemote() {
/* 405 */     return this.isRemote;
/*     */   }
/*     */   
/*     */   public void setIsRemote(Boolean isRemote) {
/* 409 */     this.isRemote = isRemote;
/*     */   }
/*     */   
/*     */   public Boolean getIsProcessed() {
/* 413 */     return this.isProcessed;
/*     */   }
/*     */   
/*     */   public void setIsProcessed(Boolean isProcessed) {
/* 417 */     this.isProcessed = isProcessed;
/*     */   }
/*     */   
/*     */   public PackageCategory getPackageCategory() {
/* 421 */     return this.packageCategory;
/*     */   }
/*     */   
/*     */   public void setPackageCategory(PackageCategory packageCategory) {
/* 425 */     this.packageCategory = packageCategory;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\StoreConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */