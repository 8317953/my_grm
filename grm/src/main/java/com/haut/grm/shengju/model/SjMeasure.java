/*    */ package com.haut.grm.shengju.model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonProperty;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import org.springframework.data.rest.core.annotation.Description;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SjMeasure
/*    */ {
/*    */   @Description("系统编号")
/*    */   String XTBM;
/*    */   @Description("采集时间")
/*    */   Date CJSJ;
/*    */   @Description("企业代码")
/*    */   String QYDM;
/*    */   @Description("库区编码")
/*    */   String KQBM;
/*    */   @Description("仓房号")
/*    */   String CFH;
/*    */   @Description("当前存储数量")
/*    */   BigDecimal DQCBSL;
/*    */   @Description("测试结果")
/*    */   BigDecimal SSJG;
/*    */   @Description("是否删除")
/* 27 */   Integer SFSC = Integer.valueOf(0);
/*    */   
/*    */   @JsonProperty("xtbm")
/*    */   public String getXTBM() {
/* 31 */     return this.XTBM;
/*    */   }
/*    */   
/* 34 */   public void setXTBM(String xTBM) { this.XTBM = xTBM; }
/*    */   
/*    */   @JsonProperty("cjsj")
/*    */   public Date getCJSJ() {
/* 38 */     return this.CJSJ;
/*    */   }
/*    */   
/* 41 */   public void setCJSJ(Date cJSJ) { this.CJSJ = cJSJ; }
/*    */   
/*    */   @JsonProperty("qydm")
/*    */   public String getQYDM() {
/* 45 */     return this.QYDM;
/*    */   }
/*    */   
/* 48 */   public void setQYDM(String qYDM) { this.QYDM = qYDM; }
/*    */   
/*    */   @JsonProperty("kqbm")
/*    */   public String getKQBM() {
/* 52 */     return this.KQBM;
/*    */   }
/*    */   
/* 55 */   public void setKQBM(String kQBM) { this.KQBM = kQBM; }
/*    */   
/*    */   @JsonProperty("cfh")
/*    */   public String getCFH() {
/* 59 */     return this.CFH;
/*    */   }
/*    */   
/* 62 */   public void setCFH(String cFH) { this.CFH = cFH; }
/*    */   
/*    */   @JsonProperty("dqjccbsl")
/*    */   public BigDecimal getDQCBSL() {
/* 66 */     return this.DQCBSL;
/*    */   }
/*    */   
/* 69 */   public void setDQCBSL(BigDecimal dQCBSL) { this.DQCBSL = dQCBSL; }
/*    */   
/*    */   @JsonProperty("ssjg")
/*    */   public BigDecimal getSSJG() {
/* 73 */     return this.SSJG;
/*    */   }
/*    */   
/* 76 */   public void setSSJG(BigDecimal sSJG) { this.SSJG = sSJG; }
/*    */   
/*    */   @JsonProperty("sfsc")
/*    */   public Integer getSFSC() {
/* 80 */     return this.SFSC;
/*    */   }
/*    */   
/* 83 */   public void setSFSC(Integer sFSC) { this.SFSC = sFSC; }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjMeasure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */