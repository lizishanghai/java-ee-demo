package ca.ws.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class Concurrent {
	
	@Test
    public void lock() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println("hello world");
        } finally {
            lock.unlock();
        }
    }

}
