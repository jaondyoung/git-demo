package cn.ly.problem;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 */
public class WeakRefDemo {

    public static void main(String[] args) {
        Object a = new Object();
        WeakReference<Object> b = new WeakReference<>(a);
        System.out.println(a);
        System.out.println(b.get());

        a = null;
        System.gc();
        System.out.println(a);
        System.out.println(b.get()); // 不管内存够不够，都回收

    }
}
