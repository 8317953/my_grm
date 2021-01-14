package com.haut.grm.model.meta;

import com.haut.grm.model.system.SystemModule;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="flatten", types={Menu.class})//可以看到这里有getparentMenu 标签flatten
public abstract interface MenuFlatten
{
  public abstract Integer getCodeId();
  
  public abstract Integer getPosition();
  
  public abstract String getName();
  
  public abstract String getUrl();
  
  public abstract String getIcon();
  
  public abstract Integer getLevel();
  
  public abstract Boolean getIsObsolete();
  
  public abstract MenuFlatten getParentMenu();
  
  public abstract SystemModule getModule();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\MenuFlatten.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */