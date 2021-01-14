/*    */ package com.haut.grm.model.standalone;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractStandalone;
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
/*    */ public class QLoadCompany
/*    */   extends EntityPathBase<LoadCompany>
/*    */ {
/*    */   private static final long serialVersionUID = 310444424L;
/* 20 */   public static final QLoadCompany loadCompany = new QLoadCompany("loadCompany");
/*    */   
/* 22 */   public final QAbstractStandalone _super = new QAbstractStandalone(this);
/*    */   
/*    */ 
/* 25 */   public final NumberPath<Long> id = this._super.id;
/*    */   
/*    */ 
/* 28 */   public final StringPath name = this._super.name;
/*    */   
/*    */ 
/* 31 */   public final NumberPath<Integer> order = this._super.order;
/*    */   
/*    */   public QLoadCompany(String variable) {
/* 34 */     super(LoadCompany.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QLoadCompany(Path<? extends LoadCompany> path) {
/* 38 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QLoadCompany(PathMetadata metadata) {
/* 42 */     super(LoadCompany.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\standalone\QLoadCompany.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */