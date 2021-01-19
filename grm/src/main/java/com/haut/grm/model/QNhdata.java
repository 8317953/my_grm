package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNhdata is a Querydsl query type for Nhdata
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNhdata extends EntityPathBase<Nhdata> {

    private static final long serialVersionUID = 95555998L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNhdata nhdata = new QNhdata("nhdata");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final StringPath code = createString("code");

    public final NumberPath<Integer> codeid = createNumber("codeid", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.haut.grm.model.type.QNhtype nhtypeid;

    public final NumberPath<Double> pow = createNumber("pow", Double.class);

    public QNhdata(String variable) {
        this(Nhdata.class, forVariable(variable), INITS);
    }

    public QNhdata(Path<? extends Nhdata> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNhdata(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNhdata(PathMetadata metadata, PathInits inits) {
        this(Nhdata.class, metadata, inits);
    }

    public QNhdata(Class<? extends Nhdata> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nhtypeid = inits.isInitialized("nhtypeid") ? new com.haut.grm.model.type.QNhtype(forProperty("nhtypeid")) : null;
    }

}

