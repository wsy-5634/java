package com.bianyiit05.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
/**
 定义类中方法访问的路径前缀
 */
//指定哪些数据需要添加到Session中
@SessionAttributes(names = {"username"},types = String.class)
public class UserController {
    /**
     *  完成请求路径到方法之间的映射关系
     *
     *  一个模块使用一个UserController
     */
    @RequestMapping(value = "/helloWorld")
    public String helloWorld(Model model){

        System.out.println("UserController 中的helloWorld执行了");
        model.addAttribute("username","牛赛兵");

        return "hello";
    }

    @RequestMapping("/helloWorld1")
    public String helloWorld1(ModelMap map){
        Object username = map.get("username");

        System.out.println("UserController 中的helloWorld1执行了:" + username);
        return "hello";
    }

    @RequestMapping("/helloWorld2")
    public String helloWorld2(SessionStatus sessionStatus){

        sessionStatus.setComplete();//销毁session
        System.out.println("UserController 中的helloWorld1执行了:");
        return "hello";
    }

    @RequestMapping("/helloWorld3")
    public String helloWorld3(@RequestHeader("Accept") String header,
                              @CookieValue("JSESSIONID") String cookie){
        System.out.println("accept:" + header);
        System.out.println("jsessionId:" + cookie);

        System.out.println("UserController 中的helloWorld1执行了:");
        return "hello";
    }

/**
 *    /user/1
 */

    @RequestMapping("/user/{id}")
    public String helloWorld4(@PathVariable("id") String id){
        System.out.println("查询第：" + id + "个用户");
        return "hello";
    }


}
