package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompany is a Querydsl query type for Company
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompany extends EntityPathBase<Company> {

    private static final long serialVersionUID = 1998774915L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompany company = new QCompany("company");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final StringPath djjgbh = createString("djjgbh");

    public final com.haut.grm.model.type.QCountry frgb;

    public final StringPath frsfz = createString("frsfz");

    public final StringPath frsjh = createString("frsjh");

    public final StringPath frxm = createString("frxm");

    public final com.haut.grm.model.type.QIdType frzjlx;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> jd = createNumber("jd", Double.class);

    public final com.haut.grm.model.standard.code.QLocation jydzbm;

    public final com.haut.grm.model.type.QCompanyLevelType lsgx;

    public final StringPath lssjdw = createString("lssjdw");

    public final NumberPath<Double> njgl = createNumber("njgl", Double.class);

    public final NumberPath<Double> njyl = createNumber("njyl", Double.class);

    public final NumberPath<Double> nsgl = createNumber("nsgl", Double.class);

    public final StringPath qydm = createString("qydm");

    public final com.haut.grm.model.type.QCompanyGrainType qylb;

    public final com.haut.grm.model.type.QCompanyDetailType qylx;

    public final StringPath qymc = createString("qymc");

    public final com.haut.grm.model.type.QCompanyType qyxz;

    public final BooleanPath sffxly = createBoolean("sffxly");

    public final BooleanPath sfyjqy = createBoolean("sfyjqy");

    public final StringPath sgxkz = createString("sgxkz");

    public final com.haut.grm.model.meta.QLevelType sgzg;

    public final com.haut.grm.model.standard.code.QLocation sjlsbh;

    public final NumberPath<Double> wd = createNumber("wd", Double.class);

    public final com.haut.grm.model.standard.code.QLocation zcqybm;

    public final DateTimePath<java.util.Date> zcsj = createDateTime("zcsj", java.util.Date.class);

    public final StringPath zcxxdz = createString("zcxxdz");

    public final NumberPath<Double> zczb = createNumber("zczb", Double.class);

    public final NumberPath<Double> zcze = createNumber("zcze", Double.class);

    public final SetPath<com.haut.grm.model.standard.code.GrainVariety, com.haut.grm.model.standard.code.QGrainVariety> zyjgpz = this.<com.haut.grm.model.standard.code.GrainVariety, com.haut.grm.model.standard.code.QGrainVariety>createSet("zyjgpz", com.haut.grm.model.standard.code.GrainVariety.class, com.haut.grm.model.standard.code.QGrainVariety.class, PathInits.DIRECT2);

    public final SetPath<com.haut.grm.model.standard.code.GrainVariety, com.haut.grm.model.standard.code.QGrainVariety> zyjypz = this.<com.haut.grm.model.standard.code.GrainVariety, com.haut.grm.model.standard.code.QGrainVariety>createSet("zyjypz", com.haut.grm.model.standard.code.GrainVariety.class, com.haut.grm.model.standard.code.QGrainVariety.class, PathInits.DIRECT2);

    public final SetPath<com.haut.grm.model.standard.code.GrainVariety, com.haut.grm.model.standard.code.QGrainVariety> zysgpz = this.<com.haut.grm.model.standard.code.GrainVariety, com.haut.grm.model.standard.code.QGrainVariety>createSet("zysgpz", com.haut.grm.model.standard.code.GrainVariety.class, com.haut.grm.model.standard.code.QGrainVariety.class, PathInits.DIRECT2);

    public final NumberPath<Double> zyzj = createNumber("zyzj", Double.class);

    public QCompany(String variable) {
        this(Company.class, forVariable(variable), INITS);
    }

    public QCompany(Path<? extends Company> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompany(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompany(PathMetadata metadata, PathInits inits) {
        this(Company.class, metadata, inits);
    }

    public QCompany(Class<? extends Company> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.frgb = inits.isInitialized("frgb") ? new com.haut.grm.model.type.QCountry(forProperty("frgb")) : null;
        this.frzjlx = inits.isInitialized("frzjlx") ? new com.haut.grm.model.type.QIdType(forProperty("frzjlx")) : null;
        this.jydzbm = inits.isInitialized("jydzbm") ? new com.haut.grm.model.standard.code.QLocation(forProperty("jydzbm")) : null;
        this.lsgx = inits.isInitialized("lsgx") ? new com.haut.grm.model.type.QCompanyLevelType(forProperty("lsgx")) : null;
        this.qylb = inits.isInitialized("qylb") ? new com.haut.grm.model.type.QCompanyGrainType(forProperty("qylb")) : null;
        this.qylx = inits.isInitialized("qylx") ? new com.haut.grm.model.type.QCompanyDetailType(forProperty("qylx")) : null;
        this.qyxz = inits.isInitialized("qyxz") ? new com.haut.grm.model.type.QCompanyType(forProperty("qyxz")) : null;
        this.sgzg = inits.isInitialized("sgzg") ? new com.haut.grm.model.meta.QLevelType(forProperty("sgzg")) : null;
        this.sjlsbh = inits.isInitialized("sjlsbh") ? new com.haut.grm.model.standard.code.QLocation(forProperty("sjlsbh")) : null;
        this.zcqybm = inits.isInitialized("zcqybm") ? new com.haut.grm.model.standard.code.QLocation(forProperty("zcqybm")) : null;
    }

}

