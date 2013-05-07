package com.liangsworld.datastructure.stack;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: liliangli
 * Date: 5/7/13
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyStackArray<E> {
    private int size = 0;
    private static final int DEFAULT_SIZE = 20;
    private Object elements[];

    public MyStackArray(){
        elements = new Object[DEFAULT_SIZE];
    }

    public void push(E e){
        if (size == elements.length){
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public E pop(){
        E e = (E) elements[--size];
        elements[size] = null;
        return e;
    }

    private void ensureCapacity(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
