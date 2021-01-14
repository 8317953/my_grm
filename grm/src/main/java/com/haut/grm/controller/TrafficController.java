/*     */ package com.haut.grm.controller;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.GrainTrafficDetailedView;
/*     */ import com.haut.grm.json.view.Views.VehicleTrafficImageView;
/*     */ import com.haut.grm.json.view.Views.VehicleTrafficView;
/*     */ import com.haut.grm.model.business.Contract;
import com.haut.grm.model.business.StockSum;
/*     */ import com.haut.grm.model.dto.BalanceDto;
/*     */ import com.haut.grm.model.dto.WeightDto;
/*     */ import com.haut.grm.model.ies.Analysis;
/*     */ import com.haut.grm.model.ies.Card;
/*     */ import com.haut.grm.model.ies.DeductRecord;
/*     */ import com.haut.grm.model.ies.DeductRule;
/*     */ import com.haut.grm.model.ies.GrainTraffic;
/*     */ import com.haut.grm.model.ies.RegisterRecord;
/*     */ import com.haut.grm.model.ies.VehicleLicense;
/*     */ import com.haut.grm.model.ies.VehicleTraffic;
/*     */ import com.haut.grm.model.type.AnalysisLevel;
/*     */ import com.haut.grm.model.type.AnalysisType;
/*     */ import com.haut.grm.model.type.CardType;
/*     */ import com.haut.grm.model.type.PackageType;
/*     */ import com.haut.grm.model.type.PlanType;
/*     */ import com.haut.grm.model.type.TrafficType;
/*     */ import com.haut.grm.repository.ies.GrainTrafficRepository;
/*     */ import com.haut.grm.repository.ies.VehicleTrafficRepository;
/*     */ import com.haut.grm.service.TrafficService;
/*     */ import com.haut.grm.util.ScaleSocketUtil;


/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.validation.Valid;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ import org.springframework.format.annotation.DateTimeFormat.ISO;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ import org.springframework.web.multipart.MultipartException;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ public class TrafficController
/*     */ {
/*     */   @Autowired
/*     */   private TrafficService trafficService;
/*     */   @Autowired
/*     */   private GrainTrafficRepository gtRepo;
/*     */   @Autowired
/*     */   private VehicleTrafficRepository vtRepo;
/*     */   
/*     */   @RequestMapping(value={"/create/vehicle_license"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public VehicleLicense uploadVehicleLicenseImage(@RequestParam MultipartFile file, @RequestParam String plate, Model model)
/*     */     throws MultipartException, IOException
/*     */   {
/*  61 */     return this.trafficService.createVehicleLicense(file, plate);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/vehicle_traffic/authorization"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void uploadAuthorizationImage(@RequestParam MultipartFile file, @RequestParam Long vtId, Model model) throws MultipartException, IOException {
/*  66 */     this.trafficService.createAuthorization(file, vtId);
/*     */   }
/*     */   
///*     */   @RequestMapping(value={"/generate/sc"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public void generateStockChangeFromGrainTrafficIn24HoursAtDate(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) Date time) {
///*  71 */     this.trafficService.generateStockChangeFromGrainTrafficIn24HoursAtDate(time);
///*     */   }
/*     */  
/*     */   @RequestMapping(value={"/count/grain_traffic"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countGrainTraffic() {
/*  76 */     return this.gtRepo.count();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/count/vehicle_traffic"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countVehicleTraffic() {
/*  81 */     return this.vtRepo.count();
/*     */   }



@RequestMapping(value={"/gettraffic/isfinished"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
@JsonView({Views.GrainTrafficDetailedView.class})
/*     */   public List<GrainTraffic> getTrafficsIsFinshed() {
/*  81 */     return this.trafficService.getGrainTrafficFinished();
/*     */   }


/*     */   
/*     */   @RequestMapping(value={"/retrieve/vehicle_traffics/filtered"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*     */   public List<VehicleTraffic> getVehicleTrafficsFiltered(@Valid String filter) {
/*  87 */     return this.trafficService.getVehicleTrafficsFiltered(filter);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/vehicle_traffics/available"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*     */   public List<VehicleTraffic> getVehicleTrafficsAvailable() {
/*  93 */     return this.trafficService.getVehicleTrafficsAvailable();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/vehicle_traffic"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.VehicleTrafficImageView.class})
/*     */   public VehicleTraffic getVehicleTraffic(@RequestParam Long id) {
			//System.out.println(id);
/*  99 */     return this.vtRepo.getById(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/delete/vehicle_traffic"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
/*     */   public void deleteVehicleTraffic(@RequestParam Long id) {
/* 104 */     this.trafficService.deleteVehicleTraffic(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/vehicle_traffics/registerable/filtered"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*     */   public List<VehicleTraffic> getVehicleTrafficsRegisterableFiltered(@Valid String filter) {
				//System.out.println("filter:"+filter);
/* 110 */     return this.trafficService.getVehicleTrafficsRegisterableFiltered(filter);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/vehicle_traffics/registerable"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*     */   public List<VehicleTraffic> getVehicleTrafficsRegisterable() {
				//System.out.println("getVehicleTrafficsRegisterable");
/* 116 */     return this.trafficService.getVehicleTrafficsRegisterable();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/card_using/{code}/{using}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updateCardUsing(@PathVariable String code, @PathVariable Boolean using) {
/* 121 */     this.trafficService.updateCardUsing(code, using);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/card_active/{code}/{active}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updateCardActive(@PathVariable String code, @PathVariable Boolean active) {
/* 126 */     this.trafficService.updateCardActive(code, active);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/card_by_physical/{code}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public Card getCardByPhysical(@PathVariable String code) {
/* 131 */     return this.trafficService.getCardByPhysical(code);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/card_by_print/{code}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public Card getCardsByPrint(@PathVariable String code) {
/* 136 */     return this.trafficService.getCardByPrint(code);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/cards/filtered"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public List<Card> getCardsFiltered(@Valid String filter) {
/* 141 */     return this.trafficService.getCardsFiltered(filter);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/vehicle_traffics/recent"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*     */   public List<VehicleTraffic> getVehicleTrafficsRecent() {
/* 147 */     return this.trafficService.getRecent3VehicleTraffics();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/vehicle_traffic"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public VehicleTraffic createVehicleTraffic(@RequestBody VehicleTraffic vehicleTraffic) {
/* 152 */     return this.trafficService.createVehicleTraffic(vehicleTraffic);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/register_record"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public RegisterRecord createRegisterRecord(@RequestBody RegisterRecord registerRecord) {
/* 157 */     return this.trafficService.createRegisterRecord(registerRecord);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/grain_traffic/{cardCode}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public GrainTraffic createGrainTraffic(@PathVariable String cardCode, @RequestBody RegisterRecord registerRecord) {
/* 162 */     return this.trafficService.createGrainTraffic(cardCode, registerRecord);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/register_record/{card}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public RegisterRecord getRegisterRecord(@PathVariable String card) {
/* 167 */     return this.trafficService.getRegisterRecordByCardCode(card);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/contracts/filtered"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public List<Contract> getContractsFiltered(@Valid String filter) {
/* 172 */     return this.trafficService.getContractsFiltered(filter);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/traffic_types"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public List<TrafficType> getAllTrafficTypes() {
/* 177 */     return this.trafficService.getAllTrafficTypes();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/package_types"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public List<PackageType> getAllPackageTypes() {
/* 182 */     return this.trafficService.getAllPackageTypes();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/analysis_types"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public List<AnalysisType> getAllAnalysisTypes() {
/* 187 */     return this.trafficService.getAllAnalysisTypes();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/grain_traffic/{code}/stage/{officialId}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updateGrainTrafficStage(@PathVariable String code, @PathVariable Integer officialId) {
/* 192 */     this.trafficService.updateGrainTrafficStage(code, officialId);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/allocate/grain_traffic/{code}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void allocateGrainTrafficStage(@PathVariable String code) {
/* 197 */     this.trafficService.allocateGrainTraffic(code);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/allocate/grain_traffic/{code}/second"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void allocateGrainTrafficForSecond(@PathVariable String code, @RequestBody BalanceDto balance) {
/* 202 */     this.trafficService.allocateGrainTrafficForSecond(code, balance);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/allocate/grain_traffic/{code}/manager/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void allocateGrainTrafficForManager(@PathVariable String code, @PathVariable Long id) {
/* 207 */     this.trafficService.allocateGrainTrafficForManager(code, id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/analysis/{cardCode}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void createAnalysis(@PathVariable String cardCode) {
/* 212 */     this.trafficService.createAnalysis(cardCode);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/{cardCode}/first_weight"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void createWeight(@PathVariable String cardCode, @RequestBody WeightDto weight) {
	//System.out.println(cardCode);
	
	//System.out.println(weight.getStoreId());
/* 217 */     this.trafficService.createWeight(cardCode, weight);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/{cardCode}/second_weight"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void secondWeight(@PathVariable String cardCode, @RequestBody WeightDto weight) {
/* 222 */     this.trafficService.secondWeight(cardCode, weight);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/confirm/{cardCode}/weight"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void confirmWeight(@PathVariable String cardCode, @RequestBody WeightDto weight) {
/* 227 */     this.trafficService.confirmWeight(cardCode, weight);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/{cardCode}/balance"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void createBalance(@PathVariable String cardCode, @RequestBody BalanceDto balance) {
/* 232 */     this.trafficService.createBalance(cardCode, balance);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/grain_traffic/code/{code}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public GrainTraffic getGrainTrafficByCode(@PathVariable String code) {
/* 237 */     return this.trafficService.getGrainTrafficByCode(code);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/grain_traffic/{cardCode}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public GrainTraffic getGrainTrafficByCardCode(@PathVariable String cardCode) {
/* 242 */     return this.trafficService.getGrainTraffic(cardCode);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/grain_traffic/active"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.GrainTrafficDetailedView.class})
/*     */   public List<GrainTraffic> getGrainTrafficActive() {
/* 248 */     return this.trafficService.getGrainTrafficActive();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/grain_traffic/led"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.GrainTrafficDetailedView.class})
/*     */   public List<GrainTraffic> getGrainTrafficForLed() {
/* 254 */     return this.trafficService.getGrainTrafficForLed();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/grain_traffic/led/top10"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.GrainTrafficDetailedView.class})
/*     */   public List<GrainTraffic> getGrainTrafficForLedTop10() {
/* 260 */     return this.trafficService.getGrainTrafficForLedTop10();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/grain_traffic/at_date"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.GrainTrafficDetailedView.class})
/*     */   public List<GrainTraffic> getGrainTrafficAtDate(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date date, @RequestParam(required=false) Boolean isFinished) {
/* 266 */     return this.trafficService.getGrainTrafficAtDate(date, isFinished);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/grain_traffic/personnel_id/{personnelId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public GrainTraffic getGrainTrafficByPersonnelId(@PathVariable String personnelId) {
/* 271 */     return this.trafficService.getGrainTrafficByPersonnelId(personnelId);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/grain_traffic/barcode"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public GrainTraffic getGrainTrafficByEncryptedBarcode(@RequestParam String barcode) throws Exception {
/* 276 */     return this.trafficService.getGrainTrafficByEncryptedBarcode(barcode);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/analysis"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updateAnalysis(@RequestBody Analysis a) throws Exception {
/* 281 */     this.trafficService.updateAnalysis(a);
//StockSum
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/grain_traffic/{cardCode}/{cardCode2}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public GrainTraffic updateGrainTrafficCardCode(@PathVariable String cardCode, @PathVariable String cardCode2) {
/* 286 */     return this.trafficService.updateGrainTrafficCardCode(cardCode, cardCode2);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/grain_traffic/{cardNumber}/leave"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void leave(@PathVariable String cardNumber) {
/* 291 */     this.trafficService.leave(cardNumber);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/barcode/{cardCode}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @ResponseBody
/*     */   public String getBase64EncryptedBarCode(@PathVariable String cardCode) throws Exception {
			  
	
			//总结一下这个就是 通过扦样完成后关联到的检验空数据的barcode 进行加密后 形成一个字符串
			  String str=this.trafficService.getBase64EncryptedBarCode(cardCode);
			  //System.out.println(str);
	
/* 297 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/create/card"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void createCard(@RequestBody Card card)
/*     */   {
/* 317 */     this.trafficService.createCard(card);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/card_type"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void createCardType(@RequestBody CardType cardType) {
/* 322 */     this.trafficService.createCardType(cardType);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/card"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updateCard(@RequestBody Card card) throws Exception {
/* 327 */     this.trafficService.updateCard(card);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/card_type"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updateCardType(@RequestBody CardType cardType) throws Exception {
/* 332 */     this.trafficService.updateCardType(cardType);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/card_types"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public List<CardType> getAllCardTypes() {
/* 337 */     return this.trafficService.getAllCardTypes();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/delete/card"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void deleteCard(@RequestBody Card card) throws Exception {
/* 342 */     this.trafficService.deleteCard(card);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/delete/card_type"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void deleteCardType(@RequestBody CardType cardType) throws Exception {
/* 347 */     this.trafficService.deleteCardType(cardType);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/deduct_rule"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void createDeductRule(@RequestBody DeductRule deductRule) {
/* 352 */     this.trafficService.createDeductRule(deductRule);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/deduct_record"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void createDeductRecord(@RequestBody DeductRecord deductRecord) {
/* 357 */     this.trafficService.createDeductRecord(deductRecord);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/analysis_level"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void createAnalysisLevel(@RequestBody AnalysisLevel analysisLevel) {
/* 362 */     this.trafficService.createAnalysisLevel(analysisLevel);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/plan_type"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void createPlanType(@RequestBody PlanType planType) {
/* 367 */     this.trafficService.createPlanType(planType);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/deduct_rule"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 371 */   public void updateDeductRule(@RequestBody DeductRule deductRule) { this.trafficService.updateDeductRule(deductRule); }
/*     */   
/*     */   @RequestMapping(value={"/update/deduct_record"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updateDeductRecord(@RequestBody DeductRecord deductRecord)
/*     */   {
/* 376 */     this.trafficService.updateDeductRecord(deductRecord);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/analysis_level"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updateAnalysisLevel(@RequestBody AnalysisLevel analysisLevel) {
/* 381 */     this.trafficService.updateAnalysisLevel(analysisLevel);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/plan_type"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updatePlanType(@RequestBody PlanType planType) {
/* 386 */     this.trafficService.updatePlanType(planType);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/delete/deduct_rule"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void deleteDeductRule(@RequestBody DeductRule deductRule) {
/* 391 */     this.trafficService.deleteDeductRule(deductRule);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/delete/deduct_record"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void deleteDeductRecord(@RequestBody DeductRecord deductRecord) {
/* 396 */     this.trafficService.deleteDeductRecord(deductRecord);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/delete/analysis_level"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void deleteAnalysisLevel(@RequestBody AnalysisLevel analysisLevel) {
/* 401 */     this.trafficService.deleteAnalysisLevel(analysisLevel);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/delete/plan_type"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void deletePlanType(@RequestBody PlanType planType) {
/* 406 */     this.trafficService.deletePlanType(planType);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/rollback/register/{cardCode}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void rollbackRegister(@PathVariable String cardCode) {
/* 411 */     this.trafficService.rollbackRegister(cardCode);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/plan_types"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public List<PlanType> getAllPlanTypes() {
/* 416 */     return this.trafficService.getAllPlanTypes();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/analysis_levels"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public List<AnalysisLevel> getAllAnalysisLevels() {
/* 421 */     return this.trafficService.getAllAnalysisLevels();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/vehicle_license/{plate}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public VehicleLicense getVehicleLicenseByPlate(@PathVariable String plate) {
/* 426 */     return this.trafficService.getVehicleLicenseByPlate(plate);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/scale_weight"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public Integer getWeight() {
	
/* 431 */     return Integer.valueOf(ScaleSocketUtil.getWeight());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/snapshot/static_image"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void snapshotForTrafficCode(@RequestParam Long gtId, @RequestParam String code) {
/* 436 */     this.trafficService.snapshotForTrafficCode((GrainTraffic)this.gtRepo.findOne(gtId), code);
/*     */   }

//	@RequestMapping(value={"/mydebug/stock"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
//	public void myDebugGbStock() {
//		//System.out.println("myDebugGbStock----------------------------------------");
//		
////		if(true) {
////			return;
////		}
//		
//		this.trafficService.generateStockChangeFromGrainTrafficIn_myself();
//		
//	}
	
	
	
	@RequestMapping(value={"/retrieve/led/turnoff"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public void ledTurnOff() {
		this.trafficService.turnOffLed();
	}

	
	@RequestMapping(value={"/retrieve/led/turnon"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public void ledTurnOn() {
		this.trafficService.turnOnLed();
	}
	
	
	@RequestMapping(value={"/retrieve/led/sendtext/{text}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public void ledSendText(@PathVariable String text) {
		this.trafficService.sendLedText(text);
	}
	
	@RequestMapping(value={"/getana/byid/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	@JsonView({Views.AnalysisView.class})
	public Analysis getAnalysisById(@PathVariable Long id) {
		return this.trafficService.getIesAnaById(id);
	}
	
	
	@RequestMapping(value={"/update/iesana"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public void updateIesAna(@RequestBody Analysis ana) {
		this.trafficService.myUpdateIesAnalysis(ana);
	}
	
	@RequestMapping(value={"/save/iesana"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public void saveIesAna(@RequestBody Analysis ana) {
		this.trafficService.mySaveIesAnalysis(ana);
	}
	
	
	

}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\TrafficController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */