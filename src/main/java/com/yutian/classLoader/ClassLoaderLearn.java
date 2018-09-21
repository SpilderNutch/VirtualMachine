package com.yutian.classLoader;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import org.junit.Test;

/**
 * 以下所有代码均为了深刻理解ClassLoader的一些精髓
 * 知识点：1，虚拟机只认二进制class流，无论何种文件形式。
 * 2，无符号数属于基本的数据类型，以u1,u2代表1个字节、2个字节。
 * 3，魔数是认知这是一个.class为后缀的文件。oxCAFFBABY
 * 4,常量引用：1，类和权限定名，2，字段的名称和标识符，3，方法的名称和描述符
 */
public class ClassLoaderLearn {
    //类加载过程，加载-》验证-》准备-》解析-》初始化-》使用-》卸载
    //虚拟机规范明确规定，有且只有一下4中情况对类进行初始化
    //1,new、getstatic、putstatic、invokestatic4条字节码指令，如果类没初始化，则先触发其初始化。
    //2,使用java.lang.reflect包方法对类进行反射调用，如果没有对类进行初始化，则先触发其初始化。
    //3,当初始一个类的时候，发现其父类没有初始化，则必须触发其父类初始化。
    //4,当虚拟机启动时，用户指定要执行一个类（包含main()方法的那个类），虚拟机则先触发其初始化。

    @Test
    public void testClassInit1(){
        //System.out.println(SubClass.value); 只会初始化父类，不会对类进行初始化
        //当子类对象new,对象将被初始化。
        SubClass subClass = new SubClass();
        System.out.println(subClass.value);
    }


    @Test
    public void testConstant(){
        //当常量字符被定义为final的时候，常量在编译阶段存入调用类的常量池中，本质上
        //并没有直接定义常量的类，因此不会触发定义常量类的初始化
        System.out.println(ConstClass.HELLOWORLD);
    }

    //clinit类构造器，当类被初始化了，其父类全部已经被初始化了；当一个接口被初始化了，并不要其父类接全部完成初始化，只有
    //真正使用的接口，才会完成初始化。
    //类加载的阶段，需要完成3件事情，1，根据全限定名来获取此类的二进制字节流；2，将字节流转换为方法去运行的数据结构。
    //3,在JAVA堆中生成一个代表这个类的java.lang.Class对象，作为方法区这些数据的访问接口。



    @Test
    public void testClassInit2(){
        //System.out.println(SubClass.value); 只会初始化父类，不会对类进行初始化
        //当子类对象new,对象将被初始化。

        System.out.println(SubClass.B);
    }

    //关于2个类相等，那么必须满足，来源于同一个JAVA二进制文件和加载类的类加载器相同。

    @Test
    public void testClassDifferent() throws Exception{

        Object customObj = new CustomClassLoader().loadClass("com.yutian.classLoader.ClassLoaderLearn").newInstance();

        //ClassLoaderLearn obj = new ClassLoaderLearn();

        System.out.println(customObj instanceof com.yutian.classLoader.ClassLoaderLearn);

    }

    //双亲委派模型，boostrap ClassLoader,负责加载<JAVA_HOME>/lib目录中。
    //扩展类加载器，Extension ClassLoader,负责加载<JAVA_HOME>/lib/ext目录中，或者java.ext.dirs系统变量指定的路径下所有类库。
    //Application ClassLoader，应用程序类加载器。这个类加载器是由ClassLoader.getSystemClassLoader方法返回值。
    //负责加载用户ClassPath上指定的类库。



}
