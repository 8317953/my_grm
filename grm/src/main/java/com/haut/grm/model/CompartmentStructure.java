package com.haut.grm.model;

import java.util.Set;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="structure", types={Compartment.class})
public abstract interface CompartmentStructure
  extends CompartmentDetail
{
  public abstract Set<CargoDetail> getCargos();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\CompartmentStructure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */