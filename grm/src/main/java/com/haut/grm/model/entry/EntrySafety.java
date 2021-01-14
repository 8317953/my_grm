/*    */ package com.haut.grm.model.entry;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.EntrySafetyView;
/*    */ import com.haut.grm.model.base.AbstractEntry;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="entry_safety")
/*    */ public class EntrySafety
/*    */   extends AbstractEntry
/*    */ {
/*    */   private static final long serialVersionUID = 4116135851983694032L;
/*    */   @Column(name="is_active")
/*    */   @JsonView({Views.EntrySafetyView.class})
/*    */   private Boolean active;
/*    */   
/*    */   public Boolean getActive()
/*    */   {
/* 22 */     return this.active;
/*    */   }
/*    */   
/*    */   public void setActive(Boolean active) {
/* 26 */     this.active = active;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\EntrySafety.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */