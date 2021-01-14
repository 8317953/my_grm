package com.haut.grm.model.business;

import com.haut.grm.model.Depot;
import com.haut.grm.model.standard.code.GrainVariety;
import com.haut.grm.model.type.GrainType;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={GrainRotate.class})
public abstract interface GrainRotateDetail
{
  public abstract Date getInputTime();
  
  public abstract String getBusinessKey();
  
  public abstract GrainType getGrainType();
  
  public abstract GrainVariety getGrainVariety();
  
  public abstract Long getAmount();
  
  public abstract Boolean getIsIngress();
  
  public abstract String getYear();
  
  public abstract Depot getDepot();
  
  public abstract String getHarvestYear();
  
  public abstract Integer getStockYear();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\GrainRotateDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */