package com.bjg.service.impl;

import com.bjg.common.JsonBean;
import com.bjg.dao.UserMapper;
import com.bjg.entity.User;
import com.bjg.service.UserService;
import com.bjg.utils.JsonUtils;
import com.bjg.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

/**
 * Create with IDEA
 *
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author TLL
 * @Date: 2019/2/26 10:20
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    JsonBean bean = null;

    @Override
    public User login(String name, String password) {


        User  user = userDao.selectByName(name);
        if(user == null){
            throw new RuntimeException("用户名错误");
        }
        if(user.getFlag()==0){
            throw new RuntimeException("该用户已被禁用");
        }
        if (!user.getPassword().equals(password)){
            throw new RuntimeException("用户名密码有误");
        }


        return user;
    }

    @Override
    public JsonBean register(User user) {
        int ret = userDao.insertSelective(user);
        if (ret>0){

            bean = JsonUtils.createJsonBean(1,"注册成功");
        }else {
            bean = JsonUtils.createJsonBean(0,"注册失败");

        }
        return bean;
    }

    @Override
    public JsonBean myInfo(String name) {
        try {
            User user = userDao.selectByName(name);
            bean = JsonUtils.createJsonBean(1,user);
        } catch (Exception e) {
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }


        return bean;
    }

    @Override
    public JsonBean UpdateInfo(User user) {

        int ret = userDao.updateByPrimaryKeySelective(user);
        if (ret>0){
            bean = JsonUtils.createJsonBean(1,"修改成功");
        }else {
            bean = JsonUtils.createJsonBean(0,"修改失败");
        }

        return bean;
    }


}
