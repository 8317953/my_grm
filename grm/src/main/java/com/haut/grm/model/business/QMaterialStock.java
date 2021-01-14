/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractBusiness;
/*    */ import com.haut.grm.model.meta.QUser;
/*    */ import com.haut.grm.model.type.QMaterialType;
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
/*    */ public class QMaterialStock
/*    */   extends EntityPathBase<MaterialStock>
/*    */ {
/*    */   private static final long serialVersionUID = 1911717243L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QMaterialStock materialStock = new QMaterialStock("materialStock");
/*    */   
/*    */   public final QAbstractBusiness _super;
/*    */   
/* 27 */   public final NumberPath<Integer> amount = createNumber("amount", Integer.class);
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
/*    */   public final QMaterialType type;
/*    */   
/*    */ 
/*    */   public QMaterialStock(String variable)
/*    */   {
/* 56 */     this(MaterialStock.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QMaterialStock(Path<? extends MaterialStock> path) {
/* 60 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QMaterialStock(PathMetadata metadata) {
/* 64 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QMaterialStock(PathMetadata metadata, PathInits inits) {
/* 68 */     this(MaterialStock.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QMaterialStock(Class<? extends MaterialStock> type, PathMetadata metadata, PathInits inits) {
/* 72 */     super(type, metadata, inits);
/* 73 */     this._super = new QAbstractBusiness(type, metadata, inits);
/* 74 */     this.auditComment = this._super.auditComment;
/* 75 */     this.auditor = this._super.auditor;
/* 76 */     this.auditTime = this._super.auditTime;
/* 77 */     this.businessKey = this._super.businessKey;
/* 78 */     this.id = this._super.id;
/* 79 */     this.inputComment = this._super.inputComment;
/* 80 */     this.inputer = this._super.inputer;
/* 81 */     this.inputTime = this._super.inputTime;
/* 82 */     this.type = (inits.isInitialized("type") ? new QMaterialType(forProperty("type")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QMaterialStock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */