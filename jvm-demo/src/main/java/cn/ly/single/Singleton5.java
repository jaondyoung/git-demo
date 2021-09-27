package cn.ly.single;

public class Singleton5 {
    private Singleton5(){

    }

    public static Singleton5 getInstance(){
        return Inner.INSTANCE;
    }

    private static class Inner{
        private static final Singleton5 INSTANCE = new Singleton5();
    }
}
