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
/*    */ public class QAnalysisType
/*    */   extends EntityPathBase<AnalysisType>
/*    */ {
/*    */   private static final long serialVersionUID = -1815642832L;
/* 20 */   public static final QAnalysisType analysisType = new QAnalysisType("analysisType");
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
/*    */   public QAnalysisType(String variable) {
/* 34 */     super(AnalysisType.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QAnalysisType(Path<? extends AnalysisType> path) {
/* 38 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QAnalysisType(PathMetadata metadata) {
/* 42 */     super(AnalysisType.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\type\QAnalysisType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */