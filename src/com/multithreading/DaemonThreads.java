//The thread which is executing in the background are called daemon thread , eg:Garbage Collector.

/*the main objective of the daemon threads is to provide support for non-daemon thread, for example if main thread runs with low memory than
JVM runs garbage collector to destroy useless objects ,so number of bytes of free memory is improved.*/

//usually daemon threads runs with low priority,but based on requirements JVM increase/decrease the priority of the daemon threads.

/*
->Main thread is always non-daemon
->all threads will inherit daemon nature from parent to child ie if parent is daemon then child is daemon and vice versa.
->impossible to change the daemon nature of main thread as it is started by JVM itself at begin.
 */

package com.multithreading;

public class DaemonThreads {
    public static void main(String [] args){
        mt9 t1 = new mt9();
        t1.setDaemon(true);  //as this thread is set as daemon thread as soon as Main thread[non daemon] execution completes it will get terminated.
        t1.start();
        System.out.println("End of Main Thread");

    }
}

class mt9 extends Thread{
    public void run(){
        for(int i=0;i<10;i++)
        {
            System.out.println("Child Thread");
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){}
        }
    }
}




/*
->public boolean isDaemon()      : to check whether the thread is daemon or not.
->public void setDaemon(boolean b)       : Daemon nature can only be changed before the start of the thread , if we try it once the thread starts then we will get IllegalThreadStateException
 */

//when-ever last non daemon threads terminated all daemon will get terminated irrespective of their situation.


//Thread stop , suspend and resume almost self-explanatory , these are deprecated and not recommended to use.