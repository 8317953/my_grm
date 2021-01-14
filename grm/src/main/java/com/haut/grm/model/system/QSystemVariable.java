/*    */ package com.haut.grm.model.system;
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
/*    */ public class QSystemVariable
/*    */   extends EntityPathBase<SystemVariable>
/*    */ {
/*    */   private static final long serialVersionUID = 2089503536L;
/* 20 */   public static final QSystemVariable systemVariable = new QSystemVariable("systemVariable");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 26 */   public final StringPath comment = createString("comment");
/*    */   
/* 28 */   public final BooleanPath deletable = createBoolean("deletable");
/*    */   
/* 30 */   public final BooleanPath editable = createBoolean("editable");
/*    */   
/* 32 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 34 */   public final StringPath variableKey = createString("variableKey");
/*    */   
/* 36 */   public final StringPath variableValue = createString("variableValue");
/*    */   
/*    */   public QSystemVariable(String variable) {
/* 39 */     super(SystemVariable.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QSystemVariable(Path<? extends SystemVariable> path) {
/* 43 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QSystemVariable(PathMetadata metadata) {
/* 47 */     super(SystemVariable.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\system\QSystemVariable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */