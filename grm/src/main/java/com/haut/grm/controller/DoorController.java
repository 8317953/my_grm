/*    */ package com.haut.grm.controller;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.DoorWithStoreView;
/*    */ import com.haut.grm.model.Door;
/*    */ import com.haut.grm.service.DoorService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class DoorController
/*    */ {
/*    */   @Autowired
/*    */   private DoorService doorService;
/*    */   
/*    */   @RequestMapping(value={"/retrieve/door/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   @JsonView({Views.DoorWithStoreView.class})
/*    */   public Door getDoor(@PathVariable Long id)
/*    */   {
/* 24 */     return this.doorService.getDoorById(id);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/update/door"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   @JsonView({Views.DoorWithStoreView.class})
/*    */   public Door updateDoor(@RequestBody Door door) {
/* 30 */     return this.doorService.updateDoor(door);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/delete/door"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void deleteDoor(@RequestBody Door door) {
/* 35 */     this.doorService.deleteDoor(door);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/store/{storeId}/door/{doorCodeId}/create_position"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public boolean setPosition(@PathVariable Long storeId, @PathVariable Integer doorCodeId) throws Throwable {
/* 40 */     Door d = this.doorService.getDoorByStoreIdAndCodeId(storeId, doorCodeId);
/* 41 */     return this.doorService.setDoorPosition(d);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/store/{storeId}/door/{doorCodeId}/delete_position"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void deletePosition(@PathVariable Long storeId, @PathVariable Integer doorCodeId) throws Throwable {
/* 46 */     Door d = this.doorService.getDoorByStoreIdAndCodeId(storeId, doorCodeId);
/* 47 */     this.doorService.deleteDoorPosition(d);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/store/{storeId}/door/{doorCodeId}/turn_to"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void turnToDoor(@PathVariable Long storeId, @PathVariable Integer doorCodeId) throws Throwable {
/* 52 */     Door d = this.doorService.getDoorByStoreIdAndCodeId(storeId, doorCodeId);
/* 53 */     this.doorService.turnToDoor(d);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\DoorController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */