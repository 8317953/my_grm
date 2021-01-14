package com.haut.grm.model.business;

import com.haut.grm.model.CargoRep;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={StockAggSum.class})
public abstract interface StockAggSumDetail
{
  public abstract StockRepresentation getStock();
  
  public abstract CargoRep getCargo();
  
  public abstract Date getTime();
  
  public abstract Long getAmount();
  
  public abstract Long getInAmount();
  
  public abstract Long getOutAmount();
  
  public abstract Double getWaterAmount();
  
  public abstract Double getImpurityAmount();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockAggSumDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */