package com.liangsworld.datastructure.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: liliangli
 * Date: 5/7/13
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyMap<K,V> {
    private int size;
    private int DEFAULT_CAPACITY = 16;

    private MyEntry<K,V>[] values = new MyEntry[DEFAULT_CAPACITY];

    public V get(K key){
        for(int i = 0; i<size; i++){
            if(values[i].getKey().equals(key)){
                return values[i].getValue();
            }
        }
        return null;
    }

    public void put(K key, V value){
        boolean insert = true;
        for(int i = 0; i < size; i ++){
            if(values[i].getKey().equals(key)){
                values[i].setValue(value);
                insert = false;
            }
        }
        if(insert){
            ensureCapa();
            values[size++] = new MyEntry<K, V>(key, value);
        }
    }

    private void ensureCapa(){
        if(size == values.length){
            int newSize = values.length * 2;
            values = Arrays.copyOf(values, newSize);
        }
    }

    public int size(){
        return size;
    }

    public void remove(K key){
        for (int i = 0; i < size; i ++){
            if(values[i].getKey().equals(key)){
                values[i] = null;
                size --;
                condenseArray(i);
            }
        }
    }

    private void condenseArray(int start){
        for(int i = start; i < start; i ++){
            values[i] = values[i+1];
        }
    }

    public Set<K> keySet(){
        Set<K> set = new HashSet<K>();
        for (int i=0; i<size;i++){
            set.add(values[i].getKey());
        }
        return set;
    }
}
