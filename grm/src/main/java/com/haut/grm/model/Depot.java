/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.DepotView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.standard.code.Location;
/*     */ import com.haut.grm.model.type.CompanyType;
/*     */ import com.haut.grm.model.type.DepotCategory;
/*     */ import com.haut.grm.model.type.RoadType;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ @Table(name="grm_depot")
/*     */ public class Depot
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = -6821094834827929889L;
/*     */   public static final long THE_ID = 1L;
/*     */   @Column(name="code_id")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private Integer codeId;
/*     */   @Column(name="company_short_code")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String companyShortCode;
/*     */   @Column(name="company_code")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String companyCode;
/*     */   @Column(name="company_name")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String companyName;
/*     */   @Column(name="name")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String name;
/*     */   @Column(name="abbrev")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String abbrev;
/*     */   @Column(name="keyword")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String keyword;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="company_type_id")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private CompanyType depotType;
/*     */   @Column(name="type")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String type;
/*     */   @Column(name="built_date")
/*     */   @JsonView({Views.DepotView.class})
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date builtDate;
/*     */   @Column(name="capacity")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private Long capacity;
/*     */   @Column(name="active_capacity")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private Long activeCapacity;
/*     */   @Column(name="oil_capacity")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private Long oilCapacity;
/*     */   @Column(name="active_oil_capacity")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private Long activeOilCapacity;
/*     */   @Column(name="space")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private Double space;
/*     */   @Column(name="manager_name")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String managerName;
/*     */   @Column(name="is_own")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private Boolean isOwn;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="road_type_id")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private RoadType roadType;
/*     */   @Column(name="road_distance")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private Integer roadDistance;
/*     */   @Column(name="telephone")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String telephone;
/*     */   @Column(name="fax")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String fax;
/*     */   @Column(name="address")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String address;
/*     */   @Column(name="zip_code")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private String zipCode;
/*     */   @Column(name="longitude")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private Double longitude;
/*     */   @Column(name="latitude")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private Double latitude;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="location_id")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private Location location;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="category_id")
/*     */   @JsonView({Views.DepotView.class})
/*     */   private DepotCategory depotCategory;
/*     */   
/*     */   public String getKeyword()
/*     */   {
/* 143 */     return this.keyword;
/*     */   }
/*     */   
/*     */   public void setKeyword(String keyword) {
/* 147 */     this.keyword = keyword;
/*     */   }
/*     */   
/*     */   public Integer getCodeId() {
/* 151 */     return this.codeId;
/*     */   }
/*     */   
/*     */   public void setCodeId(Integer codeId) {
/* 155 */     this.codeId = codeId;
/*     */   }
/*     */   
/*     */   public String getCompanyShortCode() {
/* 159 */     return this.companyShortCode;
/*     */   }
/*     */   
/*     */   public void setCompanyShortCode(String companyShortCode) {
/* 163 */     this.companyShortCode = companyShortCode;
/*     */   }
/*     */   
/*     */   public String getCompanyCode() {
/* 167 */     return this.companyCode;
/*     */   }
/*     */   
/*     */   public void setCompanyCode(String companyCode) {
/* 171 */     this.companyCode = companyCode;
/*     */   }
/*     */   
/*     */   public String getCompanyName() {
/* 175 */     return this.companyName;
/*     */   }
/*     */   
/*     */   public void setCompanyName(String companyName) {
/* 179 */     this.companyName = companyName;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 183 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 187 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getAbbrev() {
/* 191 */     return this.abbrev;
/*     */   }
/*     */   
/*     */   public void setAbbrev(String abbrev) {
/* 195 */     this.abbrev = abbrev;
/*     */   }
/*     */   
/*     */   public CompanyType getDepotType() {
/* 199 */     return this.depotType;
/*     */   }
/*     */   
/*     */   public void setDepotType(CompanyType depotType) {
/* 203 */     this.depotType = depotType;
/*     */   }
/*     */   
/*     */   public String getType() {
/* 207 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 211 */     this.type = type;
/*     */   }
/*     */   
/*     */   public Date getBuiltDate() {
/* 215 */     return this.builtDate;
/*     */   }
/*     */   
/*     */   public void setBuiltDate(Date builtDate) {
/* 219 */     this.builtDate = builtDate;
/*     */   }
/*     */   
/*     */   public Long getCapacity() {
/* 223 */     return this.capacity;
/*     */   }
/*     */   
/*     */   public void setCapacity(Long capacity) {
/* 227 */     this.capacity = capacity;
/*     */   }
/*     */   
/*     */   public Double getSpace() {
/* 231 */     return this.space;
/*     */   }
/*     */   
/*     */   public void setSpace(Double space) {
/* 235 */     this.space = space;
/*     */   }
/*     */   
/*     */   public String getTelephone() {
/* 239 */     return this.telephone;
/*     */   }
/*     */   
/*     */   public void setTelephone(String telephone) {
/* 243 */     this.telephone = telephone;
/*     */   }
/*     */   
/*     */   public String getFax() {
/* 247 */     return this.fax;
/*     */   }
/*     */   
/*     */   public void setFax(String fax) {
/* 251 */     this.fax = fax;
/*     */   }
/*     */   
/*     */   public String getAddress() {
/* 255 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/* 259 */     this.address = address;
/*     */   }
/*     */   
/*     */   public String getZipCode() {
/* 263 */     return this.zipCode;
/*     */   }
/*     */   
/*     */   public void setZipCode(String zipCode) {
/* 267 */     this.zipCode = zipCode;
/*     */   }
/*     */   
/*     */   public Double getLongitude() {
/* 271 */     return this.longitude;
/*     */   }
/*     */   
/*     */   public void setLongitude(Double longitude) {
/* 275 */     this.longitude = longitude;
/*     */   }
/*     */   
/*     */   public Double getLatitude() {
/* 279 */     return this.latitude;
/*     */   }
/*     */   
/*     */   public void setLatitude(Double latitude) {
/* 283 */     this.latitude = latitude;
/*     */   }
/*     */   
/*     */   public Location getLocation() {
/* 287 */     return this.location;
/*     */   }
/*     */   
/*     */   public void setLocation(Location location) {
/* 291 */     this.location = location;
/*     */   }
/*     */   
/*     */   public DepotCategory getDepotCategory() {
/* 295 */     return this.depotCategory;
/*     */   }
/*     */   
/*     */   public void setDepotCategory(DepotCategory depotCategory) {
/* 299 */     this.depotCategory = depotCategory;
/*     */   }
/*     */   
/*     */   public Long getActiveCapacity() {
/* 303 */     return this.activeCapacity;
/*     */   }
/*     */   
/*     */   public void setActiveCapacity(Long activeCapacity) {
/* 307 */     this.activeCapacity = activeCapacity;
/*     */   }
/*     */   
/*     */   public Long getOilCapacity() {
/* 311 */     return this.oilCapacity;
/*     */   }
/*     */   
/*     */   public void setOilCapacity(Long oilCapacity) {
/* 315 */     this.oilCapacity = oilCapacity;
/*     */   }
/*     */   
/*     */   public Long getActiveOilCapacity() {
/* 319 */     return this.activeOilCapacity;
/*     */   }
/*     */   
/*     */   public void setActiveOilCapacity(Long activeOilCapacity) {
/* 323 */     this.activeOilCapacity = activeOilCapacity;
/*     */   }
/*     */   
/*     */   public String getManagerName() {
/* 327 */     return this.managerName;
/*     */   }
/*     */   
/*     */   public void setManagerName(String managerName) {
/* 331 */     this.managerName = managerName;
/*     */   }
/*     */   
/*     */   public Boolean getIsOwn() {
/* 335 */     return this.isOwn;
/*     */   }
/*     */   
/*     */   public void setIsOwn(Boolean isOwn) {
/* 339 */     this.isOwn = isOwn;
/*     */   }
/*     */   
/*     */   public RoadType getRoadType() {
/* 343 */     return this.roadType;
/*     */   }
/*     */   
/*     */   public void setRoadType(RoadType roadType) {
/* 347 */     this.roadType = roadType;
/*     */   }
/*     */   
/*     */   public Integer getRoadDistance() {
/* 351 */     return this.roadDistance;
/*     */   }
/*     */   
/*     */   public void setRoadDistance(Integer roadDistance) {
/* 355 */     this.roadDistance = roadDistance;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\Depot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */