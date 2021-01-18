package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQtcdjl is a Querydsl query type for Qtcdjl
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQtcdjl extends EntityPathBase<Qtcdjl> {

    private static final long serialVersionUID = 192498496L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQtcdjl qtcdjl = new QQtcdjl("qtcdjl");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final com.haut.grm.model.meta.QUser acterid;

    public final QQtCdModel cdmodelid;

    public final StringPath code = createString("code");

    public final NumberPath<Integer> codeid = createNumber("codeid", Integer.class);

    public final NumberPath<Double> endamount = createNumber("endamount", Double.class);

    public final DateTimePath<java.util.Date> enddate = createDateTime("enddate", java.util.Date.class);

    public final NumberPath<Double> endnongdu = createNumber("endnongdu", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.haut.grm.model.meta.QUser inputerid;

    public final DateTimePath<java.util.Date> inputtime = createDateTime("inputtime", java.util.Date.class);

    public final com.haut.grm.model.meta.QUser managerid;

    public final DateTimePath<java.util.Date> startdate = createDateTime("startdate", java.util.Date.class);

    public final QStore storeid;

    public final NumberPath<Double> yusheamount = createNumber("yusheamount", Double.class);

    public final NumberPath<Double> yushenongdu = createNumber("yushenongdu", Double.class);

    public QQtcdjl(String variable) {
        this(Qtcdjl.class, forVariable(variable), INITS);
    }

    public QQtcdjl(Path<? extends Qtcdjl> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQtcdjl(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQtcdjl(PathMetadata metadata, PathInits inits) {
        this(Qtcdjl.class, metadata, inits);
    }

    public QQtcdjl(Class<? extends Qtcdjl> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.acterid = inits.isInitialized("acterid") ? new com.haut.grm.model.meta.QUser(forProperty("acterid"), inits.get("acterid")) : null;
        this.cdmodelid = inits.isInitialized("cdmodelid") ? new QQtCdModel(forProperty("cdmodelid"), inits.get("cdmodelid")) : null;
        this.inputerid = inits.isInitialized("inputerid") ? new com.haut.grm.model.meta.QUser(forProperty("inputerid"), inits.get("inputerid")) : null;
        this.managerid = inits.isInitialized("managerid") ? new com.haut.grm.model.meta.QUser(forProperty("managerid"), inits.get("managerid")) : null;
        this.storeid = inits.isInitialized("storeid") ? new QStore(forProperty("storeid"), inits.get("storeid")) : null;
    }

}

