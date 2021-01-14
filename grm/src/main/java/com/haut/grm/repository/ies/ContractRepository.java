package com.haut.grm.repository.ies;

import com.haut.grm.model.business.Contract;
import com.haut.grm.model.business.QContract;
import com.haut.grm.repository.base.BaseBusinessRepository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public abstract interface ContractRepository
  extends BaseBusinessRepository<Contract, QContract>
{
  @RestResource(path="query", rel="query")
  public abstract List<Contract> findByBusinessKeyContainingOrNameContainingOrClient_NameContainingOrGrainVariety_NameContaining(@Param("filter") String paramString1, @Param("filter") String paramString2, @Param("filter") String paramString3, @Param("filter") String paramString4);

  public List<Contract> findAll();
  
//  @Query("select entity from #{#entityName} entity where entity.name like %:query% or entity.name like %:query%")
  @Query("select entity from #{#entityName} entity where entity.name like %:query% or entity.client.name like %:query%")
  List<Contract> queryLike(@Param("query") String s);
  
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\ies\ContractRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */