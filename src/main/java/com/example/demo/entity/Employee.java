package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter @Setter
    private int age;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String dept;

    public Employee( String name, String dept, int age ) {
        this.name = name;
        this.dept = dept;
        this.age = age;
    }

}
