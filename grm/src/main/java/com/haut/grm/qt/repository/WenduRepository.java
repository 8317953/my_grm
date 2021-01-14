package com.haut.grm.qt.repository;

import com.haut.grm.qt.model.Wendu;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface WenduRepository
  extends JpaRepository<Wendu, String>
{
  public abstract Wendu findTop1ByCodeIdOrderByTimeDesc(String paramString);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\repository\WenduRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */