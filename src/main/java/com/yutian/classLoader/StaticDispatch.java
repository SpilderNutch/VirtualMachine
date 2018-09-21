package com.yutian.classLoader;

//考察关于类重载的信息。Human/Man/Woman均为static,而Human是静态类型或者是外观类型（Apparent Type）；
//Man是变量的实际类型。静态类型的变化是仅在使用时发生，变量本省的静态类型不会被改变，并且最终的静态变量在编译期间是可知的。
//而实际类型变化结果只有在运行期间才可确定。
public class StaticDispatch {

    abstract static class Human{};

    static class Man extends Human{

    }

    static class Womon extends Human{

    }

    public void sayHello(Human human){
        System.out.println("Hello Human .");
    }
    public void sayHello(Man man){
        System.out.println("Hello man .");
    }
    public void sayHello(Womon womon){
        System.out.println("Hello women .");
    }

    //由于是static，代码在编译器编译期间被指定为Human类型。
    public static void main(String[] args){
        StaticDispatch sd = new StaticDispatch();
        Human man = new Man();
        Human women = new Womon();
        sd.sayHello(man);
        sd.sayHello(women);

    }







}
