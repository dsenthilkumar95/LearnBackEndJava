package com.improve.programming.medium;

public class DivideWithoutMulDivOperations {
    // solution not complete still have doubt on how Integer.MIN_VALUE/Integer.MIN_VALUE will be carried out.
    
    public int divide(int dividend, int divisor) {
        if(dividend==divisor){
            return 1;
        }
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int quotient = 0;
        while(absDividend >= absDivisor) {
            int shiftCount = 0;
            int divMul = absDivisor;
            while (absDividend >= divMul) {
                divMul = divMul << 1;
                shiftCount++;
            }
            divMul = divMul >> 1;
            shiftCount--;
            absDividend = absDividend - divMul;
            quotient += 1 << shiftCount;
        }
        if(Integer.signum(dividend)==Integer.signum(divisor)) {
            return quotient;
        } else {
            return -quotient;
        }
    }

    public int divide1(int dividend, int divisor) {
        int quotient=0;
        if(Integer.signum(dividend) == Integer.signum(divisor)) {
            if(Integer.signum(dividend)==-1) {
                while(dividend <= divisor){
                    int shiftCount=0;
                    int mul = divisor;
                    while(dividend <= mul){
                        if(Integer.signum(mul) == Integer.signum(mul << 1)) {
                            mul = mul << 1;
                            shiftCount++;
                        } else {
                            break;
                        }
                    }
                    mul = mul >> 1;
                    shiftCount--;
                    dividend -= mul;
                    if(Integer.signum(1 << shiftCount)==1 && Integer.signum(quotient+(1<<shiftCount))==1) {
                        quotient += 1 << shiftCount;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                return quotient;
            } else {
                while(dividend >= divisor){
                    int shiftCount=0;
                    int mul = divisor;
                    while(dividend >= mul){
                        if(Integer.signum(mul) == Integer.signum(mul << 1)) {
                            mul = mul << 1;
                            shiftCount++;
                        } else {
                            break;
                        }
                    }
                    mul = mul >> 1;
                    shiftCount--;
                    dividend -= mul;
                    if(Integer.signum(1 << shiftCount)==1 && Integer.signum(quotient+(1<<shiftCount))==1) {
                        quotient += 1 << shiftCount;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                return quotient;
            }
        } else {
            if(Integer.signum(dividend)==-1) {
                while(dividend <= divisor){
                    int shiftCount=0;
                    int mul = divisor;
                    while(dividend <= mul){
                        if(Integer.signum(mul) == Integer.signum(mul << 1)) {
                            mul = mul << 1;
                            shiftCount++;
                        } else {
                            break;
                        }
                    }
                    mul = mul >> 1;
                    shiftCount--;
                    dividend -= mul;
                    if(Integer.signum(1 << shiftCount)==1 && Integer.signum(quotient+(1<<shiftCount))==1) {
                        quotient += 1 << shiftCount;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                return quotient;
            } else {
                while(dividend >= divisor){
                    int shiftCount=0;
                    int mul = divisor;
                    while(dividend >= mul){
                        if(Integer.signum(mul) == Integer.signum(mul << 1)) {
                            mul = mul << 1;
                            shiftCount++;
                        } else {
                            break;
                        }
                    }
                    mul = mul >> 1;
                    shiftCount--;
                    dividend -= mul;
                    if(Integer.signum(1 << shiftCount)==1 && Integer.signum(quotient+(1<<shiftCount))==1) {
                        quotient += 1 << shiftCount;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                return quotient;
            }
        }
    }

    public static void main(String[] args) {
        DivideWithoutMulDivOperations divOperations = new DivideWithoutMulDivOperations();
        System.out.println(Integer.MIN_VALUE<<1);
//        System.out.println(divOperations.divide(-50,5));
//        System.out.println(Math.abs(Integer.MIN_VALUE-1));
    }
}
