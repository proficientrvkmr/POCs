package com.java.practice.puzzles.string;

public class PairCheck {

    static String twoStrings(String s1, String s2) {
        String pair = "No";
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    pair = "Yes";
                }
            }
        }
        return pair;
    }

    public static void main(String[] str) {
        System.out.println(PairCheck.twoStrings("hello", "world"));
        System.out.println(PairCheck.twoStrings("hi", "world"));
        System.out.println(PairCheck.twoStrings("ab", "heloab"));
        System.out.println(PairCheck.twoStrings("hlasdfadfd", "kjlhkh"));
        System.out.println(PairCheck.twoStrings(" ", ""));
    }
}
