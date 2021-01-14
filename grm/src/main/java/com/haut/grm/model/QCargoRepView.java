/*    */ package com.haut.grm.model;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QCargoRepView
/*    */   extends EntityPathBase<CargoRepView>
/*    */ {
/*    */   private static final long serialVersionUID = 1757332288L;
/* 21 */   private static final PathInits INITS = new PathInits(new String[] { "*", "compartment.store.depot.*" });
/*    */   
/* 23 */   public static final QCargoRepView cargoRepView = new QCargoRepView("cargoRepView");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final StringPath code = createString("code");
/*    */   
/* 29 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/*    */   public final QCompartment compartment;
/*    */   
/* 33 */   public final StringPath depotAbbrev = createString("depotAbbrev");
/*    */   
/* 35 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 37 */   public final StringPath name = createString("name");
/*    */   
/* 39 */   public final StringPath readableName = createString("readableName");
/*    */   
/* 41 */   public final StringPath shortName = createString("shortName");
/*    */   
/* 43 */   public final NumberPath<Long> statusId = createNumber("statusId", Long.class);
/*    */   
/* 45 */   public final StringPath statusName = createString("statusName");
/*    */   
/* 47 */   public final StringPath storeName = createString("storeName");
/*    */   
/*    */   public QCargoRepView(String variable) {
/* 50 */     this(CargoRepView.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QCargoRepView(Path<? extends CargoRepView> path) {
/* 54 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QCargoRepView(PathMetadata metadata) {
/* 58 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QCargoRepView(PathMetadata metadata, PathInits inits) {
/* 62 */     this(CargoRepView.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QCargoRepView(Class<? extends CargoRepView> type, PathMetadata metadata, PathInits inits) {
/* 66 */     super(type, metadata, inits);
/* 67 */     this.compartment = (inits.isInitialized("compartment") ? new QCompartment(forProperty("compartment"), inits.get("compartment")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\QCargoRepView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */