package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmpRepository empRepository;

    public Page<Employee> findAllEmpUsing(@RequestParam(required = false)  String name
            , @RequestParam(required = false)  Integer pageNum
            , @RequestParam(required = false)  String sortBy
            , @RequestParam(required = false)  String sortOrder ) {

        String empName = Optional.ofNullable( name ).orElse("_");
        Integer pageNumber = Optional.ofNullable( pageNum ).orElse(0);
        String sortByCol = Optional.ofNullable( sortBy ).orElse("id");
        String sortOrderString = Optional.ofNullable( sortOrder ).orElse("ASC");

        Sort.Direction sortDirection = Sort.Direction.ASC;

        if( sortOrderString.equalsIgnoreCase( "DESC" ) ) {
            sortDirection = Sort.Direction.DESC;
        }

        Pageable pageRequest = PageRequest.of( pageNumber
                , 10
                , sortDirection
                , sortByCol );

        Page<Employee> employees = this.empRepository.findByName( empName
                , pageRequest );

        return employees;
    }


    public List<Employee> findTop100() {

        List<Employee> employees = this.empRepository.findTop100By( );

        return employees;
    }

}
