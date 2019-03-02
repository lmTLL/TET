package com.bjg.controller;

import com.bjg.common.JsonBean;
import com.bjg.entity.User;
import com.bjg.service.impl.UserServiceImpl;
import com.bjg.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 * Create with IDEA
 *
 * @ClassName UserController
 * @Description TODO
 * @Author TLL
 * @Date: 2019/2/26 10:21
 * @Version 1.0
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    JsonBean bean = null;

    @PostMapping("/login.do")
    public JsonBean login(String name, String password, HttpSession session){
        User user = null;
        try {
            user = userService.login(name,password);
            session.setAttribute("user",user);
           bean = JsonUtils.createJsonBean(1,"登录成功");
        } catch (Exception e) {
          bean = JsonUtils.createJsonBean(0,e.getMessage());

        }
        return bean;
    }

    @PostMapping("/register.do")
    public JsonBean register(User user){

        return userService.register(user);
    }

    @PostMapping("findMyInfo.do")
    public JsonBean findMyInfo(HttpSession session){
        User user = (User) session.getAttribute("user");
        String name = user.getName();

        return userService.myInfo(name);
    }
    @PostMapping("updateInfo.do")
    public JsonBean updateInfo(User user){
        return  userService.UpdateInfo(user);
}

}
