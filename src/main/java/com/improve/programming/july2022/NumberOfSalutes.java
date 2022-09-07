package com.improve.programming.july2022;

public class NumberOfSalutes {
    public static int solution(String s) {
        int r = 0;
        int salutes = 0;
        for(int i=0; i<s.length(); i++) {
            switch(s.charAt(i)) {
                case '>':
                    r++;
                    break;
                case '<':
                    salutes += r*2;
                    break;
                default:
                    continue;
            }
        }
        return salutes;
    }

    public static void main(String[] args) {
        System.out.println(NumberOfSalutes.solution("--->-><-><-->-"));
        System.out.println(NumberOfSalutes.solution(">----<"));
        System.out.println(NumberOfSalutes.solution("<<>><"));
        System.out.println("0 -> " + NumberOfSalutes.solution("<<<<"));
        System.out.println("0 -> " + NumberOfSalutes.solution(">>>>"));
        System.out.println("0 -> " + NumberOfSalutes.solution("<<>>"));
        System.out.println("8 -> " + NumberOfSalutes.solution("><<<<"));
        System.out.println("8 -> " + NumberOfSalutes.solution(">>>><"));
        System.out.println("8 -> " + NumberOfSalutes.solution(">><<"));
        System.out.println("8 -> " + NumberOfSalutes.solution(">>-------<<"));
        System.out.println("6 -> " + NumberOfSalutes.solution("----->>--->----<----"));
        System.out.println("12 -> " + NumberOfSalutes.solution(">><<<"));
        System.out.println("12 -> " + NumberOfSalutes.solution(">>><<"));
    }
}
