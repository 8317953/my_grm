///*    */ package com.haut.grm.controller;
///*    */ 
///*    */ import com.haut.grm.qt.datarepo.CdrecordDataTablesRepository;
///*    */ import com.haut.grm.qt.datarepo.RwrecordDataTablesRepository;
///*    */ import com.haut.grm.qt.model.Cdrecord;
///*    */ import com.haut.grm.qt.model.Nrecord;
///*    */ import com.haut.grm.qt.model.Parecord;
///*    */ import com.haut.grm.qt.model.Rwrecord;
///*    */ import com.haut.grm.qt.model.Wendu;
///*    */ import com.haut.grm.qt.repository.NrecordRepository;
///*    */ import com.haut.grm.qt.repository.ParecordRepository;
///*    */ import com.haut.grm.qt.repository.WenduRepository;
///*    */ import javax.validation.Valid;
///*    */ import org.springframework.beans.factory.annotation.Autowired;
///*    */ import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
///*    */ import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
///*    */ import org.springframework.web.bind.annotation.PathVariable;
///*    */ import org.springframework.web.bind.annotation.RequestMapping;
///*    */ import org.springframework.web.bind.annotation.RestController;
///*    */ 
///*    */ 
///*    */ @RestController
///*    */ public class QtController
///*    */ {
///*    */   @Autowired
///*    */   RwrecordDataTablesRepository rwRepo;
///*    */   @Autowired
///*    */   CdrecordDataTablesRepository cdRepo;
///*    */   @Autowired
///*    */   ParecordRepository paRepo;
///*    */   @Autowired
///*    */   NrecordRepository nRepo;
///*    */   @Autowired
///*    */   WenduRepository wdRepo;
///*    */   
///*    */   @RequestMapping(value={"/datatable/rwrecord"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*    */   public DataTablesOutput<Rwrecord> getRwrecords(@Valid DataTablesInput input)
///*    */   {
///* 39 */     return this.rwRepo.findAll(input);
///*    */   }
///*    */   
///*    */   @RequestMapping(value={"/datatable/cdrecord"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*    */   public DataTablesOutput<Cdrecord> getCdrecords(@Valid DataTablesInput input) {
///* 44 */     return this.cdRepo.findAll(input);
///*    */   }
///*    */   
///*    */   @RequestMapping(value={"/qt/pa/{codeId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*    */   public Parecord getParecord(@PathVariable String codeId) {
///* 49 */     return this.paRepo.findTop1ByCodeIdOrderByTimeDesc(codeId);
///*    */   }
///*    */   
///*    */   @RequestMapping(value={"/qt/n/{codeId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*    */   public Nrecord getNrecord(@PathVariable String codeId) {
///* 54 */     return this.nRepo.findTop1ByCodeIdOrderByTimeDesc(codeId);
///*    */   }
///*    */   
///*    */   @RequestMapping(value={"/qt/wendu/{codeId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
///*    */   public Wendu getWendu(@PathVariable String codeId) {
///* 59 */     return this.wdRepo.findTop1ByCodeIdOrderByTimeDesc(codeId);
///*    */   }
///*    */ }
//
//
///* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\QtController.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       0.7.1
// */