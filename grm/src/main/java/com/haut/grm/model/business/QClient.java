/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractBusiness;
/*    */ import com.haut.grm.model.meta.QUser;
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
/*    */ 
/*    */ public class QClient
/*    */   extends EntityPathBase<Client>
/*    */ {
/*    */   private static final long serialVersionUID = 797709823L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QClient client = new QClient("client");
/*    */   
/*    */   public final QAbstractBusiness _super;
/*    */   
/* 27 */   public final StringPath address = createString("address");
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
/*    */   
/* 55 */   public final StringPath telephone = createString("telephone");
/*    */   
/*    */   public QClient(String variable) {
/* 58 */     this(Client.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QClient(Path<? extends Client> path) {
/* 62 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QClient(PathMetadata metadata) {
/* 66 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QClient(PathMetadata metadata, PathInits inits) {
/* 70 */     this(Client.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QClient(Class<? extends Client> type, PathMetadata metadata, PathInits inits) {
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
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */