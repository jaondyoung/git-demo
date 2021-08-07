package cn.ly.problem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference(1,100);
    public static void main(String[] args) {

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t " + "改变前版本:"+stampedReference.getStamp());

            stampedReference.compareAndSet(1,2,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t " + stampedReference.getReference() + " 版本:"+stampedReference.getStamp());

        },"t1").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedReference.compareAndSet(2,3,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t " + stampedReference.getReference() + " 版本:"+stampedReference.getStamp());

        },"t2").start();
    }
}
