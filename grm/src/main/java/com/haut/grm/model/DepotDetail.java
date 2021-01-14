package com.haut.grm.model;

import com.haut.grm.model.standard.code.Location;
import com.haut.grm.model.type.CompanyType;
import com.haut.grm.model.type.DepotCategory;
import com.haut.grm.model.type.RoadType;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={Depot.class})
public abstract interface DepotDetail
{
  public abstract Long getId();
  
  public abstract Integer getCodeId();
  
  public abstract String getCompanyShortCode();
  
  public abstract String getCompanyCode();
  
  public abstract String getCompanyName();
  
  public abstract String getName();
  
  public abstract String getAbbrev();
  
  public abstract CompanyType getDepotType();
  
  public abstract DepotCategory getDepotCategory();
  
  public abstract String getType();
  
  public abstract Date getBuiltDate();
  
  public abstract Double getSpace();
  
  public abstract String getTelephone();
  
  public abstract String getFax();
  
  public abstract String getAddress();
  
  public abstract String getZipCode();
  
  public abstract Double getLongitude();
  
  public abstract Double getLatitude();
  
  public abstract Location getLocation();
  
  public abstract Long getCapacity();
  
  public abstract Long getActiveCapacity();
  
  public abstract Long getOilCapacity();
  
  public abstract Long getActiveOilCapacity();
  
  public abstract String getManagerName();
  
  public abstract Boolean getIsOwn();
  
  public abstract RoadType getRoadType();
  
  public abstract String getRoadDistance();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\DepotDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */