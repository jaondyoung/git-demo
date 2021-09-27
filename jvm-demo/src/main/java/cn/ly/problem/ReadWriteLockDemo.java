package cn.ly.problem;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读读没问题
 * 写读有问题
 * 写写有问题
 */
public class ReadWriteLockDemo {


    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        for (int i = 1; i < 6; i++) {
            final int tempi = i;
            new Thread(()->{
                myResource.put(tempi+"",tempi+"");
            },String.valueOf(i+1)).start();
        }

        for (int i = 1; i < 6; i++) {
            final int tempi = i;
            new Thread(()->{
                myResource.get(tempi+"");
            },String.valueOf(i+1)).start();
        }

    }
}

class MyResource{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在写入:" + key);
            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }


    }

    public void get(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在读取:");
            TimeUnit.MICROSECONDS.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取完成:"+ result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }
}
