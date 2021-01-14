/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.meta.LevelType;
/*     */ import com.haut.grm.model.standard.code.GrainVariety;
/*     */ import com.haut.grm.model.standard.code.Location;
/*     */ import com.haut.grm.model.type.CompanyDetailType;
/*     */ import com.haut.grm.model.type.CompanyGrainType;
/*     */ import com.haut.grm.model.type.CompanyLevelType;
/*     */ import com.haut.grm.model.type.CompanyType;
/*     */ import com.haut.grm.model.type.Country;
/*     */ import com.haut.grm.model.type.IdType;
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
/*     */ import org.springframework.data.rest.core.annotation.Description;
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
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="grm_company")
/*     */ public class Company
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = -1455657275436729190L;
/*     */   public static final long THE_ID = 1L;
/*     */   @Column
/*     */   @Description("企业代码")
/*     */   String qydm;
/*     */   @Column
/*     */   @Description("企业名称")
/*     */   String qymc;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="qylx")
/*     */   @Description("企业类型")
/*     */   CompanyDetailType qylx;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="qylb")
/*     */   @Description("企业类别")
/*     */   CompanyGrainType qylb;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="qyxz")
/*     */   @Description("企业经济性质")
/*     */   CompanyType qyxz;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="lsgx")
/*     */   @Description("隶属关系")
/*     */   CompanyLevelType lsgx;
/*     */   @Column
/*     */   @Description("是否应急企业")
/*     */   Boolean sfyjqy;
/*     */   @Column
/*     */   @Description("是否放心粮油")
/*     */   Boolean sffxly;
/*     */   @Column
/*     */   @Description("隶属上级单位")
/*     */   String lssjdw;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="sgzg")
/*     */   @Description("收购资格")
/*     */   LevelType sgzg;
/*     */   @Column
/*     */   @Description("收购许可证")
/*     */   String sgxkz;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="sjlsbh")
/*     */   @Description("上级粮食局")
/*     */   Location sjlsbh;
/*     */   @Column
/*     */   @Description("登记机关编号")
/*     */   String djjgbh;
/*     */   @Column
/*     */   @Description("注册时间")
/*     */   Date zcsj;
/*     */   @Column
/*     */   @Description("注册资本")
/*     */   Double zczb;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="zcqybm")
/*     */   @Description("注册地址区域编码")
/*     */   Location zcqybm;
/*     */   @Column
/*     */   @Description("注册详细地址")
/*     */   String zcxxdz;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="jydzbm")
/*     */   @Description("经营地址区域编码")
/*     */   Location jydzbm;
/*     */   @Column
/*     */   @Description("法人姓名")
/*     */   String frxm;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="frgb")
/*     */   @Description("法人国别")
/*     */   Country frgb;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="frzjlx")
/*     */   @Description("法人证件类型")
/*     */   IdType frzjlx;
/*     */   @Column
/*     */   @Description("法人证件号")
/*     */   String frsfz;
/*     */   @Column
/*     */   @Description("法人手机号")
/*     */   String frsjh;
/*     */   @Column
/*     */   @Description("经度")
/*     */   Double jd;
/*     */   @Column
/*     */   @Description("纬度")
/*     */   Double wd;
/*     */   @Column
/*     */   @Description("资产总额")
/*     */   Double zcze;
/*     */   @Column
/*     */   @Description("年加工量")
/*     */   Double njgl;
/*     */   @ManyToMany(fetch=FetchType.EAGER)
/*     */   @JoinTable(name="x_company_process_grain_variety", joinColumns={@JoinColumn(name="company_id")}, inverseJoinColumns={@JoinColumn(name="grain_variety_id")})
/*     */   @Description("主要加工品种")
/*     */   Set<GrainVariety> zyjgpz;
/*     */   @Column
/*     */   @Description("年经营量")
/*     */   Double njyl;
/*     */   @ManyToMany(fetch=FetchType.EAGER)
/*     */   @JoinTable(name="x_company_out_grain_variety", joinColumns={@JoinColumn(name="company_id")}, inverseJoinColumns={@JoinColumn(name="grain_variety_id")})
/*     */   @Description("主要经营品种")
/*     */   Set<GrainVariety> zyjypz;
/*     */   @Column
/*     */   @Description("年收购量")
/*     */   Double nsgl;
/*     */   @ManyToMany(fetch=FetchType.EAGER)
/*     */   @JoinTable(name="x_company_in_grain_variety", joinColumns={@JoinColumn(name="company_id")}, inverseJoinColumns={@JoinColumn(name="grain_variety_id")})
/*     */   @Description("主要收购品种")
/*     */   Set<GrainVariety> zysgpz;
/*     */   @Column
/*     */   @Description("自有资金")
/*     */   Double zyzj;
/*     */   
/*     */   public String getQydm()
/*     */   {
/* 190 */     return this.qydm;
/*     */   }
/*     */   
/*     */   public void setQydm(String qydm) {
/* 194 */     this.qydm = qydm;
/*     */   }
/*     */   
/*     */   public String getQymc() {
/* 198 */     return this.qymc;
/*     */   }
/*     */   
/*     */   public void setQymc(String qymc) {
/* 202 */     this.qymc = qymc;
/*     */   }
/*     */   
/*     */   public CompanyDetailType getQylx() {
/* 206 */     return this.qylx;
/*     */   }
/*     */   
/*     */   public void setQylx(CompanyDetailType qylx) {
/* 210 */     this.qylx = qylx;
/*     */   }
/*     */   
/*     */   public CompanyGrainType getQylb() {
/* 214 */     return this.qylb;
/*     */   }
/*     */   
/*     */   public void setQylb(CompanyGrainType qylb) {
/* 218 */     this.qylb = qylb;
/*     */   }
/*     */   
/*     */   public CompanyType getQyxz() {
/* 222 */     return this.qyxz;
/*     */   }
/*     */   
/*     */   public void setQyxz(CompanyType qyxz) {
/* 226 */     this.qyxz = qyxz;
/*     */   }
/*     */   
/*     */   public CompanyLevelType getLsgx() {
/* 230 */     return this.lsgx;
/*     */   }
/*     */   
/*     */   public void setLsgx(CompanyLevelType lsgx) {
/* 234 */     this.lsgx = lsgx;
/*     */   }
/*     */   
/*     */   public Boolean getSfyjqy() {
/* 238 */     return this.sfyjqy;
/*     */   }
/*     */   
/*     */   public void setSfyjqy(Boolean sfyjqy) {
/* 242 */     this.sfyjqy = sfyjqy;
/*     */   }
/*     */   
/*     */   public Boolean getSffxly() {
/* 246 */     return this.sffxly;
/*     */   }
/*     */   
/*     */   public void setSffxly(Boolean sffxly) {
/* 250 */     this.sffxly = sffxly;
/*     */   }
/*     */   
/*     */   public String getLssjdw() {
/* 254 */     return this.lssjdw;
/*     */   }
/*     */   
/*     */   public void setLssjdw(String lssjdw) {
/* 258 */     this.lssjdw = lssjdw;
/*     */   }
/*     */   
/*     */   public LevelType getSgzg() {
/* 262 */     return this.sgzg;
/*     */   }
/*     */   
/*     */   public void setSgzg(LevelType sgzg) {
/* 266 */     this.sgzg = sgzg;
/*     */   }
/*     */   
/*     */   public String getSgxkz() {
/* 270 */     return this.sgxkz;
/*     */   }
/*     */   
/*     */   public void setSgxkz(String sgxkz) {
/* 274 */     this.sgxkz = sgxkz;
/*     */   }
/*     */   
/*     */   public Location getSjlsbh() {
/* 278 */     return this.sjlsbh;
/*     */   }
/*     */   
/*     */   public void setSjlsbh(Location sjlsbh) {
/* 282 */     this.sjlsbh = sjlsbh;
/*     */   }
/*     */   
/*     */   public String getDjjgbh() {
/* 286 */     return this.djjgbh;
/*     */   }
/*     */   
/*     */   public void setDjjgbh(String djjgbh) {
/* 290 */     this.djjgbh = djjgbh;
/*     */   }
/*     */   
/*     */   public Date getZcsj() {
/* 294 */     return this.zcsj;
/*     */   }
/*     */   
/*     */   public void setZcsj(Date zcsj) {
/* 298 */     this.zcsj = zcsj;
/*     */   }
/*     */   
/*     */   public Double getZczb() {
/* 302 */     return this.zczb;
/*     */   }
/*     */   
/*     */   public void setZczb(Double zczb) {
/* 306 */     this.zczb = zczb;
/*     */   }
/*     */   
/*     */   public Location getZcqybm() {
/* 310 */     return this.zcqybm;
/*     */   }
/*     */   
/*     */   public void setZcqybm(Location zcqybm) {
/* 314 */     this.zcqybm = zcqybm;
/*     */   }
/*     */   
/*     */   public String getZcxxdz() {
/* 318 */     return this.zcxxdz;
/*     */   }
/*     */   
/*     */   public void setZcxxdz(String zcxxdz) {
/* 322 */     this.zcxxdz = zcxxdz;
/*     */   }
/*     */   
/*     */   public Location getJydzbm() {
/* 326 */     return this.jydzbm;
/*     */   }
/*     */   
/*     */   public void setJydzbm(Location jydzbm) {
/* 330 */     this.jydzbm = jydzbm;
/*     */   }
/*     */   
/*     */   public String getFrxm() {
/* 334 */     return this.frxm;
/*     */   }
/*     */   
/*     */   public void setFrxm(String frxm) {
/* 338 */     this.frxm = frxm;
/*     */   }
/*     */   
/*     */   public Country getFrgb() {
/* 342 */     return this.frgb;
/*     */   }
/*     */   
/*     */   public void setFrgb(Country frgb) {
/* 346 */     this.frgb = frgb;
/*     */   }
/*     */   
/*     */   public IdType getFrzjlx() {
/* 350 */     return this.frzjlx;
/*     */   }
/*     */   
/*     */   public void setFrzjlx(IdType frzjlx) {
/* 354 */     this.frzjlx = frzjlx;
/*     */   }
/*     */   
/*     */   public String getFrsfz() {
/* 358 */     return this.frsfz;
/*     */   }
/*     */   
/*     */   public void setFrsfz(String frsfz) {
/* 362 */     this.frsfz = frsfz;
/*     */   }
/*     */   
/*     */   public String getFrsjh() {
/* 366 */     return this.frsjh;
/*     */   }
/*     */   
/*     */   public void setFrsjh(String frsjh) {
/* 370 */     this.frsjh = frsjh;
/*     */   }
/*     */   
/*     */   public Double getJd() {
/* 374 */     return this.jd;
/*     */   }
/*     */   
/*     */   public void setJd(Double jd) {
/* 378 */     this.jd = jd;
/*     */   }
/*     */   
/*     */   public Double getWd() {
/* 382 */     return this.wd;
/*     */   }
/*     */   
/*     */   public void setWd(Double wd) {
/* 386 */     this.wd = wd;
/*     */   }
/*     */   
/*     */   public Double getZcze() {
/* 390 */     return this.zcze;
/*     */   }
/*     */   
/*     */   public void setZcze(Double zcze) {
/* 394 */     this.zcze = zcze;
/*     */   }
/*     */   
/*     */   public Double getNjgl() {
/* 398 */     return this.njgl;
/*     */   }
/*     */   
/*     */   public void setNjgl(Double njgl) {
/* 402 */     this.njgl = njgl;
/*     */   }
/*     */   
/*     */   public Set<GrainVariety> getZyjgpz() {
/* 406 */     return this.zyjgpz;
/*     */   }
/*     */   
/*     */   public void setZyjgpz(Set<GrainVariety> zyjgpz) {
/* 410 */     this.zyjgpz = zyjgpz;
/*     */   }
/*     */   
/*     */   public Double getNjyl() {
/* 414 */     return this.njyl;
/*     */   }
/*     */   
/*     */   public void setNjyl(Double njyl) {
/* 418 */     this.njyl = njyl;
/*     */   }
/*     */   
/*     */   public Set<GrainVariety> getZyjypz() {
/* 422 */     return this.zyjypz;
/*     */   }
/*     */   
/*     */   public void setZyjypz(Set<GrainVariety> zyjypz) {
/* 426 */     this.zyjypz = zyjypz;
/*     */   }
/*     */   
/*     */   public Double getNsgl() {
/* 430 */     return this.nsgl;
/*     */   }
/*     */   
/*     */   public void setNsgl(Double nsgl) {
/* 434 */     this.nsgl = nsgl;
/*     */   }
/*     */   
/*     */   public Set<GrainVariety> getZysgpz() {
/* 438 */     return this.zysgpz;
/*     */   }
/*     */   
/*     */   public void setZysgpz(Set<GrainVariety> zysgpz) {
/* 442 */     this.zysgpz = zysgpz;
/*     */   }
/*     */   
/*     */   public Double getZyzj() {
/* 446 */     return this.zyzj;
/*     */   }
/*     */   
/*     */   public void setZyzj(Double zyzj) {
/* 450 */     this.zyzj = zyzj;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\Company.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */