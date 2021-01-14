/*    */ package com.haut.grm.model.system;
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
/*    */ public class QCoreVersion
/*    */   extends EntityPathBase<CoreVersion>
/*    */ {
/*    */   private static final long serialVersionUID = 1282589940L;
/* 20 */   public static final QCoreVersion coreVersion = new QCoreVersion("coreVersion");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 26 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 28 */   public final StringPath name = createString("name");
/*    */   
/*    */   public QCoreVersion(String variable) {
/* 31 */     super(CoreVersion.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QCoreVersion(Path<? extends CoreVersion> path) {
/* 35 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QCoreVersion(PathMetadata metadata) {
/* 39 */     super(CoreVersion.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\system\QCoreVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */