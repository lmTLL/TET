package com.bjg.service;

import com.bjg.common.JsonBean;
import com.bjg.entity.User;

import javax.servlet.http.HttpSession;

/**
 * Create with IDEA
 *
 * @ClassName UserService
 * @Description TODO
 * @Author TLL
 * @Date: 2019/2/26 10:19
 * @Version 1.0
 */
public interface UserService {

    //登录
    User login(String name,String password);

    JsonBean register(User user);

    JsonBean myInfo(String name);

    JsonBean UpdateInfo(User user);








}
