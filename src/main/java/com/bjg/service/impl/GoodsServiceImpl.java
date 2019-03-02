package com.bjg.service.impl;

import com.bjg.common.JsonBean;
import com.bjg.dao.GoodsMapper;
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

    @Override
    public JsonBean findLike(String msg) {
        try {
            msg = "%" + msg  + "%";
            List<GoodsVo> list = goodsDao.findLike(msg);
            bean = JsonUtils.createJsonBean(1,list);
        } catch (Exception e) {
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }
}
