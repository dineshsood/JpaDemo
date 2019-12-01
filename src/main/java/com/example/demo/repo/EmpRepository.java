package com.example.demo.repo;

import com.example.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where name like %?1%")
    Page<Employee> findByName( String name, Pageable pageable );

    List<Employee> findTop100By();
}
