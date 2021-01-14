/*     */ package com.haut.grm.model.meta;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.IdView;
/*     */ import com.haut.grm.json.view.Views.UserRefRoleView;
/*     */ import com.haut.grm.json.view.Views.UserView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.type.Diploma;
/*     */ import com.haut.grm.model.type.Ethnicity;
/*     */ import com.haut.grm.model.type.Major;
/*     */ import com.haut.grm.model.type.PoliticalStatus;
/*     */ import com.haut.grm.model.type.ProfessionalTitle;
/*     */ import java.util.Date;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="meta_user")
/*     */ public class User
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = -8641052219300253616L;
/*     */   public static final String INITIAL_PASSWORD = "$2a$10$jHKVzfkH6QM0eFL0VshhuuCuEHokPiU/lFrNW0SPFZVKM309MHKZ2";
/*     */   @Column(name="code_id")
/*     */   @JsonView({Views.UserView.class})
/*     */   private Integer codeId;
/*     */   @Column(name="username")
/*     */   @JsonView({Views.IdView.class})
/*     */   private String username;
/*     */   @Column(name="official_name")
/*     */   @JsonView({Views.UserView.class})
/*     */   private String officialName;
/*     */   @Column(name="password")
/*     */   @JsonIgnore
/*  47 */   private String password = INITIAL_PASSWORD;//原来这里才是默认密码的设置
/*     */   
/*     */   @Column(name="telephone")
/*     */   @JsonView({Views.UserView.class})
/*     */   private String telephone;
/*     */   
/*     */   @Column(name="email")
/*     */   @JsonView({Views.UserView.class})
/*     */   private String email;
/*     */   
/*     */   @Column(name="gender")
/*     */   @JsonView({Views.UserView.class})
/*     */   private String gender;
/*     */   
/*     */   @Column(name="id_code")
/*     */   @JsonView({Views.UserView.class})
/*     */   private String idCode;
/*     */   
/*     */   @Column(name="date_of_in")
/*     */   @JsonView({Views.UserView.class})
/*     */   private Date dateOfIn;
/*     */   
/*     */   @Column(name="date_of_birth")
/*     */   @JsonView({Views.UserView.class})
/*     */   private Date dateOfBirth;
/*     */   
/*     */   @Column(name="is_outside")
/*     */   @JsonView({Views.UserView.class})
/*     */   private Boolean isOutside;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="political_status_id")
/*     */   @JsonView({Views.UserView.class})
/*     */   private PoliticalStatus politicalStatus;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="professional_title_id")
/*     */   @JsonView({Views.UserView.class})
/*     */   private ProfessionalTitle professionalTitle;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="diploma_id")
/*     */   @JsonView({Views.UserView.class})
/*     */   private Diploma diploma;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="major_id")
/*     */   @JsonView({Views.UserView.class})
/*     */   private Major major;
/*     */   
/*     */   @Column(name="_is_password_complete")
/*     */   @JsonView({Views.UserView.class})
/*  99 */   private Boolean isPasswordComplete = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name="_is_locked")
/*     */   @JsonView({Views.UserView.class})
/* 103 */   private Boolean isLocked = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name="_is_active")
/*     */   @JsonView({Views.UserView.class})
/* 107 */   private Boolean isActive = Boolean.valueOf(true);
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="department_id")
			@JsonView({Views.UserView.class})
/*     */   private Department department;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="ethnicity_id")
			@JsonView({Views.UserView.class})
/*     */   private Ethnicity ethnicity;
/*     */   
/*     */   @ManyToMany(fetch=FetchType.LAZY)
/*     */   @JsonView({Views.UserRefRoleView.class})
/*     */   @JoinTable(name="x_user_x_role", joinColumns={@JoinColumn(name="user_id")}, inverseJoinColumns={@JoinColumn(name="role_id")})
/*     */   private Set<Role> roles;
/*     */   
/*     */ 
/*     */   public Integer getCodeId()
/*     */   {
/* 125 */     return this.codeId;
/*     */   }
/*     */   
/*     */   public void setCodeId(Integer codeId) {
/* 129 */     this.codeId = codeId;
/*     */   }
/*     */   
/*     */   public String getUsername() {
/* 133 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setUsername(String username) {
/* 137 */     this.username = username;
/*     */   }
/*     */   
/*     */   public String getOfficialName() {
/* 141 */     return this.officialName;
/*     */   }
/*     */   
/*     */   public void setOfficialName(String officialName) {
/* 145 */     this.officialName = officialName;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 149 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/* 153 */     this.password = password;
/*     */   }
/*     */   
/*     */   public String getTelephone() {
/* 157 */     return this.telephone;
/*     */   }
/*     */   
/*     */   public void setTelephone(String telephone) {
/* 161 */     this.telephone = telephone;
/*     */   }
/*     */   
/*     */   public String getGender() {
/* 165 */     return this.gender;
/*     */   }
/*     */   
/*     */   public void setGender(String gender) {
/* 169 */     this.gender = gender;
/*     */   }
/*     */   
/*     */   public String getIdCode() {
/* 173 */     return this.idCode;
/*     */   }
/*     */   
/*     */   public void setIdCode(String idCode) {
/* 177 */     this.idCode = idCode;
/*     */   }
/*     */   
/*     */   public Date getDateOfBirth() {
/* 181 */     return this.dateOfBirth;
/*     */   }
/*     */   
/*     */   public void setDateOfBirth(Date dateOfBirth) {
/* 185 */     this.dateOfBirth = dateOfBirth;
/*     */   }
/*     */   
/*     */   public PoliticalStatus getPoliticalStatus() {
/* 189 */     return this.politicalStatus;
/*     */   }
/*     */   
/*     */   public void setPoliticalStatus(PoliticalStatus politicalStatus) {
/* 193 */     this.politicalStatus = politicalStatus;
/*     */   }
/*     */   
/*     */   public Diploma getDiploma() {
/* 197 */     return this.diploma;
/*     */   }
/*     */   
/*     */   public void setDiploma(Diploma diploma) {
/* 201 */     this.diploma = diploma;
/*     */   }
/*     */   
/*     */   public Major getMajor() {
/* 205 */     return this.major;
/*     */   }
/*     */   
/*     */   public void setMajor(Major major) {
/* 209 */     this.major = major;
/*     */   }
/*     */   
/*     */   public Boolean getIsPasswordComplete() {
/* 213 */     return this.isPasswordComplete;
/*     */   }
/*     */   
/*     */   public void setIsPasswordComplete(Boolean isPasswordComplete) {
/* 217 */     this.isPasswordComplete = isPasswordComplete;
/*     */   }
/*     */   
/*     */   public Boolean getIsLocked() {
/* 221 */     return this.isLocked;
/*     */   }
/*     */   
/*     */   public void setIsLocked(Boolean isLocked) {
/* 225 */     this.isLocked = isLocked;
/*     */   }
/*     */   
/*     */   public Boolean getIsActive() {
/* 229 */     return this.isActive;
/*     */   }
/*     */   
/*     */   public void setIsActive(Boolean isActive) {
/* 233 */     this.isActive = isActive;
/*     */   }
/*     */   
/*     */   public Department getDepartment() {
/* 237 */     return this.department;
/*     */   }
/*     */   
/*     */   public void setDepartment(Department department) {
/* 241 */     this.department = department;
/*     */   }
/*     */   
/*     */   public Ethnicity getEthnicity() {
/* 245 */     return this.ethnicity;
/*     */   }
/*     */   
/*     */   public void setEthnicity(Ethnicity ethnicity) {
/* 249 */     this.ethnicity = ethnicity;
/*     */   }
/*     */   
/*     */   public Set<Role> getRoles() {
/* 253 */     return this.roles;
/*     */   }
/*     */   
/*     */   public void setRoles(Set<Role> roles) {
/* 257 */     this.roles = roles;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/* 261 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 265 */     this.email = email;
/*     */   }
/*     */   
/*     */   public Date getDateOfIn() {
/* 269 */     return this.dateOfIn;
/*     */   }
/*     */   
/*     */   public void setDateOfIn(Date dateOfIn) {
/* 273 */     this.dateOfIn = dateOfIn;
/*     */   }
/*     */   
/*     */   public Boolean getIsOutside() {
/* 277 */     return this.isOutside;
/*     */   }
/*     */   
/*     */   public void setIsOutside(Boolean isOutside) {
/* 281 */     this.isOutside = isOutside;
/*     */   }
/*     */   
/*     */   public ProfessionalTitle getProfessionalTitle() {
/* 285 */     return this.professionalTitle;
/*     */   }
/*     */   
/*     */   public void setProfessionalTitle(ProfessionalTitle professionalTitle) {
/* 289 */     this.professionalTitle = professionalTitle;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\User.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */