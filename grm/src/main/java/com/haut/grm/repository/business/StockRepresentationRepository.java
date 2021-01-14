package com.haut.grm.repository.business;

import com.haut.grm.model.business.QStockRepresentation;
import com.haut.grm.model.business.StockRepresentation;
import com.haut.grm.repository.base.BaseQRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface StockRepresentationRepository
  extends BaseQRepository<StockRepresentation, Long, QStockRepresentation>
{}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\business\StockRepresentationRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */