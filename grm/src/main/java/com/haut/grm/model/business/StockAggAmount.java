package com.haut.grm.model.business;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="amount", types={StockAgg.class})
public abstract interface StockAggAmount
  extends StockSumAmount
{}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockAggAmount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */