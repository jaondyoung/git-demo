package cn.ly.problem;

import javax.swing.*;
import java.util.ArrayList;

/**
 * 98%的时间用来做GC，收不动垃圾，CPU占用高
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class GCOverheadDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        int i= 0;

        try {
            while(true){
                list.add(String.valueOf(++i).intern());
            }
        }catch (Throwable e){
            e.printStackTrace();
            throw  e;
        }finally {
            System.out.println(i);
        }


    }
}
