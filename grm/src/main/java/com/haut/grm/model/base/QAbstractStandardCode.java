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
/*    */ public class QAbstractStandardCode
/*    */   extends EntityPathBase<AbstractStandardCode>
/*    */ {
/*    */   private static final long serialVersionUID = 1050686287L;
/* 20 */   public static final QAbstractStandardCode abstractStandardCode = new QAbstractStandardCode("abstractStandardCode");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final StringPath code = createString("code");
/*    */   
/* 26 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 28 */   public final NumberPath<Integer> level = createNumber("level", Integer.class);
/*    */   
/* 30 */   public final StringPath name = createString("name");
/*    */   
/* 32 */   public final StringPath parentCode = createString("parentCode");
/*    */   
/* 34 */   public final StringPath shortCode = createString("shortCode");
/*    */   
/*    */   public QAbstractStandardCode(String variable) {
/* 37 */     super(AbstractStandardCode.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QAbstractStandardCode(Path<? extends AbstractStandardCode> path) {
/* 41 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QAbstractStandardCode(PathMetadata metadata) {
/* 45 */     super(AbstractStandardCode.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\QAbstractStandardCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */