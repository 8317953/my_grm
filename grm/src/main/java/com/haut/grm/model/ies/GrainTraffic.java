/*     */ package com.haut.grm.model.ies;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.GrainTrafficView;
/*     */ import com.haut.grm.json.view.Views.IdView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.business.Contract;
import com.haut.grm.model.business.StockChange;
import com.haut.grm.model.business.StockId;
/*     */ import com.haut.grm.model.meta.Stage;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="ies_ee_sheet")
/*     */ public class GrainTraffic
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 7004434855997825029L;
/*     */   @Column(name="code")
/*     */   @JsonView({Views.IdView.class})
/*     */   private String code;
/*     */   @Column(name="is_ingress")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   private Boolean isIngress;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="stage_id")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   private Stage stage;
/*     */   @Column(name="allow_stage")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*  40 */   private Integer allowStage = Integer.valueOf(0);
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="register_record_id")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   private RegisterRecord registerRecord;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="contract_id")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   private Contract contract;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="second_contract_id")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   private Contract secondContract;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="analysis_id")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   private Analysis analysis;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="weight_sheet_id")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   private WeightSheet weightSheet;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="second_weight_sheet_id")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   private WeightSheet secondWeightSheet;
/*     */   
/*     */   @Column(name="has_second")
/*  73 */   private Boolean hasSecond = Boolean.valueOf(false);
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="balance_sheet_id")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   private BalanceSheet balanceSheet;
/*     */   
/*     */   @Column(name="time")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date time;
/*     */   
/*     */   @Column(name="out_time")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date outTime;
/*     */   
/*     */   @Column(name="is_finished")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*  92 */   private Boolean isFinished = Boolean.valueOf(false);

/*     */   @ManyToOne
/*     */   @JoinColumn(name="stock_id")
/*     */   @JsonView({Views.GrainTrafficView.class})
/*     */   private StockId stock;




@ManyToOne
@JoinColumn(name="second_stock_id")
@JsonView({Views.GrainTrafficView.class})
private StockId secondstock;



@OneToOne
@JoinColumn(name="stock_change_id")
@JsonView({Views.GrainTrafficView.class})
private StockChange stockchange;


@OneToOne
@JoinColumn(name="second_stock_change_id")
@JsonView({Views.GrainTrafficView.class})
private StockChange secondstockchange;


@Column(name="yuliu_amount1")
@JsonView({Views.IdView.class})
private Double yuliuamount1;

@Column(name="yuliu_amount2")
@JsonView({Views.IdView.class})
private Double yuliuamount2;



public Double getYuliuamount1() {
	return yuliuamount1;
}
public void setYuliuamount1(Double yuliuamount1) {
	this.yuliuamount1 = yuliuamount1;
}
public Double getYuliuamount2() {
	return yuliuamount2;
}
public void setYuliuamount2(Double yuliuamount2) {
	this.yuliuamount2 = yuliuamount2;
}
public StockId getSecondstock() {
	return secondstock;
}
public void setSecondstock(StockId secondstock) {
	this.secondstock = secondstock;
}
public StockChange getSecondstockchange() {
	return secondstockchange;
}
public void setSecondstockchange(StockChange secondstockchange) {
	this.secondstockchange = secondstockchange;
}
public StockChange getStockchange() {
	return stockchange;
}
public void setStockchange(StockChange stockchange) {
	this.stockchange = stockchange;
}
public StockId getStock() {
	return stock;
}
public void setStock(StockId stock) {
	this.stock = stock;
}
/*     */   
/*     */   public String getCode() {
/*  95 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  99 */     this.code = code;
/*     */   }
/*     */   
/*     */   public Boolean getIsIngress() {
/* 103 */     return this.isIngress;
/*     */   }
/*     */   
/*     */   public void setIsIngress(Boolean isIngress) {
/* 107 */     this.isIngress = isIngress;
/*     */   }
/*     */   
/*     */   public Stage getStage() {
/* 111 */     return this.stage;
/*     */   }
/*     */   
/*     */   public void setStage(Stage stage) {
/* 115 */     this.stage = stage;
/*     */   }
/*     */   
/*     */   public RegisterRecord getRegisterRecord() {
/* 119 */     return this.registerRecord;
/*     */   }
/*     */   
/*     */   public void setRegisterRecord(RegisterRecord registerRecord) {
/* 123 */     this.registerRecord = registerRecord;
/*     */   }
/*     */   
/*     */   public Contract getContract() {
/* 127 */     return this.contract;
/*     */   }
/*     */   
/*     */   public void setContract(Contract contract) {
/* 131 */     this.contract = contract;
/*     */   }
/*     */   
/*     */   public Analysis getAnalysis() {
/* 135 */     return this.analysis;
/*     */   }
/*     */   
/*     */   public void setAnalysis(Analysis analysis) {
/* 139 */     this.analysis = analysis;
/*     */   }
/*     */   
/*     */   public WeightSheet getWeightSheet() {
/* 143 */     return this.weightSheet;
/*     */   }
/*     */   
/*     */   public void setWeightSheet(WeightSheet weightSheet) {
/* 147 */     this.weightSheet = weightSheet;
/*     */   }
/*     */   
/*     */   public BalanceSheet getBalanceSheet() {
/* 151 */     return this.balanceSheet;
/*     */   }
/*     */   
/*     */   public void setBalanceSheet(BalanceSheet balanceSheet) {
/* 155 */     this.balanceSheet = balanceSheet;
/*     */   }
/*     */   
/*     */   public Date getTime() {
/* 159 */     return this.time;
/*     */   }
/*     */   
/*     */   public void setTime(Date time) {
/* 163 */     this.time = time;
/*     */   }
/*     */   
/*     */   public Boolean getIsFinished() {
/* 167 */     return this.isFinished;
/*     */   }
/*     */   
/*     */   public void setIsFinished(Boolean isFinished) {
/* 171 */     this.isFinished = isFinished;
/*     */   }
/*     */   
/*     */   public Integer getAllowStage() {
/* 175 */     return this.allowStage;
/*     */   }
/*     */   
/*     */   public void setAllowStage(Integer allowStage) {
/* 179 */     this.allowStage = allowStage;
/*     */   }
/*     */   
/*     */   public WeightSheet getSecondWeightSheet() {
/* 183 */     return this.secondWeightSheet;
/*     */   }
/*     */   
/*     */   public void setSecondWeightSheet(WeightSheet secondWeightSheet) {
/* 187 */     this.secondWeightSheet = secondWeightSheet;
/*     */   }
/*     */   
/*     */   public Boolean getHasSecond() {
/* 191 */     return this.hasSecond;
/*     */   }
/*     */   
/*     */   public void setHasSecond(Boolean hasSecond) {
/* 195 */     this.hasSecond = hasSecond;
/*     */   }
/*     */   
/*     */   public Date getOutTime() {
/* 199 */     return this.outTime;
/*     */   }
/*     */   
/*     */   public void setOutTime(Date outTime) {
/* 203 */     this.outTime = outTime;
/*     */   }
/*     */   
/*     */   public Contract getSecondContract() {
/* 207 */     return this.secondContract;
/*     */   }
/*     */   
/*     */   public void setSecondContract(Contract secondContract) {
/* 211 */     this.secondContract = secondContract;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\GrainTraffic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */