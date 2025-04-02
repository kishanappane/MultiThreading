//only applicable for methods and blocks
//used to resolve data inconsistency problem we need to go for synchronizer
//if a method is declared as synchronizer than at a time only one thread is allowed to execute that method or blocks.
//increases the waiting period.

/*every java object has a lock ,internally the synchronizer is implemented by using this locks.
once the synchronizer method execution completes then thread releases the lock ,jvm will perform locking and unlocking automatically
 */

/*when a thread is executing the synchronizer method on a object than any other threads are not allowed to executed any other synchronizer methods but they can execute any non-synchronized methods as lock concept is based on objects and not on methods.
-->every object has to areas 1.synchronized Area 2.Non-synchronized Area.
*/

package com.multithreading;


public class ThreadSynchronisation {
    public static void main(String [] args){
        Display D=new Display();
        mt6 t1=new mt6(D,"Dhoni");
        mt6 t2=new mt6(D,"Yuvaraj");
        mt6 t3=new mt6(D,"Kholi");
        t1.start();
        t2.start();
        t3.start();
    }
}


class Display{
    public synchronized void wish(String name){
        for(int i=0;i<10;i++){
            System.out.print("Good Morning ");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){}
            System.out.println(name);
        }
    }
}


class mt6 extends Thread{
    Display d;
    String name;
    mt6(Display d,String name){
        this.d=d;
        this.name=name;
    }
    public void run(){
        d.wish(name);
    }
}

/*
if only synchronized keyword is used, and we have multiple objects and multiple threads executing separately then there will be irregular output same as non-synchronized outputs.
 but if the method is declared as static synchronized then separate threads executing on different objects will also have synchronized outputs.[class level is lock concept will be used]
 */

/*
while a thread is executing the static synchronized methods than other threads are not allowed to execute static synchronized methods simultaneously[bcoz of class level lock]  but other threads are allowed execute
following methods
->normal static method
->synchronized methods              Threading Part 8 ,31:57 a diagram for better understanding
->normal methods
 */

/*
even if two different class are referring to different synchronized methods of same object than we will get a regular output[ coz of object lock]
 */