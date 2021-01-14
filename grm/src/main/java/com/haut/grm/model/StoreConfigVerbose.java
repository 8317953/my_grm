package com.haut.grm.model;

import com.haut.grm.model.type.PackageCategory;
import com.haut.grm.model.type.StorageType;
import com.haut.grm.model.type.StructureType;
import com.haut.grm.model.type.TemperatureControlType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="verbose", types={StoreConfig.class})
public abstract interface StoreConfigVerbose
  extends StoreConfigDetail
{
  public abstract Boolean getIsInsulated();
  
  public abstract Boolean getIsPackagelessable();
  
  public abstract Boolean getIsInsecticidal();
  
  public abstract Boolean getIsRetardant();
  
  public abstract Boolean getIsTemperaturable();
  
  public abstract Boolean getIsVentilatable();
  
  public abstract Boolean getIsFumigatable();
  
  public abstract Boolean getIsChargeable();
  
  public abstract Boolean getIsInsectsensitive();
  
  public abstract PackageCategory getPackageCategory();
  
  public abstract StorageType getStorageType();
  
  public abstract TemperatureControlType getTemperatureControlType();
  
  public abstract StructureType getGroundStructure();
  
  public abstract StructureType getWallStructure();
  
  public abstract StructureType getRoofStructure();
  
  public abstract StructureType getFrameStructure();
  
  public abstract Boolean getIsRemote();
  
  public abstract Boolean getIsProcessed();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\StoreConfigVerbose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */