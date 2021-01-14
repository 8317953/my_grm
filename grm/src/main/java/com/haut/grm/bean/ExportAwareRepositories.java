/*     */ package com.haut.grm.bean;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.springframework.beans.factory.BeanFactory;
/*     */ import org.springframework.beans.factory.BeanFactoryUtils;
/*     */ import org.springframework.beans.factory.ListableBeanFactory;
/*     */ import org.springframework.data.mapping.PersistentEntity;
/*     */ import org.springframework.data.repository.core.EntityInformation;
/*     */ import org.springframework.data.repository.core.RepositoryInformation;
/*     */ import org.springframework.data.repository.core.support.RepositoryFactoryInformation;
/*     */ import org.springframework.data.repository.query.QueryMethod;
/*     */ import org.springframework.data.repository.support.Repositories;
/*     */ import org.springframework.data.rest.core.annotation.RepositoryRestResource;
/*     */ import org.springframework.util.Assert;
/*     */ 
/*     */ public class ExportAwareRepositories extends Repositories
/*     */ {
/*  22 */   static final Repositories NONE = new ExportAwareRepositories();
/*     */   
/*  24 */   private static final RepositoryFactoryInformation<Object, Serializable> EMPTY_REPOSITORY_FACTORY_INFO = EmptyRepositoryFactoryInformation.INSTANCE;
/*     */   
/*     */   private static final String DOMAIN_TYPE_MUST_NOT_BE_NULL = "Domain type must not be null!";
/*     */   
/*     */   private final BeanFactory beanFactory;
/*     */   
/*     */   private final Map<Class<?>, String> repositoryBeanNames;
/*     */   
/*     */   private final Map<Class<?>, RepositoryFactoryInformation<Object, Serializable>> repositoryFactoryInfos;
/*     */   
/*     */   private ExportAwareRepositories()
/*     */   {
/*  36 */     super(new org.springframework.beans.factory.support.DefaultListableBeanFactory());
/*  37 */     this.beanFactory = null;
/*  38 */     this.repositoryBeanNames = Collections.emptyMap();
/*  39 */     this.repositoryFactoryInfos = Collections.emptyMap();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ExportAwareRepositories(ListableBeanFactory factory)
/*     */   {
/*  50 */     super(new org.springframework.beans.factory.support.DefaultListableBeanFactory());
/*  51 */     Assert.notNull(factory, "Factory must not be null!");
/*     */     
/*  53 */     this.beanFactory = factory;
/*  54 */     this.repositoryFactoryInfos = new HashMap();
/*  55 */     this.repositoryBeanNames = new HashMap();
/*     */     
/*  57 */     populateRepositoryFactoryInformation(factory);
/*     */   }
/*     */   
/*     */   private void populateRepositoryFactoryInformation(ListableBeanFactory factory) {
/*     */     String[] arrayOfString;
/*  62 */     int j = (arrayOfString = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(factory, RepositoryFactoryInformation.class, 
/*  63 */       false, false)).length; for (int i = 0; i < j; i++) { String name = arrayOfString[i];
/*     */       
/*  64 */       cacheRepositoryFactory(name);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private synchronized void cacheRepositoryFactory(String name)
/*     */   {
/*  71 */     RepositoryFactoryInformation repositoryFactoryInformation = (RepositoryFactoryInformation)this.beanFactory.getBean(name, 
/*  72 */       RepositoryFactoryInformation.class);
/*  73 */     Class<?> domainType = 
/*  74 */       org.springframework.util.ClassUtils.getUserClass(repositoryFactoryInformation.getRepositoryInformation().getDomainType());
/*     */     
/*  76 */     RepositoryInformation information = repositoryFactoryInformation.getRepositoryInformation();
/*  77 */     Set<Class<?>> alternativeDomainTypes = information.getAlternativeDomainTypes();
/*  78 */     String beanName = BeanFactoryUtils.transformedBeanName(name);
/*     */     
/*  80 */     Set<Class<?>> typesToRegister = new java.util.HashSet(alternativeDomainTypes.size() + 1);
/*  81 */     typesToRegister.add(domainType);
/*  82 */     typesToRegister.addAll(alternativeDomainTypes);
/*     */     
/*  84 */     for (Class<?> type : typesToRegister)
/*     */     {
/*  86 */       if (this.repositoryFactoryInfos.containsKey(type)) {
/*  87 */         Class<?> repoInterface = information.getRepositoryInterface();
/*  88 */         if (repoInterface.isAnnotationPresent(RepositoryRestResource.class)) {
/*  89 */           boolean exported = ((RepositoryRestResource)repoInterface.getAnnotation(RepositoryRestResource.class)).exported();
/*     */           
/*  91 */           if (exported) {
/*  92 */             this.repositoryFactoryInfos.put(type, repositoryFactoryInformation);
/*  93 */             this.repositoryBeanNames.put(type, beanName);
/*     */           }
/*     */         }
/*     */       } else {
/*  97 */         this.repositoryFactoryInfos.put(type, repositoryFactoryInformation);
/*  98 */         this.repositoryBeanNames.put(type, beanName);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasRepositoryFor(Class<?> domainClass)
/*     */   {
/* 112 */     Assert.notNull(domainClass, "Domain type must not be null!");
/*     */     
/* 114 */     return this.repositoryFactoryInfos.containsKey(domainClass);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Object getRepositoryFor(Class<?> domainClass)
/*     */   {
/* 126 */     Assert.notNull(domainClass, "Domain type must not be null!");
/*     */     
/* 128 */     String repositoryBeanName = (String)this.repositoryBeanNames.get(domainClass);
/* 129 */     return (repositoryBeanName == null) || (this.beanFactory == null) ? null : this.beanFactory.getBean(repositoryBeanName);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private RepositoryFactoryInformation<Object, Serializable> getRepositoryFactoryInfoFor(Class<?> domainClass)
/*     */   {
/* 142 */     Assert.notNull(domainClass, "Domain type must not be null!");
/*     */     
/* 144 */     Class<?> userType = org.springframework.util.ClassUtils.getUserClass(domainClass);
/* 145 */     RepositoryFactoryInformation<Object, Serializable> repositoryInfo = (RepositoryFactoryInformation)this.repositoryFactoryInfos.get(userType);
/*     */     
/* 147 */     if (repositoryInfo != null) {
/* 148 */       return repositoryInfo;
/*     */     }
/*     */     
/* 151 */     if (!userType.equals(Object.class)) {
/* 152 */       return getRepositoryFactoryInfoFor(userType.getSuperclass());
/*     */     }
/*     */     
/* 155 */     return EMPTY_REPOSITORY_FACTORY_INFO;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public <T, S extends Serializable> EntityInformation<T, S> getEntityInformationFor(Class<?> domainClass)
/*     */   {
/* 168 */     Assert.notNull(domainClass, "Domain type must not be null!");
/*     */     
/* 170 */     return (EntityInformation<T, S>) getRepositoryFactoryInfoFor(domainClass).getEntityInformation();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public RepositoryInformation getRepositoryInformationFor(Class<?> domainClass)
/*     */   {
/* 183 */     Assert.notNull(domainClass, "Domain type must not be null!");
/*     */     
/* 185 */     RepositoryFactoryInformation<Object, Serializable> information = getRepositoryFactoryInfoFor(domainClass);
/* 186 */     return information == EMPTY_REPOSITORY_FACTORY_INFO ? null : information.getRepositoryInformation();
/*     */   }
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
/*     */   public RepositoryInformation getRepositoryInformation(Class<?> repositoryInterface)
/*     */   {
/* 200 */     for (RepositoryFactoryInformation<Object, Serializable> factoryInformation : this.repositoryFactoryInfos.values())
/*     */     {
/* 202 */       RepositoryInformation information = factoryInformation.getRepositoryInformation();
/*     */       
/* 204 */       if (information.getRepositoryInterface().equals(repositoryInterface)) {
/* 205 */         return information;
/*     */       }
/*     */     }
/*     */     
/* 209 */     return null;
/*     */   }
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
/*     */   public PersistentEntity<?, ?> getPersistentEntity(Class<?> domainClass)
/*     */   {
/* 223 */     Assert.notNull(domainClass, "Domain type must not be null!");
/* 224 */     return getRepositoryFactoryInfoFor(domainClass).getPersistentEntity();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public java.util.List<QueryMethod> getQueryMethodsFor(Class<?> domainClass)
/*     */   {
/* 236 */     Assert.notNull(domainClass, "Domain type must not be null!");
/* 237 */     return getRepositoryFactoryInfoFor(domainClass).getQueryMethods();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public java.util.Iterator<Class<?>> iterator()
/*     */   {
/* 246 */     return this.repositoryFactoryInfos.keySet().iterator();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static enum EmptyRepositoryFactoryInformation
/*     */     implements RepositoryFactoryInformation<Object, Serializable>
/*     */   {
/* 256 */     INSTANCE;
/*     */     
/*     */     public EntityInformation<Object, Serializable> getEntityInformation()
/*     */     {
/* 260 */       return null;
/*     */     }
/*     */     
/*     */     public RepositoryInformation getRepositoryInformation()
/*     */     {
/* 265 */       return null;
/*     */     }
/*     */     
/*     */     public PersistentEntity<?, ?> getPersistentEntity()
/*     */     {
/* 270 */       return null;
/*     */     }
/*     */     
/*     */     public java.util.List<QueryMethod> getQueryMethods()
/*     */     {
/* 275 */       return Collections.emptyList();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\bean\ExportAwareRepositories.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */