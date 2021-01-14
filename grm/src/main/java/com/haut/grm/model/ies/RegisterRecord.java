/*     */ package com.haut.grm.model.ies;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.RegisterRecordView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.meta.User;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ @Entity
/*     */ @Table(name="ies_register_record")
/*     */ public class RegisterRecord
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 7378785140156299512L;
/*     */   @Column(name="personnel_name", length=16)
/*     */   @JsonView({Views.RegisterRecordView.class})
/*     */   private String personnelName;
/*     */   @Column(name="personnel_id_number", length=18)
/*     */   @JsonView({Views.RegisterRecordView.class})
/*     */   private String personnelIdNumber;
/*     */   @Column(name="personnel_gender", length=2)
/*     */   @JsonView({Views.RegisterRecordView.class})
/*     */   private String personnelGender;
/*     */   @Column(name="personnel_address", length=128)
/*     */   @JsonView({Views.RegisterRecordView.class})
/*     */   private String personnelAddress;
/*     */   @Column(name="card_code", length=128)
/*     */   @JsonView({Views.RegisterRecordView.class})
/*     */   private String cardCode;
/*     */   @Column(name="telephone")
/*     */   @JsonView({Views.RegisterRecordView.class})
/*     */   private String telephone;
/*     */   @Column(name="personnel_pic")
/*     */   @JsonView({Views.RegisterRecordView.class})
/*     */   private String personnelPic;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="vehicle_id")
/*     */   @JsonView({Views.RegisterRecordView.class})
/*     */   private VehicleTraffic vehicleTraffic;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="manager_id")
/*     */   @JsonView({Views.RegisterRecordView.class})
/*     */   private User manager;
/*     */   @Column(name="time")
/*     */   @JsonView({Views.RegisterRecordView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date time;
/*     */   
/*     */   public Date getTime()
/*     */   {
/*  71 */     return this.time;
/*     */   }
/*     */   
/*     */   public void setTime(Date time) {
/*  75 */     this.time = time;
/*     */   }
/*     */   
/*     */   public String getPersonnelName() {
/*  79 */     return this.personnelName;
/*     */   }
/*     */   
/*     */   public void setPersonnelName(String personnelName) {
/*  83 */     this.personnelName = personnelName;
/*     */   }
/*     */   
/*     */   public String getPersonnelIdNumber() {
/*  87 */     return this.personnelIdNumber;
/*     */   }
/*     */   
/*     */   public void setPersonnelIdNumber(String personnelIdNumber) {
/*  91 */     this.personnelIdNumber = personnelIdNumber;
/*     */   }
/*     */   
/*     */   public String getPersonnelGender() {
/*  95 */     return this.personnelGender;
/*     */   }
/*     */   
/*     */   public void setPersonnelGender(String personnelGender) {
/*  99 */     this.personnelGender = personnelGender;
/*     */   }
/*     */   
/*     */   public String getPersonnelAddress() {
/* 103 */     return this.personnelAddress;
/*     */   }
/*     */   
/*     */   public void setPersonnelAddress(String personnelAddress) {
/* 107 */     this.personnelAddress = personnelAddress;
/*     */   }
/*     */   
/*     */   public String getPersonnelPic() {
/* 111 */     return this.personnelPic;
/*     */   }
/*     */   
/*     */   public void setPersonnelPic(String personnelPic) {
/* 115 */     this.personnelPic = personnelPic;
/*     */   }
/*     */   
/*     */   public String getCardCode() {
/* 119 */     return this.cardCode;
/*     */   }
/*     */   
/*     */   public void setCardCode(String cardCode) {
/* 123 */     this.cardCode = cardCode;
/*     */   }
/*     */   
/*     */   public VehicleTraffic getVehicleTraffic() {
/* 127 */     return this.vehicleTraffic;
/*     */   }
/*     */   
/*     */   public void setVehicleTraffic(VehicleTraffic vehicleTraffic) {
/* 131 */     this.vehicleTraffic = vehicleTraffic;
/*     */   }
/*     */   
/*     */   public User getManager() {
/* 135 */     return this.manager;
/*     */   }
/*     */   
/*     */   public void setManager(User manager) {
/* 139 */     this.manager = manager;
/*     */   }
/*     */   
/*     */   public String getTelephone() {
/* 143 */     return this.telephone;
/*     */   }
/*     */   
/*     */   public void setTelephone(String telephone) {
/* 147 */     this.telephone = telephone;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\RegisterRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */