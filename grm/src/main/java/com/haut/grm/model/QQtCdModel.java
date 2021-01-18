package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQtCdModel is a Querydsl query type for QtCdModel
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQtCdModel extends EntityPathBase<QtCdModel> {

    private static final long serialVersionUID = -1715553237L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQtCdModel qtCdModel = new QQtCdModel("qtCdModel");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final StringPath code = createString("code");

    public final NumberPath<Integer> codeid = createNumber("codeid", Integer.class);

    public final QQtFm fm1;

    public final QQtFm fm10;

    public final QQtFm fm2;

    public final QQtFm fm3;

    public final QQtFm fm4;

    public final QQtFm fm5;

    public final QQtFm fm6;

    public final QQtFm fm7;

    public final QQtFm fm8;

    public final QQtFm fm9;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.haut.grm.model.type.QQtCdType qtcdtype;

    public final QStore store;

    public QQtCdModel(String variable) {
        this(QtCdModel.class, forVariable(variable), INITS);
    }

    public QQtCdModel(Path<? extends QtCdModel> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQtCdModel(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQtCdModel(PathMetadata metadata, PathInits inits) {
        this(QtCdModel.class, metadata, inits);
    }

    public QQtCdModel(Class<? extends QtCdModel> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.fm1 = inits.isInitialized("fm1") ? new QQtFm(forProperty("fm1"), inits.get("fm1")) : null;
        this.fm10 = inits.isInitialized("fm10") ? new QQtFm(forProperty("fm10"), inits.get("fm10")) : null;
        this.fm2 = inits.isInitialized("fm2") ? new QQtFm(forProperty("fm2"), inits.get("fm2")) : null;
        this.fm3 = inits.isInitialized("fm3") ? new QQtFm(forProperty("fm3"), inits.get("fm3")) : null;
        this.fm4 = inits.isInitialized("fm4") ? new QQtFm(forProperty("fm4"), inits.get("fm4")) : null;
        this.fm5 = inits.isInitialized("fm5") ? new QQtFm(forProperty("fm5"), inits.get("fm5")) : null;
        this.fm6 = inits.isInitialized("fm6") ? new QQtFm(forProperty("fm6"), inits.get("fm6")) : null;
        this.fm7 = inits.isInitialized("fm7") ? new QQtFm(forProperty("fm7"), inits.get("fm7")) : null;
        this.fm8 = inits.isInitialized("fm8") ? new QQtFm(forProperty("fm8"), inits.get("fm8")) : null;
        this.fm9 = inits.isInitialized("fm9") ? new QQtFm(forProperty("fm9"), inits.get("fm9")) : null;
        this.qtcdtype = inits.isInitialized("qtcdtype") ? new com.haut.grm.model.type.QQtCdType(forProperty("qtcdtype")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

