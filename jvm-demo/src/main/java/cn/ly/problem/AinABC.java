package cn.ly.problem;


public class AinABC {

    public static void main(String[] args) {
        int a = 200;
        Integer a1 = new Integer(200);
        Integer a2 = new Integer(200);

        System.out.println(a == a1);// true
        System.out.println(a1 == a2);// false

    }
}
