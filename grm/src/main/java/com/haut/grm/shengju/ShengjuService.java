///*     */ package com.haut.grm.shengju;
///*     */ 
///*     */ import com.fasterxml.jackson.databind.JsonNode;
///*     */ import com.fasterxml.jackson.databind.ObjectMapper;
///*     */ import com.fasterxml.jackson.databind.node.ObjectNode;
///*     */ import com.gdls.sdk.AcpService;
///*     */ import com.gdls.sdk.SDKConfig;
///*     */ import com.gdls.utils.HttpRequest;
///*     */ import com.gdls.utils.JSONUtils;
///*     */ import com.google.common.cache.CacheBuilder;
///*     */ import com.google.common.cache.CacheLoader;
///*     */ import com.google.common.cache.LoadingCache;
///*     */ import com.haut.grm.model.Cargo;
///*     */ import com.haut.grm.model.Company;
///*     */ import com.haut.grm.model.Compartment;
///*     */ import com.haut.grm.model.Depot;
///*     */ import com.haut.grm.model.DeviceCamera;
///*     */ import com.haut.grm.model.Store;
///*     */ import com.haut.grm.model.business.GrainRotate;
///*     */ import com.haut.grm.model.business.StockId;
///*     */ import com.haut.grm.model.business.StockSum;
///*     */ import com.haut.grm.model.dto.TemperatureDataDto;
///*     */ import com.haut.grm.model.entry.EntryMeasure;
///*     */ import com.haut.grm.model.ies.GrainTraffic;
///*     */ import com.haut.grm.model.meta.User;
///*     */ import com.haut.grm.service.CommonService;
///*     */ import com.haut.grm.shengju.model.PseudoRequestEntity;
///*     */ import com.haut.grm.shengju.model.RequestEntity;
///*     */ import com.haut.grm.shengju.model.SjCargo;
///*     */ import com.haut.grm.shengju.model.SjCompany;
///*     */ import com.haut.grm.shengju.model.SjCompartment;
///*     */ import com.haut.grm.shengju.model.SjDepot;
///*     */ import com.haut.grm.shengju.model.SjDeviceCamera;
///*     */ import com.haut.grm.shengju.model.SjFile;
///*     */ import com.haut.grm.shengju.model.SjGrainRotate;
///*     */ import com.haut.grm.shengju.model.SjGrainTraffic;
///*     */ import com.haut.grm.shengju.model.SjMeasure;
///*     */ import com.haut.grm.shengju.model.SjStockSum;
///*     */ import com.haut.grm.shengju.model.SjStore;
///*     */ import com.haut.grm.shengju.model.SjTemperature;
///*     */ import com.haut.grm.shengju.model.SjUser;
///*     */ import com.haut.grm.shengju.util.ConverterUtil;
///*     */ import java.io.File;
///*     */ import java.io.PrintStream;
///*     */ import java.math.BigDecimal;
///*     */ import java.nio.file.Files;
///*     */ import java.util.ArrayList;
///*     */ import java.util.Date;
///*     */ import java.util.List;
///*     */ import java.util.Map;
///*     */ import java.util.UUID;
///*     */ import java.util.concurrent.ExecutionException;
///*     */ import java.util.concurrent.TimeUnit;
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ public class ShengjuService
///*     */ {
///*     */   private static final String IDENTIFIER = "SHUNDE";
///*     */   private static final String VERSION = "2.1";
///*     */   private static final String PASSWORD = "59297cac43a2ae496b01ad5323fc2909";
///*     */   private static final String UPDATE_IDENTIFIER = "U";
///*     */   private static final String INSERT_IDENTIFIER = "I";
///*     */   private static final String DELETE_IDENTIFIER = "D";
///*     */   public static final String ACTION_CREATE = "create";
///*     */   public static final String ACTION_UPDATE = "update";
///*     */   public static final String ACTION_DELETE = "delete";
///*     */   private static final String ROOT_SERVICE_PATH = "https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/";
///*     */   private static final String LOGIN_REQUEST = "LOGIN";
///*     */   private static final String COMPANY_REQUEST = "QYXX";
///*     */   private static final String COMPANY_REQUEST2 = "CCDWXX";
///*     */   private static final String DEPOT_REQUEST = "KQXX";
///*     */   private static final String STORE_REQUEST = "CFXX";
///*     */   private static final String COMPARTMENT_REQUEST = "AJXX";
///*     */   private static final String CARGO_REQUEST = "HWXX";
///*     */   private static final String USER_REQUEST = "DWCYRY";
///*     */   private static final String GRAIN_TRAFFIC_REQUEST = "LSCRKXX";
///*     */   private static final String GRAIN_ROTATE_REQUEST = "CBLYLHSQ";
///*     */   private static final String STOCK_SUM_REQUEST = "LSSSKC";
///*     */   private static final String CAMERA_REQUEST = "SPJKPZ";
///*     */   private static final String MEASURE_REQUEST = "LSSLJC";
///*     */   private static final String TEMPERATURE_REQUEST = "LQJCXXJK";
///*     */   private static final String FILE_REQUEST = "RESOURCE";
///*     */   private static final String IMAGE_PREFFIX = "C:/images/";
///* 110 */   private static ShengjuService singleton = new ShengjuService();
///*     */   private LoadingCache<String, String> tokenCache;
///*     */   
///*     */   private void loadSdk() {
///* 114 */     SDKConfig.getConfig().loadPropertiesFromSrc();
///* 115 */     this.tokenCache = CacheBuilder.newBuilder().expireAfterWrite(12L, TimeUnit.HOURS).build(new CacheLoader() {
///*     */       public String load(String key) {
///* 117 */         return "";
///*     */       }
///*     */     });
///*     */   }
///*     */   
///*     */   private ShengjuService() {
///* 123 */     loadSdk();
///*     */   }
///*     */   
///*     */   public static ShengjuService getInstance() {
///* 127 */     return singleton;
///*     */   }
///*     */   
///*     */   private String getToken() throws Throwable {
///* 131 */     String tokenTmp = null;
///*     */     try {
///* 133 */       tokenTmp = (String)this.tokenCache.get("SHUNDE");
///*     */     } catch (ExecutionException e) {
///* 135 */       tokenTmp = "";
///*     */     }
///* 137 */     if ((tokenTmp == null) || (tokenTmp.equals("")))
///*     */     {
///* 139 */       Map<String, Object> loginMap = (Map)JSONUtils.parse(login(), Map.class);
///* 140 */       String accessToken = (String)loginMap.get("accessToken");
///* 141 */       if ((accessToken != null) && (!"".equals(accessToken))) {
///* 142 */         this.tokenCache.put("SHUNDE", accessToken);
///* 143 */         return accessToken;
///*     */       }
///*     */       
///* 146 */       throw new Exception("登录失败");
///*     */     }
///*     */     
///*     */ 
///* 150 */     return tokenTmp;
///*     */   }
///*     */   
///*     */   private <T> RequestEntity<T> prepareEntity(String action, String requestString, Class<T> type) throws Throwable
///*     */   {
///* 155 */     RequestEntity<T> data = new RequestEntity();
///* 156 */     data.setRequestId(UUID.randomUUID().toString().replace("-", ""));
///* 157 */     data.setSendTime(new Date());
///* 158 */     data.setAccessToken(getToken());
///* 159 */     data.setName(requestString);
///* 160 */     data.setVer("2.1");
///* 161 */     if (action.equals("create"))
///* 162 */       data.setType("I");
///* 163 */     if (action.equals("update"))
///* 164 */       data.setType("U");
///* 165 */     if (action.equals("delete"))
///* 166 */       data.setType("D");
///* 167 */     data.setUsername("SHUNDE");
///* 168 */     return data;
///*     */   }
///*     */   
///*     */   private PseudoRequestEntity preparePseudoEntity(String action, String requestString) throws Throwable {
///* 172 */     PseudoRequestEntity data = new PseudoRequestEntity();
///* 173 */     data.setRequestId(UUID.randomUUID().toString().replace("-", ""));
///* 174 */     data.setSendTime(new Date());
///* 175 */     data.setAccessToken(getToken());
///* 176 */     data.setName(requestString);
///* 177 */     data.setVer("2.1");
///* 178 */     if (action.equals("create"))
///* 179 */       data.setType("I");
///* 180 */     if (action.equals("update"))
///* 181 */       data.setType("U");
///* 182 */     if (action.equals("delete"))
///* 183 */       data.setType("D");
///* 184 */     data.setUsername("SHUNDE");
///* 185 */     return data;
///*     */   }
///*     */   
///*     */   public static void main(String[] args) throws Throwable
///*     */   {
///* 190 */     SDKConfig.getConfig().loadPropertiesFromSrc();
///*     */     
///* 192 */     System.out.println(getInstance().uploadFile("C:\\aa.jpg", "create"));
///*     */   }
///*     */   
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */   public static String login()
///*     */   {
///* 283 */     ObjectMapper mapper = new ObjectMapper();
///*     */     
///* 285 */     ObjectNode data = mapper.createObjectNode();
///* 286 */     data.put("username", "SHUNDE");
///* 287 */     data.put("pwd", "59297cac43a2ae496b01ad5323fc2909");
///*     */     
///* 289 */     return HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/LOGIN", data.toString());
///*     */   }
///*     */   
///*     */   public String uploadFile(String name, String action) throws Throwable {
///* 293 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 294 */       throw new Exception("action参数不正确");
///*     */     }
///* 296 */     RequestEntity<SjFile> data = prepareEntity(action, "RESOURCE", SjFile.class);
///* 297 */     File file = new File("C:/images/" + name.replace("/image/", ""));
///* 298 */     if (!file.canRead()) {
///* 299 */       return null;
///*     */     }
///* 301 */     byte[] array = Files.readAllBytes(file.toPath());
///* 302 */     long size = file.length() * 8L;
///*     */     
///* 304 */     SjFile _file = new SjFile();
///* 305 */     _file.setWJNR(array);
///* 306 */     _file.setMC(file.getName());
///* 307 */     _file.setDX(new BigDecimal(size));
///* 308 */     List<SjFile> files = new ArrayList();
///* 309 */     files.add(_file);
///* 310 */     data.setData(files);
///*     */     
///* 312 */     ObjectMapper mapper = new ObjectMapper();
///* 313 */     String signJson = mapper.writeValueAsString(data);
///* 314 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 315 */     data.setSignature((String)reqData.get("signature"));
///* 316 */     String paramJson = mapper.writeValueAsString(data);
///* 317 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/RESOURCE", paramJson);
///* 318 */     System.out.println("执行uploadFile结果代码：" + res);
///*     */     
///* 320 */     JsonNode jsonNode = mapper.readTree(res);
///* 321 */     return jsonNode.path("description").asText();
///*     */   }
///*     */   
///*     */   public String uploadFile(byte[] content, String action) throws Throwable {
///* 325 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 326 */       throw new Exception("action参数不正确");
///*     */     }
///* 328 */     RequestEntity<SjFile> data = prepareEntity(action, "RESOURCE", SjFile.class);
///*     */     
///* 330 */     SjFile _file = new SjFile();
///* 331 */     _file.setWJNR(content);
///* 332 */     _file.setMC(UUID.randomUUID() + ".jpg");
///* 333 */     _file.setDX(new BigDecimal(content.length * 8));
///* 334 */     List<SjFile> files = new ArrayList();
///* 335 */     files.add(_file);
///* 336 */     data.setData(files);
///*     */     
///* 338 */     ObjectMapper mapper = new ObjectMapper();
///* 339 */     String signJson = mapper.writeValueAsString(data);
///* 340 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 341 */     data.setSignature((String)reqData.get("signature"));
///* 342 */     String paramJson = mapper.writeValueAsString(data);
///* 343 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/RESOURCE", paramJson);
///* 344 */     System.out.println("执行uploadFile结果代码：" + res);
///*     */     
///* 346 */     JsonNode jsonNode = mapper.readTree(res);
///* 347 */     return jsonNode.path("description").asText();
///*     */   }
///*     */   
///*     */   public String sendCompany(Company company, String action) throws Throwable {
///* 351 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 352 */       throw new Exception("action参数不正确");
///*     */     }
///* 354 */     RequestEntity<SjCompany> data = prepareEntity(action, "QYXX", SjCompany.class);
///* 355 */     List<SjCompany> companys = new ArrayList();
///* 356 */     companys.add(ConverterUtil.convertCompany(company, Boolean.valueOf(action.equals("delete"))));
///* 357 */     data.setData(companys);
///*     */     
///* 359 */     ObjectMapper mapper = new ObjectMapper();
///* 360 */     String signJson = mapper.writeValueAsString(data);
///* 361 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 362 */     data.setSignature((String)reqData.get("signature"));
///* 363 */     String paramJson = mapper.writeValueAsString(data);
///* 364 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/QYXX", paramJson);
///* 365 */     System.out.println("执行sendCompany结果代码：" + res);
///* 366 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendCompany2(String action) throws Throwable {
///* 370 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 371 */       throw new Exception("action参数不正确");
///*     */     }
///* 373 */     PseudoRequestEntity data = preparePseudoEntity(action, "CCDWXX");
///* 374 */     String rawData = "[{\"qydm\":\"91440606231956309X\",\"balx\":\"CHGRECORD\",\"ccywlx\":2,\"ccpz\":\"300\",\"sqrq\":1370563200000,\"barq\":1507852800000,\"babh\":\"440606020\",\"bazt\":3,\"nfhzh\":\"20344068100100000002561\",\"cyryrs\":78,\"bgyrs\":14,\"jhyyrs\":5,\"dzysxlrs\":64,\"yzyzgzsrs\":20,\"zjyszcrs\":15,\"kqs\":1,\"lskqs\":1,\"cfs\":28,\"jscr\":108000.00,\"yxcr\":108000.00,\"yzkqs\":0,\"ygs\":0,\"jsrg\":0,\"yxgr\":0,\"sfsc\":0,}]";
///* 375 */     data.setDatas(rawData);
///*     */     
///* 377 */     ObjectMapper mapper = new ObjectMapper();
///* 378 */     Map<String, String> reqData = AcpService.sign(rawData, "UTF-8");
///* 379 */     data.setSignature((String)reqData.get("signature"));
///* 380 */     String paramJson = mapper.writeValueAsString(data);
///* 381 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/CCDWXX", paramJson);
///* 382 */     System.out.println("执行sendCompany2结果代码：" + res);
///* 383 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendDepot(Depot depot, Company company, String action) throws Throwable {
///* 387 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 388 */       throw new Exception("action参数不正确");
///*     */     }
///* 390 */     RequestEntity<SjDepot> data = prepareEntity(action, "KQXX", SjDepot.class);
///* 391 */     List<SjDepot> depots = new ArrayList();
///* 392 */     depots.add(ConverterUtil.convertDepot(depot, company, Boolean.valueOf(action.equals("delete"))));
///* 393 */     data.setData(depots);
///*     */     
///* 395 */     ObjectMapper mapper = new ObjectMapper();
///* 396 */     String signJson = mapper.writeValueAsString(data);
///* 397 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 398 */     data.setSignature((String)reqData.get("signature"));
///* 399 */     String paramJson = mapper.writeValueAsString(data);
///* 400 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/KQXX", paramJson);
///* 401 */     System.out.println("执行sendDepot结果代码：" + res);
///* 402 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendStores(List<Store> stores, Company company, String action) throws Throwable {
///* 406 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 407 */       throw new Exception("action参数不正确");
///*     */     }
///* 409 */     RequestEntity<SjStore> data = prepareEntity(action, "CFXX", SjStore.class);
///* 410 */     data.setData(ConverterUtil.convertStores(stores, company, Boolean.valueOf(action.equals("delete"))));
///*     */     
///* 412 */     ObjectMapper mapper = new ObjectMapper();
///* 413 */     String signJson = mapper.writeValueAsString(data);
///* 414 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 415 */     data.setSignature((String)reqData.get("signature"));
///* 416 */     String paramJson = mapper.writeValueAsString(data);
///* 417 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/CFXX", paramJson);
///* 418 */     System.out.println("执行sendStores结果代码：" + res);
///* 419 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendStore(Store store, Company company, String action) throws Throwable {
///* 423 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 424 */       throw new Exception("action参数不正确");
///*     */     }
///* 426 */     RequestEntity<SjStore> data = prepareEntity(action, "CFXX", SjStore.class);
///* 427 */     List<SjStore> stores = new ArrayList();
///* 428 */     stores.add(ConverterUtil.convertStore(store, company, Boolean.valueOf(action.equals("delete"))));
///* 429 */     data.setData(stores);
///*     */     
///* 431 */     ObjectMapper mapper = new ObjectMapper();
///* 432 */     String signJson = mapper.writeValueAsString(data);
///* 433 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 434 */     data.setSignature((String)reqData.get("signature"));
///* 435 */     String paramJson = mapper.writeValueAsString(data);
///* 436 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/CFXX", paramJson);
///* 437 */     System.out.println("执行sendStore结果代码：" + res);
///* 438 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendCompartments(List<Compartment> compartments, Company company, String action) throws Throwable {
///* 442 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 443 */       throw new Exception("action参数不正确");
///*     */     }
///* 445 */     RequestEntity<SjCompartment> data = prepareEntity(action, "AJXX", SjCompartment.class);
///* 446 */     data.setData(ConverterUtil.convertCompartments(compartments, company, Boolean.valueOf(action.equals("delete"))));
///*     */     
///* 448 */     ObjectMapper mapper = new ObjectMapper();
///* 449 */     String signJson = mapper.writeValueAsString(data);
///* 450 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 451 */     data.setSignature((String)reqData.get("signature"));
///* 452 */     String paramJson = mapper.writeValueAsString(data);
///* 453 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/AJXX", paramJson);
///* 454 */     System.out.println("执行sendCompartments结果代码：" + res);
///* 455 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendCompartment(Compartment compartment, Company company, String action) throws Throwable {
///* 459 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 460 */       throw new Exception("action参数不正确");
///*     */     }
///* 462 */     RequestEntity<SjCompartment> data = prepareEntity(action, "AJXX", SjCompartment.class);
///* 463 */     List<SjCompartment> compartments = new ArrayList();
///* 464 */     compartments.add(ConverterUtil.convertCompartment(compartment, company, Boolean.valueOf(action.equals("delete"))));
///* 465 */     data.setData(compartments);
///*     */     
///* 467 */     ObjectMapper mapper = new ObjectMapper();
///* 468 */     String signJson = mapper.writeValueAsString(data);
///* 469 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 470 */     data.setSignature((String)reqData.get("signature"));
///* 471 */     String paramJson = mapper.writeValueAsString(data);
///* 472 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/AJXX", paramJson);
///* 473 */     System.out.println("执行sendCompartment结果代码：" + res);
///* 474 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendCargoes(List<Cargo> cargoes, Company company, String action) throws Throwable {
///* 478 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 479 */       throw new Exception("action参数不正确");
///*     */     }
///* 481 */     RequestEntity<SjCargo> data = prepareEntity(action, "HWXX", SjCargo.class);
///* 482 */     data.setData(ConverterUtil.convertCargoes(cargoes, company, Boolean.valueOf(action.equals("delete"))));
///*     */     
///* 484 */     ObjectMapper mapper = new ObjectMapper();
///* 485 */     String signJson = mapper.writeValueAsString(data);
///* 486 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 487 */     data.setSignature((String)reqData.get("signature"));
///* 488 */     String paramJson = mapper.writeValueAsString(data);
///* 489 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/HWXX", paramJson);
///* 490 */     System.out.println("执行sendCargoes结果代码：" + res);
///* 491 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendCargo(Cargo cargo, Company company, String action) throws Throwable {
///* 495 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 496 */       throw new Exception("action参数不正确");
///*     */     }
///* 498 */     RequestEntity<SjCargo> data = prepareEntity(action, "HWXX", SjCargo.class);
///* 499 */     List<SjCargo> cargoes = new ArrayList();
///* 500 */     cargoes.add(ConverterUtil.convertCargo(cargo, company, Boolean.valueOf(action.equals("delete"))));
///* 501 */     data.setData(cargoes);
///*     */     
///* 503 */     ObjectMapper mapper = new ObjectMapper();
///* 504 */     String signJson = mapper.writeValueAsString(data);
///* 505 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 506 */     data.setSignature((String)reqData.get("signature"));
///* 507 */     String paramJson = mapper.writeValueAsString(data);
///* 508 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/HWXX", paramJson);
///* 509 */     System.out.println("执行sendCargo结果代码：" + res);
///* 510 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendUsers(List<User> users, Company company, Depot depot, String action) throws Throwable {
///* 514 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 515 */       throw new Exception("action参数不正确");
///*     */     }
///* 517 */     RequestEntity<SjUser> data = prepareEntity(action, "DWCYRY", SjUser.class);
///* 518 */     data.setData(ConverterUtil.convertUsers(users, company, depot, Boolean.valueOf(action.equals("delete"))));
///*     */     
///* 520 */     ObjectMapper mapper = new ObjectMapper();
///* 521 */     String signJson = mapper.writeValueAsString(data);
///* 522 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 523 */     data.setSignature((String)reqData.get("signature"));
///* 524 */     String paramJson = mapper.writeValueAsString(data);
///* 525 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/DWCYRY", paramJson);
///* 526 */     System.out.println("执行sendUsers结果代码：" + res);
///* 527 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendUser(User user, Company company, Depot depot, String action) throws Throwable {
///* 531 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 532 */       throw new Exception("action参数不正确");
///*     */     }
///* 534 */     RequestEntity<SjUser> data = prepareEntity(action, "DWCYRY", SjUser.class);
///* 535 */     List<SjUser> users = new ArrayList();
///* 536 */     users.add(ConverterUtil.convertUser(user, company, depot, Boolean.valueOf(action.equals("delete"))));
///* 537 */     data.setData(users);
///*     */     
///* 539 */     ObjectMapper mapper = new ObjectMapper();
///* 540 */     String signJson = mapper.writeValueAsString(data);
///* 541 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 542 */     data.setSignature((String)reqData.get("signature"));
///* 543 */     String paramJson = mapper.writeValueAsString(data);
///* 544 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/DWCYRY", paramJson);
///* 545 */     System.out.println("执行sendUser结果代码：" + res);
///* 546 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendTemperature(TemperatureDataDto temp, Company company, Store store, Date time, Long id, String action) throws Throwable {
///* 550 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 551 */       throw new Exception("action参数不正确");
///*     */     }
///* 553 */     RequestEntity<SjTemperature> data = prepareEntity(action, "LQJCXXJK", SjTemperature.class);
///* 554 */     List<SjTemperature> temps = new ArrayList();
///* 555 */     temps.add(ConverterUtil.convertTemperature(temp, company, store, time, id));
///* 556 */     data.setData(temps);
///*     */     
///* 558 */     ObjectMapper mapper = new ObjectMapper();
///* 559 */     String signJson = mapper.writeValueAsString(data);
///* 560 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 561 */     data.setSignature((String)reqData.get("signature"));
///* 562 */     String paramJson = mapper.writeValueAsString(data);
///* 563 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/LQJCXXJK", paramJson);
///* 564 */     System.out.println("执行sendTemperature结果代码：" + res);
///* 565 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendMeasure(EntryMeasure measure, Company company, Store store, String action) throws Throwable {
///* 569 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 570 */       throw new Exception("action参数不正确");
///*     */     }
///* 572 */     RequestEntity<SjMeasure> data = prepareEntity(action, "LSSLJC", SjMeasure.class);
///* 573 */     List<SjMeasure> measures = new ArrayList();
///* 574 */     measures.add(ConverterUtil.convertMeasure(measure, company, store));
///* 575 */     data.setData(measures);
///*     */     
///* 577 */     ObjectMapper mapper = new ObjectMapper();
///* 578 */     String signJson = mapper.writeValueAsString(data);
///* 579 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 580 */     data.setSignature((String)reqData.get("signature"));
///* 581 */     String paramJson = mapper.writeValueAsString(data);
///* 582 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/LSSLJC", paramJson);
///* 583 */     System.out.println("执行sendMeasure结果代码：" + res);
///* 584 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendGrainRotate(GrainRotate gr, Company company, String action, CommonService cService) throws Throwable {
///* 588 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 589 */       throw new Exception("action参数不正确");
///*     */     }
///* 591 */     RequestEntity<SjGrainRotate> data = prepareEntity(action, "CBLYLHSQ", SjGrainRotate.class);
///* 592 */     List<SjGrainRotate> grs = new ArrayList();
///* 593 */     grs.add(ConverterUtil.convertGrainRotate(gr, company, cService));
///* 594 */     data.setData(grs);
///*     */     
///* 596 */     ObjectMapper mapper = new ObjectMapper();
///* 597 */     String signJson = mapper.writeValueAsString(data);
///* 598 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 599 */     data.setSignature((String)reqData.get("signature"));
///* 600 */     String paramJson = mapper.writeValueAsString(data);
///* 601 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/CBLYLHSQ", paramJson);
///* 602 */     System.out.println("执行sendGrainRotate结果代码：" + res);
///* 603 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendCamera(DeviceCamera camera, Company company, Depot depot, String action) throws Throwable {
///* 607 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 608 */       throw new Exception("action参数不正确");
///*     */     }
///* 610 */     RequestEntity<SjDeviceCamera> data = prepareEntity(action, "SPJKPZ", SjDeviceCamera.class);
///* 611 */     List<SjDeviceCamera> cameras = new ArrayList();
///* 612 */     cameras.add(ConverterUtil.convertDeviceCamera(camera, company, depot, Boolean.valueOf(action.equals("delete"))));
///* 613 */     data.setData(cameras);
///*     */     
///* 615 */     ObjectMapper mapper = new ObjectMapper();
///* 616 */     String signJson = mapper.writeValueAsString(data);
///* 617 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 618 */     data.setSignature((String)reqData.get("signature"));
///* 619 */     String paramJson = mapper.writeValueAsString(data);
///* 620 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/SPJKPZ", paramJson);
///* 621 */     System.out.println("执行sendCamera结果代码：" + res);
///* 622 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendCameras(List<DeviceCamera> cameras, Company company, Depot depot, String action) throws Throwable {
///* 626 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 627 */       throw new Exception("action参数不正确");
///*     */     }
///* 629 */     RequestEntity<SjDeviceCamera> data = prepareEntity(action, "SPJKPZ", SjDeviceCamera.class);
///* 630 */     data.setData(ConverterUtil.convertDeviceCameras(cameras, company, depot, Boolean.valueOf(action.equals("delete"))));
///*     */     
///* 632 */     ObjectMapper mapper = new ObjectMapper();
///* 633 */     String signJson = mapper.writeValueAsString(data);
///* 634 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 635 */     data.setSignature((String)reqData.get("signature"));
///* 636 */     String paramJson = mapper.writeValueAsString(data);
///* 637 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/SPJKPZ", paramJson);
///* 638 */     System.out.println("执行sendCameras结果代码：" + res);
///* 639 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendStockSum(StockSum sum, Company company, String action, CommonService cService) throws Throwable {
///* 643 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 644 */       throw new Exception("action参数不正确");
///*     */     }
///* 646 */     RequestEntity<SjStockSum> data = prepareEntity(action, "LSSSKC", SjStockSum.class);
///* 647 */     List<SjStockSum> sums = new ArrayList();
///* 648 */     sums.add(ConverterUtil.convertStockSum(sum, company, cService));
///* 649 */     data.setData(sums);
///*     */     
///* 651 */     ObjectMapper mapper = new ObjectMapper();
///* 652 */     String signJson = mapper.writeValueAsString(data);
///* 653 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 654 */     data.setSignature((String)reqData.get("signature"));
///* 655 */     String paramJson = mapper.writeValueAsString(data);
///* 656 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/LSSSKC", paramJson);
///* 657 */     System.out.println("执行sendStockSum结果代码：" + res);
///* 658 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendStockSums(List<StockSum> sums, Company company, String action, CommonService cService) throws Throwable {
///* 662 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 663 */       throw new Exception("action参数不正确");
///*     */     }
///* 665 */     RequestEntity<SjStockSum> data = prepareEntity(action, "LSSSKC", SjStockSum.class);
///* 666 */     data.setData(ConverterUtil.convertStockSums(sums, company, cService));
///*     */     
///* 668 */     ObjectMapper mapper = new ObjectMapper();
///* 669 */     String signJson = mapper.writeValueAsString(data);
///* 670 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 671 */     data.setSignature((String)reqData.get("signature"));
///* 672 */     String paramJson = mapper.writeValueAsString(data);
///* 673 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/LSSSKC", paramJson);
///* 674 */     System.out.println("执行sendStockSums结果代码：" + res);
///* 675 */     return paramJson + "\n" + res;
///*     */   }
///*     */   
///*     */   public String sendGrainTraffics(List<GrainTraffic> gts, Company company, String action, Map<GrainTraffic, StockId> maps, CommonService cService) throws Throwable {
///* 679 */     if ((!action.equals("create")) && (!action.equals("delete")) && (!action.equals("update"))) {
///* 680 */       throw new Exception("action参数不正确");
///*     */     }
///* 682 */     RequestEntity<SjGrainTraffic> data = prepareEntity(action, "LSCRKXX", SjGrainTraffic.class);
///* 683 */     data.setData(ConverterUtil.convertGrainTraffics(gts, company, maps, cService));
///*     */     
///* 685 */     ObjectMapper mapper = new ObjectMapper();
///* 686 */     String signJson = mapper.writeValueAsString(data);
///* 687 */     Map<String, String> reqData = AcpService.sign(signJson, "UTF-8");
///* 688 */     data.setSignature((String)reqData.get("signature"));
///* 689 */     String paramJson = mapper.writeValueAsString(data);
///* 690 */     String res = HttpRequest.post("https://www.gdgrain.gd.gov.cn/gdls-webservice/service/API/LSCRKXX", paramJson);
///* 691 */     System.out.println("执行sendGrainTraffics结果代码：" + res);
///* 692 */     return paramJson + "\n" + res;
///*     */   }
///*     */ }
//
//
///* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\ShengjuService.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       0.7.1
// */