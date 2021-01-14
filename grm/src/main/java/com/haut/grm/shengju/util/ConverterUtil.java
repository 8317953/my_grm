/*     */ package com.haut.grm.shengju.util;
/*     */ 
/*     */ import com.haut.grm.model.Cargo;
/*     */ import com.haut.grm.model.CargoRepView;
/*     */ import com.haut.grm.model.Company;
/*     */ import com.haut.grm.model.Compartment;
/*     */ import com.haut.grm.model.Depot;
/*     */ import com.haut.grm.model.DeviceCamera;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.StoreConfig;
/*     */ import com.haut.grm.model.StoreStatus;
/*     */ import com.haut.grm.model.business.Contract;
/*     */ import com.haut.grm.model.business.GrainRotate;
/*     */ import com.haut.grm.model.business.StockId;
/*     */ import com.haut.grm.model.business.StockSum;
/*     */ import com.haut.grm.model.dto.TemperatureDataDto;
/*     */ import com.haut.grm.model.entry.EntryMeasure;
/*     */ import com.haut.grm.model.ies.Analysis;
/*     */ import com.haut.grm.model.ies.GrainTraffic;
/*     */ import com.haut.grm.model.ies.RegisterRecord;
/*     */ import com.haut.grm.model.ies.WeightSheet;
/*     */ import com.haut.grm.model.meta.User;
/*     */ import com.haut.grm.model.standard.code.GrainVariety;
/*     */ import com.haut.grm.service.CommonService;
/*     */ import com.haut.grm.shengju.model.SjCargo;
/*     */ import com.haut.grm.shengju.model.SjCompany;
/*     */ import com.haut.grm.shengju.model.SjCompartment;
/*     */ import com.haut.grm.shengju.model.SjDepot;
/*     */ import com.haut.grm.shengju.model.SjDeviceCamera;
/*     */ import com.haut.grm.shengju.model.SjGrainRotate;
/*     */ import com.haut.grm.shengju.model.SjGrainTraffic;
/*     */ import com.haut.grm.shengju.model.SjMeasure;
/*     */ import com.haut.grm.shengju.model.SjStockSum;
/*     */ import com.haut.grm.shengju.model.SjStore;
/*     */ import com.haut.grm.shengju.model.SjTemperature;
/*     */ import com.haut.grm.shengju.model.SjTemperaturePoint;
/*     */ import com.haut.grm.shengju.model.SjUser;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class ConverterUtil
/*     */ {
/*  47 */   private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
/*     */   
/*     */   public static List<SjUser> convertUsers(Collection<User> users, Company company, Depot depot, Boolean isDelete) {
/*  50 */     List<SjUser> result = new ArrayList();
/*  51 */     for (User user : users) {
/*  52 */       result.add(convertUser(user, company, depot, isDelete));
/*     */     }
/*  54 */     return result;
/*     */   }
/*     */   
/*     */   public static SjUser convertUser(User user, Company company, Depot depot, Boolean isDelete) {
/*  58 */     SjUser _user = new SjUser();
/*  59 */     if (isDelete.booleanValue())
/*  60 */       _user.setSFSC(Integer.valueOf(1));
/*  61 */     _user.setRYBH(company.getQydm() + String.format("%08d", new Object[] { user.getId() }) + String.format("%03d", new Object[] { depot.getCodeId() }));
/*  62 */     _user.setQYDM(company.getQydm());
/*  63 */     _user.setKQBM(String.format("%03d", new Object[] { depot.getCodeId() }));
/*  64 */     _user.setXM(user.getOfficialName());
/*  65 */     _user.setSFZ(user.getIdCode());
/*  66 */     if (user.getEthnicity() != null) {
/*  67 */       _user.setGJ(user.getEthnicity().getName());
/*     */     } else
/*  69 */       _user.setGJ(null);
/*  70 */     _user.setCSRQ(user.getDateOfBirth());
/*  71 */     if (user.getPoliticalStatus() != null) {
/*  72 */       _user.setZZMM(user.getPoliticalStatus().getCodeId());
/*     */     } else
/*  74 */       _user.setZZMM(Integer.valueOf(13));
/*  75 */     _user.setRYLX("100");
/*  76 */     _user.setZW(Integer.valueOf(100));
/*  77 */     _user.setBYYX("不详");
/*  78 */     if (user.getDiploma() != null) {
/*  79 */       _user.setXL(user.getDiploma().getCodeId());
/*     */     } else
/*  81 */       _user.setXL(Integer.valueOf(300));
/*  82 */     if (user.getMajor() != null) {
/*  83 */       _user.setZY(user.getMajor().getCodeId());
/*     */     } else
/*  85 */       _user.setZY(Integer.valueOf(9));
/*  86 */     _user.setJKZK(Integer.valueOf(10));
/*  87 */     _user.setRZSJ(user.getDateOfIn());
/*  88 */     _user.setYDDH(user.getTelephone());
/*  89 */     _user.setYX(user.getEmail());
/*  90 */     if (user.getProfessionalTitle() != null) {
/*  91 */       _user.setZCJB(user.getProfessionalTitle().getCodeId());
/*     */     } else
/*  93 */       _user.setZCJB(Integer.valueOf(500));
/*  94 */     _user.setGZZT(Integer.valueOf(user.getIsActive().booleanValue() ? 1 : 2));
/*  95 */     _user.setSFWQ(Integer.valueOf(user.getIsOutside().booleanValue() ? 1 : 2));
/*  96 */     _user.setSFSC(Integer.valueOf(0));
/*  97 */     return _user;
/*     */   }
/*     */   
/*     */   public static SjCompany convertCompany(Company company, Boolean isDelete) {
/* 101 */     SjCompany _company = new SjCompany();
/* 102 */     if (isDelete.booleanValue())
/* 103 */       _company.setSFSC(Integer.valueOf(1));
/* 104 */     _company.setQYDM(company.getQydm());
/* 105 */     _company.setQYMC(company.getQymc());
/* 106 */     _company.setQYLX(company.getQylx().getCodeId());
/* 107 */     _company.setQYLB(company.getQylb().getCodeId());
/* 108 */     _company.setQYXZ(company.getQyxz().getCodeId());
/* 109 */     _company.setLSGX(company.getLsgx().getCodeId());
/* 110 */     _company.setSFYJQY(Integer.valueOf(company.getSfyjqy().booleanValue() ? 1 : 2));
/* 111 */     _company.setSFFXLY(Integer.valueOf(company.getSffxly().booleanValue() ? 1 : 2));
/* 112 */     _company.setLSSJDW(company.getLssjdw());
/* 113 */     _company.setSGZG(company.getSgzg().getCodeId());
/* 114 */     _company.setSGXKZ(company.getSgxkz());
/* 115 */     _company.setSJLSBH(company.getSjlsbh().getCode());
/* 116 */     _company.setDJJGBH(company.getDjjgbh());
/* 117 */     _company.setZCSJ(company.getZcsj());
/* 118 */     _company.setZCBZ(Integer.valueOf(156));
/* 119 */     _company.setZCZB(new BigDecimal(company.getZczb().doubleValue()));
/* 120 */     _company.setZCQYBM(company.getZcqybm().getCode());
/* 121 */     _company.setZCXXDZ(company.getZcxxdz());
/* 122 */     _company.setJYDZBM(company.getJydzbm().getCode());
/* 123 */     _company.setFRXM(company.getFrxm());
/* 124 */     _company.setFRGB("156");
/* 125 */     _company.setFRZJLX(company.getFrzjlx().getCodeId());
/* 126 */     _company.setFRSFZ(company.getFrsfz());
/* 127 */     _company.setFRSJH(company.getFrsjh());
/* 128 */     _company.setJD(new BigDecimal(company.getJd().doubleValue()));
/* 129 */     _company.setWD(new BigDecimal(company.getWd().doubleValue()));
/* 130 */     _company.setZCZE(new BigDecimal(company.getZcze().doubleValue()));
/* 131 */     _company.setNJGL(new BigDecimal(company.getNjgl().doubleValue()));
/* 132 */     _company.setNJYL(new BigDecimal(company.getNjyl().doubleValue()));
/* 133 */     _company.setNSGL(new BigDecimal(company.getNsgl().doubleValue()));
/* 134 */     _company.setZYZJ(new BigDecimal(company.getZyzj().doubleValue()));
/*     */     
/*     */ 
/* 137 */     if (!company.getZyjgpz().isEmpty())
/*     */     {
/* 139 */       Set<String> xx = new java.util.HashSet();
/* 140 */       for (GrainVariety gv : company.getZyjgpz()) {
/* 141 */         xx.add(gv.getShortCode());
/*     */       }
/* 143 */       _company.setZYJGPZ(String.join(",", xx));
/*     */     }
/*     */     
/* 146 */     if (!company.getZysgpz().isEmpty()) {
/* 147 */       Set<String> yy = new java.util.HashSet();
/* 148 */       for (GrainVariety gv : company.getZysgpz()) {
/* 149 */         yy.add(gv.getShortCode());
/*     */       }
/* 151 */       _company.setZYSGPZ(String.join(",", yy));
/*     */     }
/*     */     
/* 154 */     if (!company.getZysgpz().isEmpty()) {
/* 155 */       Set<String> zz = new java.util.HashSet();
/* 156 */       for (GrainVariety gv : company.getZysgpz()) {
/* 157 */         zz.add(gv.getShortCode());
/*     */       }
/* 159 */       _company.setZYJYPZ(String.join(",", zz));
/*     */     }
/*     */     
/* 162 */     return _company;
/*     */   }
/*     */   
/*     */   public static List<SjDepot> convertDepots(Collection<Depot> depots, Company company, Boolean isDelete) {
/* 166 */     List<SjDepot> result = new ArrayList();
/* 167 */     for (Depot depot : depots) {
/* 168 */       result.add(convertDepot(depot, company, isDelete));
/*     */     }
/* 170 */     return result;
/*     */   }
/*     */   
/*     */   public static SjDepot convertDepot(Depot depot, Company company, Boolean isDelete) {
/* 174 */     SjDepot _depot = new SjDepot();
/* 175 */     if (isDelete.booleanValue())
/* 176 */       _depot.setSFSC(Integer.valueOf(1));
/* 177 */     _depot.setQYDM(company.getQydm());
/* 178 */     _depot.setKQBM(String.format("%03d", new Object[] { depot.getCodeId() }));
/* 179 */     _depot.setKQMC(depot.getName());
/* 180 */     _depot.setKQFZRXM(depot.getManagerName());
/* 181 */     _depot.setKQDH(depot.getTelephone());
/* 182 */     if (depot.getLocation() != null) {
/* 183 */       _depot.setKQSD(depot.getLocation().getCode());
/*     */     } else
/* 185 */       _depot.setKQSD(null);
/* 186 */     _depot.setKQDZ(depot.getAddress());
/* 187 */     _depot.setCCSSCQ(Integer.valueOf(depot.getIsOwn().booleanValue() ? 1 : 2));
/* 188 */     _depot.setSJZCR(new BigDecimal(depot.getCapacity().longValue()));
/* 189 */     _depot.setYXZCR(new BigDecimal(depot.getActiveCapacity().longValue()));
/* 190 */     _depot.setSJZGR(new BigDecimal(depot.getOilCapacity().longValue()));
/* 191 */     _depot.setYXZGR(new BigDecimal(depot.getActiveOilCapacity().longValue()));
/* 192 */     _depot.setYWTLZYX(Integer.valueOf(2));
/* 193 */     _depot.setYWSYMT(Integer.valueOf(2));
/* 194 */     _depot.setJLGLLB(depot.getRoadType().getCodeId());
/* 195 */     _depot.setJLGLJL(new BigDecimal(depot.getRoadDistance().intValue()));
/* 196 */     _depot.setYWWRY(Integer.valueOf(2));
/* 197 */     _depot.setYWFHSS(Integer.valueOf(1));
/* 198 */     _depot.setYWXFSY(Integer.valueOf(1));
/* 199 */     _depot.setYWXFSS(Integer.valueOf(1));
/* 200 */     _depot.setYWQCH(Integer.valueOf(1));
/* 201 */     _depot.setYWJHYS(Integer.valueOf(1));
/* 202 */     _depot.setKQPMT("");
/* 203 */     _depot.setJD(new BigDecimal(depot.getLatitude().doubleValue()));
/* 204 */     _depot.setWD(new BigDecimal(depot.getLongitude().doubleValue()));
/* 205 */     _depot.setJCSJ(depot.getBuiltDate());
/* 206 */     _depot.setKQCZ(depot.getFax());
/* 207 */     _depot.setKQYB(depot.getZipCode());
/* 208 */     _depot.setSFZSF("N");
/* 209 */     return _depot;
/*     */   }
/*     */   
/*     */   public static List<SjStore> convertStores(Collection<Store> stores, Company company, Boolean isDelete) {
/* 213 */     List<SjStore> result = new ArrayList();
/* 214 */     for (Store store : stores) {
/* 215 */       result.add(convertStore(store, company, isDelete));
/*     */     }
/* 217 */     return result;
/*     */   }
/*     */   
/*     */   public static SjStore convertStore(Store store, Company company, Boolean isDelete) {
/* 221 */     SjStore _store = new SjStore();
/* 222 */     if (isDelete.booleanValue())
/* 223 */       _store.setSFSC(Integer.valueOf(1));
/* 224 */     _store.setQYDM(company.getQydm());
/* 225 */     _store.setKQBM(String.format("%03d", new Object[] { store.getDepot().getCodeId() }));
/* 226 */     _store.setCFH(String.format("%03d", new Object[] { store.getCodeId() }));
/* 227 */     _store.setCFMC(store.getName());
/* 228 */     if (store.getConfig().getType() != null) {
/* 229 */       _store.setCX(store.getConfig().getType().getCode());
/* 230 */       _store.setCXMC(store.getConfig().getType().getName());
/*     */     }
/*     */     else {
/* 233 */       _store.setCX(null);
/* 234 */       _store.setCXMC(null);
/*     */     }
/* 236 */     _store.setSJCR(new BigDecimal(store.getDesignVolume().longValue()));
/* 237 */     _store.setSJCRONG(new BigDecimal(store.getActualVolume().longValue()));
/* 238 */     _store.setJCRQ(store.getStatus().getActiveDate());
/* 239 */     _store.setNFCWCC(Integer.valueOf(store.getConfig().getIsInsulated().booleanValue() ? 1 : 2));
/* 240 */     _store.setNFSZCC(Integer.valueOf(store.getConfig().getIsPackagelessable().booleanValue() ? 1 : 2));
/* 241 */     _store.setYWFSQCSS(Integer.valueOf(store.getConfig().getIsInsecticidal().booleanValue() ? 1 : 2));
/* 242 */     _store.setYWFHFBFDSS(Integer.valueOf(store.getConfig().getIsRetardant().booleanValue() ? 1 : 2));
/* 243 */     _store.setYWLQJCSS(Integer.valueOf(store.getConfig().getIsTemperaturable().booleanValue() ? 1 : 2));
/* 244 */     _store.setYWJXTFSS(Integer.valueOf(store.getConfig().getIsVentilatable().booleanValue() ? 1 : 2));
/* 245 */     _store.setNFHLXZSC(Integer.valueOf(store.getConfig().getIsFumigatable().booleanValue() ? 1 : 2));
/* 246 */     _store.setNFFDDYQTCL(Integer.valueOf(store.getConfig().getIsChargeable().booleanValue() ? 1 : 2));
/* 247 */     _store.setNFCWCC(Integer.valueOf(store.getConfig().getIsInsectsensitive().booleanValue() ? 1 : 2));
/*     */     
/* 249 */     if (store.getConfig().getPackageCategory() != null) {
/* 250 */       _store.setCLFS(store.getConfig().getPackageCategory().getCodeId());
/*     */     }
/*     */     else {
/* 253 */       _store.setCLFS(null);
/*     */     }
/* 255 */     _store.setCLLX(Integer.valueOf(store.getConfig().getIsProcessed().booleanValue() ? 1 : 2));
/* 256 */     if (store.getConfig().getStorageType() != null) {
/* 257 */       _store.setCLJS(store.getConfig().getStorageType().getCodeId());
/*     */     }
/*     */     else {
/* 260 */       _store.setCLJS(null);
/*     */     }
/* 262 */     if (store.getConfig().getTemperatureControlType() != null) {
/* 263 */       _store.setWDKZLX(store.getConfig().getTemperatureControlType().getCodeId());
/*     */     }
/*     */     else {
/* 266 */       _store.setWDKZLX(null);
/*     */     }
/* 268 */     _store.setCFPMT("");
/* 269 */     _store.setCFSFWH(Integer.valueOf(1));
/* 270 */     if (store.getStatus().getCondition() != null) {
/* 271 */       _store.setCFZT(store.getStatus().getCondition().getCodeId());
/*     */     }
/*     */     else {
/* 274 */       _store.setCFZT(null);
/*     */     }
/* 276 */     if (store.getStatus().getStatus() != null) {
/* 277 */       _store.setSYQK(store.getStatus().getStatus().getCodeId());
/*     */     }
/*     */     else {
/* 280 */       _store.setSYQK(null);
/*     */     }
/*     */     
/* 283 */     if (store.getLatitude() != null) {
/* 284 */       _store.setJD(new BigDecimal(store.getLatitude().doubleValue()));
/*     */     } else {
/* 286 */       _store.setJD(new BigDecimal(company.getJd().doubleValue()));
/*     */     }
/* 288 */     if (store.getLongitude() != null) {
/* 289 */       _store.setWD(new BigDecimal(store.getLongitude().doubleValue()));
/*     */     } else {
/* 291 */       _store.setWD(new BigDecimal(company.getWd().doubleValue()));
/*     */     }
/* 293 */     if (store.getConfig().getGroundStructure() != null) {
/* 294 */       _store.setCKJGDM(store.getConfig().getGroundStructure().getCodeId());
/*     */     } else
/* 296 */       _store.setCKJGDM(null);
/* 297 */     if (store.getConfig().getWallStructure() != null) {
/* 298 */       _store.setCKJGQT(store.getConfig().getWallStructure().getCodeId());
/*     */     } else
/* 300 */       _store.setCKJGQT(null);
/* 301 */     if (store.getConfig().getRoofStructure() != null) {
/* 302 */       _store.setCKJGFD(store.getConfig().getRoofStructure().getCodeId());
/*     */     } else
/* 304 */       _store.setCKJGFD(null);
/* 305 */     if (store.getConfig().getFrameStructure() != null) {
/* 306 */       _store.setCKJGFJ(store.getConfig().getFrameStructure().getCodeId());
/*     */     } else
/* 308 */       _store.setCKJGFJ(null);
/* 309 */     _store.setCFCD(new BigDecimal(store.getLength().doubleValue()));
/* 310 */     _store.setCFKD(new BigDecimal(store.getBreadth().doubleValue()));
/* 311 */     _store.setYKGD(new BigDecimal(store.getHeight().doubleValue()));
/* 312 */     _store.setZLXGD(new BigDecimal(store.getGrainHeight().doubleValue()));
/* 313 */     _store.setCMSL(Integer.valueOf(store.getDoors().size()));
/* 314 */     _store.setQYRQ(store.getStatus().getActiveDate());
/* 315 */     if (store.getConfig().getManager() != null) {
/* 316 */       _store.setBGYBH(((Long)store.getConfig().getManager().getId()).toString());
/* 317 */       _store.setBGYMC(store.getConfig().getManager().getOfficialName());
/*     */     }
/*     */     else {
/* 320 */       _store.setBGYBH(null);
/* 321 */       _store.setBGYMC(null);
/*     */     }
/* 323 */     _store.setSFDCCF(store.getConfig().getIsRemote().booleanValue() ? "Y" : "N");
/* 324 */     return _store;
/*     */   }
/*     */   
/*     */   public static List<SjCompartment> convertCompartments(Collection<Compartment> compartments, Company company, Boolean isDelete) {
/* 328 */     List<SjCompartment> result = new ArrayList();
/* 329 */     for (Compartment compartment : compartments) {
/* 330 */       result.add(convertCompartment(compartment, company, isDelete));
/*     */     }
/* 332 */     return result;
/*     */   }
/*     */   
/*     */   public static SjCompartment convertCompartment(Compartment compartment, Company company, Boolean isDelete) {
/* 336 */     SjCompartment _compartment = new SjCompartment();
/* 337 */     if (isDelete.booleanValue())
/* 338 */       _compartment.setSFSC(Integer.valueOf(1));
/* 339 */     _compartment.setQYDM(company.getQydm());
/* 340 */     _compartment.setKQBM(String.format("%03d", new Object[] { compartment.getStore().getDepot().getCodeId() }));
/* 341 */     _compartment.setCFH(String.format("%03d", new Object[] { compartment.getStore().getCodeId() }));
/* 342 */     _compartment.setAJBH(String.format("%03d", new Object[] { compartment.getCodeId() }));
/* 343 */     _compartment.setAJMC(compartment.getName());
/*     */     
/* 345 */     if (compartment.getLength() != null) {
/* 346 */       _compartment.setAJCD(new BigDecimal(compartment.getLength().doubleValue()));
/*     */     }
/*     */     else {
/* 349 */       _compartment.setAJCD(new BigDecimal(0));
/*     */     }
/*     */     
/* 352 */     if (compartment.getBreadth() != null) {
/* 353 */       _compartment.setAJKD(new BigDecimal(compartment.getBreadth().doubleValue()));
/*     */     }
/*     */     else {
/* 356 */       _compartment.setAJKD(new BigDecimal(0));
/*     */     }
/*     */     
/* 359 */     if (compartment.getHeight() != null) {
/* 360 */       _compartment.setAJGD(new BigDecimal(compartment.getHeight().doubleValue()));
/*     */     }
/*     */     else {
/* 363 */       _compartment.setAJGD(new BigDecimal(0));
/*     */     }
/*     */     
/* 366 */     if (compartment.getDesignVolume() != null) {
/* 367 */       _compartment.setAJSJCR(new BigDecimal(compartment.getDesignVolume()));
/*     */     }
/*     */     else {
/* 370 */       _compartment.setAJSJCR(new BigDecimal(0));
/*     */     }
/*     */     
/* 373 */     if (compartment.getActualVolume() != null) {
/* 374 */       _compartment.setAJSJRL(new BigDecimal(compartment.getActualVolume()));
/*     */     }
/*     */     else {
/* 377 */       _compartment.setAJSJRL(new BigDecimal(0));
/*     */     }
/* 379 */     _compartment.setAJQYRQ(compartment.getActiveDate());
/* 380 */     if (compartment.getCondition() != null) {
/* 381 */       _compartment.setAJZT(compartment.getCondition().getCodeId());
/*     */     }
/*     */     else {
/* 384 */       _compartment.setAJZT(null);
/*     */     }
/* 386 */     return _compartment;
/*     */   }
/*     */   
/*     */   public static List<SjCargo> convertCargoes(Collection<Cargo> cargoes, Company company, Boolean isDelete) {
/* 390 */     List<SjCargo> result = new ArrayList();
/* 391 */     for (Cargo cargo : cargoes) {
/* 392 */       result.add(convertCargo(cargo, company, isDelete));
/*     */     }
/* 394 */     return result;
/*     */   }
/*     */   
/*     */   public static SjCargo convertCargo(Cargo cargo, Company company, Boolean isDelete) {
/* 398 */     SjCargo _cargo = new SjCargo();
/* 399 */     if (isDelete.booleanValue())
/* 400 */       _cargo.setSFSC(Integer.valueOf(1));
/* 401 */     _cargo.setQYDM(company.getQydm());
/* 402 */     _cargo.setKQBM(String.format("%03d", new Object[] { cargo.getCompartment().getStore().getDepot().getCodeId() }));
/* 403 */     _cargo.setCFH(String.format("%03d", new Object[] { cargo.getCompartment().getStore().getCodeId() }));
/* 404 */     _cargo.setAJBH(String.format("%03d", new Object[] { cargo.getCompartment().getCodeId() }));
/* 405 */     _cargo.setHWBH(String.format("%02d", new Object[] { cargo.getCodeId() }));
/* 406 */     _cargo.setHWMC(cargo.getName());
/* 407 */     _cargo.setHWQYRQ(cargo.getActiveDate());
/* 408 */     if (cargo.getVolume() != null) {
/* 409 */       _cargo.setHWRL(new BigDecimal(cargo.getVolume().doubleValue()));
/*     */     }
/*     */     else {
/* 412 */       _cargo.setHWRL(new BigDecimal(0));
/*     */     }
/* 414 */     if (cargo.getPackageCategory() != null) {
/* 415 */       _cargo.setCLFS(cargo.getPackageCategory().getCodeId());
/*     */     }
/*     */     else {
/* 418 */       _cargo.setCLFS(null);
/*     */     }
/* 420 */     if (cargo.getStatus() != null) {
/* 421 */       _cargo.setHWZT(cargo.getStatus().getCodeId());
/*     */     }
/*     */     else {
/* 424 */       _cargo.setHWZT(null);
/*     */     }
/* 426 */     return _cargo;
/*     */   }
/*     */   
/*     */   public static List<SjStockSum> convertStockSums(Collection<StockSum> sums, Company company, CommonService cService) {
/* 430 */     List<SjStockSum> result = new ArrayList();
/* 431 */     for (StockSum sum : sums) {
/* 432 */       result.add(convertStockSum(sum, company, cService));
/*     */     }
/* 434 */     return result;
/*     */   }
/*     */   
/*     */   public static SjStockSum convertStockSum(StockSum sum, Company company, CommonService cService) {
/* 438 */     SjStockSum _sum = new SjStockSum();
/* 439 */     GrainVariety gv = cService.getUpTo3Level(sum.getGrainVariety());
/* 440 */     _sum.setQYBM(company.getQydm());
/* 441 */     _sum.setKQBM(String.format("%03d", new Object[] { sum.getCargo().getCompartment().getStore().getDepot().getCodeId() }));
/* 442 */     _sum.setCFH(String.format("%03d", new Object[] { sum.getCargo().getCompartment().getStore().getCodeId() }));
/* 443 */     _sum.setAJBH(String.format("%03d", new Object[] { sum.getCargo().getCompartment().getCodeId() }));
/* 444 */     _sum.setHWBH(String.format("%02d", new Object[] { sum.getCargo().getCodeId() }));
/* 445 */     _sum.setHWZT(sum.getCargo().getStatusId().toString());
/* 446 */     _sum.setSHNF(sum.getYear());
/* 447 */     _sum.setLSXZBM(sum.getGrainType().getCodeId());
/* 448 */     _sum.setLQGSDWBM(sum.getCargo().getCompartment().getStore().getDepot().getLocation().getCode());
/* 449 */     _sum.setLQGSDWMC(sum.getCargo().getCompartment().getStore().getDepot().getName());
/* 450 */     _sum.setLSPZ(gv.getName());
/* 451 */     _sum.setLSPZBM(gv.getShortCode());
/* 452 */     if (sum.getI_analysisLevel() != null) {
/* 453 */       _sum.setLSDJBM(sum.getI_analysisLevel().getCodeId().toString());
/*     */     }
/* 455 */     if (sum.getCountry() != null) {
/* 456 */       _sum.setLSGB(sum.getCountry().getCodeId().toString());
/*     */     }
/* 458 */     _sum.setLSCD(sum.getLocation());
/* 459 */     _sum.setRKSJ(sum.getInputTime());
/* 460 */     _sum.setFCSJ(sum.getInTime());
/* 461 */     _sum.setQCSJ(sum.getOutTime());
/* 462 */     _sum.setKCSL(new BigDecimal(sum.getAmount().longValue() + sum.getInAmount().longValue() - sum.getOutAmount().longValue()));
/* 463 */     if (sum.getCargo().getCompartment().getStore().getConfig().getManager() != null) {
/* 464 */       _sum.setBGYMC(sum.getCargo().getCompartment().getStore().getConfig().getManager().getOfficialName());
/*     */     }
/* 466 */     return _sum;
/*     */   }
/*     */   
/*     */   public static List<SjGrainTraffic> convertGrainTraffics(List<GrainTraffic> gts, Company company, java.util.Map<GrainTraffic, StockId> maps, CommonService cService) throws Throwable {
/* 470 */     List<SjGrainTraffic> result = new ArrayList();
/* 471 */     int m = 1;
/* 472 */     for (int i = 1; i < gts.size() + 1; i++) {
/* 473 */       GrainTraffic gt = (GrainTraffic)gts.get(i - 1);
/* 474 */       result.add(convertGrainTraffic(gt, company, false, i, (StockId)maps.get(gt), cService));
/* 475 */       if (gt.getHasSecond().booleanValue()) {
/* 476 */         result.add(convertGrainTraffic(gt, company, true, i + m, (StockId)maps.get(gt), cService));
/* 477 */         m++;
/*     */       }
/*     */     }
/* 480 */     return result;
/*     */   }
/*     */   
/*     */   private static SjGrainTraffic convertGrainTraffic(GrainTraffic gt, Company company, boolean second, int index, StockId stock, CommonService cService) throws Throwable {
/* 484 */     SjGrainTraffic _gt = new SjGrainTraffic();
/* 485 */     _gt.setYWLX(Integer.valueOf(gt.getIsIngress().booleanValue() ? 1 : 0));
/* 486 */     _gt.setYWDJRQ(gt.getTime());
/* 487 */     _gt.setQYDM(company.getQydm());
/* 488 */     _gt.setCYRXM(gt.getRegisterRecord().getPersonnelName());
/* 489 */     _gt.setCYRSFZH(gt.getRegisterRecord().getPersonnelIdNumber());
/* 490 */     _gt.setCYRLXDH(gt.getRegisterRecord().getTelephone());
/* 491 */     _gt.setCYRXXDZ(gt.getRegisterRecord().getPersonnelAddress());
/* 492 */     _gt.setYSGJ("1");
/* 493 */     _gt.setCCH(gt.getRegisterRecord().getVehicleTraffic().getPlate());
///* 494 */     _gt.setRMDJZP(com.haut.grm.shengju.ShengjuService.getInstance().uploadFile(gt.getRegisterRecord().getVehicleTraffic().getImage(), "create"));
/* 495 */     com.haut.grm.model.ies.IesCameraImage image = cService.getFirstIesCameraImage(((Long)gt.getId()).longValue(), "WEIGHT");
/* 496 */     if (image != null) {
///* 497 */       _gt.setGBZP(com.haut.grm.shengju.ShengjuService.getInstance().uploadFile(image.getImagePath(), "create"));
/*     */     }
/* 499 */     _gt.setCLDJSJ(gt.getRegisterRecord().getTime());
/* 500 */     _gt.setDJMGRYXM(gt.getRegisterRecord().getManager().getOfficialName());
/* 501 */     _gt.setBGYKL(Long.valueOf(0L));
/* 502 */     _gt.setJSSJ(gt.getBalanceSheet().getTime());
/* 503 */     _gt.setJSRXM(gt.getBalanceSheet().getManager().getOfficialName());
/* 504 */     _gt.setCMSJ(gt.getBalanceSheet().getTime());
/* 505 */     _gt.setCMQRMGRYXM(gt.getBalanceSheet().getManager().getOfficialName());
/* 506 */     if (gt.getIsIngress().booleanValue()) {
/* 507 */       _gt.setQYSJ(gt.getAnalysis().getSampleTime());
/* 508 */       _gt.setJYY(gt.getAnalysis().getAnalyst().getOfficialName());
/* 509 */       if (gt.getAnalysis().getAnalysisLevel() != null) {
/* 510 */         _gt.setDJBM(String.format("%02d", new Object[] { gt.getAnalysis().getAnalysisLevel().getCodeId() }));
/* 511 */         _gt.setDJMC(gt.getAnalysis().getAnalysisLevel().getName());
/*     */       }
/* 513 */       _gt.setLSCD(gt.getAnalysis().getLocation());
/* 514 */       _gt.setHYJG(Integer.valueOf(0));
/* 515 */       _gt.setZJKL(Integer.valueOf(0));
/* 516 */       _gt.setSHND(gt.getAnalysis().getYear());
/* 517 */       _gt.setLSCD(gt.getAnalysis().getLocation());
/*     */     }
/*     */     else {
/* 520 */       _gt.setSHND(stock.getYear());
/* 521 */       _gt.setLSCD(stock.getLocation());
/*     */     }
/* 523 */     if (!second) {
/* 524 */       Cargo cargo = gt.getWeightSheet().getCargo();
/* 525 */       _gt.setDJBH(company.getQydm() + String.format("%03d", new Object[] { cargo.getCompartment().getStore().getDepot().getCodeId() }) + 
/* 526 */         String.format("%03d", new Object[] { cargo.getCompartment().getStore().getCodeId() }) + 
/* 527 */         String.format("%03d", new Object[] { cargo.getCompartment().getCodeId() }) + 
/* 528 */         String.format("%02d", new Object[] { cargo.getCodeId() }) + 
/* 529 */         format.format(gt.getOutTime()) + String.format("%03d", new Object[] { Integer.valueOf(index) }));
/*     */       
/* 531 */       GrainVariety gv = cService.getUpTo3Level(gt.getContract().getGrainVariety());
/* 532 */       _gt.setPZBM(gv.getShortCode());
/* 533 */       _gt.setPZMC(gv.getName());
/* 534 */       _gt.setLQXZBM(gt.getContract().getGrainType().getCodeId().toString());
/* 535 */       _gt.setLQXZMC(gt.getContract().getGrainType().getName());
/* 536 */       _gt.setKQBM(String.format("%03d", new Object[] { gt.getWeightSheet().getStore().getDepot().getCodeId() }));
/* 537 */       _gt.setCFH(String.format("%03d", new Object[] { gt.getWeightSheet().getStore().getCodeId() }));
/* 538 */       _gt.setAJBH(String.format("%03d", new Object[] { gt.getWeightSheet().getCargo().getCompartment().getCodeId() }));
/* 539 */       _gt.setHWBH(String.format("%02d", new Object[] { gt.getWeightSheet().getCargo().getCodeId() }));
/* 540 */       _gt.setHTBH(gt.getContract().getName());
/* 541 */       _gt.setKHMC(gt.getContract().getClient().getName());
/* 542 */       _gt.setBGYXM(gt.getWeightSheet().getManager().getOfficialName());
/* 543 */       _gt.setQRSJ(gt.getWeightSheet().getDeductTime());
/* 544 */       _gt.setXCZJ(Long.valueOf(gt.getWeightSheet().getDeductWeight().longValue()));
/* 545 */       _gt.setJSDJ(new BigDecimal(0));
/* 546 */       _gt.setJSJE(new BigDecimal(0));
/* 547 */       if (gt.getIsIngress().booleanValue()) {
/* 548 */         _gt.setMZ(Long.valueOf(gt.getWeightSheet().getFirstWeight().longValue()));
/* 549 */         _gt.setMZJBY(gt.getWeightSheet().getFirstUser().getOfficialName());
/* 550 */         _gt.setMZJLSJ(gt.getWeightSheet().getFirstTime());
/* 551 */         _gt.setPZ(Long.valueOf(gt.getWeightSheet().getSecondWeight().longValue()));
/* 552 */         _gt.setPZJBY(gt.getWeightSheet().getSecondUser().getOfficialName());
/* 553 */         _gt.setPZJLSJ(gt.getWeightSheet().getSecondTime());
/* 554 */         Double jz = Double.valueOf(gt.getWeightSheet().getFirstWeight().doubleValue() - gt.getWeightSheet().getSecondWeight().doubleValue() - gt.getWeightSheet().getDeductWeight().doubleValue());
/* 555 */         _gt.setJZ(Long.valueOf(jz.longValue()));
/* 556 */         _gt.setJSZL(Long.valueOf(jz.longValue()));
/*     */       }
/*     */       else {
/* 559 */         _gt.setMZ(Long.valueOf(gt.getWeightSheet().getSecondWeight().longValue()));
/* 560 */         _gt.setMZJBY(gt.getWeightSheet().getSecondUser().getOfficialName());
/* 561 */         _gt.setMZJLSJ(gt.getWeightSheet().getSecondTime());
/* 562 */         _gt.setPZ(Long.valueOf(gt.getWeightSheet().getFirstWeight().longValue()));
/* 563 */         _gt.setPZJBY(gt.getWeightSheet().getFirstUser().getOfficialName());
/* 564 */         _gt.setPZJLSJ(gt.getWeightSheet().getFirstTime());
/* 565 */         Double jz = Double.valueOf(gt.getWeightSheet().getSecondWeight().doubleValue() - gt.getWeightSheet().getFirstWeight().doubleValue() - gt.getWeightSheet().getDeductWeight().doubleValue());
/* 566 */         _gt.setJZ(Long.valueOf(jz.longValue()));
/* 567 */         _gt.setJSZL(Long.valueOf(jz.longValue()));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 572 */       Cargo cargo = gt.getSecondWeightSheet().getCargo();
/* 573 */       _gt.setDJBH(company.getQydm() + String.format("%03d", new Object[] { cargo.getCompartment().getStore().getDepot().getCodeId() }) + 
/* 574 */         String.format("%03d", new Object[] { cargo.getCompartment().getStore().getCodeId() }) + 
/* 575 */         String.format("%03d", new Object[] { cargo.getCompartment().getCodeId() }) + 
/* 576 */         String.format("%02d", new Object[] { cargo.getCodeId() }) + 
/* 577 */         format.format(gt.getOutTime()) + String.format("%03d", new Object[] { Integer.valueOf(index) }));
/* 578 */       GrainVariety gv = cService.getUpTo3Level(gt.getSecondContract().getGrainVariety());
/* 579 */       _gt.setPZBM(gv.getShortCode());
/* 580 */       _gt.setPZMC(gv.getName());
/* 581 */       _gt.setLQXZBM(gt.getSecondContract().getGrainType().getCodeId().toString());
/* 582 */       _gt.setLQXZMC(gt.getSecondContract().getGrainType().getName());
/* 583 */       _gt.setKQBM(String.format("%03d", new Object[] { gt.getSecondWeightSheet().getStore().getDepot().getCodeId() }));
/* 584 */       _gt.setCFH(String.format("%03d", new Object[] { gt.getSecondWeightSheet().getStore().getCodeId() }));
/* 585 */       _gt.setAJBH(String.format("%03d", new Object[] { gt.getSecondWeightSheet().getCargo().getCompartment().getCodeId() }));
/* 586 */       _gt.setHWBH(String.format("%02d", new Object[] { gt.getSecondWeightSheet().getCargo().getCodeId() }));
/* 587 */       _gt.setHTBH(gt.getSecondContract().getName());
/* 588 */       _gt.setKHMC(gt.getSecondContract().getClient().getName());
/* 589 */       _gt.setBGYXM(gt.getSecondWeightSheet().getManager().getOfficialName());
/* 590 */       _gt.setQRSJ(gt.getSecondWeightSheet().getDeductTime());
/* 591 */       _gt.setXCZJ(Long.valueOf(gt.getSecondWeightSheet().getDeductWeight().longValue()));
/* 592 */       _gt.setJSDJ(new BigDecimal(0));
/* 593 */       _gt.setJSJE(new BigDecimal(0));
/* 594 */       if (gt.getIsIngress().booleanValue()) {
/* 595 */         _gt.setMZ(Long.valueOf(gt.getSecondWeightSheet().getFirstWeight().longValue()));
/* 596 */         _gt.setMZJBY(gt.getSecondWeightSheet().getFirstUser().getOfficialName());
/* 597 */         _gt.setMZJLSJ(gt.getSecondWeightSheet().getFirstTime());
/* 598 */         _gt.setPZ(Long.valueOf(gt.getSecondWeightSheet().getSecondWeight().longValue()));
/* 599 */         _gt.setPZJBY(gt.getSecondWeightSheet().getSecondUser().getOfficialName());
/* 600 */         _gt.setPZJLSJ(gt.getSecondWeightSheet().getSecondTime());
/* 601 */         Double jz = Double.valueOf(gt.getSecondWeightSheet().getFirstWeight().doubleValue() - gt.getSecondWeightSheet().getSecondWeight().doubleValue() - gt.getSecondWeightSheet().getDeductWeight().doubleValue());
/* 602 */         _gt.setJZ(Long.valueOf(jz.longValue()));
/* 603 */         _gt.setJSZL(Long.valueOf(jz.longValue()));
/*     */       }
/*     */       else {
/* 606 */         _gt.setMZ(Long.valueOf(gt.getSecondWeightSheet().getSecondWeight().longValue()));
/* 607 */         _gt.setMZJBY(gt.getSecondWeightSheet().getSecondUser().getOfficialName());
/* 608 */         _gt.setMZJLSJ(gt.getSecondWeightSheet().getSecondTime());
/* 609 */         _gt.setPZ(Long.valueOf(gt.getSecondWeightSheet().getFirstWeight().longValue()));
/* 610 */         _gt.setPZJBY(gt.getSecondWeightSheet().getFirstUser().getOfficialName());
/* 611 */         _gt.setPZJLSJ(gt.getSecondWeightSheet().getFirstTime());
/* 612 */         Double jz = Double.valueOf(gt.getSecondWeightSheet().getSecondWeight().doubleValue() - gt.getSecondWeightSheet().getFirstWeight().doubleValue() - gt.getSecondWeightSheet().getDeductWeight().doubleValue());
/* 613 */         _gt.setJZ(Long.valueOf(jz.longValue()));
/* 614 */         _gt.setJSZL(Long.valueOf(jz.longValue()));
/*     */       }
/*     */     }
/*     */     
/* 618 */     return _gt;
/*     */   }
/*     */   
/*     */   public static List<SjDeviceCamera> convertDeviceCameras(Collection<DeviceCamera> cameras, Company company, Depot depot, Boolean isDelete) {
/* 622 */     List<SjDeviceCamera> result = new ArrayList();
/* 623 */     for (DeviceCamera camera : cameras) {
/* 624 */       result.add(convertDeviceCamera(camera, company, depot, isDelete));
/*     */     }
/* 626 */     return result;
/*     */   }
/*     */   
/*     */   public static SjDeviceCamera convertDeviceCamera(DeviceCamera camera, Company company, Depot depot, Boolean isDelete) {
/* 630 */     SjDeviceCamera _camera = new SjDeviceCamera();
/* 631 */     if (isDelete.booleanValue())
/* 632 */       _camera.setSFSC(Integer.valueOf(1));
/* 633 */     _camera.setXTBM(company.getQydm() + String.format("%03d", new Object[] { depot.getCodeId() }) + String.format("%03d", new Object[] { camera.getId() }));
/* 634 */     _camera.setQYDM(company.getQydm());
/* 635 */     _camera.setSBBH(String.format("%03d", new Object[] { camera.getId() }));
/* 636 */     _camera.setSBMC(camera.getName());
/* 637 */     _camera.setSBLXMC(camera.getType().getName());
/* 638 */     _camera.setJKLB(camera.getType().getCodeId().intValue() == 1 ? "0" : "1");
/* 639 */     _camera.setSBLXMC(camera.getType().getName());
/* 640 */     _camera.setKQBM(String.format("%03d", new Object[] { depot.getCodeId() }));
/* 641 */     if ((camera.getType().getCodeId().intValue() == 1) && (camera.getStore() != null))
/* 642 */       _camera.setCFH(String.format("%03d", new Object[] { camera.getStore().getCodeId() }));
/* 643 */     if (camera.getManufacturer() != null) {
/* 644 */       _camera.setSBCJ(camera.getManufacturer().getName());
/*     */     } else
/* 646 */       _camera.setSBCJ(null);
/* 647 */     _camera.setIP(camera.getIpAddress());
/* 648 */     _camera.setDK(camera.getPort().toString());
/* 649 */     _camera.setYHM(camera.getUsername());
/* 650 */     _camera.setMM(camera.getPassword());
/* 651 */     return _camera;
/*     */   }
/*     */   
/*     */   public static SjGrainRotate convertGrainRotate(GrainRotate gr, Company company, CommonService cService) {
/* 655 */     SjGrainRotate _gr = new SjGrainRotate();
/* 656 */     _gr.setSQBH(company.getQydm() + String.format("%06d", new Object[] { gr.getId() }));
/* 657 */     _gr.setSQRQ(gr.getAuditTime());
/* 658 */     _gr.setSQDWBM(company.getQydm());
/* 659 */     _gr.setSQLHNF(gr.getYear());
/* 660 */     _gr.setYWLX(gr.getIsIngress().booleanValue() ? "1" : "2");
/* 661 */     GrainVariety gv = cService.getUpTo3Level(gr.getGrainVariety());
/* 662 */     _gr.setPZBM(gv.getShortCode());
/* 663 */     _gr.setPZZT("1");
/* 664 */     _gr.setSCNF(gr.getHarvestYear());
/* 665 */     _gr.setCCNX(gr.getStockYear());
/* 666 */     _gr.setJHLHL(new BigDecimal(gr.getAmount().longValue()));
/* 667 */     _gr.setLRSJ(gr.getInputTime());
/* 668 */     return _gr;
/*     */   }
/*     */   
/*     */   public static SjMeasure convertMeasure(EntryMeasure measure, Company company, Store store) {
/* 672 */     SjMeasure _measure = new SjMeasure();
/* 673 */     _measure.setXTBM(company.getQydm() + String.format("%03d", new Object[] { store.getDepot().getCodeId() }) + 
/* 674 */       String.format("%03d", new Object[] { store.getCodeId() }) + 
/* 675 */       format.format(measure.getTime()) + String.format("%02d", new Object[] { measure.getId() }));
/* 676 */     _measure.setCJSJ(measure.getTime());
/* 677 */     _measure.setKQBM(String.format("%03d", new Object[] { store.getDepot().getCodeId() }));
/* 678 */     _measure.setCFH(String.format("%03d", new Object[] { store.getCodeId() }));
/* 679 */     _measure.setQYDM(company.getQydm());
/* 680 */     _measure.setDQCBSL(new BigDecimal(measure.getStockAmount().longValue()));
/* 681 */     _measure.setSSJG(new BigDecimal(measure.getAmount().longValue()));
/* 682 */     return _measure;
/*     */   }
/*     */   
/*     */   public static SjTemperature convertTemperature(TemperatureDataDto temp, Company company, Store store, java.util.Date time, Long id) {
/* 686 */     SjTemperature _temp = new SjTemperature();
/* 687 */     _temp.setXTBM(company.getQydm() + String.format("%03d", new Object[] { store.getDepot().getCodeId() }) + 
/* 688 */       String.format("%03d", new Object[] { store.getCodeId() }) + 
/* 689 */       format.format(time) + String.format("%02d", new Object[] { id }));
/* 690 */     _temp.setTBDWDM(company.getQydm());
/* 691 */     _temp.setJCSJ(time);
/* 692 */     _temp.setKQBM(String.format("%03d", new Object[] { store.getDepot().getCodeId() }));
/* 693 */     _temp.setCFH(String.format("%03d", new Object[] { store.getCodeId() }));
/* 694 */     _temp.setQYDM(company.getQydm());
/* 695 */     _temp.setCWQW(new BigDecimal(temp.getOutTemp().doubleValue()));
/* 696 */     _temp.setCWSD(new BigDecimal(temp.getOutMois().doubleValue()));
/* 697 */     _temp.setCNQW(new BigDecimal(temp.getHouseTemp().doubleValue()));
/* 698 */     _temp.setCNSD(new BigDecimal(temp.getHouseMois().doubleValue()));
/* 699 */     _temp.setLDZGWD(new BigDecimal(((Double)java.util.Collections.max(temp.getData())).doubleValue()));
/* 700 */     _temp.setLDZDWD(new BigDecimal(((Double)java.util.Collections.min(temp.getData())).doubleValue()));
/* 701 */     _temp.setLDPJWD(new BigDecimal(calculateAverage(temp.getData())));
/*     */     
/* 703 */     if ((store.getConfig().getTempWidth() != null) && 
/* 704 */       (store.getConfig().getTempBreadth() != null) && 
/* 705 */       (store.getConfig().getTempLayer() != null)) {
/* 706 */       Long xx = Long.valueOf(store.getConfig().getTempWidth().longValue() * store.getConfig().getTempBreadth().longValue() * store.getConfig().getTempLayer().longValue());
/*     */       
/* 708 */       if (xx.intValue() == temp.getData().size()) {
/* 709 */         long layers = store.getConfig().getTempLayer().longValue();
/* 710 */         long widths = store.getConfig().getTempWidth().longValue();
/* 711 */         long breadths = store.getConfig().getTempBreadth().longValue();
/* 712 */         List<SjTemperaturePoint> points = new ArrayList();
/*     */         
/* 714 */         for (long x = 0L; x < breadths; x += 1L) {
/* 715 */           for (long y = 0L; y < widths; y += 1L) {
/* 716 */             for (long z = 0L; z < layers; z += 1L) {
/* 717 */               long index = x + y * breadths + z * (breadths * widths);
/* 718 */               SjTemperaturePoint point = new SjTemperaturePoint();
/* 719 */               point.setX(Integer.valueOf((int)x + 1));
/* 720 */               point.setY(Integer.valueOf((int)y + 1));
/* 721 */               point.setZ(Integer.valueOf((int)z + 1));
/* 722 */               point.setCWDBH(String.valueOf(z + 1L));
/* 723 */               point.setCWGBH(String.valueOf(x * widths + y + 1L));
/* 724 */               if (temp.getData().get((int)index) != null) {
/* 725 */                 point.setWDZ(new BigDecimal(((Double)temp.getData().get((int)index)).doubleValue()));
/*     */               } else
/* 727 */                 point.setWDZ(new BigDecimal(64536));
/* 728 */               points.add(point);
/*     */             }
/*     */           }
/*     */         }
/* 732 */         _temp.setPoints(points);
/*     */       }
/*     */     }
/* 735 */     return _temp;
/*     */   }
/*     */   
/*     */   private static double calculateAverage(List<Double> marks) {
/* 739 */     Double sum = Double.valueOf(0.0D);
/* 740 */     if (!marks.isEmpty()) {
/* 741 */       for (Double mark : marks) {
/* 742 */         sum = Double.valueOf(sum.doubleValue() + mark.doubleValue());
/*     */       }
/* 744 */       return sum.doubleValue() / marks.size();
/*     */     }
/* 746 */     return sum.doubleValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengj\\util\ConverterUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */