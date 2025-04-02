/*
->Based on functionality we can group the threads  which nothing but thread groups.
->Thread group can also contain sub-thread groups.
->Main advantage  of this is we can perform common operation very easily.
 */


package com.multithreading;
import  java.lang.*;

public class ThreadGroups {
    public static void main(String [] args){
        System.out.println(Thread.currentThread().getThreadGroup().getName());  //main
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());   //system

        ThreadGroup g1 = new ThreadGroup("First Group");
        System.out.println(g1.getParent().getName());  //Main

        ThreadGroup g2 = new ThreadGroup(g1 , "Second Group");
        System.out.println(g2.getParent().getName()); //first group


        //System->Main->firstGroup->SecondGroup (Parental representation)

        Thread t1 = new Thread(g1, "First Thread");
        t1.setPriority(10);

        g1.setMaxPriority(4);
        Thread t2 = new Thread(g1, "Second Thread");

        System.out.println("First Thread Priority after changing group priority" + t1.getPriority());  //even though the group max priority is set to 4 but the t1 was already present in the group its priority won't get change but it is applicable for newly added threads.
        System.out.println("Second Thread Priority " +t2.getPriority());

        g1.list();   //to get details about the thread.

    }
}


/*
every thread in java belongs to some group , main thread belongs to main group every thread group in java is a child group of system group either directly or indirectly.
system group contains level system level threads
*finalizer (garbage collector)
*reference handler
*signal dispatcher
*attach listener
 */

/*
Thread group is class and direct child class of object and present in java.lang package .

ThreadGroup g = new ThreadGroup("First Group");    the parent group this threadGroup is the thread group of the current thread which executes this .
//"First group is the group name"
 */