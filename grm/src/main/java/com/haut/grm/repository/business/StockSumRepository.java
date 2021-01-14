//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.haut.grm.repository.business;

import com.haut.grm.model.business.QStockSum;
import com.haut.grm.model.business.StockSum;
import com.haut.grm.repository.base.BaseBusinessRepository;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StockSumRepository extends BaseBusinessRepository<StockSum, QStockSum> {
    @Query(
        value = "SELECT * FROM gb_stock_sum s1 INNER JOIN (SELECT max(input_time) latest, cargo_id FROM gb_stock_id GROUP BY cargo_id) s2 ON s1.cargo_id = s2.cargo_id AND s1.input_time = s2.latest",
        nativeQuery = true
    )
    Set<StockSum> current();

    @Query(
        value = "SELECT * FROM gb_stock_sum s1 INNER JOIN (SELECT max(input_time) latest, cargo_id FROM gb_stock_id GROUP BY cargo_id) s2 ON s1.cargo_id = s2.cargo_id AND s1.input_time = s2.latest WHERE s1.cargo_id =?1",
        nativeQuery = true
    )
    StockSum currentStock(Long var1);

    @EntityGraph(
        attributePaths = {"cargo.compartment"}
    )
    List<StockSum> findByCargo_Compartment_Store_Depot_Id(Long var1);

    default void customize(QuerydslBindings bindings, QStockSum stockSum) {
        bindings.bind(stockSum.cargo.compartment.store.id).as("storeId").first((path, value) -> {
            return path.eq(value);
        });
        bindings.bind(stockSum.cargo.id).as("cargoIds").all((path, values) -> {
            return path.in(values);
        });
        bindings.bind(stockSum.cargo.compartment.store.depot.id).as("depotId").first((path, value) -> {
            return path.eq(value);
        });
        bindings.bind(stockSum.grainType.codeId).as("grainTypeCodeId").first((path, value) -> {
            return path.eq(value);
        });
        bindings.bind(stockSum.grainVariety.code).as("grainVariety").first((path, value) -> {
            return path.startsWith(value);
        });
    }
    
    
    public StockSum findByCargo_Id(Long id);
}
