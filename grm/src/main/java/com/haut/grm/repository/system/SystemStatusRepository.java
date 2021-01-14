package com.haut.grm.repository.system;

import com.haut.grm.model.system.SystemStatus;
import com.haut.grm.repository.base.BaseEntityRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface SystemStatusRepository
  extends BaseEntityRepository<SystemStatus, Long>
{
  public abstract SystemStatus findByCode(@Param("code") String paramString);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\system\SystemStatusRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */