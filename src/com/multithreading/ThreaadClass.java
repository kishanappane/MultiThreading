//Thread scheduler is part of JVM , decides in which order the threads will get executed.
//we cannot say which algo is used by scheduler it is varied by jvm to jvm , we cannot expect exact output
/*
 t.start() method take all the responsibilities
  1.register this thread with thread scheduler
  2.all other mandatory functions                 -->around 70k lines in start method.
  3.invoke run()
*/


//there are 8 type of constructors there in Thread.

package com.multithreading;

public class ThreaadClass {
      public static void main(String [] args)
      {
          MyThread t = new MyThread();  //thread initialization
          t.start();                    //starting of threads(new thread will be created)

      //  t.run ();   -->this can also used but it wont create any new threads like t.start() , the main thread itself will execute this and treat it just like a normal method

          for(int i=0;i<10;i++){

              System.out.println("Main thread ");    //  these will be executed by main thread.
          }

          MyThread t2 = new MyThread();
          Thread t3 = new Thread(t2);
          t3.start();

      }
}

class MyThread extends Thread{
    public void run(){
        for(int i=0;i<10;i++)
        System.out.println("child is running");   //executed by child thread
    }
}


