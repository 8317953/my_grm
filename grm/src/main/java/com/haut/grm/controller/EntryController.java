/*     */ package com.haut.grm.controller;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.EntryDoorWithStoreView;
/*     */ import com.haut.grm.json.view.Views.EntryMeasureWithStoreView;
/*     */ import com.haut.grm.json.view.Views.EntrySafetyWithStoreView;
/*     */ import com.haut.grm.json.view.Views.EntryTemperatureWithStoreView;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.dto.EmDto;
/*     */ import com.haut.grm.model.dto.TemperatureDataDto;
/*     */ import com.haut.grm.model.entry.EntryDoor;
/*     */ import com.haut.grm.model.entry.EntryMeasure;
/*     */ import com.haut.grm.model.entry.EntrySafety;
/*     */ import com.haut.grm.model.entry.EntryTemperature;
/*     */ import com.haut.grm.repository.StoreRepository;
/*     */ import com.haut.grm.service.CommonService;
/*     */ import com.haut.grm.service.EntryService;
/*     */ import com.haut.grm.util.TemperatureUtil;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ import org.springframework.format.annotation.DateTimeFormat.ISO;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ public class EntryController
/*     */ {
/*     */   @Autowired
/*     */   private EntryService entryService;
/*     */   @Autowired
/*     */   private StoreRepository storeRepo;
/*     */   @Autowired
/*     */   private CommonService commonService;
/*     */   
/*     */   @RequestMapping(value={"/retrieve/entry_temperature/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryTemperatureWithStoreView.class})
/*     */   public EntryTemperature getEntryTemperatureById(@PathVariable("id") Long id)
/*     */   {
/*  44 */     return this.entryService.getEntryTemperatureById(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/temperature/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public TemperatureDataDto getTemperatureData(@PathVariable("id") Long id) throws Exception {
/*  49 */     Store store = (Store)this.storeRepo.findOne(id);
/*  50 */     String coreUrl = this.commonService.getSystemVariableWithKey("CORE_SERVICE_URL_3.0");
/*  51 */     TemperatureDataDto temp = TemperatureUtil.executeGetTemperature(coreUrl, store, Integer.valueOf(this.commonService.getSystemVariableWithKey("TEMP_WAIT")));
/*  52 */     return temp;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/entry_temperature/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @JsonView({Views.EntryTemperatureWithStoreView.class})
/*     */   public EntryTemperature createEntryTemperature(@PathVariable("id") Long id, @RequestBody String data) throws Exception {
/*  58 */     return this.entryService.createEntryTemperature(id, data);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/entry_safeties/count"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long getAllEntrySafetyCount() {
/*  63 */     return this.entryService.countEntrySafety();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/entry_doors/count"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long getAllEntryDoorCount() {
/*  68 */     return this.entryService.countEntryDoor();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/entry_measures/count"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long getAllEntryMeasureCount() {
/*  73 */     return this.entryService.countEntryMeasure();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/entry_measure/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryMeasureWithStoreView.class})
/*     */   public EntryMeasure getEntryMeasure(@PathVariable Long id) {
/*  79 */     return this.entryService.getEntryMeasureById(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/newest_entry_measure/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryMeasureWithStoreView.class})
/*     */   public EntryMeasure getNewestEntryMeasureForStore(@PathVariable Long id) {
/*  85 */     return this.entryService.getNewestEntryMeasureForStore(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/newest_entry_safety/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntrySafetyWithStoreView.class})
/*     */   public EntrySafety getNewestEntrySafetyForStore(@PathVariable Long id) {
/*  91 */     return this.entryService.getNewestEntrySafetyForStore(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/newest_entry_door/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryDoorWithStoreView.class})
/*     */   public EntryDoor getNewestEntryDoorForStore(@PathVariable Long id) {
/*  97 */     return this.entryService.getNewestEntryDoorForStore(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/newest_entry_temperature/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryTemperatureWithStoreView.class})
/*     */   public EntryTemperature getNewestEntryTempForStore(@PathVariable Long id) {
/* 103 */     return this.entryService.getNewestEntryTempForStore(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/newest_entry_temperature"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryTemperatureWithStoreView.class})
/*     */   public EntryTemperature getNewestEntryTemp() {
/* 109 */     return this.entryService.getNewestEntryTemp();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/newest_entry_measures"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryMeasureWithStoreView.class})
/*     */   public List<EntryMeasure> getNewestEntryMeasures() {
/* 115 */     return this.entryService.getNewestEntryMeasures();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/newest_entry_safeties"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntrySafetyWithStoreView.class})
/*     */   public List<EntrySafety> getNewestEntrySafeties() {
/* 121 */     return this.entryService.getNewestEntrySafeties();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/entry_safeties/alerting"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntrySafetyWithStoreView.class})
/*     */   public List<EntrySafety> getAllEntrySafetiesAlerting() {
/* 127 */     return this.entryService.getAllEntrySafetiesAlerting();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/newest_entry_doors"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryDoorWithStoreView.class})
/*     */   public List<EntryDoor> getNewestEntryDoors() {
/* 133 */     return this.entryService.getNewestEntryDoors();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/entry_door/recent/{hours}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryDoorWithStoreView.class})
/*     */   public List<EntryDoor> getEntryDoorsInRecent(@PathVariable Integer hours) {
/* 139 */     return this.entryService.getEntryDoorsInRecent(hours);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/get/entry_temperatures/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryTemperatureWithStoreView.class})
/*     */   public List<EntryTemperature> getAllEntryMeasures(@DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date start, @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date end, @PathVariable("id") Long id) {
/* 145 */     return this.entryService.getAllEntryTemperatures(id, start, end);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/get/entry_temperatures"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryTemperatureWithStoreView.class})
/*     */   public List<EntryTemperature> getAllEntryMeasures(@DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date start, @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date end) {
/* 151 */     return this.entryService.getAllEntryTemperatures(null, start, end);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/get/entry_temperatures/in"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.EntryTemperatureWithStoreView.class})
/*     */   public List<EntryTemperature> getAllEntryMeasures(EmDto dto) {
/* 157 */     return this.entryService.getAllEntryTemperatures(dto.getStart(), dto.getEnd(), dto.getIds());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/mute_safety/store/{codeId}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void muteEntrySafetyForStore(@PathVariable Long codeId) throws Exception {
/* 162 */     this.entryService.muteEntrySafetyForStore(codeId);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/count/entry_safety/store/{codeId}/alerting"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countEntrySafetyAlertingForStore(@PathVariable Long codeId) {
/* 167 */     return this.entryService.countEntrySafetyByStoreAndIsActive(codeId, Boolean.valueOf(true));
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/count/entry_safety/store/{codeId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countEntrySafetyForStore(@PathVariable Long id) {
/* 172 */     return this.entryService.countEntrySafetyByStore(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/count/entry_temperature/store/{codeId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countEntryTempForStore(@PathVariable Long id) {
/* 177 */     return this.entryService.countEntryTempByStore(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/count/entry_measure/store/{codeId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countEntryMeasureForStore(@PathVariable Long id) {
/* 182 */     return this.entryService.countEntryMeasureByStore(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/count/entry_door/store/{codeId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countEntryDoorForStore(@PathVariable Long id) {
/* 187 */     return this.entryService.countEntryDoorByStore(id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/count/entry_door/store/{id}/recent/{hours}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countEntryDoorsInRecentForStore(@PathVariable Long id, Integer hours) {
/* 192 */     return this.entryService.countEntryDoorsInRecent(hours, id);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/count/entry_temperature"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countEntryTemp() {
/* 197 */     return this.entryService.countEntryTemp();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/count/entry_safety"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countEntrySafety() {
/* 202 */     return this.entryService.countEntrySafety();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/count/entry_measure"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countEntryMeasure() {
/* 207 */     return this.entryService.countEntryMeasure();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/count/entry_door"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public long countEntryDoor() {
/* 212 */     return this.entryService.countEntryDoor();
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\EntryController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */