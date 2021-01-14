/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractBusiness;
/*    */ import com.haut.grm.model.meta.QUser;
/*    */ import com.haut.grm.model.type.QMedicineType;
/*    */ import com.haut.grm.model.type.QScale;
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
/*    */ public class QMedicineStock
/*    */   extends EntityPathBase<MedicineStock>
/*    */ {
/*    */   private static final long serialVersionUID = 122699848L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QMedicineStock medicineStock = new QMedicineStock("medicineStock");
/*    */   
/*    */   public final QAbstractBusiness _super;
/*    */   
/* 27 */   public final NumberPath<Double> amount = createNumber("amount", Double.class);
/*    */   
/*    */ 
/*    */   public final StringPath auditComment;
/*    */   
/*    */ 
/*    */   public final QUser auditor;
/*    */   
/*    */ 
/*    */   public final DateTimePath<Date> auditTime;
/*    */   
/*    */ 
/*    */   public final StringPath businessKey;
/*    */   
/*    */ 
/*    */   public final NumberPath<Long> id;
/*    */   
/*    */ 
/*    */   public final StringPath inputComment;
/*    */   
/*    */   public final QUser inputer;
/*    */   
/*    */   public final DateTimePath<Date> inputTime;
/*    */   
/*    */   public final QScale scale;
/*    */   
/*    */   public final QMedicineType type;
/*    */   
/*    */ 
/*    */   public QMedicineStock(String variable)
/*    */   {
/* 58 */     this(MedicineStock.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QMedicineStock(Path<? extends MedicineStock> path) {
/* 62 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QMedicineStock(PathMetadata metadata) {
/* 66 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QMedicineStock(PathMetadata metadata, PathInits inits) {
/* 70 */     this(MedicineStock.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QMedicineStock(Class<? extends MedicineStock> type, PathMetadata metadata, PathInits inits) {
/* 74 */     super(type, metadata, inits);
/* 75 */     this._super = new QAbstractBusiness(type, metadata, inits);
/* 76 */     this.auditComment = this._super.auditComment;
/* 77 */     this.auditor = this._super.auditor;
/* 78 */     this.auditTime = this._super.auditTime;
/* 79 */     this.businessKey = this._super.businessKey;
/* 80 */     this.id = this._super.id;
/* 81 */     this.inputComment = this._super.inputComment;
/* 82 */     this.inputer = this._super.inputer;
/* 83 */     this.inputTime = this._super.inputTime;
/* 84 */     this.scale = (inits.isInitialized("scale") ? new QScale(forProperty("scale")) : null);
/* 85 */     this.type = (inits.isInitialized("type") ? new QMedicineType(forProperty("type")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QMedicineStock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */