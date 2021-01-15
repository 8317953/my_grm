package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDeviceCamera is a Querydsl query type for DeviceCamera
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDeviceCamera extends EntityPathBase<DeviceCamera> {

    private static final long serialVersionUID = -1855167787L;

    private static final PathInits INITS = new PathInits("*", "store.depot.*");

    public static final QDeviceCamera deviceCamera = new QDeviceCamera("deviceCamera");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final NumberPath<Float> height = createNumber("height", Float.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath ipAddress = createString("ipAddress");

    public final com.haut.grm.model.type.QCameraManufacturer manufacturer;

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> port = createNumber("port", Integer.class);

    public final StringPath positionX = createString("positionX");

    public final StringPath positionY = createString("positionY");

    public final QStore store;

    public final com.haut.grm.model.type.QCameraType type;

    public final StringPath username = createString("username");

    public QDeviceCamera(String variable) {
        this(DeviceCamera.class, forVariable(variable), INITS);
    }

    public QDeviceCamera(Path<? extends DeviceCamera> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDeviceCamera(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDeviceCamera(PathMetadata metadata, PathInits inits) {
        this(DeviceCamera.class, metadata, inits);
    }

    public QDeviceCamera(Class<? extends DeviceCamera> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.manufacturer = inits.isInitialized("manufacturer") ? new com.haut.grm.model.type.QCameraManufacturer(forProperty("manufacturer")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
        this.type = inits.isInitialized("type") ? new com.haut.grm.model.type.QCameraType(forProperty("type")) : null;
    }

}

