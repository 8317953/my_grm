package com.haut.grm.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="represent", types={Compartment.class})
public abstract interface CompartmentRep
{
  public abstract String getName();
  
  public abstract Integer getCodeId();
  
  public abstract Long getId();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\CompartmentRep.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */