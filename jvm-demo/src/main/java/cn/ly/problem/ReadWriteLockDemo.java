package cn.ly.problem;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 有问题
 */
public class ReadWriteLockDemo {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock lockOne = new ReentrantLock();

    public static void main(String[] args) {

        for (int i = 1; i < 3; i++) {
            new Thread(()->{
                lockOne.lock();
                System.out.println(Thread.currentThread().getName()+"\t 写入中");
                lockOne.unlock();
                System.out.println(Thread.currentThread().getName()+"\t 写入完成");
            },String.valueOf(i+1)).start();
        }

        for (int i = 4; i < 6; i++) {
            new Thread(()->{
                lockOne.lock();
                System.out.println(Thread.currentThread().getName()+"\t 读取中");
                lockOne.unlock();
                System.out.println(Thread.currentThread().getName()+"\t 读取完成");
            },String.valueOf(i+1)).start();
        }

    }
}
