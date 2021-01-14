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
/*    */ public class QWendu
/*    */   extends EntityPathBase<Wendu>
/*    */ {
/*    */   private static final long serialVersionUID = -2003984650L;
/* 20 */   public static final QWendu wendu = new QWendu("wendu");
/*    */   
/* 22 */   public final StringPath codeId = createString("codeId");
/*    */   
/* 24 */   public final StringPath id = createString("id");
/*    */   
/* 26 */   public final NumberPath<Integer> temperature = createNumber("temperature", Integer.class);
/*    */   
/* 28 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   
/*    */   public QWendu(String variable) {
/* 31 */     super(Wendu.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QWendu(Path<? extends Wendu> path) {
/* 35 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QWendu(PathMetadata metadata) {
/* 39 */     super(Wendu.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\model\QWendu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */