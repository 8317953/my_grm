package com.haut.grm.model.meta;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="represent", types={Role.class})
public abstract interface RoleRepresent
{
  public abstract Long getId();
  
  public abstract Integer getCodeId();
  
  public abstract String getName();
  
  public abstract String getCode();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\RoleRepresent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */