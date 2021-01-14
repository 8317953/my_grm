package com.haut.grm.model.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSdTfMdType is a Querydsl query type for SdTfMdType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSdTfMdType extends EntityPathBase<SdTfMdType> {

    private static final long serialVersionUID = 376891246L;

    public static final QSdTfMdType sdTfMdType = new QSdTfMdType("sdTfMdType");

    public final com.haut.grm.model.base.QAbstractType _super = new com.haut.grm.model.base.QAbstractType(this);

    //inherited
    public final NumberPath<Integer> codeId = _super.codeId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public QSdTfMdType(String variable) {
        super(SdTfMdType.class, forVariable(variable));
    }

    public QSdTfMdType(Path<? extends SdTfMdType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSdTfMdType(PathMetadata metadata) {
        super(SdTfMdType.class, metadata);
    }

}

