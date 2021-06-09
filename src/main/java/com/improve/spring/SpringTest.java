package com.improve.spring;

import com.improve.javaBasics.Employee;

public class SpringTest {
    public static void main(String[] args){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Senthil");
        System.out.println(employee.getId());
        System.out.println(employee.getName());
    }
}
