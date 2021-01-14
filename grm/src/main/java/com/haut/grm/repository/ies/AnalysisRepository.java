package com.haut.grm.repository.ies;

import java.util.List;

import com.haut.grm.model.ies.Analysis;
import com.haut.grm.repository.base.BaseEntityRepository;

public abstract interface AnalysisRepository
  extends BaseEntityRepository<Analysis, Long>
{
  public abstract Analysis findByBarcode(String paramString);
  
  public List<Analysis> findByBarcodeLike(String barcode);
  
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\ies\AnalysisRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */