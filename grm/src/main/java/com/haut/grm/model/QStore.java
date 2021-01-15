package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = -1515952025L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStore store = new QStore("store");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final NumberPath<Long> actualVolume = createNumber("actualVolume", Long.class);

    public final NumberPath<Double> breadth = createNumber("breadth", Double.class);

    public final QDeviceCamera camera;

    public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);

    public final SetPath<Compartment, QCompartment> compartments = this.<Compartment, QCompartment>createSet("compartments", Compartment.class, QCompartment.class, PathInits.DIRECT2);

    public final QStoreConfig config;

    public final QDepot depot;

    public final NumberPath<Long> designVolume = createNumber("designVolume", Long.class);

    public final SetPath<Door, QDoor> doors = this.<Door, QDoor>createSet("doors", Door.class, QDoor.class, PathInits.DIRECT2);

    public final NumberPath<Double> grainHeight = createNumber("grainHeight", Double.class);

    public final NumberPath<Double> height = createNumber("height", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> length = createNumber("length", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath name = createString("name");

    public final SetPath<SdTfSb, QSdTfSb> sdTfSbs = this.<SdTfSb, QSdTfSb>createSet("sdTfSbs", SdTfSb.class, QSdTfSb.class, PathInits.DIRECT2);

    public final QStoreStatus status;

    public QStore(String variable) {
        this(Store.class, forVariable(variable), INITS);
    }

    public QStore(Path<? extends Store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStore(PathMetadata metadata, PathInits inits) {
        this(Store.class, metadata, inits);
    }

    public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.camera = inits.isInitialized("camera") ? new QDeviceCamera(forProperty("camera"), inits.get("camera")) : null;
        this.config = inits.isInitialized("config") ? new QStoreConfig(forProperty("config"), inits.get("config")) : null;
        this.depot = inits.isInitialized("depot") ? new QDepot(forProperty("depot"), inits.get("depot")) : null;
        this.status = inits.isInitialized("status") ? new QStoreStatus(forProperty("status"), inits.get("status")) : null;
    }

}

