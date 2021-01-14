
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.meta;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.haut.grm.model.meta.Menu;


@org.springframework.data.rest.core.annotation.RepositoryRestResource
public interface MenuRepository extends com.haut.grm.repository.base.BaseEntityRepository<com.haut.grm.model.meta.Menu,java.lang.Long>, org.springframework.data.querydsl.QueryDslPredicateExecutor<com.haut.grm.model.meta.Menu>, org.springframework.data.querydsl.binding.QuerydslBinderCustomizer<com.haut.grm.model.meta.QMenu> {
    java.util.Set<com.haut.grm.model.meta.Menu> findByRoles_Users_Id(@org.springframework.data.repository.query.Param("id") Long integer);//这里ID写成Integer 虽然不报错 但是请求时却会报错 所以写的时候务必严格按照类型写

    default void customize(org.springframework.data.querydsl.binding.QuerydslBindings bindings, com.haut.grm.model.meta.QMenu menu) { /* compiled code */ }
    
    
//    
    
    
//    And my_module=?2 ,@Param("my_module")int my_module
    @Query(value="SELECT * FROM meta_menu WHERE id IN(SELECT m_r.menu_id FROM x_menu_x_role m_r WHERE m_r.role_id IN(SELECT role_id FROM x_user_x_role WHERE x_user_x_role.user_id=(SELECT id FROM meta_user WHERE meta_user.username=?1))) AND is_obsolete=0 And my_module=?2", nativeQuery=true)//是不是原生sql 不是原生时需要对应java类而不是表名
    public List<Menu> getMenuByUserName(@Param("username")String username,@Param("my_module")int my_module);
    
    
    
    
    
}