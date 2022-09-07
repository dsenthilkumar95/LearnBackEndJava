package com.improve.javaBasics.multiithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ExploreReentrantLock {

    public static void main(String[] args) {
        ExploreReentrantLock exploreReentrantLock = new ExploreReentrantLock();
//        exploreReentrantLock.syncTheRELock();
//        exploreReentrantLock.reentrantNature();
        exploreReentrantLock.lockInterruptiblyTest();
    }

    public void lockInterruptiblyTest() {
        ReentrantLock lock = new ReentrantLock();
        Thread t = new InteruptingThread(lock);
        t.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Not sure how this value becomes 0
        System.out.println("Lock count after thread exits " + lock.getHoldCount());
    }

    public void reentrantNature() {
        Resource resource = new Resource();
        ReentrantLock lock = new ReentrantLock();
        resource.method1(lock);
    }

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
}

class InteruptingThread extends Thread {

    private ReentrantLock lock;
    public InteruptingThread() {}
    public InteruptingThread(ReentrantLock lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        lock.lock();
        System.out.println("Lock count after lock "+lock.getHoldCount());
        interrupt();
        System.out.println("Lock count after interrupt "+lock.getHoldCount());
        try {
            lock.lockInterruptibly();
            lock.getQueueLength();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Lock count after InterruptedException "+lock.getHoldCount());
        }
    }
}

class Resource {
    private int count = 0;
    public void method1(ReentrantLock lock) {
        System.out.println("Method1 Trying to lock");
        lock.lock();
        System.out.println("Method1 Lock is locked");
        try {
            System.out.println("Method1 lock count after lock " + lock.getHoldCount());
            this.method2(lock);
            this.count++;
            System.out.println("Method1 count " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("Method1 lock count after unlock " + lock.getHoldCount());
        }
    }
    public void method2(ReentrantLock lock) {
        System.out.println("Method2 Trying to lock");
        lock.lock();
        System.out.println("Method2 Lock is locked");
        try {
            System.out.println("Method2 lock count after lock " + lock.getHoldCount());
            this.count++;
            System.out.println("Method2 count " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("Method2 lock count after unlock " + lock.getHoldCount());
        }
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