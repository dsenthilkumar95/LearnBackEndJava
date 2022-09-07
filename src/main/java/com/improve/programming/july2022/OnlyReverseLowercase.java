package com.improve.programming.july2022;

public class OnlyReverseLowercase {
    public String solution(String in) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<in.length(); i++) {
            int ch = in.charAt(i);
            if(ch >= 97 && ch <= 122) {
                ch = 219 - ch;
            }
            stringBuilder.append((char)ch);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        OnlyReverseLowercase reverseLowercase = new OnlyReverseLowercase();
        String out = reverseLowercase.solution("aA");
        System.out.println(out);
    }
}
