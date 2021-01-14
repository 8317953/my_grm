/*    */ package com.haut.grm.util;
/*    */ 
/*    */ public class Pair<A, B>
/*    */ {
/*    */   private A first;
/*    */   private B second;
/*    */   
/*    */   public Pair(A first, B second) {
/*  9 */     this.first = first;
/* 10 */     this.second = second;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 14 */     int hashFirst = this.first != null ? this.first.hashCode() : 0;
/* 15 */     int hashSecond = this.second != null ? this.second.hashCode() : 0;
/*    */     
/* 17 */     return (hashFirst + hashSecond) * hashSecond + hashFirst;
/*    */   }
/*    */   
/*    */   public boolean equals(Object other) {
/* 21 */     if ((other instanceof Pair))
/*    */     {
/* 23 */       Pair otherPair = (Pair)other;
/* 24 */       return 
/* 25 */         ((this.first == otherPair.first) || (
/* 26 */         (this.first != null) && (otherPair.first != null) && 
/* 27 */         (this.first.equals(otherPair.first)))) && (
/* 28 */         (this.second == otherPair.second) || (
/* 29 */         (this.second != null) && (otherPair.second != null) && 
/* 30 */         (this.second.equals(otherPair.second))));
/*    */     }
/*    */     
/* 33 */     return false;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 38 */     return "(" + this.first + ", " + this.second + ")";
/*    */   }
/*    */   
/*    */   public A getFirst() {
/* 42 */     return (A)this.first;
/*    */   }
/*    */   
/*    */   public void setFirst(A first) {
/* 46 */     this.first = first;
/*    */   }
/*    */   
/*    */   public B getSecond() {
/* 50 */     return (B)this.second;
/*    */   }
/*    */   
/*    */   public void setSecond(B second) {
/* 54 */     this.second = second;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\Pair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */