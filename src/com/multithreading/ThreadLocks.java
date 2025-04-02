/*
Disadvantage of Synchronized keyword
->we do not have flexibility to try for a lock without waiting.
->as the threads has to wait indefinitely to acquire lock ,it leads to deadlock [no way to define maximum waiting period]
->there is no mechanism to define which thread will get the chance once the current lock is released.
->we can use synchronized keyword to the whole method or a block inside the method but not in between two methods.
 */

/*
Locks advantage :
->lock obj is similar to implicit lock acquired to execute sync block or method.
->
 */


//java.util.concurrent  package









package com.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocks {
    public static void main(String [] args){

        Display2 D=new Display2();
        mt10 t1=new mt10(D,"Dhoni");
        mt10 t2=new mt10(D,"Yuvaraj");

      //  t1.start();
      //  t2.start();                 //uncomment this to execute lock threads

        mt11 thread1 = new mt11("first thread");
        mt11 thread2 = new mt11("second thread");
        thread1.start();
        thread2.start();              //thread which are using trylock.  ,you can also use try(5000,TimeUnit.MILLISECONDS) to wait for certain peroid .

    }
}


class mt10 extends Thread{
    Display2 d;
    String name;
    mt10(Display2 d,String name){
        this.d=d;
        this.name=name;
    }
    public void run(){
        d.wish(name);
    }
}

class Display2{
    ReentrantLock l = new ReentrantLock();

    public void wish(String name){
        //1 lakh lines of code

        l.lock();      //instead of using synchronize keyword like in program   ThreadSynchronisation.java we have used lock to lock only the required area.

            for(int i=0;i<10;i++)
            {
                System.out.print("Good Morning");
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){}
                System.out.println(name);
            }
        l.unlock();

    }
}

class mt11 extends Thread
{
    static ReentrantLock l1 =new ReentrantLock();
    mt11(String name)
    {
        super(name);
    }

    public void run()
    {
        if(l1.tryLock())
        {
            System.out.println(Thread.currentThread().getName()+ " ...got the lock performing safe operations");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){}
            l1.unlock();
        }
        else
        {
            System.out.println(Thread.currentThread().getName() + "...unable to get the lock performing alternative operation");
        }
    }
}




/*
Methods in Locks:
1.Void lock()
  l.lock()          -->to acquire a lock(if available) ,else it will wait until getting the lock[same as sync]

2.boolean tryLock()
   l.tryLock()        -->if it gets lock it will perform that specific operation[exclusive] , else it will continue with other operation
   l.tryLock(1,TimeUnit.HOUR)  -->it will wait for one hour to acquire lock ,then will continue with other operation
     ->TimeUnit is a enum present in java.util.concurrent package.

 3.void unlock()
   l.unlock()     -->it is only applicable if that particular thread has a lock ,else it will throw RE:IlligleMonitorStateException
 */
