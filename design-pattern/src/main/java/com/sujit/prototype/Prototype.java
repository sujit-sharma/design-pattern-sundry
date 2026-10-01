package com.sujit.prototype;

/** A type that can create an independent copy of itself. */
public interface Prototype<T> {
    T copy();
}
