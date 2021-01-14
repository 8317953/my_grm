/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.QCargo;
/*    */ import com.haut.grm.model.QStore;
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.meta.QUser;
/*    */ import com.haut.grm.model.standalone.QLoadCompany;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class QWeightSheet extends EntityPathBase<WeightSheet>
/*    */ {
/*    */   private static final long serialVersionUID = 90040630L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QWeightSheet weightSheet = new QWeightSheet("weightSheet");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/*    */   public final QCargo cargo;
/*    */   
/* 29 */   public final StringPath comment = createString("comment");
/*    */   
/* 31 */   public final NumberPath<Double> deductPercentage = createNumber("deductPercentage", Double.class);
/*    */   
/* 33 */   public final DateTimePath<Date> deductTime = createDateTime("deductTime", Date.class);
/*    */   
/* 35 */   public final NumberPath<Double> deductWeight = createNumber("deductWeight", Double.class);
/*    */   
/* 37 */   public final DateTimePath<Date> firstTime = createDateTime("firstTime", Date.class);
/*    */   
/*    */   public final QUser firstUser;
/*    */   
/* 41 */   public final NumberPath<Double> firstWeight = createNumber("firstWeight", Double.class);
/*    */   
/* 43 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/*    */   public final QLoadCompany loadCompany;
/*    */   
/*    */   public final QUser manager;
/*    */   
/* 49 */   public final NumberPath<Long> pack = createNumber("pack", Long.class);
/*    */   
/* 51 */   public final NumberPath<Double> packPerWeight = createNumber("packPerWeight", Double.class);
/*    */   
/* 53 */   public final DateTimePath<Date> secondTime = createDateTime("secondTime", Date.class);
/*    */   
/*    */   public final QUser secondUser;
/*    */   
/* 57 */   public final NumberPath<Double> secondWeight = createNumber("secondWeight", Double.class);
/*    */   public final QStore store;
/*    */   
/*    */   public QWeightSheet(String variable)
/*    */   {
/* 62 */     this(WeightSheet.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QWeightSheet(Path<? extends WeightSheet> path) {
/* 66 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QWeightSheet(PathMetadata metadata) {
/* 70 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QWeightSheet(PathMetadata metadata, PathInits inits) {
/* 74 */     this(WeightSheet.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QWeightSheet(Class<? extends WeightSheet> type, PathMetadata metadata, PathInits inits) {
/* 78 */     super(type, metadata, inits);
/* 79 */     this.cargo = (inits.isInitialized("cargo") ? new QCargo(forProperty("cargo"), inits.get("cargo")) : null);
/* 80 */     this.firstUser = (inits.isInitialized("firstUser") ? new QUser(forProperty("firstUser"), inits.get("firstUser")) : null);
/* 81 */     this.loadCompany = (inits.isInitialized("loadCompany") ? new QLoadCompany(forProperty("loadCompany")) : null);
/* 82 */     this.manager = (inits.isInitialized("manager") ? new QUser(forProperty("manager"), inits.get("manager")) : null);
/* 83 */     this.secondUser = (inits.isInitialized("secondUser") ? new QUser(forProperty("secondUser"), inits.get("secondUser")) : null);
/* 84 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\QWeightSheet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */