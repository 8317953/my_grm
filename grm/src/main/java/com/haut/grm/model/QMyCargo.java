package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMyCargo is a Querydsl query type for MyCargo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyCargo extends EntityPathBase<MyCargo> {

    private static final long serialVersionUID = -1764017290L;

    public static final QMyCargo myCargo = new QMyCargo("myCargo");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final DateTimePath<java.util.Date> activedate = createDateTime("activedate", java.util.Date.class);

    public final StringPath cargoname = createString("cargoname");

    public final NumberPath<Integer> codeid = createNumber("codeid", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> packagecategoryid = createNumber("packagecategoryid", Integer.class);

    public final NumberPath<Integer> packagetypeid = createNumber("packagetypeid", Integer.class);

    public final NumberPath<Integer> volume = createNumber("volume", Integer.class);

    public QMyCargo(String variable) {
        super(MyCargo.class, forVariable(variable));
    }

    public QMyCargo(Path<? extends MyCargo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMyCargo(PathMetadata metadata) {
        super(MyCargo.class, metadata);
    }

}

