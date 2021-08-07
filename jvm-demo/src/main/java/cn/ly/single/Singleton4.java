package cn.ly.single;


/**
 *
 */
public class Singleton4 {
    static volatile Singleton4 INSTANCE =null;

    /**
     * 初始化过程，允许指令重排，调用时，可能对象没初始化完成，报错，出现一致性问题，所以必须加volatile
     * 1.分配内存
     * 2.初始化对象
     * 3.指向INSTANCE对象，此时INSTANCE !=null
     */

    private Singleton4(){
        System.out.println(Thread.currentThread().getName()+ "\t Singleton4");
    }

    public static Singleton4 getInstance(){
        if(INSTANCE == null){
            synchronized (Singleton4.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton4();
                }
            }

        }
        return INSTANCE;
    }
}
