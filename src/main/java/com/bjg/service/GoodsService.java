package com.bjg.service;

import com.bjg.common.JsonBean;
import com.bjg.entity.Goods;

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

    JsonBean findLike(String keyword);

    JsonBean save(Goods goods);
}
