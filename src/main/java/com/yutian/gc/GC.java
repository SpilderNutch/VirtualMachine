package com.yutian.gc;

import org.junit.Test;

/**
 * 以下代码是用于测试GC
 */
public class GC {

    public Object instance = null;
    private static final int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2 *_1MB];

    @Test
    //-XX:+PrintGCDetails 添加GC打印语句
    public void testGC(){
        System.gc();
    }

    @Test
    public void testRefrenceGC(){
        GC objA = new GC();
        GC objB = new GC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        System.gc();
    }


    /**
     *
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGaCDetails
     *
     */
    @Test
    public void gcMemory(){
        final int _1MB = 1024*1024;
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocation3 = new byte[2*_1MB];
        allocation4 = new byte[4*_1MB];


    }


}
