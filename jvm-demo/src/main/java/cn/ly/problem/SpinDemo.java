package cn.ly.problem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>(null);

    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " 获得锁");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myunLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName() + " 释放锁");
    }

    public static void main(String[] args) {
        SpinDemo spinDemo = new SpinDemo();

        new Thread(()->{
            spinDemo.mylock();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                spinDemo.myunLock();
            }


        },"aa").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            spinDemo.mylock();


            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                spinDemo.myunLock();
            }


        },"bb").start();

    }
}
