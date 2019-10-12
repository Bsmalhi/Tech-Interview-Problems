package com.leetcode.math;

public class PowerCalculate {
    public static void main(String[] args) {
        int x = 2, n = -10;
        System.out.println(x + " to the power "+ n + " is " + myPow(x, n));
        System.out.println(x + " to the power "+ n + " is " + calcPow(x, n));
    }

    private static double calcPow(double x, int n) {
        long N = n;
        if(n < 0){
            N = -N;
            x = 1/x;
        }
        double ans = 1;
        for(int i =0; i < N; i++){
            ans = ans * x;
        }
        return ans;
    }
    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return helper(x, N);
    }

    private static double helper(double x, long N){
        if(N == 0)
            return 1.0;
        double half = helper(x, N/2);
        if(N % 2 == 0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}
