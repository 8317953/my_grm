package com.haut.grm.model.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQtCdType is a Querydsl query type for QtCdType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQtCdType extends EntityPathBase<QtCdType> {

    private static final long serialVersionUID = -1129894600L;

    public static final QQtCdType qtCdType = new QQtCdType("qtCdType");

    public final com.haut.grm.model.base.QAbstractType _super = new com.haut.grm.model.base.QAbstractType(this);

    //inherited
    public final NumberPath<Integer> codeId = _super.codeId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public QQtCdType(String variable) {
        super(QtCdType.class, forVariable(variable));
    }

    public QQtCdType(Path<? extends QtCdType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQtCdType(PathMetadata metadata) {
        super(QtCdType.class, metadata);
    }

}

