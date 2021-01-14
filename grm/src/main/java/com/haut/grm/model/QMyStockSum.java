package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyStockSum is a Querydsl query type for MyStockSum
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyStockSum extends EntityPathBase<MyStockSum> {

    private static final long serialVersionUID = -1205974693L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyStockSum myStockSum = new QMyStockSum("myStockSum");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    public final QCargo cargo;

    public final QDepot depot;

    public final NumberPath<Double> hasamount = createNumber("hasamount", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> inamount = createNumber("inamount", Double.class);

    public final DateTimePath<java.util.Date> inputtime = createDateTime("inputtime", java.util.Date.class);

    public final NumberPath<Double> outamount = createNumber("outamount", Double.class);

    public final QStore store;

    public QMyStockSum(String variable) {
        this(MyStockSum.class, forVariable(variable), INITS);
    }

    public QMyStockSum(Path<? extends MyStockSum> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyStockSum(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyStockSum(PathMetadata metadata, PathInits inits) {
        this(MyStockSum.class, metadata, inits);
    }

    public QMyStockSum(Class<? extends MyStockSum> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cargo = inits.isInitialized("cargo") ? new QCargo(forProperty("cargo"), inits.get("cargo")) : null;
        this.depot = inits.isInitialized("depot") ? new QDepot(forProperty("depot"), inits.get("depot")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

