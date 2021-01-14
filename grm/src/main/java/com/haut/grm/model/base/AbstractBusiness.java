/*     */ package com.haut.grm.model.base;
/*     */ 
/*     */ import com.haut.grm.model.meta.User;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.MappedSuperclass;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import org.springframework.data.rest.core.annotation.Description;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @MappedSuperclass
/*     */ public abstract class AbstractBusiness
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 16866018488711117L;
/*     */   @Column(name="business_key")
/*     */   @Description("业务代码")
/*     */   protected String businessKey;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="inputer_id")
/*     */   @Description("业务发起人")
/*     */   protected User inputer;
/*     */   @Column(name="input_time")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   @Description("业务发起时间")
/*     */   protected Date inputTime;
/*     */   @Column(name="input_comment")
/*     */   @Description("备注")
/*     */   protected String inputComment;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="auditor_id")
/*     */   @Description("审核人")
/*     */   protected User auditor;
/*     */   @Column(name="audit_time")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   @Description("审核时间")
/*     */   protected Date auditTime;
/*     */   @Column(name="audit_comment")
/*     */   @Description("审核备注")
/*     */   protected String auditComment;
/*     */   
/*     */   public String getBusinessKey()
/*     */   {
/*  57 */     return this.businessKey;
/*     */   }
/*     */   
/*     */   public void setBusinessKey(String businessKey) {
/*  61 */     this.businessKey = businessKey;
/*     */   }
/*     */   
/*     */   public User getInputer() {
/*  65 */     return this.inputer;
/*     */   }
/*     */   
/*     */   public void setInputer(User inputer) {
/*  69 */     this.inputer = inputer;
/*     */   }
/*     */   
/*     */   public Date getInputTime() {
/*  73 */     return this.inputTime;
/*     */   }
/*     */   
/*     */   public void setInputTime(Date inputTime) {
/*  77 */     this.inputTime = inputTime;
/*     */   }
/*     */   
/*     */   public String getInputComment() {
/*  81 */     return this.inputComment;
/*     */   }
/*     */   
/*     */   public void setInputComment(String inputComment) {
/*  85 */     this.inputComment = inputComment;
/*     */   }
/*     */   
/*     */   public User getAuditor() {
/*  89 */     return this.auditor;
/*     */   }
/*     */   
/*     */   public void setAuditor(User auditor) {
/*  93 */     this.auditor = auditor;
/*     */   }
/*     */   
/*     */   public Date getAuditTime() {
/*  97 */     return this.auditTime;
/*     */   }
/*     */   
/*     */   public void setAuditTime(Date auditTime) {
/* 101 */     this.auditTime = auditTime;
/*     */   }
/*     */   
/*     */   public String getAuditComment() {
/* 105 */     return this.auditComment;
/*     */   }
/*     */   
/*     */   public void setAuditComment(String auditComment) {
/* 109 */     this.auditComment = auditComment;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\AbstractBusiness.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */