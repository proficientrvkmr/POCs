package com.java.practice.designpatterns;

import java.io.Serializable;

public class SingletonPattern {

    public static void main(String[] args) {
        SingletonDemo objOne = SingletonDemo.getInstance();
        SingletonDemo objTwo = SingletonDemo.getInstance();
        SingletonDemo objThree = null;
        try {
            objThree = (SingletonDemo) Class.forName("SingletonDemo").newInstance();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(objOne.equals(objTwo));
        System.out.println(objOne.equals(objThree));

        try {
            SingletonDemo dd = (SingletonDemo) objTwo.clone();
            System.out.println(dd);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    static class SingletonDemo implements Serializable {
        private static final long serialVersionUID = 1L;

        private SingletonDemo() {
            // prevent here from create object by REFLECTION
            if (SingletonHolder.INSTANCE != null) {
                throw new RuntimeException("Singleton class can't have more than one object.");
            }
        }

        public static SingletonDemo getInstance() {
            return SingletonHolder.INSTANCE;
        }

        protected Object readResolve() {
            return getInstance();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();

        }

        private static class SingletonHolder {
            public static final SingletonDemo INSTANCE = new SingletonDemo();
        }
    }

}
