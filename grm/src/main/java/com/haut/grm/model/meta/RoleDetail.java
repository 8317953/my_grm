package com.haut.grm.model.meta;

import com.haut.grm.model.system.SystemTrafficModule;
import java.util.Set;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={Role.class})
public abstract interface RoleDetail
{
  public abstract Long getId();
  
  public abstract Integer getCodeId();
  
  public abstract String getName();
  
  public abstract String getCode();
  
  public abstract Department getDepartment();
  
  public abstract Set<MenuFlatten> getMenus();
  
  public abstract Set<SystemTrafficModule> getTrafficModules();
  
  public abstract Set<ActivitiGroup> getActivitiGroups();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\RoleDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */