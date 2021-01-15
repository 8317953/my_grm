package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSdTfSb is a Querydsl query type for SdTfSb
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSdTfSb extends EntityPathBase<SdTfSb> {

    private static final long serialVersionUID = 234534796L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSdTfSb sdTfSb = new QSdTfSb("sdTfSb");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final NumberPath<Integer> canMove = createNumber("canMove", Integer.class);

    public final StringPath code = createString("code");

    public final NumberPath<Integer> codeid = createNumber("codeid", Integer.class);

    public final com.haut.grm.model.type.QEquipmenType equipmenttype;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.haut.grm.model.meta.QUser inputer;

    public final DateTimePath<java.util.Date> inputtime = createDateTime("inputtime", java.util.Date.class);

    public final StringPath ip = createString("ip");

    public final com.haut.grm.model.meta.QUser manager;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> port = createNumber("port", Integer.class);

    public final SetPath<SdTfEquipStatus, QSdTfEquipStatus> sdTfEquipStatuses = this.<SdTfEquipStatus, QSdTfEquipStatus>createSet("sdTfEquipStatuses", SdTfEquipStatus.class, QSdTfEquipStatus.class, PathInits.DIRECT2);

    public final QStore store;

    public QSdTfSb(String variable) {
        this(SdTfSb.class, forVariable(variable), INITS);
    }

    public QSdTfSb(Path<? extends SdTfSb> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSdTfSb(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSdTfSb(PathMetadata metadata, PathInits inits) {
        this(SdTfSb.class, metadata, inits);
    }

    public QSdTfSb(Class<? extends SdTfSb> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.equipmenttype = inits.isInitialized("equipmenttype") ? new com.haut.grm.model.type.QEquipmenType(forProperty("equipmenttype")) : null;
        this.inputer = inits.isInitialized("inputer") ? new com.haut.grm.model.meta.QUser(forProperty("inputer"), inits.get("inputer")) : null;
        this.manager = inits.isInitialized("manager") ? new com.haut.grm.model.meta.QUser(forProperty("manager"), inits.get("manager")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

