package com.haut.grm.model;

import java.util.Set;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="structure", types={Store.class})
public abstract interface StoreStructure
  extends StoreDetail
{
  public abstract Depot getDepot();
  
  public abstract Set<CompartmentStructure> getCompartments();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\StoreStructure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */