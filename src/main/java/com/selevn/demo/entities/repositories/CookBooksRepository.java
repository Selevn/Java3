package com.selevn.demo.entities.repositories;

import com.selevn.demo.entities.CookbooksViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CookBooksRepository extends JpaRepository<CookbooksViewEntity, Integer>{
    @Query(value = "select * from get_cookbooks(?1,?2,?3,CAST(?4 as varbit),?5,CAST(?6 as varchar))", nativeQuery = true)
    List<CookbooksViewEntity> getAll(Integer count,
                                     Integer page,
                                     Integer sortby,
                                     String filter,
                                     Integer hidemy,
                                     String searchString);
    @Query(value = "select * from get_cookbooks(?1,?2,?3,null,?4,CAST(?5 as varchar))", nativeQuery = true)
    List<CookbooksViewEntity> getAllNoFilters(Integer count,
                                     Integer page,
                                     Integer sortby,
                                     Integer hidemy,
                                     String searchString);

    @Query(value = "select * from get_cookbooks(?1,?2,?3,CAST(?4 as varbit),?5,CAST(?6 as varchar))", nativeQuery = true)
    int getAllCount(Integer count,
                                     Integer page,
                                     Integer sortby,
                                     String filter,
                                     Integer hidemy,
                                     String searchString);
    @Query(value = "select * from get_cookbooks_count(?1,?2,?3,null,?4,CAST(?5 as varchar))", nativeQuery = true)
    int getAllNoFiltersCount(Integer count,
                                              Integer page,
                                              Integer sortby,
                                              Integer hidemy,
                                              String searchString);
}
