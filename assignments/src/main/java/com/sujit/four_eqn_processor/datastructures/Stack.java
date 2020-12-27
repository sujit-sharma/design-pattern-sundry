package com.sujit.four_eqn_processor.datastructures;

public interface Stack<T> {
    public boolean isEmpty();
    public Integer size();
    public T peek();

    public void push(T data);
    public T pop();
}
