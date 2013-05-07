package com.liangsworld.datastructure.stack;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: liliangli
 * Date: 5/7/13
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyStackList<E> extends ArrayList<E> {
    private static final long serialVersionUID = 1L;

    public E pop(){
        E e = get(size() - 1);
        remove(size() - 1);
        return e;
    }

    public void push(E e){
        add(e);
    }
}
