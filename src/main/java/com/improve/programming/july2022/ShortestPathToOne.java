package com.improve.programming.july2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestPathToOne {
    public static Node head = new Node(0);

    public int[] countSteps(int input) {
        int[] minSteps = new int[input+2];
        for(int i=1; i<input+1; i++) {
            minSteps[i]=countRecursively(i,minSteps,0);
        }
        return minSteps;
    }

    public int countRecursively(int num, int[] minSteps, int depth) {
        System.out.println("num -> " + num + " depth -> " + depth);
        if(num <=1) {
            return depth;
        }
        if(minSteps[num]>0) {
            return minSteps[num] + depth;
        }
        if(num %2 == 0) {
            return countRecursively(num/2, minSteps,depth+1);
        } else {
            return Math.min(countRecursively(num-1,minSteps,depth+1),
                    countRecursively(num+1,minSteps,depth+1));
        }
    }

    public static int solutionWithMemory(String x) {
        int[] num = new int[x.length()+1];
        for(int i=1; i<x.length()+1; i++) {
            num[i] = Character.getNumericValue(x.charAt(i-1));
        }
        int[] looper = {0,1};
        while(!Arrays.equals(looper, num)) {
            countRecursivelyArray(looper, 0,0);
            looper = add(looper);
            System.out.println("looper -> " + Arrays.toString(looper));
        }
        return countRecursivelyArray(num,0,0);
    }

    public static int countRecursivelyArray(int[] num, int depth, int validFrom) {
        System.out.println("num -> " + Arrays.toString(num) + " depth -> " + depth + " validFrom -> " + validFrom);
        if (num.length - validFrom == 2 && num[num.length-1] == 1) {
            return depth;
        }
        int shorter = getShortest(num);
        if(shorter > 0) {
            return shorter + depth;
        }
        int shortest;
        if(num[num.length-1]%2 == 0) {
            int[] ref = Arrays.copyOf(num,num.length);
            validFrom = divide(ref,validFrom) - 1;
            int[] divArray = Arrays.copyOfRange(ref,validFrom,ref.length);
            shortest = countRecursivelyArray(divArray,depth+1,0);
        } else {
            int[] minusOne = Arrays.copyOfRange(num,validFrom,num.length);
            minusOne[minusOne.length-1] = minusOne[minusOne.length-1] - 1;
            int minusShortest = countRecursivelyArray(minusOne,depth+1,0);
            int[] plusOne = Arrays.copyOfRange(num,validFrom,num.length);
            plusOne = add(plusOne);
            int plusShortest = countRecursivelyArray(plusOne,depth+1,0);
            shortest = Math.min(minusShortest, plusShortest);
        }
        if(depth == 0) {
            setShortest(num,shortest);
        }
        return shortest;
    }

    public static int solution(String x) {
        int[] num = new int[x.length()+1];
        for(int i=1; i<x.length()+1; i++) {
            num[i] = Character.getNumericValue(x.charAt(i-1));
        }
        return countRecursivelyArrayWithoutMemory(num,0,0);
    }

    public static int countRecursivelyArrayWithoutMemory(int[] num, int depth, int validFrom) {
        if (num.length - validFrom < 3 && num[num.length-1] < 2) {
            return depth;
        }
        if(num[num.length-1]%2 == 0) {
            validFrom = divide(num,validFrom) - 1;
            int[] divArray = Arrays.copyOfRange(num,validFrom,num.length);
            return countRecursivelyArrayWithoutMemory(divArray,depth+1,0);
        } else {
            int[] minusOne = Arrays.copyOfRange(num,validFrom,num.length);
            minusOne[minusOne.length-1] = minusOne[minusOne.length-1] - 1;
            int minusShortest = countRecursivelyArrayWithoutMemory(minusOne,depth+1,0);
            int[] plusOne = Arrays.copyOfRange(num,validFrom,num.length);
            plusOne = add(plusOne);
            int plusShortest = countRecursivelyArrayWithoutMemory(plusOne,depth+1,0);
            return Math.min(minusShortest, plusShortest);
        }
    }

    public static int countStraight(int[] num, int depth, int validFrom) {
        if (num.length - validFrom < 3 && num[num.length-1] < 2) {
            return depth;
        }
        if(num[num.length-1]%2 == 0) {
            validFrom = divide(num,validFrom) - 1;
            int[] divArray = Arrays.copyOfRange(num,validFrom,num.length);
            return countRecursivelyArrayWithoutMemory(divArray,depth+1,0);
        } else {
            int[] minusOne = Arrays.copyOfRange(num,validFrom,num.length);
            minusOne[minusOne.length-1] = minusOne[minusOne.length-1] - 1;
            int minusShortest = countRecursivelyArrayWithoutMemory(minusOne,depth+1,0);
            int[] plusOne = Arrays.copyOfRange(num,validFrom,num.length);
            plusOne = add(plusOne);
            int plusShortest = countRecursivelyArrayWithoutMemory(plusOne,depth+1,0);
            return Math.min(minusShortest, plusShortest);
        }
    }

    public static int divide(int[] num, int validFrom) {
        int rem=0;
        int inter;
        boolean numNotFound = true;
        for(int i=validFrom; i<num.length; i++) {
            inter = (rem*10) + num[i];
            num[i] = inter/2;
            rem = inter%2;
            if(numNotFound) {
                if (num[i] > 0) {
                    numNotFound = false;
                } else if (num[i] == 0) {
                    validFrom++;
                }
            }
        }
        return validFrom;
    }

    public static int[] add(int[] num) {
        int ans = num[num.length-1] + 1;
        int carryover = ans / 10;
        num[num.length-1] = ans % 10;
        for(int i=num.length-2; i>-1; i--) {
            if(carryover == 0) {
                break;
            }
            ans = num[i] + carryover;
            carryover = ans / 10;
            num[i] = ans % 10;
        }
        if(num[0] != 0) {
            num = copyArray(num);
        }
        return num;
    }

    public static int[] copyArray(int[] num) {
        int[] out = new int[num.length+1];
        for(int i=0; i<num.length; i++) {
            out[i+1] = num[i];
        }
        return out;
    }

    public static void setShortest(int[] num, int shortest) {
        Node ref = head;
        for(int i=1; i<num.length; i++) {
            Node itel = ref.getNodeMap().get(num[i]);
            if(null == itel) {
                Node inter = new Node(num[i]);
                ref.getNodeMap().put(num[i],inter);
                ref = inter;
            } else {
                ref = itel;
            }
        }
        ref.setValue(shortest);
    }

    public static int getShortest(int[] num) {
        Node ref = head;
        for(int i=1; i<num.length; i++) {
            Node intl = ref.getNodeMap().get(num[i]);
            if(null == intl) {
                return 0;
            } else {
                ref = intl;
            }
        }
        return ref.getValue();
    }

    public static void main(String[] args) {
//        ShortestPathToOne shortestPathToOne = new ShortestPathToOne();
//        int[] minSteps = new int[123];
//        System.out.println("-----------------------------------------------------------");
//        System.out.println("-----------------------------------------------------------");
//        int[] out = new int[102];
//        for(int i=1; i<101; i++) {
//            System.out.println("String value " + String.valueOf(i));
//            out[i] = ShortestPathToOne.solutionWithMemory(String.valueOf(i));
//            for(Integer k : head.getNodeMap().keySet()) {
//                System.out.println(k + " -> " +  head.getNodeMap().get(k).getValue());
//            }
//        }
//        int[] countSteps = shortestPathToOne.countSteps(100);
//        System.out.println(Arrays.toString(countSteps));
//        System.out.println(Arrays.toString(out));
//        System.out.println(Arrays.equals(out,countSteps));

        System.out.println(ShortestPathToOne.solution("4"));
        System.out.println(ShortestPathToOne.solution("15"));
        System.out.println(ShortestPathToOne.solutionWithMemory("15"));
    }
}

class Node {
    private int id;
    private int value = 0;
    private Map<Integer, Node> nodeMap = new HashMap<>();
    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Map<Integer, Node> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(Map<Integer, Node> nodeMap) {
        this.nodeMap = nodeMap;
    }
}
