//If the thread is not in sleeping state , we have called the interrupt method then no exception/error will be raised ,the method wait until the thread goes into waiting state(sleeping state).
//If the target thread never enters the sleeping state ,then there is no impact of interrupt method this is only case where interrupt call is wasted.

package com.multithreading;

public class ThreadInterrupt {
    public static void main(String [] args)
    {
        mt5 t = new mt5();   //from ThreadSleep file.
        t.start();

        t.interrupt();  //interrupt method , here the sleeping thread got interrupted.
        System.out.println("Main Thread");
    }
}

class mt5 extends Thread{
    public void run(){
        for(int i=0;i<50;i++)
            System.out.println("Child thread "+ i);

        System.out.println("Entering the sleep state , good night ");
        try{
            Thread.sleep(100);      //till this line the child thread will get executed.
        }
        catch (InterruptedException e){
            System.out.println("Got Interrupted");
        }
    }
}


//Difference between join() , yield () and sleep().