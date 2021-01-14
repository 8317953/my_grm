package com.haut.grm.model.business;

import com.haut.grm.model.standard.code.GrainVariety;
import com.haut.grm.model.type.GrainType;
import com.haut.grm.model.type.PackageCategory;
import com.haut.grm.model.type.PackageType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="amount", types={StockSum.class})
public abstract interface StockSumAmount
  extends StockSumRepresent
{
  public abstract Long getAmount();
  
  public abstract Double getInAmount();
  
  public abstract Double getOutAmount();
  
  public abstract GrainVariety getGrainVariety();
  
  public abstract GrainType getGrainType();
  
  public abstract String getYear();
  
  public abstract String getLocation();
  
  public abstract PackageType getPackageType();
  
  public abstract PackageCategory getPackageCategory();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockSumAmount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */