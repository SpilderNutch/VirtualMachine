package com.yutian.Boxing;

import javax.swing.*;

public class Boxing {



    public void testBoxing(){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println((a+b) == c);
        System.out.println(c.equals(a+b));
        System.out.println(g == (a+b));
        System.out.println(g.equals(a+b));

        StringBuffer stringBuffer = new StringBuffer();


    }

    public static void main(String[] args){
       new Boxing().testBoxing();

    }




}
