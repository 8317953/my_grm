package com.haut.grm.qt.repository;

import com.haut.grm.qt.model.Parecord;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface ParecordRepository
  extends JpaRepository<Parecord, String>
{
  public abstract Parecord findTop1ByCodeIdOrderByTimeDesc(String paramString);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\repository\ParecordRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */