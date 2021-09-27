package cn.ly.problem;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4Demo {
    public static void main(String[] args) {
        String s = "Say hello to {{ name }}. He is {{ age }}.";
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","Bill");
        map.put("age",21);
        replace(s,map);

    }

    public static String replace(String original, Map<String,Object> json){
        if(!StringUtils.isEmpty(original)){
            if(json != null){
                Pattern pattern = Pattern.compile("\\b\\{\\{\\s\\w*\\s\\}\\}\\b");
                Matcher matcher = pattern.matcher(original);
                while(matcher.find()){
                    String group = matcher.group();
                    System.out.println(group);
                }

            }
        }

        return original;
    }
}
