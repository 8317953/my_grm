package com.haut.grm.repository.meta;

import com.haut.grm.model.meta.ActivitiGroup;
import com.haut.grm.repository.base.BaseEntityRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface ActivitiGroupRepository
  extends BaseEntityRepository<ActivitiGroup, Long>
{
  public abstract ActivitiGroup findByCode(String paramString);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\meta\ActivitiGroupRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */