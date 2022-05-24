package com.improve.javaBasics.multiithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ExploreReentrantLock {

    public void lockMethodInRELock() {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new NormalReLocker(lock);
        t1.setName("t1");
        Thread t2 = new NormalReLocker(lock);
        t2.setName("t2");
        t1.start();
        t2.start();
    }
    public void syncTheRELock() {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new SyncReLocker(lock);
        t1.setName("t1");
        Thread t2 = new SyncReLocker(lock);
        t2.setName("t2");
        t1.start();
        t2.start();
    }



    public static void main(String[] args) {
        ExploreReentrantLock exploreReentrantLock = new ExploreReentrantLock();
        exploreReentrantLock.syncTheRELock();
    }

}

class NormalReLocker extends Thread {
    private ReentrantLock lock;

    public NormalReLocker(){}

    public NormalReLocker(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Trying to lock");
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " Lock is locked");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " Completed");
            lock.unlock();
        }
    }
}

class SyncReLocker extends Thread {
    private ReentrantLock lock;

    public SyncReLocker(){}

    public SyncReLocker(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Trying to sync lock");
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " Lock is locked by sync");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Completed");
        }
    }
}