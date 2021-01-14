package com.haut.grm.repository.business;

import com.haut.grm.model.business.BusinessNotification;
import com.haut.grm.model.meta.ActivitiGroup;
import com.haut.grm.model.meta.User;
import com.haut.grm.repository.base.BaseEntityRepository;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface BusinessNotificationRepository
  extends BaseEntityRepository<BusinessNotification, Long>
{
  public abstract List<BusinessNotification> findByUserAndTimeAfterOrActivitiGroupInAndTimeAfterOrderByTimeDesc(User paramUser, Date paramDate1, Collection<ActivitiGroup> paramCollection, Date paramDate2);
  
  public abstract List<BusinessNotification> findByUserAndTimeAfterOrderByTimeDesc(User paramUser, Date paramDate);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\business\BusinessNotificationRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */