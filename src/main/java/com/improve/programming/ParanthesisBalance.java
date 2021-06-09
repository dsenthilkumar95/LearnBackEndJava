package com.improve.programming;

import java.util.EmptyStackException;
import java.util.Stack;

public class ParanthesisBalance {
    public int longestValidParentheses(String s) {
        Stack<Character> paranthesis = new Stack<>();
        int maxLength = 0;
        int pairs = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                paranthesis.push(s.charAt(i));
            }
            if(s.charAt(i) == ')'){
                try{
                    paranthesis.pop();
                    pairs = pairs + 2;
                    if(maxLength < pairs){
                        maxLength = pairs;
                    }
                } catch (EmptyStackException e){
                    if(maxLength < pairs){
                        maxLength = pairs;
                    }
                    pairs = 0;
                }
            }
        }
        return maxLength;
    }
}