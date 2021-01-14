/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.BusinessNotificationView;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import com.haut.grm.model.meta.ActivitiGroup;
/*    */ import com.haut.grm.model.meta.User;

import io.swagger.annotations.ApiModelProperty;

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
/*    */ @Table(name="gb_notification")
/*    */ public class BusinessNotification
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 6046747997206091088L;
/*    */   @Column(name="title")
/*    */   @JsonView({Views.BusinessNotificationView.class})
/*    */   private String title;
/*    */   @Column(name="content")
/*    */   @JsonView({Views.BusinessNotificationView.class})
/*    */   private String content;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="group_id")
/*    */   @JsonView({Views.BusinessNotificationView.class})
@ApiModelProperty(hidden=true ,name="ActivitiGroup",value="子节点")
/*    */   private ActivitiGroup activitiGroup;



			@ApiModelProperty(hidden=true ,name="User",value="子节点")
/*    */   @ManyToOne
/*    */   @JoinColumn(name="user_id")
/*    */   @JsonView({Views.BusinessNotificationView.class})
/*    */   private User user;
/*    */   @Column(name="time")
/*    */   @JsonView({Views.BusinessNotificationView.class})
/*    */   @Temporal(TemporalType.TIMESTAMP)
/*    */   private Date time;
/*    */   
/*    */   public String getTitle()
/*    */   {
/* 49 */     return this.title;
/*    */   }
/*    */   
/*    */   public void setTitle(String title) {
/* 53 */     this.title = title;
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
/*    */   public ActivitiGroup getActivitiGroup() {
/* 65 */     return this.activitiGroup;
/*    */   }
/*    */   
/*    */   public void setActivitiGroup(ActivitiGroup activitiGroup) {
/* 69 */     this.activitiGroup = activitiGroup;
/*    */   }
/*    */   
/*    */   public User getUser() {
/* 73 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setUser(User user) {
/* 77 */     this.user = user;
/*    */   }
/*    */   
/*    */   public Date getTime() {
/* 81 */     return this.time;
/*    */   }
/*    */   
/*    */   public void setTime(Date time) {
/* 85 */     this.time = time;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\BusinessNotification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */