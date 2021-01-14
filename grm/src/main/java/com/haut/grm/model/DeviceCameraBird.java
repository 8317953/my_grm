package com.haut.grm.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="bird", types={DeviceCamera.class})
public abstract interface DeviceCameraBird
{
  public abstract Long getId();
  
  public abstract String getName();
  
  public abstract String getPositionX();
  
  public abstract String getPositionY();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\DeviceCameraBird.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */