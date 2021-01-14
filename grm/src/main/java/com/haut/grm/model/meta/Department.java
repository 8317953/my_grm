/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.DepartmentView;
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
/*    */ @Table(name="meta_department")
/*    */ public class Department
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -5014112899996734281L;
/*    */   @Column(name="code_id")
/*    */   @JsonView({Views.DepartmentView.class})
/*    */   private Integer codeId;
/*    */   @Column(name="name")
/*    */   @JsonView({Views.DepartmentView.class})
/*    */   private String name;
/*    */   @Column(name="comment")
/*    */   @JsonView({Views.DepartmentView.class})
/*    */   private String comment;
/*    */   
/*    */   public Integer getCodeId()
/*    */   {
/* 33 */     return this.codeId;
/*    */   }
/*    */   
/*    */   public void setCodeId(Integer codeId) {
/* 37 */     this.codeId = codeId;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 41 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 45 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getComment() {
/* 49 */     return this.comment;
/*    */   }
/*    */   
/*    */   public void setComment(String comment) {
/* 53 */     this.comment = comment;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\Department.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */