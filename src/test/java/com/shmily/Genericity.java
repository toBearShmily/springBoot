package com.shmily;

/**
 * Created by Administrator on 2017/3/8.
 */
public class Genericity<E , T , M> {
    private E e;

    private T t;

    private M m;

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }




    public static void main(String[] args) {
        Genericity ge = new Genericity<Integer,String,String>();

    }
}
