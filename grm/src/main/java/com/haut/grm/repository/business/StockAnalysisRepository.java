package com.haut.grm.repository.business;

import com.haut.grm.model.business.QStockAnalysis;
import com.haut.grm.model.business.StockAnalysis;
import com.haut.grm.repository.base.BaseBusinessRepository;

import java.util.List;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface StockAnalysisRepository
  extends BaseBusinessRepository<StockAnalysis, QStockAnalysis>
{

//	public List<StockAnalysis> findByBusinessKeyLike(String key);

}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\business\StockAnalysisRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */