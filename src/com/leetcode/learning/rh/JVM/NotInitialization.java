package com.leetcode.learning.rh.JVM;

class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }
    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
    public static int value1 = 1234;
}
/**
 * 非主动使用类字段演示
 **/
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
        System.out.println(SubClass.value1);
    }
}
