package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompartment is a Querydsl query type for Compartment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompartment extends EntityPathBase<Compartment> {

    private static final long serialVersionUID = -1797788840L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompartment compartment = new QCompartment("compartment");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final DatePath<java.util.Date> activeDate = createDate("activeDate", java.util.Date.class);

    public final StringPath actualVolume = createString("actualVolume");

    public final NumberPath<Double> breadth = createNumber("breadth", Double.class);

    public final SetPath<Cargo, QCargo> cargos = this.<Cargo, QCargo>createSet("cargos", Cargo.class, QCargo.class, PathInits.DIRECT2);

    public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);

    public final com.haut.grm.model.type.QSpaceCondition condition;

    public final StringPath designVolume = createString("designVolume");

    public final NumberPath<Double> grainHeight = createNumber("grainHeight", Double.class);

    public final NumberPath<Double> height = createNumber("height", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> length = createNumber("length", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath name = createString("name");

    public final com.haut.grm.model.type.QSpaceStatus status;

    public final QStore store;

    public QCompartment(String variable) {
        this(Compartment.class, forVariable(variable), INITS);
    }

    public QCompartment(Path<? extends Compartment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompartment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompartment(PathMetadata metadata, PathInits inits) {
        this(Compartment.class, metadata, inits);
    }

    public QCompartment(Class<? extends Compartment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.condition = inits.isInitialized("condition") ? new com.haut.grm.model.type.QSpaceCondition(forProperty("condition")) : null;
        this.status = inits.isInitialized("status") ? new com.haut.grm.model.type.QSpaceStatus(forProperty("status")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

