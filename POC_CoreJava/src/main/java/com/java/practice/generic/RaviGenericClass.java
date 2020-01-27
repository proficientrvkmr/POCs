package com.java.practice.generic;

public class RaviGenericClass<T1, T2, T3, T4> {

    private T1 t;

    public T1 getValue() {
        return t;
    }

    public void setValue(T1 t) {
        System.out.println(t);
    }

    public T3 convertObjT2(T2 t2) {
        return (T3) (t2 + " converted");
    }

    public T4 convertObjT3(T3 t3) {
        return (T4) (t3 + " converted");
    }

    <P> P[] toArray(P[] a) {
        return null;
    }
}
