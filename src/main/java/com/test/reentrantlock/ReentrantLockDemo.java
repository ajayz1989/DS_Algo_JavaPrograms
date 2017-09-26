package com.test.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ajayk297 on 09/08/17.
 */
public class ReentrantLockDemo {

    private Lock lock = new ReentrantLock(true);
    private int counter = 0;

    //lock using reentrant lock
    private int getCounter(){

        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + " get count-" + counter);
                counter++;
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
        finally {
            lock.unlock();
        }
        return counter;
    }

    private synchronized int getSynchronizedCount(){
        return counter++;
    }

    public static void main(String arg[]){

    }

}
