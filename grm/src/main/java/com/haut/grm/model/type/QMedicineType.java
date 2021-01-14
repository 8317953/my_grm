/*    */ package com.haut.grm.model.type;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractType;
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
/*    */ public class QMedicineType
/*    */   extends EntityPathBase<MedicineType>
/*    */ {
/*    */   private static final long serialVersionUID = -578109042L;
/* 20 */   public static final QMedicineType medicineType = new QMedicineType("medicineType");
/*    */   
/* 22 */   public final QAbstractType _super = new QAbstractType(this);
/*    */   
/*    */ 
/* 25 */   public final NumberPath<Integer> codeId = this._super.codeId;
/*    */   
/*    */ 
/* 28 */   public final NumberPath<Long> id = this._super.id;
/*    */   
/*    */ 
/* 31 */   public final StringPath name = this._super.name;
/*    */   
/*    */   public QMedicineType(String variable) {
/* 34 */     super(MedicineType.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QMedicineType(Path<? extends MedicineType> path) {
/* 38 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QMedicineType(PathMetadata metadata) {
/* 42 */     super(MedicineType.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\type\QMedicineType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */