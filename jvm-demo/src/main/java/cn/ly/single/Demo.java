package cn.ly.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
//                Singleton1.getIsntance();
                //Singleton2 instance = Singleton2.INSTANCE;
                //Singleton3.getInstance();
                Singleton5.getInstance();

            },String.valueOf(i+1)).start();
        }


     // 测试反射破坏单例
        /*Constructor<Singleton1> singleton1Constructor = Singleton1.class.getDeclaredConstructor(null);
        singleton1Constructor.setAccessible(true);
        Singleton1 o1 = singleton1Constructor.newInstance();
        Singleton1 o2 = singleton1Constructor.newInstance();

        System.out.println(o1);
        System.out.println(o2);*/


    }

}
