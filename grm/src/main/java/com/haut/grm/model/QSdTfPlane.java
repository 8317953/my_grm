package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSdTfPlane is a Querydsl query type for SdTfPlane
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSdTfPlane extends EntityPathBase<SdTfPlane> {

    private static final long serialVersionUID = -888058881L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSdTfPlane sdTfPlane = new QSdTfPlane("sdTfPlane");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final com.haut.grm.model.meta.QUser acter;

    public final StringPath code = createString("code");

    public final QDepot depot;

    public final DateTimePath<java.util.Date> enddate = createDateTime("enddate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.haut.grm.model.meta.QUser inputer;

    public final DateTimePath<java.util.Date> inputtime = createDateTime("inputtime", java.util.Date.class);

    public final com.haut.grm.model.meta.QUser manager;

    public final com.haut.grm.model.type.QPlaneProcessType processType;

    public final com.haut.grm.model.type.QSdSfType sftype;

    public final DateTimePath<java.util.Date> startdate = createDateTime("startdate", java.util.Date.class);

    public final SetPath<StorePerTemWater, QStorePerTemWater> storePerTemWater = this.<StorePerTemWater, QStorePerTemWater>createSet("storePerTemWater", StorePerTemWater.class, QStorePerTemWater.class, PathInits.DIRECT2);

    public final com.haut.grm.model.type.QSdTfMdType tfmd;

    public final com.haut.grm.model.type.QSdTfType tftype;

    public QSdTfPlane(String variable) {
        this(SdTfPlane.class, forVariable(variable), INITS);
    }

    public QSdTfPlane(Path<? extends SdTfPlane> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSdTfPlane(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSdTfPlane(PathMetadata metadata, PathInits inits) {
        this(SdTfPlane.class, metadata, inits);
    }

    public QSdTfPlane(Class<? extends SdTfPlane> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.acter = inits.isInitialized("acter") ? new com.haut.grm.model.meta.QUser(forProperty("acter"), inits.get("acter")) : null;
        this.depot = inits.isInitialized("depot") ? new QDepot(forProperty("depot"), inits.get("depot")) : null;
        this.inputer = inits.isInitialized("inputer") ? new com.haut.grm.model.meta.QUser(forProperty("inputer"), inits.get("inputer")) : null;
        this.manager = inits.isInitialized("manager") ? new com.haut.grm.model.meta.QUser(forProperty("manager"), inits.get("manager")) : null;
        this.processType = inits.isInitialized("processType") ? new com.haut.grm.model.type.QPlaneProcessType(forProperty("processType")) : null;
        this.sftype = inits.isInitialized("sftype") ? new com.haut.grm.model.type.QSdSfType(forProperty("sftype")) : null;
        this.tfmd = inits.isInitialized("tfmd") ? new com.haut.grm.model.type.QSdTfMdType(forProperty("tfmd")) : null;
        this.tftype = inits.isInitialized("tftype") ? new com.haut.grm.model.type.QSdTfType(forProperty("tftype")) : null;
    }

}

