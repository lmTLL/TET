package com.bjg.controller;

import com.bjg.common.JsonBean;
import com.bjg.service.TypeService;
import com.bjg.service.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create with IDEA
 *
 * @ClassName TypeController
 * @Description TODO
 * @Author TLL
 * @Date: 2019/3/1 22:35
 * @Version 1.0
 */
@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 动态展示所有的商品类型
     * @return
     */
    @GetMapping("/selectAllType.do")
    public JsonBean selectAllTypes(){
        return typeService.findAllType();
    }
}
