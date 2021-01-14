/*    */ package com.haut.grm.model;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.type.QSpaceCondition;
/*    */ import com.haut.grm.model.type.QSpaceStatus;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DatePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.SetPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class QCompartment
/*    */   extends EntityPathBase<Compartment>
/*    */ {
/*    */   private static final long serialVersionUID = -1797788840L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QCompartment compartment = new QCompartment("compartment");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final DatePath<Date> activeDate = createDate("activeDate", Date.class);
/*    */   
/* 29 */   public final StringPath actualVolume = createString("actualVolume");
/*    */   
/* 31 */   public final NumberPath<Double> breadth = createNumber("breadth", Double.class);
/*    */   
/* 33 */   public final SetPath<Cargo, QCargo> cargos = createSet("cargos", Cargo.class, QCargo.class, PathInits.DIRECT2);
/*    */   
/* 35 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/*    */   public final QSpaceCondition condition;
/*    */   
/* 39 */   public final StringPath designVolume = createString("designVolume");
/*    */   
/* 41 */   public final NumberPath<Double> grainHeight = createNumber("grainHeight", Double.class);
/*    */   
/* 43 */   public final NumberPath<Double> height = createNumber("height", Double.class);
/*    */   
/* 45 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 47 */   public final NumberPath<Double> latitude = createNumber("latitude", Double.class);
/*    */   
/* 49 */   public final NumberPath<Double> length = createNumber("length", Double.class);
/*    */   
/* 51 */   public final NumberPath<Double> longitude = createNumber("longitude", Double.class);
/*    */   
/* 53 */   public final StringPath name = createString("name");
/*    */   
/*    */   public final QSpaceStatus status;
/*    */   public final QStore store;
/*    */   
/*    */   public QCompartment(String variable)
/*    */   {
/* 60 */     this(Compartment.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QCompartment(Path<? extends Compartment> path) {
/* 64 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QCompartment(PathMetadata metadata) {
/* 68 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QCompartment(PathMetadata metadata, PathInits inits) {
/* 72 */     this(Compartment.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QCompartment(Class<? extends Compartment> type, PathMetadata metadata, PathInits inits) {
/* 76 */     super(type, metadata, inits);
/* 77 */     this.condition = (inits.isInitialized("condition") ? new QSpaceCondition(forProperty("condition")) : null);
/* 78 */     this.status = (inits.isInitialized("status") ? new QSpaceStatus(forProperty("status")) : null);
/* 79 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\QCompartment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */