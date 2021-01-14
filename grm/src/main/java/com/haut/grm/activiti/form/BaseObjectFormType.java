/*    */ package com.haut.grm.activiti.form;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.activiti.engine.impl.form.EnumFormType;
/*    */ 
/*    */ 
/*    */ public class BaseObjectFormType
/*    */   extends EnumFormType
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String TYPE_NAME = "object";
/*    */   protected String objectQueryText;
/*    */   protected String objectDisplayProperty;
/*    */   
/*    */   public BaseObjectFormType(Map<String, String> values)
/*    */   {
/* 17 */     super(values);
/* 18 */     this.objectQueryText = ((String)values.get("objectQueryText"));
/*    */   }
/*    */   
/*    */   public String getName() {
/* 22 */     return "object";
/*    */   }
/*    */   
/*    */   public Object convertFormValueToModelValue(String propertyValue)
/*    */   {
/* 27 */     return propertyValue;
/*    */   }
/*    */   
/*    */   public String convertModelValueToFormValue(Object modelValue)
/*    */   {
/* 32 */     return (String)modelValue;
/*    */   }
/*    */   
/*    */   public String getObjectQueryText() {
/* 36 */     return this.objectQueryText;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\activiti\form\BaseObjectFormType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */