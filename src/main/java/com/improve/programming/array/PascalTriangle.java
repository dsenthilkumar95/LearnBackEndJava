package com.improve.programming.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    // Generate all the pascal triangle rows till given row number
    // Input range starts from 1.
    public List<List<Integer>> generate(int numRows) {
        int row = 1;
        List<Integer> prevList = new ArrayList<>(row);
        prevList.add(1);
        List<List<Integer>> out = new ArrayList<>();
        out.add(prevList);
        while(row < numRows) {
            List<Integer> loopList = new ArrayList<>(row+1);
            loopList.add(1);
            for(int i=1; i<row; i++) {
                loopList.add(prevList.get(i) + prevList.get(i-1));
            }
            loopList.add(1);
            prevList = loopList;
            out.add(loopList);
            row++;
        }
        return out;
    }

    // Get only particular row of pascal triangle
    // Input range starts from 0.
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> out = pascalTriangle.generate(1);
        for(List<Integer> o : out) {
            System.out.println(o);
        }
        out = pascalTriangle.generate(2);
        for(List<Integer> o : out) {
            System.out.println(o);
        }
        out = pascalTriangle.generate(3);
        for(List<Integer> o : out) {
            System.out.println(o);
        }
        out = pascalTriangle.generate(4);
        for(List<Integer> o : out) {
            System.out.println(o);
        }
        out = pascalTriangle.generate(5);
        for(List<Integer> o : out) {
            System.out.println(o);
        }
    }
}
