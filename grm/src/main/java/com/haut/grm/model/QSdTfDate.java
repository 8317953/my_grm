package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSdTfDate is a Querydsl query type for SdTfDate
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSdTfDate extends EntityPathBase<SdTfDate> {

    private static final long serialVersionUID = 2049195435L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSdTfDate sdTfDate = new QSdTfDate("sdTfDate");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final com.haut.grm.model.meta.QUser acter;

    public final NumberPath<Double> aftergraintem = createNumber("aftergraintem", Double.class);

    public final NumberPath<Double> aftergrainwater = createNumber("aftergrainwater", Double.class);

    public final NumberPath<Double> afterinnertem = createNumber("afterinnertem", Double.class);

    public final NumberPath<Double> afterinnerwater = createNumber("afterinnerwater", Double.class);

    public final NumberPath<Double> afteroutertem = createNumber("afteroutertem", Double.class);

    public final NumberPath<Double> afterouterwater = createNumber("afterouterwater", Double.class);

    public final StringPath code = createString("code");

    public final DateTimePath<java.util.Date> endtime = createDateTime("endtime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.haut.grm.model.meta.QUser inputer;

    public final DateTimePath<java.util.Date> inputtime = createDateTime("inputtime", java.util.Date.class);

    public final com.haut.grm.model.meta.QUser manager;

    public final NumberPath<Double> pregraintem = createNumber("pregraintem", Double.class);

    public final NumberPath<Double> pregrainwater = createNumber("pregrainwater", Double.class);

    public final NumberPath<Double> preinnertem = createNumber("preinnertem", Double.class);

    public final NumberPath<Double> preinnerwater = createNumber("preinnerwater", Double.class);

    public final NumberPath<Double> preoutertem = createNumber("preoutertem", Double.class);

    public final NumberPath<Double> preouterwater = createNumber("preouterwater", Double.class);

    public final com.haut.grm.model.type.QPlaneProcessType processType;

    public final QSdTfPlane sdTfPlane;

    public final com.haut.grm.model.type.QSdSfType sftype;

    public final DateTimePath<java.util.Date> starttime = createDateTime("starttime", java.util.Date.class);

    public final QStore store;

    public final com.haut.grm.model.type.QSdTfMdType tfmd;

    public final com.haut.grm.model.type.QSdTfType tftype;

    public QSdTfDate(String variable) {
        this(SdTfDate.class, forVariable(variable), INITS);
    }

    public QSdTfDate(Path<? extends SdTfDate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSdTfDate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSdTfDate(PathMetadata metadata, PathInits inits) {
        this(SdTfDate.class, metadata, inits);
    }

    public QSdTfDate(Class<? extends SdTfDate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.acter = inits.isInitialized("acter") ? new com.haut.grm.model.meta.QUser(forProperty("acter"), inits.get("acter")) : null;
        this.inputer = inits.isInitialized("inputer") ? new com.haut.grm.model.meta.QUser(forProperty("inputer"), inits.get("inputer")) : null;
        this.manager = inits.isInitialized("manager") ? new com.haut.grm.model.meta.QUser(forProperty("manager"), inits.get("manager")) : null;
        this.processType = inits.isInitialized("processType") ? new com.haut.grm.model.type.QPlaneProcessType(forProperty("processType")) : null;
        this.sdTfPlane = inits.isInitialized("sdTfPlane") ? new QSdTfPlane(forProperty("sdTfPlane"), inits.get("sdTfPlane")) : null;
        this.sftype = inits.isInitialized("sftype") ? new com.haut.grm.model.type.QSdSfType(forProperty("sftype")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
        this.tfmd = inits.isInitialized("tfmd") ? new com.haut.grm.model.type.QSdTfMdType(forProperty("tfmd")) : null;
        this.tftype = inits.isInitialized("tftype") ? new com.haut.grm.model.type.QSdTfType(forProperty("tftype")) : null;
    }

}

