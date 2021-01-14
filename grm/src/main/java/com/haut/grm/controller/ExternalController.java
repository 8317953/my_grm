/*     */ package com.haut.grm.controller;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.BusinessNotificationView;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.StoreStatus;
/*     */ import com.haut.grm.model.business.BusinessNotification;
/*     */ import com.haut.grm.model.dto.UserLoginDto;
/*     */ import com.haut.grm.model.dto.WeightDto;
/*     */ import com.haut.grm.model.ies.GrainTraffic;
/*     */ import com.haut.grm.model.meta.User;
/*     */ import com.haut.grm.repository.StoreRepository;
/*     */ import com.haut.grm.repository.meta.UserRepository;
/*     */ import com.haut.grm.service.AuthUserService;
/*     */ import com.haut.grm.service.CommonService;
/*     */ import com.haut.grm.service.MeasureTaskService;
/*     */ import com.haut.grm.service.TrafficService;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ import org.springframework.format.annotation.DateTimeFormat.ISO;
/*     */ import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ public class ExternalController
/*     */ {
/*     */   @Autowired
/*     */   private StoreRepository storeRepo;
/*     */   @Autowired
/*     */   private CommonService commonService;
/*     */   @Autowired
/*     */   private UserRepository userRepo;
/*     */   @Autowired
/*     */   private MeasureTaskService measureTaskExecutor;
/*     */   @Autowired
/*     */   private TrafficService trafficService;
/*     */   
/*     */   @RequestMapping(value={"/external/start_measure/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void startMeasure(@PathVariable("id") Long id, @RequestBody String url)
/*     */   {
/*  52 */     Store store = (Store)this.storeRepo.findOne(id);
/*  53 */     if (!store.getStatus().getIsMeasureOngoing().booleanValue())
/*  54 */       this.measureTaskExecutor.startMeasure(store, false, url, false);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/external/start_measure/all"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void startMeasureAll(@RequestBody String url) {
/*  59 */     List<Store> stores = this.storeRepo.findByDepot_Id(new Long(1L));
/*  60 */     for (Store store : stores) {
/*  61 */       if (!store.getStatus().getIsMeasureOngoing().booleanValue())
/*  62 */         this.measureTaskExecutor.startMeasure(store, false, url, false);
/*     */     }
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/external/start_measure/all/full"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void startMeasureAllFull(@RequestBody String url) {
/*  68 */     List<Store> stores = this.storeRepo.findByDepot_Id(new Long(1L));
/*  69 */     for (Store store : stores) {
/*  70 */       if (!store.getStatus().getIsMeasureOngoing().booleanValue())
/*  71 */         this.measureTaskExecutor.startMeasure(store, true, url, false);
/*     */     }
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/external/start_measure/store/{id}/full"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void startMeasureFull(@PathVariable("id") Long id, @RequestBody String url) {
/*  77 */     Store store = (Store)this.storeRepo.findOne(id);
/*  78 */     if (!store.getStatus().getIsMeasureOngoing().booleanValue()) {
/*  79 */       this.measureTaskExecutor.startMeasure(store, true, url, false);
/*     */     }
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/auth/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void login() {}
/*     */   
/*     */   @RequestMapping(value={"/external/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public User login(@RequestBody UserLoginDto user) throws Exception
/*     */   {
/*  89 */     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
/*  90 */     User _user = this.userRepo.findByUsername(user.getUsername());
/*  91 */     if (!passwordEncoder.matches(user.getPassword(), _user.getPassword()))
/*  92 */       throw new Exception("用户密码错误");
/*  93 */     return _user;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/api/retrieve/notifications"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.BusinessNotificationView.class})
/*     */   public List<BusinessNotification> getNotifications(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) Date time) {
/*  99 */     return this.commonService.getUserNotifications(time);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/api/retrieve/current/user"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public User getCurrentUser() {
/* 104 */     return AuthUserService.getCurrentUser(userRepo);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/external/confirm/{cardCode}/weight"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void apiConfirmWeight(@PathVariable String cardCode, @RequestBody WeightDto ws) {
/* 109 */     this.trafficService.confirmWeight(this.trafficService.getCardCodeByShort(cardCode), ws);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/external/retrieve/grain_traffic/{cardCode}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public GrainTraffic getGrainTrafficByCardCode(@PathVariable String cardCode) {
/* 114 */     return this.trafficService.getGrainTraffic(this.trafficService.getCardCodeByShort(cardCode));
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\ExternalController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */