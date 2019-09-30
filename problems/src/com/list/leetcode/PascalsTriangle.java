package com.list.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> result = generateTriangle(7);
        List<Integer>result1 = getRow(3);
        result1.stream().forEach(System.out::println);
    }

    private static List<List<Integer>> generateTriangle(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, numRows);
        return result;
    }

    private static void helper(List<List<Integer>> result, int numRows) {
        if(numRows == 1) result.add(Arrays.asList(1));
        else{
            helper(result, numRows - 1);
            List<Integer> prevList = result.get(numRows - 2);
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < prevList.size(); i ++){
                if(i == 0) temp.add(prevList.get(i));
                if(i > 0) temp.add(prevList.get(i) + prevList.get(i - 1));
                if(i == prevList.size() - 1) temp.add(1);
            }
            result.add(temp);
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i < rowIndex+1; i++){
            list.add(0, 1);
            for(int j = 1; j < list.size() - 1; j++){
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}
