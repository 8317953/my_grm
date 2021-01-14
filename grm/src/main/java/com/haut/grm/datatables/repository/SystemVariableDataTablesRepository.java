package com.haut.grm.datatables.repository;

import com.haut.grm.model.system.SystemVariable;
import org.springframework.data.jpa.datatables.qrepository.QDataTablesRepository;

public abstract interface SystemVariableDataTablesRepository
  extends QDataTablesRepository<SystemVariable, Long>
{
  public abstract SystemVariable findByVariableKey(String paramString);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\datatables\repository\SystemVariableDataTablesRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */