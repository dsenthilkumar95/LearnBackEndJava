package com.improve.javaBasics.collections;

import com.improve.javaBasics.multiithreading.ExploreThreadEmployee;

import java.util.*;

public class IteratingCollections {

    public static void main(String args[]){
        List<String> stringList = new ArrayList<>();
        stringList.add("senthil");
        stringList.add("saro");
        stringList.add("kishore");
        stringList.add("rekha");

        Iterator stringIterator = stringList.iterator();
        boolean first = true;
        int i=0;
        while (stringIterator.hasNext()){
            if(i==1){
                stringIterator.remove();
                first = false;
            }
            System.out.println(stringIterator.next());
            i++;
        }
        System.out.println("-----After Iteraor completes------");
        stringList.forEach(j-> {
            System.out.println(j);
        });

        Map<String,String> engaged = new TreeMap<>();
        engaged.put("Senthil", "No");
        engaged.put("Saro", "Yes");
        engaged.put("Rekha", "Yes");
        engaged.forEach((k,v)->
        {
            System.out.println("Key -> " + k + " Value -> " + v);
        });
        String value = engaged.getOrDefault("Kishore", "No");
        System.out.println("Kishore -> " + value);

        // When using treeSet or Treemap, key value should be implementing Comparable or comparator has to be passed in constructing treemap
        Map<ExploreThreadEmployee, String> treeMap = new TreeMap<>(new Comparator<ExploreThreadEmployee>() {
            @Override
            public int compare(ExploreThreadEmployee o1, ExploreThreadEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        // comparing static method for generating comparator and thencomparing method for appending compartor functionality to existing functionality
        Map<ExploreThreadEmployee, String> treeMap1 = new TreeMap<>(Comparator.comparing(ExploreThreadEmployee::getName).thenComparing(Comparator.comparing(ExploreThreadEmployee::getId)));
        ExploreThreadEmployee emp1= new ExploreThreadEmployee();
        emp1.setId(1);
        emp1.setName("Senthil");
        treeMap.put(emp1,"Senthil");
        ExploreThreadEmployee emp2= new ExploreThreadEmployee();
        emp2.setId(2);
        emp2.setName("Saro");
        treeMap.put(emp2,"Saro");

        treeMap.keySet().forEach(k -> {
            System.out.println("Employee -> " + k.toString());
        });

    }
}
