package com.haut.grm.model.business;

import com.haut.grm.model.CargoBackward;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="backward", types={StockId.class, StockSum.class})
public abstract interface StockIdBackward
{
  public abstract Long getId();
  
  public abstract CargoBackward getCargo();
  
  public abstract Date getInputTime();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockIdBackward.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */