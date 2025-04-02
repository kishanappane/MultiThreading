/*
the join used , whenever one thread is waiting for the completion of the another thread execution
if we call we have call for which thread we are joining or waiting
 */

//While preparing also make sure that the revise about the thread state chnges during join and yield methods.
//why we need -> throws IE exception !?..



package com.multithreading;

public class ThreadJoin {
    public static void main(String [] args) throws InterruptedException{
        mt3.t2 = Thread.currentThread();
        mt3 t3 =  new mt3();
        mt2 t1= new mt2();
        t3.start();
        t1.start();



      //  t1.join(10000);  -->the main thread will wait for 10 secs and then continue with its execution.
        t1.join();    //-->main thread will wait until the execution of t1 thread.
        for(int i=0;i<3;i++)
        System.out.println("Main Thread");


    }
}

class mt2 extends Thread{
    public void run(){
        for(int i=0;i<3;i++) {
            System.out.println("Child thread");
            try
            {
                Thread.sleep(100);
            }catch (InterruptedException e){

            }
        }
    }

}

class mt3 extends Thread{

    static Thread t2;    //to join the child thread to main thread we can create a static variable which can be created without creating object and then we can assign the main thread to this thread line 15.
                         //this thread will only execute once the main thread is completed with its execution.

    public void run(){

        try{t2.join();}
        catch(InterruptedException e){}
        for(int i=0;i<3;i++)
        {
            System.out.println("Child class 2");
        }

    }
}



/*
Deadlocks in Multi-threading

->if main thread calls join method on itself than it will be a deadlock
    Thread.currentThread().join();

->if main thread calls join method on child thread and child thread calls join method on main thread than it will be a deadlock.


 */