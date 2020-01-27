package com.java.practice.stream;

import java.util.Arrays;
import java.util.List;

public class MapToIntExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(21, 32, 43, 55, 42, 33, 23, 23, 35, 25, 13);
        int sum = sumIterator(integerList);

        System.out.println("sum = " + sum);
        System.out.println("Palindrome: " + isPalindrome(898));
    }

    public static boolean isPalindrome(int num) {
        int rev_num = 0;
        int tempNum = num;
        while (tempNum > 0) {
            rev_num = rev_num * 10 + tempNum % 10;
            tempNum = tempNum / 10;
        }
        return num == rev_num;
    }

    private static int sumIterator(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
