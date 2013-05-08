package com.liangsworld.datastructure.hashmap;

/**
 * Created with IntelliJ IDEA.
 * User: liliangli
 * Date: 5/7/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyEntry<K,V> {
    private MyEntry<K,V> next;
    private final K key;
    private V value;

    public MyEntry(K key,V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

    public void setValue(V value){
        this.value = value;
    }

    public void setNext(MyEntry<K,V> next){
        this.next = next;
    }

    public MyEntry<K,V> getNext(){
        return next;
    }

}
