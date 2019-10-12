package com.leetcode.recursion;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 44;
        System.out.println(climbingStairs(n));
    }

    private static int climbingStairs(int n) {
        int memo [] = new int[n + 1];
        return climbingStairs(0, n, memo);
    }

    private static int climbingStairs(int i, int n, int[] memo) {
        if(i > n)
            return 0;
        if(i == n)
            return 1;
        if(memo[i] > 0){
            return memo[i];
        }
        memo[i] = climbingStairs(i + 1, n, memo) + climbingStairs(i + 2, n, memo);
        return memo[i];
    }
}
