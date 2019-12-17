package com.steve.springboot.Controller;

import com.steve.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello springboot";
    }

    // 返回success.html界面不能加 @ResponseBody
//    @ResponseBody
    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

//    @RequestMapping({"/","index.html"})
//    public String index(){
//        return "index";
//    }
}
