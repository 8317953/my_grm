package com.haut.grm.model.ies;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={IesCameraImage.class})
public abstract interface IesCameraImageDetail
{
  public abstract Long getId();
  
  public abstract IesCameraRegistryDetail getRegistry();
  
  public abstract String getImagePath();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\IesCameraImageDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */