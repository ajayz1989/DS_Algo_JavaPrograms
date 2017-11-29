package com.ajay.multithread.joinexample.alternate;

/**
 * Created by ajayk297 on 29/11/17.
 */
public class Thread1 implements Runnable{

    private Object lockObject ;

    public Thread1(Object lockObject) {
        this.lockObject = lockObject;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        while (true){
            synchronized (lockObject){
                System.out.println(Thread.currentThread().getName());
                lockObject.notify();
                try {
                    lockObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
