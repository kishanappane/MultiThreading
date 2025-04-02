/*
we can prevent a thread execution by using following methods.
->yield()
->join()
->sleep()
 */

/*
yield method causes to pause current executing thread to give the chance for waiting threads of same priority. if there is no waiting thread or the waiting threads have low priority than same threads can continue to execute.
->if multiple threads are waiting with the same priority than we cannot except which will get chance , it depends on threadScheduler.
->the thread which is yielded ,when will get the chance once again it depends on thread scheduler.

->yield will take the thread from running to ready/runnable state.

 */



package com.multithreading;

public class ThreadYield {
    public static void main(String [] args){
        Mt t =new Mt();
        t.start();
        for(int i=0;i<10;i++)
            System.out.println("Main Thread");

    }
}

class Mt extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("child thread");
            Thread.yield();
        }
    }
}

/*
in the above program as we are having the yield method in child class then the chance of completing the main thread first is more than the child thread.
->some platform wont provide proper support for yeild method.
 */
