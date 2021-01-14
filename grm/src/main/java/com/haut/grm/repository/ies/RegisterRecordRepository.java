package com.haut.grm.repository.ies;

import com.haut.grm.model.ies.RegisterRecord;
import com.haut.grm.repository.base.BaseEntityRepository;

public abstract interface RegisterRecordRepository
  extends BaseEntityRepository<RegisterRecord, Long>
{
  public abstract RegisterRecord findTop1ByCardCodeOrderByTimeDesc(String paramString);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\ies\RegisterRecordRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */