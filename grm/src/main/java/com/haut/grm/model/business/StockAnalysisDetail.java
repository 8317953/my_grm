package com.haut.grm.model.business;

import com.haut.grm.model.type.AnalysisLevel;
import com.haut.grm.model.type.AnalysisType;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={StockAnalysis.class})
public abstract interface StockAnalysisDetail
{
  public abstract Long getId();
  
  public abstract StockIdBackward getStock();
  
  public abstract AnalysisType getType();
  
  public abstract AnalysisLevel getLevel();
  
  public abstract Double getA1();
  
  public abstract Double getA2();
  
  public abstract Double getA3();
  
  public abstract Double getA4();
  
  public abstract Double getA5();
  
  public abstract Double getA6();
  
  public abstract Double getA7();
  
  public abstract Double getA8();
  
  public abstract Double getA9();
  
  public abstract Double getA10();
  
  public abstract Double getA11();
  
  public abstract Double getA12();
  
  public abstract Integer getA13();
  
  public abstract Double getA14();
  
  public abstract Double getA15();
  
  public abstract Integer getA16();
  
  public abstract Integer getA17();
  
  public abstract String getS1();
  
  public abstract String getS2();
  
  public abstract String getS3();
  
  public abstract String getS4();
  
  public abstract String getS5();
  
  public abstract String getBusinessKey();
  
  public abstract Date getInputTime();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockAnalysisDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */