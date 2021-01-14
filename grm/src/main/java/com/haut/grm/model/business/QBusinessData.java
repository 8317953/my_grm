/*    */ package com.haut.grm.model.business;
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
/*    */ public class QBusinessData
/*    */   extends EntityPathBase<BusinessData>
/*    */ {
/*    */   private static final long serialVersionUID = -1405423938L;
/* 20 */   public static final QBusinessData businessData = new QBusinessData("businessData");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final StringPath businessKey = createString("businessKey");
/*    */   
/* 26 */   public final StringPath content = createString("content");
/*    */   
/* 28 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 30 */   public final StringPath url = createString("url");
/*    */   
/*    */   public QBusinessData(String variable) {
/* 33 */     super(BusinessData.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QBusinessData(Path<? extends BusinessData> path) {
/* 37 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QBusinessData(PathMetadata metadata) {
/* 41 */     super(BusinessData.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QBusinessData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */