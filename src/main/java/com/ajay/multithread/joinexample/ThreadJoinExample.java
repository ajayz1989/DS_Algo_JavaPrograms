package com.ajay.multithread.joinexample;

/**
 * Created by ajayk297 on 29/11/17.
 */
public class ThreadJoinExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(),"t1");
        Thread thread2 = new Thread(new MyRunnable(),"t2");
        Thread thread3 = new Thread(new MyRunnable(),"t3");

        thread3.start();
        thread2.start();
        try{
            thread2.join();

        }catch (InterruptedException i){
            i.printStackTrace();
        }
        thread1.start();
    }

    static class MyRunnable implements Runnable{

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
            Thread t = Thread.currentThread();
            System.out.println("Thread Started:-" + t.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread Ended:-" + t.getName());

        }
    }
}
