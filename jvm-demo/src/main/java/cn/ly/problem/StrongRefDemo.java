package cn.ly.problem;

public class StrongRefDemo {
    public static void main(String[] args) {
        Object a = new Object();// 强引用
        Object b = a; // 赋值
        a = null;
        System.gc();
        System.out.println(b); // 还是可达
    }
}
