package cn.ly.single;

public class Singleton3 {
    private static final Singleton3 INSTANCE;
    static {
        INSTANCE = new Singleton3();
    }

    private Singleton3(){
        System.out.println("Singleton3");
    }

    public static Singleton3 getInstance(){
        return INSTANCE;
    }

    public void say(){
        System.out.println("静态代码库单例，适合复杂的操作");
    }

}
