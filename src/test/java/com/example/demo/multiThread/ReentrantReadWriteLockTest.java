package com.example.demo.multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReentrantReadWriteLockTest {
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static ReadLock  readLock = reentrantReadWriteLock.readLock();
    private static WriteLock writeLock = reentrantReadWriteLock.writeLock();
    private static int value;
    private static CountDownLatch cdl=new CountDownLatch(20);

    public static Object handleRead(ReadLock lock) throws InterruptedException {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+" 读操作:" + value);
            Thread.sleep(500);// 模拟读操作
            System.out.println(Thread.currentThread().getName()+" 读操作:" + value);
            return value;
        } finally {
            lock.unlock();
            cdl.countDown();
        }
    }
    public static Object handleReadWrite(ReentrantReadWriteLock lock) throws InterruptedException {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+" 读操作:" + value);
            Thread.sleep(500);
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+" 写操作:" + ++value);
            return value;
        } finally {
            
            lock.writeLock().unlock();
            lock.readLock().unlock();
            cdl.countDown();
        }
    }
    
    public static Object handleWriteRead(ReentrantReadWriteLock lock) throws InterruptedException {
        try {
        	lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+" 写操作:" + ++value);
            Thread.sleep(500);
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+" 读操作:" + value);
            
            
            return value;
        } finally {
            lock.readLock().unlock();
            lock.writeLock().unlock();
            cdl.countDown();
        }
    }

    public static void handleWrite(WriteLock lock)
            throws InterruptedException {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+" 写操作:" + value++);
            Thread.sleep(500);// 模拟写操作
            System.out.println(Thread.currentThread().getName()+" 写操作:" + value++);
            
        } finally {
            lock.unlock();
            cdl.countDown();
        }
    }

    public static void main(String[] args) throws Exception {
        
        
        System.out.println(System.currentTimeMillis()+"开始了！");
        /**
         	* 同一个ReentrantReadWriteLock的读写锁，在不同线程间不重入
         */
        TestReadThread testReadThread = new TestReadThread();
        TestWriteThread testWriteThread = new TestWriteThread();
        for (int i = 0; i < 10; i++) {
        	
            new Thread(testReadThread).start();
           
        }
        for (int i = 0; i < 10; i++) {
        	
            new Thread(testWriteThread).start();
            
        }
        /**
     	* 同一个ReentrantReadWriteLock的读写锁，在同一个线程间可降级，多个进程间读锁可重入，写锁不可重入
	     */
//        TestWriteReadThread testWriteReadThread = new TestWriteReadThread();
//	    for (int i = 0; i < 20; i++) {
//	    	
//	        new Thread(testWriteReadThread).start();
//	       
//	    }
	    /**
     	* 同一个ReentrantReadWriteLock的读写锁，在同一个线程间不可升级，多个进程间读锁可重入
	     */

//	    TestReadWriteThread testReadWriteThread = new TestReadWriteThread();
//	    for (int i = 0; i < 20; i++) {
//	    	
//	        new Thread(testReadWriteThread).start();
//	       
//	    }
        cdl.await();
        System.out.println(System.currentTimeMillis()+"结束了！");

    }
    
    private static class TestReadThread extends Thread {
        @Override
        public void run() {
            try {
                ReentrantReadWriteLockTest.handleRead(readLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static class TestReadWriteThread extends Thread {
        @Override
        public void run() {
            try {
                ReentrantReadWriteLockTest.handleReadWrite(reentrantReadWriteLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static class TestWriteReadThread extends Thread {
        @Override
        public void run() {
            try {
                ReentrantReadWriteLockTest.handleWriteRead(reentrantReadWriteLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static class TestWriteThread extends Thread {
        @Override
        public void run() {
            try {
                ReentrantReadWriteLockTest.handleWrite(writeLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}