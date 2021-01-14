package com.haut.grm.model.business;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={Client.class})
public abstract interface ClientDetail
{
  public abstract Long getId();
  
  public abstract String getName();
  
  public abstract String getTelephone();
  
  public abstract String getAddress();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\ClientDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */