package com.haut.grm.repository.system;

import com.haut.grm.model.system.SystemVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="variables", itemResourceRel="variable", path="variables")
public abstract interface VariableRepository
  extends JpaRepository<SystemVariable, Long>
{}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\system\VariableRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */