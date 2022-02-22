
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
import java.util.Arrays;
import java.util.Random;

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
            assertEquals(0, myDeque2.size());
            assertEquals(myDeque2.data.length, i);
        }
    }

    /**
     * Test the expandCapacity method when initial capacity is 0
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<String> myDeque2 = new MyDeque<>(0);
        Random r = new Random(79813278949871342l);
        myDeque2.expandCapacity();
        assertEquals(myDeque2.data.length, 10);
        String[] arr = new String[100];
        for (int i = 0; i < 50; i++) {
            arr[i] = "";
            int len = r.nextInt(0, 40);
            for (int j = 0; j < len; j++)
                arr[i] += (char) (r.nextInt(0, 26) + 'a');

            myDeque2.addLast(arr[i]);
        }
        myDeque2.expandCapacity();
        assertEquals(50, myDeque2.size());
        assertEquals(myDeque2.data.length, 160);
        for (int i = 0; i < arr.length; i++)
            assertEquals(myDeque2.data[i], arr[i]);

        myDeque2 = new MyDeque<>(0);
        myDeque2.addLast(arr[0]);
        for (int i = 1; i < 8; i++) {
            myDeque2.addLast(arr[i]);
            myDeque2.removeFirst();
        }
        for (int i = 8; i < 10; i++) {
            myDeque2.addLast(arr[i]);
        }
        myDeque2.expandCapacity();
        for (int i = 7; i < 10; i++) {
            assertEquals(myDeque2.data[i - 7], arr[i]);
        }
        for (int i = 10; i < 20; i++) {
            myDeque2.addLast(arr[i]);
        }
        for (int i = 20; i < 30; i++) {
            myDeque2.addFirst(arr[i]);
        }
        for (int i = 29; i >= 20; i--) {
            assertEquals(myDeque2.removeFirst(), arr[i]);
        }
        for (int i = 19; i >= 10; i--) {
            assertEquals(myDeque2.removeLast(), arr[i]);
        }
        for (int i = 7; i < 10; i++) {
            assertEquals(myDeque2.removeFirst(), arr[i]);
        }

        myDeque2 = new MyDeque<>(0);
        myDeque2.addLast(arr[0]);
        for (int i = 1; i < 8; i++) {
            myDeque2.addLast(arr[i]);
            myDeque2.removeFirst();
        }
        for (int i = 8; i < 10; i++) {
            myDeque2.addLast(arr[i]);
        }
        while (myDeque2.size != 0) {
            myDeque2.removeFirst();
        }
        myDeque2.expandCapacity();
        assertEquals(0, myDeque2.size());
        assertEquals(myDeque2.data.length, 20);
        // assertEquals(myDeque2.front, 0);
        // assertEquals(myDeque2.rear, 0);
        for (int i = 10; i < 20; i++)
            myDeque2.addLast(arr[i]);
        for (int i = 0; i < 10; i++)
            assertEquals(myDeque2.data[i], arr[i + 10]);
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
