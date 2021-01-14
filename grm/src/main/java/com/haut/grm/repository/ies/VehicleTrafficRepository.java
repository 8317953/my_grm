package com.haut.grm.repository.ies;

import com.haut.grm.model.ies.VehicleTraffic;
import com.haut.grm.repository.base.BaseEntityRepository;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface VehicleTrafficRepository
  extends BaseEntityRepository<VehicleTraffic, Long>
{
  @Query(value="SELECT * FROM ies_vehicle_traffic WHERE deadline >= ?2 AND is_registered = 0 AND plate like %?1%", nativeQuery=true)
  public abstract List<VehicleTraffic> queryAvailable(String paramString, Date paramDate);
  
  @Query(value="SELECT * FROM ies_vehicle_traffic WHERE deadline >= ?1 AND is_registered = 0", nativeQuery=true)
  public abstract List<VehicleTraffic> getAvailable(Date paramDate);
  
  public abstract VehicleTraffic findTop1ByPlateOrderByTimeDesc(String paramString);
  
  public abstract VehicleTraffic findTop1ByPlateAndInOrderByTimeDesc(String paramString, Boolean paramBoolean);
  
  public abstract VehicleTraffic findTop1ByPlateAndInOrderByTimeAsc(String paramString, Boolean paramBoolean);
  
  public abstract VehicleTraffic findTop1ByPlateAndInAndDeadlineAfterOrderByTimeAsc(String paramString, Boolean paramBoolean, Date paramDate);
  
  public abstract VehicleTraffic findTop1ByPlateAndInAndFinishedOrderByTimeDesc(String paramString, Boolean paramBoolean1, Boolean paramBoolean2);
  
  public abstract VehicleTraffic findTop1ByPlateAndInAndFinishedOrderByInTimeDesc(String paramString, Boolean paramBoolean1, Boolean paramBoolean2);
  
  @Query(value="SELECT v1.* FROM ies_vehicle_traffic v1 INNER JOIN (SELECT max(time) latest, plate FROM ies_vehicle_traffic WHERE deadline >= ?1 GROUP BY plate) v2 ON v1.plate = v2.plate AND v1.time = v2.latest ORDER BY time DESC LIMIT 3", nativeQuery=true)
  public abstract List<VehicleTraffic> getAvailableTop3(Date paramDate);
  
  @Query(value="SELECT * FROM ies_vehicle_traffic WHERE id in (SELECT id FROM (SELECT v1.id,v1.plate,v1.time,v1.in_time FROM ies_vehicle_traffic v1 INNER JOIN (SELECT min(time) oldest, plate FROM ies_vehicle_traffic WHERE deadline >= ?1 AND is_registered = 0 AND is_in = 0 GROUP BY plate) v2  ON (v1.plate = v2.plate AND v1.time = v2.oldest) UNION SELECT v1.id,v1.plate,v1.time,v1.in_time FROM ies_vehicle_traffic v1 INNER JOIN (SELECT max(in_time) latest, plate FROM ies_vehicle_traffic WHERE deadline >= ?1 AND is_registered = 0 AND is_in = 1 AND is_finished = 0 GROUP BY plate) v2 ON (v1.plate = v2.plate AND v1.in_time = v2.latest) GROUP BY plate) xx)ORDER BY in_time DESC, time ASC", nativeQuery=true)
  public abstract List<VehicleTraffic> getRegisterable(Date paramDate);
  
  @Query(value="SELECT * FROM ies_vehicle_traffic WHERE id in (SELECT id FROM (SELECT v1.id,v1.plate,v1.time,v1.in_time FROM ies_vehicle_traffic v1 INNER JOIN (SELECT min(time) oldest, plate FROM ies_vehicle_traffic WHERE deadline >= ?2 AND is_registered = 0 AND is_in = 0 GROUP BY plate) v2  ON (v1.plate = v2.plate AND v1.time = v2.oldest) where v1.plate like %?1% UNION SELECT v1.id,v1.plate,v1.time,v1.in_time FROM ies_vehicle_traffic v1 INNER JOIN (SELECT max(in_time) latest, plate FROM ies_vehicle_traffic WHERE deadline >= ?2 AND is_registered = 0 AND is_in = 1 AND is_finished = 0 GROUP BY plate) v2 ON (v1.plate = v2.plate AND v1.in_time = v2.latest) where v1.plate like %?1% GROUP BY plate) xx)ORDER BY in_time DESC, time ASC", nativeQuery=true)
  public abstract List<VehicleTraffic> queryRegisterable(String paramString, Date paramDate);
  
  @EntityGraph(attributePaths={"image"})
  public abstract VehicleTraffic getById(Long paramLong);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\ies\VehicleTrafficRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */