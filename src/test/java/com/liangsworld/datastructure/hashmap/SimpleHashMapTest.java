package com.liangsworld.datastructure.hashmap;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: liliangli
 * Date: 5/7/13
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleHashMapTest {

    SimpleHashMap<String, Integer> simpleHashMap;

    @Before
    public void setUp(){
        this.simpleHashMap = new SimpleHashMap<String, Integer>();
        simpleHashMap.put("FC Bayern", 1900);
        simpleHashMap.put("FC Barcelona", 1899);
        simpleHashMap.put("Borussia Dortmund", 1909);
        simpleHashMap.put("Real Madrid", 1902);
    }

    @Test
    public void testSimpleHashMapGetPut(){
        assertEquals(simpleHashMap.get("FC Bayern"),Integer.valueOf(1900));
        assertEquals(simpleHashMap.get("FC Barcelona"),Integer.valueOf(1899));
        assertEquals(simpleHashMap.get("Borussia Dortmund"),Integer.valueOf(1909));
        assertEquals(simpleHashMap.get("Real Madrid"),Integer.valueOf(1902));
    }

    @Test
    public void testSimpleHashMapGetNonExistingKey(){
        assertEquals(simpleHashMap.get("Manchester United"), null);
    }

    @Test
    public void testSimpleHashMapSameValueEntry(){
        simpleHashMap.put("S.S. Lazio",1900);

        assertEquals(simpleHashMap.get("FC Bayern"),Integer.valueOf(1900));
        assertEquals(simpleHashMap.get("S.S. Lazio"),Integer.valueOf(1900));
    }

    @Test
    public void testSimpleHashMapSameHashCodeNoOverwrite(){
        String str1 = "Ea";
        String str2 = "FB";
        assertEquals(str1.hashCode(),str2.hashCode());
        simpleHashMap.put(str1, 100);
        simpleHashMap.put(str2, 200);

        assertEquals(simpleHashMap.get(str1),Integer.valueOf(100));
        assertEquals(simpleHashMap.get(str2),Integer.valueOf(200));
    }

    @Test
    public void testSimpleHashMapNullValueAllowed(){
        simpleHashMap.put("Unknown FC", null);
        assertNull(simpleHashMap.get("Unknown FC"));
    }
}
