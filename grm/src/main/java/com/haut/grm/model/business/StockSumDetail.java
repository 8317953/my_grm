package com.haut.grm.model.business;

import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

import com.haut.grm.model.CargoRepView;
import com.haut.grm.model.CargoRepViewDetail;

@Projection(name="detail", types={StockSum.class, StockSumHistory.class})
public abstract interface StockSumDetail
  extends StockSumAmount, StockSumAnalysis
{
	public abstract CargoRepViewDetail getCargo();//这里需要注意 如果想要一层层递进传的对象并非它本身
	
	public abstract Date getInputTime();
  
	public abstract Boolean getInFinished();
  
	public abstract Boolean getOutFinished();
  
	public abstract Date getInTime();
  
	public abstract Date getOutTime();
  
	public abstract Double getUnitWeight();
  
	public abstract Double getDeductVolume();
  
	public abstract Double getFactor();
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockSumDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */