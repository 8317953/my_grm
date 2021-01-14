/*    */ package com.haut.grm.model.system;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.SystemlogView;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import com.haut.grm.model.meta.User;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ import javax.persistence.Temporal;
/*    */ import javax.persistence.TemporalType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="system_log")
/*    */ public class SystemLog
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -1990241301395353063L;
/*    */   public static final String SYSTEM_TYPE = "系统生成";
/*    */   public static final String CREATE_TYPE = "创建";
/*    */   public static final String UPDATE_TYPE = "修改";
/*    */   public static final String DELETE_TYPE = "删除";
/*    */   public static final String NOTIFY_TYPE = "通知";
/*    */   @Column(name="content")
/*    */   @JsonView({Views.SystemlogView.class})
/*    */   private String content;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="user_id")
/*    */   @JsonView({Views.SystemlogView.class})
/*    */   private User user;
/*    */   @Column(name="time")
/*    */   @JsonView({Views.SystemlogView.class})
/*    */   @Temporal(TemporalType.TIMESTAMP)
/*    */   private Date time;
/*    */   @Column(name="type")
/*    */   @JsonView({Views.SystemlogView.class})
/*    */   private String type;
/*    */   
/*    */   public String getType()
/*    */   {
/* 49 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 53 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getContent() {
/* 57 */     return this.content;
/*    */   }
/*    */   
/*    */   public void setContent(String content) {
/* 61 */     this.content = content;
/*    */   }
/*    */   
/*    */   public User getUser() {
/* 65 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setUser(User user) {
/* 69 */     this.user = user;
/*    */   }
/*    */   
/*    */   public Date getTime() {
/* 73 */     return this.time;
/*    */   }
/*    */   
/*    */   public void setTime(Date time) {
/* 77 */     this.time = time;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\system\SystemLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */