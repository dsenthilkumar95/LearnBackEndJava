package com.improve.spring;

import com.improve.javaBasics.multiithreading.ExploreThreadEmployee;

public class SpringTest {
    public static void main(String[] args){
        ExploreThreadEmployee exploreThreadEmployee = new ExploreThreadEmployee();
        exploreThreadEmployee.setId(1);
        exploreThreadEmployee.setName("Senthil");
        System.out.println(exploreThreadEmployee.getId());
        System.out.println(exploreThreadEmployee.getName());
    }
}
