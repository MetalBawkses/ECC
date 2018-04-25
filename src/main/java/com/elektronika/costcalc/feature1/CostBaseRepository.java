package com.elektronika.costcalc.feature1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;


import java.util.List;

@NoRepositoryBean
public interface CostBaseRepository<T extends Cost>
        extends CrudRepository<T, Long> {

////    T findByName(String name);
////
//    @Query("select e from #{#entityName} e") // #{#entityName} will be magically replaced by type arguments in children
//    List<T> findThemAll();
////
//    @Query("select c from Cost c where c.yearMonth= :ym")
//    List<Cost> findAllCost(@Param("ym") Integer ym);



}