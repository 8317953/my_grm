package com.haut.grm.model;

import com.haut.grm.model.type.DoorState;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={Door.class})
public abstract interface DoorDetail
{
  public abstract Long getId();
  
  public abstract String getName();
  
  public abstract Integer getCodeId();
  
  public abstract Boolean getOccupied();
  
  public abstract DoorState getState();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\DoorDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */