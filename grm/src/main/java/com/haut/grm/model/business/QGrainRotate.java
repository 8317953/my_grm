/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.QDepot;
/*    */ import com.haut.grm.model.base.QAbstractBusiness;
/*    */ import com.haut.grm.model.meta.QUser;
/*    */ import com.haut.grm.model.standard.code.QGrainVariety;
/*    */ import com.haut.grm.model.type.QGrainType;
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
/*    */ public class QGrainRotate extends EntityPathBase<GrainRotate>
/*    */ {
/*    */   private static final long serialVersionUID = 131538946L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QGrainRotate grainRotate = new QGrainRotate("grainRotate");
/*    */   
/*    */   public final QAbstractBusiness _super;
/*    */   
/* 27 */   public final NumberPath<Long> amount = createNumber("amount", Long.class);
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
/*    */ 
/*    */   public final StringPath businessKey;
/*    */   
/*    */   public final QDepot depot;
/*    */   
/*    */   public final QGrainType grainType;
/*    */   
/*    */   public final QGrainVariety grainVariety;
/*    */   
/* 47 */   public final StringPath harvestYear = createString("harvestYear");
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
/* 61 */   public final com.querydsl.core.types.dsl.BooleanPath isIngress = createBoolean("isIngress");
/*    */   
/* 63 */   public final NumberPath<Integer> stockYear = createNumber("stockYear", Integer.class);
/*    */   
/* 65 */   public final StringPath year = createString("year");
/*    */   
/*    */   public QGrainRotate(String variable) {
/* 68 */     this(GrainRotate.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QGrainRotate(Path<? extends GrainRotate> path) {
/* 72 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QGrainRotate(PathMetadata metadata) {
/* 76 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QGrainRotate(PathMetadata metadata, PathInits inits) {
/* 80 */     this(GrainRotate.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QGrainRotate(Class<? extends GrainRotate> type, PathMetadata metadata, PathInits inits) {
/* 84 */     super(type, metadata, inits);
/* 85 */     this._super = new QAbstractBusiness(type, metadata, inits);
/* 86 */     this.auditComment = this._super.auditComment;
/* 87 */     this.auditor = this._super.auditor;
/* 88 */     this.auditTime = this._super.auditTime;
/* 89 */     this.businessKey = this._super.businessKey;
/* 90 */     this.depot = (inits.isInitialized("depot") ? new QDepot(forProperty("depot"), inits.get("depot")) : null);
/* 91 */     this.grainType = (inits.isInitialized("grainType") ? new QGrainType(forProperty("grainType")) : null);
/* 92 */     this.grainVariety = (inits.isInitialized("grainVariety") ? new QGrainVariety(forProperty("grainVariety")) : null);
/* 93 */     this.id = this._super.id;
/* 94 */     this.inputComment = this._super.inputComment;
/* 95 */     this.inputer = this._super.inputer;
/* 96 */     this.inputTime = this._super.inputTime;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QGrainRotate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */