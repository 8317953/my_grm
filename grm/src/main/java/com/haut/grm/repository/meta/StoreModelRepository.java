package com.haut.grm.repository.meta;

import com.haut.grm.model.meta.StoreModel;
import com.haut.grm.repository.base.BaseEntityRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface StoreModelRepository
  extends BaseEntityRepository<StoreModel, Long>
{
  public abstract StoreModel findByName(@Param("name") String paramString);
  
  public abstract StoreModel findByCodeId(@Param("codeId") Integer paramInteger);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\meta\StoreModelRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */