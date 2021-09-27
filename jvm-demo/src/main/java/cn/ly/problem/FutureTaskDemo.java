package cn.ly.problem;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class FutureTaskDemo {
    static AtomicInteger num = new AtomicInteger(0);
    public static void main(String[] args) {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            num.incrementAndGet();
            return num.get();
        });

        for (int i = 0; i < 5; i++) {
            new Thread(futureTask).start();
        }

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
