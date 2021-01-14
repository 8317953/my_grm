/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.haut.grm.model.base.QAbstractEntity;
/*     */ import com.haut.grm.model.standard.code.QLocation;
/*     */ import com.haut.grm.model.type.QCompanyType;
/*     */ import com.haut.grm.model.type.QDepotCategory;
/*     */ import com.haut.grm.model.type.QRoadType;
/*     */ import com.querydsl.core.types.Path;
/*     */ import com.querydsl.core.types.PathMetadata;
/*     */ import com.querydsl.core.types.PathMetadataFactory;
/*     */ import com.querydsl.core.types.dsl.BooleanPath;
/*     */ import com.querydsl.core.types.dsl.EntityPathBase;
/*     */ import com.querydsl.core.types.dsl.NumberPath;
/*     */ import com.querydsl.core.types.dsl.PathInits;
/*     */ import com.querydsl.core.types.dsl.StringPath;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class QDepot extends EntityPathBase<Depot>
/*     */ {
/*     */   private static final long serialVersionUID = -1530250822L;
/*  21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*     */   
/*  23 */   public static final QDepot depot = new QDepot("depot");
/*     */   
/*  25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*     */   
/*  27 */   public final StringPath abbrev = createString("abbrev");
/*     */   
/*  29 */   public final NumberPath<Long> activeCapacity = createNumber("activeCapacity", Long.class);
/*     */   
/*  31 */   public final NumberPath<Long> activeOilCapacity = createNumber("activeOilCapacity", Long.class);
/*     */   
/*  33 */   public final StringPath address = createString("address");
/*     */   
/*  35 */   public final com.querydsl.core.types.dsl.DatePath<Date> builtDate = createDate("builtDate", Date.class);
/*     */   
/*  37 */   public final NumberPath<Long> capacity = createNumber("capacity", Long.class);
/*     */   
/*  39 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*     */   
/*  41 */   public final StringPath companyCode = createString("companyCode");
/*     */   
/*  43 */   public final StringPath companyName = createString("companyName");
/*     */   
/*  45 */   public final StringPath companyShortCode = createString("companyShortCode");
/*     */   
/*     */   public final QDepotCategory depotCategory;
/*     */   
/*     */   public final QCompanyType depotType;
/*     */   
/*  51 */   public final StringPath fax = createString("fax");
/*     */   
/*  53 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*     */   
/*  55 */   public final BooleanPath isOwn = createBoolean("isOwn");
/*     */   
/*  57 */   public final StringPath keyword = createString("keyword");
/*     */   
/*  59 */   public final NumberPath<Double> latitude = createNumber("latitude", Double.class);
/*     */   
/*     */   public final QLocation location;
/*     */   
/*  63 */   public final NumberPath<Double> longitude = createNumber("longitude", Double.class);
/*     */   
/*  65 */   public final StringPath managerName = createString("managerName");
/*     */   
/*  67 */   public final StringPath name = createString("name");
/*     */   
/*  69 */   public final NumberPath<Long> oilCapacity = createNumber("oilCapacity", Long.class);
/*     */   
/*  71 */   public final NumberPath<Integer> roadDistance = createNumber("roadDistance", Integer.class);
/*     */   
/*     */   public final QRoadType roadType;
/*     */   
/*  75 */   public final NumberPath<Double> space = createNumber("space", Double.class);
/*     */   
/*  77 */   public final StringPath telephone = createString("telephone");
/*     */   
/*  79 */   public final StringPath type = createString("type");
/*     */   
/*  81 */   public final StringPath zipCode = createString("zipCode");
/*     */   
/*     */   public QDepot(String variable) {
/*  84 */     this(Depot.class, PathMetadataFactory.forVariable(variable), INITS);
/*     */   }
/*     */   
/*     */   public QDepot(Path<? extends Depot> path) {
/*  88 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*     */   }
/*     */   
/*     */   public QDepot(PathMetadata metadata) {
/*  92 */     this(metadata, PathInits.getFor(metadata, INITS));
/*     */   }
/*     */   
/*     */   public QDepot(PathMetadata metadata, PathInits inits) {
/*  96 */     this(Depot.class, metadata, inits);
/*     */   }
/*     */   
/*     */   public QDepot(Class<? extends Depot> type, PathMetadata metadata, PathInits inits) {
/* 100 */     super(type, metadata, inits);
/* 101 */     this.depotCategory = (inits.isInitialized("depotCategory") ? new QDepotCategory(forProperty("depotCategory")) : null);
/* 102 */     this.depotType = (inits.isInitialized("depotType") ? new QCompanyType(forProperty("depotType")) : null);
/* 103 */     this.location = (inits.isInitialized("location") ? new QLocation(forProperty("location")) : null);
/* 104 */     this.roadType = (inits.isInitialized("roadType") ? new QRoadType(forProperty("roadType")) : null);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\QDepot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */