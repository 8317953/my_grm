/*    */ package com.haut.grm.model.system;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.CoreVersionView;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="system_core_version")
/*    */ public class CoreVersion
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 619850842513793153L;
/*    */   @Column(name="name", length=100)
/*    */   @JsonView({Views.CoreVersionView.class})
/*    */   private String name;
/*    */   @Column(name="code_id")
/*    */   @JsonView({Views.CoreVersionView.class})
/*    */   private Integer codeId;
/*    */   
/*    */   public String getName()
/*    */   {
/* 26 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 30 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Integer getCodeId() {
/* 34 */     return this.codeId;
/*    */   }
/*    */   
/*    */   public void setCodeId(Integer codeId) {
/* 38 */     this.codeId = codeId;
/*    */   }
/*    */   
/*    */   public boolean is1() {
/* 42 */     return getCodeId().equals(Integer.valueOf(1));
/*    */   }
/*    */   
/*    */   public boolean is2() {
/* 46 */     return getCodeId().equals(Integer.valueOf(2));
/*    */   }
/*    */   
/*    */   public boolean is3() {
/* 50 */     return getCodeId().equals(Integer.valueOf(3));
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\system\CoreVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */