/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
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
/*    */ public class QStage
/*    */   extends EntityPathBase<Stage>
/*    */ {
/*    */   private static final long serialVersionUID = -1290013233L;
/* 20 */   public static final QStage stage = new QStage("stage");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 26 */   public final StringPath name = createString("name");
/*    */   
/* 28 */   public final NumberPath<Integer> next = createNumber("next", Integer.class);
/*    */   
/* 30 */   public final NumberPath<Integer> previous = createNumber("previous", Integer.class);
/*    */   
/* 32 */   public final NumberPath<Integer> value = createNumber("value", Integer.class);
/*    */   
/*    */   public QStage(String variable) {
/* 35 */     super(Stage.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QStage(Path<? extends Stage> path) {
/* 39 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QStage(PathMetadata metadata) {
/* 43 */     super(Stage.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\QStage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */