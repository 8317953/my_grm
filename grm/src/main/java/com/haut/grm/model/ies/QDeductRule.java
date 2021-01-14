/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.type.QAnalysisLevel;
/*    */ import com.haut.grm.model.type.QAnalysisType;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.BooleanPath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QDeductRule
/*    */   extends EntityPathBase<DeductRule>
/*    */ {
/*    */   private static final long serialVersionUID = 100036880L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QDeductRule deductRule = new QDeductRule("deductRule");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final BooleanPath active = createBoolean("active");
/*    */   
/* 29 */   public final NumberPath<Float> down = createNumber("down", Float.class);
/*    */   
/* 31 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/*    */   public final QAnalysisLevel level;
/*    */   
/* 35 */   public final BooleanPath reject = createBoolean("reject");
/*    */   
/*    */   public final QAnalysisType type;
/*    */   
/* 39 */   public final NumberPath<Float> up = createNumber("up", Float.class);
/*    */   
/*    */   public QDeductRule(String variable) {
/* 42 */     this(DeductRule.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QDeductRule(Path<? extends DeductRule> path) {
/* 46 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QDeductRule(PathMetadata metadata) {
/* 50 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QDeductRule(PathMetadata metadata, PathInits inits) {
/* 54 */     this(DeductRule.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QDeductRule(Class<? extends DeductRule> type, PathMetadata metadata, PathInits inits) {
/* 58 */     super(type, metadata, inits);
/* 59 */     this.level = (inits.isInitialized("level") ? new QAnalysisLevel(forProperty("level")) : null);
/* 60 */     this.type = (inits.isInitialized("type") ? new QAnalysisType(forProperty("type")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\QDeductRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */