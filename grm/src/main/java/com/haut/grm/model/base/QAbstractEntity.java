/*    */ package com.haut.grm.model.base;
/*    */ 
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.SimplePath;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QAbstractEntity
/*    */   extends EntityPathBase<AbstractEntity<? extends Serializable>>
/*    */ {
/*    */   private static final long serialVersionUID = 1649206440L;
/* 20 */   public static final QAbstractEntity abstractEntity = new QAbstractEntity("abstractEntity");
/*    */   
/* 22 */   public final SimplePath<Serializable> id = createSimple("id", Serializable.class);
/*    */   
/*    */   public QAbstractEntity(String variable)
/*    */   {
/* 26 */     super((Class<? extends AbstractEntity<? extends Serializable>>) AbstractEntity.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QAbstractEntity(Path<? extends AbstractEntity> path)
/*    */   {
/* 31 */     super((Class<? extends AbstractEntity<? extends Serializable>>) path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QAbstractEntity(PathMetadata metadata)
/*    */   {
/* 36 */     super((Class<? extends AbstractEntity<? extends Serializable>>) AbstractEntity.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\QAbstractEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */