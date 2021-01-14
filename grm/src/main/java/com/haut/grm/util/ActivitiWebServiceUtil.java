/*    */ package com.haut.grm.util;
/*    */ 
/*    */ import com.fasterxml.jackson.databind.JsonNode;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import com.fasterxml.jackson.databind.node.ObjectNode;
/*    */ import java.io.IOException;
/*    */ import java.lang.management.ManagementFactory;
/*    */ import java.net.InetAddress;
/*    */ import java.net.UnknownHostException;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import javax.management.MBeanServer;
/*    */ import javax.management.MalformedObjectNameException;
/*    */ import javax.management.ObjectName;
/*    */ import javax.management.Query;
/*    */ import org.apache.http.HttpHost;
/*    */ import org.apache.http.client.methods.HttpGet;
/*    */ import org.apache.http.client.methods.HttpPost;
/*    */ import org.apache.http.entity.ContentType;
/*    */ import org.apache.http.entity.StringEntity;
/*    */ import org.apache.http.impl.client.CloseableHttpClient;
/*    */ import org.apache.http.impl.client.HttpClientBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActivitiWebServiceUtil
/*    */ {
/*    */   private static final String AUTH_STRING = "Basic YWRtaW5fdG95bGE6NTM1NjI5NTE0MQ==";
/*    */   
		   
/*    */   public static void saveData(String url, String content)
/*    */     throws Exception
/*    */   {
	System.out.println("开始保存数据");
/* 33 */     CloseableHttpClient client = HttpClientBuilder.create().build();
/* 34 */     String _url = url.replaceAll("^http.*/", getCurrentHost().toURI() + "/grm/api/");
/* 35 */     HttpPost post = new HttpPost(_url);
/* 36 */     post.setHeader("Content-type", "application/json");
/* 37 */     post.setEntity(new StringEntity(replaceJsonUri(content), ContentType.APPLICATION_JSON));
/*    */     
/* 39 */     post.setHeader("Authorization", "Basic YWRtaW5fdG95bGE6NTM1NjI5NTE0MQ==");
/* 40 */     client.execute(post);
System.out.println("execute:结束");
/*    */   }
/*    */   
/*    */   public static void createData(String businessKey) throws Exception {
/* 44 */     CloseableHttpClient client = HttpClientBuilder.create().build();
/* 45 */     HttpGet post = new HttpGet(getCurrentHost().toURI() + "/grm/api/create_sc/" + businessKey);
/* 46 */     post.setHeader("Authorization", "Basic YWRtaW5fdG95bGE6NTM1NjI5NTE0MQ==");
/* 47 */     client.execute(post);
/*    */   }
/*    */   
/*    */   public static HttpHost getCurrentHost() throws MalformedObjectNameException, NullPointerException, UnknownHostException
/*    */   {
/* 52 */     MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
/* 53 */     Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"), 
/* 54 */       Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
/* 55 */     String host = InetAddress.getLocalHost().getHostAddress();
/* 56 */     String port = ((ObjectName)objectNames.iterator().next()).getKeyProperty("port");
/* 57 */     return new HttpHost(host, Integer.valueOf(port).intValue(), "http");
/*    */   }
/*    */   
/*    */   public static String replaceJsonUri(String content) throws IOException {
/* 61 */     ObjectMapper mapper = new ObjectMapper();
/* 62 */     JsonNode dataNode = mapper.readTree(content);
/* 63 */     ObjectNode objectNode = (ObjectNode)dataNode;
/* 64 */     Iterator<String> it = dataNode.fieldNames();
/* 65 */     while (it.hasNext()) {
/* 66 */       String fieldname = (String)it.next();
/* 67 */       JsonNode paramNode = dataNode.get(fieldname);
/* 68 */       if (paramNode.isTextual()) {
/* 69 */         String value = paramNode.textValue();
//System.out.println("fieldname:"+fieldname+","+value);
/* 70 */         objectNode.put(fieldname, value.replaceAll("^http.*/", "http://0.0.0.0/"));
/*    */       }
/*    */     }
/* 73 */     return objectNode.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\ActivitiWebServiceUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */