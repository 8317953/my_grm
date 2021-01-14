/*    */ package com.haut.grm.model.system;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.SystemTrafficModuleView;
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
/*    */ @Table(name="system_traffic_module")
/*    */ public class SystemTrafficModule
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 4484696470636130425L;
/*    */   @Column(name="code_id")
/*    */   @JsonView({Views.SystemTrafficModuleView.class})
/*    */   private Integer codeId;
/*    */   @Column(name="name")
/*    */   @JsonView({Views.SystemTrafficModuleView.class})
/*    */   private String name;
/*    */   @Column(name="code")
/*    */   @JsonView({Views.SystemTrafficModuleView.class})
/*    */   private String code;
/*    */   @Column(name="is_registerable")
/*    */   @JsonView({Views.SystemTrafficModuleView.class})
/*    */   private Boolean isRegisterable;
/*    */   
/*    */   public Boolean getIsRegisterable()
/*    */   {
/* 37 */     return this.isRegisterable;
/*    */   }
/*    */   
/*    */   public void setIsRegisterable(Boolean isRegisterable) {
/* 41 */     this.isRegisterable = isRegisterable;
/*    */   }
/*    */   
/*    */   public Integer getCodeId() {
/* 45 */     return this.codeId;
/*    */   }
/*    */   
/*    */   public void setCodeId(Integer codeId) {
/* 49 */     this.codeId = codeId;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 53 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 57 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 61 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 65 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\system\SystemTrafficModule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */