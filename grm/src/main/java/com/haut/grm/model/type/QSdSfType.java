package com.haut.grm.model.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSdSfType is a Querydsl query type for SdSfType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSdSfType extends EntityPathBase<SdSfType> {

    private static final long serialVersionUID = 1500482520L;

    public static final QSdSfType sdSfType = new QSdSfType("sdSfType");

    public final com.haut.grm.model.base.QAbstractType _super = new com.haut.grm.model.base.QAbstractType(this);

    //inherited
    public final NumberPath<Integer> codeId = _super.codeId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public QSdSfType(String variable) {
        super(SdSfType.class, forVariable(variable));
    }

    public QSdSfType(Path<? extends SdSfType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSdSfType(PathMetadata metadata) {
        super(SdSfType.class, metadata);
    }

}

