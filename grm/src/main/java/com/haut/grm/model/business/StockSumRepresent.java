package com.haut.grm.model.business;

import com.haut.grm.model.CargoRepView;
import com.haut.grm.model.CargoRepViewDetail;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="represent", types={StockSum.class, StockSumHistory.class})
public abstract interface StockSumRepresent
{
  public abstract Long getId();
  
  public abstract CargoRepViewDetail getCargo();
  
  public abstract String getCargoName();
  
  public abstract String getCargoNameShort();
  
  public abstract String getBusinessKey();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockSumRepresent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */