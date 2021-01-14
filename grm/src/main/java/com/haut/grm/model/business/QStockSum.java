/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.haut.grm.model.QCargoRepView;
/*     */ import com.haut.grm.model.base.QAbstractBusiness;
/*     */ import com.haut.grm.model.meta.QUser;
/*     */ import com.haut.grm.model.type.QAnalysisLevel;
/*     */ import com.haut.grm.model.type.QCountry;
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
/*     */ public class QStockSum extends com.querydsl.core.types.dsl.EntityPathBase<StockSum>
/*     */ {
/*     */   private static final long serialVersionUID = -1404939127L;
/*  21 */   private static final PathInits INITS = new PathInits(new String[] { "*", "cargo.compartment.store.depot.*" });
/*     */   
/*  23 */   public static final QStockSum stockSum = new QStockSum("stockSum");
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
/*     */   public final QCargoRepView cargo;
/*     */   
/*  43 */   public final StringPath cargoName = createString("cargoName");
/*     */   
/*  45 */   public final StringPath cargoNameShort = createString("cargoNameShort");
/*     */   
/*     */   public final QCountry country;
/*     */   
/*  49 */   public final NumberPath<Double> deductVolume = createNumber("deductVolume", Double.class);
/*     */   
/*  51 */   public final NumberPath<Double> factor = createNumber("factor", Double.class);
/*     */   
/*     */   public final com.haut.grm.model.type.QGrainType grainType;
/*     */   
/*     */   public final com.haut.grm.model.standard.code.QGrainVariety grainVariety;
/*     */   
/*  57 */   public final NumberPath<Double> i_a1 = createNumber("i_a1", Double.class);
/*     */   
/*  59 */   public final NumberPath<Double> i_a10 = createNumber("i_a10", Double.class);
/*     */   
/*  61 */   public final NumberPath<Double> i_a11 = createNumber("i_a11", Double.class);
/*     */   
/*  63 */   public final NumberPath<Double> i_a12 = createNumber("i_a12", Double.class);
/*     */   
/*  65 */   public final NumberPath<Integer> i_a13 = createNumber("i_a13", Integer.class);
/*     */   
/*  67 */   public final NumberPath<Double> i_a14 = createNumber("i_a14", Double.class);
/*     */   
/*  69 */   public final NumberPath<Double> i_a15 = createNumber("i_a15", Double.class);
/*     */   
/*  71 */   public final NumberPath<Integer> i_a16 = createNumber("i_a16", Integer.class);
/*     */   
/*  73 */   public final NumberPath<Integer> i_a17 = createNumber("i_a17", Integer.class);
/*     */   
/*  75 */   public final NumberPath<Double> i_a2 = createNumber("i_a2", Double.class);
/*     */   
/*  77 */   public final NumberPath<Double> i_a3 = createNumber("i_a3", Double.class);
/*     */   
/*  79 */   public final NumberPath<Double> i_a4 = createNumber("i_a4", Double.class);
/*     */   
/*  81 */   public final NumberPath<Double> i_a5 = createNumber("i_a5", Double.class);
/*     */   
/*  83 */   public final NumberPath<Double> i_a6 = createNumber("i_a6", Double.class);
/*     */   
/*  85 */   public final NumberPath<Double> i_a7 = createNumber("i_a7", Double.class);
/*     */   
/*  87 */   public final NumberPath<Double> i_a8 = createNumber("i_a8", Double.class);
/*     */   
/*  89 */   public final NumberPath<Double> i_a9 = createNumber("i_a9", Double.class);
/*     */   
/*     */   public final QAnalysisLevel i_analysisLevel;
/*     */   
/*  93 */   public final StringPath i_s1 = createString("i_s1");
/*     */   
/*  95 */   public final StringPath i_s2 = createString("i_s2");
/*     */   
/*  97 */   public final StringPath i_s3 = createString("i_s3");
/*     */   
/*  99 */   public final StringPath i_s4 = createString("i_s4");
/*     */   
/* 101 */   public final StringPath i_s5 = createString("i_s5");
/*     */   
/*     */ 
/*     */   public final NumberPath<Long> id;
/*     */   
/* 106 */   public final NumberPath<Long> inAmount = createNumber("inAmount", Long.class);
/*     */   
/* 108 */   public final BooleanPath inFinished = createBoolean("inFinished");
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
/* 119 */   public final DateTimePath<Date> inTime = createDateTime("inTime", Date.class);
/*     */   
/* 121 */   public final NumberPath<Double> l_a1 = createNumber("l_a1", Double.class);
/*     */   
/* 123 */   public final NumberPath<Double> l_a10 = createNumber("l_a10", Double.class);
/*     */   
/* 125 */   public final NumberPath<Double> l_a11 = createNumber("l_a11", Double.class);
/*     */   
/* 127 */   public final NumberPath<Double> l_a12 = createNumber("l_a12", Double.class);
/*     */   
/* 129 */   public final NumberPath<Integer> l_a13 = createNumber("l_a13", Integer.class);
/*     */   
/* 131 */   public final NumberPath<Double> l_a14 = createNumber("l_a14", Double.class);
/*     */   
/* 133 */   public final NumberPath<Double> l_a15 = createNumber("l_a15", Double.class);
/*     */   
/* 135 */   public final NumberPath<Integer> l_a16 = createNumber("l_a16", Integer.class);
/*     */   
/* 137 */   public final NumberPath<Integer> l_a17 = createNumber("l_a17", Integer.class);
/*     */   
/* 139 */   public final NumberPath<Double> l_a2 = createNumber("l_a2", Double.class);
/*     */   
/* 141 */   public final NumberPath<Double> l_a3 = createNumber("l_a3", Double.class);
/*     */   
/* 143 */   public final NumberPath<Double> l_a4 = createNumber("l_a4", Double.class);
/*     */   
/* 145 */   public final NumberPath<Double> l_a5 = createNumber("l_a5", Double.class);
/*     */   
/* 147 */   public final NumberPath<Double> l_a6 = createNumber("l_a6", Double.class);
/*     */   
/* 149 */   public final NumberPath<Double> l_a7 = createNumber("l_a7", Double.class);
/*     */   
/* 151 */   public final NumberPath<Double> l_a8 = createNumber("l_a8", Double.class);
/*     */   
/* 153 */   public final NumberPath<Double> l_a9 = createNumber("l_a9", Double.class);
/*     */   
/*     */   public final QAnalysisLevel l_analysisLevel;
/*     */   
/* 157 */   public final StringPath l_s1 = createString("l_s1");
/*     */   
/* 159 */   public final StringPath l_s2 = createString("l_s2");
/*     */   
/* 161 */   public final StringPath l_s3 = createString("l_s3");
/*     */   
/* 163 */   public final StringPath l_s4 = createString("l_s4");
/*     */   
/* 165 */   public final StringPath l_s5 = createString("l_s5");
/*     */   
/* 167 */   public final StringPath location = createString("location");
/*     */   
/* 169 */   public final SetPath<StockChange, QStockChange> negetiveStockChanges = createSet("negetiveStockChanges", StockChange.class, QStockChange.class, PathInits.DIRECT2);
/*     */   
/* 171 */   public final NumberPath<Double> o_a1 = createNumber("o_a1", Double.class);
/*     */   
/* 173 */   public final NumberPath<Double> o_a10 = createNumber("o_a10", Double.class);
/*     */   
/* 175 */   public final NumberPath<Double> o_a11 = createNumber("o_a11", Double.class);
/*     */   
/* 177 */   public final NumberPath<Double> o_a12 = createNumber("o_a12", Double.class);
/*     */   
/* 179 */   public final NumberPath<Integer> o_a13 = createNumber("o_a13", Integer.class);
/*     */   
/* 181 */   public final NumberPath<Double> o_a14 = createNumber("o_a14", Double.class);
/*     */   
/* 183 */   public final NumberPath<Double> o_a15 = createNumber("o_a15", Double.class);
/*     */   
/* 185 */   public final NumberPath<Integer> o_a16 = createNumber("o_a16", Integer.class);
/*     */   
/* 187 */   public final NumberPath<Integer> o_a17 = createNumber("o_a17", Integer.class);
/*     */   
/* 189 */   public final NumberPath<Double> o_a2 = createNumber("o_a2", Double.class);
/*     */   
/* 191 */   public final NumberPath<Double> o_a3 = createNumber("o_a3", Double.class);
/*     */   
/* 193 */   public final NumberPath<Double> o_a4 = createNumber("o_a4", Double.class);
/*     */   
/* 195 */   public final NumberPath<Double> o_a5 = createNumber("o_a5", Double.class);
/*     */   
/* 197 */   public final NumberPath<Double> o_a6 = createNumber("o_a6", Double.class);
/*     */   
/* 199 */   public final NumberPath<Double> o_a7 = createNumber("o_a7", Double.class);
/*     */   
/* 201 */   public final NumberPath<Double> o_a8 = createNumber("o_a8", Double.class);
/*     */   
/* 203 */   public final NumberPath<Double> o_a9 = createNumber("o_a9", Double.class);
/*     */   
/*     */   public final QAnalysisLevel o_analysisLevel;
/*     */   
/* 207 */   public final StringPath o_s1 = createString("o_s1");
/*     */   
/* 209 */   public final StringPath o_s2 = createString("o_s2");
/*     */   
/* 211 */   public final StringPath o_s3 = createString("o_s3");
/*     */   
/* 213 */   public final StringPath o_s4 = createString("o_s4");
/*     */   
/* 215 */   public final StringPath o_s5 = createString("o_s5");
/*     */   
/* 217 */   public final NumberPath<Long> outAmount = createNumber("outAmount", Long.class);
/*     */   
/* 219 */   public final BooleanPath outFinished = createBoolean("outFinished");
/*     */   
/* 221 */   public final DateTimePath<Date> outTime = createDateTime("outTime", Date.class);
/*     */   
/*     */   public final com.haut.grm.model.type.QPackageCategory packageCategory;
/*     */   
/*     */   public final com.haut.grm.model.type.QPackageType packageType;
/*     */   
/* 227 */   public final SetPath<StockChange, QStockChange> positiveStockChanges = createSet("positiveStockChanges", StockChange.class, QStockChange.class, PathInits.DIRECT2);
/*     */   
/* 229 */   public final SetPath<StockAnalysis, QStockAnalysis> stockAnalyses = createSet("stockAnalyses", StockAnalysis.class, QStockAnalysis.class, PathInits.DIRECT2);
/*     */   
/* 231 */   public final NumberPath<Double> unitWeight = createNumber("unitWeight", Double.class);
/*     */   
/* 233 */   public final StringPath year = createString("year");
/*     */   
/*     */   public QStockSum(String variable) {
/* 236 */     this(StockSum.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable), INITS);
/*     */   }
/*     */   
/*     */   public QStockSum(Path<? extends StockSum> path) {
/* 240 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*     */   }
/*     */   
/*     */   public QStockSum(PathMetadata metadata) {
/* 244 */     this(metadata, PathInits.getFor(metadata, INITS));
/*     */   }
/*     */   
/*     */   public QStockSum(PathMetadata metadata, PathInits inits) {
/* 248 */     this(StockSum.class, metadata, inits);
/*     */   }
/*     */   
/*     */   public QStockSum(Class<? extends StockSum> type, PathMetadata metadata, PathInits inits) {
/* 252 */     super(type, metadata, inits);
/* 253 */     this._super = new QAbstractBusiness(type, metadata, inits);
/* 254 */     this.auditComment = this._super.auditComment;
/* 255 */     this.auditor = this._super.auditor;
/* 256 */     this.auditTime = this._super.auditTime;
/* 257 */     this.businessKey = this._super.businessKey;
/* 258 */     this.cargo = (inits.isInitialized("cargo") ? new QCargoRepView(forProperty("cargo"), inits.get("cargo")) : null);
/* 259 */     this.country = (inits.isInitialized("country") ? new QCountry(forProperty("country")) : null);
/* 260 */     this.grainType = (inits.isInitialized("grainType") ? new com.haut.grm.model.type.QGrainType(forProperty("grainType")) : null);
/* 261 */     this.grainVariety = (inits.isInitialized("grainVariety") ? new com.haut.grm.model.standard.code.QGrainVariety(forProperty("grainVariety")) : null);
/* 262 */     this.i_analysisLevel = (inits.isInitialized("i_analysisLevel") ? new QAnalysisLevel(forProperty("i_analysisLevel")) : null);
/* 263 */     this.id = this._super.id;
/* 264 */     this.inputComment = this._super.inputComment;
/* 265 */     this.inputer = this._super.inputer;
/* 266 */     this.inputTime = this._super.inputTime;
/* 267 */     this.l_analysisLevel = (inits.isInitialized("l_analysisLevel") ? new QAnalysisLevel(forProperty("l_analysisLevel")) : null);
/* 268 */     this.o_analysisLevel = (inits.isInitialized("o_analysisLevel") ? new QAnalysisLevel(forProperty("o_analysisLevel")) : null);
/* 269 */     this.packageCategory = (inits.isInitialized("packageCategory") ? new com.haut.grm.model.type.QPackageCategory(forProperty("packageCategory")) : null);
/* 270 */     this.packageType = (inits.isInitialized("packageType") ? new com.haut.grm.model.type.QPackageType(forProperty("packageType")) : null);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QStockSum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */