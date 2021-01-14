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
/*    */ public class QAbstractType
/*    */   extends EntityPathBase<AbstractType>
/*    */ {
/*    */   private static final long serialVersionUID = 180944191L;
/* 20 */   public static final QAbstractType abstractType = new QAbstractType("abstractType");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 26 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 28 */   public final StringPath name = createString("name");
/*    */   
/*    */   public QAbstractType(String variable) {
/* 31 */     super(AbstractType.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QAbstractType(Path<? extends AbstractType> path) {
/* 35 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QAbstractType(PathMetadata metadata) {
/* 39 */     super(AbstractType.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\QAbstractType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */