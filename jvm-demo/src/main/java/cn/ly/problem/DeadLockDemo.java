package cn.ly.problem;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo implements Runnable{
    private String lockA;
    private String lockB;

    public DeadLockDemo(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+ "\t 持有" + lockA + " 尝试获取 "+ lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+ "\t 持有" + lockB + " 尝试获取 "+ lockA);
            }
        }
    }

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new DeadLockDemo(lockA,lockB),"AAAA").start();
        new Thread(new DeadLockDemo(lockB,lockA),"BBBB").start();
    }
}
