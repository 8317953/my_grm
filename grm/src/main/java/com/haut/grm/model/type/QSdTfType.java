package com.haut.grm.model.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSdTfType is a Querydsl query type for SdTfType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSdTfType extends EntityPathBase<SdTfType> {

    private static final long serialVersionUID = 1529111671L;

    public static final QSdTfType sdTfType = new QSdTfType("sdTfType");

    public final com.haut.grm.model.base.QAbstractType _super = new com.haut.grm.model.base.QAbstractType(this);

    //inherited
    public final NumberPath<Integer> codeId = _super.codeId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public QSdTfType(String variable) {
        super(SdTfType.class, forVariable(variable));
    }

    public QSdTfType(Path<? extends SdTfType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSdTfType(PathMetadata metadata) {
        super(SdTfType.class, metadata);
    }

}

