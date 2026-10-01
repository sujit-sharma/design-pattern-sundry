package com.sujit.objectpool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.function.Supplier;

/** A bounded, thread-safe pool that blocks when all objects are in use. */
public class ObjectPool<T extends Reusable> {
    private final Deque<T> available = new ArrayDeque<>();
    private final Set<T> borrowed = new HashSet<>();
    private final Supplier<T> factory;
    private final Semaphore capacity;

    public ObjectPool(int maxSize, Supplier<T> factory) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must be positive");
        }
        this.capacity = new Semaphore(maxSize, true);
        this.factory = factory;
    }

    public T borrowObject() throws InterruptedException {
        capacity.acquire();
        synchronized (this) {
            T object = available.pollFirst();
            if (object == null) {
                try {
                    object = factory.get();
                } catch (RuntimeException | Error failure) {
                    capacity.release();
                    throw failure;
                }
            }
            borrowed.add(object);
            return object;
        }
    }

    public void returnObject(T object) {
        synchronized (this) {
            if (!borrowed.remove(object)) {
                throw new IllegalArgumentException("Object was not borrowed from this pool");
            }
            object.reset();
            available.addLast(object);
            capacity.release();
        }
    }
}
