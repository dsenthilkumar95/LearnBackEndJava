package com.improve.javaBasics.multiithreading;

public class ExploreThreadInterupting extends Thread{
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

        ExploreThreadInterupting t1=new ExploreThreadInterupting();
        ExploreThreadInterupting t2=new ExploreThreadInterupting();

        t1.start();
        t1.interrupt();
        System.out.println("Thread1 interrupt state -> " + t1.isInterrupted());
        t2.start();

    }
}
