package com.improve.programming.july2022;

import java.util.Arrays;

public class LargestNumberDivisibleBy3 {
    public int solution(int[] l) {
        // Your code here
        Arrays.sort(l);
        int index2 = 2;
        int index1 = 0;
        int[] mod = new int[4];
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        int rem;
        for(int i=0; i<l.length; i++) {
            sum += l[i];
            sb.append(l[i]);
            rem = l[i] % 3;
            if(index1<2 && rem == 1) {
                mod[index1] = i;
                index1++;
            } else if(index2<4 && rem == 2) {
                mod[index2] = i;
                index2++;
            }
        }
        int totalRem = sum % 3;
        if(totalRem == 0) {
            StringBuilder rev = sb.reverse();
            String out = rev.toString().equals("") ? "0" : rev.toString();
            return Integer.valueOf(out);
        } else if(totalRem == 1) {
            if(index1 > 0) {
                sb.deleteCharAt(mod[0]);
                StringBuilder rev = sb.reverse();
                String out = rev.toString().equals("") ? "0" : rev.toString();
                return Integer.valueOf(out);
            } else if(index2 == 4) {
                sb.deleteCharAt(mod[2]);
                sb.deleteCharAt(mod[3]-1);
                StringBuilder rev = sb.reverse();
                String out = rev.toString().equals("") ? "0" : rev.toString();
                return Integer.valueOf(out);
            } else {
                return 0;
            }
        } else if(totalRem == 2) {
            if(index2 > 2) {
                sb.deleteCharAt(mod[2]);
                StringBuilder rev = sb.reverse();
                String out = rev.toString().equals("") ? "0" : rev.toString();
                return Integer.valueOf(out);
            } else if(index1 == 2) {
                sb.deleteCharAt(mod[0]);
                sb.deleteCharAt(mod[1]-1);
                StringBuilder rev = sb.reverse();
                String out = rev.toString().equals("") ? "0" : rev.toString();
                return Integer.valueOf(out);
            } else {
                return 0;
            }
        }
        return 0;
    }

    public void tester() {
        StringBuilder sb = new StringBuilder();
        String out = sb.toString();
        System.out.println("out ->" + out + "<-");
    }

    public static void main(String[] args) {
        LargestNumberDivisibleBy3 divisibleBy3 = new LargestNumberDivisibleBy3();
        int[] in = {4,1,7,1,7};
//        System.out.println(divisibleBy3.solution(in));
        divisibleBy3.tester();
    }
}
