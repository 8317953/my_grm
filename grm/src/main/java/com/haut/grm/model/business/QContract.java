/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.haut.grm.model.QDepot;
/*     */ import com.haut.grm.model.base.QAbstractBusiness;
/*     */ import com.haut.grm.model.meta.QUser;
/*     */ import com.haut.grm.model.standard.code.QGrainVariety;
/*     */ import com.haut.grm.model.type.QGrainType;
/*     */ import com.haut.grm.model.type.QPackageType;
/*     */ import com.haut.grm.model.type.QScale;
/*     */ import com.querydsl.core.types.Path;
/*     */ import com.querydsl.core.types.PathMetadata;
/*     */ import com.querydsl.core.types.dsl.EntityPathBase;
/*     */ import com.querydsl.core.types.dsl.NumberPath;
/*     */ import com.querydsl.core.types.dsl.PathInits;
/*     */ import com.querydsl.core.types.dsl.StringPath;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class QContract extends EntityPathBase<Contract>
/*     */ {
/*     */   private static final long serialVersionUID = 619607622L;
/*  21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*     */   
/*  23 */   public static final QContract contract = new QContract("contract");
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
/*     */   public final com.querydsl.core.types.dsl.DateTimePath<Date> auditTime;
/*     */   
/*     */ 
/*     */   public final StringPath businessKey;
/*     */   
/*     */ 
/*     */   public final QClient client;
/*     */   
/*     */ 
/*     */   public final QDepot depot;
/*     */   
/*     */ 
/*     */   public final QGrainType grainType;
/*     */   
/*     */ 
/*     */   public final QGrainVariety grainVariety;
/*     */   
/*     */   public final NumberPath<Long> id;
/*     */   
/*     */   public final StringPath inputComment;
/*     */   
/*     */   public final QUser inputer;
/*     */   
/*     */   public final com.querydsl.core.types.dsl.DateTimePath<Date> inputTime;
/*     */   
/*  61 */   public final com.querydsl.core.types.dsl.BooleanPath isIngress = createBoolean("isIngress");
/*     */   
/*  63 */   public final StringPath name = createString("name");
/*     */   
/*     */   public final QPackageType packageType;
/*     */   
/*  67 */   public final NumberPath<Double> price = createNumber("price", Double.class);
/*     */   
/*     */   public final QScale scale;
/*     */   
/*  71 */   public final NumberPath<Double> totalPrice = createNumber("totalPrice", Double.class);
/*     */   public final com.haut.grm.model.type.QContractType type;
/*     */   
/*     */   public QContract(String variable)
/*     */   {
/*  76 */     this(Contract.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable), INITS);
/*     */   }
/*     */   
/*     */   public QContract(Path<? extends Contract> path) {
/*  80 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*     */   }
/*     */   
/*     */   public QContract(PathMetadata metadata) {
/*  84 */     this(metadata, PathInits.getFor(metadata, INITS));
/*     */   }
/*     */   
/*     */   public QContract(PathMetadata metadata, PathInits inits) {
/*  88 */     this(Contract.class, metadata, inits);
/*     */   }
/*     */   
/*     */   public QContract(Class<? extends Contract> type, PathMetadata metadata, PathInits inits) {
/*  92 */     super(type, metadata, inits);
/*  93 */     this._super = new QAbstractBusiness(type, metadata, inits);
/*  94 */     this.auditComment = this._super.auditComment;
/*  95 */     this.auditor = this._super.auditor;
/*  96 */     this.auditTime = this._super.auditTime;
/*  97 */     this.businessKey = this._super.businessKey;
/*  98 */     this.client = (inits.isInitialized("client") ? new QClient(forProperty("client"), inits.get("client")) : null);
/*  99 */     this.depot = (inits.isInitialized("depot") ? new QDepot(forProperty("depot"), inits.get("depot")) : null);
/* 100 */     this.grainType = (inits.isInitialized("grainType") ? new QGrainType(forProperty("grainType")) : null);
/* 101 */     this.grainVariety = (inits.isInitialized("grainVariety") ? new QGrainVariety(forProperty("grainVariety")) : null);
/* 102 */     this.id = this._super.id;
/* 103 */     this.inputComment = this._super.inputComment;
/* 104 */     this.inputer = this._super.inputer;
/* 105 */     this.inputTime = this._super.inputTime;
/* 106 */     this.packageType = (inits.isInitialized("packageType") ? new QPackageType(forProperty("packageType")) : null);
/* 107 */     this.scale = (inits.isInitialized("scale") ? new QScale(forProperty("scale")) : null);
/* 108 */     this.type = (inits.isInitialized("type") ? new com.haut.grm.model.type.QContractType(forProperty("type")) : null);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QContract.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */