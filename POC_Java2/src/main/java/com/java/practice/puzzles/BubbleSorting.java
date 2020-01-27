package com.java.practice.puzzles;

public class BubbleSorting {

    /**
     * Not complete code. Wrong output
     */
    public static void main(String[] args) {
//        int[] arr = {2, 45, 6, 6, 3, 7, 8, 5, 4, 8, 1, 10};
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        printArray(arr, arr.length);
        System.out.println();
        bubbleSort(arr, arr.length);
        printArray(arr, arr.length);

    }

    private static void printArray(int[] arr, int length) {
        for (int i = 0; i < length; i++)
            System.out.print(arr[i] + " ");

    }

    private static void bubbleSort(int[] arr, int length) {
        for (int i = 0; i < length - 1; i++)
            bubble(arr, i);
    }

    private static void bubble(int[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[i] < arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
