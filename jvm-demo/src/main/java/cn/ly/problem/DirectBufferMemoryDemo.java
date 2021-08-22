package cn.ly.problem;

import sun.misc.VM;

/**
 *
 *-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * 直接分配物理内存，而GC不会回收这部分内存，导致Direct buffer memory
 */
import java.nio.ByteBuffer;

public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println(VM.maxDirectMemory()/(double)1024/1024 + "MB");

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
