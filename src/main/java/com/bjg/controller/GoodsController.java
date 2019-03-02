package com.bjg.controller;

import com.bjg.common.JsonBean;
import com.bjg.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create with IDEA
 *
 * @ClassName GoodsController
 * @Description TODO
 * @Author TLL
 * @Date: 2019/3/1 19:17
 * @Version 1.0
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;

    @GetMapping("/selectAllGoods.do")
    public JsonBean findAllGoods(){
        return goodsService.findAllGoods();
    }

    @GetMapping("/selectByType.do")
    public JsonBean findByType(int id){
        return goodsService.findAllByType(id);
    }

    @GetMapping("/findAllLike.do")
    public JsonBean findAllLike(String msg){
        return goodsService.findLike(msg);
    }


}
