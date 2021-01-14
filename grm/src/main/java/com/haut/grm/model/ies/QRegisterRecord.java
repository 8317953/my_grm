/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.meta.QUser;
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
/*    */ 
/*    */ 
/*    */ public class QRegisterRecord
/*    */   extends EntityPathBase<RegisterRecord>
/*    */ {
/*    */   private static final long serialVersionUID = -98540795L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QRegisterRecord registerRecord = new QRegisterRecord("registerRecord");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final StringPath cardCode = createString("cardCode");
/*    */   
/* 29 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/*    */   public final QUser manager;
/*    */   
/* 33 */   public final StringPath personnelAddress = createString("personnelAddress");
/*    */   
/* 35 */   public final StringPath personnelGender = createString("personnelGender");
/*    */   
/* 37 */   public final StringPath personnelIdNumber = createString("personnelIdNumber");
/*    */   
/* 39 */   public final StringPath personnelName = createString("personnelName");
/*    */   
/* 41 */   public final StringPath personnelPic = createString("personnelPic");
/*    */   
/* 43 */   public final StringPath telephone = createString("telephone");
/*    */   
/* 45 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   public final QVehicleTraffic vehicleTraffic;
/*    */   
/*    */   public QRegisterRecord(String variable)
/*    */   {
/* 50 */     this(RegisterRecord.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QRegisterRecord(Path<? extends RegisterRecord> path) {
/* 54 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QRegisterRecord(PathMetadata metadata) {
/* 58 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QRegisterRecord(PathMetadata metadata, PathInits inits) {
/* 62 */     this(RegisterRecord.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QRegisterRecord(Class<? extends RegisterRecord> type, PathMetadata metadata, PathInits inits) {
/* 66 */     super(type, metadata, inits);
/* 67 */     this.manager = (inits.isInitialized("manager") ? new QUser(forProperty("manager"), inits.get("manager")) : null);
/* 68 */     this.vehicleTraffic = (inits.isInitialized("vehicleTraffic") ? new QVehicleTraffic(forProperty("vehicleTraffic"), inits.get("vehicleTraffic")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\QRegisterRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */