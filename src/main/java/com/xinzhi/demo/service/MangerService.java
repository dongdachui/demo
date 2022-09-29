package com.xinzhi.demo.service;

import com.xinzhi.demo.pojo.Brand;
import com.xinzhi.demo.pojo.Order;
import com.xinzhi.demo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Dong de
 * @version 1.0
 * @date 2022/3/23 8:54
 */
@Service
public interface MangerService {

    //查询所有
    List<Brand> selectAll();
    //根据id查询
    Brand selectById(Integer id);

    //添加
    void add(Brand brand);
//    根据id查询用户信息为一个map集合
    Map<String, Object> selectMap(Integer id);
    //查询所有 返回map集合
    List<Map<String, Object>> selectAllByMap();
    //查询所有 返回map集合命名键
    Map<String, Object> MapTokey();

    void updataById(Brand brand);

    void deleteById(Integer id);
    //多条件查询
    List<Brand> conditionQuery(Integer status, String companyName, String brandName);

    void deleteByIds(int[] ids);

    Order oderByUser(Integer id);

    User userByOder(Integer id);


    User userByrole(Integer id);
}
