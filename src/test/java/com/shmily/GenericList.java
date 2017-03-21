package com.shmily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * one
 * 申明的时候就已经制定该类只能实例怎么样的实例
 * Created by Administrator on 2017/3/6.
 */
public class GenericList<T extends List> {
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }


    public static void main(String[] args){
        //此处该类原本是什么类型就只能实现什么类型
        GenericList<ArrayList> foo1 = new GenericList<>();
        GenericList<LinkedList> foo2 = new GenericList<>();
        //实例化的时候已经确定好只能实现哪种类型
        //GenericList<HashMap> foo3 = new GenericList<HashMap>();
    }
}
