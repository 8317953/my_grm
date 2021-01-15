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
/*    */ public class QDepartment
/*    */   extends EntityPathBase<Department>
/*    */ {
/*    */   private static final long serialVersionUID = 1871784737L;
/* 20 */   public static final QDepartment department = new QDepartment("department");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 26 */   public final StringPath comment = createString("comment");
/*    */   
/* 28 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 30 */   public final StringPath name = createString("name");
/*    */   
/*    */   public QDepartment(String variable) {
/* 33 */     super(Department.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QDepartment(Path<? extends Department> path) {
/* 37 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QDepartment(PathMetadata metadata) {
/* 41 */     super(Department.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\QDepartment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */