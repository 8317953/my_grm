/*      */ package com.haut.grm.service;
/*      */ 
/*      */ import com.haut.grm.datatables.repository.BalanceSheetDataTablesRepository;
/*      */ import com.haut.grm.datatables.repository.DeductRecordDataTablesRepository;
/*      */ import com.haut.grm.datatables.repository.DeductRuleDataTablesRepository;
/*      */ import com.haut.grm.datatables.repository.WeightSheetDataTablesRepository;
/*      */ import com.haut.grm.model.Cargo;
/*      */ import com.haut.grm.model.Company;
/*      */ import com.haut.grm.model.Compartment;
/*      */ import com.haut.grm.model.Depot;
/*      */ import com.haut.grm.model.DeviceCamera;
/*      */ import com.haut.grm.model.Store;
/*      */ import com.haut.grm.model.StoreStatus;
/*      */ import com.haut.grm.model.business.BusinessNotification;
/*      */ import com.haut.grm.model.business.Contract;
/*      */ import com.haut.grm.model.business.StockChange;
/*      */ import com.haut.grm.model.business.StockChangeEntry;
/*      */ import com.haut.grm.model.business.StockId;
/*      */ import com.haut.grm.model.business.StockSum;
/*      */ import com.haut.grm.model.dto.BalanceDto;
/*      */ import com.haut.grm.model.dto.ContractStockPair;
/*      */ import com.haut.grm.model.dto.WeightDto;
/*      */ import com.haut.grm.model.ies.Analysis;
/*      */ import com.haut.grm.model.ies.BalanceSheet;
/*      */ import com.haut.grm.model.ies.Card;
/*      */ import com.haut.grm.model.ies.DeductRecord;
/*      */ import com.haut.grm.model.ies.DeductRule;
/*      */ import com.haut.grm.model.ies.GrainTraffic;
/*      */ import com.haut.grm.model.ies.IesCameraImage;
/*      */ import com.haut.grm.model.ies.IesCameraRegistry;
/*      */ import com.haut.grm.model.ies.RegisterRecord;
/*      */ import com.haut.grm.model.ies.VehicleLicense;
/*      */ import com.haut.grm.model.ies.VehicleTraffic;
/*      */ import com.haut.grm.model.ies.WeightSheet;
/*      */ import com.haut.grm.model.meta.ActivitiGroup;
/*      */ import com.haut.grm.model.meta.Stage;
/*      */ import com.haut.grm.model.meta.User;
/*      */ import com.haut.grm.model.standalone.LoadCompany;
/*      */ import com.haut.grm.model.type.AnalysisLevel;
/*      */ import com.haut.grm.model.type.AnalysisType;
/*      */ import com.haut.grm.model.type.CameraManufacturer;
/*      */ import com.haut.grm.model.type.CardType;
/*      */ import com.haut.grm.model.type.CargoStatus;
/*      */ import com.haut.grm.model.type.PackageType;
/*      */ import com.haut.grm.model.type.PlanType;
/*      */ import com.haut.grm.model.type.SourceType;
/*      */ import com.haut.grm.model.type.SpaceStatus;
/*      */ import com.haut.grm.model.type.TrafficType;
/*      */ import com.haut.grm.repository.CargoRepository;
/*      */ import com.haut.grm.repository.CompanyRepository;
/*      */ import com.haut.grm.repository.StoreRepository;
/*      */ import com.haut.grm.repository.business.StockChangeRepository;
/*      */ import com.haut.grm.repository.business.StockIdRepository;
/*      */ import com.haut.grm.repository.business.StockSumRepository;
/*      */ import com.haut.grm.repository.ies.AnalysisRepository;
/*      */ import com.haut.grm.repository.ies.CardRepository;
/*      */ import com.haut.grm.repository.ies.ContractRepository;
/*      */ import com.haut.grm.repository.ies.GrainTrafficRepository;
/*      */ import com.haut.grm.repository.ies.IesCameraImageRepository;
/*      */ import com.haut.grm.repository.ies.IesCameraRegistryRepository;
/*      */ import com.haut.grm.repository.ies.RegisterRecordRepository;
/*      */ import com.haut.grm.repository.ies.VehicleLicenseRepository;
/*      */ import com.haut.grm.repository.ies.VehicleTrafficRepository;
/*      */ import com.haut.grm.repository.meta.ActivitiGroupRepository;
/*      */ import com.haut.grm.repository.meta.StageRepository;
/*      */ import com.haut.grm.repository.meta.UserRepository;
/*      */ import com.haut.grm.repository.standalone.LoadCompanyRepository;
/*      */ import com.haut.grm.repository.type.AnalysisLevelRepository;
/*      */ import com.haut.grm.repository.type.AnalysisTypeRepository;
/*      */ import com.haut.grm.repository.type.CardTypeRepository;
/*      */ import com.haut.grm.repository.type.CargoStatusRepository;
/*      */ import com.haut.grm.repository.type.PackageTypeRepository;
/*      */ import com.haut.grm.repository.type.PlanTypeRepository;
/*      */ import com.haut.grm.repository.type.SourceTypeRepository;
/*      */ import com.haut.grm.repository.type.SpaceStatusRepository;
/*      */ import com.haut.grm.repository.type.TrafficTypeRepository;
///*      */ import com.haut.grm.sdk.DjhuaCamera;
/*      */ import com.haut.grm.sdk.HkCamera;
/*      */ import com.haut.grm.sdk.KdCamera;
///*      */ import com.haut.grm.shengju.ShengjuService;
/*      */ import com.haut.grm.util.BarCodeUtil;
///*      */ import com.haut.grm.util.LEDUtil;
/*      */ import com.haut.grm.util.SMSUtil;
/*      */ import com.haut.grm.util.ScaleSocketUtil;
/*      */ import com.haut.grm.util.TemplateUtil;

import ceshi.MyShoot;
import ceshi.bx05_demo;

/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;

import javax.servlet.ServletContext;

/*      */ import org.apache.commons.io.FilenameUtils;
/*      */ import org.joda.time.DateTime;
/*      */ import org.springframework.beans.factory.annotation.Autowired;
/*      */ import org.springframework.stereotype.Service;
/*      */ import org.springframework.web.multipart.MultipartFile;
/*      */ 

