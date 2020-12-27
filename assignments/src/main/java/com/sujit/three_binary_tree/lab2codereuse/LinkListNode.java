package com.sujit.three_binary_tree.lab2codereuse;

public class LinkListNode<T> {
    private T data;
    private LinkListNode next;

    public LinkListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkListNode getNext() {
        return next;
    }

    public void setNext(LinkListNode next) {
        this.next = next;
    }
}
