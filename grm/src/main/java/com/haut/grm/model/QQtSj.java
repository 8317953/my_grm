package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQtSj is a Querydsl query type for QtSj
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQtSj extends EntityPathBase<QtSj> {

    private static final long serialVersionUID = -603151468L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQtSj qtSj = new QQtSj("qtSj");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final StringPath co1 = createString("co1");

    public final StringPath co2 = createString("co2");

    public final StringPath code = createString("code");

    public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);

    public final DateTimePath<java.util.Date> gettime = createDateTime("gettime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.haut.grm.model.meta.QUser inputer;

    public final DateTimePath<java.util.Date> inputtime = createDateTime("inputtime", java.util.Date.class);

    public final StringPath n2 = createString("n2");

    public final StringPath no1 = createString("no1");

    public final StringPath o2 = createString("o2");

    public final StringPath ph3 = createString("ph3");

    public final StringPath so2f2 = createString("so2f2");

    public QQtSj(String variable) {
        this(QtSj.class, forVariable(variable), INITS);
    }

    public QQtSj(Path<? extends QtSj> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQtSj(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQtSj(PathMetadata metadata, PathInits inits) {
        this(QtSj.class, metadata, inits);
    }

    public QQtSj(Class<? extends QtSj> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inputer = inits.isInitialized("inputer") ? new com.haut.grm.model.meta.QUser(forProperty("inputer"), inits.get("inputer")) : null;
    }

}

