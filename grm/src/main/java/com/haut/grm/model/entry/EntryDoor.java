/*    */ package com.haut.grm.model.entry;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.EntryDoorRefDoorView;
/*    */ import com.haut.grm.json.view.Views.EntryDoorView;
/*    */ import com.haut.grm.model.Door;
/*    */ import com.haut.grm.model.base.AbstractEntry;
/*    */ import com.haut.grm.model.type.DoorState;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="entry_door")
/*    */ public class EntryDoor
/*    */   extends AbstractEntry
/*    */ {
/*    */   private static final long serialVersionUID = -5428573019835173774L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="door_id")
/*    */   @JsonView({Views.EntryDoorRefDoorView.class})
/*    */   private Door door;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="state_id")
/*    */   @JsonView({Views.EntryDoorView.class})
/*    */   private DoorState state;
/*    */   
/*    */   public Door getDoor()
/*    */   {
/* 31 */     return this.door;
/*    */   }
/*    */   
/*    */   public void setDoor(Door door) {
/* 35 */     this.door = door;
/*    */   }
/*    */   
/*    */   public DoorState getState() {
/* 39 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(DoorState state) {
/* 43 */     this.state = state;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\EntryDoor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */