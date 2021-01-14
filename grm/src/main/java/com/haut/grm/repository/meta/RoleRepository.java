package com.haut.grm.repository.meta;

import com.haut.grm.model.meta.Role;
import com.haut.grm.repository.base.BaseEntityRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public abstract interface RoleRepository
  extends BaseEntityRepository<Role, Long>
{
  @RestResource(exported=false)
  public abstract Role findByCode(String paramString);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\meta\RoleRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */