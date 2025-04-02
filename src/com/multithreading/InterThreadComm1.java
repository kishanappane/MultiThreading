/*
two threads can communicate with each other by using wait, notify , notifyAll .   -->(present in object class ,not in thread class)
->The Thread which is expecting updation is  responsible for calling waiting state.
->thread which is responsible to perform updation , after performing the updation it is responsible to call notify method ,then waiting thread will get that notification then continue with execution with those updated items.

->to call these three methods ,we need to acquire the object lock ,so the thread should be inside synchronized area . we can call
these  methods from synchronized area only.

*/

/*
thread can call wait method on any java object , so to avail that method on any object so we keeping it in object class.
->if a thread calls a notify() method ,it will release the lock but may not immediately.
->thread releases locks only in wait() , notify() , notifyAll().
 */

/*
if multiple thread for waiting for notification than .notify() method will only notify one thread , and that one thread is also decided by JVM
we can use .notifyAll() to give notification to notify all threads which are waiting for that particular thread , even though multiple thread gets notified but execution happens
one by one bcoz thread needs to acquire object lock to perform action.
 */


package com.multithreading;

public class InterThreadComm1 {
    public static void main(String [] args) throws InterruptedException
    {
         mt8 t1 = new mt8();
         t1.start();
         synchronized (t1)
         {
             System.out.println("Main thread trying to call wait() method");
             t1.wait(1000);  //adding time to stop in-definate waiting and also works well when child thread first chance, so it is recommended  instead of t1.wait();
             System.out.println("Main thread got notified");
             System.out.println(t1.total);
         }
    }
}


class mt8 extends Thread
{
    int total = 0;
    public void run()
    {
       synchronized(this)
       {
           System.out.println("Child Thread starts calculation");
           for(int i=0;i<=100;i++)
               total = total + i;
           System.out.println("Child Thread trying to give notification");
           this.notify();
       }

    }

}

//public final void wait() throws Interrupted Exception;
//public final void wait(long ms,int ns) throws IE;
//Notify impact on thread state transition diagram.(Part-10 ,1:14:20)

/*
Producer-Consumer Problem

class ProducerThread                                class ConsumerThread
{                                                   {
produce()                  COMMON QUEUE q               consume()
{                                                    {
synchronized(q)                                        synchronized(q)
{                                                       {
produce item to the queue                                  if(q.isEmpty())
q.notify();                                                   q.wait();
}                                                          else
}                                                              consume items
}                                                        }
                                                      }
                                                     }



 */