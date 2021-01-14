/*    */ package com.haut.grm.model.base;
/*    */ 
/*    */ import com.haut.grm.model.meta.QUser;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QAbstractBusiness
/*    */   extends EntityPathBase<AbstractBusiness>
/*    */ {
/*    */   private static final long serialVersionUID = 999727941L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QAbstractBusiness abstractBusiness = new QAbstractBusiness("abstractBusiness");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final StringPath auditComment = createString("auditComment");
/*    */   
/*    */   public final QUser auditor;
/*    */   
/* 31 */   public final DateTimePath<Date> auditTime = createDateTime("auditTime", Date.class);
/*    */   
/* 33 */   public final StringPath businessKey = createString("businessKey");
/*    */   
/* 35 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 37 */   public final StringPath inputComment = createString("inputComment");
/*    */   
/*    */   public final QUser inputer;
/*    */   
/* 41 */   public final DateTimePath<Date> inputTime = createDateTime("inputTime", Date.class);
/*    */   
/*    */   public QAbstractBusiness(String variable) {
/* 44 */     this(AbstractBusiness.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QAbstractBusiness(Path<? extends AbstractBusiness> path) {
/* 48 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QAbstractBusiness(PathMetadata metadata) {
/* 52 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QAbstractBusiness(PathMetadata metadata, PathInits inits) {
/* 56 */     this(AbstractBusiness.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QAbstractBusiness(Class<? extends AbstractBusiness> type, PathMetadata metadata, PathInits inits) {
/* 60 */     super(type, metadata, inits);
/* 61 */     this.auditor = (inits.isInitialized("auditor") ? new QUser(forProperty("auditor"), inits.get("auditor")) : null);
/* 62 */     this.inputer = (inits.isInitialized("inputer") ? new QUser(forProperty("inputer"), inits.get("inputer")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\QAbstractBusiness.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */