package com.haut.grm.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="verbose", types={Store.class})
public abstract interface StoreVerbose
{
  public abstract Long getId();
  
  public abstract String getName();
  
  public abstract Depot getDepot();
  
  public abstract Integer getCodeId();
  
  public abstract Double getLength();
  
  public abstract Double getBreadth();
  
  public abstract Double getHeight();
  
  public abstract Double getGrainHeight();
  
  public abstract Long getActualVolume();
  
  public abstract Long getDesignVolume();
  
  public abstract Double getLongitude();
  
  public abstract Double getLatitude();
  
  public abstract DeviceCameraDetail getCamera();
  
  public abstract StoreConfigVerbose getConfig();
  
  public abstract StoreStatusDetail getStatus();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\StoreVerbose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */