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
/*    */ public class QScale
/*    */   extends EntityPathBase<Scale>
/*    */ {
/*    */   private static final long serialVersionUID = 713243024L;
/* 20 */   public static final QScale scale = new QScale("scale");
/*    */   
/* 22 */   public final QAbstractType _super = new QAbstractType(this);
/*    */   
/*    */ 
/* 25 */   public final NumberPath<Integer> codeId = this._super.codeId;
/*    */   
/* 27 */   public final NumberPath<Long> factor = createNumber("factor", Long.class);
/*    */   
/*    */ 
/* 30 */   public final NumberPath<Long> id = this._super.id;
/*    */   
/*    */ 
/* 33 */   public final StringPath name = this._super.name;
/*    */   
/*    */   public QScale(String variable) {
/* 36 */     super(Scale.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QScale(Path<? extends Scale> path) {
/* 40 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QScale(PathMetadata metadata) {
/* 44 */     super(Scale.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\type\QScale.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */