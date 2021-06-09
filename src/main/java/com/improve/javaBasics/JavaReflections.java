package com.improve.javaBasics;

import org.reflections.Reflections;

import java.util.Set;

public class JavaReflections {
    public static void main(String[] args){

        // org.reflections example
        Reflections reflections = new Reflections("org.hibernate.dialect");

        Set<Class<? extends Object>> allClasses =
                reflections.getSubTypesOf(Object.class);
        allClasses.stream().forEach(i ->{
            System.out.println(i.getName());
        });
    }
}
