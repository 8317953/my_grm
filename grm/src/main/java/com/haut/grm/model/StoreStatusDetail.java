package com.haut.grm.model;

import com.haut.grm.model.type.SpaceCondition;
import com.haut.grm.model.type.SpaceStatus;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={StoreStatus.class})
public abstract interface StoreStatusDetail
{
  public abstract Long getId();
  
  public abstract Boolean getIsMeasureOngoing();
  
  public abstract Date getMeasureTime();
  
  public abstract Date getSafetyTime();
  
  public abstract Date getDoorTime();
  
  public abstract String getMeasureComment();
  
  public abstract String getSafetyComment();
  
  public abstract String getDoorComment();
  
  public abstract SpaceCondition getCondition();
  
  public abstract SpaceStatus getStatus();
  
  public abstract Date getActiveDate();
  
  public abstract Boolean getAlerting();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\StoreStatusDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */