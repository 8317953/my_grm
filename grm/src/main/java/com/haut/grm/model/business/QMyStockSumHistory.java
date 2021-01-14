package com.haut.grm.model.business;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyStockSumHistory is a Querydsl query type for MyStockSumHistory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyStockSumHistory extends EntityPathBase<MyStockSumHistory> {

    private static final long serialVersionUID = -1352407681L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyStockSumHistory myStockSumHistory = new QMyStockSumHistory("myStockSumHistory");

    public final com.haut.grm.model.base.QAbstractBusiness _super;

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    //inherited
    public final StringPath auditComment;

    // inherited
    public final com.haut.grm.model.meta.QUser auditor;

    //inherited
    public final DateTimePath<java.util.Date> auditTime;

    //inherited
    public final StringPath businessKey;

    public final com.haut.grm.model.QCargoRepView cargo;

    public final com.haut.grm.model.type.QGrainType gt;

    public final com.haut.grm.model.standard.code.QGrainVariety gv;

    //inherited
    public final NumberPath<Long> id;

    public final NumberPath<Long> inamount = createNumber("inamount", Long.class);

    //inherited
    public final StringPath inputComment;

    // inherited
    public final com.haut.grm.model.meta.QUser inputer;

    //inherited
    public final DateTimePath<java.util.Date> inputTime;

    public final StringPath location = createString("location");

    public final NumberPath<Long> outamount = createNumber("outamount", Long.class);

    public final StringPath year = createString("year");

    public QMyStockSumHistory(String variable) {
        this(MyStockSumHistory.class, forVariable(variable), INITS);
    }

    public QMyStockSumHistory(Path<? extends MyStockSumHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyStockSumHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyStockSumHistory(PathMetadata metadata, PathInits inits) {
        this(MyStockSumHistory.class, metadata, inits);
    }

    public QMyStockSumHistory(Class<? extends MyStockSumHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.haut.grm.model.base.QAbstractBusiness(type, metadata, inits);
        this.auditComment = _super.auditComment;
        this.auditor = _super.auditor;
        this.auditTime = _super.auditTime;
        this.businessKey = _super.businessKey;
        this.cargo = inits.isInitialized("cargo") ? new com.haut.grm.model.QCargoRepView(forProperty("cargo"), inits.get("cargo")) : null;
        this.gt = inits.isInitialized("gt") ? new com.haut.grm.model.type.QGrainType(forProperty("gt")) : null;
        this.gv = inits.isInitialized("gv") ? new com.haut.grm.model.standard.code.QGrainVariety(forProperty("gv")) : null;
        this.id = _super.id;
        this.inputComment = _super.inputComment;
        this.inputer = _super.inputer;
        this.inputTime = _super.inputTime;
    }

}

