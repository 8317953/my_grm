package com.haut.grm.repository.entry;

import com.haut.grm.model.entry.EntryMeasure;
import com.haut.grm.repository.base.BaseEntryRepository;
import java.util.List;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface EntryMeasureRepository
  extends BaseEntryRepository<EntryMeasure>
{
  public abstract List<EntryMeasure> findByStore_IdOrderByTimeDesc(Long paramLong);
  
  public abstract long countByStore_Id(Long paramLong);
  
  public abstract List<EntryMeasure> findTop6ByStoreNotNullOrderByTimeDesc();
  
  public abstract EntryMeasure findTopByStore_IdAndIsAutoOrderByTimeDesc(Long paramLong, boolean paramBoolean);
  
  public abstract EntryMeasure findTop1ByStore_IdOrderByTimeDesc(Long paramLong);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\entry\EntryMeasureRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */