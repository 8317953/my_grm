package com.haut.grm.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="backward", types={Depot.class})
public abstract interface DepotBackward
{
  public abstract Long getId();
  
  public abstract Integer getCodeId();
  
  public abstract String getName();
  
  public abstract String getAbbrev();
  
  public abstract Double getLongitude();
  
  public abstract Double getLatitude();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\DepotBackward.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */