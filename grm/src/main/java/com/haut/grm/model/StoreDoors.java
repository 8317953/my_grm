package com.haut.grm.model;

import java.util.Set;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="doors", types={Store.class})
public abstract interface StoreDoors
  extends StoreDetail
{
  public abstract Set<DoorDetail> getDoors();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\StoreDoors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */