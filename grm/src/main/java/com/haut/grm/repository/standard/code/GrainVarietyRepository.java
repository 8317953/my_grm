package com.haut.grm.repository.standard.code;

import com.haut.grm.model.standard.code.GrainVariety;
import com.haut.grm.repository.base.BaseStandardCodeRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface GrainVarietyRepository
  extends BaseStandardCodeRepository<GrainVariety>
{
  @Query(value="SELECT * FROM sc_grain_variety WHERE length(code_short) = 3", nativeQuery=true)
  public abstract List<GrainVariety> getGeneralCategories();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\standard\code\GrainVarietyRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */