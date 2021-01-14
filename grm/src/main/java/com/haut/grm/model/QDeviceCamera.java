/*    */ package com.haut.grm.model;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.type.QCameraManufacturer;
/*    */ import com.haut.grm.model.type.QCameraType;
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
/*    */ public class QDeviceCamera
/*    */   extends EntityPathBase<DeviceCamera>
/*    */ {
/*    */   private static final long serialVersionUID = -1855167787L;
/* 21 */   private static final PathInits INITS = new PathInits(new String[] { "*", "store.depot.*" });
/*    */   
/* 23 */   public static final QDeviceCamera deviceCamera = new QDeviceCamera("deviceCamera");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Float> height = createNumber("height", Float.class);
/*    */   
/* 29 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 31 */   public final StringPath ipAddress = createString("ipAddress");
/*    */   
/*    */   public final QCameraManufacturer manufacturer;
/*    */   
/* 35 */   public final StringPath name = createString("name");
/*    */   
/* 37 */   public final StringPath password = createString("password");
/*    */   
/* 39 */   public final NumberPath<Integer> port = createNumber("port", Integer.class);
/*    */   
/* 41 */   public final StringPath positionX = createString("positionX");
/*    */   
/* 43 */   public final StringPath positionY = createString("positionY");
/*    */   
/*    */   public final QStore store;
/*    */   
/*    */   public final QCameraType type;
/*    */   
/* 49 */   public final StringPath username = createString("username");
/*    */   
/*    */   public QDeviceCamera(String variable) {
/* 52 */     this(DeviceCamera.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QDeviceCamera(Path<? extends DeviceCamera> path) {
/* 56 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QDeviceCamera(PathMetadata metadata) {
/* 60 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QDeviceCamera(PathMetadata metadata, PathInits inits) {
/* 64 */     this(DeviceCamera.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QDeviceCamera(Class<? extends DeviceCamera> type, PathMetadata metadata, PathInits inits) {
/* 68 */     super(type, metadata, inits);
/* 69 */     this.manufacturer = (inits.isInitialized("manufacturer") ? new QCameraManufacturer(forProperty("manufacturer")) : null);
/* 70 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/* 71 */     this.type = (inits.isInitialized("type") ? new QCameraType(forProperty("type")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\QDeviceCamera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */