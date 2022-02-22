/**
 * TODO: Add your file header
 * Name: Jiahui Xu, Andrew Wang.
 * Email: jix049@ucsd.edu, anw011@ucsd.edu
 * Sources used:None
 * 
 * This file contains a MyDeque class, which is an implementation for the 
 * Deque ADT. Elements can be added/removed from the Deque from both ends.
 * MyDeque is adopted by MyStack and MyQueue.
 */

 /**
  * This class implements DequeInterface. Elements are stored in the 
  * instance variable data. It use instance variables rear and front to
  * keep track of where the elements are in the array. Instance variable
  * size record how many elements are there in the deque.
  * Instance variables: Object[] data, int size, rear, front.
  */
class MyDeque<E> implements DequeInterface<E> {
    private static final int DEFAULT_CAPACITY = 10;
    Object[] data;
    int size;
    int rear;
    int front;
    /**
     * Initialize the Object array data with length of initialCapacity.
     * @param initialCapacity the initial length of the array
     */
    public MyDeque(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        data = new Object[initialCapacity];
        size = 0;
        front = 0;
        rear = 0;
    }
    /**
     * Returns the number of elements that exist in the deque.
     */
    public int size() {
        return this.size;
    }
    /**
     * Doubles the current capacity, set to default if zero.
     */
    public void expandCapacity() {
        if (size == 0) {
            // no elements to move
            if (data.length == 0 || data == null) {
                data = new Object[DEFAULT_CAPACITY];
            } else {
                data = new Object[data.length * 2];
            }
            front = 0;
            rear = 0;
        } else {
            // move elements
            Object[] newData;
            newData = new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                if (front + i <= data.length - 1) {
                    newData[i] = data[front + i];
                } else {
                    newData[i] = data[front + i - data.length];
                }
            }
            data = newData;
            front = 0;
            rear = size - 1;
        }
    }
    /**
     * Add the specified element to the front of the deque
     * @param element the new element
     */
    public void addFirst(E element) {
        // check input and capacity
        if (element == null) {
            throw new NullPointerException();
        }
        if (this.size == data.length) {
            this.expandCapacity();
        }
        // add new element
        if (size == 0) {
            data[front] = element;
        } else {
            if (front == 0) {
                data[data.length - 1] = element;
                front = data.length - 1;
            } else {
                data[front - 1] = element;
                front = front - 1;
            }
        }
        size++;
    }
    /**
     * Add the specified element to the rear of the deque
     * @param element the new element
     */
    public void addLast(E element) {
        // check input and capacity
        if (element == null) {
            throw new NullPointerException();
        }
        if (this.size == data.length) {
            this.expandCapacity();
        }
        // add new element
        if (size == 0) {
            data[rear] = element;
        } else {
            if (rear == data.length - 1) {
                data[0] = element;
                rear = 0;
            } else {
                data[rear + 1] = element;
                rear = rear + 1;
            }
        }
        size++;
    }
    /**
     * Removes and returns the element at the front of the deque
     * @return the removed element
     */
    public E removeFirst() {
        // check size
        if (this.size == 0) {
            return null;
        }
        // remove element
        E removeElement;
        if (size == 1) {
            removeElement = (E) data[front];
            data[front] = null;
            // front remain unchanged
        } else {
            if (front == data.length - 1) {
                removeElement = (E) data[front];
                data[front] = null;
                front = 0;
            } else {
                removeElement = (E) data[front];
                data[front] = null;
                front = front + 1;
            }
        }

        this.size--;
        return removeElement;
    }
    /**
     * Removes and returns the element at the rear of the deque
     * @return the removed element
     */
    public E removeLast() {
        // check size
        if (this.size == 0) {
            return null;
        }
        // remove element
        E removeElement;
        if (size == 1) {
            removeElement = (E) data[rear];
            data[rear] = null;
            // rear remain unchanged
        } else {
            if (rear == 0) {
                removeElement = (E) data[rear];
                data[rear] = null;
                rear = data.length - 1;
            } else {
                removeElement = (E) data[rear];
                data[rear] = null;
                rear = rear - 1;
            }
        }

        this.size--;
        return removeElement;
    }
    /**
     * Returns the element at the front of the deque
     * @return the element at front
     */
    public E peekFirst() {
        // check size
        if (this.size == 0) {
            return null;
        }
        return (E) data[front];
    }
    /**
     * Returns the element at the rear of the deque
     * @return the element at rear
     */
    public E peekLast() {
        // check size
        if (this.size == 0) {
            return null;
        }
        return (E) data[rear];
    }
}