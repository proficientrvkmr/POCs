package com.java.practice.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface PersonMood {

    boolean isHappy() default true;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface PersonInfo {

    Priority priority() default Priority.MEDIUM;

    String[] skillSet() default "Java";

    String currentWorkingIn() default "At Home";

    String sinceWorkingFrom() default "03/05/2014";

    enum Priority {
        LOW, MEDIUM, HIGH
    }

}

@PersonInfo(
        priority = PersonInfo.Priority.HIGH,
        currentWorkingIn = "IRIS Software",
        sinceWorkingFrom = "07/02/2018",
        skillSet = {"Java", "Spring Cloud", "Micro Service"}
)
class RaviInOffice {

    @PersonMood
    void raviMood() {
//        if (true)
//            throw new RuntimeException("Didn't have any answer.");
    }
}

public class MyCustomAnnotation {

    public static void main(String[] args) throws Exception {

        System.out.println("Start Reading Info ...");

        Class<RaviInOffice> obj = RaviInOffice.class;

        // Process @RKushInfo
        System.out.printf("%nRavi Info ###################");
        if (obj.isAnnotationPresent(PersonInfo.class)) {

            Annotation annotation = obj.getAnnotation(PersonInfo.class);
            PersonInfo raviData = (PersonInfo) annotation;

            System.out.printf("%nCurrent WorkingIn :%s", raviData.currentWorkingIn());
            System.out.printf("%nSince Working From :%s", raviData.sinceWorkingFrom());
            System.out.printf("%nCurrent Priority :%s", raviData.priority());
            System.out.printf("%nSkillsSet :");

            int skillCount = raviData.skillSet().length;
            for (String skill : raviData.skillSet()) {
                if (skillCount > 1) {
                    System.out.print(skill + ", ");
                } else {
                    System.out.print(skill);
                }
                skillCount--;
            }
            System.out.printf("%n%n");
        }

        System.out.println("Ravi's Today Mood ###################");

        // Process @RkushHappy
        for (Method method : obj.getDeclaredMethods()) {

            if (method.isAnnotationPresent(PersonMood.class)) {
                Annotation annotation = method.getAnnotation(PersonMood.class);
                PersonMood raviMood = (PersonMood) annotation;

                if (raviMood.isHappy()) {
                    System.out.println("Congratulation !!! Today Ravi is happy in office.");
                } else {
                    System.out.println("Sorry, Today Ravi is not happy.");
                }
            }
        }
    }

}