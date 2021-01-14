/*     */ package com.haut.grm.model.meta;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.StoreModelView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
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
/*     */ @Entity
/*     */ @Table(name="meta_store_model")
/*     */ public class StoreModel
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 93244471761774830L;
/*     */   @Column(name="name")
/*     */   @JsonView({Views.StoreModelView.class})
/*     */   private String name;
/*     */   @Column(name="code_id")
/*     */   @JsonView({Views.StoreModelView.class})
/*     */   private Integer codeId;
/*     */   @Column(name="icon_relative_path")
/*     */   @JsonView({Views.StoreModelView.class})
/*     */   private String iconRelativePath;
/*     */   @Column(name="source_x")
/*     */   @JsonView({Views.StoreModelView.class})
/*     */   private String sourceX;
/*     */   @Column(name="source_y")
/*     */   @JsonView({Views.StoreModelView.class})
/*     */   private String sourceY;
/*     */   @Column(name="target_x")
/*     */   @JsonView({Views.StoreModelView.class})
/*     */   private String targetX;
/*     */   @Column(name="target_y")
/*     */   @JsonView({Views.StoreModelView.class})
/*     */   private String targetY;
/*     */   @Column(name="cable_data")
/*     */   @JsonView({Views.StoreModelView.class})
/*     */   private String cableData;
/*     */   @Column(name="is_circle")
/*     */   @JsonView({Views.StoreModelView.class})
/*     */   private boolean isCircle;
/*     */   
/*     */   public boolean isCircle()
/*     */   {
/*  54 */     return this.isCircle;
/*     */   }
/*     */   
/*     */   public void setCircle(boolean isCircle) {
/*  58 */     this.isCircle = isCircle;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  62 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  66 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getIconRelativePath() {
/*  70 */     return this.iconRelativePath;
/*     */   }
/*     */   
/*     */   public void setIconRelativePath(String iconRelativePath) {
/*  74 */     this.iconRelativePath = iconRelativePath;
/*     */   }
/*     */   
/*     */   public String getSourceX() {
/*  78 */     return this.sourceX;
/*     */   }
/*     */   
/*     */   public void setSourceX(String sourceX) {
/*  82 */     this.sourceX = sourceX;
/*     */   }
/*     */   
/*     */   public String getSourceY() {
/*  86 */     return this.sourceY;
/*     */   }
/*     */   
/*     */   public void setSourceY(String sourceY) {
/*  90 */     this.sourceY = sourceY;
/*     */   }
/*     */   
/*     */   public String getTargetX() {
/*  94 */     return this.targetX;
/*     */   }
/*     */   
/*     */   public void setTargetX(String targetX) {
/*  98 */     this.targetX = targetX;
/*     */   }
/*     */   
/*     */   public String getTargetY() {
/* 102 */     return this.targetY;
/*     */   }
/*     */   
/*     */   public void setTargetY(String targetY) {
/* 106 */     this.targetY = targetY;
/*     */   }
/*     */   
/*     */   public String getCableData() {
/* 110 */     return this.cableData;
/*     */   }
/*     */   
/*     */   public void setCableData(String cableData) {
/* 114 */     this.cableData = cableData;
/*     */   }
/*     */   
/*     */   public Integer getCodeId() {
/* 118 */     return this.codeId;
/*     */   }
/*     */   
/*     */   public void setCodeId(Integer codeId) {
/* 122 */     this.codeId = codeId;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\StoreModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */