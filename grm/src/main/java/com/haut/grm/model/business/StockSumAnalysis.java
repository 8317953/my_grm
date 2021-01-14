package com.haut.grm.model.business;

import com.haut.grm.model.type.AnalysisLevel;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="analysis", types={StockSum.class})
public abstract interface StockSumAnalysis
  extends StockSumRepresent
{
  public abstract AnalysisLevel getL_analysisLevel();
  
  public abstract Double getL_a1();
  
  public abstract Double getL_a2();
  
  public abstract Double getL_a3();
  
  public abstract Double getL_a4();
  
  public abstract Double getL_a5();
  
  public abstract Double getL_a6();
  
  public abstract Double getL_a7();
  
  public abstract Double getL_a8();
  
  public abstract Double getL_a9();
  
  public abstract Double getL_a10();
  
  public abstract Double getL_a11();
  
  public abstract Double getL_a12();
  
  public abstract Integer getL_a13();
  
  public abstract Double getL_a14();
  
  public abstract Double getL_a15();
  
  public abstract Integer getL_a16();
  
  public abstract Integer getL_a17();
  
  public abstract String getL_s1();
  
  public abstract String getL_s2();
  
  public abstract String getL_s3();
  
  public abstract String getL_s4();
  
  public abstract String getL_s5();
  
  public abstract AnalysisLevel getO_analysisLevel();
  
  public abstract Double getO_a1();
  
  public abstract Double getO_a2();
  
  public abstract Double getO_a3();
  
  public abstract Double getO_a4();
  
  public abstract Double getO_a5();
  
  public abstract Double getO_a6();
  
  public abstract Double getO_a7();
  
  public abstract Double getO_a8();
  
  public abstract Double getO_a9();
  
  public abstract Double getO_a10();
  
  public abstract Double getO_a11();
  
  public abstract Double getO_a12();
  
  public abstract Integer getO_a13();
  
  public abstract Double getO_a14();
  
  public abstract Double getO_a15();
  
  public abstract Integer getO_a16();
  
  public abstract Integer getO_a17();
  
  public abstract String getO_s1();
  
  public abstract String getO_s2();
  
  public abstract String getO_s3();
  
  public abstract String getO_s4();
  
  public abstract String getO_s5();
  
  public abstract AnalysisLevel getI_analysisLevel();
  
  public abstract Double getI_a1();
  
  public abstract Double getI_a2();
  
  public abstract Double getI_a3();
  
  public abstract Double getI_a4();
  
  public abstract Double getI_a5();
  
  public abstract Double getI_a6();
  
  public abstract Double getI_a7();
  
  public abstract Double getI_a8();
  
  public abstract Double getI_a9();
  
  public abstract Double getI_a10();
  
  public abstract Double getI_a11();
  
  public abstract Double getI_a12();
  
  public abstract Integer getI_a13();
  
  public abstract Double getI_a14();
  
  public abstract Double getI_a15();
  
  public abstract Integer getI_a16();
  
  public abstract Integer getI_a17();
  
  public abstract String getI_s1();
  
  public abstract String getI_s2();
  
  public abstract String getI_s3();
  
  public abstract String getI_s4();
  
  public abstract String getI_s5();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockSumAnalysis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */