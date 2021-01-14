package com.haut.grm.repository;

import com.haut.grm.model.Compartment;
import com.haut.grm.repository.base.BaseEntityRepository;
import java.util.List;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface CompartmentRepository
  extends BaseEntityRepository<Compartment, Long>
{
  public abstract List<Compartment> findByStore_Depot_Id(long paramLong);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\CompartmentRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */