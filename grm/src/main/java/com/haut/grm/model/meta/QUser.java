/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.type.QDiploma;
/*    */ import com.haut.grm.model.type.QEthnicity;
/*    */ import com.haut.grm.model.type.QMajor;
/*    */ import com.haut.grm.model.type.QPoliticalStatus;
/*    */ import com.haut.grm.model.type.QProfessionalTitle;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.dsl.BooleanPath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class QUser extends EntityPathBase<User>
/*    */ {
/*    */   private static final long serialVersionUID = -734291238L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QUser user = new QUser("user");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 29 */   public final com.querydsl.core.types.dsl.DateTimePath<Date> dateOfBirth = createDateTime("dateOfBirth", Date.class);
/*    */   
/* 31 */   public final com.querydsl.core.types.dsl.DateTimePath<Date> dateOfIn = createDateTime("dateOfIn", Date.class);
/*    */   
/*    */   public final QDepartment department;
/*    */   
/*    */   public final QDiploma diploma;
/*    */   
/* 37 */   public final StringPath email = createString("email");
/*    */   
/*    */   public final QEthnicity ethnicity;
/*    */   
/* 41 */   public final StringPath gender = createString("gender");
/*    */   
/* 43 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 45 */   public final StringPath idCode = createString("idCode");
/*    */   
/* 47 */   public final BooleanPath isActive = createBoolean("isActive");
/*    */   
/* 49 */   public final BooleanPath isLocked = createBoolean("isLocked");
/*    */   
/* 51 */   public final BooleanPath isOutside = createBoolean("isOutside");
/*    */   
/* 53 */   public final BooleanPath isPasswordComplete = createBoolean("isPasswordComplete");
/*    */   
/*    */   public final QMajor major;
/*    */   
/* 57 */   public final StringPath officialName = createString("officialName");
/*    */   
/* 59 */   public final StringPath password = createString("password");
/*    */   
/*    */   public final QPoliticalStatus politicalStatus;
/*    */   
/*    */   public final QProfessionalTitle professionalTitle;
/*    */   
/* 65 */   public final com.querydsl.core.types.dsl.SetPath<Role, QRole> roles = createSet("roles", Role.class, QRole.class, PathInits.DIRECT2);
/*    */   
/* 67 */   public final StringPath telephone = createString("telephone");
/*    */   
/* 69 */   public final StringPath username = createString("username");
/*    */   
/*    */   public QUser(String variable) {
/* 72 */     this(User.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QUser(Path<? extends User> path) {
/* 76 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QUser(PathMetadata metadata) {
/* 80 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QUser(PathMetadata metadata, PathInits inits) {
/* 84 */     this(User.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
/* 88 */     super(type, metadata, inits);
/* 89 */     this.department = (inits.isInitialized("department") ? new QDepartment(forProperty("department")) : null);
/* 90 */     this.diploma = (inits.isInitialized("diploma") ? new QDiploma(forProperty("diploma")) : null);
/* 91 */     this.ethnicity = (inits.isInitialized("ethnicity") ? new QEthnicity(forProperty("ethnicity")) : null);
/* 92 */     this.major = (inits.isInitialized("major") ? new QMajor(forProperty("major")) : null);
/* 93 */     this.politicalStatus = (inits.isInitialized("politicalStatus") ? new QPoliticalStatus(forProperty("politicalStatus")) : null);
/* 94 */     this.professionalTitle = (inits.isInitialized("professionalTitle") ? new QProfessionalTitle(forProperty("professionalTitle")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\QUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */