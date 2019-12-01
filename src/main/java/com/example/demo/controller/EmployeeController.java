package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public Page<Employee> findAllEmpUsing( @RequestParam(required = false) String name
            , @RequestParam(required = false) Integer pageNum
            , @RequestParam(required = false) String sortBy
            , @RequestParam(required = false) String sortOrder ) {

        Page<Employee> employees = this.employeeService
                .findAllEmpUsing( name
                        , pageNum
                        , sortBy
                        , sortOrder );

        return employees;
    }

    @GetMapping("/employees/findTop100")
    public List<Employee> findTop100() {

        List<Employee> employees = this.employeeService
                .findTop100();

        return employees;
    }
}
