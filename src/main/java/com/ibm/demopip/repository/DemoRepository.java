package com.ibm.demopip.repository;

import com.ibm.demopip.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DemoRepository extends JpaRepository<Demo,Integer> {
    public List<Demo> findAllById(int id);
    public List<Demo> findAllByName(String name);
    public List<Demo> findAllByDate(String date);
    public List<Demo> findAllByType(String type);
}
