package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreStatus is a Querydsl query type for StoreStatus
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStoreStatus extends EntityPathBase<StoreStatus> {

    private static final long serialVersionUID = 1066072889L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreStatus storeStatus = new QStoreStatus("storeStatus");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final DatePath<java.util.Date> activeDate = createDate("activeDate", java.util.Date.class);

    public final BooleanPath alerting = createBoolean("alerting");

    public final com.haut.grm.model.type.QSpaceCondition condition;

    public final StringPath doorComment = createString("doorComment");

    public final DateTimePath<java.util.Date> doorTime = createDateTime("doorTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isMeasureOngoing = createBoolean("isMeasureOngoing");

    public final StringPath measureComment = createString("measureComment");

    public final DateTimePath<java.util.Date> measureTime = createDateTime("measureTime", java.util.Date.class);

    public final StringPath safetyComment = createString("safetyComment");

    public final DateTimePath<java.util.Date> safetyTime = createDateTime("safetyTime", java.util.Date.class);

    public final com.haut.grm.model.type.QSpaceStatus status;

    public final QStore store;

    public QStoreStatus(String variable) {
        this(StoreStatus.class, forVariable(variable), INITS);
    }

    public QStoreStatus(Path<? extends StoreStatus> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreStatus(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreStatus(PathMetadata metadata, PathInits inits) {
        this(StoreStatus.class, metadata, inits);
    }

    public QStoreStatus(Class<? extends StoreStatus> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.condition = inits.isInitialized("condition") ? new com.haut.grm.model.type.QSpaceCondition(forProperty("condition")) : null;
        this.status = inits.isInitialized("status") ? new com.haut.grm.model.type.QSpaceStatus(forProperty("status")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

