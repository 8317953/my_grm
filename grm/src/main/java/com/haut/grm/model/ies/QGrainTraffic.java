package com.haut.grm.model.ies;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGrainTraffic is a Querydsl query type for GrainTraffic
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGrainTraffic extends EntityPathBase<GrainTraffic> {

    private static final long serialVersionUID = 1210254195L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGrainTraffic grainTraffic = new QGrainTraffic("grainTraffic");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final NumberPath<Integer> allowStage = createNumber("allowStage", Integer.class);

    public final QAnalysis analysis;

    public final QBalanceSheet balanceSheet;

    public final StringPath code = createString("code");

    public final com.haut.grm.model.business.QContract contract;

    public final BooleanPath hasSecond = createBoolean("hasSecond");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isFinished = createBoolean("isFinished");

    public final BooleanPath isIngress = createBoolean("isIngress");

    public final DateTimePath<java.util.Date> outTime = createDateTime("outTime", java.util.Date.class);

    public final QRegisterRecord registerRecord;

    public final com.haut.grm.model.business.QContract secondContract;

    public final com.haut.grm.model.business.QStockId secondstock;

    public final com.haut.grm.model.business.QStockChange secondstockchange;

    public final QWeightSheet secondWeightSheet;

    public final com.haut.grm.model.meta.QStage stage;

    public final com.haut.grm.model.business.QStockId stock;

    public final com.haut.grm.model.business.QStockChange stockchange;

    public final DateTimePath<java.util.Date> time = createDateTime("time", java.util.Date.class);

    public final QWeightSheet weightSheet;

    public final NumberPath<Double> yuliuamount1 = createNumber("yuliuamount1", Double.class);

    public final NumberPath<Double> yuliuamount2 = createNumber("yuliuamount2", Double.class);

    public QGrainTraffic(String variable) {
        this(GrainTraffic.class, forVariable(variable), INITS);
    }

    public QGrainTraffic(Path<? extends GrainTraffic> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGrainTraffic(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGrainTraffic(PathMetadata metadata, PathInits inits) {
        this(GrainTraffic.class, metadata, inits);
    }

    public QGrainTraffic(Class<? extends GrainTraffic> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.analysis = inits.isInitialized("analysis") ? new QAnalysis(forProperty("analysis"), inits.get("analysis")) : null;
        this.balanceSheet = inits.isInitialized("balanceSheet") ? new QBalanceSheet(forProperty("balanceSheet"), inits.get("balanceSheet")) : null;
        this.contract = inits.isInitialized("contract") ? new com.haut.grm.model.business.QContract(forProperty("contract"), inits.get("contract")) : null;
        this.registerRecord = inits.isInitialized("registerRecord") ? new QRegisterRecord(forProperty("registerRecord"), inits.get("registerRecord")) : null;
        this.secondContract = inits.isInitialized("secondContract") ? new com.haut.grm.model.business.QContract(forProperty("secondContract"), inits.get("secondContract")) : null;
        this.secondstock = inits.isInitialized("secondstock") ? new com.haut.grm.model.business.QStockId(forProperty("secondstock"), inits.get("secondstock")) : null;
        this.secondstockchange = inits.isInitialized("secondstockchange") ? new com.haut.grm.model.business.QStockChange(forProperty("secondstockchange"), inits.get("secondstockchange")) : null;
        this.secondWeightSheet = inits.isInitialized("secondWeightSheet") ? new QWeightSheet(forProperty("secondWeightSheet"), inits.get("secondWeightSheet")) : null;
        this.stage = inits.isInitialized("stage") ? new com.haut.grm.model.meta.QStage(forProperty("stage")) : null;
        this.stock = inits.isInitialized("stock") ? new com.haut.grm.model.business.QStockId(forProperty("stock"), inits.get("stock")) : null;
        this.stockchange = inits.isInitialized("stockchange") ? new com.haut.grm.model.business.QStockChange(forProperty("stockchange"), inits.get("stockchange")) : null;
        this.weightSheet = inits.isInitialized("weightSheet") ? new QWeightSheet(forProperty("weightSheet"), inits.get("weightSheet")) : null;
    }

}

