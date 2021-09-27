package cn.ly.problem;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Test3Demo {
    public static void main(String[] args) {

        /*ArrayList<Object> objects = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now == now1);
        Stream<HashMap<Object, Object>> hashMapStream = Stream.of(new HashMap<>());*/

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(null,null);

        // 正则表达式
//        Pattern pattern = Pattern.compile("\\ba\\w*\\b");
        /*Pattern pattern = Pattern.compile("\\{{2}[\\S\\s]+\\}{2}");
//        Matcher matcher = pattern.matcher("alpha is    a someone like you alibaba ");
        Matcher matcher = pattern.matcher("Say hello to {{ name }}. He is {{ age }}.");
        while(matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }
*/
        /*Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(1.4d);

        BigDecimal bigDecimal = new BigDecimal(1.2);
        System.out.println(bigDecimal);*/

        /*String s = new StringBuilder("ja").append("va").toString();
//        String s1 = new StringBuffer("meituan").toString();
//        System.out.println(s.intern() == s); // false
        String s1 = new StringBuilder("mei").append("tuan").toString();
        System.out.println("meituan" == s1); // false
        System.out.println(s1.intern() == s1); // false
        // StringBuilder 创建的对象在堆上*/
    }

}
