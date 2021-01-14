/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.haut.grm.model.QCompartment;
/*     */ import com.haut.grm.model.QStore;
/*     */ import com.haut.grm.model.base.QAbstractEntity;
/*     */ import com.haut.grm.model.standard.code.QGrainVariety;
/*     */ import com.haut.grm.model.type.QAnalysisLevel;
/*     */ import com.haut.grm.model.type.QAnalysisType;
/*     */ import com.querydsl.core.types.Path;
/*     */ import com.querydsl.core.types.PathMetadata;
/*     */ import com.querydsl.core.types.dsl.BooleanPath;
/*     */ import com.querydsl.core.types.dsl.DateTimePath;
/*     */ import com.querydsl.core.types.dsl.NumberPath;
/*     */ import com.querydsl.core.types.dsl.PathInits;
/*     */ import com.querydsl.core.types.dsl.StringPath;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class QStockAgg extends com.querydsl.core.types.dsl.EntityPathBase<StockAgg>
/*     */ {
/*     */   private static final long serialVersionUID = -1404956865L;
/*  21 */   private static final PathInits INITS = new PathInits(new String[] { "*", "cargo.compartment.store.depot.*" });
/*     */   
/*  23 */   public static final QStockAgg stockAgg = new QStockAgg("stockAgg");
/*     */   
/*  25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*     */   
/*  27 */   public final NumberPath<Double> a1 = createNumber("a1", Double.class);
/*     */   
/*  29 */   public final NumberPath<Double> a10 = createNumber("a10", Double.class);
/*     */   
/*  31 */   public final NumberPath<Double> a11 = createNumber("a11", Double.class);
/*     */   
/*  33 */   public final NumberPath<Double> a12 = createNumber("a12", Double.class);
/*     */   
/*  35 */   public final NumberPath<Integer> a13 = createNumber("a13", Integer.class);
/*     */   
/*  37 */   public final NumberPath<Double> a14 = createNumber("a14", Double.class);
/*     */   
/*  39 */   public final NumberPath<Double> a15 = createNumber("a15", Double.class);
/*     */   
/*  41 */   public final NumberPath<Double> a2 = createNumber("a2", Double.class);
/*     */   
/*  43 */   public final NumberPath<Double> a3 = createNumber("a3", Double.class);
/*     */   
/*  45 */   public final NumberPath<Double> a4 = createNumber("a4", Double.class);
/*     */   
/*  47 */   public final NumberPath<Double> a5 = createNumber("a5", Double.class);
/*     */   
/*  49 */   public final NumberPath<Double> a6 = createNumber("a6", Double.class);
/*     */   
/*  51 */   public final NumberPath<Double> a7 = createNumber("a7", Double.class);
/*     */   
/*  53 */   public final NumberPath<Double> a8 = createNumber("a8", Double.class);
/*     */   
/*  55 */   public final NumberPath<Double> a9 = createNumber("a9", Double.class);
/*     */   
/*  57 */   public final NumberPath<Long> amount = createNumber("amount", Long.class);
/*     */   
/*     */   public final QAnalysisLevel analysisLevel;
/*     */   
/*     */   public final QAnalysisType analysisType;
/*     */   
/*  63 */   public final StringPath businessKey = createString("businessKey");
/*     */   
/*     */   public final com.haut.grm.model.QCargo cargo;
/*     */   
/*     */   public final QCompartment compartment;
/*     */   
/*  69 */   public final NumberPath<Double> deductVolume = createNumber("deductVolume", Double.class);
/*     */   
/*     */   public final com.haut.grm.model.QDepot depot;
/*     */   
/*  73 */   public final NumberPath<Double> factor = createNumber("factor", Double.class);
/*     */   
/*     */   public final com.haut.grm.model.type.QGrainType grainType;
/*     */   
/*     */   public final QGrainVariety grainVariety;
/*     */   
/*  79 */   public final StringPath id = createString("id");
/*     */   
/*  81 */   public final NumberPath<Long> inAmount = createNumber("inAmount", Long.class);
/*     */   
/*  83 */   public final BooleanPath inFinished = createBoolean("inFinished");
/*     */   
/*  85 */   public final DateTimePath<Date> inputTime = createDateTime("inputTime", Date.class);
/*     */   
/*  87 */   public final DateTimePath<Date> inTime = createDateTime("inTime", Date.class);
/*     */   
/*  89 */   public final StringPath location = createString("location");
/*     */   
/*  91 */   public final NumberPath<Long> outAmount = createNumber("outAmount", Long.class);
/*     */   
/*  93 */   public final BooleanPath outFinished = createBoolean("outFinished");
/*     */   
/*  95 */   public final DateTimePath<Date> outTime = createDateTime("outTime", Date.class);
/*     */   
/*     */   public final com.haut.grm.model.type.QPackageCategory packageCategory;
/*     */   
/*     */   public final com.haut.grm.model.type.QPackageType packageType;
/*     */   
/* 101 */   public final StringPath s1 = createString("s1");
/*     */   
/* 103 */   public final StringPath s2 = createString("s2");
/*     */   
/* 105 */   public final StringPath s3 = createString("s3");
/*     */   
/* 107 */   public final StringPath s4 = createString("s4");
/*     */   
/* 109 */   public final StringPath s5 = createString("s5");
/*     */   
/*     */   public final QStockId stock;
/*     */   
/*     */   public final QStore store;
/*     */   
/* 115 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*     */   
/* 117 */   public final NumberPath<Double> unitWeight = createNumber("unitWeight", Double.class);
/*     */   
/* 119 */   public final StringPath year = createString("year");
/*     */   
/*     */   public QStockAgg(String variable) {
/* 122 */     this(StockAgg.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable), INITS);
/*     */   }
/*     */   
/*     */   public QStockAgg(Path<? extends StockAgg> path) {
/* 126 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*     */   }
/*     */   
/*     */   public QStockAgg(PathMetadata metadata) {
/* 130 */     this(metadata, PathInits.getFor(metadata, INITS));
/*     */   }
/*     */   
/*     */   public QStockAgg(PathMetadata metadata, PathInits inits) {
/* 134 */     this(StockAgg.class, metadata, inits);
/*     */   }
/*     */   
/*     */   public QStockAgg(Class<? extends StockAgg> type, PathMetadata metadata, PathInits inits) {
/* 138 */     super(type, metadata, inits);
/* 139 */     this.analysisLevel = (inits.isInitialized("analysisLevel") ? new QAnalysisLevel(forProperty("analysisLevel")) : null);
/* 140 */     this.analysisType = (inits.isInitialized("analysisType") ? new QAnalysisType(forProperty("analysisType")) : null);
/* 141 */     this.cargo = (inits.isInitialized("cargo") ? new com.haut.grm.model.QCargo(forProperty("cargo"), inits.get("cargo")) : null);
/* 142 */     this.compartment = (inits.isInitialized("compartment") ? new QCompartment(forProperty("compartment"), inits.get("compartment")) : null);
/* 143 */     this.depot = (inits.isInitialized("depot") ? new com.haut.grm.model.QDepot(forProperty("depot"), inits.get("depot")) : null);
/* 144 */     this.grainType = (inits.isInitialized("grainType") ? new com.haut.grm.model.type.QGrainType(forProperty("grainType")) : null);
/* 145 */     this.grainVariety = (inits.isInitialized("grainVariety") ? new QGrainVariety(forProperty("grainVariety")) : null);
/* 146 */     this.packageCategory = (inits.isInitialized("packageCategory") ? new com.haut.grm.model.type.QPackageCategory(forProperty("packageCategory")) : null);
/* 147 */     this.packageType = (inits.isInitialized("packageType") ? new com.haut.grm.model.type.QPackageType(forProperty("packageType")) : null);
/* 148 */     this.stock = (inits.isInitialized("stock") ? new QStockId(forProperty("stock"), inits.get("stock")) : null);
/* 149 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QStockAgg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */