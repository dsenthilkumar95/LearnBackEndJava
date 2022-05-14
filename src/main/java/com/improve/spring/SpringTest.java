package com.improve.spring;

import com.improve.javaBasics.ThreadEmployee;

public class SpringTest {
    public static void main(String[] args){
        ThreadEmployee threadEmployee = new ThreadEmployee();
        threadEmployee.setId(1);
        threadEmployee.setName("Senthil");
        System.out.println(threadEmployee.getId());
        System.out.println(threadEmployee.getName());
    }
}
