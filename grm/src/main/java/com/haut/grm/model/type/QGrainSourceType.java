/*    */ package com.haut.grm.model.type;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractType;
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
/*    */ public class QGrainSourceType
/*    */   extends EntityPathBase<GrainSourceType>
/*    */ {
/*    */   private static final long serialVersionUID = 779253142L;
/* 20 */   public static final QGrainSourceType grainSourceType = new QGrainSourceType("grainSourceType");
/*    */   
/* 22 */   public final QAbstractType _super = new QAbstractType(this);
/*    */   
/*    */ 
/* 25 */   public final NumberPath<Integer> codeId = this._super.codeId;
/*    */   
/*    */ 
/* 28 */   public final NumberPath<Long> id = this._super.id;
/*    */   
/*    */ 
/* 31 */   public final StringPath name = this._super.name;
/*    */   
/*    */   public QGrainSourceType(String variable) {
/* 34 */     super(GrainSourceType.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QGrainSourceType(Path<? extends GrainSourceType> path) {
/* 38 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QGrainSourceType(PathMetadata metadata) {
/* 42 */     super(GrainSourceType.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\type\QGrainSourceType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */