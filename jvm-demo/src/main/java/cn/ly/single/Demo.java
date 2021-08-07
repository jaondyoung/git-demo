package cn.ly.single;

public class Demo {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
//                Singleton1.getIsntance();
                //Singleton2 instance = Singleton2.INSTANCE;
                //Singleton3.getInstance();
                Singleton4.getInstance();

            },String.valueOf(i+1)).start();
        }
    }
}
