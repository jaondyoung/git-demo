package cn.ly.problem;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.ref.SoftReference;

/**
 * 软引用
 */
public class SoftRefDemo {

    public static void memoryEnough(){
        Object a = new Object();
        SoftReference<Object> b = new SoftReference<>(a);
        System.out.println(a);
        System.out.println(b.get());

        a = null;
        System.gc();

        System.out.println(a);
        System.out.println(b.get());// 没回收

    }

    public static void memoryNoEnough(){
        Object a = new Object();
        SoftReference<Object> b = new SoftReference<>(a);
        System.out.println(a);
        System.out.println(b.get());

        a = null;
        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        }catch (Exception e){

        }finally {
            System.out.println(a);
            System.out.println(b.get());// 被回收
        }

    }

    public static void main(String[] args) {
//        memoryEnough();
        memoryNoEnough();
    }

}
