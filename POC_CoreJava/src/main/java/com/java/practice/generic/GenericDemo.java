package com.java.practice.generic;

public class GenericDemo {
    public static void main(String[] args) {

        //Case 1
        RaviGenericClass<Integer, Integer, String, String> raviObj = new RaviGenericClass<>();
        raviObj.setValue(27);
        System.out.println(raviObj.getValue());
        System.out.println(raviObj.convertObjT2(4));
        System.out.println(raviObj.convertObjT3("Generics"));

        //Case 2
        RaviGenericClass<String, String, String, String> raviObj2 = new RaviGenericClass<>();
        raviObj2.setValue("SRK");
        System.out.println(raviObj2.getValue());
        System.out.println(raviObj2.convertObjT2("RRR"));
        System.out.println(raviObj2.convertObjT3("DDDD"));

        //Case 3
        RaviGenericClass<Long, Long, Long, Long> raviObj3 = new RaviGenericClass<>();
        raviObj3.setValue(30000l);
        System.out.println(raviObj3.getValue());

        //Case 4
        RaviGenericClass<Double, Double, Double, Double> raviObj4 = new RaviGenericClass<>();
        raviObj4.setValue(344444444.444);
        System.out.println(raviObj4.getValue());

    }
}
