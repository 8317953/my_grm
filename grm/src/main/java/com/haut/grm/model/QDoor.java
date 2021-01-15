package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDoor is a Querydsl query type for Door
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDoor extends EntityPathBase<Door> {

    private static final long serialVersionUID = -603542680L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDoor door = new QDoor("door");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final BooleanPath occupied = createBoolean("occupied");

    public final com.haut.grm.model.type.QDoorState state;

    public final QStore store;

    public QDoor(String variable) {
        this(Door.class, forVariable(variable), INITS);
    }

    public QDoor(Path<? extends Door> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDoor(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDoor(PathMetadata metadata, PathInits inits) {
        this(Door.class, metadata, inits);
    }

    public QDoor(Class<? extends Door> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.state = inits.isInitialized("state") ? new com.haut.grm.model.type.QDoorState(forProperty("state")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

