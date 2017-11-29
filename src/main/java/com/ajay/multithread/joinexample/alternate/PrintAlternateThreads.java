package com.ajay.multithread.joinexample.alternate;

/**
 * Created by ajayk297 on 29/11/17.
 */
public class PrintAlternateThreads {

    public static void main(String[] args) {
        Object lockObject = new Object();
        Thread thread1 = new Thread(new Thread1(lockObject), "thread1");
        Thread thread2 = new Thread(new Thread2(lockObject), "thread2");

        thread1.start();
        thread2.start();
    }
}
