package com.haut.grm.model.wenzhou;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOutInLetter is a Querydsl query type for OutInLetter
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOutInLetter extends EntityPathBase<OutInLetter> {

    private static final long serialVersionUID = 1840156197L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOutInLetter outInLetter = new QOutInLetter("outInLetter");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final com.haut.grm.model.business.QClient client;

    public final StringPath code = createString("code");

    public final StringPath code_id = createString("code_id");

    public final com.haut.grm.model.business.QContract contrat;

    public final DateTimePath<java.util.Date> create_time = createDateTime("create_time", java.util.Date.class);

    public final com.haut.grm.model.meta.QUser createby;

    public final NumberPath<Double> dkzj = createNumber("dkzj", Double.class);

    public final com.haut.grm.model.standard.code.QGrainVariety gv;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.haut.grm.model.type.QPlaneDwType kddw;

    public final DateTimePath<java.util.Date> kdrq = createDateTime("kdrq", java.util.Date.class);

    public final DateTimePath<java.util.Date> last_date = createDateTime("last_date", java.util.Date.class);

    public final com.haut.grm.model.type.QOutInType lettertype;

    public final StringPath name = createString("name");

    public final NumberPath<Double> perprice = createNumber("perprice", Double.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final com.haut.grm.model.QStore store;

    public final NumberPath<Double> stsl = createNumber("stsl", Double.class);

    public final NumberPath<Double> sysl = createNumber("sysl", Double.class);

    public final NumberPath<Double> thsl = createNumber("thsl", Double.class);

    public QOutInLetter(String variable) {
        this(OutInLetter.class, forVariable(variable), INITS);
    }

    public QOutInLetter(Path<? extends OutInLetter> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOutInLetter(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOutInLetter(PathMetadata metadata, PathInits inits) {
        this(OutInLetter.class, metadata, inits);
    }

    public QOutInLetter(Class<? extends OutInLetter> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.client = inits.isInitialized("client") ? new com.haut.grm.model.business.QClient(forProperty("client")) : null;
        this.contrat = inits.isInitialized("contrat") ? new com.haut.grm.model.business.QContract(forProperty("contrat"), inits.get("contrat")) : null;
        this.createby = inits.isInitialized("createby") ? new com.haut.grm.model.meta.QUser(forProperty("createby"), inits.get("createby")) : null;
        this.gv = inits.isInitialized("gv") ? new com.haut.grm.model.standard.code.QGrainVariety(forProperty("gv")) : null;
        this.kddw = inits.isInitialized("kddw") ? new com.haut.grm.model.type.QPlaneDwType(forProperty("kddw")) : null;
        this.lettertype = inits.isInitialized("lettertype") ? new com.haut.grm.model.type.QOutInType(forProperty("lettertype")) : null;
        this.store = inits.isInitialized("store") ? new com.haut.grm.model.QStore(forProperty("store"), inits.get("store")) : null;
    }

}

