/*    */ package com.haut.grm.model;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QDeviceGsmModem
/*    */   extends EntityPathBase<DeviceGsmModem>
/*    */ {
/*    */   private static final long serialVersionUID = 1044407897L;
/* 20 */   public static final QDeviceGsmModem deviceGsmModem = new QDeviceGsmModem("deviceGsmModem");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final NumberPath<Integer> baudRate = createNumber("baudRate", Integer.class);
/*    */   
/* 26 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 28 */   public final StringPath manufacture = createString("manufacture");
/*    */   
/* 30 */   public final StringPath model = createString("model");
/*    */   
/* 32 */   public final StringPath port = createString("port");
/*    */   
/*    */   public QDeviceGsmModem(String variable) {
/* 35 */     super(DeviceGsmModem.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QDeviceGsmModem(Path<? extends DeviceGsmModem> path) {
/* 39 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QDeviceGsmModem(PathMetadata metadata) {
/* 43 */     super(DeviceGsmModem.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\QDeviceGsmModem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */