package cn.ly.problem;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * lock的conditon可以精确唤醒
 */
class ShareResouce{
    private int num = 0;
    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void print5(){
        lock.lock();
        while(num != 0){
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "\t 打印次数:" + (i+1));
        }

        num=1;
        b.signal();

        lock.unlock();
    }

    public void print10(){
        lock.lock();
        while(num != 1){
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "\t 打印次数:" + (i+1));
        }

        num=2;
        c.signal();

        lock.unlock();
    }

    public void print15(){
        lock.lock();
        while(num != 2){
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 15; i++) {
            System.out.println(Thread.currentThread().getName() + "\t 打印次数:" + (i+1));
        }

        num=1;
        a.signal();

        lock.unlock();
    }

}

public class LockConditionDemo {

    public static void main(String[] args) {
        ShareResouce shareResouce = new ShareResouce();

        new Thread(()->{
            shareResouce.print5();
        },"AAA").start();

        new Thread(()->{
            shareResouce.print10();
        },"BBB").start();


        new Thread(()->{
            shareResouce.print15();
        },"CCC").start();
    }
}
