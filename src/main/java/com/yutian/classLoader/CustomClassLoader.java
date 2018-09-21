package com.yutian.classLoader;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {




    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try{
            String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
            InputStream inputStream = getClass().getResourceAsStream(fileName);
            if(inputStream==null){
                return super.loadClass(name);
            }
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            return defineClass(name,b,0,b.length);
        }catch (IOException e){
            e.printStackTrace();
            throw new ClassNotFoundException(name);
        }
    }
}
