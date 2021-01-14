/*    */ package com.haut.grm.model.meta;
/*    */ 
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
/*    */ @Table(name="meta_level_type")
/*    */ public class LevelType
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 4690153545507284875L;
/*    */   @Column(name="code_id")
/*    */   private Integer codeId;
/*    */   @Column(name="name")
/*    */   private String name;
/*    */   @Column(name="code")
/*    */   private String code;
/*    */   
/*    */   public Integer getCodeId()
/*    */   {
/* 28 */     return this.codeId;
/*    */   }
/*    */   
/*    */   public void setCodeId(Integer codeId) {
/* 32 */     this.codeId = codeId;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 36 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 40 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 44 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 48 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\LevelType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */