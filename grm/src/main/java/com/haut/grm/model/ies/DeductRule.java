/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.DeductRuleView;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import com.haut.grm.model.type.AnalysisLevel;
/*    */ import com.haut.grm.model.type.AnalysisType;
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
/*    */ 
/*    */ @Entity
/*    */ @Table(name="ies_deduct_rule")
/*    */ public class DeductRule
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -659788810042126329L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="analysis_type_id")
/*    */   @JsonView({Views.DeductRuleView.class})
/*    */   private AnalysisType type;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="analysis_level_id")
/*    */   @JsonView({Views.DeductRuleView.class})
/*    */   private AnalysisLevel level;
/*    */   @Column(name="up")
/*    */   @JsonView({Views.DeductRuleView.class})
/*    */   private Float up;
/*    */   @Column(name="down")
/*    */   @JsonView({Views.DeductRuleView.class})
/*    */   private Float down;
/*    */   @Column(name="is_active")
/*    */   @JsonView({Views.DeductRuleView.class})
/*    */   private Boolean active;
/*    */   @Column(name="is_reject")
/*    */   @JsonView({Views.DeductRuleView.class})
/*    */   private Boolean reject;
/*    */   
/*    */   public AnalysisType getType()
/*    */   {
/* 51 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(AnalysisType type) {
/* 55 */     this.type = type;
/*    */   }
/*    */   
/*    */   public AnalysisLevel getLevel() {
/* 59 */     return this.level;
/*    */   }
/*    */   
/*    */   public void setLevel(AnalysisLevel level) {
/* 63 */     this.level = level;
/*    */   }
/*    */   
/*    */   public Float getUp() {
/* 67 */     return this.up;
/*    */   }
/*    */   
/*    */   public void setUp(Float up) {
/* 71 */     this.up = up;
/*    */   }
/*    */   
/*    */   public Float getDown() {
/* 75 */     return this.down;
/*    */   }
/*    */   
/*    */   public void setDown(Float down) {
/* 79 */     this.down = down;
/*    */   }
/*    */   
/*    */   public Boolean getActive() {
/* 83 */     return this.active;
/*    */   }
/*    */   
/*    */   public void setActive(Boolean active) {
/* 87 */     this.active = active;
/*    */   }
/*    */   
/*    */   public Boolean getReject() {
/* 91 */     return this.reject;
/*    */   }
/*    */   
/*    */   public void setReject(Boolean reject) {
/* 95 */     this.reject = reject;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\DeductRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */