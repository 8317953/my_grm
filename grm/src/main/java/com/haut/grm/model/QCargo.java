/*    */ package com.haut.grm.model;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.type.QCargoStatus;
/*    */ import com.haut.grm.model.type.QPackageCategory;
/*    */ import com.haut.grm.model.type.QPackageType;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DatePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class QCargo
/*    */   extends EntityPathBase<Cargo>
/*    */ {
/*    */   private static final long serialVersionUID = -1531291838L;
/* 21 */   private static final PathInits INITS = new PathInits(new String[] { "*", "compartment.store.depot.*" });
/*    */   
/* 23 */   public static final QCargo cargo = new QCargo("cargo");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final DatePath<Date> activeDate = createDate("activeDate", Date.class);
/*    */   
/* 29 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/*    */   public final QCompartment compartment;
/*    */   
/* 33 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 35 */   public final StringPath name = createString("name");
/*    */   
/*    */   public final QPackageCategory packageCategory;
/*    */   
/*    */   public final QPackageType packageType;
/*    */   
/*    */   public final QCargoStatus status;
/*    */   
/* 43 */   public final NumberPath<Double> volume = createNumber("volume", Double.class);
/*    */   
/*    */   public QCargo(String variable) {
/* 46 */     this(Cargo.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QCargo(Path<? extends Cargo> path) {
/* 50 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QCargo(PathMetadata metadata) {
/* 54 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QCargo(PathMetadata metadata, PathInits inits) {
/* 58 */     this(Cargo.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QCargo(Class<? extends Cargo> type, PathMetadata metadata, PathInits inits) {
/* 62 */     super(type, metadata, inits);
/* 63 */     this.compartment = (inits.isInitialized("compartment") ? new QCompartment(forProperty("compartment"), inits.get("compartment")) : null);
/* 64 */     this.packageCategory = (inits.isInitialized("packageCategory") ? new QPackageCategory(forProperty("packageCategory")) : null);
/* 65 */     this.packageType = (inits.isInitialized("packageType") ? new QPackageType(forProperty("packageType")) : null);
/* 66 */     this.status = (inits.isInitialized("status") ? new QCargoStatus(forProperty("status")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\QCargo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */