package cn.ly.problem;

import java.util.concurrent.ThreadPoolExecutor;

public class Test7Demo {
    public static void main(String[] args) {
        yy:if(4==4){
            System.out.println("前");
            xx:if(3==3){break xx;}
            System.out.println("后");
        }

        throw new RuntimeException("张总牛皮");

    }
}
