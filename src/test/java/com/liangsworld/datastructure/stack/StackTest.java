package com.liangsworld.datastructure.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: liliangli
 * Date: 5/7/13
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class StackTest {

    @Before
    public void setUp(){

    }

    @Test
    public void testStackArray(){
        MyStackArray<Integer> stack = new MyStackArray<Integer>();
        stack.push(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        assertTrue(stack.pop() == 7);
        assertTrue(stack.pop() == 6);
        assertTrue(stack.pop() == 5);
        assertTrue(stack.pop() == 4);
        assertTrue(stack.pop() == 3);
        assertTrue(stack.pop() == 2);
        assertTrue(stack.pop() == 1);
        assertTrue(stack.pop() == 1);
    }

    @Test
    public void testStackList(){
        MyStackList<Integer> stack = new MyStackList<Integer>();
        stack.push(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        assertTrue(stack.pop() == 7);
        assertTrue(stack.pop() == 6);
        assertTrue(stack.pop() == 5);
        assertTrue(stack.pop() == 4);
        assertTrue(stack.pop() == 3);
        assertTrue(stack.pop() == 2);
        assertTrue(stack.pop() == 1);
        assertTrue(stack.pop() == 1);
    }

    @Test
    public void testSmartStackOfInt(){
        SmartStackArrayOfInt stack = new SmartStackArrayOfInt();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        assertTrue(stack.getCurrentMin() == 2);
        assertTrue(stack.getCurrentMax()==7);

        stack.push(1);
        assertTrue(stack.getCurrentMin()==1);
        assertTrue(stack.getCurrentMax()==7);

        assertTrue(stack.pop() == 1);
        assertTrue(stack.getCurrentMin()==2);
        assertTrue(stack.getCurrentMax()==7);

        assertTrue(stack.pop() == 7);
        assertTrue(stack.getCurrentMin()==2);
        assertTrue(stack.getCurrentMax()==6);

        assertTrue(stack.pop() == 6);
        assertTrue(stack.getCurrentMin()==2);
        assertTrue(stack.getCurrentMax()==5);

        assertTrue(stack.pop() == 5);
        assertTrue(stack.getCurrentMin()==2);
        assertTrue(stack.getCurrentMax()==4);

        assertTrue(stack.pop() == 4);
        assertTrue(stack.getCurrentMin()==2);
        assertTrue(stack.getCurrentMax()==3);

        assertTrue(stack.pop() == 3);
        assertTrue(stack.getCurrentMin()==2);
        assertTrue(stack.getCurrentMax()==2);
    }
}
