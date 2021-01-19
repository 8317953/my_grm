package com.haut.grm.model.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QNhtype is a Querydsl query type for Nhtype
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNhtype extends EntityPathBase<Nhtype> {

    private static final long serialVersionUID = 497748078L;

    public static final QNhtype nhtype = new QNhtype("nhtype");

    public final com.haut.grm.model.base.QAbstractType _super = new com.haut.grm.model.base.QAbstractType(this);

    //inherited
    public final NumberPath<Integer> codeId = _super.codeId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public QNhtype(String variable) {
        super(Nhtype.class, forVariable(variable));
    }

    public QNhtype(Path<? extends Nhtype> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNhtype(PathMetadata metadata) {
        super(Nhtype.class, metadata);
    }

}

