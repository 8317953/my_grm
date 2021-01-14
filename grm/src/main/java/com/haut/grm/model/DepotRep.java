package com.haut.grm.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="represent", types={Depot.class})
public abstract interface DepotRep
{
  public abstract String getKeyword();
  
  public abstract String getAbbrev();
  
  public abstract String getName();
  
  public abstract Integer getCodeId();
  
  public abstract Long getId();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\DepotRep.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */