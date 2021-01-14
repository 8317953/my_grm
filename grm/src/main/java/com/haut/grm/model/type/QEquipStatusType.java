package com.haut.grm.model.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEquipStatusType is a Querydsl query type for EquipStatusType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEquipStatusType extends EntityPathBase<EquipStatusType> {

    private static final long serialVersionUID = -1242864798L;

    public static final QEquipStatusType equipStatusType = new QEquipStatusType("equipStatusType");

    public final com.haut.grm.model.base.QAbstractType _super = new com.haut.grm.model.base.QAbstractType(this);

    //inherited
    public final NumberPath<Integer> codeId = _super.codeId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public QEquipStatusType(String variable) {
        super(EquipStatusType.class, forVariable(variable));
    }

    public QEquipStatusType(Path<? extends EquipStatusType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEquipStatusType(PathMetadata metadata) {
        super(EquipStatusType.class, metadata);
    }

}

