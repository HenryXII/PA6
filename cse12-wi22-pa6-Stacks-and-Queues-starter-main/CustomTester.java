
/**
 * Name: Andrew Wang, Jiahui Xu.
 * Email: anw011@ucsd.edu jix049@ucsd.edu
 * Sources used: Copilot
 * 
 * This file is a tester that contains custom test cases for MyDeque, MyQueue,
 * and MyStack. The tests in this file are not contained in PublicTester and 
 * this file should be considered more comprehensive. Tests for various edge 
 * cases and corner cases are included.
 */

import org.junit.*;
import static org.junit.Assert.*;

import java.beans.Transient;

/**
 * This class contains custom test cases for MyDeque, MyQueue, and MyStack. The
 * tests in this file are not contained in PublicTester and this file should be
 * considered more comprehensive. Tests for various edge cases and corner cases
 * are included.
 */
public class CustomTester {
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when initial capacity is 0 or negative.
     */
    @Test
    public void testMyDequeConstructor() {
        MyDeque<Integer> myDeque2 = new MyDeque<>(0);
        assertEquals(0, myDeque2.size());
        assertEquals(myDeque2.data.length, 0);
        try {
            myDeque2 = new MyDeque<>(-1);
            fail();
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test the constructor when initial capacity is positive.
     */
    @Test
    public void testMyDequeConstructor2() {
        for (int i = 1; i < 1000; i++) {
            MyDeque<String> myDeque2 = new MyDeque<>(i);
            assertEquals(i, myDeque2.size());
            assertEquals(myDeque2.data.length, i);
        }
    }

    /**
     * Test the expandCapacity method when initial capacity is 0
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<String> myDeque2 = new MyDeque<>(0);
        myDeque2.expandCapacity();
        assertEquals(myDeque2.data.length, 10);
        int size = 3;
        
    }

    /**
     * Test the addFirst method when [TODO]
     */
    @Test
    public void testAddFirst() {

    }

    /**
     * Test the addLast method when [TODO]
     */
    @Test
    public void testAddLast() {

    }

    /**
     * Test the removeFirst method when [TODO]
     */
    @Test
    public void testRemoveFirst() {

    }

    /**
     * Test the removeLast method when [TODO]
     */
    @Test
    public void testRemoveLast() {

    }

    /**
     * Test the peekFirst method when [TODO]
     */
    @Test
    public void testPeekFirst() {

    }

    /**
     * Test the peekLast method when [TODO]
     */
    @Test
    public void testPeekLast() {

    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when [TODO]
     */
    @Test
    public void testMyStack() {
        // You can test any method from MyStack or a combination of methods
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when [TODO]
     */
    @Test
    public void testMyQueue() {
        // You can test any method from MyQueue or a combination of methods
    }
}
