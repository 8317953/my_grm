package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQtFm is a Querydsl query type for QtFm
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQtFm extends EntityPathBase<QtFm> {

    private static final long serialVersionUID = -603151868L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQtFm qtFm = new QQtFm("qtFm");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final StringPath code = createString("code");

    public final NumberPath<Integer> codeid = createNumber("codeid", Integer.class);

    public final StringPath com = createString("com");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath ip = createString("ip");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> port = createNumber("port", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final QStore store;

    public QQtFm(String variable) {
        this(QtFm.class, forVariable(variable), INITS);
    }

    public QQtFm(Path<? extends QtFm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQtFm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQtFm(PathMetadata metadata, PathInits inits) {
        this(QtFm.class, metadata, inits);
    }

    public QQtFm(Class<? extends QtFm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

