/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.type.QMaterialType;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QMaterialSum
/*    */   extends EntityPathBase<MaterialSum>
/*    */ {
/*    */   private static final long serialVersionUID = -1477338640L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QMaterialSum materialSum = new QMaterialSum("materialSum");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 29 */   public final NumberPath<Long> in = createNumber("in", Long.class);
/*    */   
/* 31 */   public final StringPath name = createString("name");
/*    */   
/* 33 */   public final NumberPath<Long> out = createNumber("out", Long.class);
/*    */   
/* 35 */   public final NumberPath<Long> total = createNumber("total", Long.class);
/*    */   public final QMaterialType type;
/*    */   
/*    */   public QMaterialSum(String variable)
/*    */   {
/* 40 */     this(MaterialSum.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QMaterialSum(Path<? extends MaterialSum> path) {
/* 44 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QMaterialSum(PathMetadata metadata) {
/* 48 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QMaterialSum(PathMetadata metadata, PathInits inits) {
/* 52 */     this(MaterialSum.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QMaterialSum(Class<? extends MaterialSum> type, PathMetadata metadata, PathInits inits) {
/* 56 */     super(type, metadata, inits);
/* 57 */     this.type = (inits.isInitialized("type") ? new QMaterialType(forProperty("type")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QMaterialSum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */