package com.xinzhi.demo.controller;

import com.xinzhi.demo.pojo.Brand;
import com.xinzhi.demo.pojo.Order;
import com.xinzhi.demo.pojo.User;
import com.xinzhi.demo.service.MangerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // @Controller + @ResponseBody 返回Json 数据 vue 获取后台数据的时候，都要是json 数据格式！
@RequestMapping("/admin/product")
@Api(description = "增删改查")
//             http://localhost:8201/swagger-ui.html#/mannager
public class Mannager {
    @Autowired
    private MangerService mangerService;
    //查询所有 返回list集合
    @RequestMapping("selectAll")
    public List<Brand> selectAll( ){
      List<Brand> brands= mangerService.selectAll();
        System.out.println(brands);
        return brands;
    }

    //查询所有 返回map集合   -------------------------
    @RequestMapping(value = "selectAllByMap",method = RequestMethod.GET)
    public List<Map<String,Object>> selectAllByMap( ){
        List<Map<String,Object>> brands= mangerService.selectAllByMap();
        System.out.println(brands);
        return brands;


    }

    //查询所有 返回map集合命名    键自定义
    @RequestMapping("selectAllByMapTokey")
    public Map<String,Object> selectAllByMapTokey(){
        Map<String,Object> brands=mangerService.MapTokey();
        System.out.println(brands);
        return brands;
        //TODO
    }

    //多条件查询   -------------------------------
    @ApiOperation(value = "多条件查询")
    @RequestMapping("conditionQuery/{status}/{companyName}/{brandName}")
    public List<Brand> conditionQuery(@PathVariable Integer status,
                               @PathVariable String companyName,
                               @PathVariable String brandName
    ){
        System.out.println("wiwi");
        List<Brand>  brands= mangerService.conditionQuery(status,companyName,brandName);
        return brands;
    }





//    根据id查询用户信息返回一条数据 以一个map集合
    @RequestMapping("selectMap/{id}")
    public Map<String,Object> selectMap(@PathVariable Integer id){
        Map<String,Object>  brand= mangerService.selectMap(id);
        return brand;
    }

    //根据id查询一条数据  以对象形式进行返回
    @RequestMapping("selectById/{id}")
    public Brand selectById(@PathVariable Integer id){
        Brand brand= mangerService.selectById(id);
        return brand;
    }

    //添加数据
    @RequestMapping("add")
    public void add(@RequestBody Brand brand){
      mangerService.add(brand);
//        System.out.println(brand.getId());
    }

    //修改
    @RequestMapping("updataById")
    public void updataById(@RequestBody Brand brand){
        mangerService.updataById(brand);
    }

    //根据id删除
    @RequestMapping("deleteById/{id}")
    public void deleteById(@PathVariable Integer id){
        mangerService.deleteById(id);
    }


    //批量删除    -------------------------  [1,2,3]
    @RequestMapping("deleteByIds")
    public void deleteByIds(@RequestBody int[] ids){
        System.out.println("666888");
        mangerService.deleteByIds(ids);
    }

    //当前订单属于哪一个用户   （一对一）   用到的表是order和user表
    //根据订单id查询用户
    @ApiOperation(value = "一对一")
    @GetMapping("oderByUser/{id}")
    public Order oderByUser(@PathVariable Integer id){
        Order order= mangerService.oderByUser(id);
        return order;
    }

    //当前用户有多少个订单   （一对多）   用到的表是order和user表
    //根据用户id查询对应的订单
    @ApiOperation(value = "一对多")
    @GetMapping("userByOder/{id}")
    public User userByOder(@PathVariable Integer id){
        User user= mangerService.userByOder(id);
        return user;
    }

     //一个用户有多个角色，一个角色可以被多个用户使用  （多对多）   用到的表是role和user表user_order
    //根据用户id查询对应的角色
    @ApiOperation(value = "多对多")
    @GetMapping("userByrole/{id}")
    public User userByrole(@PathVariable Integer id){
        User user= mangerService.userByrole(id);
        return user;
    }





}
