package com.bjg.controller;

import com.bjg.common.JsonBean;
import com.bjg.entity.User;
import com.bjg.service.UserService;
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
    private UserService userService;
    JsonBean bean = null;

    /**
     * 登录操作，并将登录用户信息保存到session中
     * @param name
     * @param password
     * @param session
     * @return
     */
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

    /**
     * 用户注册操作
     * @param user
     * @return
     */
    @PostMapping("/register.do")
    public JsonBean register(User user){

        return userService.register(user);
    }

    /**
     * 用户查看个人信息
     * @param session
     * @return
     */
    @PostMapping("findMyInfo.do")
    public JsonBean findMyInfo(HttpSession session){
        User user = (User) session.getAttribute("user");
        String name = user.getName();

        return userService.myInfo(name);
    }

    /**
     * 用户修改个人的信息
     * @param user
     * @return
     */
    @PostMapping("updateInfo.do")
    public JsonBean updateInfo(User user){
        return  userService.UpdateInfo(user);
}

}
