package com.haut.grm.repository;

import com.haut.grm.model.Depot;
import com.haut.grm.repository.base.BaseEntityRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface DepotRepository
  extends BaseEntityRepository<Depot, Long>
{}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\DepotRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */