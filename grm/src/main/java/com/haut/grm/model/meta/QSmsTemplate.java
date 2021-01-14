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
/*    */ public class QSmsTemplate
/*    */   extends EntityPathBase<SmsTemplate>
/*    */ {
/*    */   private static final long serialVersionUID = -1724999932L;
/* 20 */   public static final QSmsTemplate smsTemplate = new QSmsTemplate("smsTemplate");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final StringPath doorAlert = createString("doorAlert");
/*    */   
/* 26 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 28 */   public final StringPath measureAlert = createString("measureAlert");
/*    */   
/* 30 */   public final StringPath safetyAlert = createString("safetyAlert");
/*    */   
/*    */   public QSmsTemplate(String variable) {
/* 33 */     super(SmsTemplate.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QSmsTemplate(Path<? extends SmsTemplate> path) {
/* 37 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QSmsTemplate(PathMetadata metadata) {
/* 41 */     super(SmsTemplate.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\QSmsTemplate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */