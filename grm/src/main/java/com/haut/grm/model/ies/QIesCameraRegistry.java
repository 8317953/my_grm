/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.QDeviceCamera;
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.system.QSystemTrafficModule;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QIesCameraRegistry
/*    */   extends EntityPathBase<IesCameraRegistry>
/*    */ {
/*    */   private static final long serialVersionUID = -1288641176L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QIesCameraRegistry iesCameraRegistry = new QIesCameraRegistry("iesCameraRegistry");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/*    */   public final QDeviceCamera camera;
/*    */   
/* 29 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   public final QSystemTrafficModule trafficModule;
/*    */   
/*    */   public QIesCameraRegistry(String variable)
/*    */   {
/* 34 */     this(IesCameraRegistry.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QIesCameraRegistry(Path<? extends IesCameraRegistry> path) {
/* 38 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QIesCameraRegistry(PathMetadata metadata) {
/* 42 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QIesCameraRegistry(PathMetadata metadata, PathInits inits) {
/* 46 */     this(IesCameraRegistry.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QIesCameraRegistry(Class<? extends IesCameraRegistry> type, PathMetadata metadata, PathInits inits) {
/* 50 */     super(type, metadata, inits);
/* 51 */     this.camera = (inits.isInitialized("camera") ? new QDeviceCamera(forProperty("camera"), inits.get("camera")) : null);
/* 52 */     this.trafficModule = (inits.isInitialized("trafficModule") ? new QSystemTrafficModule(forProperty("trafficModule")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\QIesCameraRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */