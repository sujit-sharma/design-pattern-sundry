package com.sujit.three_binary_tree.lab2codereuse;

public class LinkedQueue<T> implements Queue<T> {

    private int length;
    private LinkListNode<T> front, rear;


    public LinkedQueue() {
        super();
        length = 0;
        front = rear = null;
    }

    public  boolean isEmpty() {
        return (length <= 0);
    }
    @Override
    public Integer size() {
        return length;
    }

    @Override
    public T peek() {
        if (isEmpty() || this.rear == null ) {
            throw new IllegalQueueStateException("Queue is Already Empty");
        }
        return front.getData();
    }

    @Override
    public void enque(T data) {
        if( data != null) {
            LinkListNode<T> node = new LinkListNode<>(data);
            if(isEmpty())
                front = node;
            else
                rear.setNext(node);
            rear = node;
            length++;
        }

    }

    @Override
    public T deque() {
               T data = peek();
                front = front.getNext();
                length--;
                if (isEmpty())
                    rear = null;
        return data;
    }
}
