package com.xinzhi.demo.service.imp;

import com.xinzhi.demo.Mapper.BaseAttrValueMapper;
import com.xinzhi.demo.pojo.Brand;
import com.xinzhi.demo.pojo.Order;
import com.xinzhi.demo.pojo.User;
import com.xinzhi.demo.service.MangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Dong de
 * @version 1.0
 * @date 2022/3/23 8:55
 */
@Service
public class MangerServiceImp implements MangerService {
    @Autowired
    private BaseAttrValueMapper  baseAttrValueMapper;


    @Override
    public List<Brand> selectAll() {
        List<Brand> brands = baseAttrValueMapper.selectAll();
        return brands;
    }

    @Override
    public Brand selectById(Integer id) {
        Brand brand = baseAttrValueMapper.selectById(id);
        return brand;
    }

    @Override
    public void add(Brand brand) {
        baseAttrValueMapper.add(brand);

        System.out.println(brand.getId());

    }

    @Override
    public Map<String, Object> selectMap(Integer id) {
        Map<String, Object>  brand=baseAttrValueMapper.selectMap(id);
        return brand;
    }

    @Override
    public List<Map<String, Object>> selectAllByMap() {
         List<Map<String,Object>> brands= baseAttrValueMapper.selectAllByMap();
        return brands;
    }

    @Override
    public Map<String, Object> MapTokey() {
        Map<String,Object> brands= baseAttrValueMapper.MapTokey();
        return brands;
    }

    @Override
    public void updataById(Brand brand) {
       baseAttrValueMapper.updataById(brand);

        }

    @Override
    public void deleteById(Integer id) {
        baseAttrValueMapper.deleteById(id);
    }

    @Override
    public List<Brand>  conditionQuery(Integer status, String companyName, String brandName) {
       List<Brand> brands= baseAttrValueMapper.conditionQuery(status,companyName,brandName);
       return brands;
    }

    @Override
    public void deleteByIds(int[] ids) {
        baseAttrValueMapper.deleteByIds(ids);
    }

    @Override
    public Order oderByUser(Integer id) {
        Order order= baseAttrValueMapper.oderByUser(id);
        return order;
    }

 @Override
    public User userByOder(Integer id) {
        User user= baseAttrValueMapper.userByOder(id);
        return user;
    }

    @Override
    public User userByrole(Integer id) {
        User user= baseAttrValueMapper.userByrole(id);
        return user;
    }

}
