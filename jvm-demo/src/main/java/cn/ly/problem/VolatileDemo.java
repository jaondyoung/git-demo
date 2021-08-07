package cn.ly.problem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证volatile的可见性
 */
class MyData{
//     int num = 0;
    volatile int num = 0;//

    AtomicInteger atomicInteger = new AtomicInteger();

    public void changeNum(){
        this.num = 60;
    }
}
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);

                myData.changeNum();
                System.out.println(Thread.currentThread().getName()+"\t num的值变成60");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"aaa").start();


        while(myData.num == 0){// 不加volatile，线程AAA结束了，main线程都没有接到num被修改的通知
            // 卡住
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }
}
