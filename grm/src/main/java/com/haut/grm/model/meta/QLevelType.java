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
/*    */ public class QLevelType
/*    */   extends EntityPathBase<LevelType>
/*    */ {
/*    */   private static final long serialVersionUID = 1701945135L;
/* 20 */   public static final QLevelType levelType = new QLevelType("levelType");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final StringPath code = createString("code");
/*    */   
/* 26 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 28 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 30 */   public final StringPath name = createString("name");
/*    */   
/*    */   public QLevelType(String variable) {
/* 33 */     super(LevelType.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QLevelType(Path<? extends LevelType> path) {
/* 37 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QLevelType(PathMetadata metadata) {
/* 41 */     super(LevelType.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\QLevelType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */