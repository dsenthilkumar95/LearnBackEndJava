package com.improve.programming.medium;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n==1) {
            return "1";
        }
        String ref = "1";
        while(n>1) {
            StringBuilder out = new StringBuilder();
            int count = 0;
            char lastValue = ref.charAt(0);
            for(char c: ref.toCharArray()){
                if(lastValue == c) {
                    count += 1;
                } else {
                    out.append(count);
                    out.append(lastValue);
                    count = 1;
                    lastValue = c;
                }
            }
            out.append(count);
            out.append(lastValue);
            ref = out.toString();
            n--;
        }
        return ref;
    }

    public static void main(String[] args){
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(5));
    }
}
