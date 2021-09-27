package cn.ly.problem;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MoreThreadTogetherDemo {

    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName() + "\t:"+System.currentTimeMillis());

            },String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
