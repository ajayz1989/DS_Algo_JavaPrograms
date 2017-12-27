package com.test.reentrantlock;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ajayk297 on 09/08/17.
 */
public class ReentrantLockDemo {

    private Lock lock = new ReentrantLock(true);
    private static int counter = 0;


    private void increment() {
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }

    //lock using reentrant lock
    private void firstThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    //lock using reentrant lock
    private void secondThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public static void main(String arg[]) throws InterruptedException {
        ReentrantLockDemo demo = new ReentrantLockDemo();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.secondThread();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();


        System.out.println(Thread.currentThread().getName() + " get count-" + counter);

    }

}
