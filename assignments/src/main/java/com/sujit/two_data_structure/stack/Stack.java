package com.sujit.two_data_structure.stack;

import com.sujit.two_data_structure.DataStructure;

public interface Stack<T> extends DataStructure<T> {
    public void push(T data);
    public T pop();
}
