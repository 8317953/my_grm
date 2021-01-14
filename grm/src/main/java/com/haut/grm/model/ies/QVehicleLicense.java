/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QVehicleLicense
/*    */   extends EntityPathBase<VehicleLicense>
/*    */ {
/*    */   private static final long serialVersionUID = -276429402L;
/* 20 */   public static final QVehicleLicense vehicleLicense = new QVehicleLicense("vehicleLicense");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 26 */   public final StringPath imagePath = createString("imagePath");
/*    */   
/* 28 */   public final StringPath plate = createString("plate");
/*    */   
/* 30 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   
/*    */   public QVehicleLicense(String variable) {
/* 33 */     super(VehicleLicense.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QVehicleLicense(Path<? extends VehicleLicense> path) {
/* 37 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QVehicleLicense(PathMetadata metadata) {
/* 41 */     super(VehicleLicense.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\QVehicleLicense.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */