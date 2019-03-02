package com.bjg.controller;

import com.bjg.common.JsonBean;
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
    private TypeServiceImpl typeService;

    @GetMapping("/selectAllType.do")
    public JsonBean selectAllTypes(){
        return typeService.findAllType();
    }
}