/*      */ @Service
/*      */ public class TrafficService
/*      */ {
/*      */   @Autowired
/*      */   private VehicleTrafficRepository vtRepo;
/*      */   @Autowired
/*      */   private CompanyRepository companyRepo;
/*      */   @Autowired
/*      */   private BusinessService bService;
/*      */   @Autowired
/*      */   private RegisterRecordRepository rrRepo;
/*      */   @Autowired
/*      */   private SourceTypeRepository stRepo;
/*      */   @Autowired
/*      */   private GrainTrafficRepository gtRepo;
/*      */   @Autowired
/*      */   private ContractRepository contractRepo;
/*      */   @Autowired
/*      */   private StageRepository stageRepo;
/*      */   @Autowired
/*      */   private StockChangeRepository scRepo;
/*      */   @Autowired
/*      */   private TrafficTypeRepository ttRepo;
/*      */   @Autowired
/*      */   private PackageTypeRepository ptRepo;
/*      */   @Autowired
/*      */   private AnalysisRepository aRepo;
/*      */   @Autowired
/*      */   private AnalysisTypeRepository atRepo;
/*      */   @Autowired
/*      */   private CardTypeRepository ctRepo;
/*      */   @Autowired
/*      */   private CardRepository cardRepo;
/*      */   @Autowired
/*      */   private AnalysisLevelRepository alRepo;
/*      */   @Autowired
/*      */   private DeductRuleDataTablesRepository druleRepo;
/*      */   @Autowired
/*      */   private DeductRecordDataTablesRepository drecordRepo;
/*      */   @Autowired
/*      */   private PlanTypeRepository planTypeRepo;
/*      */   @Autowired
/*      */   private UserRepository userRepo;
/*      */   @Autowired
/*      */   private StoreRepository storeRepo;
/*      */   @Autowired
/*      */   private BalanceSheetDataTablesRepository bsRepo;
/*      */   @Autowired
/*      */   private WeightSheetDataTablesRepository wsRepo;
/*      */   @Autowired
/*      */   private CargoRepository cargoRepo;
/*      */   @Autowired
/*      */   private CargoStatusRepository csRepo;
/*      */   @Autowired
/*      */   private SpaceStatusRepository spsRepo;
/*      */   @Autowired
/*      */   private CommonService commonService;
/*      */   @Autowired
/*      */   private StockIdRepository siRepo;
/*      */   @Autowired
/*      */   private StockSumRepository ssRepo;
/*      */   @Autowired
/*      */   private ActivitiGroupRepository agRepo;
/*      */   @Autowired
/*      */   private LoadCompanyRepository lcRepo;
/*      */   @Autowired
/*      */   private VehicleLicenseRepository vlRepo;
/*      */   @Autowired
/*      */   private IesCameraImageRepository iesCameraImageRepository;
/*      */   @Autowired
/*      */   private IesCameraRegistryRepository iesCameraRegistryRepository;
/*      */   



public TrafficService() {
	MyShoot.myInit();
	bx05_demo.myInit();
}



public void turnOnLed() {
	bx05_demo.turnOn();
}

public void turnOffLed() {
	bx05_demo.turnOff();
}


public void sendLedText(String str) {
	try {
		bx05_demo.SendProgram(str);
	} catch (Exception e) {
		System.out.println("led发送text失败");
		e.printStackTrace();
	}
}





/*      */   public List<VehicleTraffic> getVehicleTrafficsFiltered(String filter)
/*      */   {
/*  202 */     return this.vtRepo.queryAvailable(filter, new Date());
/*      */   }
/*      */   
/*      */   public List<VehicleTraffic> getVehicleTrafficsRegisterableFiltered(String filter) {
/*  206 */     return this.vtRepo.queryRegisterable(filter, new Date());
/*      */   }
/*      */   
/*      */   public List<VehicleTraffic> getVehicleTrafficsAvailable() {
/*  210 */     return this.vtRepo.getAvailable(new Date());
/*      */   }
/*      */   
/*      */   public List<VehicleTraffic> getVehicleTrafficsRegisterable() {
/*  214 */     return this.vtRepo.getRegisterable(new Date());
/*      */   }
/*      */   
/*      */   public List<VehicleTraffic> getRecent3VehicleTraffics() {
/*  218 */     return this.vtRepo.getAvailableTop3(new Date());
/*      */   }
/*      */   
/*      */   public VehicleTraffic createVehicleTraffic(VehicleTraffic vehicleTraffic) {
/*  222 */     return (VehicleTraffic)this.vtRepo.save(vehicleTraffic);
/*      */   }
/*      */   
/*      */   public RegisterRecord createRegisterRecord(RegisterRecord registerRecord) {
/*  226 */     registerRecord.setManager(AuthUserService.getCurrentUser(userRepo));
/*  227 */     registerRecord.setTime(new Date());
/*  228 */     return (RegisterRecord)this.rrRepo.save(registerRecord);
/*      */   }
/*      */   
/*      */   public RegisterRecord getRegisterRecordByCardCode(String cardCode) {
/*  232 */     return this.rrRepo.findTop1ByCardCodeOrderByTimeDesc(cardCode);
/*      */   }
/*      */   
/*      */   public GrainTraffic createGrainTraffic(GrainTraffic grainTraffic) {
/*  236 */     return (GrainTraffic)this.gtRepo.save(grainTraffic);
/*      */   }
/*      */   
/*      */   public List<Contract> getContractsFiltered(String filter) {
/*  240 */     return 
/*  241 */       this.contractRepo.findByBusinessKeyContainingOrNameContainingOrClient_NameContainingOrGrainVariety_NameContaining(filter, filter, filter, filter);
/*      */   }
/*      */   
/*      */   public GrainTraffic createGrainTraffic(String cardCode, RegisterRecord rr) {
	
	//-----------------------RegisterRecord 驾驶员身份信息
				//pic身份证头像     驾驶员身份信息存储
/*  245 */     rr.setManager(AuthUserService.getCurrentUser(userRepo));
/*      */     
/*  247 */     rr.setTime(new Date());
/*  248 */     rr = (RegisterRecord)this.rrRepo.save(rr);


				
//-------------------------VehicleTraffic  车辆信息
/*  249 */     VehicleTraffic vt = rr.getVehicleTraffic();
/*  250 */     vt.setIn(Boolean.valueOf(true));//设置登记到库属性 并在接下来  进行update 进入信息废除  登记即认为在库  并且 在未出库之间即认为在库
/*  251 */     vt.setRegistered(Boolean.valueOf(true));
/*  252 */     this.vtRepo.save(vt);
/*      */   //这一步的车辆信息在之前调度单时已经录入  此步只是修改 车辆的状态 即是否入库     



//---------------------------GrainTraffic出入库
/*  254 */     Contract c = rr.getVehicleTraffic().getContract();
/*      */     
/*  256 */     GrainTraffic gt = new GrainTraffic();
/*  257 */     if (c != null) {
	
					//一个格式表获取格式matcher
/*  258 */       String formatter = this.commonService.getSystemVariableWithKey("GRAIN_TRAFFIC_FORMATTER");
/*  259 */       formatter = (c.getIsIngress().booleanValue() ? "入库" : "出库") + formatter;
					System.out.println(this.bService.getBusinessKeyForSc(formatter));

/*  260 */       gt.setCode(this.bService.getBusinessKeyForSc(formatter));
/*  261 */       gt.setContract(c);
/*  262 */       gt.setIsIngress(c.getIsIngress());//根据合同类型 决定出入库类型
/*      */     }
			//修改卡是不是在用
/*  264 */     updateCardUsing(cardCode, Boolean.valueOf(true));

			//获取卡对象 不包含详细库相关信息 只是一些卡本身的如物理ID 是否可用 是否在用等信息
/*  265 */     Card card = getCardByPhysical(cardCode);
/*  266 */     gt.setStage(this.stageRepo.findByValue(Integer.valueOf(1)));//根据value值定位出入库状态节点信息 说白了就是step 到哪一步了
/*  267 */     gt.setTime(new Date());
/*  268 */     gt.setRegisterRecord(rr);
/*  269 */     gt.setIsFinished(Boolean.valueOf(false));



//---------------------发送 流程节点弹框信息--------------
/*  270 */     generateNotifForTraffic(gt);//发送 流程节点弹框信息



//---------------------发送短信提示-----------------------
/*  271 */     if (this.commonService.moduleActive("GSM")) {
/*      */       try {
/*  273 */         String content = "";
/*  274 */         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年M月d日HH:mm:ss");
/*  275 */         content = "承运人[" + gt.getRegisterRecord().getPersonnelName().trim() + "] 车牌[" + gt.getRegisterRecord().getVehicleTraffic().getPlate() + "] \n" + 
/*  276 */           "您此次出入库的智能卡号为: " + card.getPrintNumber() + " 出入库单号为: " + gt.getCode() + " " + 
/*  277 */           dateFormat.format(new Date());
/*      */         
/*  279 */         if (gt.getRegisterRecord().getTelephone() != null)
/*  280 */           SMSUtil.sendMessage(gt.getRegisterRecord().getTelephone(), content);
/*      */       } catch (Exception e) {
/*  282 */         e.printStackTrace();
/*      */       }
/*      */     }

//-------------------------设备抓图 可能也会有车牌识别这一部分暂时不考虑 9月18 19 把设备接入----------------------------------------
/*  285 */     snapshotForTrafficCode(gt, "REGISTER");



//---------------------------出入库单创建------------------------------
/*  286 */     return (GrainTraffic)this.gtRepo.save(gt);
/*      */   }
/*      */   
/*      */   public GrainTraffic updateGrainTrafficCardCode(String cardCode, String cardCode2) {
/*  290 */     GrainTraffic gt = this.gtRepo.findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(cardCode);
/*  291 */     RegisterRecord rr = gt.getRegisterRecord();
/*  292 */     rr.setCardCode(cardCode2);
/*  293 */     this.rrRepo.save(rr);
/*  294 */     updateCardActive(cardCode, Boolean.valueOf(true));
/*  295 */     updateCardActive(cardCode2, Boolean.valueOf(true));
/*  296 */     updateCardUsing(cardCode, Boolean.valueOf(false));
/*  297 */     updateCardUsing(cardCode2, Boolean.valueOf(true));
/*  298 */     return null;
/*      */   }
/*      */   
/*      */   public List<TrafficType> getAllTrafficTypes() {
/*  302 */     return this.ttRepo.findAll();
/*      */   }
/*      */   
/*      */   public List<PackageType> getAllPackageTypes() {
/*  306 */     return this.ptRepo.findAll();
/*      */   }
/*      */   
/*      */   public void updateGrainTrafficStage(String code, Integer officialId) {
/*  310 */     GrainTraffic gt = this.gtRepo.findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(code);
/*  311 */     gt.setStage(this.stageRepo.findByValue(officialId));
/*  312 */     if (officialId.equals(Integer.valueOf(1))) {
/*  313 */       updateCardUsing(gt.getRegisterRecord().getCardCode(), Boolean.valueOf(false));
/*      */     }
/*  315 */     this.gtRepo.save(gt);
/*      */   }
/*      */   
/*      */   public void updateGrainTrafficStage(GrainTraffic gt, Integer officialId) {
/*  319 */     gt.setStage(this.stageRepo.findByValue(officialId));
/*  320 */     this.gtRepo.save(gt);
/*      */   }
/*      */   
/*      */   public Analysis createAnalysis(String cardCode) {
	System.out.println("cardCode:"+cardCode);
	//---------------------------扦样时已经生成了近似于空的化验信息 并与出入库单 建立了关联
/*  324 */     GrainTraffic gt = this.gtRepo.findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(cardCode); //获取入库单
System.out.println("ui1");
/*  325 */     Analysis a = new Analysis();
/*  326 */     a.setSampler(AuthUserService.getCurrentUser(userRepo));
/*  327 */     a.setSampleTime(new Date());
System.out.println(BarCodeUtil.getValidBarCodeRaw(this.aRepo));
/*  328 */     a.setBarcode(BarCodeUtil.getValidBarCodeRaw(this.aRepo));
/*  329 */     gt.setAnalysis(a);
System.out.println("ui2");
/*  330 */     a = (Analysis)this.aRepo.save(a);//生成一条化验数据 --------------创建
System.out.println("ui3");
/*  331 */     gt.setStage(this.stageRepo.findByValue(Integer.valueOf(2)));
/*  332 */     gt.setAllowStage(Integer.valueOf(2));
/*  333 */     this.gtRepo.save(gt);//入库单关联上化验数据    -------------修改
/*  334 */     generateNotifForTraffic(gt);//发送弹框信息
/*  335 */     snapshotForTrafficCode(gt, "SAMPLE"); //抓图
/*  336 */     return a;
/*      */   }
/*      */   
/*      */   public String getBase64EncryptedBarCode(String cardCode) throws Exception {
///*  340 */     return BarCodeUtil.encrypt(this.gtRepo
///*  341 */       .findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(cardCode).getAnalysis()
///*  342 */       .getBarcode());
				return this.gtRepo.findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(cardCode).getAnalysis().getBarcode();
/*      */   }
/*      */   
/*      */   public GrainTraffic getGrainTraffic(String cardCode) {
/*  346 */     return this.gtRepo.findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(cardCode);
/*      */   }
/*      */   
/*      */   public GrainTraffic getGrainTrafficByBarcode(String barcode) {
/*  350 */     return this.gtRepo.findTop1ByAnalysis_Barcode(barcode);
/*      */   }
/*      */   
/*      */   public GrainTraffic getGrainTrafficByEncryptedBarcode(String barcode) throws Exception
/*      */   {
///*  355 */     return this.gtRepo.findTop1ByAnalysis_Barcode(BarCodeUtil.decrypt(barcode));
	return this.gtRepo.findTop1ByAnalysis_Barcode(barcode);
/*      */   }
/*      */   
/*      */   public void updateAnalysis(Analysis a) throws Exception {
	
/*  359 */     GrainTraffic gt = getGrainTrafficByBarcode(a.getBarcode());//获取出入库单

/*  360 */     if ((gt.getIsIngress().booleanValue()) && (gt.getStage().getValue().equals(Integer.valueOf(2)))) {//是不是在库 当前stage是不是扦样
/*  361 */       a.setAnalyst(AuthUserService.getCurrentUser(userRepo));
/*  362 */       a.setAnalysisTime(new Date());
/*  363 */       if (a.getPass().booleanValue()) {//如果是合格的
/*  364 */         gt.setStage(this.stageRepo.findByValue(Integer.valueOf(3)));//设置当前stage  为化验
/*  365 */         generateNotifForTraffic(gt);//发送弹框信息
/*      */       }
/*  367 */       if (!a.getPass().booleanValue())
/*  368 */         gt.setStage(this.stageRepo.findByValue(Integer.valueOf(-6)));//设置当前stage  为化验不合格

//-----------------修改化验结果数据 并且 设置到出入库单中
/*  369 */       gt.setAnalysis((Analysis)this.aRepo.save(a));


//-----------------修改出入库单数据 
/*  370 */       this.gtRepo.save(gt);

//--------------------抓图
/*  371 */       snapshotForTrafficCode(gt, "ANALYSIS");
/*  372 */       if (a.getDone().booleanValue()) {
/*      */         try {
	
	//---------------------led显示屏
///*  374 */           LEDUtil.sendLED(gt);
/*      */         } catch (Exception e) {
/*  376 */           e.printStackTrace();
/*      */         }
/*  378 */         if (this.commonService.moduleActive("GSM")) {
/*      */           try {
	
	//---------------------------发送短信
/*  380 */             if (a.getPass().booleanValue()) {
/*  381 */               SMSUtil.sendMessage(gt.getRegisterRecord().getTelephone(), TemplateUtil.generateAnalysisSms(this.commonService.getSystemVariableWithKey("ANALYSIS_PASS_SMS"), gt));
/*      */             } else
/*  383 */               SMSUtil.sendMessage(gt.getRegisterRecord().getTelephone(), TemplateUtil.generateAnalysisSms(this.commonService.getSystemVariableWithKey("ANALYSIS_NOT_PASS_SMS"), gt));
/*      */           } catch (Exception e) {
/*  385 */             e.printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*  389 */     } else if (gt.getIsIngress().booleanValue()) {//如果不在库里就没那么多事了直接 保存 检验表 和出入库单 表就可以了
/*  390 */       Analysis an = gt.getAnalysis();
/*  391 */       an.setA2(a.getA2());
/*  392 */       an.setA4(a.getA4());
/*  393 */       an.setA5(a.getA5());
/*  394 */       an.setA6(a.getA6());
/*  395 */       an.setA7(a.getA7());
/*  396 */       an.setA8(a.getA8());
/*  397 */       an.setA9(a.getA9());
/*  398 */       an.setA10(a.getA10());
/*  399 */       an.setA11(a.getA11());
/*  400 */       an.setA12(a.getA12());
/*  401 */       an.setA13(a.getA13());
/*  402 */       an.setA14(a.getA14());
/*  403 */       an.setA15(a.getA15());
/*  404 */       an.setA16(a.getA16());
/*  405 */       an.setA17(a.getA17());
/*  406 */       an.setS1(a.getS1());
/*  407 */       an.setS2(a.getS2());
/*  408 */       an.setS3(a.getS3());
/*  409 */       gt.setAnalysis((Analysis)this.aRepo.save(an));
/*  410 */       this.gtRepo.save(gt);
/*      */     }
/*      */     else {
/*  413 */       throw new Exception("出入库单状态不允许更改化验结果");
/*      */     }
/*      */   }
/*      */   
///*  417 */   public void generateStockChangeFromGrainTrafficIn24HoursAtDate(Date date) { 
//				Date lastDate = new DateTime(date).minusDays(1).toDate();
//
////------------------获取出入库单list集合------------------------------------------
///*  418 */     List<GrainTraffic> gts = this.gtRepo.findByOutTimeBetweenAndIsFinishedAndStage_Value(lastDate, date, true, Integer.valueOf(11));
///*  419 */     Map<GrainTraffic, StockId> maps = new HashMap();//出入库单 与虚拟货位
///*  420 */     Set<ContractStockPair> csPairs = new HashSet();//合同&虚拟货位 对象集合
///*  421 */     StockId stock; 
//			   for (GrainTraffic gt : gts) {
///*  422 */       stock = this.siRepo.currentCargo((Long)gt.getWeightSheet().getCargo().getId());  //获取当前在用货位gt.getWeightSheet().getCargo().getId()
//                 //最近一次的虚拟货位
///*  423 */       maps.put(gt, stock);//将查到的最近一次货位  和  出入库单放入map中
///*  424 */       if ((stock != null) && (gt.getContract() != null) && (gt.getWeightSheet() != null))
///*  425 */         csPairs.add(new ContractStockPair(gt.getContract(), stock)); //虚拟货位  与合同信息 绑定 放在对象 存入set集合中 
///*  426 */       if ((gt.getSecondWeightSheet() != null) && (gt.getSecondContract() != null)) {//三磅 绑定货位  存入set集合
///*  427 */         StockId stock2 = this.siRepo.currentCargo((Long)gt.getSecondWeightSheet().getCargo().getId());
///*  428 */         if (stock2 != null)
///*  429 */           csPairs.add(new ContractStockPair(gt.getSecondContract(), stock2));
///*      */       }
///*      */     }
///*  432 */     int count = 0;//计数
///*  433 */     for (ContractStockPair csPair : csPairs) {
///*  434 */       count++;
///*  435 */       StockId stock1 = csPair.getStock();//获取最近一次虚拟货位
///*  436 */       StockSum stockSum = (StockSum)this.ssRepo.findOne((Long)stock1.getId());//获取视图信息  主要似乎是用其  检验信息
///*  437 */       Contract contract = csPair.getContract();//获取合同
///*  438 */       StockChange sc = new StockChange();//创建 stockcchange 空对象
///*  439 */       sc.setPackageCategory(stock1.getPackageCategory());//设置
///*  440 */       sc.setContract(contract);
///*  441 */       sc.setGrainType(stock1.getGrainType());
///*  442 */       sc.setGrainVariety(contract.getGrainVariety());
///*  443 */       sc.setInputComment("智能出入库系统自动生成");
///*  444 */       sc.setInputTime(new DateTime(lastDate).plusSeconds(count).toDate());
//
////-------------------设置
///*  445 */       if (contract.getIsIngress().booleanValue()) {
//	//如果是入库单--------设置这个虚拟货位为目标货位
///*  446 */         sc.setTargetStock(stock1);
///*  447 */         stock1.setInTime(lastDate);//设置
///*  448 */         sc.setBusinessKey(this.bService.getBusinessKeyForSc("(" + stock1.getCargo().getCompartment().getStore().getDepot().getKeyword() + ")入%Y%04d", lastDate));
///*  449 */         sc.setType((SourceType)this.stRepo.findByCodeId(Integer.valueOf(2)));
///*      */       }
///*      */       else {
//	//否则是出库单------------------------设置该货位为源货位
///*  452 */         stock1.setOutTime(new DateTime(lastDate).plusSeconds(count).toDate());
///*  453 */         sc.setSourceStock(stock1);
///*  454 */         sc.setBusinessKey(this.bService.getBusinessKeyForSc("(" + stock1.getCargo().getCompartment().getStore().getDepot().getKeyword() + ")出%Y%04d", lastDate));
///*  455 */         sc.setType((SourceType)this.stRepo.findByCodeId(Integer.valueOf(3)));
///*      */       }
////说白了 就是他映射也有表----------------------------------------------------
///*  457 */       List<StockChangeEntry> entries = new ArrayList();//创建stockchange list
///*  458 */       AnalysisLevel aLevel = null;
///*  459 */       for (GrainTraffic gt : gts) {
///*  460 */         if ((gt.getContract() != null) && (gt.getContract().equals(contract)) && (gt.getWeightSheet() != null) && (gt.getWeightSheet().getCargo().equals(stock1.getCargo()))) {
///*  461 */           
//					 WeightSheet ws = gt.getWeightSheet();//获取出入库单中
//					 //计算净重
///*  462 */           Double amount = Double.valueOf(Math.abs(ws.getFirstWeight().doubleValue() - ws.getSecondWeight().doubleValue() - ws.getDeductWeight().doubleValue()));
///*  463 */           if (amount.longValue() > 0L) {
///*  464 */             StockChangeEntry entry = new StockChangeEntry();
///*  465 */             if ((ws.getPack() != null) && (ws.getPackPerWeight() != null)) {
///*  466 */               amount = Double.valueOf(amount.doubleValue() - Math.round(ws.getPack().longValue() * ws.getPackPerWeight().doubleValue()));
///*      */             }
///*  468 */             entry.setAmount(Long.valueOf(amount.longValue()));
///*  469 */             entry.setPack(ws.getPack());
///*  470 */             entry.setPlate(gt.getRegisterRecord().getVehicleTraffic().getPlate());
///*  471 */             if (contract.getIsIngress().booleanValue()) {//入库检验
///*  472 */               entry.setWater(gt.getAnalysis().getA1());
///*  473 */               entry.setImpurity(gt.getAnalysis().getA3());
///*  474 */               entry.setYear(gt.getAnalysis().getYear());
///*  475 */               entry.setLocation(gt.getAnalysis().getLocation());
///*  476 */               if ((gt.getAnalysis().getAnalysisLevel() != null) && (
///*  477 */                 (aLevel == null) || (gt.getAnalysis().getAnalysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
///*  478 */                 aLevel = gt.getAnalysis().getAnalysisLevel();
///*      */               }
///*      */             }
///*      */             else
///*      */             {//出库或者没有 检验信息的情况下 赋值  当前 虚拟货位 的之前的检验信息
///*  483 */               entry.setWater(stockSum.getL_a1());
///*  484 */               entry.setImpurity(stockSum.getL_a3());
///*  485 */               entry.setYear(stockSum.getYear());
///*  486 */               entry.setLocation(stockSum.getLocation());
///*  487 */               if ((stockSum.getL_analysisLevel() != null) && (
///*  488 */                 (aLevel == null) || (stockSum.getL_analysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
///*  489 */                 aLevel = stockSum.getL_analysisLevel();
///*      */               }
///*      */             }
///*      */             
///*  493 */             entries.add(entry);
///*      */           }
///*      */         }
//
//
////有三磅的信息
///*  496 */         if ((gt.getSecondContract() != null) && (gt.getSecondContract().equals(contract)) && (gt.getSecondWeightSheet() != null) && (gt.getSecondWeightSheet().getCargo().equals(stock1.getCargo()))) {
///*  497 */           WeightSheet ws = gt.getSecondWeightSheet();
///*  498 */           Double amount = Double.valueOf(Math.abs(ws.getFirstWeight().doubleValue() - ws.getSecondWeight().doubleValue() - ws.getDeductWeight().doubleValue()));
///*      */           
///*  500 */           if (amount.longValue() > 0L) {
///*  501 */             StockChangeEntry entry = new StockChangeEntry();
///*  502 */             if ((ws.getPack() != null) && (ws.getPackPerWeight() != null)) {
///*  503 */               amount = Double.valueOf(amount.doubleValue() - Math.round(ws.getPack().longValue() * ws.getPackPerWeight().doubleValue()));
///*      */             }
///*  505 */             entry.setAmount(Long.valueOf(amount.longValue()));
///*  506 */             entry.setPack(ws.getPack());
///*  507 */             entry.setPlate(gt.getRegisterRecord().getVehicleTraffic().getPlate());
///*  508 */             if (contract.getIsIngress().booleanValue()) {
///*  509 */               entry.setWater(gt.getAnalysis().getA1());
///*  510 */               entry.setImpurity(gt.getAnalysis().getA3());
///*  511 */               entry.setYear(gt.getAnalysis().getYear());
///*  512 */               entry.setLocation(gt.getAnalysis().getLocation());
///*  513 */               if ((gt.getAnalysis().getAnalysisLevel() != null) && (
///*  514 */                 (aLevel == null) || (gt.getAnalysis().getAnalysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
///*  515 */                 aLevel = gt.getAnalysis().getAnalysisLevel();
///*      */               }
///*      */             }
///*      */             else
///*      */             {
///*  520 */               entry.setWater(stockSum.getL_a1());
///*  521 */               entry.setImpurity(stockSum.getL_a3());
///*  522 */               entry.setYear(stockSum.getYear());
///*  523 */               entry.setLocation(stockSum.getLocation());
///*  524 */               if ((stockSum.getL_analysisLevel() != null) && (
///*  525 */                 (aLevel == null) || (stockSum.getL_analysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
///*  526 */                 aLevel = stockSum.getL_analysisLevel();
///*      */               }
///*      */             }
///*      */             
///*  530 */             entries.add(entry);
///*      */           }
///*      */         }
///*      */       }
//
//
//
//
///*  534 */       Double wa = Double.valueOf(0.0D);
///*  535 */       Double ia = Double.valueOf(0.0D);
///*  536 */       Long pack = Long.valueOf(0L);
///*  537 */       Long amount = Long.valueOf(0L);
///*  538 */       for (StockChangeEntry entry : entries) {
///*  539 */         if (entry.getPack() != null) {
///*  540 */           pack = Long.valueOf(pack.longValue() + entry.getPack().longValue());
///*      */         }
///*  542 */         if (entry.getAmount() != null) {
///*  543 */           amount = Long.valueOf(amount.longValue() + entry.getAmount().longValue());
///*      */         }
///*  545 */         if (entry.getWater() != null) {
///*  546 */           wa = Double.valueOf(wa.doubleValue() + entry.getWater().doubleValue() * entry.getAmount().longValue());
///*      */         }
///*  548 */         if (entry.getImpurity() != null) {
///*  549 */           ia = Double.valueOf(ia.doubleValue() + entry.getImpurity().doubleValue() * entry.getAmount().longValue());
///*      */         }
///*      */       }
///*  552 */       if (amount.longValue() != 0L) {
///*  553 */         sc.setWater(Double.valueOf(wa.doubleValue() / amount.longValue()));
///*      */       }
///*  555 */       if (amount.longValue() != 0L) {
///*  556 */         sc.setImpurity(Double.valueOf(ia.doubleValue() / amount.longValue()));
///*      */       }
///*  558 */       sc.setAnalysisLevel(aLevel);
///*  559 */       sc.setAmount(amount);
///*  560 */       sc.setPack(pack);
///*  561 */       sc.setEntries(entries);//这里他将entry的集合设置进去 也就是 存储的时候有可能 也将其存储进去
///*  562 */       this.scRepo.save(sc);
///*  563 */       this.siRepo.save(stock1);
///*      */     }
///*  565 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///*      */     try {
/////*  567 */       ShengjuService.getInstance().sendGrainTraffics(gts, company, "create", maps, this.commonService);
///*      */     } catch (Throwable e) {
///*  569 */       System.out.println("每日出入库单汇总上传省局失败");
///*  570 */       e.printStackTrace();
///*      */     }
///*      */   }













//	public void generateStockChangeFromGrainTrafficIn_myself() {
//
////------------------获取出入库单list集合------------------------------------------
//
//		List<GrainTraffic> gts=this.gtRepo.findAll();
////		Map<GrainTraffic, StockId> maps = new HashMap();//出入库单 与虚拟货位//map基本没什么用 只是用来上传省局
//		Set<ContractStockPair> csPairs = new HashSet();//合同&虚拟货位 对象集合
//		StockId stock; 
//		for (GrainTraffic gt : gts) {
//			System.out.println("l-----------------");
//			stock = this.siRepo.currentCargo((Long)gt.getWeightSheet().getCargo().getId());  //获取当前在用货位gt.getWeightSheet().getCargo().getId()
//     //最近一次的虚拟货位
////			maps.put(gt, stock);//将查到的最近一次货位  和  出入库单放入map中
//			if ((stock != null) && (gt.getContract() != null) && (gt.getWeightSheet() != null)) {
//				csPairs.add(new ContractStockPair(gt.getContract(), stock)); //虚拟货位  与合同信息 绑定 放在对象 存入set集合中   虚拟货位说白了就是货位信息
//				System.out.println("add-----------------");
//			}
//        
//			if ((gt.getSecondWeightSheet() != null) && (gt.getSecondContract() != null)) {//三磅 绑定货位  存入set集合
//				StockId stock2 = this.siRepo.currentCargo((Long)gt.getSecondWeightSheet().getCargo().getId());//获取三磅货位
//				if (stock2 != null) {
//					csPairs.add(new ContractStockPair(gt.getSecondContract(), stock2));//三磅货位与三磅合同绑定
//				}
//     
//			}
//		}
//		//以上注意 set不会 重复存储相同的对象 按照上面 所示 似乎 即使是属性完全相同 也会视为  相同对象
//		//原来该对象 重写了equal方法
//		//也就是说 相同 货位 相同合同 一天内 只生成一个stockchange
//		
//		
////		if(true) {
////			System.out.println("csPairs size:"+csPairs.size());
////			return;
////		}
//		
//		
//		int count = 0;//计数
//		for (ContractStockPair csPair : csPairs) {
//			count++;
//			StockId stock1 = csPair.getStock();//获取最近一次虚拟货位
//			StockSum stockSum = (StockSum)this.ssRepo.findOne((Long)stock1.getId());//获取视图信息
//			Contract contract = csPair.getContract();//获取合同
//			StockChange sc = new StockChange();//创建 stockcchange 空对象
//			sc.setPackageCategory(stock1.getPackageCategory());//设置
//			sc.setContract(contract);
//			sc.setGrainType(stock1.getGrainType());
//			sc.setGrainVariety(contract.getGrainVariety());
//			sc.setInputComment("智能出入库系统自动生成");
//			sc.setInputTime(new Date());
//
////-------------------设置 stockchange的出入库种类 应该 也可以设置其他的种类
//			if (contract.getIsIngress().booleanValue()) {
////如果是入库单--------设置这个虚拟货位为目标货位
//				sc.setTargetStock(stock1);
//				stock1.setInTime(new Date());//设置
//				sc.setBusinessKey(this.bService.getBusinessKeyForSc("(" + stock1.getCargo().getCompartment().getStore().getDepot().getKeyword() + ")入%Y%04d", new Date()));
//				sc.setType((SourceType)this.stRepo.findByCodeId(Integer.valueOf(2)));
//			}
//			else {
////否则是出库单------------------------设置该货位为源货位
//				stock1.setOutTime(new DateTime(new Date()).plusSeconds(count).toDate());
//				sc.setSourceStock(stock1);
//				sc.setBusinessKey(this.bService.getBusinessKeyForSc("(" + stock1.getCargo().getCompartment().getStore().getDepot().getKeyword() + ")出%Y%04d", new Date()));
//				sc.setType((SourceType)this.stRepo.findByCodeId(Integer.valueOf(3)));
//			}
//			
//			//因为 一天内 同一货位 同一合同 只生成了一个stockchange   所以 改stockchange 下方 附属的 每一车辆  信息、数量，等等信息作为集合存储为stockchange的一个属性 在数据库同样有一个表作为对应 进行 存储 
//			List<StockChangeEntry> entries = new ArrayList();//创建stockchange 下属的车辆信息 即数量 等等   -----集合
//			AnalysisLevel aLevel = null;//这一部分很简单 就是在对 粮食等级 进行 最小化存储处理  和去null化处理
//			for (GrainTraffic gt : gts) {   
//				if ((gt.getContract() != null) && (gt.getContract().equals(contract)) && (gt.getWeightSheet() != null) //改stockchange下的所以出入库单
//						&& (gt.getWeightSheet().getCargo().equals(stock1.getCargo()))) {
//          
//					WeightSheet ws = gt.getWeightSheet();//获取出入库单中
//		 //计算净重       //总感觉 这个数量 算的有点问题 之后再说吧      //有可能 出库时 这个就是 0   入库时代表  扣水 
//					Double amount = Double.valueOf(Math.abs(ws.getFirstWeight().doubleValue() - ws.getSecondWeight().doubleValue() - ws.getDeductWeight().doubleValue()));
//					if (amount.longValue() > 0L) {
//						StockChangeEntry entry = new StockChangeEntry();  //将作为  entries的一个元素进行存储  存的 是 单独一个出入库单的 车辆 数量 等各种信息 
//						if ((ws.getPack() != null) && (ws.getPackPerWeight() != null)) {//如果 还有包装 重
//							amount = Double.valueOf(amount.doubleValue() - Math.round(ws.getPack().longValue() * ws.getPackPerWeight().doubleValue()));
//						}
//						entry.setAmount(Long.valueOf(amount.longValue()));
//						entry.setPack(ws.getPack());
//						entry.setPlate(gt.getRegisterRecord().getVehicleTraffic().getPlate());
//						if (contract.getIsIngress().booleanValue()) {//如果是入库  存储   入库检验数据
//							entry.setWater(gt.getAnalysis().getA1());
//							entry.setImpurity(gt.getAnalysis().getA3());
//							entry.setYear(gt.getAnalysis().getYear());
//							entry.setLocation(gt.getAnalysis().getLocation());
//							if ((gt.getAnalysis().getAnalysisLevel() != null) && (//说白了 就是质检等级 取相对最下的那个
//									(aLevel == null) || (gt.getAnalysis().getAnalysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
//								aLevel = gt.getAnalysis().getAnalysisLevel();
//							}
//						}
//						else
//						{//出库或者没有 检验信息的情况下 赋值  当前 虚拟货位 的之前的检验信息   //出库时存储最近一次的检验数据  （注意 改数据可能是任何一种类型的检验    l代表最近一次检验 无论什么类型检验）
//							entry.setWater(stockSum.getL_a1());
//							entry.setImpurity(stockSum.getL_a3());
//							entry.setYear(stockSum.getYear());
//							entry.setLocation(stockSum.getLocation());
//							if ((stockSum.getL_analysisLevel() != null) && (
//									(aLevel == null) || (stockSum.getL_analysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
//								aLevel = stockSum.getL_analysisLevel();
//							}
//						}
//   
//						entries.add(entry);//将元素信息 填入  
//					}
//				}
//
//
////有三磅的信息
//				if ((gt.getSecondContract() != null) && (gt.getSecondContract().equals(contract)) && (gt.getSecondWeightSheet() != null) && (gt.getSecondWeightSheet().getCargo().equals(stock1.getCargo()))) {
//					WeightSheet ws = gt.getSecondWeightSheet();
//					Double amount = Double.valueOf(Math.abs(ws.getFirstWeight().doubleValue() - ws.getSecondWeight().doubleValue() - ws.getDeductWeight().doubleValue()));
///*      */           
//					if (amount.longValue() > 0L) {
//						StockChangeEntry entry = new StockChangeEntry();
//						if ((ws.getPack() != null) && (ws.getPackPerWeight() != null)) {
//							amount = Double.valueOf(amount.doubleValue() - Math.round(ws.getPack().longValue() * ws.getPackPerWeight().doubleValue()));
//						}
//						entry.setAmount(Long.valueOf(amount.longValue()));
//						entry.setPack(ws.getPack());
//						entry.setPlate(gt.getRegisterRecord().getVehicleTraffic().getPlate());
//						if (contract.getIsIngress().booleanValue()) {
//							entry.setWater(gt.getAnalysis().getA1());
//							entry.setImpurity(gt.getAnalysis().getA3());
//							entry.setYear(gt.getAnalysis().getYear());
//							entry.setLocation(gt.getAnalysis().getLocation());
//							if ((gt.getAnalysis().getAnalysisLevel() != null) && (
//									(aLevel == null) || (gt.getAnalysis().getAnalysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
//								aLevel = gt.getAnalysis().getAnalysisLevel();
//							}
//						}
//						else
//						{
//							entry.setWater(stockSum.getL_a1());
//							entry.setImpurity(stockSum.getL_a3());
//							entry.setYear(stockSum.getYear());
//							entry.setLocation(stockSum.getLocation());
//							if ((stockSum.getL_analysisLevel() != null) && (
//									(aLevel == null) || (stockSum.getL_analysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
//								aLevel = stockSum.getL_analysisLevel();
//							}
//						}
//           
//						entries.add(entry);
//					}
//				}
//			}
//
//
//
//
//			Double wa = Double.valueOf(0.0D);
//			Double ia = Double.valueOf(0.0D);
//			Long pack = Long.valueOf(0L);
//			Long amount = Long.valueOf(0L);
//			for (StockChangeEntry entry : entries) {//+=  计算总量 存入 stockchange  而水分 和 杂志 计算的 则是 总量水分/总量的比重 等等  存入 stockchange
//				if (entry.getPack() != null) {
//					pack = Long.valueOf(pack.longValue() + entry.getPack().longValue());
//				}
//				if (entry.getAmount() != null) {
//					amount = Long.valueOf(amount.longValue() + entry.getAmount().longValue());
//				}
//				if (entry.getWater() != null) {
//					wa = Double.valueOf(wa.doubleValue() + entry.getWater().doubleValue() * entry.getAmount().longValue());
//				}
//				if (entry.getImpurity() != null) {
//					ia = Double.valueOf(ia.doubleValue() + entry.getImpurity().doubleValue() * entry.getAmount().longValue());
//				}
//			}
//			if (amount.longValue() != 0L) {
//				sc.setWater(Double.valueOf(wa.doubleValue() / amount.longValue()));
//			}
//			if (amount.longValue() != 0L) {
//				sc.setImpurity(Double.valueOf(ia.doubleValue() / amount.longValue()));
//			}
//			sc.setAnalysisLevel(aLevel);
//			sc.setAmount(amount);
//			sc.setPack(pack);
//			sc.setEntries(entries);
//			this.scRepo.save(sc);
//			this.siRepo.save(stock1);//几乎没发生什么改变   那么  库存的呈现 依靠的怕不止是stockid  
//		}
//		Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
//		try {
/////*  567 */       ShengjuService.getInstance().sendGrainTraffics(gts, company, "create", maps, this.commonService);
//		} catch (Throwable e) {
//			System.out.println("每日出入库单汇总上传省局失败");
//			e.printStackTrace();
//		}
//	}






	
	
	
	
	
	
	
//	public void generateStockChangeFromGrainTrafficIn_myself_One(GrainTraffic ef) {
//
//		//------------------获取出入库单list集合------------------------------------------
//
//				List<GrainTraffic> gts=new ArrayList<GrainTraffic>();
//				gts.add(ef);
////				Map<GrainTraffic, StockId> maps = new HashMap();//出入库单 与虚拟货位//map基本没什么用 只是用来上传省局
//				Set<ContractStockPair> csPairs = new HashSet();//合同&虚拟货位 对象集合
//				StockId stock; 
//				for (GrainTraffic gt : gts) {
//					System.out.println("l-----------------");
//					stock = this.siRepo.currentCargo((Long)gt.getWeightSheet().getCargo().getId());  //获取当前在用货位gt.getWeightSheet().getCargo().getId()
//		     //最近一次的虚拟货位
////					maps.put(gt, stock);//将查到的最近一次货位  和  出入库单放入map中
//					if ((stock != null) && (gt.getContract() != null) && (gt.getWeightSheet() != null)) {
//						csPairs.add(new ContractStockPair(gt.getContract(), stock)); //虚拟货位  与合同信息 绑定 放在对象 存入set集合中   虚拟货位说白了就是货位信息
//						System.out.println("add-----------------");
//					}
//		        
//					if ((gt.getSecondWeightSheet() != null) && (gt.getSecondContract() != null)) {//三磅 绑定货位  存入set集合
//						StockId stock2 = this.siRepo.currentCargo((Long)gt.getSecondWeightSheet().getCargo().getId());//获取三磅货位
//						if (stock2 != null) {
//							csPairs.add(new ContractStockPair(gt.getSecondContract(), stock2));//三磅货位与三磅合同绑定
//						}
//		     
//					}
//				}
//				//以上注意 set不会 重复存储相同的对象 按照上面 所示 似乎 即使是属性完全相同 也会视为  相同对象
//				//原来该对象 重写了equal方法
//				//也就是说 相同 货位 相同合同 一天内 只生成一个stockchange
//				
//				
////				if(true) {
////					System.out.println("csPairs size:"+csPairs.size());
////					return;
////				}
//				
//				
//				int count = 0;//计数
//				for (ContractStockPair csPair : csPairs) {
//					count++;
//					StockId stock1 = csPair.getStock();//获取最近一次虚拟货位
//					StockSum stockSum = (StockSum)this.ssRepo.findOne((Long)stock1.getId());//获取视图信息
//					Contract contract = csPair.getContract();//获取合同
//					StockChange sc = new StockChange();//创建 stockcchange 空对象
//					sc.setPackageCategory(stock1.getPackageCategory());//设置
//					sc.setContract(contract);
//					sc.setGrainType(stock1.getGrainType());
//					sc.setGrainVariety(contract.getGrainVariety());
//					sc.setInputComment("智能出入库系统自动生成");
//					sc.setInputTime(new Date());
//
//		//-------------------设置 stockchange的出入库种类 应该 也可以设置其他的种类
//					if (contract.getIsIngress().booleanValue()) {
//		//如果是入库单--------设置这个虚拟货位为目标货位
//						sc.setTargetStock(stock1);
//						stock1.setInTime(new Date());//设置
//						sc.setBusinessKey(this.bService.getBusinessKeyForSc("(" + stock1.getCargo().getCompartment().getStore().getDepot().getKeyword() + ")入%Y%04d", new Date()));
//						sc.setType((SourceType)this.stRepo.findByCodeId(Integer.valueOf(2)));
//					}
//					else {
//		//否则是出库单------------------------设置该货位为源货位
//						stock1.setOutTime(new DateTime(new Date()).plusSeconds(count).toDate());
//						sc.setSourceStock(stock1);
//						sc.setBusinessKey(this.bService.getBusinessKeyForSc("(" + stock1.getCargo().getCompartment().getStore().getDepot().getKeyword() + ")出%Y%04d", new Date()));
//						sc.setType((SourceType)this.stRepo.findByCodeId(Integer.valueOf(3)));
//					}
//					
//					//因为 一天内 同一货位 同一合同 只生成了一个stockchange   所以 改stockchange 下方 附属的 每一车辆  信息、数量，等等信息作为集合存储为stockchange的一个属性 在数据库同样有一个表作为对应 进行 存储 
//					List<StockChangeEntry> entries = new ArrayList();//创建stockchange 下属的车辆信息 即数量 等等   -----集合
//					AnalysisLevel aLevel = null;//这一部分很简单 就是在对 粮食等级 进行 最小化存储处理  和去null化处理
//					for (GrainTraffic gt : gts) {   
//						if ((gt.getContract() != null) && (gt.getContract().equals(contract)) && (gt.getWeightSheet() != null) //改stockchange下的所以出入库单
//								&& (gt.getWeightSheet().getCargo().equals(stock1.getCargo()))) {
//		          
//							WeightSheet ws = gt.getWeightSheet();//获取出入库单中
//				 //计算净重       //总感觉 这个数量 算的有点问题 之后再说吧      //有可能 出库时 这个就是 0   入库时代表  扣水 
//							Double amount = Double.valueOf(Math.abs(ws.getFirstWeight().doubleValue() - ws.getSecondWeight().doubleValue() - ws.getDeductWeight().doubleValue()));
//							if (amount.longValue() > 0L) {
//								StockChangeEntry entry = new StockChangeEntry();  //将作为  entries的一个元素进行存储  存的 是 单独一个出入库单的 车辆 数量 等各种信息 
//								if ((ws.getPack() != null) && (ws.getPackPerWeight() != null)) {//如果 还有包装 重
//									amount = Double.valueOf(amount.doubleValue() - Math.round(ws.getPack().longValue() * ws.getPackPerWeight().doubleValue()));
//								}
//								entry.setAmount(Long.valueOf(amount.longValue()));
//								entry.setPack(ws.getPack());
//								entry.setPlate(gt.getRegisterRecord().getVehicleTraffic().getPlate());
//								if (contract.getIsIngress().booleanValue()) {//如果是入库  存储   入库检验数据
//									entry.setWater(gt.getAnalysis().getA1());
//									entry.setImpurity(gt.getAnalysis().getA3());
//									entry.setYear(gt.getAnalysis().getYear());
//									entry.setLocation(gt.getAnalysis().getLocation());
//									if ((gt.getAnalysis().getAnalysisLevel() != null) && (//说白了 就是质检等级 取相对最下的那个
//											(aLevel == null) || (gt.getAnalysis().getAnalysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
//										aLevel = gt.getAnalysis().getAnalysisLevel();
//									}
//								}
//								else
//								{//出库或者没有 检验信息的情况下 赋值  当前 虚拟货位 的之前的检验信息   //出库时存储最近一次的检验数据  （注意 改数据可能是任何一种类型的检验    l代表最近一次检验 无论什么类型检验）
//									entry.setWater(stockSum.getL_a1());
//									entry.setImpurity(stockSum.getL_a3());
//									entry.setYear(stockSum.getYear());
//									entry.setLocation(stockSum.getLocation());
//									if ((stockSum.getL_analysisLevel() != null) && (
//											(aLevel == null) || (stockSum.getL_analysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
//										aLevel = stockSum.getL_analysisLevel();
//									}
//								}
//		   
//								entries.add(entry);//将元素信息 填入  
//							}
//						}
//
//
//		//有三磅的信息
//						if ((gt.getSecondContract() != null) && (gt.getSecondContract().equals(contract)) && (gt.getSecondWeightSheet() != null) && (gt.getSecondWeightSheet().getCargo().equals(stock1.getCargo()))) {
//							WeightSheet ws = gt.getSecondWeightSheet();
//							Double amount = Double.valueOf(Math.abs(ws.getFirstWeight().doubleValue() - ws.getSecondWeight().doubleValue() - ws.getDeductWeight().doubleValue()));
//		/*      */           
//							if (amount.longValue() > 0L) {
//								StockChangeEntry entry = new StockChangeEntry();
//								if ((ws.getPack() != null) && (ws.getPackPerWeight() != null)) {
//									amount = Double.valueOf(amount.doubleValue() - Math.round(ws.getPack().longValue() * ws.getPackPerWeight().doubleValue()));
//								}
//								entry.setAmount(Long.valueOf(amount.longValue()));
//								entry.setPack(ws.getPack());
//								entry.setPlate(gt.getRegisterRecord().getVehicleTraffic().getPlate());
//								if (contract.getIsIngress().booleanValue()) {
//									entry.setWater(gt.getAnalysis().getA1());
//									entry.setImpurity(gt.getAnalysis().getA3());
//									entry.setYear(gt.getAnalysis().getYear());
//									entry.setLocation(gt.getAnalysis().getLocation());
//									if ((gt.getAnalysis().getAnalysisLevel() != null) && (
//											(aLevel == null) || (gt.getAnalysis().getAnalysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
//										aLevel = gt.getAnalysis().getAnalysisLevel();
//									}
//								}
//								else
//								{
//									entry.setWater(stockSum.getL_a1());
//									entry.setImpurity(stockSum.getL_a3());
//									entry.setYear(stockSum.getYear());
//									entry.setLocation(stockSum.getLocation());
//									if ((stockSum.getL_analysisLevel() != null) && (
//											(aLevel == null) || (stockSum.getL_analysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
//										aLevel = stockSum.getL_analysisLevel();
//									}
//								}
//		           
//								entries.add(entry);
//							}
//						}
//					}
//
//
//
//
//					Double wa = Double.valueOf(0.0D);
//					Double ia = Double.valueOf(0.0D);
//					Long pack = Long.valueOf(0L);
//					Long amount = Long.valueOf(0L);
//					for (StockChangeEntry entry : entries) {//+=  计算总量 存入 stockchange  而水分 和 杂志 计算的 则是 总量水分/总量的比重 等等  存入 stockchange
//						if (entry.getPack() != null) {
//							pack = Long.valueOf(pack.longValue() + entry.getPack().longValue());
//						}
//						if (entry.getAmount() != null) {
//							amount = Long.valueOf(amount.longValue() + entry.getAmount().longValue());
//						}
//						if (entry.getWater() != null) {
//							wa = Double.valueOf(wa.doubleValue() + entry.getWater().doubleValue() * entry.getAmount().longValue());
//						}
//						if (entry.getImpurity() != null) {
//							ia = Double.valueOf(ia.doubleValue() + entry.getImpurity().doubleValue() * entry.getAmount().longValue());
//						}
//					}
//					if (amount.longValue() != 0L) {
//						sc.setWater(Double.valueOf(wa.doubleValue() / amount.longValue()));
//					}
//					if (amount.longValue() != 0L) {
//						sc.setImpurity(Double.valueOf(ia.doubleValue() / amount.longValue()));
//					}
//					sc.setAnalysisLevel(aLevel);
//					sc.setAmount(amount);
//					sc.setPack(pack);
//					sc.setEntries(entries);
//					this.scRepo.save(sc);
//					this.siRepo.save(stock1);//几乎没发生什么改变   那么  库存的呈现 依靠的怕不止是stockid  
//				}
//				Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
//				try {
//		///*  567 */       ShengjuService.getInstance().sendGrainTraffics(gts, company, "create", maps, this.commonService);
//				} catch (Throwable e) {
//					System.out.println("每日出入库单汇总上传省局失败");
//					e.printStackTrace();
//				}
//			}
	
	
	
	
	
	public void stockChangeJsOne(GrainTraffic ef) {
		Set<ContractStockPair> csPairs = new HashSet();//合同&虚拟货位 对象集合

		StockId stock = this.siRepo.currentCargo((Long)ef.getWeightSheet().getCargo().getId());
		
		if ((stock != null) && (ef.getContract() != null) && (ef.getWeightSheet() != null)) {//如果改出入库单一磅 信息有
			csPairs.add(new ContractStockPair(ef.getContract(), stock)); //虚拟货位  与合同信息 绑定 放在对象 存入set集合中   虚拟货位说白了就是货位信息
		}
		
		if ((ef.getSecondWeightSheet() != null) && (ef.getSecondContract() != null)){//如果含有二磅信息
			StockId stock2 = this.siRepo.currentCargo((Long)ef.getSecondWeightSheet().getCargo().getId());//获取三磅货位
			if (stock2 != null) {
				csPairs.add(new ContractStockPair(ef.getSecondContract(), stock2));//三磅货位与三磅合同绑定
			}
		}
		
		int count = 0;//计数

		for (ContractStockPair csPair : csPairs){//遍历所有出入库单中出现 货位 此货位 包含一磅 和三磅的货位
			count++;
			StockId stock1 = csPair.getStock();//获取最近一次虚拟货位
			StockSum stockSum = (StockSum)this.ssRepo.findOne((Long)stock1.getId());//获取视图信息
			Contract contract = csPair.getContract();//获取合同
			StockChange sc = new StockChange();//创建 stockcchange 空对象
			sc.setPackageCategory(stock1.getPackageCategory());//设置
			sc.setContract(contract);
			sc.setGrainType(stock1.getGrainType());
			sc.setGrainVariety(contract.getGrainVariety());
			sc.setInputComment("智能出入库系统自动生成");
			sc.setInputTime(new Date());
			
			if (contract.getIsIngress().booleanValue()) {//根据合同判断出入库出库或入库  合同和货位共同确定了 set的唯一性  也就是说 不存在 source 和target同时存在的问题  
				//合同确定source or target stock 确定里面填什么值
				sc.setTargetStock(stock1);
				stock1.setInTime(new Date());//设置
				sc.setBusinessKey(this.bService.getBusinessKeyForSc("(" + stock1.getCargo().getCompartment().getStore().getDepot().getKeyword() + ")入%Y%04d", new Date()));
				sc.setType((SourceType)this.stRepo.findByCodeId(Integer.valueOf(2)));
			}else {
				stock1.setOutTime(new DateTime(new Date()).plusSeconds(count).toDate());
				sc.setSourceStock(stock1);
				sc.setBusinessKey(this.bService.getBusinessKeyForSc("(" + stock1.getCargo().getCompartment().getStore().getDepot().getKeyword() + ")出%Y%04d", new Date()));
				sc.setType((SourceType)this.stRepo.findByCodeId(Integer.valueOf(3)));
			}
			
			List<StockChangeEntry> entries = new ArrayList();//创建stockchange 下属的车辆信息 即数量 等等   -----集合
			
			AnalysisLevel aLevel = null;//这一部分很简单 就是在对 粮食等级 进行 最小化存储处理  和去null化处理
			boolean first=false;
			boolean second=false;
			if ((ef.getContract() != null) && (ef.getContract().equals(contract)) && (ef.getWeightSheet() != null) //如果该出入库单1磅 货位合同 与该stockchange一致
					&& (ef.getWeightSheet().getCargo().equals(stock1.getCargo()))) {
				first=true;
				
				WeightSheet ws = ef.getWeightSheet();//那就获取
				
				Double amount = Double.valueOf(Math.abs(ws.getFirstWeight().doubleValue() - ws.getSecondWeight().doubleValue() - ws.getDeductWeight().doubleValue()));
				if (amount.longValue() > 0L) {
					StockChangeEntry entry = new StockChangeEntry();  //将作为  entries的一个元素进行存储  存的 是 单独一个出入库单的 车辆 数量 等各种信息 
					if ((ws.getPack() != null) && (ws.getPackPerWeight() != null)) {//如果 还有包装 重
						amount = Double.valueOf(amount.doubleValue() - Math.round(ws.getPack().longValue() * ws.getPackPerWeight().doubleValue()));
					}
					entry.setAmount(Long.valueOf(amount.longValue()));
					entry.setPack(ws.getPack());
					entry.setPlate(ef.getRegisterRecord().getVehicleTraffic().getPlate());
					
					if (contract.getIsIngress().booleanValue()) {//如果是入库  存储   入库检验数据   entry 入库用入库检化验 
						entry.setWater(ef.getAnalysis().getA1());
						entry.setImpurity(ef.getAnalysis().getA3());
						entry.setYear(ef.getAnalysis().getYear());
						entry.setLocation(ef.getAnalysis().getLocation());
						if ((ef.getAnalysis().getAnalysisLevel() != null) && (//说白了 就是质检等级 取相对最下的那个
								(aLevel == null) || (ef.getAnalysis().getAnalysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
							aLevel = ef.getAnalysis().getAnalysisLevel();
						}
					}
					else
					{//出库或者没有 检验信息的情况下 赋值  当前 虚拟货位 的之前的检验信息   //出库时存储最近一次的检验数据  （注意 改数据可能是任何一种类型的检验    l代表最近一次检验 无论什么类型检验）
						entry.setWater(stockSum.getL_a1());
						entry.setImpurity(stockSum.getL_a3());
						entry.setYear(stockSum.getYear());
						entry.setLocation(stockSum.getLocation());
						if ((stockSum.getL_analysisLevel() != null) && (
								(aLevel == null) || (stockSum.getL_analysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
							aLevel = stockSum.getL_analysisLevel();
						}
					}

					entries.add(entry);//将元素信息 填入 
					
				}
				
				
			}
			if ((ef.getSecondContract() != null) && (ef.getSecondContract().equals(contract)) && (ef.getSecondWeightSheet() != null) && (ef.getSecondWeightSheet().getCargo().equals(stock1.getCargo()))) {
				
				second=true;
				WeightSheet ws = ef.getSecondWeightSheet();
				Double amount = Double.valueOf(Math.abs(ws.getFirstWeight().doubleValue() - ws.getSecondWeight().doubleValue() - ws.getDeductWeight().doubleValue()));
           
				if (amount.longValue() > 0L) {
					StockChangeEntry entry = new StockChangeEntry();
					if ((ws.getPack() != null) && (ws.getPackPerWeight() != null)) {
						amount = Double.valueOf(amount.doubleValue() - Math.round(ws.getPack().longValue() * ws.getPackPerWeight().doubleValue()));
					}
					entry.setAmount(Long.valueOf(amount.longValue()));
					entry.setPack(ws.getPack());
					entry.setPlate(ef.getRegisterRecord().getVehicleTraffic().getPlate());
					if (contract.getIsIngress().booleanValue()) {
						entry.setWater(ef.getAnalysis().getA1());
						entry.setImpurity(ef.getAnalysis().getA3());
						entry.setYear(ef.getAnalysis().getYear());
						entry.setLocation(ef.getAnalysis().getLocation());
						if ((ef.getAnalysis().getAnalysisLevel() != null) && (
								(aLevel == null) || (ef.getAnalysis().getAnalysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
							aLevel = ef.getAnalysis().getAnalysisLevel();
						}
					}
					else
					{
						entry.setWater(stockSum.getL_a1());
						entry.setImpurity(stockSum.getL_a3());
						entry.setYear(stockSum.getYear());
						entry.setLocation(stockSum.getLocation());
						if ((stockSum.getL_analysisLevel() != null) && (
								(aLevel == null) || (stockSum.getL_analysisLevel().getCodeId().intValue() < aLevel.getCodeId().intValue()))) {
							aLevel = stockSum.getL_analysisLevel();
						}
					}
       
					entries.add(entry);
				}
			}
			
			Double wa = Double.valueOf(0.0D);
			Double ia = Double.valueOf(0.0D);
			Long pack = Long.valueOf(0L);
			Long amount = Long.valueOf(0L);
			for (StockChangeEntry entry : entries) {//+=  计算总量 存入 stockchange  而水分 和 杂志 计算的 则是 总量水分/总量的比重 等等  存入 stockchange
				if (entry.getPack() != null) {
					pack = Long.valueOf(pack.longValue() + entry.getPack().longValue());
				}
				if (entry.getAmount() != null) {
					amount = Long.valueOf(amount.longValue() + entry.getAmount().longValue());
				}
				if (entry.getWater() != null) {
					wa = Double.valueOf(wa.doubleValue() + entry.getWater().doubleValue() * entry.getAmount().longValue());
				}
				if (entry.getImpurity() != null) {
					ia = Double.valueOf(ia.doubleValue() + entry.getImpurity().doubleValue() * entry.getAmount().longValue());
				}
			}
			if (amount.longValue() != 0L) {
				sc.setWater(Double.valueOf(wa.doubleValue() / amount.longValue()));
			}
			if (amount.longValue() != 0L) {
				sc.setImpurity(Double.valueOf(ia.doubleValue() / amount.longValue()));
			}
			sc.setAnalysisLevel(aLevel);
			sc.setAmount(amount);
			sc.setPack(pack);
			sc.setEntries(entries);
			StockChange scId=this.scRepo.save(sc);
			if(first) {
				ef.setStockchange(scId);
			}
			if(second) {
				ef.setSecondstockchange(scId);
			}
			gtRepo.save(ef);
			this.siRepo.save(stock1);//几乎没发生什么改变   那么  库存的呈现 依靠的怕不止是stockid  
			
			
	
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	












/*      */   
///*      */   public void generateStockChangeFromGrainTrafficIn24Hours() {
///*  575 */     Date lastDate = new DateTime().toDate();
///*  576 */     generateStockChangeFromGrainTrafficIn24HoursAtDate(lastDate);
///*      */   }
/*      */   
/*      */   public List<AnalysisType> getAllAnalysisTypes() {
/*  580 */     return this.atRepo.findAll();
/*      */   }
/*      */   
/*      */   public CardType createCardType(CardType cardType) {
/*  584 */     return (CardType)this.ctRepo.save(cardType);
/*      */   }
/*      */   
/*      */   public List<CardType> getAllCardTypes() {
/*  588 */     return this.ctRepo.findAll();
/*      */   }
/*      */   
/*      */   public CardType updateCardType(CardType cardType) {
/*  592 */     return (CardType)this.ctRepo.save(cardType);
/*      */   }
/*      */   
/*      */   public void deleteVehicleTraffic(Long id) {
/*  596 */     this.vtRepo.delete(id);
/*      */   }
/*      */   
/*      */   public void deleteCardType(CardType cardType) {
/*  600 */     this.ctRepo.delete(cardType);
/*      */   }
/*      */   
/*      */   public Card createCard(Card card) {
/*  604 */     return (Card)this.cardRepo.save(card);
/*      */   }
/*      */   
/*      */   public List<Card> getAllCards() {
/*  608 */     return this.cardRepo.findAll();
/*      */   }
/*      */   
/*      */   public Card updateCard(Card card) {
/*  612 */     return (Card)this.cardRepo.save(card);
/*      */   }
/*      */   
/*      */   public void deleteCard(Card card) {
/*  616 */     this.cardRepo.delete(card);
/*      */   }
/*      */   
/*      */   public DeductRecord createDeductRecord(DeductRecord deductRecord) {
/*  620 */     return (DeductRecord)this.drecordRepo.save(deductRecord);
/*      */   }
/*      */   
/*      */   public DeductRule createDeductRule(DeductRule deductRule) {
/*  624 */     return (DeductRule)this.druleRepo.save(deductRule);
/*      */   }
/*      */   
/*      */   public AnalysisLevel createAnalysisLevel(AnalysisLevel analysisLevel) {
/*  628 */     return (AnalysisLevel)this.alRepo.save(analysisLevel);
/*      */   }
/*      */   
/*      */   public PlanType createPlanType(PlanType planType) {
/*  632 */     return (PlanType)this.planTypeRepo.save(planType);
/*      */   }
/*      */   
/*      */   public DeductRecord updateDeductRecord(DeductRecord deductRecord) {
/*  636 */     return (DeductRecord)this.drecordRepo.save(deductRecord);
/*      */   }
/*      */   
/*      */   public DeductRule updateDeductRule(DeductRule deductRule) {
/*  640 */     return (DeductRule)this.druleRepo.save(deductRule);
/*      */   }
/*      */   
/*      */   public AnalysisLevel updateAnalysisLevel(AnalysisLevel analysisLevel) {
/*  644 */     return (AnalysisLevel)this.alRepo.save(analysisLevel);
/*      */   }
/*      */   
/*      */   public PlanType updatePlanType(PlanType planType) {
/*  648 */     return (PlanType)this.planTypeRepo.save(planType);
/*      */   }
/*      */   
/*      */   public void deleteDeductRecord(DeductRecord deductRecord) {
/*  652 */     this.drecordRepo.delete(deductRecord);
/*      */   }
/*      */   
/*      */   public void deleteDeductRule(DeductRule deductRule)
/*      */   {
/*  657 */     this.druleRepo.delete(deductRule);
/*      */   }
/*      */   
/*      */   public void deleteAnalysisLevel(AnalysisLevel analysisLevel) {
/*  661 */     this.alRepo.delete(analysisLevel);
/*      */   }
/*      */   
/*      */   public void deletePlanType(PlanType planType)
/*      */   {
/*  666 */     this.planTypeRepo.delete(planType);
/*      */   }
/*      */   
/*      */   public List<PlanType> getAllPlanTypes()
/*      */   {
/*  671 */     return this.planTypeRepo.findAll();
/*      */   }
/*      */   
/*      */   public List<AnalysisLevel> getAllAnalysisLevels() {
/*  675 */     return this.alRepo.findAll();
/*      */   }
/*      */   
/*      */   public void createWeight(String cardCode, WeightDto weight) {
/*  679 */     GrainTraffic gt = this.gtRepo.findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(cardCode);//获取出入库单

				Long stock_id=weight.getStock_id();
				StockId stock=siRepo.findOne(stock_id);
				
				
				

/*  680 */     WeightSheet ws = new WeightSheet();//创建将要存入存入过磅表的空对象
/*  681 */     ws.setFirstUser(AuthUserService.getCurrentUser(userRepo));//设置
				System.out.println(weight.getAmount()+","+weight.getStoreId()+","+weight.getLoadCompanyId()+","+weight.getCargoId());
/*  682 */     ws.setFirstWeight(weight.getAmount());//整数部分最多5位 小数部分本身就占了4位 一共9位//设置
/*  683 */     ws.setFirstTime(new Date());//设置
/*  684 */     ws.setStore((Store)this.storeRepo.findOne(weight.getStoreId()));//设置
/*  685 */     ws.setLoadCompany((LoadCompany)this.lcRepo.findOne(weight.getLoadCompanyId()));//设置
/*  686 */     ws.setCargo((Cargo)this.cargoRepo.findOne(weight.getCargoId()));//设置
/*  687 */     ws = (WeightSheet)this.wsRepo.save(ws);//过磅表存储 返回带有ID的过磅数据
/*  688 */     if (gt.getIsIngress().booleanValue()) {
/*  689 */       gt.setStage(this.stageRepo.findByValue(Integer.valueOf(4)));//改变节点状态//称毛重
/*      */     } else
/*  691 */       gt.setStage(this.stageRepo.findByValue(Integer.valueOf(5)));//改变节点状态出库上面是入库 IsIngress 是区分出入库单的字段  一磅对于出库是皮重 对于 入库是毛重 
/*  692 */     if (gt.getHasSecond().booleanValue()) {
/*  693 */       gt.setSecondWeightSheet(ws);  //三磅意味着又一条完整的过磅数据  包含一二磅     设置在出入库单的第二过磅数据中   所以还是要  过了1磅和二磅 
				gt.setSecondstock(stock);
/*      */     } else {
					
	gt.setWeightSheet(ws);//大部分是正常情况 设置在第一过磅数据中
	gt.setStock(stock);
}
/*  695 */       


//--------------------设置完开始存储到出入库单中
/*  696 */     this.gtRepo.save(gt);
/*  697 */     generateNotifForTraffic(gt);//发送弹框信息



/*  698 */     snapshotForTrafficCode(gt, "WEIGHT");//开始抓图
/*      */   }
/*      */   
/*      */   public void secondWeight(String cardCode, WeightDto weight) {
/*  702 */     GrainTraffic gt = this.gtRepo.findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(cardCode);//获取出入库单
/*  703 */     WeightSheet ws = null;
/*  704 */     if (gt.getHasSecond().booleanValue()) {//如果有三磅信息  获取三磅信息进行设置
/*  705 */       ws = gt.getSecondWeightSheet();
/*  706 */       ws.setStore((Store)this.storeRepo.findOne(weight.getStoreId()));
/*  707 */       ws.setCargo((Cargo)this.cargoRepo.findOne(weight.getCargoId()));
/*  708 */       gt.setSecondContract((Contract)this.contractRepo.findOne(weight.getContractId()));
/*      */     }
/*      */     else {//如果没有就设置一二磅信息
/*  711 */       ws = gt.getWeightSheet();
/*  712 */       ws.setStore((Store)this.storeRepo.findOne(weight.getStoreId()));
/*  713 */       ws.setCargo((Cargo)this.cargoRepo.findOne(weight.getCargoId()));
/*  714 */       gt.setContract((Contract)this.contractRepo.findOne(weight.getContractId()));
/*      */     }
/*  716 */     ws.setDeductPercentage(weight.getDeductAmount());//设置
/*  717 */     ws.setPack(weight.getPack());//设置
/*  718 */     ws.setPackPerWeight(weight.getPackPerWeight());//设置
				System.out.println(weight.getAmount());
//				if(true) {
//					return;
//				}
				
/*  719 */     ws.setSecondWeight(weight.getAmount());//设置
/*  720 */     ws.setSecondTime(new Date());//设置
/*  721 */     ws.setSecondUser(AuthUserService.getCurrentUser(userRepo));//设置
/*  722 */     ws.setComment(weight.getComment());//设置

//DeductWeight就是二磅时候 的扣水    填入的 百分比  percent   amount是算出来的   

//入库  一磅>2二磅     0-（2磅-1磅） 为正  
/*  723 */     if (gt.getIsIngress().booleanValue()) { //判读 出or入库
/*  724 */       ws.setDeductWeight(new Double(Math.round(0.0D - (ws.getSecondWeight().doubleValue() - ws.getFirstWeight().doubleValue()) * (ws.getDeductPercentage().doubleValue() / 100.0D))));
/*  725 */       gt.setStage(this.stageRepo.findByValue(Integer.valueOf(8)));
/*  726 */       gt.setAllowStage(Integer.valueOf(8));
/*      */     }
/*      */     else {
/*  729 */       ws.setDeductWeight(new Double(Math.round((ws.getSecondWeight().doubleValue() - ws.getFirstWeight().doubleValue()) * (ws.getDeductPercentage().doubleValue() / 100.0D))));
/*  730 */       gt.setStage(this.stageRepo.findByValue(Integer.valueOf(9)));
/*  731 */       gt.setAllowStage(Integer.valueOf(9));
/*      */     }
//-------------------------保存过磅信息
/*  733 */     this.wsRepo.save(ws);
/*  734 */     this.gtRepo.save(gt);//保存出入库单信息
/*  735 */     generateNotifForTraffic(gt);//发送弹框信息
				
/*  736 */     snapshotForTrafficCode(gt, "SECOND_WEIGHT");//抓图
/*      */   }
/*      */   
/*      */   public void confirmWeight(String cardCode, WeightDto weight) {
/*  740 */     GrainTraffic gt = this.gtRepo.findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(cardCode);
/*  741 */     WeightSheet ws = null;

//------------还是在区分有没有三磅
/*  742 */     if (gt.getHasSecond().booleanValue()) {
/*  743 */       ws = gt.getSecondWeightSheet();
/*      */     } else
/*  745 */       ws = gt.getWeightSheet();
/*  746 */     ws.setComment(weight.getComment());//设置无关紧要的备注
/*  747 */     if ((weight.getUsername() != null) && (weight.getUsername().getUsername() != null)) {
/*  748 */       ws.setManager(this.userRepo.findByUsername(weight.getUsername().getUsername()));//设置人manager
/*  749 */       System.out.println("正在确认入仓信息 by " + weight.getUsername().getUsername());
/*      */     }
/*  751 */     ws.setDeductTime(new Date());//设置时间反正是值仓完时执行的  设置了当前时间
/*  752 */     this.wsRepo.save(ws);//过磅数据保存设置


//------------------------下面这一步就是值仓比较主要的操作了  主要根据区别出入库  来确定此刻的当前节点状态 值仓入库和值仓出库
/*  753 */     if (gt.getIsIngress().booleanValue()) {//
/*  754 */       gt.setStage(this.stageRepo.findByValue(Integer.valueOf(6)));
/*      */     } else
/*  756 */       gt.setStage(this.stageRepo.findByValue(Integer.valueOf(7)));

//--------------------出入库数据保存设置
/*  757 */     this.gtRepo.save(gt); 
/*  758 */     generateNotifForTraffic(gt);//发送弹框信息
/*      */   }
/*      */   
/*      */   public void createBalance(String cardCode, BalanceDto balance) {//最终的确认
/*  762 */     GrainTraffic gt = this.gtRepo.findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(cardCode);//获取出入库单
/*  763 */     BalanceSheet bs = new BalanceSheet(); //创建最终确认空表 确认表信息很简略基本上就是一些基础的确认信息

/*  764 */     bs.setManager(AuthUserService.getCurrentUser(userRepo));//确认表设置
/*  765 */     bs.setComment(balance.getComment());//确认表设置
/*  766 */     bs.setTime(new Date());//确认表设置
/*  767 */     bs = (BalanceSheet)this.bsRepo.save(bs);//确认表保存并返回带有ID的确认表数据
/*  768 */     gt.setBalanceSheet(bs); //出入库单设置
/*      */     
/*  770 */     gt.setIsFinished(Boolean.valueOf(true));//出入库单设置
/*  771 */     gt.setOutTime(new Date());//出入库单设置
/*      */     
/*  773 */     VehicleTraffic vt = gt.getRegisterRecord().getVehicleTraffic();//获取车辆信息
/*  774 */     vt.setFinished(Boolean.valueOf(true));//车辆信息设置  车辆完成
/*  775 */     this.vtRepo.save(vt); //车辆信息存储更改
/*      */     
/*  777 */     if (!balance.getIsFinished().booleanValue()) {//这里应该是判断回二磅
/*  778 */       if (gt.getHasSecond().booleanValue()) {
/*  779 */         WeightSheet ws2 = gt.getSecondWeightSheet();
/*  780 */         if (ws2 != null) {
/*  781 */           ws2.setDeductPercentage(Double.valueOf(0.0D));
/*  782 */           ws2.setDeductWeight(Double.valueOf(0.0D));
/*  783 */           ws2.setPack(Long.valueOf(0L));
/*  784 */           ws2.setSecondWeight(ws2.getFirstWeight());
/*      */         }
/*  786 */         this.wsRepo.save(ws2);
/*  787 */         gt.setStage(this.stageRepo.findByValue(Integer.valueOf(11)));
/*  788 */         Card c = getCardByPhysical(gt.getRegisterRecord().getCardCode());
/*  789 */         c.setIsUsing(Boolean.valueOf(false));
/*  790 */         this.cardRepo.save(c);
/*  791 */         this.gtRepo.save(gt);
/*  792 */         return;
/*      */       }
/*  794 */       gt.setStage(this.stageRepo.findByValue(balance.getStage()));
/*  795 */       Card c = getCardByPhysical(gt.getRegisterRecord().getCardCode());
/*  796 */       c.setIsUsing(Boolean.valueOf(false));
/*  797 */       this.cardRepo.save(c);
/*  798 */       this.gtRepo.save(gt);
/*  799 */       WeightSheet ws = gt.getWeightSheet();
/*  800 */       if (ws != null) {
/*  801 */         ws.setDeductPercentage(Double.valueOf(0.0D));
/*  802 */         ws.setDeductWeight(Double.valueOf(0.0D));
/*  803 */         ws.setPack(Long.valueOf(0L));
/*  804 */         ws.setSecondWeight(ws.getFirstWeight());
/*  805 */         this.wsRepo.save(ws);
/*      */       }
/*  807 */       return;
/*      */     }
/*      */     
/*  810 */     WeightSheet ws = gt.getWeightSheet();//获取出入库单的 过磅信息
/*  811 */     gt.setContract((Contract)this.contractRepo.findOne(balance.getContractId())); //出入库单设置合同
/*  812 */     ws.setStore((Store)this.storeRepo.findOne(balance.getStoreId()));
/*  813 */     ws.setCargo((Cargo)this.cargoRepo.findOne(balance.getCargoId()));
/*  814 */     this.wsRepo.save(ws);
/*      */     
/*  816 */     if (gt.getHasSecond().booleanValue()) { //有过三邦信息 与上面不同的是上面点的不是确认 而是 回二磅
/*  817 */       WeightSheet ws2 = gt.getSecondWeightSheet();
/*  818 */       ws2.setStore((Store)this.storeRepo.findOne(balance.getSecondStoreId()));
/*  819 */       ws2.setCargo((Cargo)this.cargoRepo.findOne(balance.getSecondCargoId()));
/*  820 */       gt.setSecondContract((Contract)this.contractRepo.findOne(balance.getSecondContractId()));
/*  821 */       this.wsRepo.save(ws2);
/*      */     }
/*      */     
/*  824 */     gt.setStage(this.stageRepo.findByValue(Integer.valueOf(11)));//设置状态为正常结束

//--------------------------------修改货位状态
/*  825 */     changeCargoStatus(gt, gt.getWeightSheet(), false);



/*  826 */     if ((gt.getSecondWeightSheet() != null & gt.getHasSecond().booleanValue())) {//有三磅信息
/*  827 */       changeCargoStatus(gt, gt.getSecondWeightSheet(), true);
/*      */     }
/*      */     
/*  830 */     Card c = getCardByPhysical(gt.getRegisterRecord().getCardCode()); //获取卡数据 
/*  831 */     c.setIsUsing(Boolean.valueOf(false));//设置卡数据 为  没在用可重新启用  即销卡
/*  832 */     this.cardRepo.save(c);//卡信息保存设置
/*  833 */     GrainTraffic gtOne= this.gtRepo.save(gt);//出入库单保存设置

				//生成gbstockchage

				stockChangeJsOne(gtOne);
				
				

/*  834 */     generateNotifForTraffic(gt);//发送弹框信息
/*  835 */     snapshotForTrafficCode(gt, "FINANCE");//抓图
/*      */   }
/*      */   
/*      */   public void changeCargoStatus(GrainTraffic gt, WeightSheet ws, boolean isSecond) {
/*  839 */     Cargo cargo = ws.getCargo();
/*  840 */     Store store = ws.getStore();
/*  841 */     if (this.cargoRepo.countByCompartment_Store_Id(((Long)store.getId()).longValue()) == 1L) {//如果只有一个货位还需要修改仓房（是不是只有1一个 货位的状态都是要修改的）
	//------------------------直接修改仓房状态值
	
	System.out.println("修改仓房状态值:"+(Integer.valueOf(gt.getIsIngress().booleanValue() ? 4 : 5)));
	
	
/*  842 */       store.getStatus().setStatus((SpaceStatus)this.spsRepo.findByCodeId(Integer.valueOf(gt.getIsIngress().booleanValue() ? 4 : 5)));
/*  843 */       this.storeRepo.save(store);
/*      */     }
System.out.println("修改货位状态:"+(Integer.valueOf(gt.getIsIngress().booleanValue() ? 2 : 4)));
/*  845 */     cargo.setStatus((CargoStatus)this.csRepo.findByCodeId(Integer.valueOf(gt.getIsIngress().booleanValue() ? 2 : 4)));
/*  846 */     this.cargoRepo.save(cargo);
/*      */   }
/*      */   
/*      */   public GrainTraffic getGrainTrafficByCardCode(String card) {
/*  850 */     return this.gtRepo.findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(card);
/*      */   }
/*      */   
/*      */   public List<Card> getCardsFiltered(String filter) {
/*  854 */     return this.cardRepo.findByPrintNumberContaining(filter);
/*      */   }
/*      */   
/*      */   public Card getCardByPhysical(String code) {
/*  858 */     return this.cardRepo.findByPhysicalNumber(code);
/*      */   }
/*      */   
/*      */   public Card getCardByPrint(String code) {
/*  862 */     return this.cardRepo.findByPrintNumber(code);
/*      */   }
/*      */   
/*      */   public void updateCardActive(String code, Boolean active) {
/*  866 */     Card c = this.cardRepo.findByPrintNumberOrPhysicalNumber(code, code);
/*  867 */     if (c != null) {
/*  868 */       c.setIsActive(active);
/*  869 */       this.cardRepo.save(c);
/*      */     }
/*      */   }
/*      */   
/*      */   public void updateCardUsing(String code, Boolean using) {
/*  874 */     Card c = this.cardRepo.findByPrintNumberOrPhysicalNumber(code, code);
/*  875 */     if (c != null) {
/*  876 */       c.setIsUsing(using);
/*  877 */       this.cardRepo.save(c);
/*      */     }
/*      */   }
/*      */   
/*      */   public GrainTraffic getGrainTrafficByPersonnelId(String personnelId) {
/*  882 */     return this.gtRepo.findByRegisterRecord_PersonnelIdNumber(personnelId);
/*      */   }
/*      */   
/*      */   public GrainTraffic getGrainTrafficByCode(String code) {
/*  886 */     return this.gtRepo.findByCode(code);
/*      */   }
/*      */   
/*      */   public void leave(String cardNumber) {
/*  890 */     GrainTraffic gt = getGrainTrafficByCardCode(cardNumber);
/*  891 */     gt.setIsFinished(Boolean.valueOf(true));
/*  892 */     if (gt.getStage().getValue().equals(Integer.valueOf(10)))
/*  893 */       gt.setStage(this.stageRepo.findByValue(Integer.valueOf(11)));
/*  894 */     this.gtRepo.save(gt);
/*      */   }
/*      */   
/*      */   public void allocateGrainTrafficForSecond(String code, BalanceDto balance) {
	
				//获取出入库单
/*  898 */     GrainTraffic gt = getGrainTrafficByCardCode(code);

				//设置一次回磅合同
/*  899 */     gt.setContract((Contract)this.contractRepo.findOne(balance.getContractId()));
				//设置二次回磅合同
/*  900 */     gt.setSecondContract((Contract)this.contractRepo.findOne(balance.getSecondContractId()));
				//有二次回磅
/*  901 */     gt.setHasSecond(Boolean.valueOf(true));
/*  902 */     if (gt.getIsIngress().booleanValue()) {
/*  903 */       gt.setStage(this.stageRepo.findByValue(Integer.valueOf(3)));//设置步骤数    入库时需要扦样化验    所以设置到 化验步骤
/*      */     } else {
/*  905 */       gt.setStage(this.stageRepo.findByValue(Integer.valueOf(1)));//但是 出库 不需要 扦样化验   所以设置 到 登记步骤
/*      */     }
/*  907 */     gt.setAllowStage(gt.getStage().getValue());//设置调度值  感觉没什么大用
/*      */     
/*  909 */     WeightSheet ws = gt.getWeightSheet();  //存储一磅过磅信息
/*      */     
/*  911 */     ws.setStore((Store)this.storeRepo.findOne(balance.getStoreId()));
/*  912 */     ws.setCargo((Cargo)this.cargoRepo.findOne(balance.getCargoId()));
/*  913 */     this.wsRepo.save(ws);
/*      */     
/*  915 */     this.gtRepo.save(gt);//存储出入库单
/*  916 */     generateNotifForTraffic(gt);//发送弹框信息
/*      */   }
/*      */   
/*      */   public void allocateGrainTraffic(String code) {
/*  920 */     GrainTraffic gt = getGrainTrafficByCardCode(code);
/*  921 */     if (gt.getStage().getValue().intValue() > 0) {
/*  922 */       gt.setAllowStage(gt.getStage().getValue());
/*  923 */       this.gtRepo.save(gt);
/*      */     }
/*  925 */     Stage next = this.stageRepo.findByValue(gt.getStage().getNext());
/*  926 */     if (gt.getStage().getValue().equals(Integer.valueOf(1))) {
/*  927 */       if (gt.getIsIngress().booleanValue()) {
/*  928 */         next = this.stageRepo.findByValue(Integer.valueOf(2));
/*      */       } else
/*  930 */         next = this.stageRepo.findByValue(Integer.valueOf(5));
/*      */     }
/*  932 */     if ((this.commonService.moduleActive("GSM") & next != null)) {
/*      */       try {
/*  934 */         String content = "";
/*  935 */         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年M月d日HH:mm:ss");
/*  936 */         content = "出入库单[" + gt.getCode() + "]状态提醒： 承运人[" + gt.getRegisterRecord().getPersonnelName().trim() + "] 车辆[" + gt.getRegisterRecord().getVehicleTraffic().getPlate() + "]\n" + gt.getStage().getName() + "业务完成,请前往" + next.getName() + "业务 " + dateFormat.format(new Date());
/*      */         
/*  938 */         if (gt.getRegisterRecord().getTelephone() != null)
/*  939 */           SMSUtil.sendMessage(gt.getRegisterRecord().getTelephone(), content);
/*      */       } catch (Exception e) {
/*  941 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void allocateGrainTrafficForManager(String code, Long userId) {
/*  947 */     GrainTraffic gt = getGrainTrafficByCardCode(code);
/*  948 */     User user = (User)this.userRepo.findOne(userId);
/*  949 */     WeightSheet ws = null;
/*  950 */     if (gt.getHasSecond().booleanValue()) {
/*  951 */       ws = gt.getSecondWeightSheet();
/*  952 */       ws.setManager(user);
/*  953 */       this.wsRepo.save(ws);
/*      */     }
/*      */     else {
/*  956 */       ws = gt.getWeightSheet();
/*  957 */       ws.setManager(user);
/*  958 */       this.wsRepo.save(ws);
/*      */     }
/*  960 */     if (gt.getStage().getValue().intValue() > 0) {
/*  961 */       gt.setAllowStage(gt.getStage().getValue());
/*  962 */       this.gtRepo.save(gt);
/*      */     }
/*  964 */     if (this.commonService.moduleActive("GSM")) {
/*      */       try {
/*  966 */         String content = "";
/*  967 */         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年M月d日HH:mm:ss");
/*  968 */         content = "[" + content + ws.getStore().getName() + "] " + "值仓提醒 " + 
/*  969 */           dateFormat.format(new Date());
/*      */         
/*  971 */         if (user.getTelephone() != null)
/*  972 */           SMSUtil.sendMessage(user.getTelephone(), content);
/*      */       } catch (Exception e) {
/*  974 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public List<GrainTraffic> getGrainTrafficActive() {
/*  980 */     return this.gtRepo.findByIsFinished(false);
/*      */   }



public List<GrainTraffic> getGrainTrafficFinished() {
/*  980 */     return this.gtRepo.findByIsFinished(true);
/*      */   }



/*      */   
/*      */   public List<GrainTraffic> getGrainTrafficForLed() {
/*  984 */     return this.gtRepo.findByIsIngressAndIsFinished(true, true);
/*      */   }
/*      */   
/*      */   public List<GrainTraffic> getGrainTrafficForLedTop10() {
/*  988 */     return this.gtRepo.findTop20ByIsIngressAndAnalysis_DoneOrderByAnalysis_AnalysisTimeDesc(true, true);
/*      */   }
/*      */   
/*      */   public List<GrainTraffic> getGrainTrafficForLed(String filter) {
/*  992 */     return null;
/*      */   }
/*      */   
/*      */   public Integer getScaleWeight() {
/*  996 */     return Integer.valueOf(ScaleSocketUtil.getWeight());
/*      */   }
/*      */   
/*      */   public String getCardCodeByShort(String shortCode) {
/* 1000 */     List<Card> cards = this.cardRepo.findByPhysicalNumberContaining(shortCode);
/* 1001 */     if (cards.size() == 1) {
/* 1002 */       return ((Card)cards.get(0)).getPhysicalNumber();
/*      */     }
/*      */     
/* 1005 */     for (Card card : cards) {
/* 1006 */       if (card.getPhysicalNumber().subSequence(6, card.getPhysicalNumber().length()).toString().startsWith(shortCode))
/* 1007 */         return card.getPhysicalNumber();
/*      */     }
/* 1009 */     return ((Card)cards.get(0)).getPhysicalNumber();
/*      */   }
/*      */   
/*      */   public void rollbackRegister(String cardCode)
/*      */   {
/* 1014 */     GrainTraffic gt = getGrainTrafficByCardCode(cardCode);
/* 1015 */     updateCardUsing(cardCode, Boolean.valueOf(false));
/* 1016 */     this.gtRepo.delete(gt);
/*      */   }
/*      */   
/*      */   public void generateNotifForTraffic(GrainTraffic gt) {
/* 1020 */     ActivitiGroup ag = this.agRepo.findByCode("TRAFFIC");
/* 1021 */     BusinessNotification notif = new BusinessNotification();
/* 1022 */     String content = "出入库单: " + gt.getCode() + ", 合同: " + gt.getContract().getName();
/* 1023 */     String extend = null;

				//这里简化一下 只分一种 完成 了 当前 调度
				extend = "; 已完成" + gt.getStage().getName();
				
///* 1024 */     if (gt.getStage().getNext() == null) {
///* 1025 */       if (gt.getStage().getValue().equals(Integer.valueOf(1))) {
///* 1026 */         extend = "; 已完成" + gt.getStage().getName() + "业务, 调度下一步的业务：" + (gt.getIsIngress().booleanValue() ? this.stageRepo.findByValue(Integer.valueOf(2)).getName() : this.stageRepo.findByValue(Integer.valueOf(5)).getName());
///* 1027 */       } else if (gt.getStage().getValue().equals(Integer.valueOf(11))) {
///* 1028 */         extend = "; 已顺利完成,确认出库";
///* 1029 */       } else if (gt.getStage().getValue().intValue() < 0) {
///* 1030 */         extend = "; 非正常出库,状态为: " + gt.getStage().getName();
///*      */       }
///*      */       
///*      */     }
/////* 1034 */     else if ((gt.getHasSecond().booleanValue()) && ((gt.getStage().getValue().equals(Integer.valueOf(1))) || (gt.getStage().getValue().equals(Integer.valueOf(3))))) {
/////* 1035 */       extend = "; 车辆二次回磅, 调度下一步的业务：" + this.stageRepo.findByValue(gt.getStage().getNext()).getName();
/////*      */     }
///*      */     else {
///* 1038 */       extend = "; 已完成" + gt.getStage().getName() + "业务, 调度下一步的业务：" + this.stageRepo.findByValue(gt.getStage().getNext()).getName();
///*      */     }
/* 1040 */     notif.setContent(content + extend);
/* 1041 */     notif.setTitle("车辆 " + gt.getRegisterRecord().getVehicleTraffic().getPlate());
/* 1042 */     notif.setActivitiGroup(ag);
/* 1043 */     notif.setTime(new Date());
/* 1044 */     this.commonService.createNotification(notif);
/*      */   }
/*      */   
/*      */   public List<GrainTraffic> getGrainTrafficAtDate(Date date, Boolean isFinished) {
/* 1048 */     Date date1 = new DateTime(date).withTimeAtStartOfDay().toDate();
/* 1049 */     Date date2 = new DateTime(date).plusDays(1).withTimeAtStartOfDay().toDate();
/* 1050 */     return this.gtRepo.findByOutTimeBetweenAndIsFinished(date1, date2, isFinished.booleanValue());
/*      */   }
/*      */   
/*      */   public void snapshotForGrainTraffic(IesCameraRegistry cr, GrainTraffic gt) {
/* 1054 */     DeviceCamera camera = cr.getCamera();
/* 1055 */     System.out.println("开始抓图");
/* 1056 */     if ((camera.getManufacturer() != null) && (camera.getManufacturer().getCodeId().intValue() == 1)) {
/* 1057 */       System.out.println("开始大华抓图" + camera.getId());
/*      */       try {
///* 1059 */         DjhuaCamera.getInstance().snapshot(cr, gt);
/*      */       } catch (Exception e) {
/* 1061 */         System.out.println("大华设备抓图失败");
/*      */       }
/*      */     }
/* 1064 */     if ((camera.getManufacturer() != null) && (camera.getManufacturer().getCodeId().intValue() == 3)) {
/* 1065 */       System.out.println("开始科达设备抓图" + camera.getId());
/* 1066 */       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
/* 1067 */       String dateString = dateFormat.format(new Date());
/* 1068 */       String path = String.format("C:/images/gt_%d_%s.jpeg", new Object[] { gt.getId(), dateString });
/* 1069 */       String relPath = String.format("/image/gt_%d_%s.jpeg", new Object[] { gt.getId(), dateString });
/*      */       try {
/* 1071 */         KdCamera.getInstance().snapshot(cr.getCamera(), path);
/*      */       } catch (Throwable e) {
/* 1073 */         System.out.println("科达设备抓图失败");
/*      */       }
/* 1075 */       IesCameraImage image = new IesCameraImage();
/* 1076 */       image.setGrainTraffic(gt);
/* 1077 */       image.setRegistry(cr);
/* 1078 */       image.setImagePath(relPath);
/* 1079 */       this.iesCameraImageRepository.save(image);
/*      */     }
/* 1081 */     if ((camera.getManufacturer() != null) && (camera.getManufacturer().getCodeId().intValue() == 2)) {
/* 1082 */       System.out.println("开始海康设备抓图" + camera.getId());
/* 1083 */       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
/* 1084 */       String dateString = dateFormat.format(new Date());
/* 1085 */       String path = String.format("C:/images/gt_%d_%s.jpg", new Object[] { gt.getId(), dateString });
/* 1086 */       String relPath = String.format("/image/gt_%d_%s.jpg", new Object[] { gt.getId(), dateString });
/*      */       try {
/* 1088 */         HkCamera.getInstance().snapshot(cr.getCamera(), path);
/*      */       } catch (Throwable e) {
/* 1090 */         System.out.println("海康设备抓图失败");
/*      */       }
/* 1092 */       IesCameraImage image = new IesCameraImage();
/* 1093 */       image.setGrainTraffic(gt);
/* 1094 */       image.setRegistry(cr);
/* 1095 */       image.setImagePath(relPath);
/* 1096 */       this.iesCameraImageRepository.save(image);
/*      */     }
/*      */   }

	
@Autowired
ServletContext servletContext;
public static final String MODEL_ICON_ROOT_PATH = "/WEB-INF/assets/myimage/";


	public void mySnapshotForGrainTraffic(IesCameraRegistry cr, GrainTraffic gt,String code) {
//		
//		System.out.println("开始抓拍.......");
//		DeviceCamera camera = cr.getCamera();
//		
//		VehicleTraffic vt=null;
//		VehicleTrafficRepository myvtRe=null;
//		if("REGISTER".equals(code)) {
//			vt=gt.getRegisterRecord().getVehicleTraffic();
//			myvtRe=vtRepo;
//		}
//		
//		
//		
//		
//		
//		int lUserID =MyShoot.myLogin(camera.getIpAddress(), "8000", camera.getUsername(), camera.getPassword());
//		
//		MyShoot.myShoot(cr, gt, this.iesCameraImageRepository,lUserID,camera.getIpAddress(),servletContext.getRealPath(MODEL_ICON_ROOT_PATH),vt,myvtRe,camera);		

	}


































/*      */   
/*      */   public void snapshotForTrafficCode(GrainTraffic gt, String code) {
/* 1101 */     List<IesCameraRegistry> crs = this.iesCameraRegistryRepository.findByTrafficModule_Code(code);
/* 1102 */     for (IesCameraRegistry cr : crs) {
///* 1103 */       snapshotForGrainTraffic(cr, gt);
					mySnapshotForGrainTraffic(cr,gt,code);
/*      */     }
/*      */   }
/*      */   
/*      */   public VehicleLicense createVehicleLicense(MultipartFile file, String plate) throws IOException {
/* 1108 */     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
/* 1109 */     Date time = new Date();
/* 1110 */     String dateString = dateFormat.format(time);
/* 1111 */     String filePreffix = String.format("vl_%s_%s", new Object[] { plate.replace(' ', '_'), dateString });
/* 1112 */     File licenseImage = File.createTempFile(filePreffix, "." + FilenameUtils.getExtension(file.getOriginalFilename()), new File("C:/images/"));
/* 1113 */     file.transferTo(licenseImage);
/*      */     
/* 1115 */     VehicleLicense vehicleLicense = new VehicleLicense();
/* 1116 */     vehicleLicense.setPlate(plate);
/* 1117 */     vehicleLicense.setTime(time);
/* 1118 */     vehicleLicense.setImagePath("/image/" + licenseImage.getName());
/* 1119 */     return (VehicleLicense)this.vlRepo.save(vehicleLicense);
/*      */   }
/*      */   
/*      */   public void createAuthorization(MultipartFile file, Long vtId) throws IOException {
/* 1123 */     VehicleTraffic vt = (VehicleTraffic)this.vtRepo.findOne(vtId);
/* 1124 */     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
/* 1125 */     Date time = new Date();
/* 1126 */     String dateString = dateFormat.format(time);
/* 1127 */     String filePreffix = String.format("vta_%s_%s", new Object[] { vt.getPlate().replace(' ', '_'), dateString });
/* 1128 */     File authorizationImage = File.createTempFile(filePreffix, "." + FilenameUtils.getExtension(file.getOriginalFilename()), new File("C:/images/"));
/* 1129 */     file.transferTo(authorizationImage);
/*      */     
/* 1131 */     vt.setAuthorizationPath("/image/" + authorizationImage.getName());
/* 1132 */     this.vtRepo.save(vt);
/*      */   }
/*      */   
/*      */   public VehicleLicense getVehicleLicenseByPlate(String plate) {
/* 1136 */     return this.vlRepo.findTop1ByPlateOrderByTimeDesc(plate);
/*      */   }


			public Analysis getIesAnaById(Long id) {
				return aRepo.findOne(id);
			}
			
			
			public void myUpdateIesAnalysis(Analysis a) {
				if(a.getId()==null) {
					System.out.println("没有ID 无法修改");
					return;
				}
				aRepo.save(a);
			}
			
			public void mySaveIesAnalysis(Analysis a) {
				
				aRepo.save(a);
			}
			
			
			



/*      */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\TrafficService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */