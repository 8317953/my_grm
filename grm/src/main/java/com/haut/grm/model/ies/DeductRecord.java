/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.DeductRecordView;
/*    */ import com.haut.grm.model.Store;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import javax.persistence.AssociationOverride;
/*    */ import javax.persistence.AttributeOverride;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="deduct_record")
/*    */ @AttributeOverride(name="createdDate", column=@Column(name="created_date"))
/*    */ @AssociationOverride(name="createdBy", joinColumns={@JoinColumn(name="created_by")})
/*    */ public class DeductRecord
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 6584188273963844411L;
/*    */   @Column(name="code", length=100, unique=true)
/*    */   @JsonView({Views.DeductRecordView.class})
/*    */   private String code;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="store_id")
/*    */   @JsonView({Views.DeductRecordView.class})
/*    */   private Store store;
/*    */   @Column(name="amount")
/*    */   @JsonView({Views.DeductRecordView.class})
/*    */   private Float amount;
/*    */   @Column(name="price")
/*    */   @JsonView({Views.DeductRecordView.class})
/*    */   private Float price;
/*    */   @Column(name="comment", length=256)
/*    */   @JsonView({Views.DeductRecordView.class})
/*    */   private String comment;
/*    */   
/*    */   public String getCode()
/*    */   {
/* 49 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 53 */     this.code = code;
/*    */   }
/*    */   
/*    */   public Store getStore() {
/* 57 */     return this.store;
/*    */   }
/*    */   
/*    */   public void setStore(Store store) {
/* 61 */     this.store = store;
/*    */   }
/*    */   
/*    */   public Float getAmount() {
/* 65 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(Float amount) {
/* 69 */     this.amount = amount;
/*    */   }
/*    */   
/*    */   public Float getPrice() {
/* 73 */     return this.price;
/*    */   }
/*    */   
/*    */   public void setPrice(Float price) {
/* 77 */     this.price = price;
/*    */   }
/*    */   
/*    */   public String getComment() {
/* 81 */     return this.comment;
/*    */   }
/*    */   
/*    */   public void setComment(String comment) {
/* 85 */     this.comment = comment;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\DeductRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */