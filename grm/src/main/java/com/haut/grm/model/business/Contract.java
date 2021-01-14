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
/*     */ @Entity
/*     */ @Table(name="gb_contract")
/*     */ public class Contract
/*     */   extends AbstractBusiness
/*     */ {
/*     */   private static final long serialVersionUID = 6189478760294426641L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="type_id")
/*     */   @JsonView({Views.ContractTypeView.class})
/*     */   @Description("合同类型")
/*     */   private ContractType type;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="depot_id")
/*     */   @Description("粮库")
/*     */   private Depot depot;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_variety_id")
/*     */   @Description("粮食种类")
/*     */   private GrainVariety grainVariety;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_type_id")
/*     */   @Description("粮食性质")
/*     */   private GrainType grainType;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="package_type_id")
/*     */   @Description("包装类型")
/*     */   private PackageType packageType;
/*     */   @Column(name="name")
/*     */   @Description("合同编号")
/*     */   private String name;
/*     */   @Column(name="is_ingress")
/*     */   @Description("购销方向")
/*  62 */   private Boolean isIngress = Boolean.valueOf(false);
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="client_id")
/*     */   @JsonView({Views.ContractRefClientView.class})
/*     */   @Description("客户")
/*     */   private Client client;
/*     */   
/*     */   @Column(name="amount")
/*     */   @Description("数量")
/*     */   private Long amount;
/*     */   
/*     */   @Column(name="price")
/*     */   @Description("单价(元/吨)")
/*     */   private Double price;
/*     */   
/*     */   @Column(name="total_price")
/*     */   @Description("总价(元)")
/*     */   private Double totalPrice;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="scale_id")
/*     */   @Description("数量单位")
/*     */   private Scale scale;
/*     */   
/*     */   public ContractType getType()
/*     */   {
/*  88 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(ContractType type) {
/*  92 */     this.type = type;
/*     */   }
/*     */   
/*     */   public Client getClient() {
/*  96 */     return this.client;
/*     */   }
/*     */   
/*     */   public void setClient(Client client) {
/* 100 */     this.client = client;
/*     */   }
/*     */   
/*     */   public Long getAmount() {
/* 104 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Long amount) {
/* 108 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public GrainType getGrainType() {
/* 112 */     return this.grainType;
/*     */   }
/*     */   
/*     */   public void setGrainType(GrainType grainType) {
/* 116 */     this.grainType = grainType;
/*     */   }
/*     */   
/*     */   public GrainVariety getGrainVariety() {
/* 120 */     return this.grainVariety;
/*     */   }
/*     */   
/*     */   public void setGrainVariety(GrainVariety grainVariety) {
/* 124 */     this.grainVariety = grainVariety;
/*     */   }
/*     */   
/*     */   public Boolean getIsIngress() {
/* 128 */     return this.isIngress;
/*     */   }
/*     */   
/*     */   public void setIsIngress(Boolean isIngress) {
/* 132 */     this.isIngress = isIngress;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 136 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 140 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Double getPrice() {
/* 144 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(Double price) {
/* 148 */     this.price = price;
/*     */   }
/*     */   
/*     */   public Double getTotalPrice() {
/* 152 */     return this.totalPrice;
/*     */   }
/*     */   
/*     */   public void setTotalPrice(Double totalPrice) {
/* 156 */     this.totalPrice = totalPrice;
/*     */   }
/*     */   
/*     */   public Scale getScale() {
/* 160 */     return this.scale;
/*     */   }
/*     */   
/*     */   public void setScale(Scale scale) {
/* 164 */     this.scale = scale;
/*     */   }
/*     */   
/*     */   public Depot getDepot() {
/* 168 */     return this.depot;
/*     */   }
/*     */   
/*     */   public void setDepot(Depot depot) {
/* 172 */     this.depot = depot;
/*     */   }
/*     */   
/*     */   public PackageType getPackageType() {
/* 176 */     return this.packageType;
/*     */   }
/*     */   
/*     */   public void setPackageType(PackageType packageType) {
/* 180 */     this.packageType = packageType;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\Contract.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */