package com.haut.grm.repository.system;

import com.haut.grm.model.system.CoreVersion;
import com.haut.grm.repository.base.BaseEntityRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface CoreVersionRepository
  extends BaseEntityRepository<CoreVersion, Long>
{}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\system\CoreVersionRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */