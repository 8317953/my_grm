/*    */ package com.haut.grm.model.system;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.SystemModuleView;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="system_module")
/*    */ public class SystemModule
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -4636088742099875875L;
/*    */   @Column(name="name")
/*    */   @JsonView({Views.SystemModuleView.class})
/*    */   private String name;
/*    */   @Column(name="code")
/*    */   @JsonView({Views.SystemModuleView.class})
/*    */   private String code;
/*    */   @Column(name="code_id")
/*    */   @JsonView({Views.SystemModuleView.class})
/*    */   private Integer codeId;
/*    */   @Column(name="is_active")
/*    */   @JsonView({Views.SystemModuleView.class})
/*    */   private Boolean active;
/*    */   
/*    */   public Integer getCodeId()
/*    */   {
/* 34 */     return this.codeId;
/*    */   }
/*    */   
/*    */   public void setCodeId(Integer codeId) {
/* 38 */     this.codeId = codeId;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 42 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 46 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 50 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 54 */     this.code = code;
/*    */   }
/*    */   
/*    */   public Boolean getActive() {
/* 58 */     return this.active;
/*    */   }
/*    */   
/*    */   public void setActive(Boolean active) {
/* 62 */     this.active = active;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\system\SystemModule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */