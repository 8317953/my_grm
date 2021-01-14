/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.haut.grm.model.base.QAbstractBusiness;
/*     */ import com.haut.grm.model.meta.QUser;
/*     */ import com.haut.grm.model.standard.code.QGrainVariety;
/*     */ import com.haut.grm.model.type.QCountry;
/*     */ import com.haut.grm.model.type.QPackageCategory;
/*     */ import com.querydsl.core.types.Path;
/*     */ import com.querydsl.core.types.PathMetadata;
/*     */ import com.querydsl.core.types.dsl.BooleanPath;
/*     */ import com.querydsl.core.types.dsl.DateTimePath;
/*     */ import com.querydsl.core.types.dsl.NumberPath;
/*     */ import com.querydsl.core.types.dsl.PathInits;
/*     */ import com.querydsl.core.types.dsl.SetPath;
/*     */ import com.querydsl.core.types.dsl.StringPath;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class QStockId extends com.querydsl.core.types.dsl.EntityPathBase<StockId>
/*     */ {
/*     */   private static final long serialVersionUID = 508868381L;
/*  21 */   private static final PathInits INITS = new PathInits(new String[] { "*", "cargo.compartment.store.depot.*" });
/*     */   
/*  23 */   public static final QStockId stockId = new QStockId("stockId");
/*     */   
/*     */   public final QAbstractBusiness _super;
/*     */   
/*  27 */   public final NumberPath<Long> amount = createNumber("amount", Long.class);
/*     */   
/*     */ 
/*     */   public final StringPath auditComment;
/*     */   
/*     */ 
/*     */   public final QUser auditor;
/*     */   
/*     */ 
/*     */   public final DateTimePath<Date> auditTime;
/*     */   
/*     */ 
/*     */   public final StringPath businessKey;
/*     */   
/*     */   public final com.haut.grm.model.QCargo cargo;
/*     */   
/*     */   public final QCountry country;
/*     */   
/*  45 */   public final NumberPath<Double> deductVolume = createNumber("deductVolume", Double.class);
/*     */   
/*  47 */   public final NumberPath<Double> factor = createNumber("factor", Double.class);
/*     */   
/*     */ 
/*     */   public final com.haut.grm.model.type.QGrainType grainType;
/*     */   
/*     */   public final QGrainVariety grainVariety;
/*     */   
/*     */   public final NumberPath<Long> id;
/*     */   
/*  56 */   public final BooleanPath inFinished = createBoolean("inFinished");
/*     */   
/*     */ 
/*     */   public final StringPath inputComment;
/*     */   
/*     */ 
/*     */   public final QUser inputer;
/*     */   
/*     */ 
/*     */   public final DateTimePath<Date> inputTime;
/*     */   
/*  67 */   public final DateTimePath<Date> inTime = createDateTime("inTime", Date.class);
/*     */   
/*  69 */   public final StringPath location = createString("location");
/*     */   
/*  71 */   public final SetPath<StockChange, QStockChange> negetiveStockChanges = createSet("negetiveStockChanges", StockChange.class, QStockChange.class, PathInits.DIRECT2);
/*     */   
/*  73 */   public final BooleanPath outFinished = createBoolean("outFinished");
/*     */   
/*  75 */   public final DateTimePath<Date> outTime = createDateTime("outTime", Date.class);
/*     */   
/*     */   public final QPackageCategory packageCategory;
/*     */   
/*     */   public final com.haut.grm.model.type.QPackageType packageType;
/*     */   
/*  81 */   public final SetPath<StockChange, QStockChange> positiveStockChanges = createSet("positiveStockChanges", StockChange.class, QStockChange.class, PathInits.DIRECT2);
/*     */   
/*  83 */   public final SetPath<StockAnalysis, QStockAnalysis> stockAnalyses = createSet("stockAnalyses", StockAnalysis.class, QStockAnalysis.class, PathInits.DIRECT2);
/*     */   
/*  85 */   public final NumberPath<Double> unitWeight = createNumber("unitWeight", Double.class);
/*     */   
/*  87 */   public final StringPath year = createString("year");
/*     */   
/*     */   public QStockId(String variable) {
/*  90 */     this(StockId.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable), INITS);
/*     */   }
/*     */   
/*     */   public QStockId(Path<? extends StockId> path) {
/*  94 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*     */   }
/*     */   
/*     */   public QStockId(PathMetadata metadata) {
/*  98 */     this(metadata, PathInits.getFor(metadata, INITS));
/*     */   }
/*     */   
/*     */   public QStockId(PathMetadata metadata, PathInits inits) {
/* 102 */     this(StockId.class, metadata, inits);
/*     */   }
/*     */   
/*     */   public QStockId(Class<? extends StockId> type, PathMetadata metadata, PathInits inits) {
/* 106 */     super(type, metadata, inits);
/* 107 */     this._super = new QAbstractBusiness(type, metadata, inits);
/* 108 */     this.auditComment = this._super.auditComment;
/* 109 */     this.auditor = this._super.auditor;
/* 110 */     this.auditTime = this._super.auditTime;
/* 111 */     this.businessKey = this._super.businessKey;
/* 112 */     this.cargo = (inits.isInitialized("cargo") ? new com.haut.grm.model.QCargo(forProperty("cargo"), inits.get("cargo")) : null);
/* 113 */     this.country = (inits.isInitialized("country") ? new QCountry(forProperty("country")) : null);
/* 114 */     this.grainType = (inits.isInitialized("grainType") ? new com.haut.grm.model.type.QGrainType(forProperty("grainType")) : null);
/* 115 */     this.grainVariety = (inits.isInitialized("grainVariety") ? new QGrainVariety(forProperty("grainVariety")) : null);
/* 116 */     this.id = this._super.id;
/* 117 */     this.inputComment = this._super.inputComment;
/* 118 */     this.inputer = this._super.inputer;
/* 119 */     this.inputTime = this._super.inputTime;
/* 120 */     this.packageCategory = (inits.isInitialized("packageCategory") ? new QPackageCategory(forProperty("packageCategory")) : null);
/* 121 */     this.packageType = (inits.isInitialized("packageType") ? new com.haut.grm.model.type.QPackageType(forProperty("packageType")) : null);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QStockId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */