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
/*    */ public class QMedicineRequest
/*    */   extends EntityPathBase<MedicineRequest>
/*    */ {
/*    */   private static final long serialVersionUID = 635877185L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QMedicineRequest medicineRequest = new QMedicineRequest("medicineRequest");
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
/*    */ 
/*    */   public final QUser inputer;
/*    */   
/*    */ 
/*    */   public final DateTimePath<Date> inputTime;
/*    */   
/* 53 */   public final StringPath purpose = createString("purpose");
/*    */   
/*    */   public final QScale scale;
/*    */   public final QMedicineType type;
/*    */   
/*    */   public QMedicineRequest(String variable)
/*    */   {
/* 60 */     this(MedicineRequest.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QMedicineRequest(Path<? extends MedicineRequest> path) {
/* 64 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QMedicineRequest(PathMetadata metadata) {
/* 68 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QMedicineRequest(PathMetadata metadata, PathInits inits) {
/* 72 */     this(MedicineRequest.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QMedicineRequest(Class<? extends MedicineRequest> type, PathMetadata metadata, PathInits inits) {
/* 76 */     super(type, metadata, inits);
/* 77 */     this._super = new QAbstractBusiness(type, metadata, inits);
/* 78 */     this.auditComment = this._super.auditComment;
/* 79 */     this.auditor = this._super.auditor;
/* 80 */     this.auditTime = this._super.auditTime;
/* 81 */     this.businessKey = this._super.businessKey;
/* 82 */     this.id = this._super.id;
/* 83 */     this.inputComment = this._super.inputComment;
/* 84 */     this.inputer = this._super.inputer;
/* 85 */     this.inputTime = this._super.inputTime;
/* 86 */     this.scale = (inits.isInitialized("scale") ? new QScale(forProperty("scale")) : null);
/* 87 */     this.type = (inits.isInitialized("type") ? new QMedicineType(forProperty("type")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QMedicineRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */