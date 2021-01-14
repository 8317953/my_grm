/*    */ package com.haut.grm.activiti.form;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractType;
/*    */ import com.haut.grm.repository.base.BaseTypeRepository;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.activiti.bpmn.model.FormProperty;
/*    */ import org.activiti.bpmn.model.FormValue;
/*    */ import org.activiti.engine.form.AbstractFormType;
/*    */ import org.activiti.engine.impl.form.BooleanFormType;
/*    */ import org.activiti.engine.impl.form.DateFormType;
/*    */ import org.activiti.engine.impl.form.DoubleFormType;
/*    */ import org.activiti.engine.impl.form.FormTypes;
/*    */ import org.activiti.engine.impl.form.LongFormType;
/*    */ import org.activiti.engine.impl.form.StringFormType;
/*    */ import org.springframework.beans.BeansException;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.repository.support.Repositories;
/*    */ import org.springframework.stereotype.Component;
/*    */ import org.springframework.web.context.WebApplicationContext;
/*    */ 
/*    */ @Component
/*    */ public class GrmFormTypes
/*    */   extends FormTypes
/*    */ {
/*    */   @Autowired
/*    */   private WebApplicationContext appContext;
/*    */   
/*    */   public GrmFormTypes()
/*    */   {
/* 31 */     addFormType(new StringFormType());
/* 32 */     addFormType(new LongFormType());
/* 33 */     addFormType(new DateFormType("dd/MM/yyyy"));
/* 34 */     addFormType(new BooleanFormType());
/* 35 */     addFormType(new DoubleFormType());
/*    */   }
/*    */   
/*    */   public AbstractFormType parseFormPropertyType(FormProperty formProperty)
/*    */   {
/* 40 */     if (formProperty.getType().equals("type")) {
/* 41 */       return parseObjectTypeFormType(formProperty);
/*    */     }
/* 43 */     if (formProperty.getType().equals("object")) {
/* 44 */       return parseBaseObjectFormType(formProperty);
/*    */     }
/* 46 */     return super.parseFormPropertyType(formProperty);
/*    */   }
/*    */   
/*    */ 
/*    */   private AbstractFormType parseObjectTypeFormType(FormProperty formProperty)
/*    */   {
/* 52 */     Map<String, String> map = new HashMap();
/* 53 */     for (FormValue fv : formProperty.getFormValues()) {
/* 54 */       map.put(fv.getId(), fv.getName());
/*    */     }
/* 56 */     BaseTypeRepository<? extends AbstractType> repo = null;
/*    */     try {
/* 58 */       repo = (BaseTypeRepository)new Repositories(this.appContext).getRepositoryFor(Class.forName("com.haut.grm.model." + (String)map.get("objectClass")));
/*    */     } catch (BeansException e) {
/* 60 */       e.printStackTrace();
/*    */     } catch (ClassNotFoundException e) {
/* 62 */       e.printStackTrace();
/*    */     }
/* 64 */     return new ObjectTypeFormType(map, repo);
/*    */   }
/*    */   
/*    */   private AbstractFormType parseBaseObjectFormType(FormProperty formProperty) {
/* 68 */     Map<String, String> map = new HashMap();
/* 69 */     for (FormValue fv : formProperty.getFormValues()) {
/* 70 */       map.put(fv.getId(), fv.getName());
/*    */     }
/* 72 */     return new BaseObjectFormType(map);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\activiti\form\GrmFormTypes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */