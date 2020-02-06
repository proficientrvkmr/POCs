package com.java.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMapExample1 {
    public static void main(String[] args) {
        List<User> userList = Arrays.asList(
                new User("Ram", 23, Arrays.asList("3", "4")),
                new User("Shyam", 43, Arrays.asList("5", "6", "7")),
                new User("Radha", 33, Arrays.asList("8", "9"))
        );

        List<List<String>> collectLost = userList.stream()
                .map(User::getPhoneNumbers)
                .collect(Collectors.toList());

        collectLost.forEach(System.out::println);

        userList.forEach(
                user -> user.getPhoneNumbers().stream()
                        .filter(phone -> phone.equals("5"))
                        .map(phone -> user)
                        .forEachOrdered(System.out::println)
        );

        Optional<String> phoneNos = userList.stream().map(user -> user.getPhoneNumbers())
                .flatMap(phoneNoList -> phoneNoList.stream())
                .filter(p -> p.equals("5"))
                .findAny();

        phoneNos.ifPresent(System.out::println);

    }

    private static class User {
        private String name;
        private int age;
        private List<String> phoneNumbers;

        public User(String name, int age, List<String> phoneNumbers) {
            this.name = name;
            this.age = age;
            this.phoneNumbers = phoneNumbers;
        }

        @Override
        public String toString() {
            return "Name: " + name + " Age: " + age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }
    }
}
