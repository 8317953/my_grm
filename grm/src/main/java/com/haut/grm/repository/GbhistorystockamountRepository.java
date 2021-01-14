//
//  // IntelliJ API Decompiler stub source generated from a class file
//  // Implementation of methods is not available
//
//package com.haut.grm.repository;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.querydsl.QueryDslPredicateExecutor;
//import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
//import org.springframework.data.querydsl.binding.QuerydslBindings;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//import com.haut.grm.model.QGbhistorystockamount;
//import com.haut.grm.model.Gbhistorystockamount;
//import com.haut.grm.repository.base.BaseEntityRepository;
//
//import io.swagger.annotations.Api;
//
//
//@RepositoryRestResource
//public interface GbhistorystockamountRepository extends BaseEntityRepository<Gbhistorystockamount,Long>, QueryDslPredicateExecutor<Gbhistorystockamount>, QuerydslBinderCustomizer<QGbhistorystockamount> {
//    default void customize(QuerydslBindings bindings, QGbhistorystockamount gbhistorystockamount) { /* compiled code */ }
//
//
//    @Query(value="SELECT * FROM `gb_history_stock_amount` WHERE (input_time IN (SELECT s.max_input_time FROM (SELECT *,DATE_FORMAT(`input_time`,'%Y%m%d') AS `ymd`,MAX(input_time) AS max_input_time FROM `gb_history_stock_amount` WHERE stock_id=?1 GROUP BY ymd)s) AND stock_id=?1)", nativeQuery=true)
//    public List<Gbhistorystockamount> myfindByStockid(int stockid);
//    
//}