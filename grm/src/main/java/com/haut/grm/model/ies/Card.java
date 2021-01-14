/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.CardView;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import com.haut.grm.model.type.CardType;
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
/*    */ @Table(name="ies_card")
/*    */ public class Card
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -2258145908427055083L;
/*    */   @Column(name="print_number")
/*    */   @JsonView({Views.CardView.class})
/*    */   private String printNumber;
/*    */   @Column(name="physical_number")
/*    */   @JsonView({Views.CardView.class})
/*    */   private String physicalNumber;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="card_type_id")
/*    */   @JsonView({Views.CardView.class})
/*    */   private CardType type;
/*    */   @Column(name="is_using")
/*    */   @JsonView({Views.CardView.class})
/* 38 */   private Boolean isUsing = Boolean.valueOf(false);
/*    */   
/*    */   @Column(name="is_active")
/*    */   @JsonView({Views.CardView.class})
/* 42 */   private Boolean isActive = Boolean.valueOf(true);
/*    */   
/*    */   public String getPrintNumber() {
/* 45 */     return this.printNumber;
/*    */   }
/*    */   
/*    */   public void setPrintNumber(String printNumber) {
/* 49 */     this.printNumber = printNumber;
/*    */   }
/*    */   
/*    */   public String getPhysicalNumber() {
/* 53 */     return this.physicalNumber;
/*    */   }
/*    */   
/*    */   public void setPhysicalNumber(String physicalNumber) {
/* 57 */     this.physicalNumber = physicalNumber;
/*    */   }
/*    */   
/*    */   public CardType getType() {
/* 61 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(CardType type) {
/* 65 */     this.type = type;
/*    */   }
/*    */   
/*    */   public Boolean getIsUsing() {
/* 69 */     return this.isUsing;
/*    */   }
/*    */   
/*    */   public void setIsUsing(Boolean isUsing) {
/* 73 */     this.isUsing = isUsing;
/*    */   }
/*    */   
/*    */   public Boolean getIsActive() {
/* 77 */     return this.isActive;
/*    */   }
/*    */   
/*    */   public void setIsActive(Boolean isActive) {
/* 81 */     this.isActive = isActive;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\Card.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */