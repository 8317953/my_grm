/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.haut.grm.model.base.QAbstractEntity;
/*     */ import com.haut.grm.model.standard.code.GrainVariety;
/*     */ import com.haut.grm.model.standard.code.QGrainVariety;
/*     */ import com.haut.grm.model.standard.code.QLocation;
/*     */ import com.haut.grm.model.type.QCompanyLevelType;
/*     */ import com.haut.grm.model.type.QCountry;
/*     */ import com.querydsl.core.types.Path;
/*     */ import com.querydsl.core.types.PathMetadata;
/*     */ import com.querydsl.core.types.dsl.BooleanPath;
/*     */ import com.querydsl.core.types.dsl.NumberPath;
/*     */ import com.querydsl.core.types.dsl.PathInits;
/*     */ import com.querydsl.core.types.dsl.SetPath;
/*     */ import com.querydsl.core.types.dsl.StringPath;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class QCompany extends com.querydsl.core.types.dsl.EntityPathBase<Company>
/*     */ {
/*     */   private static final long serialVersionUID = 1998774915L;
/*  21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*     */   
/*  23 */   public static final QCompany company = new QCompany("company");
/*     */   
/*  25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*     */   
/*  27 */   public final StringPath djjgbh = createString("djjgbh");
/*     */   
/*     */   public final QCountry frgb;
/*     */   
/*  31 */   public final StringPath frsfz = createString("frsfz");
/*     */   
/*  33 */   public final StringPath frsjh = createString("frsjh");
/*     */   
/*  35 */   public final StringPath frxm = createString("frxm");
/*     */   
/*     */   public final com.haut.grm.model.type.QIdType frzjlx;
/*     */   
/*  39 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*     */   
/*  41 */   public final NumberPath<Double> jd = createNumber("jd", Double.class);
/*     */   
/*     */   public final QLocation jydzbm;
/*     */   
/*     */   public final QCompanyLevelType lsgx;
/*     */   
/*  47 */   public final StringPath lssjdw = createString("lssjdw");
/*     */   
/*  49 */   public final NumberPath<Double> njgl = createNumber("njgl", Double.class);
/*     */   
/*  51 */   public final NumberPath<Double> njyl = createNumber("njyl", Double.class);
/*     */   
/*  53 */   public final NumberPath<Double> nsgl = createNumber("nsgl", Double.class);
/*     */   
/*  55 */   public final StringPath qydm = createString("qydm");
/*     */   
/*     */   public final com.haut.grm.model.type.QCompanyGrainType qylb;
/*     */   
/*     */   public final com.haut.grm.model.type.QCompanyDetailType qylx;
/*     */   
/*  61 */   public final StringPath qymc = createString("qymc");
/*     */   
/*     */   public final com.haut.grm.model.type.QCompanyType qyxz;
/*     */   
/*  65 */   public final BooleanPath sffxly = createBoolean("sffxly");
/*     */   
/*  67 */   public final BooleanPath sfyjqy = createBoolean("sfyjqy");
/*     */   
/*  69 */   public final StringPath sgxkz = createString("sgxkz");
/*     */   
/*     */   public final com.haut.grm.model.meta.QLevelType sgzg;
/*     */   
/*     */   public final QLocation sjlsbh;
/*     */   
/*  75 */   public final NumberPath<Double> wd = createNumber("wd", Double.class);
/*     */   
/*     */   public final QLocation zcqybm;
/*     */   
/*  79 */   public final com.querydsl.core.types.dsl.DateTimePath<Date> zcsj = createDateTime("zcsj", Date.class);
/*     */   
/*  81 */   public final StringPath zcxxdz = createString("zcxxdz");
/*     */   
/*  83 */   public final NumberPath<Double> zczb = createNumber("zczb", Double.class);
/*     */   
/*  85 */   public final NumberPath<Double> zcze = createNumber("zcze", Double.class);
/*     */   
/*  87 */   public final SetPath<GrainVariety, QGrainVariety> zyjgpz = createSet("zyjgpz", GrainVariety.class, QGrainVariety.class, PathInits.DIRECT2);
/*     */   
/*  89 */   public final SetPath<GrainVariety, QGrainVariety> zyjypz = createSet("zyjypz", GrainVariety.class, QGrainVariety.class, PathInits.DIRECT2);
/*     */   
/*  91 */   public final SetPath<GrainVariety, QGrainVariety> zysgpz = createSet("zysgpz", GrainVariety.class, QGrainVariety.class, PathInits.DIRECT2);
/*     */   
/*  93 */   public final NumberPath<Double> zyzj = createNumber("zyzj", Double.class);
/*     */   
/*     */   public QCompany(String variable) {
/*  96 */     this(Company.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable), INITS);
/*     */   }
/*     */   
/*     */   public QCompany(Path<? extends Company> path) {
/* 100 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*     */   }
/*     */   
/*     */   public QCompany(PathMetadata metadata) {
/* 104 */     this(metadata, PathInits.getFor(metadata, INITS));
/*     */   }
/*     */   
/*     */   public QCompany(PathMetadata metadata, PathInits inits) {
/* 108 */     this(Company.class, metadata, inits);
/*     */   }
/*     */   
/*     */   public QCompany(Class<? extends Company> type, PathMetadata metadata, PathInits inits) {
/* 112 */     super(type, metadata, inits);
/* 113 */     this.frgb = (inits.isInitialized("frgb") ? new QCountry(forProperty("frgb")) : null);
/* 114 */     this.frzjlx = (inits.isInitialized("frzjlx") ? new com.haut.grm.model.type.QIdType(forProperty("frzjlx")) : null);
/* 115 */     this.jydzbm = (inits.isInitialized("jydzbm") ? new QLocation(forProperty("jydzbm")) : null);
/* 116 */     this.lsgx = (inits.isInitialized("lsgx") ? new QCompanyLevelType(forProperty("lsgx")) : null);
/* 117 */     this.qylb = (inits.isInitialized("qylb") ? new com.haut.grm.model.type.QCompanyGrainType(forProperty("qylb")) : null);
/* 118 */     this.qylx = (inits.isInitialized("qylx") ? new com.haut.grm.model.type.QCompanyDetailType(forProperty("qylx")) : null);
/* 119 */     this.qyxz = (inits.isInitialized("qyxz") ? new com.haut.grm.model.type.QCompanyType(forProperty("qyxz")) : null);
/* 120 */     this.sgzg = (inits.isInitialized("sgzg") ? new com.haut.grm.model.meta.QLevelType(forProperty("sgzg")) : null);
/* 121 */     this.sjlsbh = (inits.isInitialized("sjlsbh") ? new QLocation(forProperty("sjlsbh")) : null);
/* 122 */     this.zcqybm = (inits.isInitialized("zcqybm") ? new QLocation(forProperty("zcqybm")) : null);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\QCompany.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */