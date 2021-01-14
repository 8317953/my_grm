/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.QStore;
/*    */ import com.haut.grm.model.base.QAbstractBusiness;
/*    */ import com.haut.grm.model.meta.QUser;
/*    */ import com.haut.grm.model.type.QWorkloadCategory;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DatePath;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class QWorkloadSchedule extends EntityPathBase<WorkloadSchedule>
/*    */ {
/*    */   private static final long serialVersionUID = -724624286L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QWorkloadSchedule workloadSchedule = new QWorkloadSchedule("workloadSchedule");
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
/*    */   public final QWorkloadCategory category;
/*    */   
/* 41 */   public final StringPath color = createString("color");
/*    */   
/* 43 */   public final DatePath<Date> endDate = createDate("endDate", Date.class);
/*    */   
/* 45 */   public final StringPath endTime = createString("endTime");
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
/* 59 */   public final DatePath<Date> startDate = createDate("startDate", Date.class);
/*    */   
/* 61 */   public final StringPath startTime = createString("startTime");
/*    */   public final QStore store;
/*    */   
/*    */   public QWorkloadSchedule(String variable)
/*    */   {
/* 66 */     this(WorkloadSchedule.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QWorkloadSchedule(Path<? extends WorkloadSchedule> path) {
/* 70 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QWorkloadSchedule(PathMetadata metadata) {
/* 74 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QWorkloadSchedule(PathMetadata metadata, PathInits inits) {
/* 78 */     this(WorkloadSchedule.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QWorkloadSchedule(Class<? extends WorkloadSchedule> type, PathMetadata metadata, PathInits inits) {
/* 82 */     super(type, metadata, inits);
/* 83 */     this._super = new QAbstractBusiness(type, metadata, inits);
/* 84 */     this.auditComment = this._super.auditComment;
/* 85 */     this.auditor = this._super.auditor;
/* 86 */     this.auditTime = this._super.auditTime;
/* 87 */     this.businessKey = this._super.businessKey;
/* 88 */     this.category = (inits.isInitialized("category") ? new QWorkloadCategory(forProperty("category")) : null);
/* 89 */     this.id = this._super.id;
/* 90 */     this.inputComment = this._super.inputComment;
/* 91 */     this.inputer = this._super.inputer;
/* 92 */     this.inputTime = this._super.inputTime;
/* 93 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QWorkloadSchedule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */