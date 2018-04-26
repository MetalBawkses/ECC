package com.elektronika.costcalc.repository;

import com.elektronika.costcalc.model.Cost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

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