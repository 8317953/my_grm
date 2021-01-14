package com.haut.grm.model;

import com.haut.grm.model.type.SpaceCondition;
import com.haut.grm.model.type.SpaceStatus;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={Compartment.class})
public abstract interface CompartmentDetail
{
  public abstract Long getId();
  
  public abstract Integer getCodeId();
  
  public abstract String getName();
  
  public abstract Double getLength();
  
  public abstract Double getBreadth();
  
  public abstract Double getHeight();
  
  public abstract Double getGrainHeight();
  
  public abstract String getActualVolume();
  
  public abstract String getDesignVolume();
  
  public abstract Double getLongitude();
  
  public abstract Double getLatitude();
  
  public abstract SpaceStatus getStatus();
  
  public abstract SpaceCondition getCondition();
  
  public abstract Date getActiveDate();
  
  public abstract void setActiveDate(Date paramDate);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\CompartmentDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */