package com.sujit.two_data_structure.stack;
import com.sujit.two_data_structure.exception.IllegalStackStateException;

public class ArrayStack<T> extends AbstractStack<T> {

    private int capacity;

    private int top = -1;

    private T[] stackData;

    public ArrayStack() {
        this.capacity = 100; //set default capacity of stack
        this.stackData = (T[]) new Object[capacity];
    }
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stackData = (T[]) new Object[capacity];

    }

    public boolean isFull() {
        return (capacity ==size() );
    }

    @Override
    public Integer size() {
        return top + 1;
    }

    @Override
    public T peek() throws IllegalStackStateException {
        if(isEmpty()) {
            throw new IllegalStackStateException("The Stack is Already Empty");
        }
        return this.stackData[top];
    }

    @Override
    public void push(T data) throws IllegalStackStateException {
        if(isFull() || data == null) {
            throw new IllegalStackStateException("The Stack is Already Full");
        }
        this.stackData[++top] = data;
    }

    @Override
    public T pop() throws IllegalStackStateException {
        T data = peek();
        top--;
        return data;
    }
}
