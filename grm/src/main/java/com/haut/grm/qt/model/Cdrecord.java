/*     */ package com.haut.grm.qt.model;
/*     */ 
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
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
/*     */ @Table(name="cdrecord")
/*     */ public class Cdrecord
/*     */ {
/*     */   @Id
/*     */   @Column(name="序号")
/*     */   private Integer id;
/*     */   @Column(name="仓房类型")
/*     */   private String type;
/*     */   @Column(name="仓房名")
/*     */   private String codeId;
/*     */   @Column(name="PLC编号")
/*     */   private Integer plc;
/*     */   @Column(name="设定充氮量")
/*     */   private Long sdcdl;
/*     */   @Column(name="实际充氮量")
/*     */   private Long sjcdl;
/*     */   @Column(name="设定浓度")
/*     */   private Float sdnd;
/*     */   @Column(name="结束浓度")
/*     */   private Float jsnd;
/*     */   @Column(name="开始时间")
/*     */   private Date startTime;
/*     */   @Column(name="结束时间")
/*     */   private Date endTime;
/*     */   @Column(name="是否异常")
/*     */   private String sfyc;
/*     */   
/*     */   public Integer getId()
/*     */   {
/*  49 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  53 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  57 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  61 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getCodeId() {
/*  65 */     return this.codeId;
/*     */   }
/*     */   
/*     */   public void setCodeId(String codeId) {
/*  69 */     this.codeId = codeId;
/*     */   }
/*     */   
/*     */   public Integer getPlc() {
/*  73 */     return this.plc;
/*     */   }
/*     */   
/*     */   public void setPlc(Integer plc) {
/*  77 */     this.plc = plc;
/*     */   }
/*     */   
/*     */   public Long getSdcdl() {
/*  81 */     return this.sdcdl;
/*     */   }
/*     */   
/*     */   public void setSdcdl(Long sdcdl) {
/*  85 */     this.sdcdl = sdcdl;
/*     */   }
/*     */   
/*     */   public Long getSjcdl() {
/*  89 */     return this.sjcdl;
/*     */   }
/*     */   
/*     */   public void setSjcdl(Long sjcdl) {
/*  93 */     this.sjcdl = sjcdl;
/*     */   }
/*     */   
/*     */   public Float getSdnd() {
/*  97 */     return this.sdnd;
/*     */   }
/*     */   
/*     */   public void setSdnd(Float sdnd) {
/* 101 */     this.sdnd = sdnd;
/*     */   }
/*     */   
/*     */   public Float getJsnd() {
/* 105 */     return this.jsnd;
/*     */   }
/*     */   
/*     */   public void setJsnd(Float jsnd) {
/* 109 */     this.jsnd = jsnd;
/*     */   }
/*     */   
/*     */   public Date getStartTime() {
/* 113 */     return this.startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date startTime) {
/* 117 */     this.startTime = startTime;
/*     */   }
/*     */   
/*     */   public Date getEndTime() {
/* 121 */     return this.endTime;
/*     */   }
/*     */   
/*     */   public void setEndTime(Date endTime) {
/* 125 */     this.endTime = endTime;
/*     */   }
/*     */   
/*     */   public String getSfyc() {
/* 129 */     return this.sfyc;
/*     */   }
/*     */   
/*     */   public void setSfyc(String sfyc) {
/* 133 */     this.sfyc = sfyc;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\model\Cdrecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */