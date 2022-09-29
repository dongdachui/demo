package com.xinzhi.demo.Mapper;

import com.xinzhi.demo.pojo.Brand;
import com.xinzhi.demo.pojo.Order;
import com.xinzhi.demo.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BaseAttrValueMapper {

    List<Brand> selectAll();


    Brand selectById(@Param("id") Integer id);

    void add(Brand brand);

    Map<String, Object> selectMap(@Param("id")Integer id);


    List<Map<String, Object>> selectAllByMap();

    //键必须唯一
    @MapKey("id")
    Map<String, Object> MapTokey();


    Brand updataById(Brand brand);

    void deleteById(Integer id);

    List<Brand> conditionQuery(@Param("status") Integer status, @Param("companyName") String companyName ,@Param("brandName") String brandName);

    void deleteByIds(int[] ids);
    //一对一
    Order oderByUser(@Param("id")Integer id);

    User userByOder(Integer id);

    User userByrole(Integer id);
}
