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
/*    */ public class QActivitiGroup
/*    */   extends EntityPathBase<ActivitiGroup>
/*    */ {
/*    */   private static final long serialVersionUID = -1699025775L;
/* 20 */   public static final QActivitiGroup activitiGroup = new QActivitiGroup("activitiGroup");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final StringPath code = createString("code");
/*    */   
/* 26 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 28 */   public final StringPath comment = createString("comment");
/*    */   
/* 30 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 32 */   public final StringPath name = createString("name");
/*    */   
/*    */   public QActivitiGroup(String variable) {
/* 35 */     super(ActivitiGroup.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QActivitiGroup(Path<? extends ActivitiGroup> path) {
/* 39 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QActivitiGroup(PathMetadata metadata) {
/* 43 */     super(ActivitiGroup.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\QActivitiGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */