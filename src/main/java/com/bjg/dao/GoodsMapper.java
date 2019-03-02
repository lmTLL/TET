package com.bjg.dao;

import com.bjg.entity.Goods;
import com.bjg.vo.GoodsVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    @Select("select * from  t_type t inner join t_goods g where g.tid=t.id inner join t_user_type ut where ut.gid=g.id inner join t_user u where u.id=ut.uid")
    int finAll();

    @Select("select * from  t_goods g inner join t_type t where g.tid=t.id ")
    List<GoodsVo> findAllGoods();

    @Select("select * from  t_goods g inner join t_type t on g.tid=t.id where g.tid=#{id} ")
    List<GoodsVo> findByType(int id);

    @Select("select g.id, g.goodsname, g.picture, g.details, g.price, g.oprice, g.linkaddress, g.tradingaddress, g.tid, t.type, g.flag from  t_goods g inner join t_type t on g.tid=t.id where g.goodsname like #{msg} or t.type like #{msg} ")
    List<GoodsVo> findLike(String msg);

    List<GoodsVo> findByLike(String msg);


}