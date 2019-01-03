package com.zhaokai.Sample;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Counter{
    //private Lock Lock  = new ReentrantLock();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock rlock = readWriteLock.readLock();
    private  Lock wlock = readWriteLock.writeLock();
    private int value = 0;
    public void add(int m){
        try {
            if (wlock.tryLock(3, TimeUnit.SECONDS)) {
                try {
                    this.value += m;
                } finally {
                    wlock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void des(int m ){
        wlock.lock();
        try{
            this.value -=m;
        }finally {
            this.wlock.unlock();
        }
    }
    public int get(){
        rlock.lock();
        try{
            return this.value;
        }finally {
            rlock.unlock();
        }
    }
}

public class Main {
    final static int Loop = 100;
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(){
            @Override
            public void run(){
              for (int i=0;i< Loop;i++){
                  counter.add(1);
              }
          }
        };

        Thread t2 = new Thread(){
          @Override
          public void run(){
              for (int i=0;i<Loop;i++){
                  counter.des(1);
              }
          }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.get());

    }
}
