package com.haut.grm.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="represent", types={Cargo.class})
public abstract interface CargoRep
{
  public abstract String getName();
  
  public abstract Integer getCodeId();
  
  public abstract Long getId();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\CargoRep.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */