/*    */ package com.haut.grm.model.entry;
/*    */ 
/*    */ import com.haut.grm.model.QStore;
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QMeasureDiff
/*    */   extends EntityPathBase<MeasureDiff>
/*    */ {
/*    */   private static final long serialVersionUID = -1606309491L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QMeasureDiff measureDiff = new QMeasureDiff("measureDiff");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Double> errorPercentage = createNumber("errorPercentage", Double.class);
/*    */   
/* 29 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/*    */   public final QStore store;
/*    */   
/* 33 */   public final DateTimePath<Date> thatTime = createDateTime("thatTime", Date.class);
/*    */   
/* 35 */   public final NumberPath<Double> thatVolume = createNumber("thatVolume", Double.class);
/*    */   
/* 37 */   public final DateTimePath<Date> thisTime = createDateTime("thisTime", Date.class);
/*    */   
/* 39 */   public final NumberPath<Double> thisVolume = createNumber("thisVolume", Double.class);
/*    */   
/*    */   public QMeasureDiff(String variable) {
/* 42 */     this(MeasureDiff.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QMeasureDiff(Path<? extends MeasureDiff> path) {
/* 46 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QMeasureDiff(PathMetadata metadata) {
/* 50 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QMeasureDiff(PathMetadata metadata, PathInits inits) {
/* 54 */     this(MeasureDiff.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QMeasureDiff(Class<? extends MeasureDiff> type, PathMetadata metadata, PathInits inits) {
/* 58 */     super(type, metadata, inits);
/* 59 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\QMeasureDiff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */