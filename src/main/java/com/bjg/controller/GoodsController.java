package com.bjg.controller;

import com.bjg.common.JsonBean;
import com.bjg.entity.Goods;
import com.bjg.service.GoodsService;
import com.bjg.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private GoodsService goodsService;

    /**
     * 展示所有的商品
     * @return
     */
    @GetMapping("/selectAllGoods.do")
    public JsonBean findAllGoods(){
        return goodsService.findAllGoods();
    }

    /**
     * 通过商品类型展示所有的商品
     * @param id
     * @return
     */
    @GetMapping("/selectByType.do")
    public JsonBean findByType(int id){
        return goodsService.findAllByType(id);
    }

    /**
     * 通过商品的种类和名称对商品进行模糊查询并展示
     * @param keyword
     * @return
     */
    @GetMapping("/findAllLike.do")
    public JsonBean findAllLike(String keyword){
        return goodsService.findLike(keyword);
    }

    /**
     * 用户上传商品
     * @param goods
     * @return
     */
    @PostMapping("saveGoods.do")
    public JsonBean insertGoods(Goods goods){
        return goodsService.save(goods);
    }


}
