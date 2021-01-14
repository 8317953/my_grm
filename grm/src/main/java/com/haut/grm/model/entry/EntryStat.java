package com.haut.grm.model.entry;

import com.haut.grm.model.StoreBackward;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="stat", types={EntryDoor.class, EntrySafety.class})
public abstract interface EntryStat
{
  public abstract Date getTime();
  
  public abstract StoreBackward getStore();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\EntryStat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */