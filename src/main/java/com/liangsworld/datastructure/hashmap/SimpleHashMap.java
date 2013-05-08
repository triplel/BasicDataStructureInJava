package com.liangsworld.datastructure.hashmap;

/**
 * Created with IntelliJ IDEA.
 * User: liliangli
 * Date: 5/7/13
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleHashMap<K,V> {
    private int DEFAULT_BUCKET_NUM = 128;
    private MyEntry<K,V>[] buckets;

    public SimpleHashMap(){
        buckets = new MyEntry[DEFAULT_BUCKET_NUM];
    }

    public V get(K key){
        throwIfKeyNull(key);
        MyEntry<K,V> entry = buckets[bucketIndexForKey(key)];
        while(entry != null && !key.equals(entry.getKey())){
            entry = entry.getNext();
        }
        return entry != null? entry.getValue():null;
    }

    public void put(K key, V value){
        throwIfKeyNull(key);

        int bucketIndex = bucketIndexForKey(key);
        MyEntry<K,V> entry = buckets[bucketIndex];

        if(entry != null){
            boolean done = false;
            while(!done){
                if(key.equals(entry.getKey())){
                    entry.setValue(value);
                    done = true;
                } else if(entry.getNext() == null){
                    entry.setNext(new MyEntry<K, V>(key,value));
                    done = true;
                }
                entry = entry.getNext();
            }
        } else {
            buckets[bucketIndex] = new MyEntry<K, V>(key, value);
        }
    }

    public int bucketIndexForKey(K key){
        int bucketIndex;
        int kHashCode = key.hashCode();

        //a string can get negative hasCode
        if(kHashCode < 0){
            bucketIndex = (kHashCode * -1) % buckets.length;
        }else{
            bucketIndex = (kHashCode) % buckets.length;
        }

        return bucketIndex;
    }

    private void throwIfKeyNull(K key){
        if(key == null){
            throw new IllegalArgumentException("key must not be null!");
        }
    }
}
