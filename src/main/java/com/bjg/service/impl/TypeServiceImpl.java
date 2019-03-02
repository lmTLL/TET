package com.bjg.service.impl;

import com.bjg.common.JsonBean;
import com.bjg.dao.TypeMapper;
import com.bjg.entity.Type;
import com.bjg.service.TypeService;
import com.bjg.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with IDEA
 *
 * @ClassName TypeServiceImpl
 * @Description TODO
 * @Author TLL
 * @Date: 2019/3/1 22:21
 * @Version 1.0
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeDao;
    JsonBean bean;

    @Override
    public JsonBean findAllType() {
        try {
            List<Type> list = typeDao.findAllType();
           bean= JsonUtils.createJsonBean(1,list);
        } catch (Exception e) {
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }
}
