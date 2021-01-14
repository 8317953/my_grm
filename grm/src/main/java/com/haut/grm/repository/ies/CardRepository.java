package com.haut.grm.repository.ies;

import com.haut.grm.model.ies.Card;
import com.haut.grm.repository.base.BaseEntityRepository;
import java.util.List;

public abstract interface CardRepository
  extends BaseEntityRepository<Card, Long>
{
  public abstract List<Card> findByPrintNumberContaining(String paramString);
  
  public abstract Card findByPhysicalNumber(String paramString);
  
  public abstract Card findByPrintNumber(String paramString);
  
  public abstract Card findByPrintNumberOrPhysicalNumber(String paramString1, String paramString2);
  
  public abstract List<Card> findByPhysicalNumberContaining(String paramString);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\ies\CardRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */