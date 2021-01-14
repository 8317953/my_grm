package com.haut.grm.repository.ies;

import com.haut.grm.model.ies.VehicleLicense;
import com.haut.grm.repository.base.BaseEntityRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface VehicleLicenseRepository
  extends BaseEntityRepository<VehicleLicense, Long>
{
  public abstract VehicleLicense findTop1ByPlateOrderByTimeDesc(String paramString);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\ies\VehicleLicenseRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */