package com.java.practice.puzzles;

/**
 * Rotate Array in Clock-Wise direction.
 */
public class RotateAnArray {

    public static void main(String[] args) {
        int arr[] = {2, 4, 2, 54, 7, 1};
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            System.out.println("Array, Rotating after for " + i + "th position: ");

            for (int j = 0; j < i; j++) {

                int temp = arr[n - 1];
                int lastIndex = n - 1;
                while (lastIndex > 0) {
                    arr[lastIndex] = arr[lastIndex - 1];
                    lastIndex--;
                }
                arr[0] = temp;
            }

            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }

            System.out.println();

        }
    }
}
