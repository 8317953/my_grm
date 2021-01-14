package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlane is a Querydsl query type for Plane
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlane extends EntityPathBase<Plane> {

    private static final long serialVersionUID = -1518974494L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlane plane = new QPlane("plane");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final com.haut.grm.model.business.QContract contract;

    public final StringPath file_path = createString("file_path");

    public final com.haut.grm.model.type.QGrainType grain_type;

    public final com.haut.grm.model.standard.code.QGrainVariety grain_variety;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> input_time = createDateTime("input_time", java.util.Date.class);

    public final com.haut.grm.model.meta.QUser input_user;

    public final NumberPath<Double> plane_amount = createNumber("plane_amount", Double.class);

    public final StringPath plane_business = createString("plane_business");

    public final com.haut.grm.model.type.QPlaneDwType plane_bzdw;

    public final DateTimePath<java.util.Date> plane_end_date = createDateTime("plane_end_date", java.util.Date.class);

    public final com.haut.grm.model.type.QPlaneDwType plane_gldw;

    public final StringPath plane_name = createString("plane_name");

    public final DateTimePath<java.util.Date> plane_start_date = createDateTime("plane_start_date", java.util.Date.class);

    public final com.haut.grm.model.type.QPlanType plane_type;

    public final StringPath plane_wenhao = createString("plane_wenhao");

    public final com.haut.grm.model.type.QPlaneDwType plane_zxdw;

    public final com.haut.grm.model.type.QPlaneProcessType process;

    public QPlane(String variable) {
        this(Plane.class, forVariable(variable), INITS);
    }

    public QPlane(Path<? extends Plane> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlane(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlane(PathMetadata metadata, PathInits inits) {
        this(Plane.class, metadata, inits);
    }

    public QPlane(Class<? extends Plane> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.contract = inits.isInitialized("contract") ? new com.haut.grm.model.business.QContract(forProperty("contract"), inits.get("contract")) : null;
        this.grain_type = inits.isInitialized("grain_type") ? new com.haut.grm.model.type.QGrainType(forProperty("grain_type")) : null;
        this.grain_variety = inits.isInitialized("grain_variety") ? new com.haut.grm.model.standard.code.QGrainVariety(forProperty("grain_variety")) : null;
        this.input_user = inits.isInitialized("input_user") ? new com.haut.grm.model.meta.QUser(forProperty("input_user"), inits.get("input_user")) : null;
        this.plane_bzdw = inits.isInitialized("plane_bzdw") ? new com.haut.grm.model.type.QPlaneDwType(forProperty("plane_bzdw")) : null;
        this.plane_gldw = inits.isInitialized("plane_gldw") ? new com.haut.grm.model.type.QPlaneDwType(forProperty("plane_gldw")) : null;
        this.plane_type = inits.isInitialized("plane_type") ? new com.haut.grm.model.type.QPlanType(forProperty("plane_type")) : null;
        this.plane_zxdw = inits.isInitialized("plane_zxdw") ? new com.haut.grm.model.type.QPlaneDwType(forProperty("plane_zxdw")) : null;
        this.process = inits.isInitialized("process") ? new com.haut.grm.model.type.QPlaneProcessType(forProperty("process")) : null;
    }

}

