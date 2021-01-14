package com.haut.grm.repository.business;

import com.haut.grm.model.business.MaterialStock;
import com.haut.grm.model.business.QMaterialStock;
import com.haut.grm.repository.base.BaseBusinessRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface MaterialStockRepository
  extends BaseBusinessRepository<MaterialStock, QMaterialStock>
{}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\business\MaterialStockRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */