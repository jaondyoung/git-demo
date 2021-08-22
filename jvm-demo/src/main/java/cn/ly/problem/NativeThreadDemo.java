package cn.ly.problem;

/**
 * 在linux才能看到错误，单个进程可以创建1024个
 * oom：unable to create new native thread
 *
 */
public class NativeThreadDemo {

    public static void main(String[] args) {
        for (int i = 0; ; i++) {

            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t被创建");
            },String.valueOf(i++)).start();

        }
    }
}
