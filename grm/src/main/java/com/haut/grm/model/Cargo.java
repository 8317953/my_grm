/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.CargoRefCompartmentView;
/*     */ import com.haut.grm.json.view.Views.CargoStatusView;
/*     */ import com.haut.grm.json.view.Views.CargoView;
/*     */ import com.haut.grm.json.view.Views.PackageCategoryView;
/*     */ import com.haut.grm.json.view.Views.PackageTypeView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.type.CargoStatus;
/*     */ import com.haut.grm.model.type.PackageCategory;
/*     */ import com.haut.grm.model.type.PackageType;
/*     */ import com.querydsl.core.annotations.QueryInit;
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
/*     */ //这里有两个 极大 的坑 首先后面加s 还是es居然是符合英语语法

		//其次这里显示出了api的好处  localhost:8080/grm/api可以显示出所有Api

//最后 qClass是自动生成 的 生成方法 引入 特殊的包  并且 run maven build 第二个 compile 然后2.使用eclipse/sts的mvn插件：Run As — Maven generate-sources；

/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="grm_cargo")
/*     */ public class Cargo
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 6516896139021765560L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="compartment_id")
/*     */   @JsonView({Views.CargoRefCompartmentView.class})
/*     */   @QueryInit({"store.depot.*"})
/*     */   private Compartment compartment;
/*     */   @Column(name="name")
/*     */   @JsonView({Views.CargoView.class})
/*     */   private String name;
/*     */   @Column(name="code_id")
/*     */   @JsonView({Views.CargoView.class})
/*     */   private Integer codeId;
/*     */   @Column(name="volume")
/*     */   @JsonView({Views.CargoView.class})
/*     */   private Double volume;
/*     */   @ManyToOne
/*     */   @JsonView({Views.CargoStatusView.class})
/*     */   @JoinColumn(name="status_id")
/*     */   private CargoStatus status;
/*     */   @ManyToOne
/*     */   @JsonView({Views.PackageTypeView.class})
/*     */   @JoinColumn(name="package_type_id")
/*     */   private PackageType packageType;
/*     */   @ManyToOne
/*     */   @JsonView({Views.PackageCategoryView.class})
/*     */   @JoinColumn(name="package_category_id")
/*     */   private PackageCategory packageCategory;
/*     */   @Column(name="active_date")
/*     */   @JsonView({Views.CargoView.class})
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date activeDate;
/*     */   
/*     */   public Compartment getCompartment()
/*     */   {
/*  69 */     return this.compartment;
/*     */   }
/*     */   
/*     */   public void setCompartment(Compartment compartment) {
/*  73 */     this.compartment = compartment;
/*     */   }
/*     */   
/*     */   public Integer getCodeId() {
/*  77 */     return this.codeId;
/*     */   }
/*     */   
/*     */   public void setCodeId(Integer codeId) {
/*  81 */     this.codeId = codeId;
/*     */   }
/*     */   
/*     */   public CargoStatus getStatus() {
/*  85 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(CargoStatus status) {
/*  89 */     this.status = status;
/*     */   }
/*     */   
/*     */   public PackageType getPackageType() {
/*  93 */     return this.packageType;
/*     */   }
/*     */   
/*     */   public void setPackageType(PackageType packageType) {
/*  97 */     this.packageType = packageType;
/*     */   }
/*     */   
/*     */   public Date getActiveDate() {
/* 101 */     return this.activeDate;
/*     */   }
/*     */   
/*     */   public void setActiveDate(Date activeDate) {
/* 105 */     this.activeDate = activeDate;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 109 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 113 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Double getVolume() {
/* 117 */     return this.volume;
/*     */   }
/*     */   
/*     */   public void setVolume(Double volume) {
/* 121 */     this.volume = volume;
/*     */   }
/*     */   
/*     */   public PackageCategory getPackageCategory() {
/* 125 */     return this.packageCategory;
/*     */   }
/*     */   
/*     */   public void setPackageCategory(PackageCategory packageCategory) {
/* 129 */     this.packageCategory = packageCategory;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\Cargo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */