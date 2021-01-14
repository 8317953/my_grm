/*    */ package com.haut.grm.model.dto;
/*    */ 
/*    */ import java.util.Date;
/*    */ import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
/*    */ import org.springframework.format.annotation.DateTimeFormat;
/*    */ import org.springframework.format.annotation.DateTimeFormat.ISO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VehicleTrafficInput
/*    */   extends DataTablesInput
/*    */ {
/*    */   @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
/*    */   private Date queryStart;
/*    */   @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
/*    */   private Date queryEnd;
/*    */   private Long cameraId;
/*    */   private Boolean isIn;
/*    */   private Boolean isRegistered;
			

private Long contractid;




public Long getContractid() {
	return contractid;
}
public void setContractid(Long contractid) {
	this.contractid = contractid;
}
/*    */   
/*    */   public Date getQueryStart()
/*    */   {
/* 24 */     return this.queryStart;
/*    */   }
/*    */   
/*    */   public void setQueryStart(Date queryStart) {
/* 28 */     this.queryStart = queryStart;
/*    */   }
/*    */   
/*    */   public Date getQueryEnd() {
/* 32 */     return this.queryEnd;
/*    */   }
/*    */   
/*    */   public void setQueryEnd(Date queryEnd) {
/* 36 */     this.queryEnd = queryEnd;
/*    */   }
/*    */   
/*    */   public Long getCameraId() {
/* 40 */     return this.cameraId;
/*    */   }
/*    */   
/*    */   public void setCameraId(Long cameraId) {
/* 44 */     this.cameraId = cameraId;
/*    */   }
/*    */   
/*    */   public Boolean getIsIn() {
/* 48 */     return this.isIn;
/*    */   }
/*    */   
/*    */   public void setIsIn(Boolean isIn) {
/* 52 */     this.isIn = isIn;
/*    */   }
/*    */   
/*    */   public Boolean getIsRegistered() {
/* 56 */     return this.isRegistered;
/*    */   }
/*    */   
/*    */   public void setIsRegistered(Boolean isRegistered) {
/* 60 */     this.isRegistered = isRegistered;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\dto\VehicleTrafficInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */