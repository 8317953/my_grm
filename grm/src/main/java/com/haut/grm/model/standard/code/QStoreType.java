/*    */ package com.haut.grm.model.standard.code;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractStandardCode;
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
/*    */ public class QStoreType
/*    */   extends EntityPathBase<StoreType>
/*    */ {
/*    */   private static final long serialVersionUID = 328272465L;
/* 20 */   public static final QStoreType storeType = new QStoreType("storeType");
/*    */   
/* 22 */   public final QAbstractStandardCode _super = new QAbstractStandardCode(this);
/*    */   
/*    */ 
/* 25 */   public final StringPath code = this._super.code;
/*    */   
/*    */ 
/* 28 */   public final NumberPath<Long> id = this._super.id;
/*    */   
/*    */ 
/* 31 */   public final NumberPath<Integer> level = this._super.level;
/*    */   
/*    */ 
/* 34 */   public final StringPath name = this._super.name;
/*    */   
/*    */ 
/* 37 */   public final StringPath parentCode = this._super.parentCode;
/*    */   
/*    */ 
/* 40 */   public final StringPath shortCode = this._super.shortCode;
/*    */   
/*    */   public QStoreType(String variable) {
/* 43 */     super(StoreType.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QStoreType(Path<? extends StoreType> path) {
/* 47 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QStoreType(PathMetadata metadata) {
/* 51 */     super(StoreType.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\standard\code\QStoreType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */