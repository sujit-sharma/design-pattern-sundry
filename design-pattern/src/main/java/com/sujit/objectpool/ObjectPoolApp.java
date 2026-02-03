package com.sujit.objectpool;

import java.util.logging.Logger;

public class ObjectPoolApp {
    public static void main(String[] args) throws InterruptedException {
        ObjectPool<Connection> pool = new ObjectPool<>(2, Connection::new);

        Connection first = pool.borrowObject();
        first.execute("SELECT * FROM users");
        pool.returnObject(first);

        Connection reused = pool.borrowObject();
        Logger.getGlobal().info("Borrowed again: " + reused);
        reused.execute("SELECT * FROM orders");
        pool.returnObject(reused);
    }
}
