package com.haut.grm.model.business;

import java.util.Set;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="verbose", types={StockId.class})
public abstract interface StockIdVerbose
  extends StockIdDetail
{
  public abstract Set<StockChangeDetail> getPositiveStockChanges();
  
  public abstract Set<StockChangeDetail> getNegetiveStockChanges();
  
  public abstract Set<StockAnalysis> getStockAnalyses();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockIdVerbose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */