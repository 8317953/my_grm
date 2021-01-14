/*    */ package com.haut.grm.activiti.form;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractType;
/*    */ import com.haut.grm.repository.base.BaseTypeRepository;
/*    */ import java.util.Map;
/*    */ import org.activiti.engine.ActivitiObjectNotFoundException;
/*    */ import org.activiti.engine.impl.form.EnumFormType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ObjectTypeFormType
/*    */   extends EnumFormType
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String TYPE_NAME = "type";
/*    */   protected String objectClass;
/*    */   protected String objectQueryText;
/*    */   private BaseTypeRepository<? extends AbstractType> repo;
/*    */   
/*    */   public ObjectTypeFormType(Map<String, String> values, BaseTypeRepository<? extends AbstractType> repo)
/*    */   {
/* 23 */     super(values);
/* 24 */     this.objectClass = ((String)values.get("objectClass"));
/* 25 */     this.objectQueryText = ((String)values.get("objectQueryText"));
/* 26 */     this.repo = repo;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 30 */     return "type";
/*    */   }
/*    */   
/*    */   public Object convertFormValueToModelValue(String propertyValue)
/*    */   {
/* 35 */     if (propertyValue != null)
/*    */     {
/* 37 */       AbstractType object = this.repo.findByName(propertyValue);
/* 38 */       if (object == null) {
/* 39 */         throw new ActivitiObjectNotFoundException("ObjectType with name " + propertyValue + " does not exist");
/*    */       }
/* 41 */       return object.getName();
/*    */     }
/* 43 */     return null;
/*    */   }
/*    */   
/*    */   public String convertModelValueToFormValue(Object modelValue)
/*    */   {
/* 48 */     return (String)modelValue;
/*    */   }
/*    */   
/*    */   public String getObjectClass() {
/* 52 */     return this.objectClass;
/*    */   }
/*    */   
/*    */   public String getObjectQueryText() {
/* 56 */     return this.objectQueryText;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\activiti\form\ObjectTypeFormType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */