
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
     * Test the constructor when initial capacity is positive and large.
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
     * Test the expandCapacity method when initial capacity is 0, or first is
     * greater than rear, or expanding on an empty queue with first greater than
     * rear
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
        assertEquals(0, myDeque2.front);
        assertEquals(myDeque2.rear, 0);
        assertEquals(myDeque2.data.length, 20);
        for (int i = 10; i < 20; i++)
            myDeque2.addLast(arr[i]);
        for (int i = 0; i < 10; i++)
            assertEquals(myDeque2.data[i], arr[i + 10]);

        myDeque2 = new MyDeque<>(0);
        myDeque2.addLast(arr[0]);
        for (int i = 1; i < 8; i++) {
            myDeque2.addFirst(arr[i]);
            myDeque2.removeLast();
        }
        for (int i = 8; i < 10; i++) {
            myDeque2.addFirst(arr[i]);
        }
        myDeque2.expandCapacity();
        for (int i = 7; i < 10; i++) {
            assertEquals(myDeque2.data[9 - i], arr[i]);
        }
        for (int i = 20; i < 30; i++) {
            myDeque2.addFirst(arr[i]);
        }
        for (int i = 10; i < 20; i++) {
            myDeque2.addLast(arr[i]);
        }
        for (int i = 29; i >= 20; i--) {
            assertEquals(myDeque2.removeFirst(), arr[i]);
        }
        for (int i = 19; i >= 10; i--) {
            assertEquals(myDeque2.removeLast(), arr[i]);
        }
        for (int i = 7; i < 10; i++) {
            assertEquals(myDeque2.removeLast(), arr[i]);
        }

    }

    /**
     * Test the addFirst method when initial capacity is 0, or first is greater
     * or equal to rear, or adding on an empty queue with first greater than
     * rear or adding on an empty queue with first equal to rear or adding null
     */
    @Test
    public void testAddFirst() {
        MyDeque<String> myDeque2 = new MyDeque<>(0);
        Random r = new Random(79813278949871342l);
        String[] arr = new String[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = "";
            int len = r.nextInt(0, 40);
            for (int j = 0; j < len; j++)
                arr[i] += (char) (r.nextInt(0, 26) + 'a');
        }
        for (int i = 0; i < 50; i++)
            myDeque2.addFirst(arr[i]);
        assertEquals(50, myDeque2.size());
        assertEquals(80, myDeque2.data.length);
        for (int i = 49; i > -1; i--)
            assertEquals(arr[49 - i], myDeque2.removeLast());
        for (int i = 0; i < 50; i++)
            myDeque2.addFirst(arr[i]);
        while (myDeque2.size != 0) {
            myDeque2.removeFirst();
        }
        assertEquals(0, myDeque2.size());
        for (int i = 0; i < 100; i++) {
            myDeque2.addFirst(arr[i]);
        }
        assertEquals(100, myDeque2.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(myDeque2.removeLast(), arr[i]);
        }
        myDeque2 = new MyDeque<>(0);
        myDeque2.addFirst(arr[0]);
        for (int i = 1; i < 94; i++) {
            myDeque2.addFirst(arr[i]);
            myDeque2.removeLast();
        }
        assertEquals(1, myDeque2.size());
        assertEquals(10, myDeque2.data.length);
        assertEquals(arr[93], myDeque2.removeFirst());
        for (int i = 0; i < 100; i++) {
            myDeque2.addFirst(arr[i]);
        }
        assertEquals(100, myDeque2.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(myDeque2.removeLast(), arr[i]);
        }
        try {
            myDeque2.addFirst(null);
            fail("Should have thrown NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("java.lang.NullPointerException",
                    e.getClass().getName());
        }
    }

    /**
     * Test the addLast method when initial capacity is 0, or first is greater
     * or equal to rear, or adding on an empty queue with first greater than
     * rear or adding on an empty queue with first equal to rear or adding null
     */
    @Test
    public void testAddLast() {
        MyDeque<String> myDeque2 = new MyDeque<>(0);
        Random r = new Random(79813278949871342l);
        String[] arr = new String[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = "";
            int len = r.nextInt(0, 40);
            for (int j = 0; j < len; j++)
                arr[i] += (char) (r.nextInt(0, 26) + 'a');
        }
        for (int i = 0; i < 50; i++)
            myDeque2.addLast(arr[i]);
        assertEquals(50, myDeque2.size());
        assertEquals(80, myDeque2.data.length);
        for (int i = 49; i > -1; i--)
            assertEquals(arr[49 - i], myDeque2.removeFirst());
        for (int i = 0; i < 50; i++)
            myDeque2.addLast(arr[i]);
        while (myDeque2.size != 0) {
            myDeque2.removeLast();
        }
        assertEquals(0, myDeque2.size());
        for (int i = 0; i < 100; i++) {
            myDeque2.addLast(arr[i]);
        }
        assertEquals(100, myDeque2.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(myDeque2.removeFirst(), arr[i]);
        }
        myDeque2 = new MyDeque<>(0);
        myDeque2.addLast(arr[0]);
        for (int i = 1; i < 94; i++) {
            myDeque2.addLast(arr[i]);
            myDeque2.removeFirst();
        }
        assertEquals(1, myDeque2.size());
        assertEquals(10, myDeque2.data.length);
        assertEquals(arr[93], myDeque2.removeFirst());
        for (int i = 0; i < 100; i++) {
            myDeque2.addLast(arr[i]);
        }
        assertEquals(100, myDeque2.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(myDeque2.removeFirst(), arr[i]);
        }
        try {
            myDeque2.addLast(null);
            fail("Should have thrown NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("java.lang.NullPointerException",
                    e.getClass().getName());
        }
    }

    /**
     * Test the removeFirst method when front is greater or equal to rear or
     * removing from an empty queue or removing from a queue with no rear (front
     * is equal to rear)
     */
    @Test
    public void testRemoveFirst() {
        MyDeque<String> myDeque2 = new MyDeque<>(0);
        assertEquals(null, myDeque2.removeFirst());
        String[] test = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
        myDeque2.addFirst(test[0]);
        for (int i = 1; i < 5; i++) {
            myDeque2.addFirst(test[i]);
            myDeque2.removeLast();
        }
        myDeque2.removeLast();
        for (int i = 0; i < 10; i++)
            myDeque2.addLast(test[i]);
        for (int i = 0; i < 10; i++) {
            assertEquals(test[i], myDeque2.removeFirst());
        }
        assertEquals(null, myDeque2.removeFirst());
        myDeque2 = new MyDeque<>(0);
        myDeque2.addLast(test[0]);
        for (int i = 1; i < 5; i++) {
            myDeque2.addLast(test[i]);
            myDeque2.removeFirst();
        }
        myDeque2.removeFirst();
        for (int i = 0; i < 10; i++)
            myDeque2.addLast(test[i]);
        for (int i = 0; i < 10; i++) {
            assertEquals(test[i], myDeque2.removeFirst());
        }
        for (int i = 0; i < 10; i++) {
            myDeque2.addFirst(test[i]);
        }
        myDeque2.addFirst("abcd");
        myDeque2.addFirst("cdef");
        assertEquals("cdef", myDeque2.removeFirst());
        assertEquals("abcd", myDeque2.removeFirst());
        for (int i = 9; i >= 0; i--)
            assertEquals(test[i], myDeque2.removeFirst());
        assertEquals(null, myDeque2.removeFirst());
    }

    /**
     * Test the removeLast method when front is greater or equal to rear or
     * removing from an empty queue or removing from a queue with no rear or
     * (front is equal to rear)
     * 
     */
    @Test
    public void testRemoveLast() {
        MyDeque<String> myDeque2 = new MyDeque<>(0);
        assertEquals(null, myDeque2.removeLast());
        String[] test = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
        myDeque2.addFirst(test[0]);
        for (int i = 1; i < 5; i++) {
            myDeque2.addFirst(test[i]);
            myDeque2.removeLast();
        }
        myDeque2.removeLast();
        for (int i = 0; i < 10; i++)
            myDeque2.addFirst(test[i]);
        for (int i = 0; i < 10; i++) {
            assertEquals(test[i], myDeque2.removeLast());
        }
        assertEquals(null, myDeque2.removeLast());
        myDeque2 = new MyDeque<>(0);
        myDeque2.addLast(test[0]);
        for (int i = 1; i < 5; i++) {
            myDeque2.addLast(test[i]);
            myDeque2.removeFirst();
        }
        myDeque2.removeFirst();
        for (int i = 0; i < 10; i++)
            myDeque2.addFirst(test[i]);
        for (int i = 0; i < 10; i++) {
            assertEquals(test[i], myDeque2.removeLast());
        }
        for (int i = 0; i < 10; i++) {
            myDeque2.addLast(test[i]);
        }
        myDeque2.addLast("abcd");
        myDeque2.addLast("cdef");
        assertEquals("cdef", myDeque2.removeLast());
        assertEquals("abcd", myDeque2.removeLast());
        for (int i = 9; i >= 0; i--)
            assertEquals(test[i], myDeque2.removeLast());
        assertEquals(null, myDeque2.removeLast());
    }

    /**
     * Test the peekFirst method when empty or when front is greater or equal to
     * rear
     */
    @Test
    public void testPeekFirst() {
        MyDeque<String> myDeque2 = new MyDeque<>(0);
        assertEquals(null, myDeque2.peekFirst());
        String[] test = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
        myDeque2.addFirst(test[0]);
        for (int i = 1; i < 5; i++) {
            myDeque2.addFirst(test[i]);
            myDeque2.removeLast();
        }
        myDeque2.removeLast();
        for (int i = 0; i < 10; i++) {
            myDeque2.addFirst(test[i]);
            assertEquals(test[i], myDeque2.peekFirst());
        }
        myDeque2.addLast("sti");
        assertEquals("j", myDeque2.peekFirst());
        myDeque2.addFirst("abcd");
        assertEquals("abcd", myDeque2.peekFirst());
        myDeque2.removeFirst();
        myDeque2.removeLast();
        for (int i = 1; i < 10; i++) {
            myDeque2.removeFirst();
            assertEquals(test[9 - i], myDeque2.peekFirst());
        }
        myDeque2.removeLast();
        assertEquals(null, myDeque2.peekFirst());
    }

    /**
     * Test the peekLast method when empty or when rear is greater or equal to
     * front or when rear is equal to front
     * 
     */
    @Test
    public void testPeekLast() {
        MyDeque<String> myDeque2 = new MyDeque<>(0);
        assertEquals(null, myDeque2.peekFirst());
        String[] test = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
        myDeque2.addFirst(test[0]);
        for (int i = 1; i < 5; i++) {
            myDeque2.addFirst(test[i]);
            myDeque2.removeLast();
        }
        myDeque2.removeLast();
        for (int i = 0; i < 10; i++) {
            myDeque2.addLast(test[i]);
            assertEquals(test[i], myDeque2.peekLast());
        }
        myDeque2.addFirst("sti");
        assertEquals("j", myDeque2.peekLast());
        myDeque2.addLast("abcd");
        assertEquals("abcd", myDeque2.peekLast());
        myDeque2.removeFirst();
        myDeque2.removeLast();
        for (int i = 1; i < 10; i++) {
            myDeque2.removeLast();
            assertEquals(test[9 - i], myDeque2.peekLast());
        }
        myDeque2.removeLast();
        assertEquals(null, myDeque2.peekLast());
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when empty or when pushing and popping randomly
     */
    @Test
    public void testMyStack() {
        int[] arr = new int[5000];
        int top = 0;
        Random r = new Random(1928374912384l);
        MyStack<Integer> myStack = new MyStack<>(0);
        assertTrue(myStack.empty());
        for (int i = 0; i < 7000; i++) {
            if (top == 0)
                assertTrue(myStack.empty());
            else
                assertFalse(myStack.empty());
            if (r.nextBoolean() || top == 0) {
                myStack.push(i);
                arr[top++] = i;
                assertEquals(i, (long) myStack.peek());
            } else {
                assertEquals(arr[--top], (long) myStack.pop());
            }
        }
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when empty or when pushing and polling randomly
     */
    @Test
    public void testMyQueue() {
        int[] arr = new int[10000];
        int left = 0;
        int right = 0;
        Random r = new Random(1928374912384l);
        MyQueue<Integer> myQueue = new MyQueue<>(0);
        for (int i = 0; i < 7000; i++) {
            if (right - left == 0)
                assertTrue(myQueue.empty());
            else
                assertFalse(myQueue.empty());
            if (r.nextBoolean() || right - left == 0) {
                myQueue.enqueue(i);
                arr[right++] = i;
                assertEquals(arr[left], (long) myQueue.peek());
            } else {
                assertEquals(arr[left++], (long) myQueue.dequeue());
            }
        }
    }
}
