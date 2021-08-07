package cn.ly.problem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 阻塞队列版的生成消费者：
 * 不需要控制同步锁
 */
class MyResouce{
    private volatile boolean FLAG = true;
    private AtomicInteger num = new AtomicInteger(0);
    private BlockingQueue<String> blockingQueue = null;

    public MyResouce(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void prod() throws InterruptedException {
        String data;
        boolean retVal;
        while(FLAG){
            data = num.incrementAndGet() + "";
            retVal = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(retVal){
                System.out.println(Thread.currentThread().getName() + "\t 生产蛋糕 "+ data +" 成功");
            }else{
                System.out.println(Thread.currentThread().getName() + "\t 生产蛋糕 "+ data +" 失败");
            }
            // 1m 生产一个
            TimeUnit.SECONDS.sleep(1);

        }

        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停，生产停止");
    }

    public void consumer() throws InterruptedException {
        String data;
        while(FLAG){
            data = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(data ==null || "".equalsIgnoreCase(data)){
                System.out.println(Thread.currentThread().getName() + "\t 出故障，获取不到蛋糕，不再接受蛋糕");
                System.out.println();
                System.out.println();
                System.out.println();
                stop();//
                return ;
            }else{
                System.out.println(Thread.currentThread().getName() + "\t 消费蛋糕 "+ data +" 成功");
            }

        }
    }

    public void stop(){
        this.FLAG = false;
    }

}

public class ProductConsumerBlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        MyResouce myResouce = new MyResouce(new ArrayBlockingQueue<String>(10));

        new Thread(()->{
            try {
                myResouce.prod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                myResouce.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();


        TimeUnit.SECONDS.sleep(5);
        myResouce.stop();

        System.out.println("5秒后，停止");
    }
}
