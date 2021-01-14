/*    */ package com.haut.grm.model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonBackReference;
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.DoorRefStoreView;
/*    */ import com.haut.grm.json.view.Views.DoorView;
/*    */ import com.haut.grm.json.view.Views.IdView;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import com.haut.grm.model.type.DoorState;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="grm_door")
/*    */ public class Door
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -4956823767498842935L;
/*    */   @Column(name="name")
/*    */   @JsonView({Views.IdView.class})
/*    */   private String name;
/*    */   @JsonBackReference
/*    */   @ManyToOne
/*    */   @JoinColumn(name="store_id")
/*    */   @JsonView({Views.DoorRefStoreView.class})
/*    */   private Store store;
/*    */   @Column(name="code_id")
/*    */   @JsonView({Views.IdView.class})
/*    */   private Integer codeId;
/*    */   @Column(name="occupied")
/*    */   @JsonView({Views.DoorView.class})
/* 37 */   private Boolean occupied = Boolean.valueOf(false);
/*    */   @ManyToOne
/*    */   @JoinColumn(name="state_id")
/*    */   @JsonView({Views.DoorView.class})
/*    */   private DoorState state;
/*    */   
/*    */   public String getName()
/*    */   {
/* 45 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 49 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Store getStore() {
/* 53 */     return this.store;
/*    */   }
/*    */   
/*    */   public void setStore(Store store) {
/* 57 */     this.store = store;
/*    */   }
/*    */   
/*    */   public Integer getCodeId() {
/* 61 */     return this.codeId;
/*    */   }
/*    */   
/*    */   public void setCodeId(Integer codeId) {
/* 65 */     this.codeId = codeId;
/*    */   }
/*    */   
/*    */   public Boolean getOccupied() {
/* 69 */     return this.occupied;
/*    */   }
/*    */   
/*    */   public void setOccupied(Boolean occupied) {
/* 73 */     this.occupied = occupied;
/*    */   }
/*    */   
/*    */   public DoorState getState() {
/* 77 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(DoorState state) {
/* 81 */     this.state = state;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\Door.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */