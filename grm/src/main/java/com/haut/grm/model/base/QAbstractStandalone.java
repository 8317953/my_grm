/*    */ package com.haut.grm.model.base;
/*    */ 
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
/*    */ 
/*    */ public class QAbstractStandalone
/*    */   extends EntityPathBase<AbstractStandalone>
/*    */ {
/*    */   private static final long serialVersionUID = -25889142L;
/* 20 */   public static final QAbstractStandalone abstractStandalone = new QAbstractStandalone("abstractStandalone");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 26 */   public final StringPath name = createString("name");
/*    */   
/* 28 */   public final NumberPath<Integer> order = createNumber("order", Integer.class);
/*    */   
/*    */   public QAbstractStandalone(String variable) {
/* 31 */     super(AbstractStandalone.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QAbstractStandalone(Path<? extends AbstractStandalone> path) {
/* 35 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QAbstractStandalone(PathMetadata metadata) {
/* 39 */     super(AbstractStandalone.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\QAbstractStandalone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */