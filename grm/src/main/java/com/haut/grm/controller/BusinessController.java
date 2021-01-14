/*    */ package com.haut.grm.controller;
/*    */ 
/*    */ import com.haut.grm.service.BusinessService;
/*    */ import java.util.Date;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class BusinessController
/*    */ {
/*    */   @Autowired
/*    */   private BusinessService bService;
/*    */   
/*    */   @RequestMapping(value={"/stock/in_finish/{id}/{time}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void inFinish(@PathVariable Long id, @PathVariable Date time)
/*    */   {
/* 22 */     this.bService.stockInFinish(id, time);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/stock/out_finish/{id}/{time}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void outFinish(@PathVariable Long id, @PathVariable Date time, @RequestParam boolean generate) {
/* 27 */     this.bService.stockOutFinish(id, time, generate);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\BusinessController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */