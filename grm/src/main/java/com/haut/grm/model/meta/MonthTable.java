/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ import javax.persistence.Temporal;
/*    */ import javax.persistence.TemporalType;
/*    */ import org.hibernate.annotations.Generated;
/*    */ import org.hibernate.annotations.GenerationTime;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="meta_month")
/*    */ public class MonthTable
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 2031666237595411578L;
/*    */   @Column(name="date")
/*    */   @Temporal(TemporalType.DATE)
/*    */   private Date date;
/*    */   @Column(name="last_date")
/*    */   @Temporal(TemporalType.DATE)
/*    */   @Generated(GenerationTime.ALWAYS)
/*    */   private Date lastDate;
/*    */   @Column(name="month")
/*    */   @Generated(GenerationTime.ALWAYS)
/*    */   private String month;
/*    */   @Column(name="year")
/*    */   @Generated(GenerationTime.ALWAYS)
/*    */   private String year;
/*    */   @Column(name="month_name")
/*    */   @Generated(GenerationTime.ALWAYS)
/*    */   private String monthName;
/*    */   @Column(name="date_name")
/*    */   @Generated(GenerationTime.ALWAYS)
/*    */   private String dateName;
/*    */   
/*    */   public Date getDate()
/*    */   {
/* 51 */     return this.date;
/*    */   }
/*    */   
/*    */   public void setDate(Date date) {
/* 55 */     this.date = date;
/*    */   }
/*    */   
/*    */   public Date getLastDate() {
/* 59 */     return this.lastDate;
/*    */   }
/*    */   
/*    */   public void setLastDate(Date lastDate) {
/* 63 */     this.lastDate = lastDate;
/*    */   }
/*    */   
/*    */   public String getMonth() {
/* 67 */     return this.month;
/*    */   }
/*    */   
/*    */   public void setMonth(String month) {
/* 71 */     this.month = month;
/*    */   }
/*    */   
/*    */   public String getYear() {
/* 75 */     return this.year;
/*    */   }
/*    */   
/*    */   public void setYear(String year) {
/* 79 */     this.year = year;
/*    */   }
/*    */   
/*    */   public String getMonthName() {
/* 83 */     return this.monthName;
/*    */   }
/*    */   
/*    */   public void setMonthName(String monthName) {
/* 87 */     this.monthName = monthName;
/*    */   }
/*    */   
/*    */   public String getDateName() {
/* 91 */     return this.dateName;
/*    */   }
/*    */   
/*    */   public void setDateName(String dateName) {
/* 95 */     this.dateName = dateName;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\MonthTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */