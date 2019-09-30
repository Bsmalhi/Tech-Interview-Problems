package com.recursion.leetcode;

import java.util.HashMap;

public class FibonacciNumbers {
    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Fibonacci Number at 3: " + FibNum(n) );
    }

    private static int FibNum(int n) {
        if(n < 2)
            return n;
        int result;
        if(map.containsKey(n))
            return map.get(n);
        else
            result = FibNum(n - 1) + FibNum(n - 2);
        map.put(n, result);
        return result;
    }
}
