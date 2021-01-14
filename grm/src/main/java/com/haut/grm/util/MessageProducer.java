/*     */ package com.haut.grm.util;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonEncoding;
/*     */ import com.fasterxml.jackson.core.JsonFactory;
/*     */ import com.fasterxml.jackson.core.JsonGenerator;
/*     */ import com.fasterxml.jackson.databind.MapperFeature;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import com.fasterxml.jackson.databind.SerializationConfig;
/*     */ import com.haut.grm.bean.HibernateAwareObjectMapper;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.BusinessNotificationView;
/*     */ import com.haut.grm.json.view.Views.EntryDoorWithStoreView;
/*     */ import com.haut.grm.json.view.Views.StoreView;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.business.BusinessNotification;
/*     */ import com.haut.grm.model.entry.EntryDoor;
/*     */ import com.haut.grm.model.entry.EntrySafety;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import javax.jms.JMSException;
/*     */ import javax.jms.Message;
/*     */ import javax.jms.Session;
/*     */ import javax.jms.TextMessage;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.jms.core.JmsTemplate;
/*     */ import org.springframework.jms.core.MessageCreator;
/*     */ import org.springframework.stereotype.Component;
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
/*     */ 
/*     */ @Component
/*     */ public class MessageProducer
/*     */ {
/*     */   private static final String TYPE = "type";
/*     */   private static final String MESSAGE = "message";
/*     */   private static final String STARTED_TYPE = "STARTED";
/*     */   private static final String INIT_TYPE = "initType";
/*     */   private static final String DEFAULT_INIT = "default";
/*     */   private static final String SUPER_INIT = "super";
/*     */   private static final String INTERRUPTED_TYPE = "INTERRUPTED";
/*     */   private static final String MEASURING_TYPE = "MEASURING";
/*     */   private static final String NOTIFICATION_TYPE = "NOTIFICATION";
/*     */   private static final String WEIGHT_TYPE = "WEIGHT";
/*     */   private static final String STOPPED_TYPE = "STOPPED";
/*     */   private static final String ALERT_SAFETY = "ALERT_SAFETY";
/*     */   private static final String ALERT_DOOR = "ALERT_DOOR";
/*     */   private static final String MUTE_SAFETY = "MUTE_SAFETY";
/*     */   private static final String VEHICLE_TRAFFIC = "VEHICLE_TRAFFIC";
/*     */   private static final String PLATE = "plate";
/*     */   private static final String CAMERA_NAME = "cameraName";
/*     */   private static final String IS_NEW = "isNew";
/*     */   private static final String MUTE_DOOR = "MUTE_DOOR";
/*     */   private static final String ALERT_ENTRY = "entry";
/*     */   private static final String STORE_ID = "storeId";
/*     */   private static final String PROGRESS_TOTAL = "total";
/*     */   private static final String PROGRESS_NOW = "now";
/*     */   @Autowired
/*     */   private JmsTemplate template;
/*     */   
/*     */   public synchronized void generateStartMessage(final Store store, final boolean isDefaultInit)
/*     */     throws JMSException, InterruptedException
/*     */   {
/*  80 */     this.template.send(new MessageCreator() {
/*     */       public Message createMessage(Session session) throws JMSException {
/*  82 */         String content = null;
/*  83 */         ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */         try {
/*  85 */           JsonGenerator jsonGenerator = new JsonFactory().createGenerator(out, JsonEncoding.UTF8);
/*  86 */           jsonGenerator.writeStartObject();
/*  87 */           jsonGenerator.writeStringField("type", "STARTED");
/*  88 */           jsonGenerator.writeStringField("initType", isDefaultInit ? "default" : "super");
/*  89 */           jsonGenerator.writeNumberField("storeId", ((Long)store.getId()).longValue());
/*  90 */           jsonGenerator.writeEndObject();
/*  91 */           jsonGenerator.close();
/*  92 */           content = out.toString("UTF-8");
/*  93 */           out.close();
/*     */         } catch (IOException e) {
/*  95 */           e.printStackTrace();
/*     */         }
/*  97 */         TextMessage message = session.createTextMessage(content);
/*     */         
/*  99 */         return message;
/*     */       }
/* 101 */     });
/* 102 */     Thread.sleep(500L);
/*     */   }
/*     */   
/*     */   public void generateProgressMessage(final Store store, final Pair<Integer, Integer> progress, final boolean isDefaultInit) throws JMSException {
/* 106 */     this.template.send(new MessageCreator() {
/*     */       public Message createMessage(Session session) throws JMSException {
/* 108 */         String content = null;
/* 109 */         ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */         try {
/* 111 */           JsonGenerator jsonGenerator = new JsonFactory().createGenerator(out, JsonEncoding.UTF8);
/* 112 */           jsonGenerator.writeStartObject();
/* 113 */           jsonGenerator.writeStringField("type", "MEASURING");
/* 114 */           jsonGenerator.writeStringField("initType", isDefaultInit ? "default" : "super");
/* 115 */           jsonGenerator.writeNumberField("storeId", ((Long)store.getId()).longValue());
/* 116 */           jsonGenerator.writeStringField("now", ((Integer)progress.getFirst()).toString());
/* 117 */           jsonGenerator.writeStringField("total", ((Integer)progress.getSecond()).toString());
/* 118 */           jsonGenerator.writeEndObject();
/* 119 */           jsonGenerator.close();
/* 120 */           content = out.toString("UTF-8");
/* 121 */           out.close();
/*     */         } catch (IOException e) {
/* 123 */           e.printStackTrace();
/*     */         }
/* 125 */         TextMessage message = session.createTextMessage(content);
/*     */         
/* 127 */         return message;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void generateStopMessage(final Store store) throws JMSException {
/* 133 */     this.template.send(new MessageCreator() {
/*     */       public Message createMessage(Session session) throws JMSException {
/* 135 */         String content = null;
/* 136 */         ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */         try {
/* 138 */           JsonGenerator jsonGenerator = new JsonFactory().createGenerator(out, JsonEncoding.UTF8);
/* 139 */           jsonGenerator.writeStartObject();
/* 140 */           jsonGenerator.writeStringField("type", "STOPPED");
/* 141 */           jsonGenerator.writeNumberField("storeId", ((Long)store.getId()).longValue());
/* 142 */           jsonGenerator.writeEndObject();
/* 143 */           jsonGenerator.close();
/* 144 */           content = out.toString("UTF-8");
/* 145 */           out.close();
/*     */         } catch (IOException e) {
/* 147 */           e.printStackTrace();
/*     */         }
/* 149 */         TextMessage message = session.createTextMessage(content);
/*     */         
/* 151 */         return message;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void generateWeightMessage(final Store store, final boolean isDefaultInit) throws JMSException {
/* 157 */     this.template.send(new MessageCreator() {
/*     */       public Message createMessage(Session session) throws JMSException {
/* 159 */         String content = null;
/* 160 */         ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */         try {
/* 162 */           JsonGenerator jsonGenerator = new JsonFactory().createGenerator(out, JsonEncoding.UTF8);
/* 163 */           jsonGenerator.writeStartObject();
/* 164 */           jsonGenerator.writeStringField("type", "WEIGHT");
/* 165 */           jsonGenerator.writeStringField("initType", isDefaultInit ? "default" : "super");
/* 166 */           jsonGenerator.writeNumberField("storeId", ((Long)store.getId()).longValue());
/* 167 */           jsonGenerator.writeEndObject();
/* 168 */           jsonGenerator.close();
/* 169 */           content = out.toString("UTF-8");
/* 170 */           out.close();
/*     */         } catch (IOException e) {
/* 172 */           e.printStackTrace();
/*     */         }
/* 174 */         TextMessage message = session.createTextMessage(content);
/*     */         
/* 176 */         return message;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void generateSafetyMessage(final EntrySafety entrySafety) throws JMSException {
/* 182 */     this.template.send(new MessageCreator() {
/*     */       public Message createMessage(Session session) throws JMSException {
/* 184 */         String content = null;
/* 185 */         ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */         try {
/* 187 */           ObjectMapper mapper = new HibernateAwareObjectMapper();
/* 188 */           JsonFactory jsonFactory = new JsonFactory();
/* 189 */           jsonFactory.setCodec(mapper);
/* 190 */           JsonGenerator jsonGenerator = jsonFactory.createGenerator(out, JsonEncoding.UTF8);
/* 191 */           jsonGenerator.writeStartObject();
/* 192 */           jsonGenerator.writeStringField("type", "ALERT_SAFETY");
/* 193 */           jsonGenerator.writeObjectField("entry", entrySafety);
/* 194 */           jsonGenerator.writeNumberField("storeId", ((Long)entrySafety.getStore().getId()).longValue());
/* 195 */           jsonGenerator.writeEndObject();
/* 196 */           jsonGenerator.close();
/* 197 */           content = out.toString("UTF-8");
/* 198 */           out.close();
/*     */         } catch (IOException e) {
/* 200 */           e.printStackTrace();
/*     */         }
/* 202 */         TextMessage message = session.createTextMessage(content);
/*     */         
/* 204 */         return message;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void generateDoorMessage(final EntryDoor entryDoor) throws JMSException {
/* 210 */     this.template.send(new MessageCreator() {
/*     */       public Message createMessage(Session session) throws JMSException {
/* 212 */         String content = null;
/* 213 */         ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */         try {
/* 215 */           ObjectMapper mapper = new ObjectMapper();
/* 216 */           mapper.disable(new MapperFeature[] { MapperFeature.DEFAULT_VIEW_INCLUSION });
/* 217 */           mapper.setConfig(mapper.getSerializationConfig().withView(Views.EntryDoorWithStoreView.class));
/* 218 */           JsonFactory jsonFactory = new JsonFactory();
/* 219 */           jsonFactory.setCodec(mapper);
/* 220 */           JsonGenerator jsonGenerator = jsonFactory.createGenerator(out, JsonEncoding.UTF8);
/* 221 */           jsonGenerator.writeStartObject();
/* 222 */           jsonGenerator.writeStringField("type", "ALERT_DOOR");
/* 223 */           jsonGenerator.writeObjectField("entry", entryDoor);
/* 224 */           jsonGenerator.writeNumberField("storeId", ((Long)entryDoor.getStore().getId()).longValue());
/* 225 */           jsonGenerator.writeEndObject();
/* 226 */           jsonGenerator.close();
/* 227 */           content = out.toString("UTF-8");
/* 228 */           out.close();
/*     */         } catch (IOException e) {
/* 230 */           e.printStackTrace();
/*     */         }
/* 232 */         TextMessage message = session.createTextMessage(content);
/*     */         
/* 234 */         return message;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void generateMuteSafetyMessage(final Store store) throws JMSException {
/* 240 */     this.template.send(new MessageCreator() {
/*     */       public Message createMessage(Session session) throws JMSException {
/* 242 */         String content = null;
/* 243 */         ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */         try {
/* 245 */           ObjectMapper mapper = new ObjectMapper();
/* 246 */           mapper.disable(new MapperFeature[] { MapperFeature.DEFAULT_VIEW_INCLUSION });
/* 247 */           mapper.setConfig(mapper.getSerializationConfig().withView(Views.StoreView.class));
/* 248 */           JsonFactory jsonFactory = new JsonFactory();
/* 249 */           jsonFactory.setCodec(mapper);
/* 250 */           JsonGenerator jsonGenerator = jsonFactory.createGenerator(out, JsonEncoding.UTF8);
/* 251 */           jsonGenerator.writeStartObject();
/* 252 */           jsonGenerator.writeStringField("type", "MUTE_SAFETY");
/* 253 */           jsonGenerator.writeObjectField("entry", store);
/* 254 */           jsonGenerator.writeNumberField("storeId", ((Long)store.getId()).longValue());
/* 255 */           jsonGenerator.writeEndObject();
/* 256 */           jsonGenerator.close();
/* 257 */           content = out.toString("UTF-8");
/* 258 */           out.close();
/*     */         } catch (IOException e) {
/* 260 */           e.printStackTrace();
/*     */         }
/* 262 */         TextMessage message = session.createTextMessage(content);
/*     */         
/* 264 */         return message;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void generateMuteDoorMessage(final EntryDoor entryDoor) throws JMSException
/*     */   {
/* 271 */     this.template.send(new MessageCreator() {
/*     */       public Message createMessage(Session session) throws JMSException {
/* 273 */         String content = null;
/* 274 */         ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */         try {
/* 276 */           ObjectMapper mapper = new ObjectMapper();
/* 277 */           mapper.disable(new MapperFeature[] { MapperFeature.DEFAULT_VIEW_INCLUSION });
/* 278 */           mapper.setConfig(mapper.getSerializationConfig().withView(Views.EntryDoorWithStoreView.class));
/* 279 */           JsonFactory jsonFactory = new JsonFactory();
/* 280 */           jsonFactory.setCodec(mapper);
/* 281 */           JsonGenerator jsonGenerator = jsonFactory.createGenerator(out, JsonEncoding.UTF8);
/* 282 */           jsonGenerator.writeStartObject();
/* 283 */           jsonGenerator.writeStringField("type", "MUTE_DOOR");
/* 284 */           jsonGenerator.writeObjectField("entry", entryDoor);
/* 285 */           jsonGenerator.writeNumberField("storeId", ((Long)entryDoor.getStore().getId()).longValue());
/* 286 */           jsonGenerator.writeEndObject();
/* 287 */           jsonGenerator.close();
/* 288 */           content = out.toString("UTF-8");
/* 289 */           out.close();
/*     */         } catch (IOException e) {
/* 291 */           e.printStackTrace();
/*     */         }
/* 293 */         TextMessage message = session.createTextMessage(content);
/*     */         
/* 295 */         return message;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void generateInterruptMessage(final Store store, final String message) throws JMSException
/*     */   {
/* 302 */     this.template.send(new MessageCreator() {
/*     */       public Message createMessage(Session session) throws JMSException {
/* 304 */         String content = null;
/* 305 */         ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */         try {
/* 307 */           JsonGenerator jsonGenerator = new JsonFactory().createGenerator(out, JsonEncoding.UTF8);
/* 308 */           jsonGenerator.writeStartObject();
/* 309 */           jsonGenerator.writeStringField("type", "INTERRUPTED");
/* 310 */           jsonGenerator.writeNumberField("storeId", ((Long)store.getId()).longValue());
/* 311 */           jsonGenerator.writeStringField("message", message);
/* 312 */           jsonGenerator.writeEndObject();
/* 313 */           jsonGenerator.close();
/* 314 */           content = out.toString("UTF-8");
/* 315 */           out.close();
/*     */         } catch (IOException e) {
/* 317 */           e.printStackTrace();
/*     */         }
/* 319 */         TextMessage message = session.createTextMessage(content);
/*     */         
/* 321 */         return message;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void generateVehicleMessage(final String plate, final String cameraName, final boolean isNew) throws JMSException
/*     */   {
/* 328 */     this.template.send(new MessageCreator() {
/*     */       public Message createMessage(Session session) throws JMSException {
/* 330 */         String content = null;
/* 331 */         ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */         try {
/* 333 */           JsonGenerator jsonGenerator = new JsonFactory().createGenerator(out, JsonEncoding.UTF8);
/* 334 */           jsonGenerator.writeStartObject();
/* 335 */           jsonGenerator.writeStringField("type", "VEHICLE_TRAFFIC");
/* 336 */           jsonGenerator.writeStringField("plate", plate);
/* 337 */           jsonGenerator.writeStringField("cameraName", cameraName);
/* 338 */           jsonGenerator.writeBooleanField("isNew", isNew);
/* 339 */           jsonGenerator.writeEndObject();
/* 340 */           jsonGenerator.close();
/* 341 */           content = out.toString("UTF-8");
/* 342 */           out.close();
/*     */         } catch (IOException e) {
/* 344 */           e.printStackTrace();
/*     */         }
/* 346 */         TextMessage message = session.createTextMessage(content);
/*     */         
/* 348 */         return message;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void generateNotificationMessage(final BusinessNotification notif) throws JMSException {
/* 354 */     this.template.send(new MessageCreator() {
/*     */       public Message createMessage(Session session) throws JMSException {
/* 356 */         String content = null;
/* 357 */         ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */         try {
/* 359 */           ObjectMapper mapper = new ObjectMapper();
/* 360 */           mapper.disable(new MapperFeature[] { MapperFeature.DEFAULT_VIEW_INCLUSION });
/* 361 */           mapper.setConfig(mapper.getSerializationConfig().withView(Views.BusinessNotificationView.class));
/* 362 */           JsonFactory jsonFactory = new JsonFactory();
/* 363 */           jsonFactory.setCodec(mapper);
/* 364 */           JsonGenerator jsonGenerator = jsonFactory.createGenerator(out, JsonEncoding.UTF8);
/* 365 */           jsonGenerator.writeStartObject();
/* 366 */           jsonGenerator.writeStringField("type", "NOTIFICATION");
/* 367 */           jsonGenerator.writeObjectField("NOTIFICATION", notif);
/* 368 */           jsonGenerator.writeEndObject();
/* 369 */           jsonGenerator.close();
/* 370 */           content = out.toString("UTF-8");
/* 371 */           out.close();
/*     */         } catch (IOException e) {
/* 373 */           e.printStackTrace();
/*     */         }
/* 375 */         TextMessage message = session.createTextMessage(content);
/*     */         
/* 377 */         return message;
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\gr\\util\MessageProducer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */