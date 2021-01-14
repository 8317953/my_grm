/*    */ package com.haut.grm.model.system;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.SystemModuleView;
/*    */ import com.haut.grm.json.view.Views.SystemStatusView;
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
/*    */ @Table(name="system_status")
/*    */ public class SystemStatus
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 7882083501299515063L;
/*    */   public static final String SMS_SERVICE = "SMS";
/*    */   public static final String CORE_SERVICE = "CORE";
/*    */   public static final String PLATE_SERVICE = "PLATE";
/*    */   public static final String SDK_SERVICE = "SDK";
/*    */   public static final String SCHED_MEASURE_SERVICE = "SCHED_MEASURE";
/*    */   public static final String SCHED_TEMP_SERVICE = "SCHED_TEMP";
/*    */   public static final String SCHED_SUMMARY_SERVICE = "SCHED_SUMMARY";
/*    */   @Column(name="code_id")
/*    */   @JsonView({Views.SystemModuleView.class})
/*    */   private Integer codeId;
/*    */   @Column(name="name")
/*    */   @JsonView({Views.SystemStatusView.class})
/*    */   private String name;
/*    */   @Column(name="code")
/*    */   @JsonView({Views.SystemStatusView.class})
/*    */   private String code;
/*    */   @Column(name="value")
/*    */   @JsonView({Views.SystemModuleView.class})
/*    */   private Boolean value;
/*    */   
/*    */   public Integer getCodeId()
/*    */   {
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
/*    */   
/*    */   public Boolean getValue() {
/* 69 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(Boolean value) {
/* 73 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\system\SystemStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */