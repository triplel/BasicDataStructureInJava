package com.liangsworld.datastructure.treemap;

import com.liangsworld.datastructure.hashmap.MyEntry;
import com.liangsworld.datastructure.map.MyMap;
import org.junit.Test;
import org.junit.Before;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: liliangli
 * Date: 5/9/13
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class TreeMapTest {

    TreeMap naturalOrderTreeMap;
    TreeMap customizedSortingTreeMap;
    TreeMap treeMapFromSortedMap;
    SortedMap sortedMap;


    @Before
    public void setUp(){
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        this.naturalOrderTreeMap = new TreeMap();
        this.customizedSortingTreeMap = new TreeMap(c);
        // you can create a treemap from a sorted map
//        this.treeMapFromSortedMap = new TreeMap(sortedMap);
    }

    @Test
    public void testNaturalOrderTreeMap(){
        naturalOrderTreeMap.put("FC Bayern München", "Fußball-Club Bayern München e.V.");
        naturalOrderTreeMap.put("FC Barcelona", "Futbol Club Barcelona");
        naturalOrderTreeMap.put("Real Madrid C.F.", "Real Madrid Club de Fútbol");
        naturalOrderTreeMap.put("Borussia Dortmund", "Ballspielverein Borussia 09 e.V. Dortmund");

        MyMap<String, String> clubs = new MyMap<String, String>();

        clubs.put("FC Bayern München", "Fußball-Club Bayern München e.V.");
        clubs.put("FC Barcelona", "Futbol Club Barcelona");
        clubs.put("Real Madrid C.F.", "Real Madrid Club de Fútbol");
        clubs.put("Borussia Dortmund", "Ballspielverein Borussia 09 e.V. Dortmund");

        for(Object entry: naturalOrderTreeMap.entrySet()){
            System.out.println(entry.toString());
        };

        for(Object entry: clubs.keySet()){
            System.out.println(entry.toString());
        };
    }
}
