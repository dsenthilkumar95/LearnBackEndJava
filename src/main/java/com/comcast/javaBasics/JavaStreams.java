package com.comcast.javaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args){
        Stream<Integer> stream1 = Stream.of(1,2,3,4);
        Stream<Integer> stream2 = Stream.of(new Integer[]{1,2,3,4});
        Stream<Integer> stream3 = Arrays.stream(new Integer[]{1,2,3,4,5});
        // Start Index is included and End Index is excluded.
        Stream<Integer> stream4 = Arrays.stream(new Integer[]{1,2,3,4,5}, 1,4);
        // Auto boxing is not allowed
        //Stream<Integer> stream3 = Stream.of(new int[]{1,2,3,4});

        // NOT Possible since of() method gives only Stream<T>
        // IntStream stream3 = Stream.of(new int[]{1,2,3,4});

        IntStream intStream = Arrays.stream(new int[]{1,2,3,4});
        IntStream intStream1 = Arrays.stream(new int[]{1,2,3,4}, 1,3);

        List<String> stringList = List.of("senthil", "saro", "rekha");
        Stream<String> stringStream = stringList.stream();
        Stream<String> parallelStream = stringList.parallelStream();

        // infinite Stream is produced with the element supplied. Limit can be used to cut them to the required number
        Stream<String> generatedStream = Stream.generate(() -> {
            return "abc";
        }).limit(10);
        Stream<Integer> generatedStream1 = Stream.generate(new Random()::nextInt).limit(5);

        // infinite Stream is produced with function(f) applied over each previous element(seed). Stream will be seed,f(seed),f(f(seed))...
        Stream<String> iterateStream = Stream.iterate("abcdefgh", i -> i.substring(1));
        // infinite Stream is produced with function(f) applied over each previous element(seed) till the middle predicate produces true.
        // Once the middle predicate fails stream production stops
        Stream<String> iterateStream1 = Stream.iterate("abcdefgh", i -> {
            return i.length()>0;
        }, i -> i.substring(1));
        intStream1.forEach(i -> System.out.println(i));

        String s1 = "ABCDEFGHZ";
        IntStream charStreamCap = s1.chars();
        charStreamCap.forEach(i -> {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(" -> ");
            sb.append(Character.toChars(i));
            //System.out.println(sb.toString());
            //System.out.println(i + " -> " + Character.toChars(i));
            // This is not working as this gives only the charater object Id
        });
    }
}
