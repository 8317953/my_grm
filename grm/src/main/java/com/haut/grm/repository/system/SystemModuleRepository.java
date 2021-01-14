package com.haut.grm.repository.system;

import com.haut.grm.model.system.SystemModule;
import com.haut.grm.repository.base.BaseEntityRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="modules", itemResourceRel="module", path="modules")
public abstract interface SystemModuleRepository
  extends BaseEntityRepository<SystemModule, Long>
{}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\system\SystemModuleRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */