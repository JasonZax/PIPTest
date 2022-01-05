package com.ibm.demopip.repository;

import com.ibm.demopip.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository<Demo,Integer>{

    @Query("from Demo m where m.id=:id and m.name=:name and m.date=:date and m.type =: type")
    Demo findAll(@Param(value = "id") String id, @Param(value = "name") String name, @Param(value = "date") String date,@Param(value = "type") String tpe);

    @Transactional
    @Modifying
    @Query("delete from Demo m where m.id=:id")
    int deleteById(@Param(value = "id") int id);

    @Transactional
    @Modifying
    @Query(value = "insert into Demo(id,name,date,type) values(?1,?2,?3,?4)",nativeQuery = true)
    int insertAll(String id,String name,String date,String type);

}
