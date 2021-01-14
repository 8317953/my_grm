/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.haut.grm.model.base.QAbstractBusiness;
/*     */ import com.haut.grm.model.meta.QUser;
/*     */ import com.haut.grm.model.standard.code.QGrainVariety;
/*     */ import com.haut.grm.model.type.QAnalysisLevel;
/*     */ import com.haut.grm.model.type.QGrainType;
/*     */ import com.haut.grm.model.type.QPackageCategory;
/*     */ import com.haut.grm.model.type.QSourceType;
/*     */ import com.querydsl.core.types.Path;
/*     */ import com.querydsl.core.types.PathMetadata;
/*     */ import com.querydsl.core.types.dsl.EntityPathBase;
/*     */ import com.querydsl.core.types.dsl.NumberPath;
/*     */ import com.querydsl.core.types.dsl.PathInits;
/*     */ import com.querydsl.core.types.dsl.StringPath;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class QStockChange extends EntityPathBase<StockChange>
/*     */ {
/*     */   private static final long serialVersionUID = -555553614L;
/*  21 */   private static final PathInits INITS = new PathInits(new String[] { "*", "sourceStock.cargo.compartment.store.depot.*", "targetStock.cargo.compartment.store.depot.*" });
/*     */   
/*  23 */   public static final QStockChange stockChange = new QStockChange("stockChange");
/*     */   
/*     */   public final QAbstractBusiness _super;
/*     */   
/*  27 */   public final NumberPath<Long> amount = createNumber("amount", Long.class);
/*     */   
/*     */ 
/*     */   public final QAnalysisLevel analysisLevel;
/*     */   
/*     */ 
/*     */   public final StringPath auditComment;
/*     */   
/*     */ 
/*     */   public final QUser auditor;
/*     */   
/*     */ 
/*     */   public final com.querydsl.core.types.dsl.DateTimePath<Date> auditTime;
/*     */   
/*     */   public final StringPath businessKey;
/*     */   
/*     */   public final QContract contract;
/*     */   
/*  45 */   public final com.querydsl.core.types.dsl.ListPath<StockChangeEntry, QStockChangeEntry> entries = createList("entries", StockChangeEntry.class, QStockChangeEntry.class, PathInits.DIRECT2);
/*     */   
/*     */ 
/*     */   public final QGrainType grainType;
/*     */   
/*     */   public final QGrainVariety grainVariety;
/*     */   
/*     */   public final NumberPath<Long> id;
/*     */   
/*  54 */   public final NumberPath<Double> impurity = createNumber("impurity", Double.class);
/*     */   
/*     */ 
/*     */   public final StringPath inputComment;
/*     */   
/*     */ 
/*     */   public final QUser inputer;
/*     */   
/*     */ 
/*     */   public final com.querydsl.core.types.dsl.DateTimePath<Date> inputTime;
/*     */   
/*  65 */   public final NumberPath<Long> pack = createNumber("pack", Long.class);
/*     */   
/*     */   public final QPackageCategory packageCategory;
/*     */   
/*     */   public final QStockId sourceStock;
/*     */   
/*     */   public final QStockId targetStock;
/*     */   
/*     */   public final QSourceType type;
/*     */   
/*  75 */   public final NumberPath<Double> water = createNumber("water", Double.class);
/*     */   
/*     */   public QStockChange(String variable) {
/*  78 */     this(StockChange.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable), INITS);
/*     */   }
/*     */   
/*     */   public QStockChange(Path<? extends StockChange> path) {
/*  82 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*     */   }
/*     */   
/*     */   public QStockChange(PathMetadata metadata) {
/*  86 */     this(metadata, PathInits.getFor(metadata, INITS));
/*     */   }
/*     */   
/*     */   public QStockChange(PathMetadata metadata, PathInits inits) {
/*  90 */     this(StockChange.class, metadata, inits);
/*     */   }
/*     */   
/*     */   public QStockChange(Class<? extends StockChange> type, PathMetadata metadata, PathInits inits) {
/*  94 */     super(type, metadata, inits);
/*  95 */     this._super = new QAbstractBusiness(type, metadata, inits);
/*  96 */     this.analysisLevel = (inits.isInitialized("analysisLevel") ? new QAnalysisLevel(forProperty("analysisLevel")) : null);
/*  97 */     this.auditComment = this._super.auditComment;
/*  98 */     this.auditor = this._super.auditor;
/*  99 */     this.auditTime = this._super.auditTime;
/* 100 */     this.businessKey = this._super.businessKey;
/* 101 */     this.contract = (inits.isInitialized("contract") ? new QContract(forProperty("contract"), inits.get("contract")) : null);
/* 102 */     this.grainType = (inits.isInitialized("grainType") ? new QGrainType(forProperty("grainType")) : null);
/* 103 */     this.grainVariety = (inits.isInitialized("grainVariety") ? new QGrainVariety(forProperty("grainVariety")) : null);
/* 104 */     this.id = this._super.id;
/* 105 */     this.inputComment = this._super.inputComment;
/* 106 */     this.inputer = this._super.inputer;
/* 107 */     this.inputTime = this._super.inputTime;
/* 108 */     this.packageCategory = (inits.isInitialized("packageCategory") ? new QPackageCategory(forProperty("packageCategory")) : null);
/* 109 */     this.sourceStock = (inits.isInitialized("sourceStock") ? new QStockId(forProperty("sourceStock"), inits.get("sourceStock")) : null);
/* 110 */     this.targetStock = (inits.isInitialized("targetStock") ? new QStockId(forProperty("targetStock"), inits.get("targetStock")) : null);
/* 111 */     this.type = (inits.isInitialized("type") ? new QSourceType(forProperty("type")) : null);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QStockChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */