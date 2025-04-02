/*
->creating a new thread for every independent may cause memory and performance issues, to solve this thread-pool can be used
 ->TP is a pool of already created threads ready to do our job. TP is  also known as Executor service.
 */


package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {
    public static void main(String [] args){
        PrintJob [] jobs ={
                              new PrintJob("Ravi"),
                              new PrintJob("Kishan"),
                              new PrintJob("Ram"),
                              new PrintJob("shiva"),
                              new PrintJob("Prasad"),
                              new PrintJob("karan"),
        };
        ExecutorService service= Executors.newFixedThreadPool(3);    //if there is no executor framework we need to implement all these threads by declaring each one of them.

        for(PrintJob job : jobs){
            service.submit(job);
        }
        service.shutdown();
    }
}

class PrintJob implements Runnable
{
    String name;
    PrintJob(String name){
        this.name = name;
    }

    public void run(){
        System.out.println(name+ " ...Job started by Thread: " + Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){}
        System.out.println(name + " ....Job completed by Thread : " +Thread.currentThread().getName());
    }

}


/*
while developing web servers we can use thread pool concept.
 */