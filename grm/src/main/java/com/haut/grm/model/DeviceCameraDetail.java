package com.haut.grm.model;

import com.haut.grm.model.type.CameraManufacturer;
import com.haut.grm.model.type.CameraType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={DeviceCamera.class})
public abstract interface DeviceCameraDetail
{
  public abstract Long getId();
  
  public abstract String getIpAddress();
  
  public abstract String getName();
  
  public abstract Integer getPort();
  
  public abstract String getUsername();
  
  public abstract Float getHeight();
  
  public abstract String getPassword();
  
  public abstract CameraType getType();
  
  public abstract CameraManufacturer getManufacturer();
  
  public abstract String getPositionX();
  
  public abstract String getPositionY();
  
  public abstract StoreBackward getStore();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\DeviceCameraDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */