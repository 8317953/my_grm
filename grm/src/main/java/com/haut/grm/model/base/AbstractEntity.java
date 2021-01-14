/*    */ package com.haut.grm.model.base;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.IdView;
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.MappedSuperclass;
/*    */ import javax.persistence.Transient;
/*    */ import org.springframework.data.domain.Persistable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MappedSuperclass
/*    */ public abstract class AbstractEntity<PK extends Serializable>
/*    */   implements Persistable<PK>
/*    */ {
/*    */   private static final long serialVersionUID = 5097130116958366004L;
/*    */   @JsonView({Views.IdView.class})
/*    */   @Id
/*    */   @GeneratedValue
/*    */   public PK id;
/*    */   
/*    */   public PK getId()
/*    */   {
/* 29 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setId(PK id)
/*    */   {
/* 38 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @Transient
/*    */   public boolean isNew()
/*    */   {
/* 49 */     return getId() == null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String toString()
/*    */   {
/* 59 */     return String.format("Entity of type %s with id: %s", new Object[] { getClass().getName(), getId() });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 70 */     if (obj == null) {
/* 71 */       return false;
/*    */     }
/*    */     
/* 74 */     if (this == obj) {
/* 75 */       return true;
/*    */     }
/*    */     
/* 78 */     if (!getClass().equals(obj.getClass())) {
/* 79 */       return false;
/*    */     }
/*    */     
/* 82 */     AbstractEntity<?> that = (AbstractEntity)obj;
/*    */     
/* 84 */     return getId() == null ? false : getId().equals(that.getId());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 95 */     int hashCode = 17;
/*    */     
/* 97 */     hashCode += (getId() == null ? 0 : getId().hashCode() * 31);
/*    */     
/* 99 */     return hashCode;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\AbstractEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */