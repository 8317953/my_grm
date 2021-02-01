package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQtfmmodel is a Querydsl query type for Qtfmmodel
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQtfmmodel extends EntityPathBase<Qtfmmodel> {

    private static final long serialVersionUID = -430480443L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQtfmmodel qtfmmodel = new QQtfmmodel("qtfmmodel");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final QQtFm cdfmid;

    public final QQtCdModel cdmodelid;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QQtfmmodel(String variable) {
        this(Qtfmmodel.class, forVariable(variable), INITS);
    }

    public QQtfmmodel(Path<? extends Qtfmmodel> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQtfmmodel(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQtfmmodel(PathMetadata metadata, PathInits inits) {
        this(Qtfmmodel.class, metadata, inits);
    }

    public QQtfmmodel(Class<? extends Qtfmmodel> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cdfmid = inits.isInitialized("cdfmid") ? new QQtFm(forProperty("cdfmid"), inits.get("cdfmid")) : null;
        this.cdmodelid = inits.isInitialized("cdmodelid") ? new QQtCdModel(forProperty("cdmodelid"), inits.get("cdmodelid")) : null;
    }

}

