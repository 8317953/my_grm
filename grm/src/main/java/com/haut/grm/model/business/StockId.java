/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.haut.grm.model.Cargo;
/*     */ import com.haut.grm.model.base.AbstractBusiness;
/*     */ import com.haut.grm.model.standard.code.GrainVariety;
/*     */ import com.haut.grm.model.type.Country;
/*     */ import com.haut.grm.model.type.GrainType;
/*     */ import com.haut.grm.model.type.PackageCategory;
/*     */ import com.haut.grm.model.type.PackageType;
/*     */ import com.querydsl.core.annotations.QueryInit;
/*     */ import java.util.Date;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import org.springframework.data.rest.core.annotation.Description;
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
/*     */ @Table(name="gb_stock_id")
/*     */ public class StockId
/*     */   extends AbstractBusiness
/*     */ {
/*     */   private static final long serialVersionUID = -4621716849005500082L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="cargo_id")
/*     */   @Description("货位")
/*     */   @QueryInit({"compartment.store.depot.*"})
/*     */   private Cargo cargo;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_type_id")
/*     */   @Description("粮食性质")
/*     */   private GrainType grainType;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_variety_id")
/*     */   @Description("粮食品种")
/*     */   private GrainVariety grainVariety;
/*     */   @Column(name="year")
/*     */   @Description("收获年份")
/*     */   private String year;
/*     */   @Column(name="amount")
/*     */   @Description("初始数量 (kg/公斤)")
/*     */   private Long amount;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="package_type_id")
/*     */   @Description("包装规格")
/*     */   private PackageType packageType;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="package_category_id")
/*     */   @Description("储存方式")
/*     */   private PackageCategory packageCategory;
/*     */   @Column(name="location")
/*     */   @Description("产地")
/*     */   private String location;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="country_id")
/*     */   @Description("国别")
/*     */   private Country country;
/*     */   @Column(name="in_finished")
/*  81 */   private Boolean inFinished = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name="out_finished")
/*  84 */   private Boolean outFinished = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name="in_time")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date inTime;
/*     */   
/*     */   @Column(name="out_time")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date outTime;
/*     */   
/*     */   @Column(name="_unit_weight")
/*  95 */   private Double unitWeight = Double.valueOf(550.0D);
/*     */   
/*     */   @Column(name="_deduct_volume")
/*  98 */   private Double deductVolume = Double.valueOf(54.5D);
/*     */   
/*     */   @Column(name="_factor")
/* 101 */   private Double factor = Double.valueOf(1.03D);
/*     */   
/*     */   @OneToMany(fetch=FetchType.LAZY, mappedBy="stock", cascade={javax.persistence.CascadeType.ALL})
/*     */   private Set<StockAnalysis> stockAnalyses;
/*     */   
/*     */   @OneToMany(fetch=FetchType.LAZY, mappedBy="targetStock", cascade={javax.persistence.CascadeType.ALL})
/*     */   private Set<StockChange> positiveStockChanges;
/*     */   @OneToMany(fetch=FetchType.LAZY, mappedBy="sourceStock", cascade={javax.persistence.CascadeType.ALL})
/*     */   private Set<StockChange> negetiveStockChanges;
/*     */   
/*     */   public PackageCategory getPackageCategory()
/*     */   {
/* 113 */     return this.packageCategory;
/*     */   }
/*     */   
/*     */   public void setPackageCategory(PackageCategory packageCategory) {
/* 117 */     this.packageCategory = packageCategory;
/*     */   }
/*     */   
/*     */   public Set<StockChange> getPositiveStockChanges() {
/* 121 */     return this.positiveStockChanges;
/*     */   }
/*     */   
/*     */   public void setPositiveStockChanges(Set<StockChange> positiveStockChanges) {
/* 125 */     this.positiveStockChanges = positiveStockChanges;
/*     */   }
/*     */   
/*     */   public Set<StockChange> getNegetiveStockChanges() {
/* 129 */     return this.negetiveStockChanges;
/*     */   }
/*     */   
/*     */   public void setNegetiveStockChanges(Set<StockChange> negetiveStockChanges) {
/* 133 */     this.negetiveStockChanges = negetiveStockChanges;
/*     */   }
/*     */   
/*     */   public Cargo getCargo() {
/* 137 */     return this.cargo;
/*     */   }
/*     */   
/*     */   public void setCargo(Cargo cargo) {
/* 141 */     this.cargo = cargo;
/*     */   }
/*     */   
/*     */   public GrainType getGrainType() {
/* 145 */     return this.grainType;
/*     */   }
/*     */   
/*     */   public void setGrainType(GrainType grainType) {
/* 149 */     this.grainType = grainType;
/*     */   }
/*     */   
/*     */   public GrainVariety getGrainVariety() {
/* 153 */     return this.grainVariety;
/*     */   }
/*     */   
/*     */   public void setGrainVariety(GrainVariety grainVariety) {
/* 157 */     this.grainVariety = grainVariety;
/*     */   }
/*     */   
/*     */   public String getYear() {
/* 161 */     return this.year;
/*     */   }
/*     */   
/*     */   public void setYear(String year) {
/* 165 */     this.year = year;
/*     */   }
/*     */   
/*     */   public Long getAmount() {
/* 169 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Long amount) {
/* 173 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public PackageType getPackageType() {
/* 177 */     return this.packageType;
/*     */   }
/*     */   
/*     */   public void setPackageType(PackageType packageType) {
/* 181 */     this.packageType = packageType;
/*     */   }
/*     */   
/*     */   public String getLocation() {
/* 185 */     return this.location;
/*     */   }
/*     */   
/*     */   public void setLocation(String location) {
/* 189 */     this.location = location;
/*     */   }
/*     */   
/*     */   public Boolean getInFinished() {
/* 193 */     return this.inFinished;
/*     */   }
/*     */   
/*     */   public void setInFinished(Boolean inFinished) {
/* 197 */     this.inFinished = inFinished;
/*     */   }
/*     */   
/*     */   public Boolean getOutFinished() {
/* 201 */     return this.outFinished;
/*     */   }
/*     */   
/*     */   public void setOutFinished(Boolean outFinished) {
/* 205 */     this.outFinished = outFinished;
/*     */   }
/*     */   
/*     */   public Date getInTime() {
/* 209 */     return this.inTime;
/*     */   }
/*     */   
/*     */   public void setInTime(Date inTime) {
/* 213 */     this.inTime = inTime;
/*     */   }
/*     */   
/*     */   public Date getOutTime() {
/* 217 */     return this.outTime;
/*     */   }
/*     */   
/*     */   public void setOutTime(Date outTime) {
/* 221 */     this.outTime = outTime;
/*     */   }
/*     */   
/*     */   public Set<StockAnalysis> getStockAnalyses() {
/* 225 */     return this.stockAnalyses;
/*     */   }
/*     */   
/*     */   public void setStockAnalyses(Set<StockAnalysis> stockAnalyses) {
/* 229 */     this.stockAnalyses = stockAnalyses;
/*     */   }
/*     */   
/*     */   public Double getUnitWeight() {
/* 233 */     return this.unitWeight;
/*     */   }
/*     */   
/*     */   public void setUnitWeight(Double unitWeight) {
/* 237 */     this.unitWeight = unitWeight;
/*     */   }
/*     */   
/*     */   public Double getDeductVolume() {
/* 241 */     return this.deductVolume;
/*     */   }
/*     */   
/*     */   public void setDeductVolume(Double deductVolume) {
/* 245 */     this.deductVolume = deductVolume;
/*     */   }
/*     */   
/*     */   public Double getFactor() {
/* 249 */     return this.factor;
/*     */   }
/*     */   
/*     */   public void setFactor(Double factor) {
/* 253 */     this.factor = factor;
/*     */   }
/*     */   
/*     */   public Country getCountry() {
/* 257 */     return this.country;
/*     */   }
/*     */   
/*     */   public void setCountry(Country country) {
/* 261 */     this.country = country;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */