/*
if very few lines of code required synchronisation than it is not required to declare entire method are synchronized we can declare those lines in synchronized block.
->reduces waiting time ,improve performance.
->thread has to get the lock to execute this block.
 */

/*
types of declaration
-->to get the lock of current object            to get the lock of particular object        to get class level lock
synchronized(this)                               synchronized(b)                             synchronized(Display.class)
{                                                {                                           {

}                                                 }                                           }

 */

//lock concept applicable only for object types and class types hence we cannot pass primitive type as argument to sync block.



package com.multithreading;

public class ThreadSynchronizedBlock {
    public static void main(String [] args ){
        Display1 D = new Display1();
        mt7 t1=new mt7(D," Kishan");
        mt7 t2 =new mt7(D," Ram");
        t1.start();
        t2.start();
    }
}

class Display1{
    public void wish(String name){
        //1 lakh lines of code
        synchronized (this)                 //synchronized(Display.class)
        {
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
        }
    }
}

class mt7 extends Thread{
    Display1 D;
    String name;
    mt7(Display1 D, String name)
    {
        this.D=D;
        this.name=name;
    }
    public void run()
    {
        D.wish(name);
    }
}


/*A thread can have multiple locks from different objects.
*  class x{
* Y y = new Y();
* synchronized(y)
* {
*    Z z =new Z();
*    synchronized(z)
*    {
*            here thread has lock of x,y,z.
*     }
* }
* }
*
* */