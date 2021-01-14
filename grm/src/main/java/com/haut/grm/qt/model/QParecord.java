/*    */ package com.haut.grm.qt.model;
/*    */ 
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QParecord
/*    */   extends EntityPathBase<Parecord>
/*    */ {
/*    */   private static final long serialVersionUID = 883902557L;
/* 20 */   public static final QParecord parecord = new QParecord("parecord");
/*    */   
/* 22 */   public final StringPath codeId = createString("codeId");
/*    */   
/* 24 */   public final StringPath id = createString("id");
/*    */   
/* 26 */   public final NumberPath<Float> pressure = createNumber("pressure", Float.class);
/*    */   
/* 28 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   
/*    */   public QParecord(String variable) {
/* 31 */     super(Parecord.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QParecord(Path<? extends Parecord> path) {
/* 35 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QParecord(PathMetadata metadata) {
/* 39 */     super(Parecord.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\model\QParecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */