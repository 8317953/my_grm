/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.type.QMedicineType;
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
/*    */ public class QMedicineSum
/*    */   extends EntityPathBase<MedicineSum>
/*    */ {
/*    */   private static final long serialVersionUID = -1148474371L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QMedicineSum medicineSum = new QMedicineSum("medicineSum");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 29 */   public final NumberPath<Double> in = createNumber("in", Double.class);
/*    */   
/* 31 */   public final StringPath name = createString("name");
/*    */   
/* 33 */   public final NumberPath<Double> out = createNumber("out", Double.class);
/*    */   
/* 35 */   public final NumberPath<Double> total = createNumber("total", Double.class);
/*    */   public final QMedicineType type;
/*    */   
/*    */   public QMedicineSum(String variable)
/*    */   {
/* 40 */     this(MedicineSum.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QMedicineSum(Path<? extends MedicineSum> path) {
/* 44 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QMedicineSum(PathMetadata metadata) {
/* 48 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QMedicineSum(PathMetadata metadata, PathInits inits) {
/* 52 */     this(MedicineSum.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QMedicineSum(Class<? extends MedicineSum> type, PathMetadata metadata, PathInits inits) {
/* 56 */     super(type, metadata, inits);
/* 57 */     this.type = (inits.isInitialized("type") ? new QMedicineType(forProperty("type")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QMedicineSum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */