package com.haut.grm.model.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlaneProcessType is a Querydsl query type for PlaneProcessType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlaneProcessType extends EntityPathBase<PlaneProcessType> {

    private static final long serialVersionUID = -404793785L;

    public static final QPlaneProcessType planeProcessType = new QPlaneProcessType("planeProcessType");

    public final com.haut.grm.model.base.QAbstractType _super = new com.haut.grm.model.base.QAbstractType(this);

    //inherited
    public final NumberPath<Integer> codeId = _super.codeId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public QPlaneProcessType(String variable) {
        super(PlaneProcessType.class, forVariable(variable));
    }

    public QPlaneProcessType(Path<? extends PlaneProcessType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlaneProcessType(PathMetadata metadata) {
        super(PlaneProcessType.class, metadata);
    }

}

