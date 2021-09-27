package cn.ly.test;

public class TestRunnable {
    public static void main(String[] args) {
        new Thread(()->{},"ss");
    }

    class TestIner{}
}
