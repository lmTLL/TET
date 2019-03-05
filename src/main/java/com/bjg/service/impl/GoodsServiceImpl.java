package com.bjg.service.impl;

import com.bjg.common.JsonBean;
import com.bjg.dao.GoodsMapper;
import com.bjg.entity.Goods;
import com.bjg.service.GoodsService;
import com.bjg.utils.JsonUtils;
import com.bjg.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with IDEA
 *
 * @ClassName GoodsServiceImpl
 * @Description TODO
 * @Author TLL
 * @Date: 2019/3/1 19:13
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsDao;
    JsonBean bean = null;

    //展示所有商品
    @Override
    public JsonBean findAllGoods() {
        try {
            List<GoodsVo> list = goodsDao.findAllGoods();
            bean = JsonUtils.createJsonBean(1,list);
        } catch (Exception e) {
            bean = JsonUtils.createJsonBean(0,e.getMessage());

        }
        return bean;
    }

    //通过商品类型展示商品
    @Override
    public JsonBean findAllByType(int id) {
        try {
            List<GoodsVo> list = goodsDao.findByType(id);
            bean=JsonUtils.createJsonBean(1,list);
        } catch (Exception e) {
            bean=JsonUtils.createJsonBean(0,e.getMessage());
        }

        return bean;
    }

    //通过关键字模糊查找商品
    @Override
    public JsonBean findLike(String keyword) {
        if (keyword==null || keyword.equals(' ')){
            return null;
        } else {
            keyword = "%" + keyword  + "%";
        }

        try {
            List<GoodsVo> list = goodsDao.findByLike(keyword);
            bean=JsonUtils.createJsonBean(1,list);
        } catch (Exception e) {
            bean=JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    //上传商品
    @Override
    public JsonBean save(Goods goods) {
        int ret = 0;
        ret = goodsDao.insertSelective(goods);
        if (ret>0){
            bean = JsonUtils.createJsonBean(1,"提交成功");
        }else {
            bean = JsonUtils.createJsonBean(0,"提交失败");
        }
        return bean;
    }
}
