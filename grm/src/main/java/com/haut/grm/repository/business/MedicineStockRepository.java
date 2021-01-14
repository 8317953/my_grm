package com.haut.grm.repository.business;

import com.haut.grm.model.business.MedicineStock;
import com.haut.grm.model.business.QMedicineStock;
import com.haut.grm.repository.base.BaseBusinessRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface MedicineStockRepository
  extends BaseBusinessRepository<MedicineStock, QMedicineStock>
{}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\business\MedicineStockRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */