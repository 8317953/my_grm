package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSdTfEquipStatus is a Querydsl query type for SdTfEquipStatus
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSdTfEquipStatus extends EntityPathBase<SdTfEquipStatus> {

    private static final long serialVersionUID = 1722264485L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSdTfEquipStatus sdTfEquipStatus = new QSdTfEquipStatus("sdTfEquipStatus");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final com.haut.grm.model.type.QEquipStatusType equipstatus;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.haut.grm.model.meta.QUser inputer;

    public final DateTimePath<java.util.Date> inputtime = createDateTime("inputtime", java.util.Date.class);

    public final QSdTfDate sdTfDate;

    public final QSdTfPlane sdTfPlane;

    public final QSdTfSb tfequip;

    public QSdTfEquipStatus(String variable) {
        this(SdTfEquipStatus.class, forVariable(variable), INITS);
    }

    public QSdTfEquipStatus(Path<? extends SdTfEquipStatus> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSdTfEquipStatus(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSdTfEquipStatus(PathMetadata metadata, PathInits inits) {
        this(SdTfEquipStatus.class, metadata, inits);
    }

    public QSdTfEquipStatus(Class<? extends SdTfEquipStatus> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.equipstatus = inits.isInitialized("equipstatus") ? new com.haut.grm.model.type.QEquipStatusType(forProperty("equipstatus")) : null;
        this.inputer = inits.isInitialized("inputer") ? new com.haut.grm.model.meta.QUser(forProperty("inputer"), inits.get("inputer")) : null;
        this.sdTfDate = inits.isInitialized("sdTfDate") ? new QSdTfDate(forProperty("sdTfDate"), inits.get("sdTfDate")) : null;
        this.sdTfPlane = inits.isInitialized("sdTfPlane") ? new QSdTfPlane(forProperty("sdTfPlane"), inits.get("sdTfPlane")) : null;
        this.tfequip = inits.isInitialized("tfequip") ? new QSdTfSb(forProperty("tfequip"), inits.get("tfequip")) : null;
    }

}

