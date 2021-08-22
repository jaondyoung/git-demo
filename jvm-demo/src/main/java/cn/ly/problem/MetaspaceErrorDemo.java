package cn.ly.problem;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=10m
 *
 * 元空间也是有限的
 */
public class MetaspaceErrorDemo {
    static class OmmTest{

    }

    public static void main(String[] args) {
        int i=0;//计算多次发送异常
        try{
            while (true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OmmTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                        return methodProxy.invokeSuper(o,args);
                    }
                });

                enhancer.create();
            }
        }catch (Throwable e){
            throw  e;
        }finally {
            System.out.println(i);
        }


    }

}
