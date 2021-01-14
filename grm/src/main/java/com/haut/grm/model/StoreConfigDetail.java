package com.haut.grm.model;

import com.haut.grm.model.meta.StoreModel;
import com.haut.grm.model.meta.User;
import com.haut.grm.model.standard.code.StoreType;
import com.haut.grm.model.system.CoreVersion;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={StoreConfig.class})
public abstract interface StoreConfigDetail
{
  public abstract Long getId();
  
  public abstract User getManager();
  
  public abstract Boolean getIsDemo();
  
  public abstract CoreVersion getVersion();
  
  public abstract String getSourcePositionX();
  
  public abstract String getSourcePositionY();
  
  public abstract String getTargetPositionX();
  
  public abstract String getTargetPositionY();
  
  public abstract Long getTempLayer();
  
  public abstract Long getTempBreadth();
  
  public abstract Long getTempWidth();
  
  public abstract String getCableData();
  
  public abstract StoreModel getModel();
  
  public abstract StoreType getType();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\StoreConfigDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */