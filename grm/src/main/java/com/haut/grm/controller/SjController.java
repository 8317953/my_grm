/*     */ package com.haut.grm.controller;
/*     */ 
/*     */ import com.haut.grm.model.Cargo;
/*     */ import com.haut.grm.model.Company;
/*     */ import com.haut.grm.model.Compartment;
/*     */ import com.haut.grm.model.Depot;
/*     */ import com.haut.grm.model.DeviceCamera;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.business.GrainRotate;
/*     */ import com.haut.grm.model.business.StockId;
/*     */ import com.haut.grm.model.business.StockSum;
/*     */ import com.haut.grm.model.dto.TemperatureDataDto;
/*     */ import com.haut.grm.model.ies.GrainTraffic;
/*     */ import com.haut.grm.model.ies.WeightSheet;
/*     */ import com.haut.grm.model.meta.User;
/*     */ import com.haut.grm.repository.CargoRepository;
/*     */ import com.haut.grm.repository.CompanyRepository;
/*     */ import com.haut.grm.repository.CompartmentRepository;
/*     */ import com.haut.grm.repository.DepotRepository;
/*     */ import com.haut.grm.repository.DeviceCameraRepository;
/*     */ import com.haut.grm.repository.StoreRepository;
/*     */ import com.haut.grm.repository.business.GrainRotateRepository;
/*     */ import com.haut.grm.repository.business.StockIdRepository;
/*     */ import com.haut.grm.repository.business.StockSumRepository;
/*     */ import com.haut.grm.repository.ies.GrainTrafficRepository;
/*     */ import com.haut.grm.repository.meta.UserRepository;
/*     */ import com.haut.grm.service.CommonService;
///*     */ import com.haut.grm.shengju.ShengjuService;
/*     */ import com.haut.grm.util.TemperatureUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.joda.time.DateTime;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ import org.springframework.format.annotation.DateTimeFormat.ISO;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
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
/*     */ @RestController
/*     */ public class SjController
/*     */ {
/*     */   @Autowired
/*     */   private CompanyRepository companyRepo;
/*     */   @Autowired
/*     */   private StockIdRepository siRepo;
/*     */   @Autowired
/*     */   private DepotRepository depotRepo;
/*     */   @Autowired
/*     */   private StoreRepository storeRepo;
/*     */   @Autowired
/*     */   private CompartmentRepository compartmentRepo;
/*     */   @Autowired
/*     */   private CargoRepository cargoRepo;
/*     */   @Autowired
/*     */   private UserRepository userRepo;
/*     */   @Autowired
/*     */   private StockSumRepository sumRepo;
/*     */   @Autowired
/*     */   private GrainTrafficRepository gtRepo;
/*     */   @Autowired
/*     */   private GrainRotateRepository grRepo;
/*     */   @Autowired
/*     */   private DeviceCameraRepository cameraRepo;
/*     */   @Autowired
/*     */   private CommonService commonService;
/*     */   
/*     */   @RequestMapping(value={"/sj/company"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String company(@RequestParam String action)
/*     */     throws Throwable
/*     */   {
/*  86 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///*  87 */     return ShengjuService.getInstance().sendCompany(company, action);
				return null;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sj/company2"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String company2(@RequestParam String action) throws Throwable {
///*  92 */     return ShengjuService.getInstance().sendCompany2(action);
				return null;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sj/depot"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String depot(@RequestParam String action) throws Throwable {
/*  97 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
/*  98 */     Depot depot = (Depot)this.depotRepo.findOne(Long.valueOf(1L));
///*  99 */     return ShengjuService.getInstance().sendDepot(depot, company, action);
				return null;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sj/store"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String store(@RequestParam String action, @RequestParam Long id) throws Throwable {
/* 104 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
/* 105 */     Store store = this.storeRepo.getById(id);
///* 106 */     return ShengjuService.getInstance().sendStore(store, company, action);
				return null;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sj/stores"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String stores(@RequestParam String action) throws Throwable {
/* 111 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
/* 112 */     List<Store> stores = this.storeRepo.getByDepot_Id(Long.valueOf(1L));
///* 113 */     return ShengjuService.getInstance().sendStores(stores, company, action);
				return null;
/*     */   }
/*     */   
///*     */   @RequestMapping(value={"/sj/compartment"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String compartment(@RequestParam String action, @RequestParam Long id) throws Throwable {
///* 118 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 119 */     Compartment compartment = (Compartment)this.compartmentRepo.findOne(id);
///* 120 */     return ShengjuService.getInstance().sendCompartment(compartment, company, action);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/compartments"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String compartments(@RequestParam String action) throws Throwable {
///* 125 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 126 */     List<Compartment> compartments = this.compartmentRepo.findByStore_Depot_Id(1L);
///* 127 */     return ShengjuService.getInstance().sendCompartments(compartments, company, action);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/cargoes"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String cargoes(@RequestParam String action) throws Throwable {
///* 132 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 133 */     List<Cargo> cargoes = this.cargoRepo.findByCompartment_Store_Depot_Id(1L);
///* 134 */     return ShengjuService.getInstance().sendCargoes(cargoes, company, action);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/cargo"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String cargo(@RequestParam String action, @RequestParam Long id) throws Throwable {
///* 139 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 140 */     Cargo cargo = (Cargo)this.cargoRepo.findOne(id);
///* 141 */     return ShengjuService.getInstance().sendCargo(cargo, company, action);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/user"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String user(@RequestParam String action, @RequestParam Long id) throws Throwable {
///* 146 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 147 */     Depot depot = (Depot)this.depotRepo.findOne(Long.valueOf(1L));
///* 148 */     User data = (User)this.userRepo.findOne(id);
///* 149 */     return ShengjuService.getInstance().sendUser(data, company, depot, action);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/users"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String users(@RequestParam String action) throws Throwable {
///* 154 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 155 */     Depot depot = (Depot)this.depotRepo.findOne(Long.valueOf(1L));
///* 156 */     List<User> datas = this.userRepo.findAll();
///* 157 */     return ShengjuService.getInstance().sendUsers(datas, company, depot, action);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/stockSum"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String stockSum(@RequestParam String action, @RequestParam Long id) throws Throwable {
///* 162 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 163 */     StockSum data = (StockSum)this.sumRepo.findOne(id);
///* 164 */     return ShengjuService.getInstance().sendStockSum(data, company, action, this.commonService);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/stockSums"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String stockSums(@RequestParam String action) throws Throwable {
///* 169 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 170 */     List<StockSum> datas = this.sumRepo.findByCargo_Compartment_Store_Depot_Id(Long.valueOf(1L));
///* 171 */     return ShengjuService.getInstance().sendStockSums(datas, company, action, this.commonService);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/grainRotate"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String grainRotate(@RequestParam String action, @RequestParam Long id) throws Throwable {
///* 176 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 177 */     GrainRotate gr = (GrainRotate)this.grRepo.findOne(id);
///* 178 */     return ShengjuService.getInstance().sendGrainRotate(gr, company, action, this.commonService);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/grainTraffics"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String stockSums(@RequestParam String action, @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) Date date) throws Throwable {
///* 183 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 184 */     Date lastDate = new DateTime(date).minusDays(1).toDate();
///* 185 */     List<GrainTraffic> gts = this.gtRepo.findByOutTimeBetweenAndIsFinishedAndStage_Value(lastDate, date, true, Integer.valueOf(11));
///* 186 */     Map<GrainTraffic, StockId> maps = new HashMap();
///* 187 */     for (GrainTraffic gt : gts) {
///* 188 */       StockId stock = this.siRepo.currentCargo((Long)gt.getWeightSheet().getCargo().getId());
///* 189 */       maps.put(gt, stock);
///*     */     }
///* 191 */     return ShengjuService.getInstance().sendGrainTraffics(gts, company, action, maps, this.commonService);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/temp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String getTemperatureData(@RequestParam Long id, @RequestParam Long index) throws Throwable {
///* 196 */     Store store = (Store)this.storeRepo.findOne(id);
///* 197 */     String coreUrl = this.commonService.getSystemVariableWithKey("CORE_SERVICE_URL_3.0");
///* 198 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 199 */     TemperatureDataDto temp = TemperatureUtil.executeGetTemperature(coreUrl, store, Integer.valueOf(this.commonService.getSystemVariableWithKey("TEMP_WAIT")));
///* 200 */     return ShengjuService.getInstance().sendTemperature(temp, company, store, new Date(), index, "create");
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/camera"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String camera(@RequestParam String action, @RequestParam Long id) throws Throwable {
///* 205 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 206 */     Store store = (Store)this.storeRepo.findOne(id);
///* 207 */     return ShengjuService.getInstance().sendStore(store, company, action);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sj/cameras"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*     */   public String cameras(@RequestParam String action) throws Throwable {
///* 212 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///* 213 */     Depot depot = (Depot)this.depotRepo.findOne(Long.valueOf(1L));
///* 214 */     List<DeviceCamera> cameras = new ArrayList(this.cameraRepo.findByStore_Depot_IdOrStoreIsNull(Long.valueOf(1L)));
///* 215 */     return ShengjuService.getInstance().sendCameras(cameras, company, depot, action);
///*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\SjController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */