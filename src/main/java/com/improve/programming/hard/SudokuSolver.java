package com.improve.programming.hard;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {

    }

    public static void main(String[] args){
        int allowed = 0b1111111110;
        System.out.println();
        char c = '1';
        int v = c-'0';
        System.out.println(v);
        int setmask = 1<<v;
        allowed &= setmask;
        System.out.println(allowed);

    }
}
