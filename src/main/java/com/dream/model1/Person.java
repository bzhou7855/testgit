package com.dream.model1;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private String name;
    private Integer salary;
    private List<Apple> appleList;

    public Person(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }
}
