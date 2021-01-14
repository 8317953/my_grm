package com.haut.grm.repository.business;

import com.haut.grm.model.business.QStockId;
import com.haut.grm.model.business.StockId;
import com.haut.grm.repository.base.BaseBusinessRepository;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface StockIdRepository
  extends BaseBusinessRepository<StockId, QStockId>
{
  @Query(value="SELECT * FROM gb_stock_id s1 INNER JOIN (SELECT max(input_time) latest, cargo_id FROM gb_stock_id GROUP BY cargo_id) s2 ON s1.cargo_id = s2.cargo_id AND s1.input_time = s2.latest", nativeQuery=true)
  public abstract Set<StockId> current();
  
  //这个查询就是  SELECT max(input_time) latest, cargo_id FROM gb_stock_id GROUP BY cargo_id  根据cargo_id分组找最近一次该cargo 的stock 的时间      然后根据这个时间找到  stock（也就是该cargo 最近一次stock）
  @Query(value="SELECT * FROM gb_stock_id s1 INNER JOIN (SELECT max(input_time) latest, cargo_id FROM gb_stock_id GROUP BY cargo_id) s2 ON s1.cargo_id = s2.cargo_id AND s1.input_time = s2.latest WHERE s1.cargo_id =?1", nativeQuery=true)
  public abstract StockId currentCargo(Long paramLong);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\business\StockIdRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 * qingjias
 */