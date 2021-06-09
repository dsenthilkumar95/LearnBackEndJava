package com.improve.javaBasics;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringExplore {
    public static void main(String[] args){

        String s1 = "Senthil";
        String s = "Senthil"; // This will search for "Senthil" in String constant pool and if already present it points to the same.
        String s2 = "Saravanan";
        System.out.println(s2.indexOf("ar"));
        System.out.println(s2.lastIndexOf('a'));

//        Get charater a particular index from 0 to String length - 1
        System.out.println("String starts with -> " + s1.charAt(0));
        System.out.println("String ends with -> " + s1.charAt(s1.length()-1));

        // Getting int stream of chars from string and working on it.
        String s3 = "abcdefghz";
        IntStream charStream = s3.chars();
        charStream.forEach(i -> {
            System.out.println(i + " -> " + new String(Character.toChars(i)));
        });
        String s4 = "ABCDEFGHZ";
        IntStream charStreamCap = s4.chars();
        charStreamCap.forEach(i -> {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(" -> ");
            sb.append(Character.toChars(i));
            System.out.println(sb.toString());
            //System.out.println(i + " -> " + Character.toChars(i));
            // This is not working as this gives only the charater object Id
        });

        String s5 = "*sen*thi*l**";
        String[] s5split = s5.split("\\*");
        // Here split generated empty string for first position, but not produces empty string for end position
        Stream.of(s5split).forEach(i -> System.out.println("-" + i + "-"));

        // Objects[] obj = new String[5];

        // Objects.requireNonNull(T obj) returns the object not boolean true/false
        System.out.println("requireNonNull -> " + Objects.requireNonNull(s5));

        final StringBuffer sb = new StringBuffer();
        sb.append("setnthi");
        sb.append("kumar");
        System.out.println(sb.toString());
    }
}
