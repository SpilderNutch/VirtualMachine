package com.yutian.classLoader;

//动态分派。
public class DynamicDispatch {


    static abstract class Human{
        protected abstract void sayHello();
    };

    static class Man extends Human{
        protected void sayHello(){
            System.out.println("Man say Hello!");
        }
    }

    static class Womon extends Human{
        protected void sayHello(){
            System.out.println("Woman say Hello!");
        }
    }


    public static void main(String[] args){
        Human man = new Man();
        Human women = new Womon();
        man.sayHello();
        women.sayHello();

    }

}
