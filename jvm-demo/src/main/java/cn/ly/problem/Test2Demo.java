package cn.ly.problem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入只含字母的一串字符，输入字符按ASCII码从小到大排序的位置，输入值大于ASCII码位置时，取最大的一个字符，
 * 相同字母取最小位置的
 * 输出指定位置ASCII码的字母在字符的位置
 * 如下：
 * // AbCdeFG
*  //3  ACFGbde
*  //5
 *
 *
 * //fAdDAkBbBq
 * //4 AABBDbdfkq
 * //6
 */
public class Test2Demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int num = scanner.nextInt();

        if(num >= 1){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            char aChar;
            if(num > chars.length){
                aChar = chars[chars.length -1];
            }else{
                aChar = chars[num - 1];
            }

            int i = s.indexOf(aChar);
            System.out.println(i);

        }

    }
}
