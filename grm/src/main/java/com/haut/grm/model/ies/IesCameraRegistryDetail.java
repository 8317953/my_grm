package com.haut.grm.model.ies;

import com.haut.grm.model.DeviceCameraList;
import com.haut.grm.model.system.SystemTrafficModule;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={IesCameraRegistry.class})
public abstract interface IesCameraRegistryDetail
{
  public abstract Long getId();
  
  public abstract DeviceCameraList getCamera();
  
  public abstract SystemTrafficModule getTrafficModule();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\IesCameraRegistryDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */