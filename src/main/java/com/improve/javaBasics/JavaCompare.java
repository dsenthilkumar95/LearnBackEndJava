package com.improve.javaBasics;

import com.improve.javaBasics.multiithreading.ExploreThreadEmployee;

import java.util.*;

public class JavaCompare {
    public static void main(String[] args){

        CompareAObj compareAObj1 = new CompareAObj();
        compareAObj1.setId(1);
        CompareAObj compareAObj2 = new CompareAObj();
        compareAObj2.setId(2);
        CompareAObj[] compareAObjsArray = {compareAObj1, compareAObj2};
        Arrays.sort(compareAObjsArray);
        Arrays.stream(compareAObjsArray).forEach(i-> System.out.println(i.toString()));

        CompareBObj compareBObj1 = new CompareBObj();
        compareBObj1.setId(1);
        CompareBObj compareBObj2 = new CompareBObj();
        compareBObj2.setId(2);
        CompareBObj[] compareBObjsArray = {compareBObj1, compareBObj2};

        class IdComparator implements Comparator<CompareBObj> {
            @Override
            public int compare(CompareBObj o1, CompareBObj o2) {
                return o1.getId() - o2.getId();
            }
        }

        Arrays.sort(compareBObjsArray, new IdComparator());
        Arrays.stream(compareBObjsArray).forEach(i-> System.out.println(i.toString()));

        int[] intArray = {4,3,2,1};
        Arrays.sort(intArray);

        System.out.println("Sorting List of List of Strings");
        List<List<String>> outerList = new ArrayList<>();
//        outerList.add(List.of("Senthil", "c"));
//        outerList.add(List.of("Saravanan", "a"));
//        outerList.add(List.of("Rekha", "b"));
        outerList.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        outerList.forEach(i -> {
            i.forEach(j -> System.out.println(j.toString()));
        });

        ExploreThreadEmployee emp1 = new ExploreThreadEmployee();
        emp1.setName("Employee");
        ExploreThreadEmployee emp2 = new ExploreThreadEmployee();
        emp2.setName("Saravanan");
        ExploreThreadEmployee emp3 = new ExploreThreadEmployee();
        emp3.setName("Senthil");
        Map<String, Integer> keyValueMap = new HashMap<>();
        keyValueMap.put("Employee",1);
        keyValueMap.put("Saravanan",2);
        keyValueMap.put("Senthil",3);

        Comparator<ExploreThreadEmployee> employeeComparator = new Comparator<ExploreThreadEmployee>() {
            @Override
            public int compare(ExploreThreadEmployee o1, ExploreThreadEmployee o2) {
                return keyValueMap.get(o1.getName()) - keyValueMap.get(o2.getName());
            }
        };
        List<ExploreThreadEmployee> empList = new ArrayList<>();
        empList.add(emp3);
        empList.add(emp2);
        empList.add(emp1);
        empList.forEach(i-> System.out.println(i));
        System.out.println("----------------------");
        empList.stream().sorted(employeeComparator).forEach(k->{
            System.out.println(k);
        });

    }
}


