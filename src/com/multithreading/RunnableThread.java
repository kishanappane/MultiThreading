/*
the runnable interface have only run method , the Thread class also extends runnable interface . but if we are implementing runnable interface than we have make use of Thread class as we need start() method to register the thread to the thread scheduler.
 */

//runnable is recommended over Thread class coz we can have a option to extend a class.



package com.multithreading;

public class RunnableThread {
    public static void main(String [] args){
            Runn1 r= new Runn1();
            Thread t = new Thread(r);
            t.start();

            for(int i=0;i<10;i++)
                System.out.println("parent class");
    }
}

class Runn1 implements Runnable{
    public void run(){
        for(int i=0;i<10;i++)
            System.out.println("Child Class");
    }
}



/*
runn1 r=new runn1
Thread t1 = new Thread();
Thread t2 = new Thread(r);

case 1 : t1.start()     -->a new thread will be created which is responsible of execution of thread class run method.[new thread]
case 2 : t1.run()       -->run method exectued just like a normal method [no new thread]
case 3 : t2.start()      -->a thread is created which is responsible for executing runn1 class run method
case 4 : t2.run()        -->normal method , but run() in runn1 will be executed.
 */
