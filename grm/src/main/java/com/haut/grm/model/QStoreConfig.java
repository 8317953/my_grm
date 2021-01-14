/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.haut.grm.model.meta.QStoreModel;
/*     */ import com.haut.grm.model.meta.QUser;
/*     */ import com.haut.grm.model.standard.code.QStoreType;
/*     */ import com.haut.grm.model.system.QCoreVersion;
/*     */ import com.haut.grm.model.type.QPackageCategory;
/*     */ import com.haut.grm.model.type.QStorageType;
/*     */ import com.haut.grm.model.type.QStructureType;
/*     */ import com.haut.grm.model.type.QTemperatureControlType;
/*     */ import com.querydsl.core.types.Path;
/*     */ import com.querydsl.core.types.PathMetadata;
/*     */ import com.querydsl.core.types.dsl.BooleanPath;
/*     */ import com.querydsl.core.types.dsl.NumberPath;
/*     */ import com.querydsl.core.types.dsl.PathInits;
/*     */ import com.querydsl.core.types.dsl.StringPath;
/*     */ 
/*     */ public class QStoreConfig extends com.querydsl.core.types.dsl.EntityPathBase<StoreConfig>
/*     */ {
/*     */   private static final long serialVersionUID = 603762313L;
/*  21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*     */   
/*  23 */   public static final QStoreConfig storeConfig = new QStoreConfig("storeConfig");
/*     */   
/*  25 */   public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);
/*     */   
/*  27 */   public final StringPath cableData = createString("cableData");
/*     */   
/*     */   public final QStructureType frameStructure;
/*     */   
/*     */   public final QStructureType groundStructure;
/*     */   
/*  33 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*     */   
/*  35 */   public final BooleanPath isChargeable = createBoolean("isChargeable");
/*     */   
/*  37 */   public final BooleanPath isDemo = createBoolean("isDemo");
/*     */   
/*  39 */   public final BooleanPath isFumigatable = createBoolean("isFumigatable");
/*     */   
/*  41 */   public final BooleanPath isInsecticidal = createBoolean("isInsecticidal");
/*     */   
/*  43 */   public final BooleanPath isInsectsensitive = createBoolean("isInsectsensitive");
/*     */   
/*  45 */   public final BooleanPath isInsulated = createBoolean("isInsulated");
/*     */   
/*  47 */   public final BooleanPath isPackagelessable = createBoolean("isPackagelessable");
/*     */   
/*  49 */   public final BooleanPath isProcessed = createBoolean("isProcessed");
/*     */   
/*  51 */   public final BooleanPath isRemote = createBoolean("isRemote");
/*     */   
/*  53 */   public final BooleanPath isRetardant = createBoolean("isRetardant");
/*     */   
/*  55 */   public final BooleanPath isTemperaturable = createBoolean("isTemperaturable");
/*     */   
/*  57 */   public final BooleanPath isVentilatable = createBoolean("isVentilatable");
/*     */   
/*     */   public final QUser manager;
/*     */   
/*     */   public final QStoreModel model;
/*     */   
/*     */   public final QPackageCategory packageCategory;
/*     */   
/*     */   public final QStructureType roofStructure;
/*     */   
/*  67 */   public final StringPath sourcePositionX = createString("sourcePositionX");
/*     */   
/*  69 */   public final StringPath sourcePositionY = createString("sourcePositionY");
/*     */   
/*     */   public final QStorageType storageType;
/*     */   
/*     */   public final QStore store;
/*     */   
/*  75 */   public final StringPath targetPositionX = createString("targetPositionX");
/*     */   
/*  77 */   public final StringPath targetPositionY = createString("targetPositionY");
/*     */   
/*  79 */   public final NumberPath<Long> tempBreadth = createNumber("tempBreadth", Long.class);
/*     */   
/*     */   public final QTemperatureControlType temperatureControlType;
/*     */   
/*  83 */   public final NumberPath<Long> tempLayer = createNumber("tempLayer", Long.class);
/*     */   
/*  85 */   public final NumberPath<Long> tempWidth = createNumber("tempWidth", Long.class);
/*     */   
/*     */   public final QStoreType type;
/*     */   
/*     */   public final QCoreVersion version;
/*     */   public final QStructureType wallStructure;
/*     */   
/*     */   public QStoreConfig(String variable)
/*     */   {
/*  94 */     this(StoreConfig.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable), INITS);
/*     */   }
/*     */   
/*     */   public QStoreConfig(Path<? extends StoreConfig> path) {
/*  98 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*     */   }
/*     */   
/*     */   public QStoreConfig(PathMetadata metadata) {
/* 102 */     this(metadata, PathInits.getFor(metadata, INITS));
/*     */   }
/*     */   
/*     */   public QStoreConfig(PathMetadata metadata, PathInits inits) {
/* 106 */     this(StoreConfig.class, metadata, inits);
/*     */   }
/*     */   
/*     */   public QStoreConfig(Class<? extends StoreConfig> type, PathMetadata metadata, PathInits inits) {
/* 110 */     super(type, metadata, inits);
/* 111 */     this.frameStructure = (inits.isInitialized("frameStructure") ? new QStructureType(forProperty("frameStructure")) : null);
/* 112 */     this.groundStructure = (inits.isInitialized("groundStructure") ? new QStructureType(forProperty("groundStructure")) : null);
/* 113 */     this.manager = (inits.isInitialized("manager") ? new QUser(forProperty("manager"), inits.get("manager")) : null);
/* 114 */     this.model = (inits.isInitialized("model") ? new QStoreModel(forProperty("model")) : null);
/* 115 */     this.packageCategory = (inits.isInitialized("packageCategory") ? new QPackageCategory(forProperty("packageCategory")) : null);
/* 116 */     this.roofStructure = (inits.isInitialized("roofStructure") ? new QStructureType(forProperty("roofStructure")) : null);
/* 117 */     this.storageType = (inits.isInitialized("storageType") ? new QStorageType(forProperty("storageType")) : null);
/* 118 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/* 119 */     this.temperatureControlType = (inits.isInitialized("temperatureControlType") ? new QTemperatureControlType(forProperty("temperatureControlType")) : null);
/* 120 */     this.type = (inits.isInitialized("type") ? new QStoreType(forProperty("type")) : null);
/* 121 */     this.version = (inits.isInitialized("version") ? new QCoreVersion(forProperty("version")) : null);
/* 122 */     this.wallStructure = (inits.isInitialized("wallStructure") ? new QStructureType(forProperty("wallStructure")) : null);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\QStoreConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */