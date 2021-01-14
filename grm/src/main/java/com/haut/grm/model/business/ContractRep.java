/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.ContractRefClientView;
/*     */ import com.haut.grm.json.view.Views.ContractTypeView;
/*     */ import com.haut.grm.model.Depot;
/*     */ import com.haut.grm.model.base.AbstractBusiness;
/*     */ import com.haut.grm.model.standard.code.GrainVariety;
/*     */ import com.haut.grm.model.type.ContractType;
/*     */ import com.haut.grm.model.type.GrainType;
/*     */ import com.haut.grm.model.type.PackageType;
/*     */ import com.haut.grm.model.type.Scale;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
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
/*     */ @Entity
/*     */ @Table(name="gb_contract_representation")
/*     */ public class ContractRep
/*     */   extends AbstractBusiness
/*     */ {
/*     */   private static final long serialVersionUID = -7889389470187930694L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="type_id")
/*     */   @JsonView({Views.ContractTypeView.class})
/*     */   @Description("合同类型")
/*     */   private ContractType type;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_variety_id")
/*     */   @Description("粮食种类")
/*     */   private GrainVariety grainVariety;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_type_id")
/*     */   @Description("粮食性质")
/*     */   private GrainType grainType;
/*     */   @Column(name="name")
/*     */   @Description("合同编号")
/*     */   private String name;
/*     */   @Column(name="is_ingress")
/*     */   @Description("方向")
/*     */   private Boolean isIngress;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="client_id")
/*     */   @JsonView({Views.ContractRefClientView.class})
/*     */   @Description("客户")
/*     */   private Client client;
/*     */   @Column(name="amount")
/*     */   @Description("数量")
/*     */   private Long amount;
/*     */   @Column(name="price")
/*     */   @Description("单价(元/吨)")
/*     */   private Double price;
/*     */   @Column(name="total_price")
/*     */   @Description("总价(元)")
/*     */   private Double totalPrice;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="scale_id")
/*     */   @Description("数量单位")
/*     */   private Scale scale;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="depot_id")
/*     */   @Description("粮库")
/*     */   private Depot depot;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="package_type_id")
/*     */   @Description("包装类型")
/*     */   private PackageType packageType;
/*     */   @Column(name="readable_name")
/*     */   private String readableName;
/*     */   
/*     */   public ContractType getType()
/*     */   {
/*  91 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(ContractType type) {
/*  95 */     this.type = type;
/*     */   }
/*     */   
/*     */   public GrainVariety getGrainVariety() {
/*  99 */     return this.grainVariety;
/*     */   }
/*     */   
/*     */   public void setGrainVariety(GrainVariety grainVariety) {
/* 103 */     this.grainVariety = grainVariety;
/*     */   }
/*     */   
/*     */   public GrainType getGrainType() {
/* 107 */     return this.grainType;
/*     */   }
/*     */   
/*     */   public void setGrainType(GrainType grainType) {
/* 111 */     this.grainType = grainType;
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
/*     */   public Boolean getIsIngress() {
/* 123 */     return this.isIngress;
/*     */   }
/*     */   
/*     */   public void setIsIngress(Boolean isIngress) {
/* 127 */     this.isIngress = isIngress;
/*     */   }
/*     */   
/*     */   public Client getClient() {
/* 131 */     return this.client;
/*     */   }
/*     */   
/*     */   public void setClient(Client client) {
/* 135 */     this.client = client;
/*     */   }
/*     */   
/*     */   public Long getAmount() {
/* 139 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Long amount) {
/* 143 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public Double getPrice() {
/* 147 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(Double price) {
/* 151 */     this.price = price;
/*     */   }
/*     */   
/*     */   public Double getTotalPrice() {
/* 155 */     return this.totalPrice;
/*     */   }
/*     */   
/*     */   public void setTotalPrice(Double totalPrice) {
/* 159 */     this.totalPrice = totalPrice;
/*     */   }
/*     */   
/*     */   public Scale getScale() {
/* 163 */     return this.scale;
/*     */   }
/*     */   
/*     */   public void setScale(Scale scale) {
/* 167 */     this.scale = scale;
/*     */   }
/*     */   
/*     */   public String getReadableName() {
/* 171 */     return this.readableName;
/*     */   }
/*     */   
/*     */   public void setReadableName(String readableName) {
/* 175 */     this.readableName = readableName;
/*     */   }
/*     */   
/*     */   public Depot getDepot() {
/* 179 */     return this.depot;
/*     */   }
/*     */   
/*     */   public void setDepot(Depot depot) {
/* 183 */     this.depot = depot;
/*     */   }
/*     */   
/*     */   public PackageType getPackageType() {
/* 187 */     return this.packageType;
/*     */   }
/*     */   
/*     */   public void setPackageType(PackageType packageType) {
/* 191 */     this.packageType = packageType;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\ContractRep.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */