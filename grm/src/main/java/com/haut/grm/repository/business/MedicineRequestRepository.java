package com.haut.grm.repository.business;

import com.haut.grm.model.business.MedicineRequest;
import com.haut.grm.model.business.QMedicineRequest;
import com.haut.grm.repository.base.BaseBusinessRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface MedicineRequestRepository
  extends BaseBusinessRepository<MedicineRequest, QMedicineRequest>
{}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\business\MedicineRequestRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */