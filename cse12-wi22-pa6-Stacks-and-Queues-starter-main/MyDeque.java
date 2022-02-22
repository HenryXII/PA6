/**
 * 
 */
class MyDeque<E> implements DequeInterface<E> {
    private static final int DEFAULT_CAPACITY = 10;
    Object[] data;
    int size;
    int rear;
    int front;

    public MyDeque(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        data = new Object[initialCapacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    public int size() {
        return this.size;
    }

    public void expandCapacity() {
        if (size == 0) {
            // no elements to move
            if (data.length == 0 || data == null) {
                data = new Object[DEFAULT_CAPACITY];
            } else {
                data = new Object[data.length * 2];
            }
            // no need to updata front or rear?
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

    public void addFirst(E element) {
        // check input and capacity
        if (element == null) {
            throw new IllegalArgumentException();
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

    public void addLast(E element) {
        // check input and capacity
        if (element == null) {
            throw new IllegalArgumentException();
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

    public E peekFirst() {
        // check size
        if (this.size == 0) {
            return null;
        }
        return (E) data[front];
    }

    public E peekLast() {
        // check size
        if (this.size == 0) {
            return null;
        }
        return (E) data[rear];
    }
}