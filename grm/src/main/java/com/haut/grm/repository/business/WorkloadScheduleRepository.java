package com.haut.grm.repository.business;

import com.haut.grm.model.Store;
import com.haut.grm.model.business.QWorkloadSchedule;
import com.haut.grm.model.business.WorkloadSchedule;
import com.haut.grm.repository.base.BaseBusinessRepository;
import java.util.List;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface WorkloadScheduleRepository
  extends BaseBusinessRepository<WorkloadSchedule, QWorkloadSchedule>
{
  public abstract List<WorkloadSchedule> findByStore(Store paramStore);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\business\WorkloadScheduleRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */