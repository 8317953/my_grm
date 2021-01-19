/*    */ package com.haut.grm.model.base;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.BaseTypeView;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.MappedSuperclass;
/*    */ 
/*    */ 
/*    */ @MappedSuperclass
/*    */ public abstract class AbstractType
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -314539126489012262L;
/*    */   @JsonView({Views.IdView.class})
/*    */   @Column(name="name")
/*    */   protected String name;
/*    */   @JsonView({Views.IdView.class})
/*    */   @Column(name="code_id")
/*    */   protected Integer codeId;
/*    */   
/*    */   public String getName()
/*    */   {
/* 23 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 27 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Integer getCodeId() {
/* 31 */     return this.codeId;
/*    */   }
/*    */   
/*    */   public void setCodeId(Integer codeId) {
/* 35 */     this.codeId = codeId;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\AbstractType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */