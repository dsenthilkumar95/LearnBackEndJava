//package com.improve.javaBasics;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Java11Features {
//    public static void main(String[] args){
//        // Finds the string with only blankspaces
//        String s1 = " ";
//        System.out.println("Is s empty -> " + s1.isEmpty());
//
//        // Converts string with linebreaks in it to stream of strings split by \n
//        String s2="JD\nJD\nJD";
//        List<String> s1List = s2.lines().collect(Collectors.toList());
//        System.out.println(s1List.toString());
//
//        // Trims the whitespaces both in beginning and end of string
//        String s3 = "   Senthil    ";
//        System.out.print("Start");
//        System.out.print(s3.strip());
//        System.out.println("End");
//
//        System.out.print("Start");
//        System.out.print(s3.stripLeading());
//        System.out.println("End");
//
//        System.out.print("Start");
//        System.out.print(s3.stripTrailing());
//        System.out.println("End");
//
//        //To repeat the given string for as many times as mentioned by the integer
//        String s4 = "?";
//        System.out.println(s4.repeat(6));
//
//
//
//    }
//}
