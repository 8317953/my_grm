/*     */ package com.haut.grm.controller;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
/*     */ import com.haut.grm.datatables.repository.BusinessNotificationDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.ContractDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.EntryDoorDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.EntryMeasureDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.EntrySafetyDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.EntryTemperatureDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.GrainRotateDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.IesCameraRegistryDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.MaterialRequestDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.MaterialStockDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.MedicineRequestDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.MedicineStockDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.RoleDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.StockAnalysisDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.StockChangeDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.StockIdDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.UserDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.VehicleLicenseDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.VehicleTrafficDataTablesRepository;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.GrainTrafficForDataTablesView;
/*     */ import com.haut.grm.json.view.Views.VehicleTrafficForDatatableView;
/*     */ import com.haut.grm.model.DeviceCamera;
import com.haut.grm.model.MyFenIesSheet;
import com.haut.grm.model.Plane;
/*     */ import com.haut.grm.model.QCargo;
/*     */ import com.haut.grm.model.QCompartment;
/*     */ import com.haut.grm.model.QDepot;
/*     */ import com.haut.grm.model.QDoor;
/*     */ import com.haut.grm.model.QStore;
/*     */ import com.haut.grm.model.business.BusinessNotification;
/*     */ import com.haut.grm.model.business.Client;
/*     */ import com.haut.grm.model.business.Contract;
/*     */ import com.haut.grm.model.business.GrainPlan;
/*     */ import com.haut.grm.model.business.GrainRotate;
/*     */ import com.haut.grm.model.business.MaterialStock;
/*     */ import com.haut.grm.model.business.MedicineRequest;
/*     */ import com.haut.grm.model.business.MedicineStock;
/*     */ import com.haut.grm.model.business.QBusinessNotification;
/*     */ import com.haut.grm.model.business.QContract;
/*     */ import com.haut.grm.model.business.QGrainRotate;
/*     */ import com.haut.grm.model.business.QMaterialRequest;
/*     */ import com.haut.grm.model.business.QMaterialStock;
/*     */ import com.haut.grm.model.business.QMedicineRequest;
/*     */ import com.haut.grm.model.business.QMedicineStock;
/*     */ import com.haut.grm.model.business.QStockAnalysis;
/*     */ import com.haut.grm.model.business.QStockChange;
/*     */ import com.haut.grm.model.business.QStockId;
/*     */ import com.haut.grm.model.business.StockAnalysis;
/*     */ import com.haut.grm.model.business.StockChange;
/*     */ import com.haut.grm.model.business.StockId;
/*     */ import com.haut.grm.model.dto.EntryDataInput;
/*     */ import com.haut.grm.model.dto.GrainRotateDto;
/*     */ import com.haut.grm.model.dto.SearchDto;
/*     */ import com.haut.grm.model.dto.StockChangeDto;
/*     */ import com.haut.grm.model.dto.VehicleTrafficInput;
/*     */ import com.haut.grm.model.entry.DoorCollect;
/*     */ import com.haut.grm.model.entry.EntryTemperature;
/*     */ import com.haut.grm.model.entry.MeasureDiff;
/*     */ import com.haut.grm.model.entry.QEntryDoor;
/*     */ import com.haut.grm.model.entry.QEntryMeasure;
/*     */ import com.haut.grm.model.entry.QEntrySafety;
/*     */ import com.haut.grm.model.entry.QEntryTemperature;
/*     */ import com.haut.grm.model.ies.BalanceSheet;
/*     */ import com.haut.grm.model.ies.DeductRecord;
/*     */ import com.haut.grm.model.ies.DeductRule;
/*     */ import com.haut.grm.model.ies.GrainTraffic;
/*     */ import com.haut.grm.model.ies.IesCameraRegistry;
/*     */ import com.haut.grm.model.ies.QVehicleTraffic;
/*     */ import com.haut.grm.model.ies.VehicleTraffic;
/*     */ import com.haut.grm.model.ies.WeightSheet;
/*     */ import com.haut.grm.model.meta.ActivitiGroup;
/*     */ import com.haut.grm.model.meta.QActivitiGroup;
/*     */ import com.haut.grm.model.meta.QUser;
/*     */ import com.haut.grm.model.meta.Role;
/*     */ import com.haut.grm.model.meta.User;
/*     */ import com.haut.grm.model.standalone.LoadCompany;
/*     */ import com.haut.grm.model.standalone.StandaloneLocation;
/*     */ import com.haut.grm.model.system.SystemLog;
/*     */ import com.haut.grm.model.system.SystemVariable;
/*     */ import com.haut.grm.model.type.QAnalysisType;
import com.haut.grm.model.wenzhou.OutInLetter;
import com.haut.grm.repository.MyFenIesSheetRepository;
/*     */ import com.haut.grm.repository.meta.UserRepository;
/*     */ import com.haut.grm.service.AuthUserService;
/*     */ import com.haut.grm.service.DataTablesService;
/*     */ import com.querydsl.core.BooleanBuilder;
/*     */ import com.querydsl.core.types.dsl.BooleanExpression;
/*     */ import com.querydsl.core.types.dsl.BooleanPath;
/*     */ import com.querydsl.core.types.dsl.DateTimePath;
/*     */ import com.querydsl.core.types.dsl.NumberPath;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.validation.Valid;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
/*     */ import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @org.springframework.web.bind.annotation.RestController
/*     */ public class DataTablesController
/*     */ {
/*     */   @Autowired
/*     */   DataTablesService dataTablesService;
/*     */   @Autowired
/*     */   MedicineRequestDataTablesRepository medicineRequestRepo;
/*     */   @Autowired
/*     */   MedicineStockDataTablesRepository medicineStockRepo;
/*     */   @Autowired
/*     */   MaterialStockDataTablesRepository materialStockRepo;
/*     */   @Autowired
/*     */   MaterialRequestDataTablesRepository materialRequestRepo;
/*     */   @Autowired
/*     */   StockIdDataTablesRepository stockIdRepo;
/*     */   @Autowired
/*     */   StockChangeDataTablesRepository stockChangeRepo;
/*     */   @Autowired
/*     */   StockAnalysisDataTablesRepository stockAnalysisRepo;
/*     */   @Autowired
/*     */   VehicleTrafficDataTablesRepository vtRepo;
/*     */   @Autowired
/*     */   EntryMeasureDataTablesRepository emRepo;
/*     */   @Autowired
/*     */   EntrySafetyDataTablesRepository esRepo;
/*     */   @Autowired
/*     */   EntryTemperatureDataTablesRepository etRepo;
/*     */   @Autowired
/*     */   EntryDoorDataTablesRepository edRepo;
/*     */   @Autowired
/*     */   BusinessNotificationDataTablesRepository bnRepo;
/*     */   @Autowired
/*     */   GrainRotateDataTablesRepository grRepo;
/*     */   @Autowired
/*     */   UserDataTablesRepository _userRepo;
/*     */   @Autowired
/*     */   RoleDataTablesRepository roleRepo;
/*     */   @Autowired
/*     */   UserRepository userRepo;
/*     */   @Autowired
/*     */   ContractDataTablesRepository cRepo;
/*     */   @Autowired
/*     */   IesCameraRegistryDataTablesRepository irRepo;
/*     */   @Autowired
/*     */   VehicleLicenseDataTablesRepository vlRepo;

@Autowired
MyFenIesSheetRepository myFenIesSheetRepo;
/*     */   
/*     */   @RequestMapping(value={"/datatable/stockChanges"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<StockChange> getStockChanges(@Valid StockChangeDto input)
/*     */   {
/* 147 */     BooleanBuilder where = new BooleanBuilder();
/* 148 */     QStockChange _stockChange = QStockChange.stockChange;
/* 149 */     if (input.getQueryStart() != null) {
/* 150 */       where.and(_stockChange.inputTime.after(input.getQueryStart()));
/*     */     }
/* 152 */     if (input.getQueryEnd() != null) {
/* 153 */       where.and(_stockChange.inputTime.before(input.getQueryEnd()));
/*     */     }
/* 155 */     if (input.getTypeId() != null) {
/* 156 */       where.and(_stockChange.type.id.eq(input.getTypeId()));
/*     */     }
/* 158 */     if (input.getStockId() != null) {
/* 159 */       where.and(_stockChange.sourceStock.id.eq(input.getStockId())
/* 160 */         .or(_stockChange.targetStock.id.eq(input.getStockId())));
/*     */     }
/* 162 */     else if (input.getDepotId() != null) {
/* 163 */       if ((input.getTypeId() != null) && ((input.getTypeId().equals(new Long(1L))) || (input.getTypeId().equals(new Long(3L))) || (input.getTypeId().equals(new Long(5L))))) {
/* 164 */         where.and(_stockChange.sourceStock.cargo.compartment.store.depot.id.eq(input.getDepotId()));
/*     */       }
/* 166 */       if ((input.getTypeId() != null) && ((input.getTypeId().equals(new Long(2L))) || (input.getTypeId().equals(new Long(4L))))) {
/* 167 */         where.and(_stockChange.targetStock.cargo.compartment.store.depot.id.eq(input.getDepotId()));
/*     */       }
/*     */     }
/* 170 */     if (input.getStockId2() != null) {
/* 171 */       where.and(_stockChange.sourceStock.id.eq(input.getStockId2()));
/*     */     }
/* 173 */     else if ((input.getDepotId2() != null) && 
/* 174 */       (input.getTypeId() != null) && (input.getTypeId().equals(new Long(1L)))) {
/* 175 */       where.and(_stockChange.targetStock.cargo.compartment.store.depot.id.eq(input.getDepotId2()));
/*     */     }
/*     */     
/* 178 */     return this.stockChangeRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/stockAnalyses"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<StockAnalysis> getStockAnalyses(@Valid StockChangeDto input) {
/* 183 */     BooleanBuilder where = new BooleanBuilder();
/* 184 */     QStockAnalysis _stockAnalysis = QStockAnalysis.stockAnalysis;
/* 185 */     if (input.getQueryStart() != null) {
/* 186 */       where.and(_stockAnalysis.inputTime.after(input.getQueryStart()));
/*     */     }
/* 188 */     if (input.getQueryEnd() != null) {
/* 189 */       where.and(_stockAnalysis.inputTime.before(input.getQueryEnd()));
/*     */     }
/* 191 */     if (input.getTypeId() != null) {
/* 192 */       where.and(_stockAnalysis.type.id.eq(input.getTypeId()));
/*     */     }
/* 194 */     if (input.getDepotId() != null) {
/* 195 */       where.and(_stockAnalysis.stock.cargo.compartment.store.depot.id.eq(input.getDepotId()));
/*     */     }
/* 197 */     if (input.getStockId() != null) {
/* 198 */       where.and(_stockAnalysis.stock.id.eq(input.getStockId()));
/*     */     }
/* 200 */     return this.stockAnalysisRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/stockIds"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<StockId> getStockIds(@Valid StockChangeDto input) {
/* 205 */     BooleanBuilder where = new BooleanBuilder();
/* 206 */     QStockId _stockId = QStockId.stockId;
/* 207 */     if (input.getQueryStart() != null) {
/* 208 */       where.and(_stockId.inputTime.after(input.getQueryStart()));
/*     */     }
/* 210 */     if (input.getQueryEnd() != null) {
/* 211 */       where.and(_stockId.inputTime.before(input.getQueryEnd()));
/*     */     }
/* 213 */     if (input.getDepotId() != null) {
/* 214 */       where.and(_stockId.cargo.compartment.store.depot.id.eq(input.getDepotId()));
/*     */     }
/* 216 */     if (input.getStockId() != null) {
/* 217 */       where.and(_stockId.id.eq(input.getStockId()));
/*     */     }
/* 219 */     return this.stockIdRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/contracts"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<Contract> getContracts(@Valid StockChangeDto input) {
/* 224 */     BooleanBuilder where = new BooleanBuilder();
/* 225 */     QContract _contract = QContract.contract;
/* 226 */     if (input.getDepotId() != null) {
/* 227 */       where.and(_contract.depot.id.eq(input.getDepotId()));
/*     */     }
/* 229 */     return this.cRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/grainRotates"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<GrainRotate> getGrainRotates(@Valid GrainRotateDto input) {
/* 234 */     BooleanBuilder where = new BooleanBuilder();
/* 235 */     QGrainRotate _grainRotate = QGrainRotate.grainRotate;
/* 236 */     if (input.getIngress() != null) {
/* 237 */       where.and(_grainRotate.isIngress.eq(input.getIngress()));
/*     */     }
/* 239 */     return this.grRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/notifications"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<BusinessNotification> getNotifs(@Valid SearchDto input, @org.springframework.web.bind.annotation.RequestParam(required=false) Boolean isIndividual) {
/* 244 */     BooleanBuilder where = new BooleanBuilder();
/* 245 */     QBusinessNotification _notif = QBusinessNotification.businessNotification;
/* 246 */     if (isIndividual.booleanValue()) {
/* 247 */       where.and(_notif.user.isNotNull());
/* 248 */       where.and(_notif.user.eq(AuthUserService.getCurrentUser(userRepo)));
/*     */     }
/*     */     else {
/* 251 */       where.and(_notif.activitiGroup.isNotNull());
/* 252 */       if (AuthUserService.getCurrentUser(userRepo) != null) {
/* 253 */         Set<ActivitiGroup> ags = new java.util.HashSet();
/* 254 */         for (Role role : this.userRepo.readById((Long)AuthUserService.getCurrentUser(userRepo).getId()).getRoles()) {
/* 255 */           ags.addAll(role.getActivitiGroups());
/*     */         }
/* 257 */         where.and(_notif.activitiGroup.in(ags));
/*     */       }
/*     */     }
/*     */     
/* 261 */     return this.bnRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/materialRequests"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<com.haut.grm.model.business.MaterialRequest> getMaterialRequests(@Valid SearchDto input) {
/* 266 */     BooleanBuilder where = new BooleanBuilder();
/* 267 */     QMaterialRequest _data = QMaterialRequest.materialRequest;
/* 268 */     if (input.getQueryStart() != null) {
/* 269 */       where.and(_data.inputTime.after(input.getQueryStart()));
/*     */     }
/* 271 */     if (input.getQueryEnd() != null) {
/* 272 */       where.and(_data.inputTime.before(input.getQueryEnd()));
/*     */     }
/* 274 */     return this.materialRequestRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/materialStocks"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<MaterialStock> getMaterialStocks(@Valid SearchDto input) {
/* 279 */     BooleanBuilder where = new BooleanBuilder();
/* 280 */     QMaterialStock _data = QMaterialStock.materialStock;
/* 281 */     if (input.getQueryStart() != null) {
/* 282 */       where.and(_data.inputTime.after(input.getQueryStart()));
/*     */     }
/* 284 */     if (input.getQueryEnd() != null) {
/* 285 */       where.and(_data.inputTime.before(input.getQueryEnd()));
/*     */     }
/* 287 */     return this.materialStockRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/medicineRequests"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<MedicineRequest> getMedicineRequests(@Valid SearchDto input) {
/* 292 */     BooleanBuilder where = new BooleanBuilder();
/* 293 */     QMedicineRequest _data = QMedicineRequest.medicineRequest;
/* 294 */     if (input.getQueryStart() != null) {
/* 295 */       where.and(_data.inputTime.after(input.getQueryStart()));
/*     */     }
/* 297 */     if (input.getQueryEnd() != null) {
/* 298 */       where.and(_data.inputTime.before(input.getQueryEnd()));
/*     */     }
/* 300 */     return this.medicineRequestRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/medicineStocks"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<MedicineStock> getMedicineStocks(@Valid SearchDto input) {
/* 305 */     BooleanBuilder where = new BooleanBuilder();
/* 306 */     QMedicineStock _data = QMedicineStock.medicineStock;
/* 307 */     if (input.getQueryStart() != null) {
/* 308 */       where.and(_data.inputTime.after(input.getQueryStart()));
/*     */     }
/* 310 */     if (input.getQueryEnd() != null) {
/* 311 */       where.and(_data.inputTime.before(input.getQueryEnd()));
/*     */     }
/* 313 */     return this.medicineStockRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/vehicle_licenses"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<com.haut.grm.model.ies.VehicleLicense> getVehicleLicenses(@Valid DataTablesInput input) {
/* 318 */     return this.vlRepo.findAll(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/camera_registries"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<IesCameraRegistry> getCameraRegistries(@Valid DataTablesInput input) {
/* 323 */     return this.irRepo.findAll(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/cameras"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<DeviceCamera> getCameras(@Valid DataTablesInput input) {
/* 328 */     return this.dataTablesService.getCameras(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/users"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<User> getUsers(@Valid DataTablesInput input) {
/* 333 */     return this._userRepo.findAll(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/roles"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<Role> getRoles(@Valid DataTablesInput input) {
/* 338 */     return this.roleRepo.findAll(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/locations"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<StandaloneLocation> getLocations(@Valid DataTablesInput input) {
/* 343 */     return this.dataTablesService.getLocations(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/loadCompanies"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<LoadCompany> getLoadCompaniess(@Valid DataTablesInput input) {
/* 348 */     return this.dataTablesService.getLoadCompanies(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/years"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<com.haut.grm.model.standalone.Year> getYears(@Valid DataTablesInput input) {
/* 353 */     return this.dataTablesService.getYears(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/door_collects"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<DoorCollect> getDoorCollects(@Valid SearchDto input) {
/* 358 */     return this.dataTablesService.getDoorCollects(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/measure_diffs"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<MeasureDiff> getMeasureDiffs(@Valid SearchDto input) {
/* 363 */     return this.dataTablesService.getMeasureDiffs(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/vehicle_traffics"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.VehicleTrafficForDatatableView.class})
/*     */   public DataTablesOutput<VehicleTraffic> getVehicleTraffics(@ModelAttribute VehicleTrafficInput input) {
/* 369 */     BooleanBuilder where = new BooleanBuilder();
/* 370 */     QVehicleTraffic _data = QVehicleTraffic.vehicleTraffic;
///* 371 */     if (input.getQueryStart() != null) {
///* 372 */       where.and(_data.time.after(input.getQueryStart()));
///*     */     }
///* 374 */     if (input.getQueryEnd() != null) {
///* 375 */       where.and(_data.time.before(input.getQueryEnd()));
///*     */     }
///* 377 */     if (input.getIsIn() != null) {
///* 378 */       where.and(_data.in.eq(input.getIsIn()));
///*     */     }
///* 380 */     if (input.getIsRegistered() != null) {
///* 381 */       where.and(_data.registered.eq(input.getIsRegistered()));
///*     */     }
				
if(input.getContractid()!=null) {
//	System.out.println(input.getContractid());
	where.and(_data.contract.id.eq(input.getContractid()));
	
	if (input.getIsRegistered() != null) {
		where.and(_data.registered.eq(input.getIsRegistered()));
	}
}else {
	where.and(_data.contract.id.eq(-1l));
}



/* 383 */     return this.vtRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/clients"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<Client> getClients(@Valid DataTablesInput input) {
/* 388 */     return this.dataTablesService.getClients(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/grain_plans"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<GrainPlan> getGrainPlans(@Valid DataTablesInput input) {
/* 393 */     return this.dataTablesService.getGrainPlans(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/cards"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<com.haut.grm.model.ies.Card> getCards(@Valid DataTablesInput input) {
/* 398 */     return this.dataTablesService.getCards(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/deduct_rules"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<DeductRule> getDeductRules(@Valid DataTablesInput input) {
/* 403 */     return this.dataTablesService.getDeductRules(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/deduct_records"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<DeductRecord> getDeductRecords(@Valid DataTablesInput input) {
/* 408 */     return this.dataTablesService.getDeductRecords(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/balance_sheets"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<BalanceSheet> getBalanceSheets(@Valid DataTablesInput input) {
/* 413 */     return this.dataTablesService.getBalanceSheets(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/weight_sheets"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<WeightSheet> getWeightSheets(@Valid DataTablesInput input) {
/* 418 */     return this.dataTablesService.getWeightSheets(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/register_records"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<com.haut.grm.model.ies.RegisterRecord> getRegisterRecords(@Valid DataTablesInput input) {
/* 423 */     return this.dataTablesService.getRegisterRecords(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/grain_traffics"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.GrainTrafficForDataTablesView.class})
/*     */   public DataTablesOutput<GrainTraffic> getGrainTraffics(@Valid DataTablesInput input) {
/* 429 */     return this.dataTablesService.getGrainTraffics(input);
/*     */   }


@RequestMapping(value={"/datatable/isfinished/grain_traffics"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
@JsonView({Views.GrainTrafficForDataTablesView.class})
public DataTablesOutput<GrainTraffic> getGrainTrafficsIsfinished(@Valid DataTablesInput input) {
//	DataTablesOutput<GrainTraffic> datas=
//	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//	List<GrainTraffic> list=datas.getData();
////	System.out.println("datable:"+list.size());
//	for(GrainTraffic g:list) {
//		Date out_time=g.getOutTime();
//		StockId stock=g.getStock();
//		StockId stock2=g.getSecondstock();
//		List<MyFenIesSheet> sheets= myFenIesSheetRepo.findByStockAndOuttimeBefore(stock, out_time);
//		String outStr=sdf.format(out_time);
////		System.out.println(outStr+",stock_id:"+stock.getId());
//		Double outamount=0.0;
//		Double inamount=0.0;
////		System.out.println(stock.getId());
//		for(MyFenIesSheet mySheet:sheets) {
//			outamount+=mySheet.getOutamount();
//			inamount+=mySheet.getInamount();
////			System.out.println(mySheet.getId()+","+mySheet.getOutamount());
////			System.out.println(mySheet.getId()+","+mySheet.getInamount());
//			
//		}
//		Double reamount= stock.getAmount()+outamount+inamount;
//		g.setYuliuamount1(reamount);
//		
//		if(stock2!=null) {
//			List<MyFenIesSheet> sheets2= myFenIesSheetRepo.findByStockAndOuttimeBefore(stock2, out_time);
//			
//			Double outamount2=0.0;
//			Double inamount2=0.0;
////			System.out.println(stock2.getId());
//			for(MyFenIesSheet mySheet:sheets2) {
//				outamount2+=mySheet.getOutamount();
//				inamount2+=mySheet.getInamount();
////				System.out.println(mySheet.getId()+","+mySheet.getOutamount());
////				System.out.println(mySheet.getId()+","+mySheet.getInamount());
//			}
//			Double reamount2= stock2.getAmount()+outamount2+inamount2;
//			g.setYuliuamount2(reamount2);
//		}
//		
//	}
	
	return this.dataTablesService.getGrainTrafficsByOutfinished(input);
}



/*     */   
/*     */   @RequestMapping(value={"/datatable/system_logs"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<SystemLog> getLogs(@Valid DataTablesInput input) {
/* 434 */     return this.dataTablesService.getlogs(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/system_variables"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<SystemVariable> getSystemVariables(@Valid DataTablesInput input) {
/* 439 */     return this.dataTablesService.getVariables(input);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/entry_measures"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<com.haut.grm.model.entry.EntryMeasure> getEntryMeasures(@Valid EntryDataInput input) {
/* 444 */     BooleanBuilder where = new BooleanBuilder();
/* 445 */     QEntryMeasure _data = QEntryMeasure.entryMeasure;
/* 446 */     if (input.getQueryStart() != null) {
/* 447 */       where.and(_data.time.after(input.getQueryStart()));
/*     */     }
/* 449 */     if (input.getQueryEnd() != null) {
/* 450 */       where.and(_data.time.before(input.getQueryEnd()));
/*     */     }
/* 452 */     if (input.getStoreId() != null) {
/* 453 */       where.and(_data.store.id.eq(input.getStoreId()));
/*     */     }
/* 455 */     return this.emRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/entry_doors"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<com.haut.grm.model.entry.EntryDoor> getEntryDoors(@Valid EntryDataInput input) {
/* 460 */     BooleanBuilder where = new BooleanBuilder();
/* 461 */     QEntryDoor _data = QEntryDoor.entryDoor;
/* 462 */     if (input.getQueryStart() != null) {
/* 463 */       where.and(_data.time.after(input.getQueryStart()));
/*     */     }
/* 465 */     if (input.getQueryEnd() != null) {
/* 466 */       where.and(_data.time.before(input.getQueryEnd()));
/*     */     }
/* 468 */     if (input.getStoreId() != null) {
/* 469 */       where.and(_data.door.store.id.eq(input.getStoreId()));
/*     */     }
/* 471 */     if (input.getDoorId() != null) {
/* 472 */       where.and(_data.door.codeId.eq(input.getDoorId()));
/*     */     }
/* 474 */     return this.edRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/entry_temperatures"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<EntryTemperature> getEntryTemperatures(@Valid EntryDataInput input) {
/* 479 */     BooleanBuilder where = new BooleanBuilder();
/* 480 */     QEntryTemperature _data = QEntryTemperature.entryTemperature;
/* 481 */     if (input.getQueryStart() != null) {
/* 482 */       where.and(_data.time.after(input.getQueryStart()));
/*     */     }
/* 484 */     if (input.getQueryEnd() != null) {
/* 485 */       where.and(_data.time.before(input.getQueryEnd()));
/*     */     }
/* 487 */     if (input.getStoreId() != null) {
/* 488 */       where.and(_data.store.id.eq(input.getStoreId()));
/*     */     }
/* 490 */     return this.etRepo.findAll(input, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/datatable/entry_safeties"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public DataTablesOutput<com.haut.grm.model.entry.EntrySafety> getEntrySafeties(@Valid EntryDataInput input) {
/* 495 */     BooleanBuilder where = new BooleanBuilder();
/* 496 */     QEntrySafety _data = QEntrySafety.entrySafety;
/* 497 */     if (input.getQueryStart() != null) {
/* 498 */       where.and(_data.time.after(input.getQueryStart()));
/*     */     }
/* 500 */     if (input.getQueryEnd() != null) {
/* 501 */       where.and(_data.time.before(input.getQueryEnd()));
/*     */     }
/* 503 */     if (input.getStoreId() != null) {
/* 504 */       where.and(_data.store.id.eq(input.getStoreId()));
/*     */     }
/* 506 */     return this.esRepo.findAll(input, where);
/*     */   }


@RequestMapping(value={"/datatable/planes"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
public DataTablesOutput<Plane> getPlanes(@Valid DataTablesInput input) {
	return dataTablesService.getPlane(input);
}


@RequestMapping(value={"/datatable/letters"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
public DataTablesOutput<OutInLetter> getLetters(@Valid DataTablesInput input) {
	return dataTablesService.getLetters(input);
}



@RequestMapping(value={"/datatable/stock/ana"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
public DataTablesOutput<StockAnalysis> getStockAnas(@Valid DataTablesInput input) {
	return dataTablesService.getStockAna(input);
}



/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\DataTablesController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */