package com.java.practice.puzzles.string;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class SearchString {
    public static void main(String[] str) {

        ArrayList<Data> list = new ArrayList<>();

        String searchString = "abc";

        String[] val = {"fabcsdf", "asdfabc", "dfadsfsdfabc", "abckdf", "ddfabc", "fabcsdf"};

        for (String str1 : val) {
            Data data = new SearchString().new Data();
            data.setIndex(str1.indexOf(searchString));
            data.setValue(str1);

            list.add(data);
        }

        Collections.sort(list, Comparator.comparingInt(Data::getIndex));

        System.out.println(list);


    }

    class Data {
        int index;
        String value;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String toString() {
            return index + " " + value;
        }
    }
}
