package com.liangsworld.datastructure.stack;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: liliangli
 * Date: 5/7/13
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class SmartStackArrayOfInt {
    private int stackIndex = 0;
    private int trackIndex = 0;
    private static final int DEFAULT_SIZE = 20;
    private Integer elements[];
    private Integer trackMin[];

    public SmartStackArrayOfInt(){
        elements = new Integer[DEFAULT_SIZE];
        trackMin = new Integer[DEFAULT_SIZE];
    }

    public void push(int i){
        if (stackIndex == elements.length){
            ensureElementsCapacity();
        }
        elements[stackIndex++] = i;
        pushTrackMin(i);
    }

    public int pop(){
        int e = (int) elements[--stackIndex];
        elements[stackIndex] = null;
        popTrackMin();
        return e;
    }

    public int getCurrentMin(){
        return trackMin[trackIndex-1];
    }
    private void ensureElementsCapacity(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void ensureTrackMinCapacity(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void pushTrackMin(Integer i){
        if (trackIndex == trackMin.length){
            ensureTrackMinCapacity();
        }
        if(trackIndex == 0){
            trackMin[trackIndex++] = i;
        }else{
            int min = trackMin[trackIndex-1];
            if(min >= i){
                trackMin[trackIndex++] = i;
            }else{
                trackMin[trackIndex++] = min;
            }
        }
    }

    private int popTrackMin(){
        int i = (int) trackMin[--trackIndex];
        trackMin[trackIndex] = null;
        return i;
    }
}
