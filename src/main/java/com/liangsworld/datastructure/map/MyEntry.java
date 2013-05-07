package com.liangsworld.datastructure.map;

/**
 * Created with IntelliJ IDEA.
 * User: liliangli
 * Date: 5/7/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyEntry<K, V> {
    private final K key;
    private V value;

    public MyEntry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
