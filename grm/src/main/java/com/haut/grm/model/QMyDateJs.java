package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyDateJs is a Querydsl query type for MyDateJs
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyDateJs extends EntityPathBase<MyDateJs> {

    private static final long serialVersionUID = 1178724637L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyDateJs myDateJs = new QMyDateJs("myDateJs");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final DateTimePath<java.util.Date> formatouttime = createDateTime("formatouttime", java.util.Date.class);

    public final StringPath id = createString("id");

    public final NumberPath<Integer> inamount = createNumber("inamount", Integer.class);

    public final NumberPath<Integer> jsamount = createNumber("jsamount", Integer.class);

    public final NumberPath<Integer> outamount = createNumber("outamount", Integer.class);

    public final com.haut.grm.model.business.QStockId stock;

    public QMyDateJs(String variable) {
        this(MyDateJs.class, forVariable(variable), INITS);
    }

    public QMyDateJs(Path<? extends MyDateJs> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyDateJs(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyDateJs(PathMetadata metadata, PathInits inits) {
        this(MyDateJs.class, metadata, inits);
    }

    public QMyDateJs(Class<? extends MyDateJs> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.stock = inits.isInitialized("stock") ? new com.haut.grm.model.business.QStockId(forProperty("stock"), inits.get("stock")) : null;
    }

}

