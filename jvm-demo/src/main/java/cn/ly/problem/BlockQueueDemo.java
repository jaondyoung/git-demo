package cn.ly.problem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueueDemo {

    public static void main(String[] args) {
        //arrayBlockQueueTest();
        BlockingQueue<String> arrayBlockingQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "\t put a");
                arrayBlockingQueue.put("a");

                System.out.println(Thread.currentThread().getName() + "\t put b");
                arrayBlockingQueue.put("b");

                System.out.println(Thread.currentThread().getName() + "\t put c");
                arrayBlockingQueue.put("c");

                System.out.println(Thread.currentThread().getName() + "\t put d");
                arrayBlockingQueue.put("d");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"AAA").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t take "+ arrayBlockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t take "+ arrayBlockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t take "+ arrayBlockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t take "+ arrayBlockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"BBB").start();

    }

    private static void arrayBlockQueueTest() {
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);

        new Thread(()->{
            try {
                arrayBlockingQueue.put("a");
                System.out.println(Thread.currentThread().getName() + "\t put a");

                arrayBlockingQueue.put("b");
                System.out.println(Thread.currentThread().getName() + "\t put b");

                arrayBlockingQueue.put("c");
                System.out.println(Thread.currentThread().getName() + "\t put c");

                arrayBlockingQueue.put("d");
                System.out.println(Thread.currentThread().getName() + "\t put d");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"AAA").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t take "+ arrayBlockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t take "+ arrayBlockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t take "+ arrayBlockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t take "+ arrayBlockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"BBB").start();
    }
}
