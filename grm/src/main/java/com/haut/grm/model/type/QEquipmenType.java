package com.haut.grm.model.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEquipmenType is a Querydsl query type for EquipmenType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEquipmenType extends EntityPathBase<EquipmenType> {

    private static final long serialVersionUID = -557718278L;

    public static final QEquipmenType equipmenType = new QEquipmenType("equipmenType");

    public final com.haut.grm.model.base.QAbstractType _super = new com.haut.grm.model.base.QAbstractType(this);

    //inherited
    public final NumberPath<Integer> codeId = _super.codeId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public QEquipmenType(String variable) {
        super(EquipmenType.class, forVariable(variable));
    }

    public QEquipmenType(Path<? extends EquipmenType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEquipmenType(PathMetadata metadata) {
        super(EquipmenType.class, metadata);
    }

}

