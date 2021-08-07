package cn.ly.single;

/**
 * 枚举 饿汉式
 */
public enum Singleton2 {
    INSTANCE;
    public void say(){
        System.out.println("我是枚举饿汉式单例模式");
    }

    private Singleton2(){
        System.out.println("Singleton2");
    }
}
