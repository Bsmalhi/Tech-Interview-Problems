package com.companies;

import java.util.Arrays;

public class Zoox {
    public static void main(String[] args) {
        String input = "interview";
//        System.out.println(printAscending(input));
        System.out.println(reverseWord("hello world"));
        String line = "1 2 3";
        String [] in = line.split(" ");
//        System.out.println(fibonacciNumber(in));
        System.out.println(printPercentage("0....."));
    }

    private static int printPercentage(String s) {
        double count1 = 1, count2 =0;
        int length = s.length();
        char a = s.charAt(0);
        char[] c = s.toCharArray();
        for(int i= 1; i < c.length; i++){
            if(c[i] == a){
                count1 ++;
            }else{
                count2 ++;
            }
        }
        System.out.println(count1);
        int n = (int) Math.round((count1/length) * 100);
        return n;
    }

    private static int fibonacciNumber(String[] input) {
        int a = Integer.valueOf(input[0].trim());
        int b = Integer.valueOf(input[1].trim());
        int n = Integer.valueOf(input[2].trim());

        if(n <= 1){
            return n;
        }
        for(int i = 2; i < n; i++){
            int temp = b;
            b += a;
            a = temp;
        }
        return b;
    }

    private static String reverseWord(String str) {
        StringBuilder result = new StringBuilder();
//        String [] strArray = str.split(" ");
        for(String temp: str.split(" ")){
            char [] c = temp.toCharArray();
            reverseArray(c);
            result.append(String.valueOf(c));
            result.append(" ");
        }
        return result.toString().trim();
    }

    private static String printAscending(String input) {
        char [] arr = input.toCharArray();

        Arrays.sort(arr);
        reverseArray(arr);

        String.valueOf(arr);
        return "";
    }

    private static void reverseArray(char[] arr) {
        int i = 0, j = arr.length -1;
        while(i < j){
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
    }
}
