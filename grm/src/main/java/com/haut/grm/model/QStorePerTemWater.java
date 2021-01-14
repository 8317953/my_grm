package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStorePerTemWater is a Querydsl query type for StorePerTemWater
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStorePerTemWater extends EntityPathBase<StorePerTemWater> {

    private static final long serialVersionUID = 304035761L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStorePerTemWater storePerTemWater = new QStorePerTemWater("storePerTemWater");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final NumberPath<Double> graintem = createNumber("graintem", Double.class);

    public final NumberPath<Double> grainwater = createNumber("grainwater", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> innertem = createNumber("innertem", Double.class);

    public final NumberPath<Double> innerwater = createNumber("innerwater", Double.class);

    public final NumberPath<Double> outtem = createNumber("outtem", Double.class);

    public final NumberPath<Double> outwater = createNumber("outwater", Double.class);

    public final QSdTfPlane sdTfPlane;

    public final QStore store;

    public QStorePerTemWater(String variable) {
        this(StorePerTemWater.class, forVariable(variable), INITS);
    }

    public QStorePerTemWater(Path<? extends StorePerTemWater> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStorePerTemWater(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStorePerTemWater(PathMetadata metadata, PathInits inits) {
        this(StorePerTemWater.class, metadata, inits);
    }

    public QStorePerTemWater(Class<? extends StorePerTemWater> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.sdTfPlane = inits.isInitialized("sdTfPlane") ? new QSdTfPlane(forProperty("sdTfPlane"), inits.get("sdTfPlane")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

