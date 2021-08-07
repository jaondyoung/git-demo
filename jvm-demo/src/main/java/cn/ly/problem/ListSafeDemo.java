package cn.ly.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class ListSafeDemo {
    public static void main(String[] args) {
        Collections.synchronizedList(new ArrayList<>());
//        ConcurrentHashMap
    }
}
