package cn.ly.problem;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);// 5个线程
//        ExecutorService executorService = Executors.newSingleThreadExecutor();// 1个线程
//        ExecutorService executorService = Executors.newCachedThreadPool();// N个线程
//        ExecutorService executorService = Executors.newScheduledThreadPool(5);// N个线程
        ExecutorService executorService = new ThreadPoolExecutor(2,5,1,TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());// 自定义线程池


        for (int i = 0; i < 20; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + "\t 窗口办理");
                try {
                    TimeUnit.MICROSECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();




    }

}
