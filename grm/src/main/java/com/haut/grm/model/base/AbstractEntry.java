/*    */ package com.haut.grm.model.base;
/*    */ 
/*    */ import com.haut.grm.model.Store;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.MappedSuperclass;
/*    */ import javax.persistence.Temporal;
/*    */ import javax.persistence.TemporalType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MappedSuperclass
/*    */ public abstract class AbstractEntry
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 2014556278793328332L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="store_id")
/*    */   private Store store;
/*    */   @Column(name="time")
/*    */   @Temporal(TemporalType.TIMESTAMP)
/*    */   protected Date time;
/*    */   
/*    */   public Date getTime()
/*    */   {
/* 31 */     return this.time;
/*    */   }
/*    */   
/*    */   public void setTime(Date time) {
/* 35 */     this.time = time;
/*    */   }
/*    */   
/*    */   public Store getStore() {
/* 39 */     return this.store;
/*    */   }
/*    */   
/*    */   public void setStore(Store store) {
/* 43 */     this.store = store;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\AbstractEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */