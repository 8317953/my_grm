/*    */ package com.haut.grm.controller;
/*    */ 
/*    */ import com.haut.grm.model.business.WorkloadSchedule;
/*    */ import com.haut.grm.model.dto.WorkloadScheduleDto;
/*    */ import com.haut.grm.model.type.WorkloadCategory;
/*    */ import com.haut.grm.service.WorkloadService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class WorkloadController
/*    */ {
/*    */   @Autowired
/*    */   private WorkloadService workloadService;
/*    */   
/*    */   @RequestMapping(value={"/update/workload_category"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public WorkloadCategory updateWorkloadCategory(@RequestBody WorkloadCategory wc)
/*    */   {
/* 26 */     return this.workloadService.updateWorkloadCategory(wc);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/create/workload_category"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public WorkloadCategory createWorkloadCategory(@RequestBody WorkloadCategory wc) {
/* 31 */     return this.workloadService.createWorkloadCategory(wc);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/delete/workload_category"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void deleteWorkloadCategory(@RequestBody WorkloadCategory wc) {
/* 36 */     this.workloadService.deleteWorkloadCategory(wc);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/retrieve/workload_categories"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public List<WorkloadCategory> getWorkloadCategories() {
/* 41 */     return this.workloadService.getWorkloadCategories();
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/retrieve/workload_schedules/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public List<WorkloadSchedule> getWorkloadSchedules(@PathVariable("id") Long id) {
/* 46 */     return this.workloadService.getWorkloadSchedules(id);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/create/workload_schedule"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public WorkloadSchedule createWorkloadSchedule(@RequestBody WorkloadScheduleDto workloadScheduleDto) {
/* 51 */     return this.workloadService.createWorkloadSchedule(workloadScheduleDto);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/delete/workload_schedule"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void WorkloadSchedule(@RequestParam Long workloadScheduleId) {
/* 56 */     this.workloadService.deleteWorkloadSchedule(workloadScheduleId);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\WorkloadController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */