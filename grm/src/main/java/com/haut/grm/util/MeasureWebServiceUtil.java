/*     */ package com.haut.grm.util;
/*     */ 
/*     */ import com.haut.grm.bean.GlobalHandler;
/*     */ import com.haut.grm.model.entry.EntryMeasure;

import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.FutureTask;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.client.ClientProtocolException;
/*     */ import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MeasureWebServiceUtil
/*     */ {
/*     */   public static final String START_MEASURE = "startScan";
/*     */   public static final String STOP_MEASURE = "SysReset";
/*     */   public static final String START_MEASURE_NEW = "startMeasure";
/*     */   public static final String START_MEASURE_NEW_FULL = "startFullMeasure";
/*     */   public static final String GET_MEASURE_STATUS = "getMeasureStatus";
/*     */   public static final String GET_MEASURE_STATUS_FULL = "getMeasureFullStatus";
/*     */   public static final String GET_MEASURE_WEIGHT = "getScanWeight";
/*     */   public static final String GET_MEASURE_WEIGHT_NEW = "getMeasureWeight";
/*     */   public static final String GET_MEASURE_WEIGHT_NEW_FULL = "getMeasureFullWeight";
/*     */   public static final String GET_MEASURE_DATA = "getScanResult";
/*     */   public static final String GET_MEASURE_DATA_FULL = "getScanFullResult";
/*     */   public static final String SET_BASE_DATA = "setBaseDATA";
/*     */   public static final String SET_UP = "setUp";
/*     */   public static final String SET_DOWN = "setDown";
/*     */   public static final String SET_RIGHT = "setRight";
/*     */   public static final String SET_LEFT = "setLeft";
/*     */   public static final String MESSAGE_DELAYED = "message_delayed";
/*     */   public static final String SUCCESS_PREFIX = "suc_";
/*     */   public static final String SUCCESS = "suc";
/*     */   public static final String SUCCESS_WEIGHT_PREFIX = "suc_getScanWeight_";
/*     */   public static final String SUCCESS_DATA_PREFIX = "suc_getScanResult_";
/*     */   public static final String UNSUCCESS_PREFIX = "unsuc_";
/*     */   public static final String UNSUCCESS_SOCKET_PREFIX = "unsuc_socketconnect";
/*     */   public static final String UNSUCCESS_ALREADY_STARTED = "unsuc_startScan_dev_on";
/*     */   public static final String UNSUCCESS_ALREADY_STARTED_NEW = "unsuc_startmeasure_shebeibusy";
/*     */   public static final String STORE_ID_PARAM = "shebei";
/*     */   public static final String DATA_KEY = "data";
/*  74 */   public static int DEBUG_COUNTER = 0;
/*     */   
/*     */   /* Error */


public static String execute(TemperatureUtil tem, String action,List<NameValuePair> urlParameters) {
	return null;
	
}


public static String execute(String rootUrl, String action,List<NameValuePair> urlParameters) throws Exception {
//	System.out.println(rootUrl+","+action+","+urlParameters+"liiliiiiiiiiiiiiiiiidddddddddddddddddddddddddddddddddddddddddddddddddddd");
////	System.out.println("executeiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
//	String responseBody = null;
//    CloseableHttpClient httpclient = HttpClients.createDefault();
//	try {
//		//System.out.println("经过这1");
//		HttpPost post = new HttpPost(rootUrl+action);
//		//System.out.println("经过这2"+post);
//		if (urlParameters != null)
//			post.setEntity(new UrlEncodedFormEntity(urlParameters));
//
//		/*
//		 * 匿名
//		 */
//        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//
//            @Override
//            public String handleResponse(
//                    final HttpResponse response) throws ClientProtocolException, IOException {
//                int status = response.getStatusLine().getStatusCode();
//                if (status >= 200 && status < 300) {
//                    HttpEntity entity = response.getEntity();
//                    return entity != null ? EntityUtils.toString(entity) : null;
//                } else {
//                    throw new ClientProtocolException("Unexpected response status: " + status);
//                }
//            }
//
//        };
//        String content = httpclient.execute(post, responseHandler);
//        System.out.println("cotent:"+content);
////        <?xml version="1.0" encoding="utf-8"?>
////        <string xmlns="http://tempuri.org/">suc_getmeasurefullstatus_5,155</string>
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = factory.newDocumentBuilder();
//		Document doc = builder.parse(new InputSource(new ByteArrayInputStream(content.getBytes("utf-8"))));
//		responseBody = doc.getElementsByTagName("string").item(0).getFirstChild().getNodeValue();
//		System.out.println("responseBody:"+responseBody);
////		suc_getmeasurefullstatus_5,155
//		
//	} finally {
//		httpclient.close();
//    }
//	return responseBody;
	return null;
}
/*     */   
/*     */   public static String executeApiData(String apiUrl, EntryMeasure entry)
/*     */     throws Exception
/*     */   {
/* 114 */     Map<String, Object> requestParams = new HashMap();
/* 115 */     requestParams.put("data", entry);
/* 116 */     return executeJSON(apiUrl, null, requestParams);
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static String executeJSON(String rootUrl, String action, Map<String, Object> jsonParams)
/*     */     throws Exception
/*     */   {
				return null;
/*     */     // Byte code:
/*     */     //   0: aconst_null
/*     */     //   1: astore_3
/*     */     //   2: invokestatic 109	org/apache/http/impl/client/HttpClients:createDefault	()Lorg/apache/http/impl/client/CloseableHttpClient;
/*     */     //   5: astore 4
/*     */     //   7: new 115	org/apache/http/client/methods/HttpPost
/*     */     //   10: dup
/*     */     //   11: new 117	java/lang/StringBuilder
/*     */     //   14: dup
/*     */     //   15: aload_0
/*     */     //   16: invokestatic 119	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   19: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   22: aload_1
/*     */     //   23: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   26: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   29: invokespecial 138	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
/*     */     //   32: astore 5
/*     */     //   34: aload_2
/*     */     //   35: ifnull +141 -> 176
/*     */     //   38: aconst_null
/*     */     //   39: astore 6
/*     */     //   41: new 262	java/io/ByteArrayOutputStream
/*     */     //   44: dup
/*     */     //   45: invokespecial 264	java/io/ByteArrayOutputStream:<init>	()V
/*     */     //   48: astore 7
/*     */     //   50: new 265	com/fasterxml/jackson/core/JsonFactory
/*     */     //   53: dup
/*     */     //   54: invokespecial 267	com/fasterxml/jackson/core/JsonFactory:<init>	()V
/*     */     //   57: aload 7
/*     */     //   59: getstatic 268	com/fasterxml/jackson/core/JsonEncoding:UTF8	Lcom/fasterxml/jackson/core/JsonEncoding;
/*     */     //   62: invokevirtual 274	com/fasterxml/jackson/core/JsonFactory:createGenerator	(Ljava/io/OutputStream;Lcom/fasterxml/jackson/core/JsonEncoding;)Lcom/fasterxml/jackson/core/JsonGenerator;
/*     */     //   65: astore 8
/*     */     //   67: aload 8
/*     */     //   69: invokevirtual 278	com/fasterxml/jackson/core/JsonGenerator:writeStartObject	()V
/*     */     //   72: aload_2
/*     */     //   73: invokeinterface 283 1 0
/*     */     //   78: invokeinterface 287 1 0
/*     */     //   83: astore 10
/*     */     //   85: goto +30 -> 115
/*     */     //   88: aload 10
/*     */     //   90: invokeinterface 293 1 0
/*     */     //   95: checkcast 120	java/lang/String
/*     */     //   98: astore 9
/*     */     //   100: aload 8
/*     */     //   102: aload 9
/*     */     //   104: aload_2
/*     */     //   105: aload 9
/*     */     //   107: invokeinterface 299 2 0
/*     */     //   112: invokevirtual 303	com/fasterxml/jackson/core/JsonGenerator:writeObjectField	(Ljava/lang/String;Ljava/lang/Object;)V
/*     */     //   115: aload 10
/*     */     //   117: invokeinterface 307 1 0
/*     */     //   122: ifne -34 -> 88
/*     */     //   125: aload 8
/*     */     //   127: invokevirtual 311	com/fasterxml/jackson/core/JsonGenerator:writeEndObject	()V
/*     */     //   130: aload 8
/*     */     //   132: invokevirtual 314	com/fasterxml/jackson/core/JsonGenerator:close	()V
/*     */     //   135: aload 7
/*     */     //   137: ldc_w 315
/*     */     //   140: invokevirtual 317	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   143: astore 6
/*     */     //   145: aload 7
/*     */     //   147: invokevirtual 320	java/io/ByteArrayOutputStream:close	()V
/*     */     //   150: goto +10 -> 160
/*     */     //   153: astore 8
/*     */     //   155: aload 8
/*     */     //   157: invokevirtual 321	java/io/IOException:printStackTrace	()V
/*     */     //   160: aload 5
/*     */     //   162: new 326	org/apache/http/entity/StringEntity
/*     */     //   165: dup
/*     */     //   166: aload 6
/*     */     //   168: ldc -86
/*     */     //   170: invokespecial 328	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;Ljava/lang/String;)V
/*     */     //   173: invokevirtual 144	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
/*     */     //   176: new 331	com/haut/grm/util/MeasureWebServiceUtil$2
/*     */     //   179: dup
/*     */     //   180: invokespecial 333	com/haut/grm/util/MeasureWebServiceUtil$2:<init>	()V
/*     */     //   183: astore 6
/*     */     //   185: aload 4
/*     */     //   187: aload 5
/*     */     //   189: aload 6
/*     */     //   191: invokevirtual 151	org/apache/http/impl/client/CloseableHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
/*     */     //   194: checkcast 120	java/lang/String
/*     */     //   197: astore 7
/*     */     //   199: invokestatic 156	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
/*     */     //   202: astore 8
/*     */     //   204: aload 8
/*     */     //   206: invokevirtual 162	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
/*     */     //   209: astore 9
/*     */     //   211: aload 9
/*     */     //   213: new 166	org/xml/sax/InputSource
/*     */     //   216: dup
/*     */     //   217: new 168	java/io/ByteArrayInputStream
/*     */     //   220: dup
/*     */     //   221: aload 7
/*     */     //   223: ldc -86
/*     */     //   225: invokevirtual 172	java/lang/String:getBytes	(Ljava/lang/String;)[B
/*     */     //   228: invokespecial 176	java/io/ByteArrayInputStream:<init>	([B)V
/*     */     //   231: invokespecial 179	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
/*     */     //   234: invokevirtual 182	javax/xml/parsers/DocumentBuilder:parse	(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;
/*     */     //   237: astore 10
/*     */     //   239: aload 10
/*     */     //   241: ldc -68
/*     */     //   243: invokeinterface 190 2 0
/*     */     //   248: iconst_0
/*     */     //   249: invokeinterface 196 2 0
/*     */     //   254: invokeinterface 202 1 0
/*     */     //   259: invokeinterface 208 1 0
/*     */     //   264: astore_3
/*     */     //   265: goto +13 -> 278
/*     */     //   268: astore 11
/*     */     //   270: aload 4
/*     */     //   272: invokevirtual 211	org/apache/http/impl/client/CloseableHttpClient:close	()V
/*     */     //   275: aload 11
/*     */     //   277: athrow
/*     */     //   278: aload 4
/*     */     //   280: invokevirtual 211	org/apache/http/impl/client/CloseableHttpClient:close	()V
/*     */     //   283: aload_3
/*     */     //   284: areturn
/*     */     // Line number table:
/*     */     //   Java source line #120	-> byte code offset #0
/*     */     //   Java source line #121	-> byte code offset #2
/*     */     //   Java source line #124	-> byte code offset #7
/*     */     //   Java source line #126	-> byte code offset #34
/*     */     //   Java source line #128	-> byte code offset #38
/*     */     //   Java source line #129	-> byte code offset #41
/*     */     //   Java source line #131	-> byte code offset #50
/*     */     //   Java source line #132	-> byte code offset #67
/*     */     //   Java source line #133	-> byte code offset #72
/*     */     //   Java source line #134	-> byte code offset #100
/*     */     //   Java source line #133	-> byte code offset #115
/*     */     //   Java source line #136	-> byte code offset #125
/*     */     //   Java source line #137	-> byte code offset #130
/*     */     //   Java source line #138	-> byte code offset #135
/*     */     //   Java source line #139	-> byte code offset #145
/*     */     //   Java source line #140	-> byte code offset #150
/*     */     //   Java source line #141	-> byte code offset #155
/*     */     //   Java source line #143	-> byte code offset #160
/*     */     //   Java source line #146	-> byte code offset #176
/*     */     //   Java source line #161	-> byte code offset #185
/*     */     //   Java source line #162	-> byte code offset #199
/*     */     //   Java source line #163	-> byte code offset #204
/*     */     //   Java source line #164	-> byte code offset #211
/*     */     //   Java source line #165	-> byte code offset #239
/*     */     //   Java source line #167	-> byte code offset #265
/*     */     //   Java source line #168	-> byte code offset #270
/*     */     //   Java source line #169	-> byte code offset #275
/*     */     //   Java source line #168	-> byte code offset #278
/*     */     //   Java source line #170	-> byte code offset #283
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	285	0	rootUrl	String
/*     */     //   0	285	1	action	String
/*     */     //   0	285	2	jsonParams	Map<String, Object>
/*     */     //   1	283	3	responseBody	String
/*     */     //   5	274	4	httpclient	org.apache.http.impl.client.CloseableHttpClient
/*     */     //   32	156	5	post	org.apache.http.client.methods.HttpPost
/*     */     //   39	128	6	content	String
/*     */     //   183	7	6	responseHandler	ResponseHandler<String>
/*     */     //   48	98	7	out	java.io.ByteArrayOutputStream
/*     */     //   197	25	7	content	String
/*     */     //   65	66	8	jsonGenerator	com.fasterxml.jackson.core.JsonGenerator
/*     */     //   153	3	8	e	IOException
/*     */     //   202	3	8	factory	javax.xml.parsers.DocumentBuilderFactory
/*     */     //   98	8	9	jsonParam	String
/*     */     //   209	3	9	builder	javax.xml.parsers.DocumentBuilder
/*     */     //   83	33	10	localIterator	java.util.Iterator
/*     */     //   237	3	10	doc	org.w3c.dom.Document
/*     */     //   268	8	11	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   50	150	153	java/io/IOException
/*     */     //   7	268	268	finally
/*     */   }
/*     */   
/*     */   public static void executeStartMeasureNewAction(String rootUrl, final List<NameValuePair> urlParameters, Boolean debug)
/*     */     throws Exception
/*     */   {
///* 175 */     if (debug.booleanValue()) {
///* 176 */       return;
///*     */     }
///*     */     
///* 179 */     Callable<String> call = new Callable() {
///*     */       public String call() throws Exception {
///* 181 */         String responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, "startMeasure", urlParameters);
///* 182 */         while ((!responseBody.startsWith("suc_")) && (!responseBody.startsWith("unsuc_startmeasure_shebeibusy"))) {
///* 183 */           responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, "startMeasure", urlParameters);
///* 184 */           Thread.sleep(1000L);
///*     */         }
///* 186 */         return responseBody;
///*     */       }
///*     */       
///* 189 */     };
///* 190 */     FutureTask<String> future = new FutureTask(call);
///* 191 */     GlobalHandler.getScheduler().execute(future);
///* 192 */     future.get(20L, TimeUnit.SECONDS);
/*     */   }
/*     */   
/*     */   public static void executeStartMeasureNewFullAction(String rootUrl, final List<NameValuePair> urlParameters, Boolean debug) throws Exception
/*     */   {
///* 197 */     if (debug.booleanValue()) {
///* 198 */       return;
///*     */     }
///*     */     
///* 201 */     Callable<String> call = new Callable() {
///*     */       public String call() throws Exception {
///* 203 */         String responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, "startFullMeasure", urlParameters);
///* 204 */         while ((!responseBody.startsWith("suc_")) && (!responseBody.startsWith("unsuc_startmeasure_shebeibusy"))) {
///* 205 */           responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, "startFullMeasure", urlParameters);
///* 206 */           Thread.sleep(1000L);
///*     */         }
///* 208 */         return responseBody;
///*     */       }
///*     */       
///* 211 */     };
///* 212 */     FutureTask<String> future = new FutureTask(call);
///* 213 */     GlobalHandler.getScheduler().execute(future);
///* 214 */     future.get(20L, TimeUnit.SECONDS);
/*     */   }
/*     */   
/*     */   public static void executeStartMeasureAction(String rootUrl, final List<NameValuePair> urlParameters, Boolean debug) throws Exception
/*     */   {
///* 219 */     if (debug.booleanValue()) {
///* 220 */       return;
///*     */     }
///*     */     
///* 223 */     Callable<String> call = new Callable() {
///*     */       public String call() throws Exception {
///* 225 */         String responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, "startScan", urlParameters);
///* 226 */         while ((!responseBody.startsWith("suc_")) && (!responseBody.startsWith("unsuc_startScan_dev_on"))) {
///* 227 */           responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, "startScan", urlParameters);
///* 228 */           Thread.sleep(1000L);
///*     */         }
///* 230 */         return responseBody;
///*     */       }
///*     */       
///* 233 */     };
///* 234 */     FutureTask<String> future = new FutureTask(call);
///* 235 */     GlobalHandler.getScheduler().execute(future);
///* 236 */     future.get(20L, TimeUnit.SECONDS);
/*     */   }
/*     */   
/*     */   public static void executeSetBaseDataAction(String rootUrl, final List<NameValuePair> urlParameters) throws Exception
/*     */   {
///* 241 */     Callable<String> call = new Callable() {
///*     */       public String call() throws Exception {
///* 243 */         String responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, "setBaseDATA", urlParameters);
///* 244 */         while (!responseBody.startsWith("suc")) {
///* 245 */           responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, "setBaseDATA", urlParameters);
///* 246 */           Thread.sleep(1000L);
///*     */         }
///* 248 */         return responseBody;
///*     */       }
///*     */       
///* 251 */     };
///* 252 */     FutureTask<String> future = new FutureTask(call);
///* 253 */     GlobalHandler.getScheduler().execute(future);
///* 254 */     future.get(20L, TimeUnit.SECONDS);
/*     */   }
/*     */   
/*     */   public static Pair<Integer, Integer> executeStatusAction(String rootUrl, final List<NameValuePair> urlParameters, Boolean debug, boolean isFull) throws TimeoutException, InterruptedException, ExecutionException, CoreResponseParseException
/*     */   {
///* 259 */     if (debug.booleanValue()) {
///* 260 */       DEBUG_COUNTER += 50;
///* 261 */       return new Pair(Integer.valueOf(DEBUG_COUNTER), Integer.valueOf(2000));
///*     */     }
///*     */     
///* 264 */     Pair<Integer, Integer> result = new Pair(Integer.valueOf(0), Integer.valueOf(0));
///* 265 */     final String action = isFull ? "getMeasureFullStatus" : "getMeasureStatus";
///* 266 */     Callable<String> call = new Callable() {
///*     */       public String call() throws Exception {
///* 268 */         String responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, action, urlParameters);
///* 269 */         while (!responseBody.startsWith("suc_")) {
///* 270 */           responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, action, urlParameters);
///* 271 */           Thread.sleep(1000L);
///*     */         }
///* 273 */         return responseBody;
///*     */       }
///*     */       
///* 276 */     };
///* 277 */     FutureTask<String> future = new FutureTask(call);
///* 278 */     GlobalHandler.getScheduler().execute(future);
///* 279 */     String responseBody = (String)future.get(3L, TimeUnit.MINUTES);
///*     */     
///* 281 */     Pattern p = Pattern.compile("^[a-zA-Z_]+([0-9]+),([0-9]+)$");
///* 282 */     Matcher m = p.matcher(responseBody);
///*     */     
///* 284 */     if (m.find()) {
///* 285 */       result = new Pair(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(2)));
///*     */     }
///*     */     else {
///* 288 */       throw new CoreResponseParseException("获取状态信息错误");
///*     */     }
///*     */     
///* 291 */     return result;
				return null;
/*     */   }
/*     */   
/*     */   public static EntryMeasure executeWeightAction(String rootUrl, final List<NameValuePair> urlParameters, Boolean debug, Boolean newVersion, boolean isFull) throws InterruptedException, ExecutionException, TimeoutException, CoreResponseParseException
/*     */   {
///* 296 */     if (debug.booleanValue()) {
///* 297 */       DEBUG_COUNTER = 0;
///* 298 */       EntryMeasure result = new EntryMeasure();
///* 299 */       result.setVolume(Double.valueOf(2000.0D));
///* 300 */       return result;
///*     */     }
///*     */     
///* 303 */     EntryMeasure result = new EntryMeasure();
///* 304 */     final String action = newVersion.booleanValue() ? "getMeasureWeight" : isFull ? "getMeasureFullWeight" : "getScanWeight";
///* 305 */     Callable<String> call = new Callable() {
///*     */       public String call() throws Exception {
///* 307 */         String responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, action, urlParameters);
///* 308 */         while (!responseBody.startsWith("suc_")) {
///* 309 */           responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, action, urlParameters);
///* 310 */           Thread.sleep(1000L);
///*     */         }
///* 312 */         return responseBody;
///*     */       }
///*     */       
///* 315 */     };
///* 316 */     FutureTask<String> future = new FutureTask(call);
///* 317 */     GlobalHandler.getScheduler().execute(future);
///* 318 */     String responseBody = (String)future.get(10L, TimeUnit.MINUTES);
///*     */     
///* 320 */     Pattern p = Pattern.compile("^[a-zA-Z_]+([-+]?[0-9]*\\.?[0-9]+)$");
///* 321 */     Matcher m = p.matcher(responseBody);
///*     */     
///* 323 */     if (m.find()) {
///* 324 */       System.out.println("获取计算体积原始返回：" + responseBody);
///* 325 */       System.out.println("获取计算体积值：" + Double.parseDouble(m.group(1)));
///* 326 */       result.setVolume(Double.valueOf(m.group(1)));
///*     */     }
///*     */     else {
///* 329 */       throw new CoreResponseParseException("获取计算重量错误");
///*     */     }
///*     */     
///* 332 */     return result;
				return null;
/*     */   }
/*     */   
/*     */   public static String executeDataAction(String rootUrl, final List<NameValuePair> urlParameters, Boolean debug, boolean isFull) throws InterruptedException, ExecutionException, TimeoutException {
///* 336 */     if (debug.booleanValue()) {
///* 337 */       return "DEBUG_DATA";
///*     */     }
///*     */     
///* 340 */     final String action = isFull ? "getScanFullResult" : "getScanResult";
///* 341 */     Callable<String> call = new Callable() {
///*     */       public String call() throws Exception {
///* 343 */         String responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, action, urlParameters);
///* 344 */         while (!responseBody.startsWith("suc_")) {
///* 345 */           responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, action, urlParameters);
///* 346 */           Thread.sleep(1000L);
///*     */         }
///* 348 */         return responseBody;
///*     */       }
///*     */       
///* 351 */     };
///* 352 */     FutureTask<String> future = new FutureTask(call);
///* 353 */     GlobalHandler.getScheduler().execute(future);
///* 354 */     return (String)future.get(30L, TimeUnit.MINUTES);
				return null;
/*     */   }
/*     */   
/*     */   public static void executeStopMeasureAction(String rootUrl, final List<NameValuePair> urlParameters, Boolean debug) throws Exception
/*     */   {
///* 359 */     if (debug.booleanValue()) {
///* 360 */       return;
///*     */     }
///*     */     
///* 363 */     Callable<String> call = new Callable() {
///*     */       public String call() throws Exception {
///* 365 */         String responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, "SysReset", urlParameters);
///* 366 */         while (!responseBody.startsWith("suc_")) {
///* 367 */           responseBody = MeasureWebServiceUtil.execute(MeasureWebServiceUtil.this, "SysReset", urlParameters);
///* 368 */           Thread.sleep(1000L);
///*     */         }
///* 370 */         return responseBody;
///*     */       }
///*     */       
///* 373 */     };
///* 374 */     FutureTask<String> future = new FutureTask(call);
///* 375 */     GlobalHandler.getScheduler().execute(future);
///* 376 */     future.get(20L, TimeUnit.SECONDS);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\MeasureWebServiceUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */