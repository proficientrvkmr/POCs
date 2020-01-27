package com.java.practice.puzzles;

public class BinaryArraySort {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1};

        System.out.println("Input: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

        System.out.println("\n\nSorted: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
