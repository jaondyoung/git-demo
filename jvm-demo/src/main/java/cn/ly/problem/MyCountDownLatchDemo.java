package cn.ly.problem;

import java.util.concurrent.atomic.AtomicInteger;

public class MyCountDownLatchDemo {
    public volatile int total;


    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 离开教室");
                //count.incrementAndGet();
                count.decrementAndGet();

            },String.valueOf(i+1)).start();
        }

        while(count.get() != 0){
            // 什么也不做
        }
        System.out.println(Thread.currentThread().getName() + "\t 班长锁门");

    }
}
