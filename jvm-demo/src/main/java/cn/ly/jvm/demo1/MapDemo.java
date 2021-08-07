package cn.ly.jvm.demo1;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.*;

public class MapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> ss = new ConcurrentHashMap<>();
        String s1 = "3";
        String s2 = "3";
        System.out.println(s1.equals(s2));
        System.out.println(LocalTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        System.out.println(Instant.now());

        String s3 = new StringBuilder("ja").append("va").toString();
        String s4 = s3.intern();
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

        String s5 = new StringBuilder("1.8.").append("0_171").toString();
        String s6 = s5.intern();
        System.out.println(s5 == s6);
        System.out.println(s5.equals(s6));
        new Thread(()->{
            System.out.println("hello thread");
        },"t1").start();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }



}
