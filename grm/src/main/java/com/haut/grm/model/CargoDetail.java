package com.haut.grm.model;

import com.haut.grm.model.type.CargoStatus;
import com.haut.grm.model.type.PackageCategory;
import com.haut.grm.model.type.PackageType;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={Cargo.class})
public abstract interface CargoDetail
{
  public abstract Long getId();
  
  public abstract Integer getCodeId();
  
  public abstract String getName();
  
  public abstract CargoStatus getStatus();
  
  public abstract PackageType getPackageType();
  
  public abstract PackageCategory getPackageCategory();
  
  public abstract Date getActiveDate();
  
  public abstract Double getVolume();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\CargoDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */