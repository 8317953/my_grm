package com.haut.grm.repository.type;


import com.haut.grm.model.type.PlaneDwType;
import com.haut.grm.repository.base.BaseTypeRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface PlanDwTypeRepository
  extends BaseTypeRepository<PlaneDwType>
{}
