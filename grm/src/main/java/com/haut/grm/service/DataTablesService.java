/*     */ package com.haut.grm.service;
/*     */ 
/*     */ import com.haut.grm.datatables.repository.BalanceSheetDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.CardDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.ClientDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.ContractDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.DeductRecordDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.DeductRuleDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.DeviceCameraDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.DoorCollectDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.EntryDoorDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.EntryMeasureDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.EntrySafetyDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.EntryTemperatureDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.GrainPlanDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.GrainTrafficDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.LoadCompanyDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.MeasureDiffDataTablesRepository;
import com.haut.grm.datatables.repository.OutInLetterDataTablesRepository;
import com.haut.grm.datatables.repository.PlaneDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.RegisterRecordDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.StandaloneLocationDataTablesRepository;
import com.haut.grm.datatables.repository.StockAnalysisDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.SystemLogDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.SystemVariableDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.VehicleTrafficDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.WeightSheetDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.YearDataTablesRepository;
/*     */ import com.haut.grm.model.DeviceCamera;
import com.haut.grm.model.Plane;
/*     */ import com.haut.grm.model.QDeviceCamera;
/*     */ import com.haut.grm.model.QDoor;
/*     */ import com.haut.grm.model.QStore;
/*     */ import com.haut.grm.model.business.Client;
/*     */ import com.haut.grm.model.business.Contract;
/*     */ import com.haut.grm.model.business.GrainPlan;
import com.haut.grm.model.business.StockAnalysis;
/*     */ import com.haut.grm.model.dto.SearchDto;
/*     */ import com.haut.grm.model.dto.VehicleTrafficInput;
/*     */ import com.haut.grm.model.entry.DoorCollect;
/*     */ import com.haut.grm.model.entry.EntryDoor;
/*     */ import com.haut.grm.model.entry.EntryMeasure;
/*     */ import com.haut.grm.model.entry.EntrySafety;
/*     */ import com.haut.grm.model.entry.EntryTemperature;
/*     */ import com.haut.grm.model.entry.MeasureDiff;
/*     */ import com.haut.grm.model.entry.QDoorCollect;
/*     */ import com.haut.grm.model.entry.QEntryDoor;
/*     */ import com.haut.grm.model.entry.QEntryMeasure;
/*     */ import com.haut.grm.model.entry.QEntrySafety;
/*     */ import com.haut.grm.model.entry.QEntryTemperature;
/*     */ import com.haut.grm.model.entry.QMeasureDiff;
/*     */ import com.haut.grm.model.ies.BalanceSheet;
/*     */ import com.haut.grm.model.ies.Card;
/*     */ import com.haut.grm.model.ies.DeductRecord;
/*     */ import com.haut.grm.model.ies.DeductRule;
/*     */ import com.haut.grm.model.ies.GrainTraffic;
import com.haut.grm.model.ies.QGrainTraffic;
/*     */ import com.haut.grm.model.ies.QVehicleTraffic;
/*     */ import com.haut.grm.model.ies.RegisterRecord;
/*     */ import com.haut.grm.model.ies.VehicleTraffic;
/*     */ import com.haut.grm.model.ies.WeightSheet;
/*     */ import com.haut.grm.model.standalone.LoadCompany;
/*     */ import com.haut.grm.model.standalone.StandaloneLocation;
/*     */ import com.haut.grm.model.standalone.Year;
/*     */ import com.haut.grm.model.system.SystemLog;
/*     */ import com.haut.grm.model.system.SystemVariable;
import com.haut.grm.model.wenzhou.OutInLetter;
/*     */ import com.querydsl.core.types.dsl.BooleanExpression;
/*     */ import com.querydsl.core.types.dsl.DateTimePath;
/*     */ import com.querydsl.core.types.dsl.NumberPath;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
/*     */ import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
/*     */ import org.springframework.stereotype.Service;
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
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class DataTablesService
/*     */ {
/*     */   @Autowired
/*     */   private EntryMeasureDataTablesRepository emRepo;
/*     */   @Autowired
/*     */   private EntrySafetyDataTablesRepository esRepo;
/*     */   @Autowired
/*     */   private EntryTemperatureDataTablesRepository etRepo;
/*     */   @Autowired
/*     */   private MeasureDiffDataTablesRepository mdRepo;
/*     */   @Autowired
/*     */   private DoorCollectDataTablesRepository dctRepo;
/*     */   @Autowired
/*     */   private EntryDoorDataTablesRepository edRepo;
/*     */   @Autowired
/*     */   private VehicleTrafficDataTablesRepository vtRepo;
/*     */   @Autowired
/*     */   private GrainPlanDataTablesRepository gpRepo;
/*     */   @Autowired
/*     */   private ContractDataTablesRepository contractRepo;
/*     */   @Autowired
/*     */   private ClientDataTablesRepository clientRepo;
/*     */   @Autowired
/*     */   private CardDataTablesRepository cardRepo;
/*     */   @Autowired
/*     */   private DeductRuleDataTablesRepository druleRepo;
/*     */   @Autowired
/*     */   private DeductRecordDataTablesRepository drecordRepo;
/*     */   @Autowired
/*     */   private BalanceSheetDataTablesRepository bsRepo;
/*     */   @Autowired
/*     */   private WeightSheetDataTablesRepository wsRepo;
/*     */   @Autowired
/*     */   private RegisterRecordDataTablesRepository rrRepo;
/*     */   @Autowired
/*     */   private GrainTrafficDataTablesRepository gtRepo;
/*     */   @Autowired
/*     */   private SystemLogDataTablesRepository logRepo;
/*     */   @Autowired
/*     */   private SystemVariableDataTablesRepository variableRepo;
/*     */   @Autowired
/*     */   private DeviceCameraDataTablesRepository cameraRepo;
/*     */   @Autowired
/*     */   private StandaloneLocationDataTablesRepository locationRepo;
/*     */   @Autowired
/*     */   private YearDataTablesRepository yearRepo;
/*     */   @Autowired
/*     */   private LoadCompanyDataTablesRepository lcRepo;


@Autowired
private StockAnalysisDataTablesRepository stockAnaRepo;


@Autowired
private PlaneDataTablesRepository planeRepo;


@Autowired
private OutInLetterDataTablesRepository outInLetterRepo;

/*     */   
/*     */   public DataTablesOutput<EntryMeasure> getEntryMeasures(DataTablesInput input, Integer codeId)
/*     */   {
/* 137 */     return codeId != null ? this.emRepo.findAll(input, QEntryMeasure.entryMeasure.store.codeId.eq(codeId)) : this.emRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<EntrySafety> getEntrySafeties(DataTablesInput input, Integer codeId) {
/* 141 */     return codeId != null ? this.esRepo.findAll(input, QEntrySafety.entrySafety.store.codeId.eq(codeId)) : this.esRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<EntryTemperature> getEntryTemperatures(DataTablesInput input, Integer codeId) {
/* 145 */     return codeId != null ? this.etRepo.findAll(input, QEntryTemperature.entryTemperature.store.codeId.eq(codeId)) : this.etRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<EntryDoor> getEntryDoors(DataTablesInput input, Integer storeCodeId, Integer codeId) {
/* 149 */     QEntryDoor qed = QEntryDoor.entryDoor;
/* 150 */     return codeId != null ? this.edRepo.findAll(input, qed.door.store.codeId.eq(codeId).and(qed.door.codeId.eq(codeId))) : this.edRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<DoorCollect> getDoorCollects(SearchDto input) {
/* 154 */     return input.getQueryStart() != null ? this.dctRepo.findAll(input, QDoorCollect.doorCollect.time.between(input.getQueryStart(), input.getQueryEnd())) : this.dctRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<MeasureDiff> getMeasureDiffs(SearchDto input)
/*     */   {
/* 159 */     return input.getQueryStart() != null ? this.mdRepo.findAll(input, QMeasureDiff.measureDiff.thisTime.between(input.getQueryStart(), input.getQueryEnd())) : this.mdRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<VehicleTraffic> getVehicleTraffics(VehicleTrafficInput input) {
/* 163 */     return input.getQueryStart() != null ? this.vtRepo.findAll(input, QVehicleTraffic.vehicleTraffic.time.between(input.getQueryStart(), input.getQueryStart()).and(QVehicleTraffic.vehicleTraffic.camera.id.eq(input.getCameraId()))) : this.vtRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<Contract> getContracts(DataTablesInput input) {
/* 167 */     return this.contractRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<StandaloneLocation> getLocations(DataTablesInput input) {
/* 171 */     return this.locationRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<Year> getYears(DataTablesInput input) {
/* 175 */     return this.yearRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<LoadCompany> getLoadCompanies(DataTablesInput input) {
/* 179 */     return this.lcRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<Client> getClients(DataTablesInput input) {
/* 183 */     return this.clientRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<GrainPlan> getGrainPlans(DataTablesInput input) {
/* 187 */     return this.gpRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<Card> getCards(DataTablesInput input) {
/* 191 */     return this.cardRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<DeductRule> getDeductRules(DataTablesInput input) {
/* 195 */     return this.druleRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<DeductRecord> getDeductRecords(DataTablesInput input) {
/* 199 */     return this.drecordRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<GrainTraffic> getGrainTraffics(DataTablesInput input) {
/* 203 */     return this.gtRepo.findAll(input);
/*     */   }



public DataTablesOutput<GrainTraffic> getGrainTrafficsByOutfinished(DataTablesInput input) {
	return this.gtRepo.findAll(input,QGrainTraffic.grainTraffic.isFinished.eq(true));
}


/*     */   
/*     */   public DataTablesOutput<RegisterRecord> getRegisterRecords(DataTablesInput input) {
/* 207 */     return this.rrRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<WeightSheet> getWeightSheets(DataTablesInput input) {
/* 211 */     return this.wsRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<BalanceSheet> getBalanceSheets(DataTablesInput input) {
/* 215 */     return this.bsRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<EntryDoor> getEntryDoors(DataTablesInput input) {
/* 219 */     return this.edRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<SystemLog> getlogs(DataTablesInput input) {
/* 223 */     return this.logRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<SystemVariable> getVariables(DataTablesInput input) {
/* 227 */     return this.variableRepo.findAll(input);
/*     */   }
/*     */   
/*     */   public DataTablesOutput<DeviceCamera> getCameras(DataTablesInput input) {
/* 231 */     return this.cameraRepo.findAll(input);
/*     */   }

public DataTablesOutput<Plane> getPlane(DataTablesInput input){
	return planeRepo.findAll(input);
}



public DataTablesOutput<OutInLetter> getLetters(DataTablesInput input){
	return outInLetterRepo.findAll(input);
}


public DataTablesOutput<StockAnalysis> getStockAna(DataTablesInput input){
	return stockAnaRepo.findAll(input);
}



/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\DataTablesService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */