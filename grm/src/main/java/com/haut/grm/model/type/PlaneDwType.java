package com.haut.grm.model.type;

import com.haut.grm.model.base.AbstractType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="plane_dw_type")
public class PlaneDwType
  extends AbstractType
{
  private static final long serialVersionUID = 1782246482070067345L;
}
