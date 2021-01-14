package com.haut.grm.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="backward", types={Store.class})
public abstract interface StoreBackward
{
  public abstract Long getId();
  
  public abstract DepotBackward getDepot();
  
  public abstract Integer getCodeId();
  
  public abstract String getName();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\StoreBackward.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */