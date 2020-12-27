package com.sujit.three_binary_tree.lab2codereuse;


public interface Queue<T> {
    public void enque(T Data);
    public T deque();
    public Integer size();
    public T peek();
    public boolean isEmpty();
}
