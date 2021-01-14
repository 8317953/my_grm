package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyFenIesSheet is a Querydsl query type for MyFenIesSheet
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyFenIesSheet extends EntityPathBase<MyFenIesSheet> {

    private static final long serialVersionUID = 46306737L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyFenIesSheet myFenIesSheet = new QMyFenIesSheet("myFenIesSheet");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final NumberPath<Integer> allowstage = createNumber("allowstage", Integer.class);

    public final com.haut.grm.model.ies.QAnalysis analysis;

    public final StringPath code = createString("code");

    public final com.haut.grm.model.business.QContract contract;

    public final NumberPath<Double> deductpercentage = createNumber("deductpercentage", Double.class);

    public final NumberPath<Double> deductweight = createNumber("deductweight", Double.class);

    public final NumberPath<Double> fweight = createNumber("fweight", Double.class);

    public final StringPath id = createString("id");

    public final NumberPath<Double> inamount = createNumber("inamount", Double.class);

    public final NumberPath<Integer> isecond = createNumber("isecond", Integer.class);

    public final NumberPath<Integer> isingress = createNumber("isingress", Integer.class);

    public final NumberPath<Double> outamount = createNumber("outamount", Double.class);

    public final DateTimePath<java.util.Date> outtime = createDateTime("outtime", java.util.Date.class);

    public final NumberPath<Integer> pack = createNumber("pack", Integer.class);

    public final NumberPath<Double> packperweight = createNumber("packperweight", Double.class);

    public final NumberPath<Double> packtotalamount = createNumber("packtotalamount", Double.class);

    public final com.haut.grm.model.ies.QRegisterRecord registerRecord;

    public final NumberPath<Integer> stageid = createNumber("stageid", Integer.class);

    public final com.haut.grm.model.business.QStockId stock;

    public final com.haut.grm.model.business.QStockChange stockchange;

    public final NumberPath<Double> sweight = createNumber("sweight", Double.class);

    public final DateTimePath<java.util.Date> time = createDateTime("time", java.util.Date.class);

    public QMyFenIesSheet(String variable) {
        this(MyFenIesSheet.class, forVariable(variable), INITS);
    }

    public QMyFenIesSheet(Path<? extends MyFenIesSheet> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyFenIesSheet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyFenIesSheet(PathMetadata metadata, PathInits inits) {
        this(MyFenIesSheet.class, metadata, inits);
    }

    public QMyFenIesSheet(Class<? extends MyFenIesSheet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.analysis = inits.isInitialized("analysis") ? new com.haut.grm.model.ies.QAnalysis(forProperty("analysis"), inits.get("analysis")) : null;
        this.contract = inits.isInitialized("contract") ? new com.haut.grm.model.business.QContract(forProperty("contract"), inits.get("contract")) : null;
        this.registerRecord = inits.isInitialized("registerRecord") ? new com.haut.grm.model.ies.QRegisterRecord(forProperty("registerRecord"), inits.get("registerRecord")) : null;
        this.stock = inits.isInitialized("stock") ? new com.haut.grm.model.business.QStockId(forProperty("stock"), inits.get("stock")) : null;
        this.stockchange = inits.isInitialized("stockchange") ? new com.haut.grm.model.business.QStockChange(forProperty("stockchange"), inits.get("stockchange")) : null;
    }

}

