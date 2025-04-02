//run method overloading is valid but the start method will call no-arg method only , overloaded run method has to called explicitly like a normal method call
// if we are not over-riding run  method than the parent[Thread] class run method will get executed , which has empty implementation. no o/p
//if we have start method in child thread class then it will be treated as normal method. or we can have start method in which we will call parent[Thread class] start method like line 25.

//getName and setName are part of Thread class.

package com.multithreading;

public class ThreadClassOverloading {
    public static void main(String [] args){
        MyThread1 t =new MyThread1();
        t.start();
        //t.run(5);  --explicitly calling the argumented run method.

        System.out.println("Main Method");
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("Pawan Kalyan");
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread1 extends Thread{

    public void start()
    {
        //super.start();
        run(4);   //calling the int-arg method explicitly in start  method.
        System.out.println("start-method");

    }
    public void run(){
        System.out.println("no-arg method");
    }

    public void run(int i){
        System.out.println("int-arg method");
    }
}
