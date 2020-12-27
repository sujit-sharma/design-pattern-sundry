package com.sujit.two_data_structure.stack;
import com.sujit.two_data_structure.utils.Node;
import com.sujit.two_data_structure.exception.IllegalStackStateException;

public class LinkedStack<T> extends AbstractStack<T> {

    private Node<T> top;
    private  int size;

    public LinkedStack(){
        top = null;
        size = 0;
    }

    @Override
    public void push(T data) {
        if (data != null){
            Node<T> node = new Node<>(data);
            node.setNext(top);
            top = node;
            size++;
        }
    }

    @Override
    public T pop() {
        T data = peek();
        top = top.getNext();
        size--;
        return data;
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public T peek() {
        if(isEmpty() || top == null) {
            throw new IllegalStackStateException("The Stack is Already Empty");
        }
        return top.getData();
    }

}
