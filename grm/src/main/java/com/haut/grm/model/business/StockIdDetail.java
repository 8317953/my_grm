package com.haut.grm.model.business;

import com.haut.grm.model.CargoBackward;
import com.haut.grm.model.standard.code.GrainVariety;
import com.haut.grm.model.type.Country;
import com.haut.grm.model.type.GrainType;
import com.haut.grm.model.type.PackageCategory;
import com.haut.grm.model.type.PackageType;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={StockId.class})
public abstract interface StockIdDetail
{
  public abstract Long getId();
  
  public abstract CargoBackward getCargo();
  
  public abstract GrainType getGrainType();
  
  public abstract GrainVariety getGrainVariety();
  
  public abstract String getYear();
  
  public abstract Long getAmount();
  
  public abstract PackageType getPackageType();
  
  public abstract String getLocation();
  
  public abstract String getBusinessKey();
  
  public abstract Date getInputTime();
  
  public abstract Boolean getInFinished();
  
  public abstract Boolean getOutFinished();
  
  public abstract Date getInTime();
  
  public abstract Date getOutTime();
  
  public abstract Double getUnitWeight();
  
  public abstract Double getDeductVolume();
  
  public abstract Double getFactor();
  
  public abstract PackageCategory getPackageCategory();
  
  public abstract Country getCountry();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockIdDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */