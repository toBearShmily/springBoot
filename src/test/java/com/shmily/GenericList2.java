package com.shmily;

import java.util.*;

/**
 * 申明的时候该类可以实现任何类型，具体实例化的时候确定实现具体的某种类型
 * Created by Administrator on 2017/3/6.
 */
public class GenericList2<T> {
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }

    public static void main(String[] args){
        //这里指定的是引用的时候指定具体实现类型，即引用变量的类型
        GenericList2<? extends List> foo = null;

        foo = new GenericList2<ArrayList>();
        //错误
        //foo = new GenericList2<HashMap>();

        //指向上类实现
        GenericList2<? super List> foo2 = null;
        foo2 = new GenericList2<Object>();
        foo2 = new GenericList2<Collection>();


        GenericList2<String> ge = null;
        ge = new GenericList2<String>();
        ge.setFoo("hello world");

        GenericList2<?> ge1 = ge;
        ge1.getFoo();

        ge1.setFoo(null);
        //此处是错的，hello world会打印，ge赋值给ge1后.ge1可以拿到值，但是come不会打印，
        //赋值是成功的，有值，但是赋值后，只知道当前泛型类型是继承自Object，但是不知道其具体类型，所以在给ge1赋值come
        //时在不知道类型的情况下赋值取值都需要进行强转，违背了泛型的意义，，故，会报错
        //ge1.setFoo("come");
    }
}
