
//If a thread dont want to perform any operation for particular amount time than we should go for sleep method
//every sleep throws interrupted exception which checked exception hence whenever we are using sleep method compulsory we should handle IE either by try-catch or by throws keyword otherwise will get CE.
//public static void sleep(long ms,int ns)

package com.multithreading;

public class ThreadSleep {
    public static void main(String [] args)
    {
        mt4 t = new mt4();
        t.start();

        for(int i=0;i<5;i++)
            System.out.println("Main Thread");
    }
}

class mt4 extends Thread{
    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("child is running");
                Thread.sleep(1000);
            }
        }

        catch(InterruptedException e)
        {
            System.out.println("Thread got interrupted");
        }
    }
}

// a thread can interrupt a sleeping thread or a waiting thread by using a interrupt method of thread class
// public void interrupt
