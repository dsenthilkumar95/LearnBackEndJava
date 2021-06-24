package com.improve.javaBasics;

public class InterruptingThread extends Thread{
    @Override
    public void run(){
        for(int i=1;i<=2;i++){
            if(Thread.interrupted()){
                System.out.println("code for interrupted thread at i="+i);
            }
            else{
                System.out.println("code for normal thread at i="+i);
            }
        }
    }

    public static void main(String args[]){

        InterruptingThread t1=new InterruptingThread();
        InterruptingThread t2=new InterruptingThread();

        t1.start();
        t1.interrupt();
        System.out.println("Thread1 interrupt state -> " + t1.isInterrupted());
        t2.start();

    }
}
