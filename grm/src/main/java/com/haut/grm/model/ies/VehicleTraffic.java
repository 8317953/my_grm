/*     */ package com.haut.grm.model.ies;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.VehicleTrafficImageView;
/*     */ import com.haut.grm.json.view.Views.VehicleTrafficView;
/*     */ import com.haut.grm.model.DeviceCamera;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.business.Contract;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.Lob;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import org.hibernate.annotations.Fetch;
/*     */ import org.hibernate.annotations.FetchMode;
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
/*     */ @Table(name="ies_vehicle_traffic")
/*     */ public class VehicleTraffic
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = -8102463050949602940L;
/*     */   @Column(name="plate")
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*     */   private String plate;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="camera_id")
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*     */   private DeviceCamera camera;
/*     */   @Column(name="time")
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date time;
/*     */   @Column(name="deadline")
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date deadline;
/*     */   @Column(name="in_time")
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date inTime;
/*     */   @Column(name="is_in")
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*  60 */   private Boolean in = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name="is_registered")
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*  64 */   private Boolean registered = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name="is_finished")
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*  68 */   private Boolean finished = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name="image")
/*     */   @JsonView({Views.VehicleTrafficImageView.class})
/*     */   @Lob
/*     */   @Basic(fetch=FetchType.LAZY)
/*     */   @Fetch(FetchMode.SELECT)
/*     */   private byte[] image;
/*     */   @Column(name="authorization_path")
/*     */   private String authorizationPath;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="contract_id")
/*     */   @JsonView({Views.VehicleTrafficView.class})
/*     */   private Contract contract;
/*     */   
/*     */   public Date getInTime()
/*     */   {
/*  85 */     return this.inTime;
/*     */   }
/*     */   
/*     */   public void setInTime(Date inTime) {
/*  89 */     this.inTime = inTime;
/*     */   }
/*     */   
/*     */   public Boolean getRegistered() {
/*  93 */     return this.registered;
/*     */   }
/*     */   
/*     */   public void setRegistered(Boolean registered) {
/*  97 */     this.registered = registered;
/*     */   }
/*     */   
/*     */   public String getPlate() {
/* 101 */     return this.plate;
/*     */   }
/*     */   
/*     */   public void setPlate(String plate) {
/* 105 */     this.plate = plate;
/*     */   }
/*     */   
/*     */   public Date getTime() {
/* 109 */     return this.time;
/*     */   }
/*     */   
/*     */   public void setTime(Date time) {
/* 113 */     this.time = time;
/*     */   }
/*     */   
/*     */   public byte[] getImage() {
/* 117 */     return this.image;
/*     */   }
/*     */   
/*     */   public void setImage(byte[] image) {
/* 121 */     this.image = image;
/*     */   }
/*     */   
/*     */   public DeviceCamera getCamera() {
/* 125 */     return this.camera;
/*     */   }
/*     */   
/*     */   public void setCamera(DeviceCamera camera) {
/* 129 */     this.camera = camera;
/*     */   }
/*     */   
/*     */   public Date getDeadline() {
/* 133 */     return this.deadline;
/*     */   }
/*     */   
/*     */   public void setDeadline(Date deadline) {
/* 137 */     this.deadline = deadline;
/*     */   }
/*     */   
/*     */   public Boolean getIn() {
/* 141 */     return this.in;
/*     */   }
/*     */   
/*     */   public void setIn(Boolean in) {
/* 145 */     this.in = in;
/*     */   }
/*     */   
/*     */   public Contract getContract() {
/* 149 */     return this.contract;
/*     */   }
/*     */   
/*     */   public void setContract(Contract contract) {
/* 153 */     this.contract = contract;
/*     */   }
/*     */   
/*     */   public Boolean getFinished() {
/* 157 */     return this.finished;
/*     */   }
/*     */   
/*     */   public void setFinished(Boolean finished) {
/* 161 */     this.finished = finished;
/*     */   }
/*     */   
/*     */   public String getAuthorizationPath() {
/* 165 */     return this.authorizationPath;
/*     */   }
/*     */   
/*     */   public void setAuthorizationPath(String authorizationPath) {
/* 169 */     this.authorizationPath = authorizationPath;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\VehicleTraffic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */