/*    */ package com.haut.grm.model;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.SetPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QStore
/*    */   extends EntityPathBase<Store>
/*    */ {
/*    */   private static final long serialVersionUID = -1515952025L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QStore store = new QStore("store");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Long> actualVolume = createNumber("actualVolume", Long.class);
/*    */   
/* 29 */   public final NumberPath<Double> breadth = createNumber("breadth", Double.class);
/*    */   
/*    */   public final QDeviceCamera camera;
/*    */   
/* 33 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 35 */   public final SetPath<Compartment, QCompartment> compartments = createSet("compartments", Compartment.class, QCompartment.class, PathInits.DIRECT2);
/*    */   
/*    */   public final QStoreConfig config;
/*    */   
/*    */   public final QDepot depot;
/*    */   
/* 41 */   public final NumberPath<Long> designVolume = createNumber("designVolume", Long.class);
/*    */   
/* 43 */   public final SetPath<Door, QDoor> doors = createSet("doors", Door.class, QDoor.class, PathInits.DIRECT2);
/*    */   
/* 45 */   public final NumberPath<Double> grainHeight = createNumber("grainHeight", Double.class);
/*    */   
/* 47 */   public final NumberPath<Double> height = createNumber("height", Double.class);
/*    */   
/* 49 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 51 */   public final NumberPath<Double> latitude = createNumber("latitude", Double.class);
/*    */   
/* 53 */   public final NumberPath<Double> length = createNumber("length", Double.class);
/*    */   
/* 55 */   public final NumberPath<Double> longitude = createNumber("longitude", Double.class);
/*    */   
/* 57 */   public final StringPath name = createString("name");
/*    */   public final QStoreStatus status;
/*    */   
/*    */   public QStore(String variable)
/*    */   {
/* 62 */     this(Store.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QStore(Path<? extends Store> path) {
/* 66 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QStore(PathMetadata metadata) {
/* 70 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QStore(PathMetadata metadata, PathInits inits) {
/* 74 */     this(Store.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
/* 78 */     super(type, metadata, inits);
/* 79 */     this.camera = (inits.isInitialized("camera") ? new QDeviceCamera(forProperty("camera"), inits.get("camera")) : null);
/* 80 */     this.config = (inits.isInitialized("config") ? new QStoreConfig(forProperty("config"), inits.get("config")) : null);
/* 81 */     this.depot = (inits.isInitialized("depot") ? new QDepot(forProperty("depot"), inits.get("depot")) : null);
/* 82 */     this.status = (inits.isInitialized("status") ? new QStoreStatus(forProperty("status"), inits.get("status")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\QStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */