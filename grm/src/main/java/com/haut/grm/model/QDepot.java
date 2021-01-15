package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDepot is a Querydsl query type for Depot
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDepot extends EntityPathBase<Depot> {

    private static final long serialVersionUID = -1530250822L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDepot depot = new QDepot("depot");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final StringPath abbrev = createString("abbrev");

    public final NumberPath<Long> activeCapacity = createNumber("activeCapacity", Long.class);

    public final NumberPath<Long> activeOilCapacity = createNumber("activeOilCapacity", Long.class);

    public final StringPath address = createString("address");

    public final DatePath<java.util.Date> builtDate = createDate("builtDate", java.util.Date.class);

    public final NumberPath<Long> capacity = createNumber("capacity", Long.class);

    public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);

    public final StringPath companyCode = createString("companyCode");

    public final StringPath companyName = createString("companyName");

    public final StringPath companyShortCode = createString("companyShortCode");

    public final com.haut.grm.model.type.QDepotCategory depotCategory;

    public final com.haut.grm.model.type.QCompanyType depotType;

    public final StringPath fax = createString("fax");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isOwn = createBoolean("isOwn");

    public final StringPath keyword = createString("keyword");

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final com.haut.grm.model.standard.code.QLocation location;

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath managerName = createString("managerName");

    public final StringPath name = createString("name");

    public final NumberPath<Long> oilCapacity = createNumber("oilCapacity", Long.class);

    public final NumberPath<Integer> roadDistance = createNumber("roadDistance", Integer.class);

    public final com.haut.grm.model.type.QRoadType roadType;

    public final NumberPath<Double> space = createNumber("space", Double.class);

    public final StringPath telephone = createString("telephone");

    public final StringPath type = createString("type");

    public final StringPath zipCode = createString("zipCode");

    public QDepot(String variable) {
        this(Depot.class, forVariable(variable), INITS);
    }

    public QDepot(Path<? extends Depot> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDepot(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDepot(PathMetadata metadata, PathInits inits) {
        this(Depot.class, metadata, inits);
    }

    public QDepot(Class<? extends Depot> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.depotCategory = inits.isInitialized("depotCategory") ? new com.haut.grm.model.type.QDepotCategory(forProperty("depotCategory")) : null;
        this.depotType = inits.isInitialized("depotType") ? new com.haut.grm.model.type.QCompanyType(forProperty("depotType")) : null;
        this.location = inits.isInitialized("location") ? new com.haut.grm.model.standard.code.QLocation(forProperty("location")) : null;
        this.roadType = inits.isInitialized("roadType") ? new com.haut.grm.model.type.QRoadType(forProperty("roadType")) : null;
    }

}

