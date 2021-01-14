/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.ActivitiGroupView;
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
/*    */ 
/*    */ @Entity
/*    */ @Table(name="meta_activiti_group")
/*    */ public class ActivitiGroup
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 3437231050319631309L;
/*    */   @Column(name="code_id")
/*    */   @JsonView({Views.ActivitiGroupView.class})
/*    */   private Integer codeId;
/*    */   @Column(name="name")
/*    */   @JsonView({Views.ActivitiGroupView.class})
/*    */   private String name;
/*    */   @Column(name="code")
/*    */   @JsonView({Views.ActivitiGroupView.class})
/*    */   private String code;
/*    */   @Column(name="comment")
/*    */   @JsonView({Views.ActivitiGroupView.class})
/*    */   private String comment;
/*    */   
/*    */   public Integer getCodeId()
/*    */   {
/* 37 */     return this.codeId;
/*    */   }
/*    */   
/*    */   public void setCodeId(Integer codeId) {
/* 41 */     this.codeId = codeId;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 45 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 49 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 53 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 57 */     this.code = code;
/*    */   }
/*    */   
/*    */   public String getComment() {
/* 61 */     return this.comment;
/*    */   }
/*    */   
/*    */   public void setComment(String comment) {
/* 65 */     this.comment = comment;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\ActivitiGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */