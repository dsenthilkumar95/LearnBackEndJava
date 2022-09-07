package com.improve.programming.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TicToeGame {
    public void startGame() {
        int inCount = 9;
        boolean xPlayer = true;
        char[][] charMatrix = new char[3][3];
        Map<Integer, Integer> componentMap = new HashMap<>();
        for(int i=0; i<8; i++) {
            componentMap.put(i,0);
        }
        int position = 0;
        while(inCount>0) {
            position = getInput(xPlayer);
            int row = position / 10;
            int column = position % 10;
            if(xPlayer) {
                charMatrix[row][column] = 'x';
            } else {
                charMatrix[row][column] = 'o';
            }
            boolean result = check(charMatrix,componentMap,row,column,xPlayer);
            if(result) {
                if(xPlayer) {
                    System.out.println("Player X won");
                } else {
                    System.out.println("Player O Won");
                }
                break;
            } else {
                for(int j=0; j<charMatrix.length; j++){
                    System.out.println(Arrays.toString(charMatrix[j]));
                }
            }
            inCount--;
            xPlayer = !xPlayer;
        }
        System.out.println("Match Draw");
    }
    public int getInput(boolean xPlayer) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<Integer> getInput = () -> {
            if(xPlayer) {
                System.out.println("X player enter the position :");
            } else {
                System.out.println("O player enter the position :");
            }
            Scanner scanner = new Scanner(System.in);
            int threadPosition = scanner.nextInt();
            return threadPosition;
        };
        Future<Integer> output = executorService.submit(getInput);
        try {
            Thread.sleep(30000);
            if(!output.isDone()) {
                System.out.println("NO Input from players");
                System.exit(1);
            } else {
                return output.get();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    // component check
    // row, column, diagonal -> component
    // component number , component count
    // count = 3, component check and winner
    // component overlap -> 3 + 3 + 2
    // add for x and subtract for 0
    public boolean check(char[][] charMatrix, Map<Integer,Integer> compMap, int row, int column, boolean xPlayer) {
        // diagonal -> 00, 22, 20, 02, 11
         // 00, 11, 22
        // 20,11,02 -> 2
        // row -> 0,1,2 // column -> 3,4,5 // diagonal -> 6,7
        if(xPlayer) {
            int count = compMap.get(row) +1;
            if(count ==3) {
                return true;
            } else {
                compMap.put(row,count);
            }
            count = compMap.get(column+3) + 1;
            if(count == 3) {
                return true;
            } else {
                compMap.put(column+3,count);
            }
            int diagonal = checkDiagonal(row,column);
            if(diagonal == -1) {
                return false;
            } else {
                if(diagonal == 2) {
                    count = compMap.get(6) + 1;
                    if(count == 3) {
                        return true;
                    } else {
                        compMap.put(6,count);
                    }
                    count = compMap.get(7) + 1;
                    if(count == 3) {
                        return true;
                    } else {
                        compMap.put(7,count);
                    }
                } else {
                    count = compMap.get(diagonal+6) + 1;
                    if(count == 3) {
                        return true;
                    } else {
                        compMap.put(diagonal+6,count);
                    }
                }
            }
            return false;
        } else {
            int count = compMap.get(row)-1;
            if(count == -3) {
                return true;
            } else {
                compMap.put(row,count);
            }
            count = compMap.get(column+3) - 1;
            if(count == -3) {
                return true;
            } else {
                compMap.put(column+3,count);
            }
            int diagonal = checkDiagonal(row,column);
            if(diagonal == -1) {
                return false;
            } else {
                if(diagonal == 2) {
                    count = compMap.get(6) - 1;
                    if(count == -3) {
                        return true;
                    } else {
                        compMap.put(6,count);
                    }
                    count = compMap.get(7) - 1;
                    if(count == -3) {
                        return true;
                    } else {
                        compMap.put(7,count);
                    }
                }
                count = compMap.get(diagonal+6) - 1;
                if(count == -3) {
                    return true;
                } else {
                    compMap.put(diagonal+6,count);
                }
            }
            return false;
        }
    }

    public int checkDiagonal(int row, int column) {
        if(row == column) {
            if(row == 1) {
                return 2;
            } else {
                return 0;
            }
        } else if(row + column == 2) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        TicToeGame ticToeGame = new TicToeGame();
        ticToeGame.startGame();
    }
}
