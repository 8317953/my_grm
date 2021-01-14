package com.haut.grm.repository.entry;

import com.haut.grm.model.Store;
import com.haut.grm.model.entry.EntryTemperature;
import com.haut.grm.repository.base.BaseEntityRepository;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface EntryTemperatureRepository
  extends BaseEntityRepository<EntryTemperature, Long>, JpaSpecificationExecutor<EntryTemperature>
{
  public abstract List<EntryTemperature> findByStoreOrderByTimeDesc(Store paramStore);
  
  public abstract List<EntryTemperature> findByStoreAndTimeBetweenOrderByTimeDesc(Store paramStore, Date paramDate1, Date paramDate2);
  
  public abstract List<EntryTemperature> findByTimeBetweenOrderByTimeDesc(Date paramDate1, Date paramDate2);
  
  public abstract List<EntryTemperature> findByTimeBetweenAndStore_IdInOrderByTimeDesc(Date paramDate1, Date paramDate2, List<Long> paramList);
  
  public abstract EntryTemperature findTop1ByStore_IdOrderByTimeDesc(@Param("storeId") Long paramLong);
  
  public abstract List<EntryTemperature> findTop6ByOrderByTimeDesc();
  
  public abstract EntryTemperature findTop1ByOrderByTimeDesc();
  
  public abstract long countByStore_Id(Long paramLong);
  
  @Query(value="SELECT * FROM entry_temperature WHERE DATE_FORMAT(`time`,'%H') = ?1", nativeQuery=true)
  public abstract List<EntryTemperature> findByHour(String paramString);
  
  @Query(value="SELECT * FROM entry_temperature WHERE DATE_FORMAT(`time`,'%H') = ?1 AND store_id = ?2", nativeQuery=true)
  public abstract List<EntryTemperature> findByHourAndStore(String paramString, Long paramLong);
  
  

  
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\entry\EntryTemperatureRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */