package com.haut.grm.model.business;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail", types={ContractRep.class})//这个就相当于权限效果 加在实体类中 相当于查询了子集
public abstract interface ContractRepDetail
  extends ContractDetail
{
  public abstract String getReadableName();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\ContractRepDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */