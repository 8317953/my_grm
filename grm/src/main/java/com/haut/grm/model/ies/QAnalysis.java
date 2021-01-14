package com.haut.grm.model.ies;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnalysis is a Querydsl query type for Analysis
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAnalysis extends EntityPathBase<Analysis> {

    private static final long serialVersionUID = -377909811L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnalysis analysis = new QAnalysis("analysis");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

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

    public final NumberPath<Double> a1l = createNumber("a1l", Double.class);

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

    public final NumberPath<Double> a3l = createNumber("a3l", Double.class);

    public final NumberPath<Double> a4 = createNumber("a4", Double.class);

    public final NumberPath<Double> a40 = createNumber("a40", Double.class);

    public final NumberPath<Double> a5 = createNumber("a5", Double.class);

    public final NumberPath<Double> a6 = createNumber("a6", Double.class);

    public final NumberPath<Double> a7 = createNumber("a7", Double.class);

    public final NumberPath<Double> a8 = createNumber("a8", Double.class);

    public final NumberPath<Double> a9 = createNumber("a9", Double.class);

    public final StringPath analysisComment = createString("analysisComment");

    public final com.haut.grm.model.type.QAnalysisLevel analysisLevel;

    public final DateTimePath<java.util.Date> analysisTime = createDateTime("analysisTime", java.util.Date.class);

    public final com.haut.grm.model.meta.QUser analyst;

    public final com.haut.grm.model.QAnaMoban anamoban;

    public final StringPath barcode = createString("barcode");

    public final com.haut.grm.model.type.QCountry country;

    public final BooleanPath done = createBoolean("done");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath location = createString("location");

    public final BooleanPath pass = createBoolean("pass");

    public final StringPath s1 = createString("s1");

    public final StringPath s2 = createString("s2");

    public final StringPath s3 = createString("s3");

    public final StringPath sampleComment = createString("sampleComment");

    public final com.haut.grm.model.meta.QUser sampler;

    public final DateTimePath<java.util.Date> sampleTime = createDateTime("sampleTime", java.util.Date.class);

    public final StringPath year = createString("year");

    public QAnalysis(String variable) {
        this(Analysis.class, forVariable(variable), INITS);
    }

    public QAnalysis(Path<? extends Analysis> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnalysis(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnalysis(PathMetadata metadata, PathInits inits) {
        this(Analysis.class, metadata, inits);
    }

    public QAnalysis(Class<? extends Analysis> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.analysisLevel = inits.isInitialized("analysisLevel") ? new com.haut.grm.model.type.QAnalysisLevel(forProperty("analysisLevel")) : null;
        this.analyst = inits.isInitialized("analyst") ? new com.haut.grm.model.meta.QUser(forProperty("analyst"), inits.get("analyst")) : null;
        this.anamoban = inits.isInitialized("anamoban") ? new com.haut.grm.model.QAnaMoban(forProperty("anamoban"), inits.get("anamoban")) : null;
        this.country = inits.isInitialized("country") ? new com.haut.grm.model.type.QCountry(forProperty("country")) : null;
        this.sampler = inits.isInitialized("sampler") ? new com.haut.grm.model.meta.QUser(forProperty("sampler"), inits.get("sampler")) : null;
    }

}

