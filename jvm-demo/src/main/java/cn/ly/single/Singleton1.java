package cn.ly.single;

/**
 * 饿汉式
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){
        System.out.println("Singleton1");
    }

    public static Singleton1 getIsntance(){
        return INSTANCE;
    }

    public void say(){
        System.out.println("我是饿汉式单例模式");
    }
}
