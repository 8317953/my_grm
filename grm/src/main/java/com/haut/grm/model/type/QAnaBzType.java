package com.haut.grm.model.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAnaBzType is a Querydsl query type for AnaBzType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAnaBzType extends EntityPathBase<AnaBzType> {

    private static final long serialVersionUID = 531462124L;

    public static final QAnaBzType anaBzType = new QAnaBzType("anaBzType");

    public final com.haut.grm.model.base.QAbstractType _super = new com.haut.grm.model.base.QAbstractType(this);

    //inherited
    public final NumberPath<Integer> codeId = _super.codeId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public QAnaBzType(String variable) {
        super(AnaBzType.class, forVariable(variable));
    }

    public QAnaBzType(Path<? extends AnaBzType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAnaBzType(PathMetadata metadata) {
        super(AnaBzType.class, metadata);
    }

}

