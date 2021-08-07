package cn.ly.problem;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock版的生产消费者
 */
class MyData2{
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 生产
    public void increment() {
        lock.lock();
        // 1.判断
        while(num != 0){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 2.干活
        num++;
        System.out.println(Thread.currentThread().getName() + "\t 生产 " + num);

        // 3.通知
        condition.signalAll();

        lock.unlock();

    }

    // 消费
    public void decrement() {
        lock.lock();
        // 1.判断
        while(num == 0){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 2.干活
        num--;
        System.out.println(Thread.currentThread().getName() + "\t 消费 " + num);

        // 3.通知
        condition.signalAll();
        lock.unlock();
    }

}

public class ProductConsumerTranditionDemo {
    public static void main(String[] args) {
        MyData2 myData = new MyData2();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                myData.increment();
            }

        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                myData.decrement();
            }

        },"B").start();


        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                myData.increment();
            }

        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                myData.decrement();
            }

        },"D").start();
    }
}
