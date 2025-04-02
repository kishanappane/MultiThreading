/*
sometimes the thread needs to return some things but the runnable implements void method so we have Callable interface which
implements call method to overcome this issue.
 */

package com.multithreading;

import java.util.concurrent.*;

public class ThreadPools2 {
    public static void main(String [] args) throws ExecutionException, InterruptedException {

        MyCallable [] jobs ={
                                 new MyCallable(10),
                                 new MyCallable(20),
                                 new MyCallable(30),
                                 new MyCallable(40) };
        ExecutorService service = Executors.newFixedThreadPool(3);

        for(MyCallable job :jobs)
        {
            Future f =  service.submit(job);
            System.out.println(f.get());
        }
        service.shutdown();
    }
}

class MyCallable implements Callable{
    int num;
    MyCallable(int num)
    {
        this.num=num;
    }
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " ... is responsible for sum of first "+ num + " numbers ");
        int sum=0;
        for(int i=1;i<=num;i++)
        {
            sum = sum+i;
        }
        return sum;
    }
}
