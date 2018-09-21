package com.yutian.classLoader;

public class SubClass extends  SuperClass{

    static {
        System.out.println("SubClass inited.");
    }

    public static int B = value;

}
