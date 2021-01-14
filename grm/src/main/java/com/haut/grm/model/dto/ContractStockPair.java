/*    */ package com.haut.grm.model.dto;
/*    */ 
/*    */ import com.haut.grm.model.business.Contract;
/*    */ import com.haut.grm.model.business.StockId;
/*    */ 
/*    */ 
/*    */ public class ContractStockPair
/*    */ {
/*    */   private Contract contract;
/*    */   private StockId stock;
/*    */   
/*    */   public ContractStockPair(Contract contract, StockId stock)
/*    */   {
/* 14 */     this.contract = contract;
/* 15 */     this.stock = stock;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 20 */     int prime = 31;
/* 21 */     int result = 1;
/* 22 */     result = 31 * result + (this.contract == null ? 0 : this.contract.hashCode());
/* 23 */     result = 31 * result + (this.stock == null ? 0 : this.stock.hashCode());
/* 24 */     return result;
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 29 */     if (this == obj)
/* 30 */       return true;
/* 31 */     if (obj == null)
/* 32 */       return false;
/* 33 */     if (getClass() != obj.getClass())
/* 34 */       return false;
/* 35 */     ContractStockPair other = (ContractStockPair)obj;
/* 36 */     if (this.contract == null) {
/* 37 */       if (other.contract != null)
/* 38 */         return false;
/* 39 */     } else if (!this.contract.equals(other.contract))
/* 40 */       return false;
/* 41 */     if (this.stock == null) {
/* 42 */       if (other.stock != null)
/* 43 */         return false;
/* 44 */     } else if (!this.stock.equals(other.stock))
/* 45 */       return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public Contract getContract() {
/* 50 */     return this.contract;
/*    */   }
/*    */   
/*    */   public void setContract(Contract contract) {
/* 54 */     this.contract = contract;
/*    */   }
/*    */   
/*    */   public StockId getStock() {
/* 58 */     return this.stock;
/*    */   }
/*    */   
/*    */   public void setStock(StockId stock) {
/* 62 */     this.stock = stock;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\dto\ContractStockPair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */