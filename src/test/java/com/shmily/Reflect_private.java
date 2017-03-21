package com.shmily;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/3/13.
 */
public class Reflect_private {
    public static void main(String[] args) throws Exception{
        Private2 p = new Private2();
        Class<?> classType = p.getClass();

        Field field = classType.getDeclaredField("name");
        field.setAccessible(true);
        field.set(p,"wxb123");

        System.out.println(p.getName());
    }
}

class Private2{
    private String name="wxb";

    public String getName(){
        return name;
    }
}

