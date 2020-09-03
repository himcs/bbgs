package top.himcs.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    /**
     * 用户注册
     */
    @PostMapping("/register")
    public void register() {

    }

    /**
     * 用户登陆
     */
    @PostMapping("/login")
    public void login() {

    }


    /**
     * 用户退出
     */
    @PostMapping("/logout")
    public void logout() {

    }
}
