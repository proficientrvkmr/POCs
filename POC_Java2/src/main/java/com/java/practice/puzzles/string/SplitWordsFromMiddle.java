package com.java.practice.puzzles.string;

public class SplitWordsFromMiddle {

    public static void main(String[] str) {
        String givenString = "Hello I am Mike Saunders";
        String[] words = givenString.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String val : words) {
            if (val.length() >= 4 && val.length() % 2 == 0) {
                int index = val.length() / 2;
                stringBuilder.append(val.substring(0, index));
                stringBuilder.append(" ");
                stringBuilder.append(val.substring(index, val.length()));
            } else {
                stringBuilder.append(val);
            }
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder);
    }
}
