package com.haut.grm.model.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOutInType is a Querydsl query type for OutInType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOutInType extends EntityPathBase<OutInType> {

    private static final long serialVersionUID = 183696435L;

    public static final QOutInType outInType = new QOutInType("outInType");

    public final com.haut.grm.model.base.QAbstractType _super = new com.haut.grm.model.base.QAbstractType(this);

    //inherited
    public final NumberPath<Integer> codeId = _super.codeId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public QOutInType(String variable) {
        super(OutInType.class, forVariable(variable));
    }

    public QOutInType(Path<? extends OutInType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOutInType(PathMetadata metadata) {
        super(OutInType.class, metadata);
    }

}

