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
/*    */ public class QPackageType
/*    */   extends EntityPathBase<PackageType>
/*    */ {
/*    */   private static final long serialVersionUID = -63043482L;
/* 20 */   public static final QPackageType packageType = new QPackageType("packageType");
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
/* 33 */   public final StringPath shortName = createString("shortName");
/*    */   
/* 35 */   public final StringPath size = createString("size");
/*    */   
/*    */   public QPackageType(String variable) {
/* 38 */     super(PackageType.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QPackageType(Path<? extends PackageType> path) {
/* 42 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QPackageType(PathMetadata metadata) {
/* 46 */     super(PackageType.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\type\QPackageType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */