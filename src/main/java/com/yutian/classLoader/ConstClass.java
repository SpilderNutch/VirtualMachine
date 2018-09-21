package com.yutian.classLoader;

public class ConstClass {

    static {
        System.out.println("ConstantClass init!");
    }

    public static final String HELLOWORLD = "helloWorld big boy!";

}
