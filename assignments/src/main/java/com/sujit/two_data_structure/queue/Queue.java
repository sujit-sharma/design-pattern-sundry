package com.sujit.two_data_structure.queue;

import com.sujit.two_data_structure.DataStructure;

public interface Queue<T> extends DataStructure<T> {
    public void enque(T Data);
    public T deque();
}
