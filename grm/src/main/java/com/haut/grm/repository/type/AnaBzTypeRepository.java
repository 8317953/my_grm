package com.haut.grm.repository.type;

import com.haut.grm.model.type.AnaBzType;

import com.haut.grm.repository.base.BaseTypeRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface AnaBzTypeRepository
  extends BaseTypeRepository<AnaBzType>
{
	public void deleteByName(String name);
	
	public AnaBzType findByName(String name);

}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\type\PlanTypeRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */