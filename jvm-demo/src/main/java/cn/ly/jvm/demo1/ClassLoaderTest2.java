package cn.ly.jvm.demo1;

import sun.misc.Launcher;
import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

/**
 * 验证几种类加载器的加载目录
 */
public class ClassLoaderTest2 {

    public static void main(String[] args) {
        System.out.println("*****************启动类加载器********************");
        // 获取bootstrap能够加载的api路径
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for(URL element : urls){
            System.out.println(element.toExternalForm());
        }


        // 随机取一个类来验证其类加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);

        /*System.out.println("*****************扩展类加载器********************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }*/
        // 随机取一个类来验证其类加载器
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
