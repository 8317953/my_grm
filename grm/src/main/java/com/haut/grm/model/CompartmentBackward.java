package com.haut.grm.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="backward", types={Compartment.class})
public abstract interface CompartmentBackward
{
  public abstract Long getId();
  
  public abstract StoreBackward getStore();
  
  public abstract String getName();
  
  public abstract String getCodeId();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\CompartmentBackward.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */