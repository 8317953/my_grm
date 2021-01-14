package com.haut.grm.model.business;

import com.haut.grm.model.Depot;
import com.haut.grm.model.standard.code.GrainVariety;
import com.haut.grm.model.type.ContractType;
import com.haut.grm.model.type.GrainType;
import com.haut.grm.model.type.PackageType;
import com.haut.grm.model.type.Scale;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={Contract.class})
public abstract interface ContractDetail
{
  public abstract Long getId();
  
  public abstract ContractType getType();
  
  public abstract Client getClient();
  
  public abstract Long getAmount();
  
  public abstract GrainType getGrainType();
  
  public abstract GrainVariety getGrainVariety();
  
  public abstract Boolean getIsIngress();
  
  public abstract String getName();
  
  public abstract Double getPrice();
  
  public abstract Double getTotalPrice();
  
  public abstract Scale getScale();
  
  public abstract String getBusinessKey();
  
  public abstract Date getInputTime();
  
  public abstract Depot getDepot();
  
  public abstract PackageType getPackageType();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\ContractDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */