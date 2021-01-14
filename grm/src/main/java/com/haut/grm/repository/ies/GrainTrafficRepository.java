package com.haut.grm.repository.ies;

import com.haut.grm.model.ies.GrainTraffic;
import com.haut.grm.repository.base.BaseEntityRepository;
import java.util.Date;
import java.util.List;

public abstract interface GrainTrafficRepository
  extends BaseEntityRepository<GrainTraffic, Long>
{
  public abstract GrainTraffic findByCode(String paramString);
  
  public abstract GrainTraffic findTop1ByRegisterRecord_CardCodeOrderByTimeDesc(String paramString);
  
  public abstract GrainTraffic findTop1ByAnalysis_BarcodeAndIsFinishedOrderByTimeDesc(String paramString, Boolean paramBoolean);
  
  public abstract GrainTraffic findTop1ByAnalysis_Barcode(String paramString);
  
  public abstract GrainTraffic findByRegisterRecord_PersonnelIdNumber(String paramString);
  
  public abstract List<GrainTraffic> findByIsFinished(boolean paramBoolean);
  
  public abstract List<GrainTraffic> findByTimeBetweenAndIsFinished(Date paramDate1, Date paramDate2, boolean paramBoolean);
  
  public abstract List<GrainTraffic> findByOutTimeBetweenAndIsFinished(Date paramDate1, Date paramDate2, boolean paramBoolean);
  
  public abstract List<GrainTraffic> findByIsIngressAndIsFinished(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract List<GrainTraffic> findByOutTimeBetweenAndIsFinishedAndStage_Value(Date paramDate1, Date paramDate2, boolean paramBoolean, Integer paramInteger);
  
  public abstract List<GrainTraffic> findTop10ByIsIngressAndIsFinishedOrderByOutTimeDesc(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract List<GrainTraffic> findTop20ByIsIngressAndAnalysis_DoneOrderByAnalysis_AnalysisTimeDesc(boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\ies\GrainTrafficRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */