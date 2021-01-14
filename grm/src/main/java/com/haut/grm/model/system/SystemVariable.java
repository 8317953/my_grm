/*    */ package com.haut.grm.model.system;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.SystemVariableView;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="system_variable")
/*    */ public class SystemVariable
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -8062862386225558483L;
/*    */   @Column(name="code_id")
/*    */   @JsonView({Views.SystemVariableView.class})
/*    */   private Integer codeId;
/*    */   @Column(name="variable_key")
/*    */   @JsonView({Views.SystemVariableView.class})
/*    */   private String variableKey;
/*    */   @Column(name="variable_value")
/*    */   @JsonView({Views.SystemVariableView.class})
/*    */   private String variableValue;
/*    */   @Column(name="comment")
/*    */   @JsonView({Views.SystemVariableView.class})
/*    */   private String comment;
/*    */   @Column(name="editable")
/*    */   @JsonView({Views.SystemVariableView.class})
/*    */   private boolean editable;
/*    */   @Column(name="deletable")
/*    */   @JsonView({Views.SystemVariableView.class})
/*    */   private boolean deletable;
/*    */   
/*    */   public Integer getCodeId()
/*    */   {
/* 42 */     return this.codeId;
/*    */   }
/*    */   
/*    */   public void setCodeId(Integer codeId) {
/* 46 */     this.codeId = codeId;
/*    */   }
/*    */   
/*    */   public String getVariableKey() {
/* 50 */     return this.variableKey;
/*    */   }
/*    */   
/*    */   public void setVariableKey(String variableKey) {
/* 54 */     this.variableKey = variableKey;
/*    */   }
/*    */   
/*    */   public String getVariableValue() {
/* 58 */     return this.variableValue;
/*    */   }
/*    */   
/*    */   public void setVariableValue(String variableValue) {
/* 62 */     this.variableValue = variableValue;
/*    */   }
/*    */   
/*    */   public String getComment() {
/* 66 */     return this.comment;
/*    */   }
/*    */   
/*    */   public void setComment(String comment) {
/* 70 */     this.comment = comment;
/*    */   }
/*    */   
/*    */   public boolean isEditable() {
/* 74 */     return this.editable;
/*    */   }
/*    */   
/*    */   public void setEditable(boolean editable) {
/* 78 */     this.editable = editable;
/*    */   }
/*    */   
/*    */   public boolean isDeletable() {
/* 82 */     return this.deletable;
/*    */   }
/*    */   
/*    */   public void setDeletable(boolean deletable) {
/* 86 */     this.deletable = deletable;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\system\SystemVariable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */