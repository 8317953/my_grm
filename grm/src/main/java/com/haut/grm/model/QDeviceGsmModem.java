package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDeviceGsmModem is a Querydsl query type for DeviceGsmModem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDeviceGsmModem extends EntityPathBase<DeviceGsmModem> {

    private static final long serialVersionUID = 1044407897L;

    public static final QDeviceGsmModem deviceGsmModem = new QDeviceGsmModem("deviceGsmModem");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final NumberPath<Integer> baudRate = createNumber("baudRate", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath manufacture = createString("manufacture");

    public final StringPath model = createString("model");

    public final StringPath port = createString("port");

    public QDeviceGsmModem(String variable) {
        super(DeviceGsmModem.class, forVariable(variable));
    }

    public QDeviceGsmModem(Path<? extends DeviceGsmModem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDeviceGsmModem(PathMetadata metadata) {
        super(DeviceGsmModem.class, metadata);
    }

}

