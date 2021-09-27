package cn.ly.problem;




import java.util.*;

/**
 * 输入一串带有字母和数字的字符串,在0~200内，忽略大小写，输出字母+字母出现的次数
 * 如下：
 *  //aa233aaaaaaaaaaaaaaaaaaa1
 * // a22132a1911
 *
 */
public class TestDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            if(s.length() <= 200 || s.length() >= 0){
                String lowStr = s.toLowerCase();
                char[] chars = lowStr.toCharArray();

                int sum = 0;
                char temp = Character.valueOf('-');
                String newStr = "";
                for (int i=0,size=chars.length;i<size;i++) {
                    if(!Character.isLetterOrDigit(chars[i])){
                        newStr = "";
                        break;
                    }else{
                        if(Character.compare(temp,chars[i]) == 0){
                            sum ++;
                        }else{
                            if(i != 0){
                                newStr += temp + "" + sum;
                            }
                            temp = chars[i];
                            sum = 1;

                        }

                        if(i == size - 1){
                            newStr += temp + "" + sum;
                        }
                    }
                }

                System.out.println(newStr);

            }

        }


    }


}
