package cn.ly.problem;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 离开教室");
                countDownLatch.countDown();

            },String.valueOf(i+1)).start();
        }

        new Thread(()->{

            try {
                countDownLatch.await(); // 当指定数量的线程完成任务时，再执行某个线程时适用
                System.out.println(Thread.currentThread().getName() + "\t 班长锁门");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"7").start();

//        countDownLatch.await(); // 当指定数量的线程完成任务时，再执行某个线程时适用
//        System.out.println(Thread.currentThread().getName() + "\t 班长锁门");

    }
}
