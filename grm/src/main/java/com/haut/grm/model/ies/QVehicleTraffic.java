/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.QDeviceCamera;
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.business.QContract;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.ArrayPath;
/*    */ import com.querydsl.core.types.dsl.BooleanPath;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class QVehicleTraffic extends EntityPathBase<VehicleTraffic>
/*    */ {
/*    */   private static final long serialVersionUID = -1510497438L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QVehicleTraffic vehicleTraffic = new QVehicleTraffic("vehicleTraffic");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final StringPath authorizationPath = createString("authorizationPath");
/*    */   
/*    */   public final QDeviceCamera camera;
/*    */   
/*    */   public final QContract contract;
/*    */   
/* 33 */   public final DateTimePath<Date> deadline = createDateTime("deadline", Date.class);
/*    */   
/* 35 */   public final BooleanPath finished = createBoolean("finished");
/*    */   
/* 37 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 39 */   public final ArrayPath<byte[], Byte> image = createArray("image", byte[].class);
/*    */   
/* 41 */   public final BooleanPath in = createBoolean("in");
/*    */   
/* 43 */   public final DateTimePath<Date> inTime = createDateTime("inTime", Date.class);
/*    */   
/* 45 */   public final StringPath plate = createString("plate");
/*    */   
/* 47 */   public final BooleanPath registered = createBoolean("registered");
/*    */   
/* 49 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   
/*    */   public QVehicleTraffic(String variable) {
/* 52 */     this(VehicleTraffic.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QVehicleTraffic(Path<? extends VehicleTraffic> path) {
/* 56 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QVehicleTraffic(PathMetadata metadata) {
/* 60 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QVehicleTraffic(PathMetadata metadata, PathInits inits) {
/* 64 */     this(VehicleTraffic.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QVehicleTraffic(Class<? extends VehicleTraffic> type, PathMetadata metadata, PathInits inits) {
/* 68 */     super(type, metadata, inits);
/* 69 */     this.camera = (inits.isInitialized("camera") ? new QDeviceCamera(forProperty("camera"), inits.get("camera")) : null);
/* 70 */     this.contract = (inits.isInitialized("contract") ? new QContract(forProperty("contract"), inits.get("contract")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\QVehicleTraffic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */