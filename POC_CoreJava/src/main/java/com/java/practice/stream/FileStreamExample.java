package com.java.practice.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileStreamExample {

    public static void main(String[] args) throws IOException {

        Object[] stringList = Files.lines(Paths.get("C:\\Users\\ravi.kushwah\\Documents\\Spring REST Index.txt"))
                .toArray();
//                .collect(Collectors.toList());

        IntStream intStream = Stream.of(stringList).flatMapToInt(obj -> Arrays.stream((int[]) obj));
        System.out.println("Total Lines:: " + stringList.length);
//        stringList(System.out::println);
        System.out.println(stringList);

//        A.print();
//        B b = new B();
//        b.print();
    }

}
//interface A {
//     static void print(){
//        System.out.println("od");
//    }
//}
//class B implements A {
//    static void print(){
//        System.out.println("dfd");
//    }
//}