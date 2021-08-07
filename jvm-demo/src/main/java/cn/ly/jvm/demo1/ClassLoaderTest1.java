package cn.ly.jvm.demo1;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

/**
 * 查看几种类加载器
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        // 得到系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 得到上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        // 试图获取其上层：
        ClassLoader bootClassLoader = extClassLoader.getParent();
        System.out.println(bootClassLoader);

        // 对于用户类来说：默认使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest1.class.getClassLoader();
        System.out.println(classLoader);

        // 对于String来说，默认使用boot类加载器
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

        ClassLoader classLoader2 = WebMvcAutoConfiguration.class.getClassLoader();
        System.out.println(classLoader2);
    }
}
