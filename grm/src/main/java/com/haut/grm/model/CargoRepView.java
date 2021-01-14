/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.querydsl.core.annotations.QueryInit;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ 
/*     */ @Entity
/*     */ @Table(name="grm_cargo_representation")
/*     */ public class CargoRepView
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 7833372389644867457L;
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   @JoinColumn(name="compartment_id")
/*     */   @QueryInit({"store.depot.*"})
/*     */   private Compartment compartment;
/*     */   @Column(name="code_id")
/*     */   private Integer codeId;
/*     */   @Column(name="name")
/*     */   private String name;
/*     */   @Column(name="readable_name", insertable=false, updatable=false)
/*     */   private String readableName;
/*     */   @Column(name="code", insertable=false, updatable=false)
/*     */   private String code;
/*     */   @Column(name="status_id", insertable=false, updatable=false)
/*     */   private Long statusId;
/*     */   @Column(name="status_name", insertable=false, updatable=false)
/*     */   private String statusName;
/*     */   @Column(name="store_name", insertable=false, updatable=false)
/*     */   private String storeName;
/*     */   @Column(name="depot_abbrev", insertable=false, updatable=false)
/*     */   private String depotAbbrev;
/*     */   @Column(name="short_name", insertable=false, updatable=false)
/*     */   private String shortName;
/*     */   
/*     */   public Compartment getCompartment()
/*     */   {
/*  55 */     return this.compartment;
/*     */   }
/*     */   
/*     */   public void setCompartment(Compartment compartment) {
/*  59 */     this.compartment = compartment;
/*     */   }
/*     */   
/*     */   public Integer getCodeId() {
/*  63 */     return this.codeId;
/*     */   }
/*     */   
/*     */   public void setCodeId(Integer codeId) {
/*  67 */     this.codeId = codeId;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  71 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  75 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getReadableName() {
/*  79 */     return this.readableName;
/*     */   }
/*     */   
/*     */   public void setReadableName(String readableName) {
/*  83 */     this.readableName = readableName;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  87 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  91 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getStatusName() {
/*  95 */     return this.statusName;
/*     */   }
/*     */   
/*     */   public void setStatusName(String statusName) {
/*  99 */     this.statusName = statusName;
/*     */   }
/*     */   
/*     */   public String getStoreName() {
/* 103 */     return this.storeName;
/*     */   }
/*     */   
/*     */   public void setStoreName(String storeName) {
/* 107 */     this.storeName = storeName;
/*     */   }
/*     */   
/*     */   public String getDepotAbbrev() {
/* 111 */     return this.depotAbbrev;
/*     */   }
/*     */   
/*     */   public void setDepotAbbrev(String depotAbbrev) {
/* 115 */     this.depotAbbrev = depotAbbrev;
/*     */   }
/*     */   
/*     */   public String getShortName() {
/* 119 */     return this.shortName;
/*     */   }
/*     */   
/*     */   public void setShortName(String shortName) {
/* 123 */     this.shortName = shortName;
/*     */   }
/*     */   
/*     */   public Long getStatusId() {
/* 127 */     return this.statusId;
/*     */   }
/*     */   
/*     */   public void setStatusId(Long statusId) {
/* 131 */     this.statusId = statusId;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\CargoRepView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */