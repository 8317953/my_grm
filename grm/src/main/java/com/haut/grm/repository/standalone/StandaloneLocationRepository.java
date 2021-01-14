package com.haut.grm.repository.standalone;

import com.haut.grm.model.standalone.QStandaloneLocation;
import com.haut.grm.model.standalone.StandaloneLocation;
import com.haut.grm.repository.base.BaseStandaloneRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface StandaloneLocationRepository
  extends BaseStandaloneRepository<StandaloneLocation, QStandaloneLocation>
{}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\standalone\StandaloneLocationRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */