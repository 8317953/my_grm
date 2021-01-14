/*     */ package com.haut.grm.util;
/*     */ 
/*     */ import com.haut.grm.bean.GlobalHandler;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.StoreConfig;
/*     */ import com.haut.grm.model.dto.TemperatureDataDto;
/*     */ import com.haut.grm.model.meta.StoreModel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.FutureTask;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
/*     */ 
/*     */ public class TemperatureUtil
/*     */ {
/*     */   public static TemperatureDataDto parseTemp(String coreUrl, String data, Integer number)
/*     */   {
/*  21 */     TemperatureDataDto tDto = new TemperatureDataDto();
/*  22 */     ArrayList<Double> dataList = new ArrayList();
/*  23 */     String[] segs = data.split(",");
/*  24 */     int i = 0;
/*  25 */     String[] arrayOfString1; int j = (arrayOfString1 = segs).length; for (int i1 = 0; i1 < j; i1++) { String seg = arrayOfString1[i1];
/*  26 */       if (i1 < number.intValue()) {
/*  27 */         if (seg.matches("[-+]?[0-9]*\\.?[0-9]+")) {
/*  28 */           dataList.add(Double.valueOf(seg));
/*     */         }
/*     */         else {
/*  31 */           dataList.add(null);
/*     */         }
/*     */       }
/*  34 */       if (seg.matches(".*仓外湿度.*[-+]?[0-9]*\\.?[0-9]+%")) {
/*  35 */         Pattern p = Pattern.compile("^.*：([-+]?[0-9]*\\.?[0-9]+)%$");
/*  36 */         Matcher m = p.matcher(seg);
/*  37 */         if (m.find())
/*  38 */           tDto.setOutMois(Double.valueOf(m.group(1)));
/*     */       }
/*  40 */       if (seg.matches(".*仓外温度.*[-+]?[0-9]*\\.?[0-9]+度")) {
/*  41 */         Pattern p = Pattern.compile(".*：([-+]?[0-9]*\\.?[0-9]+)度");
/*  42 */         Matcher m = p.matcher(seg);
/*  43 */         if (m.find())
/*  44 */           tDto.setOutTemp(Double.valueOf(m.group(1)));
/*     */       }
/*  46 */       if (seg.matches(".*仓内湿度.*[-+]?[0-9]*\\.?[0-9]+%")) {
/*  47 */         Pattern p = Pattern.compile("^.*：([-+]?[0-9]*\\.?[0-9]+)%$");
/*  48 */         Matcher m = p.matcher(seg);
/*  49 */         if (m.find())
/*  50 */           tDto.setHouseMois(Double.valueOf(m.group(1)));
/*     */       }
/*  52 */       if (seg.matches(".*仓内温度.*[-+]?[0-9]*\\.?[0-9]+度")) {
/*  53 */         Pattern p = Pattern.compile(".*：([-+]?[0-9]*\\.?[0-9]+)度");
/*  54 */         Matcher m = p.matcher(seg);
/*  55 */         if (m.find())
/*  56 */           tDto.setHouseTemp(Double.valueOf(m.group(1)));
/*     */       }
/*  58 */       i1++;
/*     */     }
/*  60 */     tDto.setData(dataList);
/*  61 */     return tDto;
/*     */   }
/*     */   
/*     */   public static TemperatureDataDto executeGetTemperature(String coreUrl, Store store, Integer waitInSeconds) throws Exception {
/*  65 */     final List<NameValuePair> params = new ArrayList();
/*  66 */     params.add(new org.apache.http.message.BasicNameValuePair("cangfang", store.getCodeId().toString()));
/*     */     
/*  68 */     Callable<String> call = new Callable() {
/*     */       public String call() throws Exception {
///*  70 */         String result = MeasureWebServiceUtil.execute(TemperatureUtil.this, "getTemperatureDatas", params);
///*  71 */         return result;
					return null;
/*     */       }
/*     */       
/*  74 */     };
/*  75 */     FutureTask<String> future = new FutureTask(call);
/*  76 */     GlobalHandler.getScheduler().execute(future);
/*  77 */     String data = (String)future.get(waitInSeconds.intValue(), java.util.concurrent.TimeUnit.SECONDS);
/*  78 */     return regulateData(parseTemp(coreUrl, data, Integer.valueOf(new Long(store.getConfig().getTempBreadth().longValue() * store.getConfig().getTempWidth().longValue() * store.getConfig().getTempLayer().longValue()).intValue())), store);
/*     */   }
/*     */   
/*     */   public static TemperatureDataDto regulateData(TemperatureDataDto data, Store store) throws CloneNotSupportedException {
/*  82 */     TemperatureDataDto result = (TemperatureDataDto)data.clone();
/*  83 */     List<Double> dataList = data.getData();
/*  84 */     List<List<Double>> cableList = new ArrayList();
/*  85 */     int cableLength = store.getConfig().getTempLayer().intValue();
/*  86 */     int nx = store.getConfig().getTempBreadth().intValue();
/*  87 */     int cableNumber = store.getConfig().getTempBreadth().intValue() * store.getConfig().getTempWidth().intValue();
/*  88 */     for (int i = 0; i < cableNumber; i++) {
/*  89 */       List<Double> thisCable = new ArrayList();
/*  90 */       for (int j = 0; j < cableLength; j++) {
/*  91 */         thisCable.add((Double)dataList.get(i * cableLength + j));
/*     */       }
/*  93 */       cableList.add(thisCable); }
/*     */     List<Integer> nullNumber;
/*  95 */     for (int i = 0; i < cableNumber; i++) {
/*  96 */       List<Double> thisCable = (List)cableList.get(i);
/*  97 */       nullNumber = new ArrayList();
/*  98 */       List<Integer> iregularNumber = new ArrayList();
/*  99 */       for (int j = 0; j < cableLength; j++) {
/* 100 */         if (thisCable.get(j) == null) {
/* 101 */           nullNumber.add(Integer.valueOf(j));
/*     */         }
/* 103 */         else if (isIregular((Double)thisCable.get(j))) {
/* 104 */           iregularNumber.add(Integer.valueOf(j));
/*     */         }
/*     */       }
/* 107 */       if (nullNumber.size() + iregularNumber.size() != 0)
/*     */       {
/* 109 */         if (nullNumber.size() + iregularNumber.size() > cableLength / 2) {
/* 110 */           for (Integer x : iregularNumber) {
/* 111 */             thisCable.set(x.intValue(), null);
/*     */           }
/*     */           
/*     */         }
/* 115 */         else if (store.getConfig().getModel().isCircle()) {
/* 116 */           Double aver = Double.valueOf(0.0D);
/* 117 */           for (int j = 0; j < cableLength; j++) {
/* 118 */             if (!isIregularOrNull((Double)thisCable.get(j)))
/* 119 */               aver = Double.valueOf(aver.doubleValue() + ((Double)thisCable.get(j)).doubleValue());
/*     */           }
/* 121 */           aver = Double.valueOf(aver.doubleValue() / (cableLength - nullNumber.size() - iregularNumber.size()));
/* 122 */           for (Integer x : iregularNumber) {
/* 123 */             thisCable.set(x.intValue(), aver);
/*     */           }
/* 125 */           for (Integer x : nullNumber) {
/* 126 */             thisCable.set(x.intValue(), aver);
/*     */           }
/*     */         }
/*     */         else {
/* 130 */           for (int j = 0; j < cableLength; j++) {
/* 131 */             if (isIregularOrNull((Double)thisCable.get(j))) {
/* 132 */               Double aver = Double.valueOf(0.0D);
/* 133 */               int count = 0;
/*     */               
/* 135 */               if ((j != 0) && (!isIregularOrNull((Double)thisCable.get(j - 1)))) {
/* 136 */                 aver = Double.valueOf(aver.doubleValue() + ((Double)thisCable.get(j - 1)).doubleValue());
/* 137 */                 count++;
/*     */               }
/*     */               
/* 140 */               if ((j + 1 != cableLength) && (!isIregularOrNull((Double)thisCable.get(j + 1)))) {
/* 141 */                 aver = Double.valueOf(aver.doubleValue() + ((Double)thisCable.get(j + 1)).doubleValue());
/* 142 */                 count++;
/*     */               }
/*     */               
/* 145 */               if ((i > 0) && (!isIregularOrNull((Double)((List)cableList.get(i - 1)).get(j)))) {
/* 146 */                 aver = Double.valueOf(aver.doubleValue() + ((Double)((List)cableList.get(i - 1)).get(j)).doubleValue());
/* 147 */                 count++;
/*     */               }
/*     */               
/* 150 */               if ((i < cableNumber - 1) && (!isIregularOrNull((Double)((List)cableList.get(i + 1)).get(j)))) {
/* 151 */                 aver = Double.valueOf(aver.doubleValue() + ((Double)((List)cableList.get(i + 1)).get(j)).doubleValue());
/* 152 */                 count++;
/*     */               }
/*     */               
/* 155 */               if ((i >= nx) && (!isIregularOrNull((Double)((List)cableList.get(i - nx)).get(j)))) {
/* 156 */                 aver = Double.valueOf(aver.doubleValue() + ((Double)((List)cableList.get(i - nx)).get(j)).doubleValue());
/* 157 */                 count++;
/*     */               }
/*     */               
/* 160 */               if ((i <= cableNumber - nx) && (!isIregularOrNull((Double)((List)cableList.get(i + nx)).get(j)))) {
/* 161 */                 aver = Double.valueOf(aver.doubleValue() + ((Double)((List)cableList.get(i + nx)).get(j)).doubleValue());
/* 162 */                 count++;
/*     */               }
/* 164 */               if (count > 0) {
/* 165 */                 thisCable.set(j, Double.valueOf(aver.doubleValue() / count));
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 172 */     List<Double> resultList = new ArrayList();
/* 173 */     for (List<Double> thisCable : cableList) {
/* 174 */       resultList.addAll(thisCable);
/*     */     }
/* 176 */     result.setRawData(dataList);
/* 177 */     result.setData(resultList);
/* 178 */     return result;
/*     */   }
/*     */   
/*     */   private static boolean isIregular(Double point) {
/* 182 */     return (point != null) && ((point.doubleValue() > 100.0D) || (point.doubleValue() < -100.0D));
/*     */   }
/*     */   
/*     */   private static boolean isIregularOrNull(Double point) {
/* 186 */     return (point == null) || (point.doubleValue() > 100.0D) || (point.doubleValue() < -100.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\TemperatureUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */