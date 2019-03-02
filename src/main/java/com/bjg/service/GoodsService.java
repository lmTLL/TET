package com.bjg.service;

import com.bjg.common.JsonBean;

/**
 * Create with IDEA
 *
 * @ClassName GoodsService
 * @Description TODO
 * @Author TLL
 * @Date: 2019/3/1 19:12
 * @Version 1.0
 */
public interface GoodsService {

    JsonBean findAllGoods();

    JsonBean findAllByType(int id);

    JsonBean findLike(String msg);
}
