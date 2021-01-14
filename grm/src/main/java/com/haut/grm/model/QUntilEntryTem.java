package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUntilEntryTem is a Querydsl query type for UntilEntryTem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUntilEntryTem extends EntityPathBase<UntilEntryTem> {

    private static final long serialVersionUID = -873316018L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUntilEntryTem untilEntryTem = new QUntilEntryTem("untilEntryTem");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final StringPath data = createString("data");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QStore store;

    public final DateTimePath<java.util.Date> time = createDateTime("time", java.util.Date.class);

    public final StringPath ymd = createString("ymd");

    public QUntilEntryTem(String variable) {
        this(UntilEntryTem.class, forVariable(variable), INITS);
    }

    public QUntilEntryTem(Path<? extends UntilEntryTem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUntilEntryTem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUntilEntryTem(PathMetadata metadata, PathInits inits) {
        this(UntilEntryTem.class, metadata, inits);
    }

    public QUntilEntryTem(Class<? extends UntilEntryTem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

