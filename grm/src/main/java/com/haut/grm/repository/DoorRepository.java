package com.haut.grm.repository;

import com.haut.grm.model.Door;
import com.haut.grm.repository.base.BaseEntityRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface DoorRepository
  extends BaseEntityRepository<Door, Long>
{
  public abstract Door findByStore_Depot_IdAndStore_CodeIdAndCodeId(Long paramLong, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Door findByStore_IdAndCodeId(Long paramLong, Integer paramInteger);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\DoorRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */