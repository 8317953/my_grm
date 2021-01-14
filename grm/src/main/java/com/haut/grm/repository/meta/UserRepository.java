package com.haut.grm.repository.meta;

import com.haut.grm.model.meta.Role;
import com.haut.grm.model.meta.User;
import com.haut.grm.repository.base.BaseEntityRepository;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface UserRepository
  extends BaseEntityRepository<User, Long>
{
  @EntityGraph(attributePaths={"roles.trafficModules"})
  public abstract User getByUsername(String paramString);
  
  @EntityGraph(attributePaths={"roles.trafficModules"})
  public abstract List<User> getByIdNotNull();
  
  public abstract User findByUsername(String paramString);
  
  public abstract List<User> findByRoles(List<Role> paramList);
  
  @EntityGraph(attributePaths={"roles.activitiGroups"})
  public abstract User readById(Long paramLong);
  
  @EntityGraph(attributePaths={"roles.trafficModules"})
  public abstract User getById(Long paramLong);
  
  public abstract List<User> findByOfficialNameContainingOrTelephoneContaining(String paramString1, String paramString2);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\meta\UserRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */