package cn.ly.gitdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static int num =1;

    @GetMapping("hello")
    public String hello(){
        System.out.println("创建分支");
        System.out.println("主干提交");
        System.out.println("分支提交");
        System.out.println("clone提交");
        return "hello git111";
    }
}
