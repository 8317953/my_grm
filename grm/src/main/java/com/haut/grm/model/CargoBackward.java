package com.haut.grm.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="backward", types={Cargo.class})
public abstract interface CargoBackward
{
  public abstract Long getId();
  
  public abstract CompartmentBackward getCompartment();
  
  public abstract String getName();
  
  public abstract String getCodeId();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\CargoBackward.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */