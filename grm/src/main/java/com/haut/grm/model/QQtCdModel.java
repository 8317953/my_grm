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

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.haut.grm.model.type.QQtCdType qtcdtype;

    public final SetPath<Qtfmmodel, QQtfmmodel> qtfmmodels = this.<Qtfmmodel, QQtfmmodel>createSet("qtfmmodels", Qtfmmodel.class, QQtfmmodel.class, PathInits.DIRECT2);

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
        this.qtcdtype = inits.isInitialized("qtcdtype") ? new com.haut.grm.model.type.QQtCdType(forProperty("qtcdtype")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

