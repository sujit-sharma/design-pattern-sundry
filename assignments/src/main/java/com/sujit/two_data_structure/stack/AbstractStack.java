package com.sujit.two_data_structure.stack;

public  abstract class AbstractStack<T> implements Stack<T> {

    public boolean isEmpty() {
        return this.size() <= 0;
    }

}
