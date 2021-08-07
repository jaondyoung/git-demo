package cn.ly.problem;

import java.util.Arrays;

public class FunDemo {
    public static void main(String[] args) {
        Arrays.asList("java","python","c#")
                .forEach((String s)->{
                    System.out.println("hello "+ s);
                });

    }

}
