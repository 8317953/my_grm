/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonBackReference;
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.DeviceCameraRefStoreView;
/*     */ import com.haut.grm.json.view.Views.DeviceCameraView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.type.CameraManufacturer;
/*     */ import com.haut.grm.model.type.CameraType;
/*     */ import com.querydsl.core.annotations.QueryInit;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="device_camera")
/*     */ public class DeviceCamera
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 3316234736994803598L;
/*     */   public static final int PLATE_TYPE_CODEID = 2;
/*     */   @JsonBackReference
/*     */   @OneToOne(mappedBy="camera")
/*     */   @JsonView({Views.DeviceCameraRefStoreView.class})
/*     */   @QueryInit({"depot.*"})
/*     */   private Store store;
/*     */   @Column(name="name")
/*     */   @JsonView({Views.DeviceCameraView.class})
/*     */   private String name;
/*     */   @Column(name="ip_address")
/*     */   @JsonView({Views.DeviceCameraView.class})
/*  38 */   private String ipAddress = "0.0.0.0";
/*     */   
/*     */   @Column(name="port")
/*     */   @JsonView({Views.DeviceCameraView.class})
/*  42 */   private Integer port = Integer.valueOf(0);
/*     */   
/*     */   @Column(name="username")
/*     */   @JsonView({Views.DeviceCameraView.class})
/*     */   private String username;
/*     */   
/*     */   @Column(name="height")
/*     */   @JsonView({Views.DeviceCameraView.class})
/*     */   private Float height;
/*     */   
/*     */   @Column(name="password")
/*     */   @JsonView({Views.DeviceCameraView.class})
/*     */   private String password;
/*     */   
/*     */   @ManyToOne
/*     */   @JsonView({Views.DeviceCameraView.class})
/*     */   @JoinColumn(name="type_id")
/*     */   private CameraType type;
/*     */   
/*     */   @ManyToOne
/*     */   @JsonView({Views.DeviceCameraView.class})
/*     */   @JoinColumn(name="manufacturer_id")
/*     */   private CameraManufacturer manufacturer;
/*     */   
/*     */   @Column(name="position_x")
/*     */   @JsonView({Views.DeviceCameraView.class})
/*     */   private String positionX;
/*     */   @Column(name="position_y")
/*     */   @JsonView({Views.DeviceCameraView.class})
/*     */   private String positionY;
/*     */   
/*     */   public String getIpAddress()
/*     */   {
/*  75 */     return this.ipAddress;
/*     */   }
/*     */   
/*     */   public void setIpAddress(String ipAddress) {
/*  79 */     this.ipAddress = ipAddress;
/*     */   }
/*     */   
/*     */   public Integer getPort() {
/*  83 */     return this.port;
/*     */   }
/*     */   
/*     */   public void setPort(Integer port) {
/*  87 */     this.port = port;
/*     */   }
/*     */   
/*     */   public String getUsername() {
/*  91 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setUsername(String username) {
/*  95 */     this.username = username;
/*     */   }
/*     */   
/*     */   public Float getHeight() {
/*  99 */     return this.height;
/*     */   }
/*     */   
/*     */   public void setHeight(Float height) {
/* 103 */     this.height = height;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 107 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/* 111 */     this.password = password;
/*     */   }
/*     */   
/*     */   public CameraType getType() {
/* 115 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(CameraType type) {
/* 119 */     this.type = type;
/*     */   }
/*     */   
/*     */   public CameraManufacturer getManufacturer() {
/* 123 */     return this.manufacturer;
/*     */   }
/*     */   
/*     */   public void setManufacturer(CameraManufacturer manufacturer) {
/* 127 */     this.manufacturer = manufacturer;
/*     */   }
/*     */   
/*     */   public Store getStore() {
/* 131 */     return this.store;
/*     */   }
/*     */   
/*     */   public void setStore(Store store) {
/* 135 */     this.store = store;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 139 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 143 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getPositionX() {
/* 147 */     return this.positionX;
/*     */   }
/*     */   
/*     */   public void setPositionX(String positionX) {
/* 151 */     this.positionX = positionX;
/*     */   }
/*     */   
/*     */   public String getPositionY() {
/* 155 */     return this.positionY;
/*     */   }
/*     */   
/*     */   public void setPositionY(String positionY) {
/* 159 */     this.positionY = positionY;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\DeviceCamera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */