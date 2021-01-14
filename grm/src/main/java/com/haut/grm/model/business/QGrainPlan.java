/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractBusiness;
/*    */ import com.haut.grm.model.meta.QUser;
/*    */ import com.haut.grm.model.type.QPlanType;
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
/*    */ public class QGrainPlan
/*    */   extends EntityPathBase<GrainPlan>
/*    */ {
/*    */   private static final long serialVersionUID = 1054821264L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QGrainPlan grainPlan = new QGrainPlan("grainPlan");
/*    */   
/*    */ 
/*    */   public final QAbstractBusiness _super;
/*    */   
/*    */ 
/*    */   public final StringPath auditComment;
/*    */   
/*    */ 
/*    */   public final QUser auditor;
/*    */   
/*    */ 
/*    */   public final DateTimePath<Date> auditTime;
/*    */   
/*    */   public final StringPath businessKey;
/*    */   
/* 39 */   public final StringPath content = createString("content");
/*    */   
/*    */ 
/*    */   public final NumberPath<Long> id;
/*    */   
/*    */ 
/*    */   public final StringPath inputComment;
/*    */   
/*    */ 
/*    */   public final QUser inputer;
/*    */   
/*    */ 
/*    */   public final DateTimePath<Date> inputTime;
/*    */   
/* 53 */   public final StringPath name = createString("name");
/*    */   public final QPlanType type;
/*    */   
/*    */   public QGrainPlan(String variable)
/*    */   {
/* 58 */     this(GrainPlan.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QGrainPlan(Path<? extends GrainPlan> path) {
/* 62 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QGrainPlan(PathMetadata metadata) {
/* 66 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QGrainPlan(PathMetadata metadata, PathInits inits) {
/* 70 */     this(GrainPlan.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QGrainPlan(Class<? extends GrainPlan> type, PathMetadata metadata, PathInits inits) {
/* 74 */     super(type, metadata, inits);
/* 75 */     this._super = new QAbstractBusiness(type, metadata, inits);
/* 76 */     this.auditComment = this._super.auditComment;
/* 77 */     this.auditor = this._super.auditor;
/* 78 */     this.auditTime = this._super.auditTime;
/* 79 */     this.businessKey = this._super.businessKey;
/* 80 */     this.id = this._super.id;
/* 81 */     this.inputComment = this._super.inputComment;
/* 82 */     this.inputer = this._super.inputer;
/* 83 */     this.inputTime = this._super.inputTime;
/* 84 */     this.type = (inits.isInitialized("type") ? new QPlanType(forProperty("type")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QGrainPlan.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */