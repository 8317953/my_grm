/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.BooleanPath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QStoreModel
/*    */   extends EntityPathBase<StoreModel>
/*    */ {
/*    */   private static final long serialVersionUID = 1928748695L;
/* 20 */   public static final QStoreModel storeModel = new QStoreModel("storeModel");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final StringPath cableData = createString("cableData");
/*    */   
/* 26 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 28 */   public final StringPath iconRelativePath = createString("iconRelativePath");
/*    */   
/* 30 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 32 */   public final BooleanPath isCircle = createBoolean("isCircle");
/*    */   
/* 34 */   public final StringPath name = createString("name");
/*    */   
/* 36 */   public final StringPath sourceX = createString("sourceX");
/*    */   
/* 38 */   public final StringPath sourceY = createString("sourceY");
/*    */   
/* 40 */   public final StringPath targetX = createString("targetX");
/*    */   
/* 42 */   public final StringPath targetY = createString("targetY");
/*    */   
/*    */   public QStoreModel(String variable) {
/* 45 */     super(StoreModel.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QStoreModel(Path<? extends StoreModel> path) {
/* 49 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QStoreModel(PathMetadata metadata) {
/* 53 */     super(StoreModel.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\QStoreModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */