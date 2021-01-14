package com.haut.grm.model;

import com.haut.grm.model.type.CameraManufacturer;
import com.haut.grm.model.type.CameraType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="list", types={DeviceCamera.class})
public abstract interface DeviceCameraList
{
  public abstract Long getId();
  
  public abstract String getName();
  
  public abstract CameraType getType();
  
  public abstract CameraManufacturer getManufacturer();
  
  public abstract StoreBackward getStore();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\DeviceCameraList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */