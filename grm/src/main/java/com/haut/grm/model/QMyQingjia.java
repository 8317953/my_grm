package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyQingjia is a Querydsl query type for MyQingjia
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyQingjia extends EntityPathBase<MyQingjia> {

    private static final long serialVersionUID = 1056953547L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyQingjia myQingjia = new QMyQingjia("myQingjia");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final StringPath bumen = createString("bumen");

    public final StringPath cijibeizhu = createString("cijibeizhu");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> starttime = createDateTime("starttime", java.util.Date.class);

    public final com.haut.grm.model.meta.QUser startuser;

    public final NumberPath<Integer> tianshu = createNumber("tianshu", Integer.class);

    public final StringPath yuanyin = createString("yuanyin");

    public final StringPath zongjinglibeizhu = createString("zongjinglibeizhu");

    public QMyQingjia(String variable) {
        this(MyQingjia.class, forVariable(variable), INITS);
    }

    public QMyQingjia(Path<? extends MyQingjia> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyQingjia(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyQingjia(PathMetadata metadata, PathInits inits) {
        this(MyQingjia.class, metadata, inits);
    }

    public QMyQingjia(Class<? extends MyQingjia> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.startuser = inits.isInitialized("startuser") ? new com.haut.grm.model.meta.QUser(forProperty("startuser"), inits.get("startuser")) : null;
    }

}

