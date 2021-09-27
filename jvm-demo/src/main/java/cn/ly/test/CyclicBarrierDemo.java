package cn.ly.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });

        for (int i = 0; i < 21; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + "\t 收集成功");
                    cyclicBarrier.await();// 重置为0，还可以重新计数,计数3次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            },String.valueOf(i+1)).start();
        }


    }
}
