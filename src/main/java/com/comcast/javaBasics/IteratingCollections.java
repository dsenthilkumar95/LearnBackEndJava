package com.comcast.javaBasics;

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

        LinkedHashMap<String,String> engaged = new LinkedHashMap<>();
        engaged.put("Senthil", "No");
        engaged.put("Saro", "Yes");
        engaged.put("Rekha", "Yes");
        engaged.forEach((k,v)->
        {
            System.out.println("Key -> " + k + " Value -> " + v);
        });
        String value = engaged.getOrDefault("Kishore", "No");
        System.out.println("Kishore -> " + value);
    }
}
