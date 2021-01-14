package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnaMoban is a Querydsl query type for AnaMoban
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAnaMoban extends EntityPathBase<AnaMoban> {

    private static final long serialVersionUID = 1378855027L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnaMoban anaMoban = new QAnaMoban("anaMoban");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final StringPath a1 = createString("a1");

    public final StringPath a10 = createString("a10");

    public final StringPath a11 = createString("a11");

    public final StringPath a12 = createString("a12");

    public final StringPath a13 = createString("a13");

    public final StringPath a14 = createString("a14");

    public final StringPath a15 = createString("a15");

    public final StringPath a16 = createString("a16");

    public final StringPath a17 = createString("a17");

    public final StringPath a18 = createString("a18");

    public final StringPath a19 = createString("a19");

    public final StringPath a2 = createString("a2");

    public final StringPath a20 = createString("a20");

    public final StringPath a21 = createString("a21");

    public final StringPath a22 = createString("a22");

    public final StringPath a23 = createString("a23");

    public final StringPath a24 = createString("a24");

    public final StringPath a25 = createString("a25");

    public final StringPath a26 = createString("a26");

    public final StringPath a27 = createString("a27");

    public final StringPath a28 = createString("a28");

    public final StringPath a29 = createString("a29");

    public final StringPath a3 = createString("a3");

    public final StringPath a30 = createString("a30");

    public final StringPath a31 = createString("a31");

    public final StringPath a32 = createString("a32");

    public final StringPath a33 = createString("a33");

    public final StringPath a34 = createString("a34");

    public final StringPath a35 = createString("a35");

    public final StringPath a36 = createString("a36");

    public final StringPath a37 = createString("a37");

    public final StringPath a38 = createString("a38");

    public final StringPath a39 = createString("a39");

    public final StringPath a4 = createString("a4");

    public final StringPath a40 = createString("a40");

    public final StringPath a5 = createString("a5");

    public final StringPath a6 = createString("a6");

    public final StringPath a7 = createString("a7");

    public final StringPath a8 = createString("a8");

    public final StringPath a9 = createString("a9");

    public final com.haut.grm.model.standard.code.QGrainVariety gv;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public QAnaMoban(String variable) {
        this(AnaMoban.class, forVariable(variable), INITS);
    }

    public QAnaMoban(Path<? extends AnaMoban> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnaMoban(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnaMoban(PathMetadata metadata, PathInits inits) {
        this(AnaMoban.class, metadata, inits);
    }

    public QAnaMoban(Class<? extends AnaMoban> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gv = inits.isInitialized("gv") ? new com.haut.grm.model.standard.code.QGrainVariety(forProperty("gv")) : null;
    }

}

