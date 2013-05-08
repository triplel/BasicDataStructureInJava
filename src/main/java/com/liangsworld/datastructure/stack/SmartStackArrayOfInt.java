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

    private static class Tracker{
        int max;
        int min;

        Tracker(int max, int min){
            this.max=max;
            this.min=min;
        }
    }

    private int stackIndex = 0;
    private int trackIndex = 0;
    private static final int DEFAULT_SIZE = 20;
    private Integer elements[];
    private Tracker trackMin[];


    public SmartStackArrayOfInt(){
        elements = new Integer[DEFAULT_SIZE];
        trackMin = new Tracker[DEFAULT_SIZE];
    }

    public void push(int i){
        if (stackIndex == elements.length){
            ensureElementsCapacity();
        }
        elements[stackIndex++] = i;
        pushTracker(i);
    }

    public int pop(){
        int e = (int) elements[--stackIndex];
        elements[stackIndex] = null;
        popTrackTop();
        return e;
    }

    public int getCurrentMin(){
        return trackMin[trackIndex-1].min;
    }

    public int getCurrentMax(){
        return trackMin[trackIndex-1].max;
    }
    private void ensureElementsCapacity(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void ensureTrackMinCapacity(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void pushTracker(Integer i){
        if (trackIndex == trackMin.length){
            ensureTrackMinCapacity();
        }
        if(trackIndex == 0){
            trackMin[trackIndex++] = new Tracker(i, i);
        }else{
            int min = trackMin[trackIndex-1].min;
            int max = trackMin[trackIndex-1].max;
            Tracker t;
            if(min >= i){
                t = new Tracker(max, i);
            }else if( (i > min) && (i <= max)){
                t = new Tracker(max, min);
            }else{
                t = new Tracker(i, min);
            }
                trackMin[trackIndex++] = t;
        }
    }

    private Tracker popTrackTop(){
//        int i = (int) trackMin[--trackIndex];
//        trackMin[trackIndex] = null;
//        return i;
        Tracker t = (Tracker) trackMin[--trackIndex];
        trackMin[trackIndex] = null;
        return t;

    }
}
