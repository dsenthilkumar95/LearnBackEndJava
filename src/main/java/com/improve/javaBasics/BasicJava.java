package com.improve.javaBasics;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BasicJava {

    public static void main(String[] args) {
        // Ambiguity in multiple inheritance
        InterA interA = new Ambigious();
        interA.common();
        Object arrList = new ArrayList<String>();

        // ArrayList construction from another collection
        String[] sourceArray = new String[]{"senthil"};
        String[] targetArray = java.util.Arrays.copyOf(sourceArray, 1);

        sourceArray[0] = "saro";
        System.out.println(targetArray[0]);

        // remove method overloading in ArrayList between index and object
        // Here 1 is casted to int primitive as removes "2" from list, while only 1 created as Integer object is only removes the "1" from list
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.remove(1);
        intList.remove(new Integer(1));
        intList.forEach(i -> System.out.println(i));

        // Here String print method is called and null casts to String before Object
        print(null);

        // using / operator in int
        int a;
        a = 8/3;
        int b = -1/2;
        System.out.println("a -> " + a + " b -> " + b);

        // Changing today date to tomorrow and setting time.
        Date now = new Date();
        System.out.println(now.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        System.out.println("Tomorrow -> " + date.toString());

        // calling function with return in finally block
        System.out.println("return in finally block -> " + showingFinallyPower());

        printUs();

        Integer int1  = Integer.parseUnsignedInt("196");
        Byte b1 = int1.byteValue();
        System.out.println("Byte Value of 196 -> " + b1);


    }

    public static void print(Object o){
        System.out.println("Object method is called");
    }

    public static void print(String s){
        System.out.println("String method is called");
    }

    public static void print(int s){
        System.out.println("int method is called");
    }


    public static int showingFinallyPower(){
        try{
            return 0;
        } catch (Exception e){
            return 10;
        } finally {
            return 20;
        }
    }

    public static void printUs(int... s){
        System.out.println("int group is called");
    }
//    public static void printUs(String... s){
//        System.out.println("string group is called");
//    }
    public static void printUs(float... s){
        System.out.println("float group is called");
    }
    public static void printUs(double... s){
        System.out.println("double group is called");
    }
//    public static void printUs(Object... s){
//        System.out.println("object group is called");
//    }
}
