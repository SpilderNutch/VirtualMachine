package com.yutian.memArea;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 一下代码用于测试内存数据
 */
public class Memory {

    /**
     * java.lang.OutOfMemoryError 内存溢出
     * -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
     *
     */
    @Test
    public void testHeapMemory(){
        List<String> list = new ArrayList<String>();

        while(true){
            list.add(new String("orginal"));
        }

    }


    /**
     * 测试栈运行情况
     *
     * java.lang.StackOverflowError
     */
    @Test
    public void testHeap(){

        int stackLength = 0;
        stackLength ++;
        while(true){
            System.out.println(stackLength);
            testHeap();
        }
    }



    /**
     * 测试常量池内存溢出异常
     * 设置最大常量池d大小10M
     * -XX:PermSize=1M -XX:MaxPermSize=1M
     * 测试数据未成功
     * OutOfMemory:PermGen space,常量池内存溢出
     */
    @Test
    public void testPerm(){

        List<String> list = new ArrayList<String>();
        int i=0;
        while(true){
            System.out.println(String.valueOf(i++).intern());
            list.add(String.valueOf(i++).intern());
        }
    }



    /**
     * 测试方法区内存溢出异常
     * 设置最大常量池d大小10M
     * -XX:PermSize=1M -XX:MaxPermSize=1M
     * 测试数据未成功
     * OutOfMemory:PermGen space,常量池内存溢出
     */
    @Test
    public void testMethodArea(){

        class OMAObjct{
            Object o;
            public OMAObjct(){

            }

            public OMAObjct(Object o){
                this.o = o;
            }
        }

        while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OMAObjct.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
            enhancer.create();
        }
    }


    //直接内存溢出异常，与方法区数据类似

}
