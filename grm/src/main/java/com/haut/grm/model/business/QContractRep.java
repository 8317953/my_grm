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
/*     */ public class QContractRep extends EntityPathBase<ContractRep>
/*     */ {
/*     */   private static final long serialVersionUID = -1038689161L;
/*  21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*     */   
/*  23 */   public static final QContractRep contractRep = new QContractRep("contractRep");
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
/*  69 */   public final StringPath readableName = createString("readableName");
/*     */   
/*     */   public final QScale scale;
/*     */   
/*  73 */   public final NumberPath<Double> totalPrice = createNumber("totalPrice", Double.class);
/*     */   public final com.haut.grm.model.type.QContractType type;
/*     */   
/*     */   public QContractRep(String variable)
/*     */   {
/*  78 */     this(ContractRep.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable), INITS);
/*     */   }
/*     */   
/*     */   public QContractRep(Path<? extends ContractRep> path) {
/*  82 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*     */   }
/*     */   
/*     */   public QContractRep(PathMetadata metadata) {
/*  86 */     this(metadata, PathInits.getFor(metadata, INITS));
/*     */   }
/*     */   
/*     */   public QContractRep(PathMetadata metadata, PathInits inits) {
/*  90 */     this(ContractRep.class, metadata, inits);
/*     */   }
/*     */   
/*     */   public QContractRep(Class<? extends ContractRep> type, PathMetadata metadata, PathInits inits) {
/*  94 */     super(type, metadata, inits);
/*  95 */     this._super = new QAbstractBusiness(type, metadata, inits);
/*  96 */     this.auditComment = this._super.auditComment;
/*  97 */     this.auditor = this._super.auditor;
/*  98 */     this.auditTime = this._super.auditTime;
/*  99 */     this.businessKey = this._super.businessKey;
/* 100 */     this.client = (inits.isInitialized("client") ? new QClient(forProperty("client"), inits.get("client")) : null);
/* 101 */     this.depot = (inits.isInitialized("depot") ? new QDepot(forProperty("depot"), inits.get("depot")) : null);
/* 102 */     this.grainType = (inits.isInitialized("grainType") ? new QGrainType(forProperty("grainType")) : null);
/* 103 */     this.grainVariety = (inits.isInitialized("grainVariety") ? new QGrainVariety(forProperty("grainVariety")) : null);
/* 104 */     this.id = this._super.id;
/* 105 */     this.inputComment = this._super.inputComment;
/* 106 */     this.inputer = this._super.inputer;
/* 107 */     this.inputTime = this._super.inputTime;
/* 108 */     this.packageType = (inits.isInitialized("packageType") ? new QPackageType(forProperty("packageType")) : null);
/* 109 */     this.scale = (inits.isInitialized("scale") ? new QScale(forProperty("scale")) : null);
/* 110 */     this.type = (inits.isInitialized("type") ? new com.haut.grm.model.type.QContractType(forProperty("type")) : null);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QContractRep.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */