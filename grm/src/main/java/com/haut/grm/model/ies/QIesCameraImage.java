/*    */ package com.haut.grm.model.ies;
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
/*    */ public class QIesCameraImage
/*    */   extends EntityPathBase<IesCameraImage>
/*    */ {
/*    */   private static final long serialVersionUID = 683605008L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QIesCameraImage iesCameraImage = new QIesCameraImage("iesCameraImage");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/*    */   public final QGrainTraffic grainTraffic;
/*    */   
/* 29 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 31 */   public final StringPath imagePath = createString("imagePath");
/*    */   public final QIesCameraRegistry registry;
/*    */   
/*    */   public QIesCameraImage(String variable)
/*    */   {
/* 36 */     this(IesCameraImage.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QIesCameraImage(Path<? extends IesCameraImage> path) {
/* 40 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QIesCameraImage(PathMetadata metadata) {
/* 44 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QIesCameraImage(PathMetadata metadata, PathInits inits) {
/* 48 */     this(IesCameraImage.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QIesCameraImage(Class<? extends IesCameraImage> type, PathMetadata metadata, PathInits inits) {
/* 52 */     super(type, metadata, inits);
/* 53 */     this.grainTraffic = (inits.isInitialized("grainTraffic") ? new QGrainTraffic(forProperty("grainTraffic"), inits.get("grainTraffic")) : null);
/* 54 */     this.registry = (inits.isInitialized("registry") ? new QIesCameraRegistry(forProperty("registry"), inits.get("registry")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\QIesCameraImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */