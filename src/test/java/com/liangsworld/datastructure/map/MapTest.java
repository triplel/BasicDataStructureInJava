package com.liangsworld.datastructure.map;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

import com.liangsworld.datastructure.map.MyMap;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: liliangli
 * Date: 5/7/13
 * Time: 11:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class MapTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testStandardMap(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Sven", 1);
        map.put("Sven", 2);
        map.put("Sven", 1);
        assertEquals(map.get("Sven"), new Integer(1));

        for(int i = 0; i < 100; i++){
            map.put(String.valueOf(i), i);
        }

        assertEquals(map.size(), 101);

        assertEquals(map.get("51"), new Integer(51));
        assertEquals(map.keySet().size(), 101);
    }

    @Test
    public void testMyMap() {
        MyMap<String, Integer> myMap = new MyMap<String, Integer>();
        myMap.put("Sven", 1);
        myMap.put("Sven", 2);
        myMap.put("Sven", 1);
        assertEquals(myMap.get("Sven"), new Integer(1));
        for(int i = 0; i < 100; i++){
            myMap.put(String.valueOf(i), i);
        }

        assertEquals(myMap.size(), 101);

        assertEquals(myMap.get("51"), new Integer(51));
        assertEquals(myMap.keySet().size(), 101);
        myMap.put("Bender", 0);
        assertEquals(myMap.size(), 102);
    }
}
