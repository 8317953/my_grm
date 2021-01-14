package com.haut.grm.repository.ies;




import org.springframework.data.rest.core.annotation.RepositoryRestResource;



import com.haut.grm.model.business.ContractRep;

import com.haut.grm.model.business.QContractRep;
import com.haut.grm.repository.base.BaseBusinessRepository;

@RepositoryRestResource
public abstract interface ContractRepRepository
  extends BaseBusinessRepository<ContractRep, QContractRep>
{
  
  
}