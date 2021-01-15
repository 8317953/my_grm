package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCargo is a Querydsl query type for Cargo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCargo extends EntityPathBase<Cargo> {

    private static final long serialVersionUID = -1531291838L;

    private static final PathInits INITS = new PathInits("*", "compartment.store.depot.*");

    public static final QCargo cargo = new QCargo("cargo");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final DatePath<java.util.Date> activeDate = createDate("activeDate", java.util.Date.class);

    public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);

    public final QCompartment compartment;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final com.haut.grm.model.type.QPackageCategory packageCategory;

    public final com.haut.grm.model.type.QPackageType packageType;

    public final com.haut.grm.model.type.QCargoStatus status;

    public final NumberPath<Double> volume = createNumber("volume", Double.class);

    public QCargo(String variable) {
        this(Cargo.class, forVariable(variable), INITS);
    }

    public QCargo(Path<? extends Cargo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCargo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCargo(PathMetadata metadata, PathInits inits) {
        this(Cargo.class, metadata, inits);
    }

    public QCargo(Class<? extends Cargo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.compartment = inits.isInitialized("compartment") ? new QCompartment(forProperty("compartment"), inits.get("compartment")) : null;
        this.packageCategory = inits.isInitialized("packageCategory") ? new com.haut.grm.model.type.QPackageCategory(forProperty("packageCategory")) : null;
        this.packageType = inits.isInitialized("packageType") ? new com.haut.grm.model.type.QPackageType(forProperty("packageType")) : null;
        this.status = inits.isInitialized("status") ? new com.haut.grm.model.type.QCargoStatus(forProperty("status")) : null;
    }

}

