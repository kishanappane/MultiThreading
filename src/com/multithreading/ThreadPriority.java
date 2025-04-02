/*
Threads mainly has 3 priorities
        Thread.MIN_PRIORITY = 1
        Thread.NORM_PRIORITY = 5
        Thread.MAX_PRIORITY = 10

        the default priority of the main thread is 5 for all other threads the default priority will be inherited by parent thread ie same has the priority of the parent thread

 */

/*
Thread class has methods like these to handle priority
public final int getPriority();
public final void setPriority(int p );   --range 1 - 10
 */



package com.multithreading;

public class ThreadPriority {
    public static void main(String [] args)
    {
        System.out.println("Priority of the main thread" + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(7);
        System.out.println("Modified priority of the main thread" + Thread.currentThread().getPriority());
        MyThread3 t = new MyThread3();        // for this the parent class is Thread class , but the parent thread is Main thread only ,thats why it is inherited parent class priority which is 7.
        System.out.println("priority of the child thread " + Thread.currentThread().getPriority());
    }
}

class MyThread3 extends Thread{
    public void run(){
        System.out.println("child thread");
    }

}
