package cn.ly.jvm.demo1;

/**
 * 验证双亲委派机制
 */
public class ClassLoaderTest3 {
    public static void main(String[] args) {
        // 此时已自定义一个java.lang.String类,但调用的还是rt.jar里的String
        String s = new String();




    }
}

class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
