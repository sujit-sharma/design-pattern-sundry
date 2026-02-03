package com.sujit.objectpool;

/** An object that can be reset before it is returned to a pool. */
public interface Reusable {
    void reset();
}
