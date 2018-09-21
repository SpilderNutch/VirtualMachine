package com.yutian.classLoader;

/**
 * 父类
 */
public class SuperClass {

    public static int value = 123;

    static{
        System.out.println("SuperClass inited.");
        value = 1234;
    }


}
