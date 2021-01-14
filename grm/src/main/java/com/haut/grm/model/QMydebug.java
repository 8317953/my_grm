package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMydebug is a Querydsl query type for Mydebug
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMydebug extends EntityPathBase<Mydebug> {

    private static final long serialVersionUID = -1733436883L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMydebug mydebug = new QMydebug("mydebug");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final QCompartment compartment;

    public final StringPath content = createString("content");

    public final QDepot depot;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QStore store;

    public final QStore storem;

    public final StringPath url = createString("url");

    public QMydebug(String variable) {
        this(Mydebug.class, forVariable(variable), INITS);
    }

    public QMydebug(Path<? extends Mydebug> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMydebug(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMydebug(PathMetadata metadata, PathInits inits) {
        this(Mydebug.class, metadata, inits);
    }

    public QMydebug(Class<? extends Mydebug> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.compartment = inits.isInitialized("compartment") ? new QCompartment(forProperty("compartment"), inits.get("compartment")) : null;
        this.depot = inits.isInitialized("depot") ? new QDepot(forProperty("depot"), inits.get("depot")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
        this.storem = inits.isInitialized("storem") ? new QStore(forProperty("storem"), inits.get("storem")) : null;
    }

}

