package com.haut.grm.model.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlaneDwType is a Querydsl query type for PlaneDwType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlaneDwType extends EntityPathBase<PlaneDwType> {

    private static final long serialVersionUID = 593331119L;

    public static final QPlaneDwType planeDwType = new QPlaneDwType("planeDwType");

    public final com.haut.grm.model.base.QAbstractType _super = new com.haut.grm.model.base.QAbstractType(this);

    //inherited
    public final NumberPath<Integer> codeId = _super.codeId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public QPlaneDwType(String variable) {
        super(PlaneDwType.class, forVariable(variable));
    }

    public QPlaneDwType(Path<? extends PlaneDwType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlaneDwType(PathMetadata metadata) {
        super(PlaneDwType.class, metadata);
    }

}

