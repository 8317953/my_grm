package com.haut.grm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreConfig is a Querydsl query type for StoreConfig
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStoreConfig extends EntityPathBase<StoreConfig> {

    private static final long serialVersionUID = 603762313L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreConfig storeConfig = new QStoreConfig("storeConfig");

    public final com.haut.grm.model.base.QAbstractEntity _super = new com.haut.grm.model.base.QAbstractEntity(this);

    public final StringPath cableData = createString("cableData");

    public final com.haut.grm.model.type.QStructureType frameStructure;

    public final com.haut.grm.model.type.QStructureType groundStructure;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isChargeable = createBoolean("isChargeable");

    public final BooleanPath isDemo = createBoolean("isDemo");

    public final BooleanPath isFumigatable = createBoolean("isFumigatable");

    public final BooleanPath isInsecticidal = createBoolean("isInsecticidal");

    public final BooleanPath isInsectsensitive = createBoolean("isInsectsensitive");

    public final BooleanPath isInsulated = createBoolean("isInsulated");

    public final BooleanPath isPackagelessable = createBoolean("isPackagelessable");

    public final BooleanPath isProcessed = createBoolean("isProcessed");

    public final BooleanPath isRemote = createBoolean("isRemote");

    public final BooleanPath isRetardant = createBoolean("isRetardant");

    public final BooleanPath isTemperaturable = createBoolean("isTemperaturable");

    public final BooleanPath isVentilatable = createBoolean("isVentilatable");

    public final com.haut.grm.model.meta.QUser manager;

    public final com.haut.grm.model.meta.QStoreModel model;

    public final com.haut.grm.model.type.QPackageCategory packageCategory;

    public final com.haut.grm.model.type.QStructureType roofStructure;

    public final StringPath sourcePositionX = createString("sourcePositionX");

    public final StringPath sourcePositionY = createString("sourcePositionY");

    public final com.haut.grm.model.type.QStorageType storageType;

    public final QStore store;

    public final StringPath targetPositionX = createString("targetPositionX");

    public final StringPath targetPositionY = createString("targetPositionY");

    public final NumberPath<Long> tempBreadth = createNumber("tempBreadth", Long.class);

    public final com.haut.grm.model.type.QTemperatureControlType temperatureControlType;

    public final NumberPath<Long> tempLayer = createNumber("tempLayer", Long.class);

    public final NumberPath<Long> tempWidth = createNumber("tempWidth", Long.class);

    public final com.haut.grm.model.standard.code.QStoreType type;

    public final com.haut.grm.model.system.QCoreVersion version;

    public final com.haut.grm.model.type.QStructureType wallStructure;

    public QStoreConfig(String variable) {
        this(StoreConfig.class, forVariable(variable), INITS);
    }

    public QStoreConfig(Path<? extends StoreConfig> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreConfig(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreConfig(PathMetadata metadata, PathInits inits) {
        this(StoreConfig.class, metadata, inits);
    }

    public QStoreConfig(Class<? extends StoreConfig> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.frameStructure = inits.isInitialized("frameStructure") ? new com.haut.grm.model.type.QStructureType(forProperty("frameStructure")) : null;
        this.groundStructure = inits.isInitialized("groundStructure") ? new com.haut.grm.model.type.QStructureType(forProperty("groundStructure")) : null;
        this.manager = inits.isInitialized("manager") ? new com.haut.grm.model.meta.QUser(forProperty("manager"), inits.get("manager")) : null;
        this.model = inits.isInitialized("model") ? new com.haut.grm.model.meta.QStoreModel(forProperty("model")) : null;
        this.packageCategory = inits.isInitialized("packageCategory") ? new com.haut.grm.model.type.QPackageCategory(forProperty("packageCategory")) : null;
        this.roofStructure = inits.isInitialized("roofStructure") ? new com.haut.grm.model.type.QStructureType(forProperty("roofStructure")) : null;
        this.storageType = inits.isInitialized("storageType") ? new com.haut.grm.model.type.QStorageType(forProperty("storageType")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
        this.temperatureControlType = inits.isInitialized("temperatureControlType") ? new com.haut.grm.model.type.QTemperatureControlType(forProperty("temperatureControlType")) : null;
        this.type = inits.isInitialized("type") ? new com.haut.grm.model.standard.code.QStoreType(forProperty("type")) : null;
        this.version = inits.isInitialized("version") ? new com.haut.grm.model.system.QCoreVersion(forProperty("version")) : null;
        this.wallStructure = inits.isInitialized("wallStructure") ? new com.haut.grm.model.type.QStructureType(forProperty("wallStructure")) : null;
    }

}

