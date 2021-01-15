package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCargoRepView is a Querydsl query type for CargoRepView
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCargoRepView extends EntityPathBase<CargoRepView> {

    private static final long serialVersionUID = 1757332288L;

    private static final PathInits INITS = new PathInits("*", "compartment.store.depot.*");

    public static final QCargoRepView cargoRepView = new QCargoRepView("cargoRepView");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final StringPath code = createString("code");

    public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);

    public final QCompartment compartment;

    public final StringPath depotAbbrev = createString("depotAbbrev");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath readableName = createString("readableName");

    public final StringPath shortName = createString("shortName");

    public final NumberPath<Long> statusId = createNumber("statusId", Long.class);

    public final StringPath statusName = createString("statusName");

    public final StringPath storeName = createString("storeName");

    public QCargoRepView(String variable) {
        this(CargoRepView.class, forVariable(variable), INITS);
    }

    public QCargoRepView(Path<? extends CargoRepView> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCargoRepView(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCargoRepView(PathMetadata metadata, PathInits inits) {
        this(CargoRepView.class, metadata, inits);
    }

    public QCargoRepView(Class<? extends CargoRepView> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.compartment = inits.isInitialized("compartment") ? new QCompartment(forProperty("compartment"), inits.get("compartment")) : null;
    }

}

