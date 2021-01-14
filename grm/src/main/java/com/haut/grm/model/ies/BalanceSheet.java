/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.BalanceSheetView;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import com.haut.grm.model.meta.User;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ import javax.persistence.Temporal;
/*    */ import javax.persistence.TemporalType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="ies_balance_sheet")
/*    */ public class BalanceSheet
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -3941209189416691348L;
/*    */   @Column(name="comment")
/*    */   @JsonView({Views.BalanceSheetView.class})
/*    */   private String comment;
/*    */   @Column(name="is_finished")
/*    */   @JsonView({Views.BalanceSheetView.class})
/*    */   private Boolean isFinished;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="created_by")
/*    */   @JsonView({Views.BalanceSheetView.class})
/*    */   private User manager;
/*    */   @Column(name="created_date")
/*    */   @JsonView({Views.BalanceSheetView.class})
/*    */   @Temporal(TemporalType.TIMESTAMP)
/*    */   private Date time;
/*    */   
/*    */   public String getComment()
/*    */   {
/* 46 */     return this.comment;
/*    */   }
/*    */   
/*    */   public void setComment(String comment) {
/* 50 */     this.comment = comment;
/*    */   }
/*    */   
/*    */   public User getManager() {
/* 54 */     return this.manager;
/*    */   }
/*    */   
/*    */   public void setManager(User manager) {
/* 58 */     this.manager = manager;
/*    */   }
/*    */   
/*    */   public Date getTime() {
/* 62 */     return this.time;
/*    */   }
/*    */   
/*    */   public void setTime(Date time) {
/* 66 */     this.time = time;
/*    */   }
/*    */   
/*    */   public Boolean getIsFinished() {
/* 70 */     return this.isFinished;
/*    */   }
/*    */   
/*    */   public void setIsFinished(Boolean isFinished) {
/* 74 */     this.isFinished = isFinished;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\BalanceSheet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */