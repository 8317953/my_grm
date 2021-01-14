package com.haut.grm.repository.business;


import com.haut.grm.model.business.MyStockSumHistory;
import com.haut.grm.model.business.QMyStockSumHistory;
import com.haut.grm.repository.base.BaseBusinessRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface MyStockSumHistoryRepository
  extends BaseBusinessRepository<MyStockSumHistory, QMyStockSumHistory>
{
  
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\business\StockIdRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 * qingjias
 */