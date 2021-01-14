package com.haut.grm.model.business;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStockAnalysis is a Querydsl query type for StockAnalysis
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStockAnalysis extends EntityPathBase<StockAnalysis> {

    private static final long serialVersionUID = 527029086L;

    private static final PathInits INITS = new PathInits("*", "stock.cargo.compartment.store.depot.*");

    public static final QStockAnalysis stockAnalysis = new QStockAnalysis("stockAnalysis");

    public final com.haut.grm.model.base.QAbstractBusiness _super;

    public final NumberPath<Double> a1 = createNumber("a1", Double.class);

    public final NumberPath<Double> a10 = createNumber("a10", Double.class);

    public final NumberPath<Double> a11 = createNumber("a11", Double.class);

    public final NumberPath<Double> a12 = createNumber("a12", Double.class);

    public final NumberPath<Integer> a13 = createNumber("a13", Integer.class);

    public final NumberPath<Double> a14 = createNumber("a14", Double.class);

    public final NumberPath<Double> a15 = createNumber("a15", Double.class);

    public final NumberPath<Double> a16 = createNumber("a16", Double.class);

    public final NumberPath<Double> a17 = createNumber("a17", Double.class);

    public final NumberPath<Double> a18 = createNumber("a18", Double.class);

    public final NumberPath<Double> a19 = createNumber("a19", Double.class);

    public final NumberPath<Double> a2 = createNumber("a2", Double.class);

    public final NumberPath<Double> a20 = createNumber("a20", Double.class);

    public final NumberPath<Double> a21 = createNumber("a21", Double.class);

    public final NumberPath<Double> a22 = createNumber("a22", Double.class);

    public final NumberPath<Double> a23 = createNumber("a23", Double.class);

    public final NumberPath<Double> a24 = createNumber("a24", Double.class);

    public final NumberPath<Double> a25 = createNumber("a25", Double.class);

    public final NumberPath<Double> a26 = createNumber("a26", Double.class);

    public final NumberPath<Double> a27 = createNumber("a27", Double.class);

    public final NumberPath<Double> a28 = createNumber("a28", Double.class);

    public final NumberPath<Double> a29 = createNumber("a29", Double.class);

    public final NumberPath<Double> a3 = createNumber("a3", Double.class);

    public final NumberPath<Double> a30 = createNumber("a30", Double.class);

    public final NumberPath<Double> a31 = createNumber("a31", Double.class);

    public final NumberPath<Double> a32 = createNumber("a32", Double.class);

    public final NumberPath<Double> a33 = createNumber("a33", Double.class);

    public final NumberPath<Double> a34 = createNumber("a34", Double.class);

    public final NumberPath<Double> a35 = createNumber("a35", Double.class);

    public final NumberPath<Double> a36 = createNumber("a36", Double.class);

    public final NumberPath<Double> a37 = createNumber("a37", Double.class);

    public final NumberPath<Double> a38 = createNumber("a38", Double.class);

    public final NumberPath<Double> a39 = createNumber("a39", Double.class);

    public final NumberPath<Double> a4 = createNumber("a4", Double.class);

    public final NumberPath<Double> a40 = createNumber("a40", Double.class);

    public final NumberPath<Double> a5 = createNumber("a5", Double.class);

    public final NumberPath<Double> a6 = createNumber("a6", Double.class);

    public final NumberPath<Double> a7 = createNumber("a7", Double.class);

    public final NumberPath<Double> a8 = createNumber("a8", Double.class);

    public final NumberPath<Double> a9 = createNumber("a9", Double.class);

    public final com.haut.grm.model.QAnaMoban anamoban;

    //inherited
    public final StringPath auditComment;

    // inherited
    public final com.haut.grm.model.meta.QUser auditor;

    //inherited
    public final DateTimePath<java.util.Date> auditTime;

    //inherited
    public final StringPath businessKey;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath inputComment;

    // inherited
    public final com.haut.grm.model.meta.QUser inputer;

    //inherited
    public final DateTimePath<java.util.Date> inputTime;

    public final com.haut.grm.model.type.QAnalysisLevel level;

    public final StringPath s1 = createString("s1");

    public final StringPath s2 = createString("s2");

    public final StringPath s3 = createString("s3");

    public final StringPath s4 = createString("s4");

    public final StringPath s5 = createString("s5");

    public final QStockId stock;

    public final com.haut.grm.model.type.QAnalysisType type;

    public QStockAnalysis(String variable) {
        this(StockAnalysis.class, forVariable(variable), INITS);
    }

    public QStockAnalysis(Path<? extends StockAnalysis> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStockAnalysis(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStockAnalysis(PathMetadata metadata, PathInits inits) {
        this(StockAnalysis.class, metadata, inits);
    }

    public QStockAnalysis(Class<? extends StockAnalysis> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.haut.grm.model.base.QAbstractBusiness(type, metadata, inits);
        this.anamoban = inits.isInitialized("anamoban") ? new com.haut.grm.model.QAnaMoban(forProperty("anamoban"), inits.get("anamoban")) : null;
        this.auditComment = _super.auditComment;
        this.auditor = _super.auditor;
        this.auditTime = _super.auditTime;
        this.businessKey = _super.businessKey;
        this.id = _super.id;
        this.inputComment = _super.inputComment;
        this.inputer = _super.inputer;
        this.inputTime = _super.inputTime;
        this.level = inits.isInitialized("level") ? new com.haut.grm.model.type.QAnalysisLevel(forProperty("level")) : null;
        this.stock = inits.isInitialized("stock") ? new QStockId(forProperty("stock"), inits.get("stock")) : null;
        this.type = inits.isInitialized("type") ? new com.haut.grm.model.type.QAnalysisType(forProperty("type")) : null;
    }

}

