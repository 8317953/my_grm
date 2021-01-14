/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.type.QCardType;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.BooleanPath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QCard
/*    */   extends EntityPathBase<Card>
/*    */ {
/*    */   private static final long serialVersionUID = -835389823L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QCard card = new QCard("card");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 29 */   public final BooleanPath isActive = createBoolean("isActive");
/*    */   
/* 31 */   public final BooleanPath isUsing = createBoolean("isUsing");
/*    */   
/* 33 */   public final StringPath physicalNumber = createString("physicalNumber");
/*    */   
/* 35 */   public final StringPath printNumber = createString("printNumber");
/*    */   public final QCardType type;
/*    */   
/*    */   public QCard(String variable)
/*    */   {
/* 40 */     this(Card.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QCard(Path<? extends Card> path) {
/* 44 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QCard(PathMetadata metadata) {
/* 48 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QCard(PathMetadata metadata, PathInits inits) {
/* 52 */     this(Card.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QCard(Class<? extends Card> type, PathMetadata metadata, PathInits inits) {
/* 56 */     super(type, metadata, inits);
/* 57 */     this.type = (inits.isInitialized("type") ? new QCardType(forProperty("type")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\QCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */