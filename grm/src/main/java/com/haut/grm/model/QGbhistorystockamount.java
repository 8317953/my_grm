//package com.haut.grm.model;
//
//import static com.querydsl.core.types.PathMetadataFactory.*;
//
//import com.querydsl.core.types.dsl.*;
//
//import com.querydsl.core.types.PathMetadata;
//import javax.annotation.Generated;
//import com.querydsl.core.types.Path;
//
//
///**
// * QGbhistorystockamount is a Querydsl query type for Gbhistorystockamount
// */
//@Generated("com.querydsl.codegen.EntitySerializer")
//public class QGbhistorystockamount extends EntityPathBase<Gbhistorystockamount> {
//
//    private static final long serialVersionUID = 29480367L;
//
//    public static final QGbhistorystockamount gbhistorystockamount = new QGbhistorystockamount("gbhistorystockamount");
//
//    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);
//
//    public final NumberPath<Double> amount = createNumber("amount", Double.class);
//
//    public final StringPath businesskey = createString("businesskey");
//
//    public final NumberPath<Long> id = createNumber("id", Long.class);
//
//    public final NumberPath<Integer> inorout = createNumber("inorout", Integer.class);
//
//    public final DateTimePath<java.util.Date> input_time = createDateTime("input_time", java.util.Date.class);
//
//    public final NumberPath<Integer> stockid = createNumber("stockid", Integer.class);
//
//    public QGbhistorystockamount(String variable) {
//        super(Gbhistorystockamount.class, forVariable(variable));
//    }
//
//    public QGbhistorystockamount(Path<? extends Gbhistorystockamount> path) {
//        super(path.getType(), path.getMetadata());
//    }
//
//    public QGbhistorystockamount(PathMetadata metadata) {
//        super(Gbhistorystockamount.class, metadata);
//    }
//
//}
//
