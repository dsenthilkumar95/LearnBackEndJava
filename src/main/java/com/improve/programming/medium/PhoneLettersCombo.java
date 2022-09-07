package com.improve.programming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PhoneLettersCombo {
    public List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();
        String[] values = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length() == 0) {
            return out;
        }
        int[] maxValues = new int[digits.length()];
        int[] current = new int[digits.length()];
        int total = 1;
        for(int i=0; i<digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            maxValues[i] = values[index].length();
            total *= maxValues[i];
        }
        StringBuilder sb = new StringBuilder(digits.length());
        while(total>0) {
            for(int j=0; j<digits.length(); j++) {
                int in = Character.getNumericValue(digits.charAt(j));
                sb.append(values[in].charAt(current[j]));
            }
            out.add(sb.toString());
            total--;
            current = nextValue(current,maxValues);
            sb.delete(0,digits.length());
        }
        return out;
    }

    public int[] nextValue(int[] input, int[] maxValues) {
        int lastDigit = input.length-1;
        int sum = input[lastDigit] + 1;
        int carry = sum / maxValues[lastDigit];
        input[lastDigit] = sum % maxValues[lastDigit];
        if(carry > 0) {
            for(int i=input.length-2; i>-1; i--) {
                sum = input[i] + carry;
                carry = sum / maxValues[i];
                input[i] = sum % maxValues[i];
                if(carry == 0) {
                    break;
                }
            }
        }
        return input;
    }

    public List<String> letterCombinationsEasySolution(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PhoneLettersCombo ph = new PhoneLettersCombo();
        List<String> stringList = ph.letterCombinations("2");
        System.out.println(Arrays.toString(stringList.toArray()));
    }
}
