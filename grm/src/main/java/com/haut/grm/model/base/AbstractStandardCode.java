/*    */ package com.haut.grm.model.base;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.BaseStandardCodeView;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.MappedSuperclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MappedSuperclass
/*    */ public abstract class AbstractStandardCode
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -4005756115005804857L;
/*    */   @JsonView({Views.BaseStandardCodeView.class})
/*    */   @Column(name="code")
/*    */   protected String code;
/*    */   @JsonView({Views.BaseStandardCodeView.class})
/*    */   @Column(name="name")
/*    */   protected String name;
/*    */   @JsonView({Views.BaseStandardCodeView.class})
/*    */   @Column(name="parent_code")
/*    */   protected String parentCode;
/*    */   @JsonView({Views.BaseStandardCodeView.class})
/*    */   @Column(name="code_short")
/*    */   protected String shortCode;
/*    */   @JsonView({Views.BaseStandardCodeView.class})
/*    */   @Column(name="level")
/*    */   protected Integer level;
/*    */   
/*    */   public String getShortCode()
/*    */   {
/* 38 */     return this.shortCode;
/*    */   }
/*    */   
/*    */   public void setShortCode(String shortCode) {
/* 42 */     this.shortCode = shortCode;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 46 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 50 */     this.code = code;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 54 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 58 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getParentCode() {
/* 62 */     return this.parentCode;
/*    */   }
/*    */   
/*    */   public void setParentCode(String parentCode) {
/* 66 */     this.parentCode = parentCode;
/*    */   }
/*    */   
/*    */   public Integer getLevel() {
/* 70 */     return this.level;
/*    */   }
/*    */   
/*    */   public void setLevel(Integer level) {
/* 74 */     this.level = level;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\AbstractStandardCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */