/*    */ package com.haut.grm.model.entry;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.DoorCollectRefStoreView;
/*    */ import com.haut.grm.json.view.Views.DoorCollectView;
/*    */ import com.haut.grm.model.Store;
/*    */ import com.haut.grm.model.base.AbstractEntry;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="entry_door_collect")
/*    */ public class DoorCollect
/*    */   extends AbstractEntry
/*    */ {
/*    */   private static final long serialVersionUID = -1472882413973418913L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="store_id")
/*    */   @JsonView({Views.DoorCollectRefStoreView.class})
/*    */   private Store store;
/*    */   @Column(name="open_count")
/*    */   @JsonView({Views.DoorCollectView.class})
/*    */   private Long openCount;
/*    */   @Column(name="close_count")
/*    */   @JsonView({Views.DoorCollectView.class})
/*    */   private Long closeCount;
/*    */   @Column(name="comment")
/*    */   @JsonView({Views.DoorCollectView.class})
/*    */   private String comment;
/*    */   
/*    */   public Store getStore()
/*    */   {
/* 38 */     return this.store;
/*    */   }
/*    */   
/*    */   public void setStore(Store store) {
/* 42 */     this.store = store;
/*    */   }
/*    */   
/*    */   public Long getOpenCount() {
/* 46 */     return this.openCount;
/*    */   }
/*    */   
/*    */   public void setOpenCount(Long openCount) {
/* 50 */     this.openCount = openCount;
/*    */   }
/*    */   
/*    */   public Long getCloseCount() {
/* 54 */     return this.closeCount;
/*    */   }
/*    */   
/*    */   public void setCloseCount(Long closeCount) {
/* 58 */     this.closeCount = closeCount;
/*    */   }
/*    */   
/*    */   public String getComment() {
/* 62 */     return this.comment;
/*    */   }
/*    */   
/*    */   public void setComment(String comment) {
/* 66 */     this.comment = comment;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\DoorCollect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */