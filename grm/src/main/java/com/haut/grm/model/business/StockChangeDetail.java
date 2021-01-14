package com.haut.grm.model.business;

import com.haut.grm.model.standard.code.GrainVariety;
import com.haut.grm.model.type.AnalysisLevel;
import com.haut.grm.model.type.GrainType;
import com.haut.grm.model.type.PackageCategory;
import com.haut.grm.model.type.SourceType;
import java.util.Date;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={StockChange.class})
public abstract interface StockChangeDetail
{
  public abstract Long getId();
  
  public abstract AnalysisLevel getAnalysisLevel();
  
  public abstract Double getWater();
  
  public abstract Double getImpurity();
  
  public abstract GrainType getGrainType();
  
  public abstract Long getPack();
  
  public abstract GrainVariety getGrainVariety();
  
  public abstract StockId getSourceStock();
  
  public abstract StockId getTargetStock();
  
  public abstract SourceType getType();
  
  public abstract Long getAmount();
  
  public abstract ContractDetail getContract();
  
  public abstract Date getInputTime();
  
  public abstract String getInputComment();
  
  public abstract String getBusinessKey();
  
  public abstract PackageCategory getPackageCategory();
  
  public abstract List<StockChangeEntry> getEntries();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockChangeDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */