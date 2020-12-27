package com.sujit.two_data_structure.queue;

import com.sujit.two_data_structure.exception.IllegalQueueStateException;

public class CircularArrayQueue<T> implements Queue<T> {

    private static final int CAPACITY = 100;
    private int front, rear, size;
    private T[] queueData;

    public CircularArrayQueue() {
        super();
         //set default capacity of queue
        this.queueData = (T[]) new Object[CAPACITY];
        size= 0;
        front= 0;
        rear = 0;
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public T peek() {
        T data;
        if(size <= 0 ){
            throw new IllegalQueueStateException("Queue is Empty");
        }
        data = queueData[front % CAPACITY];
        return data;
    }

    @Override
    public void enque(T data) throws IllegalQueueStateException {
        if (size == CAPACITY || data == null) {
            throw new IllegalQueueStateException("Queue is Already Full");
        }
        size++;
        queueData[rear] = data;
        rear = (rear+1) % CAPACITY;
    }

    @Override
    public T deque() {
        T data = peek();
        front = (front + 1 % CAPACITY);
        size--;
        return data;
    }
}
