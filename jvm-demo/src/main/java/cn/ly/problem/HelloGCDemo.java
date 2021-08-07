package cn.ly.problem;

import java.util.concurrent.TimeUnit;

public class HelloGCDemo {
    public static void main(String[] args) {
        System.out.println("**********helloGC");
//        byte[] bytes = new byte[50 * 1024 * 1024];

        try {
            TimeUnit.SECONDS.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
