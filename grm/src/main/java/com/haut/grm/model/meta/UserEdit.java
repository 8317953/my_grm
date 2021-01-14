package com.haut.grm.model.meta;

import com.haut.grm.model.type.Diploma;
import com.haut.grm.model.type.Ethnicity;
import com.haut.grm.model.type.Major;
import com.haut.grm.model.type.PoliticalStatus;
import com.haut.grm.model.type.ProfessionalTitle;
import java.util.Date;
import java.util.Set;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="edit", types={User.class})
public abstract interface UserEdit
{
  public abstract Long getId();
  
  public abstract Integer getCodeId();
  
  public abstract String getUsername();
  
  public abstract String getOfficialName();
  
  public abstract String getTelephone();
  
  public abstract String getGender();
  
  public abstract Department getDepartment();
  
  public abstract Ethnicity getEthnicity();
  
  public abstract Set<RoleRepresent> getRoles();
  
  public abstract ProfessionalTitle getProfessionalTitle();
  
  public abstract Boolean getIsOutside();
  
  public abstract Date getDateOfIn();
  
  public abstract Date getDateOfBirth();
  
  public abstract String getEmail();
  
  public abstract Boolean getIsActive();
  
  public abstract Major getMajor();
  
  public abstract Diploma getDiploma();
  
  public abstract String getIdCode();
  
  public abstract PoliticalStatus getPoliticalStatus();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\UserEdit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */