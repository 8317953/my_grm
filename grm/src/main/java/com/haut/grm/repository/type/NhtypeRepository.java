package com.haut.grm.repository.type;

import com.haut.grm.model.type.Nhtype;
import com.haut.grm.repository.base.BaseTypeRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface NhtypeRepository
  extends BaseTypeRepository<Nhtype>
{}